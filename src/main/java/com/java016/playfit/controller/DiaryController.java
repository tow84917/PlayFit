package com.java016.playfit.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.Principal;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.IntToDoubleFunction;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jca.work.WorkManagerTaskExecutor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.java016.playfit.dao.DailyRecordRepository;
import com.java016.playfit.model.DailyRecord;
import com.java016.playfit.model.FitAchieve;
import com.java016.playfit.model.Food;
import com.java016.playfit.model.Meal;
import com.java016.playfit.model.TimePeriod;
import com.java016.playfit.model.User;
import com.java016.playfit.service.DailyRecordService;
import com.java016.playfit.service.FitAchieveService;
import com.java016.playfit.service.FoodService;
import com.java016.playfit.service.MealService;
import com.java016.playfit.service.TimePeriodService;
import com.java016.playfit.service.UserService;


@Controller
public class DiaryController {
	
	
	@Autowired
	UserService userService;
	@Autowired
	DailyRecordService dailyRecordService;
	@Autowired
	FitAchieveService fitAchieveService;
	@Autowired
	TimePeriodService timePeriodService;
	@Autowired
	FoodService foodService;
	@Autowired
	MealService mealService;
	@Autowired
	DailyRecordRepository dailyRecordRepo;
	
	//修改或新增日記的表單頁面
	@RequestMapping("/diary_add_update")
	public ModelAndView diary_add_update(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		
		//登入的使用者帳號(電子信箱)
		String email = userService.getLoginUserEmail();
		//用帳號抓出此用戶的Entity
		User user = userService.findByEmail(email);

		//抓出今天的日期
		java.util.Date utilDate = new java.util.Date();
		//把日期轉成SQL型態的Date
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		//取出目前用戶今天的日常紀錄
		DailyRecord todayDailyRecord = dailyRecordService.getDailyRecordByUserAndDate(user, sqlDate);
		List<FitAchieve> fitAchieves = null;
		//如果目前用戶沒有今天的日常紀錄
		if(todayDailyRecord == null) {
			//new一個日常紀錄的物件
			todayDailyRecord = new DailyRecord();
			//擁有者設為目前用戶
			todayDailyRecord.setUser(user);
			//日期設今天
			todayDailyRecord.setCreatedDate(sqlDate);
			//狀態設為0
			todayDailyRecord.setStatus(0);
		}
		else {
			fitAchieves = fitAchieveService.getAllFitAchieveByDailyRecordAndStatus(todayDailyRecord, "按計畫執行");
		}
		System.out.println(fitAchieves);
		//此日常紀錄存在session裡面
		session.setAttribute("todayDailyRecord", todayDailyRecord);
		//取出全部的飲食時段
		List<TimePeriod> timePeriods = timePeriodService.getAllTimePeriod();
		//取出全部的食物品項
		List<Food> foods = foodService.getAllFood();
		//取出今天的日常紀錄裡的所有飲食紀錄
		List<Meal> meals = todayDailyRecord.getMeals();
		
		mv.addObject("fitAchieves",fitAchieves);
		mv.addObject("meals", meals);
		mv.addObject("foods",foods);
		mv.addObject("todayDailyRecord",todayDailyRecord);
		mv.addObject("timePeriods",timePeriods);
		mv.setViewName("addDiary_form");
		return mv;
	}
	
	@PostMapping("/processDiaryUpdate")
	public String processDiaryUpdate(@RequestParam(required=false,name="mealHidden") String[] timePeriodIdsFoodIdsForUpdate
									,@RequestParam(required=false,name="deleteMealHidden") String[]	mealIdsForDelete
									,DailyRecord todayDailyRecord,HttpSession session
									) {
		System.out.println("processDiaryUpdate開始");
		DailyRecord tempTodayDailyRecord = (DailyRecord) session.getAttribute("todayDailyRecord");
		tempTodayDailyRecord.setTitle(todayDailyRecord.getTitle());
		tempTodayDailyRecord.setContent(todayDailyRecord.getContent());
		tempTodayDailyRecord.setStatus(1);

		
		session.removeAttribute("todayDailyRecord");
		System.out.println("存成日記");
		//存成日記
		dailyRecordService.saveDailyRecord(tempTodayDailyRecord);
		System.out.println("新增或刪除用餐紀錄");
		//新增或刪除用餐紀錄
		dailyRecordService.updateDailyRecordAndMeal(tempTodayDailyRecord, timePeriodIdsFoodIdsForUpdate, mealIdsForDelete, userService.getLoginUserEmail());
		
		System.out.println("因為可能會新增或刪除用餐紀錄 所以要更新日常紀錄的卡路里");
		//因為可能會新增或刪除用餐紀錄 所以要更新日常紀錄的卡路里
		dailyRecordService.updateDailyRecordKcalIntake(tempTodayDailyRecord);
		return "redirect:/";
	}
	
	//日記的首頁
	@RequestMapping("/diary_homepage/{pageNumber}")
	public ModelAndView diary_homepage(@PathVariable("pageNumber") int currentPage) {

		ModelAndView mv = new ModelAndView();
		//登入的使用者帳號(電子信箱)
		String email = userService.getLoginUserEmail();
		//用帳號抓出此用戶的Entity
		User user = userService.findByEmail(email);

		//抓出今天的日期
		java.util.Date utilDate = new java.util.Date();
		//把日期轉成SQL型態的Date
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        //取出目前用戶今天的日常紀錄
		DailyRecord todayDailyRecord = dailyRecordService.getDailyRecordByUserAndDate(user, sqlDate);
		
		//用戶今天的日常紀錄是否已經成為日記
		boolean isDiary = dailyRecordService.isDailyRecordBecomeDairy(todayDailyRecord);

		
		//取出目前用戶全部的日常紀錄
		Page<DailyRecord> page = dailyRecordService.getAllDailyRecordByUserAndPage(user,currentPage);
		List<DailyRecord> dailyRecords = page.getContent();
		long totalItems = page.getTotalElements();
		int totalPages = page.getTotalPages();
		
		mv.addObject("currentPage", currentPage);
		mv.addObject("totalItems", totalItems);
		mv.addObject("totalPages", totalPages);
		mv.addObject("isDiary",isDiary);
		mv.addObject("dailyRecords",dailyRecords);
		mv.addObject("todayDailyRecord",todayDailyRecord);
		mv.setViewName("diary");
		return mv;
	}
	//某一天的日記頁面
	@GetMapping("/showDailyRecord/{id}")
	public ModelAndView showDailyRecord(@PathVariable(value = "id") int id, Principal principal, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		String userEmail = userService.getLoginUserEmail();
		DailyRecord dailyRecord = dailyRecordService.getDailyRecordByIdWithUserCheck(id, userEmail);
		List<Meal> todayMeals = dailyRecord.getMeals();
		List<FitAchieve> fitAchieves = fitAchieveService.getAllFitAchieveByDailyRecordAndStatus(dailyRecord, "按計畫執行");
		mv.addObject("fitAchieves",fitAchieves);
		mv.addObject("dailyRecord", dailyRecord);
		mv.addObject("todayMeals", todayMeals);
		mv.setViewName("showDailyRecord");
		return mv;
	}
	
	
	
}
