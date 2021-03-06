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

	// ??????????????????
	@PostMapping("/editPassword")
	public String processEditPassword(
			@RequestParam(value = "originPwd") String originPwd,
			@RequestParam(value = "newPwd") String newPwd, 
			@RequestParam(value = "confimPwd") String confimPwd,
			RedirectAttributes ra) {

		// ??????????????????
		int userId = userService.getLoginUserId();
		User user = userService.getUserById(userId);

		// ?????????????????????
		boolean originPwdOk = passwordEncoder.matches(originPwd, user.getPassword());
		if (!originPwdOk) {
			ra.addFlashAttribute("passwordError", "The original password or the confirmed password error.");
			return "redirect:/editPassword";
		}

		// ????????????7???
		if (newPwd.length() < 7) {
			ra.addFlashAttribute("passwordError", "Password size under 7.");
			return "redirect:/editPassword";
		}

		// ???????????????????????????????????????
		if (!(newPwd.equals(confimPwd))) {
			ra.addFlashAttribute("passwordError", "The original password or the confirmed password error.");
			return "redirect:/editPassword";
		}
		
		// ??????????????????
		if (originPwd.equals(newPwd)) {
			ra.addFlashAttribute("passwordError", "Same old and new password.");
			return "redirect:/editPassword";
		}

		// ????????????
		userService.updateUserPassword(userId, newPwd);

		ra.addFlashAttribute("upadtePasswordOK", "Upadte password success, login again.");
		
		// ??????????????????
		SecurityContextHolder.getContext().setAuthentication(null);
		
		// ????????????
		// <div th:if="${upadtePasswordOK} style="color: green"">
		// [[${upadtePasswordOK}]]
		// </div>

		return "redirect:/login";

	}
	
	// ??????????????????????????????????????????
	@GetMapping(value = "/getEyePic/{type}", produces = MediaType.IMAGE_PNG_VALUE)
	@ResponseBody
	public byte[] getEyePic(
			@PathVariable("type") String type) throws IOException {
		
		// ???????????????
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

	// ????????????????????????
	@PostMapping("/editHealthRecord")
	public String processEditBodyInfo(
			@RequestParam(value = "height") Double height,
			@RequestParam(value = "weight") Double weight,
			@RequestParam(value = "activityLevel") String activityLevel,
			RedirectAttributes ra
			) {

		// ???????????????
		int userId = userService.getLoginUserId();
		User user = userService.getUserById(userId);
		
		// ????????????????????????
		HealthRecord healthRecordLast = healthRecordService.findLastDateByUserId(userId);
		
		// ????????????????????? ?????????
		if (healthRecordLast.getHeight().equals(height) && // Double ??????????????????equals()
			healthRecordLast.getWeight().equals(weight) &&
			healthRecordLast.getExerciseFrequency().equals(activityLevel)
				) {
			return "redirect:/MemberPage";
		}

		// ?????????????????????
		java.util.Date utilDate = new java.util.Date();

		// ???????????????SQL?????????Date
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		// ???????????????
		HealthRecord healthRecordToday = healthRecordService.findByUserIdAndDate(userId, sqlDate);

		// ????????????????????????
		if (healthRecordToday == null) {
			// ???????????????????????????????????????
			healthRecordService.createNewRecord(healthRecordLast, user, sqlDate);
			
			// ??????????????????(????????????)
			HealthRecord healthRecordTodayNew = 
					healthRecordService.findByUserIdAndDate(userId, sqlDate);
			
			// ?????????????????????
			healthRecordTodayNew.setHeight(height);
			healthRecordTodayNew.setWeight(weight);
			healthRecordTodayNew.setExerciseFrequency(activityLevel);
			
			// ?????????????????????
			healthRecordService.updateHealthRecord(user, healthRecordTodayNew);
			ra.addFlashAttribute("updateMessage","editBodyInfoSuccess");
		}

		// ????????????????????????
		if (healthRecordToday != null) {
			// ?????????????????????
			healthRecordToday.setHeight(height);
			healthRecordToday.setWeight(weight);
			healthRecordToday.setExerciseFrequency(activityLevel);
			
			healthRecordService.updateHealthRecord(user, healthRecordToday);
			ra.addFlashAttribute("updateMessage","editBodyInfoSuccess");
		}
		
		
		return "redirect:/MemberPage";
	}

	// ????????????USER
	@PostMapping("/editUser")
	public String processEditProfile(
			@ModelAttribute("modifyUser") User modifyUser,
			BindingResult result,
			RedirectAttributes ra) {

		// ??????
		editUserValidator.validate(modifyUser, result);
		
		// ??????????????????
		if (result.hasErrors()) {
			
//			??????????????????????????????
			System.out.println("======================");
			List<ObjectError> list = result.getAllErrors();
			for(ObjectError error : list) {
				System.out.println("????????????" + error);
			}
			System.out.println("======================");
			
			System.out.println(modifyUser.getFullName());
			return "EditMemberInfo";
		}
		
		// ????????????
		User userOld = userService.getLoginUser();
//		System.out.println(userOld);
//		System.out.println(modifyUser);
		
		// ?????????????????????????????????
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
		
		// ??????User
		userService.saveUser(modifyUser);
		
		// ???????????? User
		User userUpdated = userService.getUserById(userService.getLoginUserId());

		// ??? UserDetails ??? authentication 
		CustomUserDetails customUserDetails = new CustomUserDetails(userUpdated);
					
		// Authentication ??????????????????
		Authentication authentication = 
				new UsernamePasswordAuthenticationToken
				(customUserDetails, customUserDetails.getPassword(), 
									customUserDetails.getAuthorities());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		// ????????????????????????
		HealthRecord healthRecordLast = healthRecordService.findLastDateByUserId(userUpdated.getId());

		// ????????????????????????(???????????? BMR???TDEE???BFP???FFMI)
		int originAge = healthRecordLast.getAge();
		int newAge = bodyCalculator.calAge(modifyUser.getBirthday());

		// ???????????????????????????
		if (newAge != originAge) {

			// ?????????????????????
			java.util.Date utilDate = new java.util.Date();

			// ???????????????SQL?????????Date
			java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

			// ???????????????
			HealthRecord healthRecordToday = healthRecordService.findByUserIdAndDate(userUpdated.getId(), sqlDate);

			// ????????????????????????
			if (healthRecordToday == null) {
				healthRecordService.createNewRecord(healthRecordLast, userOld, sqlDate);
			}

			// ????????????????????????
			if (healthRecordToday != null) {
				healthRecordService.updateHealthRecord(userOld, healthRecordToday);
			}

		}
		
		ra.addFlashAttribute("updateMessage","editUserSuccess");
		
		return "redirect:/MemberPage"; // redirect request

	}

	// ?????????Password??????
	@GetMapping("/editPassword")
	public String showEditPassword(Model model) {
		model.addAttribute("currentForm", "passwordForm");
		
		// ??????????????????
		LinkedList<String> eyeType = new LinkedList<String>();
		eyeType.add("open");
		eyeType.add("close");
	
		model.addAttribute("eyeType", eyeType);
		
		return "EditPassword";
	}

	// ???????????????????????????
	@GetMapping("/editHealthRecord")
	public String showEditBodyInfo(Model model) {
		model.addAttribute("currentForm", "healthRecordForm");
		
		// ???????????????????????????
		int userId = userService.getLoginUserId();
		HealthRecord healthRecordLast = healthRecordService.findLastDateByUserId(userId);
		model.addAttribute("healthRecord", healthRecordLast);
		
		return "EditBodyInfo";
	}

	// ?????????USER??????
	@GetMapping("/editUser")
	public String showEditUser(Model model) {
		model.addAttribute("currentForm", "userForm");
		return "EditMemberInfo";
	}

	// ????????? modal
	@ModelAttribute("modifyUser")
	public User giveModifyUser() {
		int userId = userService.getLoginUserId();
		User user = userService.getUserById(userId);
		return user;
	}

	// ?????? Modal
	@ModelAttribute("hrefList")
	public List<String> hrefList() {

		List<String> hrefList = new LinkedList<String>();

		hrefList.add("/editUser");
		hrefList.add("/editHealthRecord");
		hrefList.add("/editPassword");

		return hrefList;
	}

}











