package com.java016.playfit.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.java016.playfit.model.Avatar;
import com.java016.playfit.model.BodyType;
import com.java016.playfit.model.HealthRecord;
import com.java016.playfit.model.PersonalGoal;
import com.java016.playfit.model.User;
import com.java016.playfit.service.AvatarService;
import com.java016.playfit.service.BodyTypeService;
import com.java016.playfit.service.HealthRecordService;
import com.java016.playfit.service.PersonalGoalService;
import com.java016.playfit.service.UserService;
import com.java016.playfit.tool.BodyCalculator;

@Controller
@SessionAttributes("newMember")
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@Autowired
    HealthRecordService healthRecordService;
	
	@Autowired
	PersonalGoalService personalGoalService;
	
	@Autowired
	AvatarService avatarService;
	
	@Autowired
	BodyTypeService bodyTypeService;
	
	@Autowired
	BodyCalculator bodyCalculator;
	
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	
//	@RequestMapping("/users")
//	@ResponseBody
//	public ModelAndView Users() {
//		ModelAndView mv = new ModelAndView();
//		List<User> listUser = userService.findAll();
//	
//		mv.addObject("objs",listUser);
//		mv.setViewName("home");
//		return mv;
//	}
	
	// 首頁(舊的預設首頁)
	@RequestMapping("/")
	public ModelAndView index() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
	
	// 首頁(新的正式)
	@RequestMapping("/index")
	public ModelAndView index2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/index/indexOffical");
		return mv;
	}
	
	// 計算機頁面
	@RequestMapping("/calculator")
	public ModelAndView calculator() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("calculator");
		return mv;
	}
	
	// 給認證信網頁
	@GetMapping("/certificationEmail")
	public ModelAndView certificationEmail() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("certificationEmail");
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView login_signup() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("personalGoal",new PersonalGoal());
		mv.addObject("healthRecord", new HealthRecord());
		mv.addObject("user",new User());
		mv.setViewName("login_signup");
//		System.out.println("----------------");
		return mv;
	}
	
	// 處理虛擬角色
	@PostMapping(value= "/process_avatar")
	@ResponseBody
	public String processAvatar(final HttpServletRequest request) 
			throws IOException {
		
		// 確認新 user 已存存
		boolean isTempNewMember= false ;
		
		// 等待 /process_register 處理完畢
		while (!isTempNewMember) {
			if (request.getSession().getAttribute("newMember") != null) {
				isTempNewMember = true ;
			}
		}
		
		// 新會員已儲存
		User newMember = userService.findByEmail(
				((User)request.getSession().getAttribute("newMember")).getEmail());
		
		// 命名 & 路徑(系統檔案內 refresh)
		String avatarFileName ="Avatar_" + newMember.getId()+ ".svg";
		String path = "src/main/resources/static/images/Avatar/"; 
		
		// 輸出到系統內 Avatar Folder
		InputStream is = request.getInputStream();
		OutputStream os = 
				new FileOutputStream(new File(path + avatarFileName));
		
		byte[] b = new byte[8192];
		int len=0;
		while((len= is.read(b))!= -1) {
			os.write(b,0,len);
		}
		
		// 新Avatar
		Avatar avatar = new Avatar();
		avatar.setImagePath("./images/Avatar/" + avatarFileName);
		
		// 儲存 Avatar
		avatar.setName(newMember.getFullName());
		avatarService.saveAvatar(avatar);
		
		// 把 Avatar 給 newMember
		newMember.setAvatar(avatar);
		// 更新User Avatar
		userService.saveUser(newMember);
		
		return "OK";
	}
			
	@PostMapping("/process_register")
	public ModelAndView processRegister(User user, 
			PersonalGoal personalGoal, HealthRecord healthRecord, Model model) {
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("register_success");
		
		// 今天的日期
		java.util.Date utilDate = new java.util.Date();
		// 把日期轉成SQL型態的Date
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		System.out.println("controller > " + user);
		System.out.println("controller > " + healthRecord);
		System.out.println("controller > " + personalGoal);
		
		// 儲存 User
		user.setCertificationStatus(0);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		userService.saveUser(user);
		
		// 儲存健康紀錄
		healthRecord.setUser(user);
		healthRecord.setDate(sqlDate);
		healthRecord.setCalorieDeficit(0.0);
		healthRecord = bodyCalculator.calAll(healthRecord, user);
		healthRecordService.saveHealthRecord(healthRecord);
		
		// 儲存個人目標
		personalGoal.setUser(user);
		personalGoal.setCreateDate(sqlDate);
		personalGoal.setStartWeight(healthRecord.getWeight());
		personalGoal.setTotalLost(0);
		personalGoalService.savePersonalGoal(personalGoal);
		
		// 儲存新USER 進 Session
		User newMember = userService.findByEmail(user.getEmail());
		model.addAttribute("newMember",newMember) ;
		
		return mv;
	}
	
//	@RequestMapping("/register")
//	 public ModelAndView ShowRegistrationForm() {
//	  ModelAndView mv = new ModelAndView();
//	  mv.addObject("user",new User());
//	  mv.setViewName("signup_form");
//	  return mv;
//	 }
	
	// 登入失敗處理
	@RequestMapping(value = "/login/failure")
	public String loginFailure(
			@RequestParam(name = "errorMessage") String errorMessage, 
			Model model 
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
	
	// 體型、顏色、衣服、帽子 (前端要送) 新方式後端產圖 順便存取配件 Id
	@RequestMapping("/createAvatar")
	@ResponseBody
	public String createAvatar() {
		
		// 找體型
		BodyType bodyType = bodyTypeService.findByName("OVERWEIGHT");
		
		// 體型、顏色、衣服、帽子
		avatarService.saveAvatarPic(
				bodyType, "lightpurple", "Camera", "Fishermenhat", "Avatar_999");

		//		avatarService.saveAvatarPic(
//				bodyType, "lightpurple", "Camera", null, "Avatar_999");
		
		return "OK" ;
	}
	
//	@GetMapping("/showFormForUpdate/{id}")
//	public String showFormForUpdate(@PathVariable(value = "id") int id, Model model) {
//		
//		User user = userService.getUserById(id);
//		model.addAttribute("user",user);
//		return "update_user";
//	}
//	
//	@PostMapping("/processUserUpdate")
//	public ModelAndView processUserUpdate(User user) {
//		ModelAndView mv = new ModelAndView();
//		userService.updateUserName(user.getId(), user.getFullName());
//		List<User> listUser = userService.findAll();
//		
//		mv.addObject("objs",listUser);
//		mv.setViewName("home");
//		return mv;
//	}
}
