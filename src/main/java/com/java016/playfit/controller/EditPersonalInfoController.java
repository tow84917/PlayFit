package com.java016.playfit.controller;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java016.playfit.model.HealthRecord;
import com.java016.playfit.model.User;
import com.java016.playfit.service.HealthRecordService;
import com.java016.playfit.service.UserService;
import com.java016.playfit.tool.BodyCalculator;
import com.java016.playfit.tool.editUserValidator;

@Controller
public class EditPersonalInfoController {

	@Autowired
	UserService userService;
	
	@Autowired
	HealthRecordService healthRecordService;
	
	@Autowired
	BodyCalculator bodyCalculator;

	// 處理修改USER
	@PostMapping("/editMemberInfo")
	public String processEditProfile(@ModelAttribute("modifyUser") User modifyUser, 
			BindingResult result, RedirectAttributes ra) {

		// 驗證
		new editUserValidator().validate(modifyUser, result);

		// 有錯回到原頁
		if (result.hasErrors()) {
			System.out.println(modifyUser.getFullName());
			return "EditMemberInfo";
		}
		
		// 儲存User
		userService.saveUser(modifyUser);
		
		int userId = userService.getLoginUserId();
		User user = userService.getUserById(userId);
		
		// 取最近健康紀錄
		HealthRecord healthRecord = healthRecordService.findLastDateByUserId(userId);
		
		// 檢查年記是否改變(年紀影響 BMR、TDEE、BFP、FFMI)
		int originAge = healthRecord.getAge();
		int newAge = bodyCalculator.calAge(modifyUser.getBirthday()); 
		
		// 儲存或更新健康紀錄
		if (newAge != originAge) {
			healthRecordService.updateHealthRecord(user, healthRecord);
		}

		return "redirect:/MemberPage"; // redirect request

	}
	
	// 給修改USER頁面
	@GetMapping("/editUser")
	public String showEditUser(Model model) {
		model.addAttribute("currentForm","userForm");
		return "EditMemberInfo" ;
	}
	
	// 給修改 modal
	@ModelAttribute("modifyUser")
	public User giveModifyUser() {
		int userId = userService.getLoginUserId();
		User user = userService.getUserById(userId);
		System.out.println(user.getAvatar().getName());
		return user ;
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




