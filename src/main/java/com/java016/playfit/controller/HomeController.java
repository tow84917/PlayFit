package com.java016.playfit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.java016.playfit.model.User;
import com.java016.playfit.service.UserService;

@Controller
public class HomeController {
	
	@Autowired
	UserService userService;

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
	
	@RequestMapping("/register")
	public ModelAndView ShowRegistrationForm() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("user",new User());
		mv.setViewName("signup_form");
		return mv;
	}
	
	@PostMapping("/process_register")
	public ModelAndView processRegister(User user) {
		ModelAndView mv = new ModelAndView();
		System.out.println("controller > " + user);
		userService.saveUser(user);
		mv.setViewName("register_success");
		return mv;
	}
	
	@GetMapping("/login")
	public String login() {
		return "/login";
	}
	
	// 登入失敗處理
	@RequestMapping("/login/failure")
	public String loginFailure(
			@RequestParam(name = "errorMessage") String errorMessage, Model model 
			) {
		
		// 密碼錯誤
		if (errorMessage.equals("使用者Email/密碼無效")) {
			model.addAttribute("error", true);
		}
		
		// 尚未啟用
		if (errorMessage.equals("帳號尚未啟用")) {
			model.addAttribute("isEnabled", true);
		}
		
		return "login";
	}
	
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
