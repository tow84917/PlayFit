package com.java016.playfit.controller;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java016.playfit.model.Avatar;
import com.java016.playfit.model.DailyRecord;
import com.java016.playfit.model.FitAchieve;
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
	@RequestMapping("/MemberPage") // 須同時支援GET、POST(forward:/)
	public String showMemberPage(Model model, RedirectAttributes ra,
								 HttpServletRequest request, HttpSession session) {
		session.setAttribute("userId", userService.getLoginUser());
		// 改由攔截器 檢查
//		// 確認帳號是否啟用
//		boolean isEnable = userService.isLoginUserEnable();
//		
//		// 未啟用轉認證畫面
//		if (!isEnable) {
//			return "redirect:/certificationEmail";
//		}
		
		// 目前登入者 + Id
		int userId = userService.getLoginUserId();
		User user = userService.getUserById(userId);
		model.addAttribute("user", user);

		// 會員虛擬角色
		Avatar avatar = user.getAvatar();
		model.addAttribute("avatar", avatar);

		// 會員頁日期表示法
		String today = memberService.getFormatMemberPageDate();
		model.addAttribute("today", today);

		// 抓出今天的日期
		java.util.Date utilDate = new java.util.Date();
		// 把日期轉成SQL型態的Date
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		// 取目前用戶今天的紀錄
		DailyRecord todayRecord = dailyRecordService.findByUserIdAndDate(userId, sqlDate);
		model.addAttribute("todayRecord", todayRecord);

		// 如果今天還沒有紀錄
		if (todayRecord == null) {
			model.addAttribute("activityStatus", false);
			model.addAttribute("calLost", 0);
			model.addAttribute("calGain", 0);
		} else {

			// 今日運動項目 & 完成狀態
			LinkedHashMap<FitAchieve, FitActivity> activityStatus = 
					memberService.getTodayAchieveAndActivity(todayRecord);
			model.addAttribute("activityStatus", activityStatus);
			
			// 今日消耗&攝取
			Integer kcalBurned = todayRecord.getKcalBurned();
			Integer kcalIntake = todayRecord.getKcalIntake();
			
			model.addAttribute("calLost", kcalBurned);
			
			model.addAttribute("calGain", kcalIntake);

		}

		// 取最近健康紀錄
		HealthRecord healthRecord = healthRecordService.findLastDateByUserId(userId);
		model.addAttribute("healthRecord", healthRecord);

		// 取最近目標紀錄
		PersonalGoal personalGoal = personalGoalService.findLastDateByUserId(userId);
		model.addAttribute("personalGoal", personalGoal);

		// 收到 forward:/MemberPage (edit personalGoal)
		String result = (String) request.getAttribute("result");
		if (result != null) {
			if (result.equalsIgnoreCase("error")) {
				ra.addFlashAttribute("updateResult", "error"); // Flash forward 會消失
			}
			if (result.equalsIgnoreCase("success")) {
				ra.addFlashAttribute("updateResult", "success");
			}
			return "redirect:/MemberPage";
		}

		return "MemberPage";
	}

	// 取近一周運動量
	@GetMapping(value = "/weeklyExerciseData", 
			produces = { "application/json" })
	@ResponseBody
//	@PreAuthorize("hasRole('PRIME')")
	public Map<Integer, String[]> weeklyExerciseData() {
		Map<Integer, String[]> data = null;
		int userId = userService.getLoginUserId();
		User user = userService.getUserById(userId);
		data = memberService.getWeekExerciseData(user);
		return data;
	}
	
	// 當日項目完成率
	@PostMapping(value = "/taskCompletionRate",
			consumes = { "application/json" },
			produces = { "application/json" })
	@ResponseBody
	public Map<String, Double> taskCompletionRate(@RequestBody java.util.Date date) {
		
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		
//		System.out.println(sqlDate + "---------------------------------");
		
		int userId = userService.getLoginUserId();
		DailyRecord todayRecord = dailyRecordService.findByUserIdAndDate(userId, sqlDate);
		
		Double completionRate = 0.0 ;
		
		if (todayRecord != null) {
			completionRate = memberService.getTaskCompletionRate(todayRecord);
		}
		
		Map<String, Double> map = new HashMap<>();
		map.put("completionRate", completionRate);
		
		return map;
	}

	// 修改個人目標
	@PostMapping("/editPersonGoal")
	public String editPersonGoal(
			@RequestParam("editWeight") Double newGoal, HttpServletRequest request) {

		// user id
		int userId = userService.getLoginUserId();
		User user = userService.getUserById(userId);

		// 取最近健康紀錄
		HealthRecord healthRecord = healthRecordService.findLastDateByUserId(userId);

		// 設定目標高於體重則無效
		if (newGoal >= healthRecord.getWeight()) {
			request.setAttribute("result", "error"); // 加入訊息告知會員頁
			return "forward:/MemberPage"; // forward 轉交 = POST Mehod
		}

		// 更新一天限創一個
		personalGoalService.updatePersonalGoal(newGoal, user, healthRecord);
		request.setAttribute("result", "success"); // 加入訊息告知會員頁

		return "forward:/MemberPage"; // forward 轉交 = POST Mehod
	}

	// 連結到修改表單 Modal
	@ModelAttribute("actionToEditForm")
	public String goEditForm() {

		return "editUser";
	}
}









