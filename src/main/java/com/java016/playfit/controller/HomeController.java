package com.java016.playfit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.java016.playfit.dao.UserRepository;
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
		
		
		List<User> listUser = userService.getAllUsers();
	
		mv.addObject("objs",listUser);
		mv.setViewName("home");
		return mv;
	}
	
	@RequestMapping("index")
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
		userService.saveUser(user);
		mv.setViewName("register_success");
		return mv;
	}
	
	
	@GetMapping("/login")
	public String login() {
		return "/login";
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
		List<User> listUser = userService.getAllUsers();
		
		mv.addObject("objs",listUser);
		mv.setViewName("home");
		return mv;
	}
}
