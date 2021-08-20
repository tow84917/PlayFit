package com.java016.playfit.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
		int userId = userService.getLoginUserId();
		User user = userService.getUserById(userId);
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
		} else {
			// 算今日項目達成率
			Double completionRate = memberService.getTaskCompletionRate(todayRecord);
			mv.addObject("completionRate", completionRate);

			// 今日運動項目 & 完成狀態
			LinkedHashMap<FitActivity, String> activityStatus = memberService.getTodayActivityAndStatus(todayRecord);
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

		return mv;
	}

	// 處理修改表單
	@PostMapping("/editProfile")
	public String processEditProfile(@Valid @ModelAttribute("editUser") User editUser, BindingResult result) {

		// 有錯回到原頁
		if (result.hasErrors()) {
			System.out.println(editUser.getFullName());
			return "EditProfile";
		}

		userService.saveUser(editUser);

		return "redirect:/MemberPage"; // redirect request

	}

	// 修改User Modal
	@ModelAttribute("editUser")
	public User giveEditUser() {
		int userId = userService.getLoginUserId();
		User editUser = userService.getUserById(userId);
		return editUser;
	}

	// 修改表單頁面
	@GetMapping("/editProfile")
	public ModelAndView editProfilePage() {

		ModelAndView mv = new ModelAndView();
		mv.setViewName("EditProfile");

		return mv;
	}

	// 修改個人目標
	@PostMapping("/editPersonGoal")
	public String editPersonGoal(@ModelAttribute("personalGoal") PersonalGoal editGoal) {
		// user id
		int userId = userService.getLoginUserId();
		User user = userService.getUserById(userId);
		// 抓出今天的日期
		java.util.Date utilDate = new java.util.Date();
		// 把日期轉成SQL型態的Date
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		PersonalGoal personalGoal = personalGoalService.findByUserIdAndDate(userId, sqlDate);
		HealthRecord healthRecord = healthRecordService.findLastDateByUserId(userId);
		
		// 每天限一個目標
		if (personalGoal == null) { // 新的
			personalGoal = new PersonalGoal();
			personalGoal.setUser(user);
			personalGoal.setStartWeight(healthRecord.getWeight());
			personalGoal.setGoalWeight(editGoal.getGoalWeight());
			personalGoal.setTotalLost(0);
			personalGoal.setCreateDate(sqlDate);
			personalGoalService.savePersonalGoal(personalGoal);
		}else if (personalGoal != null) { // 新的舊的修改
			personalGoal.setGoalWeight(editGoal.getGoalWeight());
			personalGoalService.savePersonalGoal(personalGoal);
		}
		
		return "forward:MemberPage";
	}

	// 取近期運動量
	@RequestMapping("/graphicExerciseData")
	@ResponseBody
	public Map<Integer, String[]> graphicExerciseData() {
		Map<Integer, String[]> data = null;
//		int userId = userService.getLoginUserId();

//		data = dailyRecordService.weekExerciseData(userId);
		data = memberService.getWeekExerciseData(1);
		return data;
	}
}






