package com.java016.playfit.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.batik.transcoder.TranscoderException;
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
		System.out.println("----------------");
		return mv;
	}
	
	
	
	@PostMapping(value= "/process_avatar")
		public void processAvatar(final HttpServletRequest request) throws IOException, TranscoderException {
		InputStream is = request.getInputStream();
		OutputStream os = new FileOutputStream(new File("/Users/Xuan/Downloads/test.svg"));
		
//		SVGDocument doc = new SAXSVGDocumentFactory(XMLResourceDescriptor.getXMLParserClassName())
//		.createSVGDocument("", is);
//		TranscoderInput input = new TranscoderInput(doc);
//		createAvatar.outputSvg(input, new File("/Users/Xuan/Downloads/s.svg"));
		
		
//		os.write(is.readAllBytes());
		
		byte[] b = new byte[8192];
		int len=0;
		while((len= is.read(b))!= -1) {
			os.write(b,0,len);
		}
			
		
		System.out.println(request == null);
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("errorXXX");
//		return mv;
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
	
	@RequestMapping("/register")
	 public ModelAndView ShowRegistrationForm() {
	  ModelAndView mv = new ModelAndView();
	  mv.addObject("user",new User());
	  mv.setViewName("signup_form");
	  return mv;
	 }
	
//	@GetMapping("/login")
//	public String login() {
//		return "/login_signup";
//	}
	
	// 登入失敗處理
	@RequestMapping(value = "/login/failure")
	public String loginFailure(
			@RequestParam(name = "errorMessage") String errorMessage, Model model 
			) {
		
		System.out.println(errorMessage);
		
		// 帳號錯誤
		if (errorMessage.equals("rgrdsgdfhgnot found")) {
			model.addAttribute("error", true);
		}
		
		// 密碼錯誤
		if (errorMessage.equals("Bad credentials")) {
			model.addAttribute("error", true);
		}
		
		// 尚未啟用
		if (errorMessage.equals("Disabled")) {
			model.addAttribute("isEnabled", true);
		}
		
		return "redirect:/login";
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
