package com.java016.playfit.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java016.playfit.model.Avatar;
import com.java016.playfit.model.AvatarBody;
import com.java016.playfit.model.AvatarClothes;
import com.java016.playfit.model.AvatarHat;
import com.java016.playfit.model.BodyType;
import com.java016.playfit.model.HealthRecord;
import com.java016.playfit.model.PersonalGoal;
import com.java016.playfit.model.User;
import com.java016.playfit.security.CustomUserDetails;
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
	
//	// 首頁(舊的預設首頁)
//	@RequestMapping("/")
//	public ModelAndView index() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("index");
//		return mv;
//	}
	
	// 首頁(新的正式)
	@RequestMapping(value = {"/index", "/"})
	public ModelAndView index2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/index/indexOffical");
		return mv;
	}
	
	// 關於我們
	@RequestMapping("/aboutUs")
	public ModelAndView aboutUs() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/aboutUs/aboutUs");
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
	
	// 給登入註冊頁
	@RequestMapping("/login")
	public String login_signup( 
			Model model, RedirectAttributes ra, HttpServletRequest request,
			@RequestParam(required = false, name = "logout") String rp,
			@RequestParam(required = false, name = "resetPassword") boolean resetPassword) {
		
		// 給註冊 model
		model.addAttribute("personalGoal",new PersonalGoal());
		model.addAttribute("healthRecord", new HealthRecord());
		model.addAttribute("user",new User());
		
		// 取是否有錯誤訊息
		Object isError = request.getAttribute("error");
//		System.out.println(rp);
		
		// 登入錯誤訊息
		if(isError != null) {
			if((boolean)isError) {
				ra.addFlashAttribute("error", true);
				return "redirect:/login";
			}
		}
		
		// 登出訊息
		if(rp != null ) {
			ra.addFlashAttribute("logout", true);
			return "redirect:/login";		
		}	
		
		// 忘記密碼重置
		if (resetPassword) {
			ra.addFlashAttribute("upadtePasswordOK", true);
			return "redirect:/login";
		}
		
		return "login";
	}
	
	// 處理虛擬角色
	@PostMapping(value= "/process_avatar")
	@ResponseBody
	public String processAvatar(
			@RequestBody Map<String, String> avatarInfo,  
			final HttpServletRequest request) 
			throws IOException {
		
		// 確認新 user 已存存
		boolean isTempNewMember= false ;
				
		// 等待 /process_register 處理完畢
		while (!isTempNewMember) {
			if (request.getSession().getAttribute("newMember") != null) {
				isTempNewMember = true ;
			}
		}
				
		User newStoredMember = userService.findByEmail(
			((User)request.getSession().getAttribute("newMember")).getEmail());
		
		// 前端傳 Avatar 各部件資訊
		String avatarSize = avatarInfo.get("avatarSize");
		String colorInfo = avatarInfo.get("colorInfo");
		String hatInfo = avatarInfo.get("hatInfo");
		String clothesInfo = avatarInfo.get("clothesInfo");
				
		// 命名 & 路徑(系統檔案內 refresh)
		String avatarFileName ="Avatar_" + newStoredMember.getId();
				
		// 找體型
		BodyType bodyType = bodyTypeService.findByName(avatarSize);
		
		// 產生圖片
		avatarService.saveAvatarPic(
			bodyType, colorInfo, clothesInfo, hatInfo, avatarFileName);
				
		// 找體型、顏色、衣服、帽子
		AvatarBody avatarBody = avatarService.getAvatarBody(colorInfo, bodyType);
		AvatarClothes avatarClothes = avatarService.getAvatarClothes(bodyType, clothesInfo);
		AvatarHat avatarHat = avatarService.getAvatarHat(bodyType, hatInfo);
				
		// 新Avatar
		Avatar avatar = new Avatar();
		
		// 路徑
		avatar.setImagePath("/images/Avatar/" + avatarFileName + ".svg");
		
		// Set Avatar 部件
		avatar.setAvatarBody(avatarBody);
		avatar.setAvatarClothes(avatarClothes);
		avatar.setAvatarHat(avatarHat);
				
		// 儲存 Avatar
		avatar.setName(newStoredMember.getFullName());
		avatarService.saveAvatar(avatar);
				
		// 把 Avatar 給 newMember
		newStoredMember.setAvatar(avatar);
		// 更新User Avatar
		userService.saveUser(newStoredMember);
				
		return "OK";
	}
	
	
	// 處理虛擬角色
//	@PostMapping(value= "/process_avatar")
//	@ResponseBody
//	public String processAvatar(final HttpServletRequest request) 
//			throws IOException {
//		
//		// 確認新 user 已存存
//		boolean isTempNewMember= false ;
//		
//		// 等待 /process_register 處理完畢
//		while (!isTempNewMember) {
//			if (request.getSession().getAttribute("newMember") != null) {
//				isTempNewMember = true ;
//			}
//		}
//		
//		// 新會員已儲存
//		User newMember = userService.findByEmail(
//				((User)request.getSession().getAttribute("newMember")).getEmail());
//		
//		// 命名 & 路徑(系統檔案內 refresh)
//		String avatarFileName ="Avatar_" + newMember.getId()+ ".svg";
//		String path = "src/main/resources/static/images/Avatar/"; 
//		
//		// 輸出到系統內 Avatar Folder
//		InputStream is = request.getInputStream();
//		OutputStream os = 
//				new FileOutputStream(new File(path + avatarFileName));
//		
//		byte[] b = new byte[8192];
//		int len=0;
//		while((len= is.read(b))!= -1) {
//			os.write(b,0,len);
//		}
//		
//		// 新Avatar
//		Avatar avatar = new Avatar();
//		avatar.setImagePath("./images/Avatar/" + avatarFileName);
//		
//		// 儲存 Avatar
//		avatar.setName(newMember.getFullName());
//		avatarService.saveAvatar(avatar);
//		
//		// 把 Avatar 給 newMember
//		newMember.setAvatar(avatar);
//		// 更新User Avatar
//		userService.saveUser(newMember);
//		
//		return "OK";
//	}
	
	// 註冊處裡
	@PostMapping("/process_register")
	public String processRegister(User user, 
			PersonalGoal personalGoal, HealthRecord healthRecord, Model model) {
		
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
		
		// 儲存後在資料庫的User
		User newMember = userService.findByEmail(user.getEmail());
		
		// 儲存健康紀錄
		healthRecord.setUser(newMember);
		healthRecord.setDate(sqlDate);
		healthRecord.setCalorieDeficit(0.0);
		healthRecord = bodyCalculator.calAll(healthRecord, user);
		healthRecordService.saveHealthRecord(healthRecord);
		
		// 儲存個人目標
		personalGoal.setUser(newMember);
		personalGoal.setCreateDate(sqlDate);
		personalGoal.setStartWeight(healthRecord.getWeight());
		personalGoal.setTotalLost(0);
		personalGoalService.savePersonalGoal(personalGoal);
		
		// 儲存新USER 進 Session
		model.addAttribute("newMember",newMember) ;
		
		// 給Security 登入資訊,未驗證(redirect:/MemberPage => MemberPage 檢查)
		CustomUserDetails customUserDetails = new CustomUserDetails(newMember);
		
		// 更新 authentication , 讓剛註冊者儲存登入資訊
		Authentication authentication = 
				new UsernamePasswordAuthenticationToken
				(customUserDetails, customUserDetails.getPassword(), 
						customUserDetails.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return "redirect:/MemberPage"; // 跳轉 Memberpage
	}
	
	// 登入失敗處理
	@RequestMapping(value = "/login/failure")
	public String loginFailure(
			@RequestParam(name = "errorMessage") String errorMessage,
//			Model model 
			HttpServletRequest request
			) {
		
		System.out.println(errorMessage);
		
		// 帳號錯誤
		if (errorMessage.equals("rgrdsgdfhgnot found")) {
//			model.addAttribute("error", true);
			request.setAttribute("error", true);
		}
		
		// 密碼錯誤
		if (errorMessage.equals("Bad credentials")) {
//			model.addAttribute("error", true);
			request.setAttribute("error", true);
		}
		
		// 尚未啟用(已自行檢查)
//		if (errorMessage.equals("Disabled")) {
//			model.addAttribute("isEnabled", true);
//		}
		
		return "forward:/login";
	}
	
	// 體型、顏色、衣服、帽子 (前端要送) 新方式後端產圖 順便存取配件 Id
//	@RequestMapping("/createAvatar")
//	@ResponseBody
//	public String createAvatar() {
//		
//		// 找體型
//		BodyType bodyType = bodyTypeService.findByName("OVERWEIGHT");
//		
//		// 體型、顏色、衣服、帽子
//		avatarService.saveAvatarPic(
//				bodyType, "lightpurple", "Camera", "Fishermenhat", "Avatar_999");
//
//		//		avatarService.saveAvatarPic(
////				bodyType, "lightpurple", "Camera", null, "Avatar_999");
//		
//		return "OK" ;
//	}
	
}
