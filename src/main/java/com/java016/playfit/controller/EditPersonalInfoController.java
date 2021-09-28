package com.java016.playfit.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java016.playfit.model.HealthRecord;
import com.java016.playfit.model.User;
import com.java016.playfit.security.CustomUserDetails;
import com.java016.playfit.service.HealthRecordService;
import com.java016.playfit.service.UserService;
import com.java016.playfit.tool.BodyCalculator;
import com.java016.playfit.tool.EditUserValidator;

@Controller
public class EditPersonalInfoController {

	UserService userService;

	HealthRecordService healthRecordService;

	BodyCalculator bodyCalculator;

	BCryptPasswordEncoder passwordEncoder;
	
	EditUserValidator editUserValidator;
	
	@Autowired
	public EditPersonalInfoController(UserService userService, HealthRecordService healthRecordService,
			BodyCalculator bodyCalculator, BCryptPasswordEncoder passwordEncoder, EditUserValidator editUserValidator) {
		this.userService = userService;
		this.healthRecordService = healthRecordService;
		this.bodyCalculator = bodyCalculator;
		this.passwordEncoder = passwordEncoder;
		this.editUserValidator = editUserValidator;
	}

	// 處理修改密碼
	@PostMapping("/editPassword")
	public String processEditPassword(
			@RequestParam(value = "originPwd") String originPwd,
			@RequestParam(value = "newPwd") String newPwd, 
			@RequestParam(value = "confimPwd") String confimPwd,
			RedirectAttributes ra) {

		// 取現在登入者
		int userId = userService.getLoginUserId();
		User user = userService.getUserById(userId);

		// 與原始密碼不符
		boolean originPwdOk = passwordEncoder.matches(originPwd, user.getPassword());
		if (!originPwdOk) {
			ra.addFlashAttribute("passwordError", "The original password or the confirmed password error.");
			return "redirect:/editPassword";
		}

		// 密碼最少7位
		if (newPwd.length() < 7) {
			ra.addFlashAttribute("passwordError", "Password size under 7.");
			return "redirect:/editPassword";
		}

		// 輸入密碼與再次確認密碼不符
		if (!(newPwd.equals(confimPwd))) {
			ra.addFlashAttribute("passwordError", "The original password or the confirmed password error.");
			return "redirect:/editPassword";
		}
		
		// 新舊密碼相同
		if (originPwd.equals(newPwd)) {
			ra.addFlashAttribute("passwordError", "Same old and new password.");
			return "redirect:/editPassword";
		}

		// 更新密碼
		userService.updateUserPassword(userId, newPwd);

		ra.addFlashAttribute("upadtePasswordOK", "Upadte password success, login again.");
		
		// 改密碼完登出
		SecurityContextHolder.getContext().setAuthentication(null);
		
		// 前端字樣
		// <div th:if="${upadtePasswordOK} style="color: green"">
		// [[${upadtePasswordOK}]]
		// </div>

		return "redirect:/login";

	}
	
	// 給修改前端密碼頁眼睛圖示切換
	@GetMapping(value = "/getEyePic/{type}", produces = MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public byte[] getEyePic(
			@PathVariable("type") String type) throws IOException {
		
		// 檔名、路徑
		String fileNameOpen = "eye.png";
		String fileNameClose = "eyeclosed.png";
		String path = "static/editProfileForm/img/"; 
		
		System.out.println(type);
		
		InputStream is = null ;
		
		// ClassPathResource = start from src/main/resources
		if (type.equals("open")) {
			is = new ClassPathResource(path + fileNameOpen).getInputStream();			
		}
		
		if (type.equals("close")) {
			is = new ClassPathResource(path + fileNameClose).getInputStream();			
		}
		
		return is.readAllBytes();
	}

	// 處裡修改身體資訊
	@PostMapping("/editHealthRecord")
	public String processEditBodyInfo(
			@RequestParam(value = "height") Double height,
			@RequestParam(value = "weight") Double weight,
			@RequestParam(value = "activityLevel") String activityLevel,
			RedirectAttributes ra
			) {

		// 現在登入者
		int userId = userService.getLoginUserId();
		User user = userService.getUserById(userId);
		
		// 取最近期健康紀錄
		HealthRecord healthRecordLast = healthRecordService.findLastDateByUserId(userId);
		
		// 與之前紀錄相同 不更新
		if (healthRecordLast.getHeight().equals(height) && // Double 物件型態要用equals()
			healthRecordLast.getWeight().equals(weight) &&
			healthRecordLast.getExerciseFrequency().equals(activityLevel)
				) {
			return "redirect:/MemberPage";
		}

		// 抓出今天的日期
		java.util.Date utilDate = new java.util.Date();

		// 把日期轉成SQL型態的Date
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		// 取今日紀錄
		HealthRecord healthRecordToday = healthRecordService.findByUserIdAndDate(userId, sqlDate);

		// 無今日紀錄則創建
		if (healthRecordToday == null) {
			// 建新紀錄欄位先繼承上次最新
			healthRecordService.createNewRecord(healthRecordLast, user, sqlDate);
			
			// 再取今日紀錄(剛創好的)
			HealthRecord healthRecordTodayNew = 
					healthRecordService.findByUserIdAndDate(userId, sqlDate);
			
			// 設定值在新建的
			healthRecordTodayNew.setHeight(height);
			healthRecordTodayNew.setWeight(weight);
			healthRecordTodayNew.setExerciseFrequency(activityLevel);
			
			// 更新會重新計算
			healthRecordService.updateHealthRecord(user, healthRecordTodayNew);
			ra.addFlashAttribute("updateMessage","editBodyInfoSuccess");
		}

		// 有今日紀錄則更新
		if (healthRecordToday != null) {
			// 設定值在舊有的
			healthRecordToday.setHeight(height);
			healthRecordToday.setWeight(weight);
			healthRecordToday.setExerciseFrequency(activityLevel);
			
			healthRecordService.updateHealthRecord(user, healthRecordToday);
			ra.addFlashAttribute("updateMessage","editBodyInfoSuccess");
		}
		
		
		return "redirect:/MemberPage";
	}

	// 處理修改USER
	@PostMapping("/editUser")
	public String processEditProfile(
			@ModelAttribute("modifyUser") User modifyUser,
			BindingResult result,
			RedirectAttributes ra) {

		// 驗證
		editUserValidator.validate(modifyUser, result);
		
		// 有錯回到原頁
		if (result.hasErrors()) {
			
//			觀察是否有格式錯誤用
			System.out.println("======================");
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError error : list) {
				System.out.println("有錯誤：" + error);
			}
			System.out.println("======================");
			
			System.out.println(modifyUser.getFullName());
			return "EditMemberInfo";
		}
		
		// 舊的資料
		User userOld = userService.getLoginUser();
//		System.out.println(userOld);
//		System.out.println(modifyUser);
		
		// 新舊資料相同不顯示更新
		if (
			modifyUser.getFullName().equals(userOld.getFullName()) &&
			modifyUser.getNickName().equals(userOld.getNickName()) &&	
			modifyUser.getPhone().equals(userOld.getPhone()) 		&&
			modifyUser.getEmail().equals(userOld.getEmail()) 		&&
			modifyUser.getAddress().equals(userOld.getAddress()) 	&&
			modifyUser.getGender().equals(userOld.getGender()) 	&&
			modifyUser.getBirthday().equals(userOld.getBirthday()) 
			) {
				return "redirect:/MemberPage";
			}
		
		// 儲存User
		userService.saveUser(modifyUser);
		
		// 更新後的 User
		User userUpdated = userService.getUserById(userService.getLoginUserId());

		// 新 UserDetails 給 authentication 
		CustomUserDetails customUserDetails = new CustomUserDetails(userUpdated);
					
		// Authentication 更新為新資料
		Authentication authentication = 
				new UsernamePasswordAuthenticationToken
				(customUserDetails, customUserDetails.getPassword(), 
									customUserDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		// 取最近期健康紀錄
		HealthRecord healthRecordLast = healthRecordService.findLastDateByUserId(userUpdated.getId());

		// 檢查年紀是否改變(年紀影響 BMR、TDEE、BFP、FFMI)
		int originAge = healthRecordLast.getAge();
		int newAge = bodyCalculator.calAge(modifyUser.getBirthday());

		// 儲存或更新健康紀錄
		if (newAge != originAge) {

			// 抓出今天的日期
			java.util.Date utilDate = new java.util.Date();

			// 把日期轉成SQL型態的Date
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

			// 取今日紀錄
			HealthRecord healthRecordToday = healthRecordService.findByUserIdAndDate(userUpdated.getId(), sqlDate);

			// 無今日紀錄則創建
			if (healthRecordToday == null) {
				healthRecordService.createNewRecord(healthRecordLast, userOld, sqlDate);
			}

			// 有今日紀錄則更新
			if (healthRecordToday != null) {
				healthRecordService.updateHealthRecord(userOld, healthRecordToday);
			}

		}
		
		ra.addFlashAttribute("updateMessage","editUserSuccess");
		
		return "redirect:/MemberPage"; // redirect request

	}

	// 給修改Password頁面
	@GetMapping("/editPassword")
	public String showEditPassword(Model model) {
		model.addAttribute("currentForm", "passwordForm");
		
		// 給眼睛的狀態
		LinkedList<String> eyeType = new LinkedList<String>();
		eyeType.add("open");
		eyeType.add("close");
	
		model.addAttribute("eyeType", eyeType);
		
		return "EditPassword";
	}

	// 給修改身體資訊頁面
	@GetMapping("/editHealthRecord")
	public String showEditBodyInfo(Model model) {
		model.addAttribute("currentForm", "healthRecordForm");
		
		// 給默認上次紀錄的值
		int userId = userService.getLoginUserId();
		HealthRecord healthRecordLast = healthRecordService.findLastDateByUserId(userId);
		model.addAttribute("healthRecord", healthRecordLast);
		
		return "EditBodyInfo";
	}

	// 給修改USER頁面
	@GetMapping("/editUser")
	public String showEditUser(Model model) {
		model.addAttribute("currentForm", "userForm");
		return "EditMemberInfo";
	}

	// 給修改 modal
	@ModelAttribute("modifyUser")
	public User giveModifyUser() {
		int userId = userService.getLoginUserId();
		User user = userService.getUserById(userId);
		return user;
	}

	// 連結 Modal
	@ModelAttribute("hrefList")
	public List<String> hrefList() {

		List<String> hrefList = new LinkedList<String>();

		hrefList.add("/editUser");
		hrefList.add("/editHealthRecord");
		hrefList.add("/editPassword");

		return hrefList;
	}

}











