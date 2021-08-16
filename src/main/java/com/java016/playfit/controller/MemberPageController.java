package com.java016.playfit.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.java016.playfit.model.Avatar;
import com.java016.playfit.model.DailyRecord;
import com.java016.playfit.model.FitActivity;
import com.java016.playfit.model.HealthRecord;
import com.java016.playfit.model.PersonalGoal;
import com.java016.playfit.model.User;
import com.java016.playfit.service.DailyRecordService;
import com.java016.playfit.service.HealthRecordService;
import com.java016.playfit.service.MemberService;
import com.java016.playfit.service.PersonalGoalService;
import com.java016.playfit.service.UserService;

@Controller
public class MemberPageController {
	
	
	MemberService memberService;
	
	UserService userService;
	
	HealthRecordService healthRecordService;
	
	PersonalGoalService personalGoalService;
	
	DailyRecordService dailyRecordService;
	
	@Autowired
	public MemberPageController(UserService userService, HealthRecordService healthRecordService,
			PersonalGoalService personalGoalService, DailyRecordService dailyRecordService,
			MemberService memberService) {
		this.userService = userService;
		this.healthRecordService = healthRecordService;
		this.personalGoalService = personalGoalService;
		this.dailyRecordService = dailyRecordService;
		this.memberService = memberService;
	}

	// 會員頁面
	@RequestMapping("/MemberPage")
	public ModelAndView showMemberPage() {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("MemberPage");
		
		// 目前登入者 + Id
		User user = userService.getLoginUser();
		int userId = user.getId();	
		mv.addObject("user", user);
		
		// 會員虛擬角色
		Avatar avatar = user.getAvatar();
		mv.addObject("avatar", avatar);

		// 會員頁日期表示法
		String today = memberService.getFormatMemberPageDate();
		mv.addObject("today", today);
		
		// 抓出今天的日期
		java.util.Date utilDate = new java.util.Date();
		// 把日期轉成SQL型態的Date
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		// 取目前用戶今天的紀錄
		DailyRecord todayRecord = dailyRecordService.findByUserIdAndDate(userId, sqlDate);
		mv.addObject("todayRecord", todayRecord);
		
		// 如果今天還沒有紀錄
		if (todayRecord == null) {
			mv.addObject("completionRate", 0);
			mv.addObject("activityStatus", false);
			mv.addObject("calLost", 0);
			mv.addObject("calGain", 0);
		}else {
			// 算今日項目達成率
			Double completionRate = memberService.taskCompletionRate(todayRecord);
			mv.addObject("completionRate", completionRate);
			
			// 今日運動項目 & 完成狀態
			LinkedHashMap<FitActivity, String> activityStatus = 
					memberService.getTodayActivityAndStatus(todayRecord);		
			mv.addObject("activityStatus", activityStatus);	
			
			// 今日消耗
			mv.addObject("calLost", todayRecord.getKcalBurned());
			mv.addObject("calGain", todayRecord.getKcalIntake());
			
		}
		
		// 取最近健康紀錄
		HealthRecord healthRecord = healthRecordService.findLastDateByUserId(userId);
		mv.addObject("healthRecord", healthRecord);
		
		// 取最近目標紀錄
		PersonalGoal personalGoal = personalGoalService.findLastDateByUserId(userId);
		mv.addObject("personalGoal", personalGoal);
		
		// 給修改資料用
		User editUser = new User(); 
		mv.addObject("editUser", editUser);

		return mv;
	}
	
	// 未完成 修改表單會改另一頁
	@RequestMapping(value = "/editProfile", method = RequestMethod.POST)
	public ModelAndView editProfile(@ModelAttribute("editUser") User user){
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("testPost");
		
		System.out.println(user.getFullName());
		
		return mv;
		
	}

	// 取近期運動量
	@RequestMapping("/graphicExerciseData")
	@ResponseBody
	public Map<Integer, String[]> graphicExerciseData() {
		Map<Integer, String[]> data = null;
//		int userId = userService.getLoginUserId();

//		data = dailyRecordService.weekExerciseData(userId);
		data = memberService.weekExerciseData(1);
		return data;
	}
}















