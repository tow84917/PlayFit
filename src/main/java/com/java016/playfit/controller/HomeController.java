package com.java016.playfit.controller;

//import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.java016.playfit.model.HealthRecord;
import com.java016.playfit.model.PersonalGoal;
import com.java016.playfit.model.User;
import com.java016.playfit.service.HealthRecordService;
import com.java016.playfit.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@Autowired
    HealthRecordService healthRecordService;
	

	@RequestMapping("/users")
	@ResponseBody
	public ModelAndView Users() {
		ModelAndView mv = new ModelAndView();
		List<User> listUser = userService.findAll();
	
		mv.addObject("objs",listUser);
		mv.setViewName("home");
		return mv;
	}
	
	// 首頁
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView login_signup() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("personalGoal",new PersonalGoal());
		mv.addObject("healthRecord", new HealthRecord());
		mv.addObject("user",new User());
		mv.setViewName("login_signup");
		return mv;
	}
	
	@PostMapping("/process_register")
	public ModelAndView processRegister(User user, PersonalGoal personalGoal,HealthRecord healthRecord) {
		ModelAndView mv = new ModelAndView();
		System.out.println("controller > " + user);
		user.setCertificationStatus(0);
		user.setGender("Male");
		userService.saveUser(user);
		personalGoal.setUser(user);
		healthRecord.setUser(user);
		System.out.println("controller > " + personalGoal);
		System.out.println("controller > " + healthRecord);
				
		

//		healthRecordService.saveHealthRecord(HealthRecord);
		mv.setViewName("register_success");
		return mv;
	}
	
//	@GetMapping("/login")
//	public String login() {
//		return "/login_signup";
//	}
	
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
		
		User user = userService.getUserById(id);
		model.addAttribute("user",user);
		return "update_user";
	}
	
	@PostMapping("/processUserUpdate")
	public ModelAndView processUserUpdate(User user) {
		ModelAndView mv = new ModelAndView();
		userService.updateUserName(user.getId(), user.getFullName());
		List<User> listUser = userService.findAll();
		
		mv.addObject("objs",listUser);
		mv.setViewName("home");
		return mv;
	}
}
