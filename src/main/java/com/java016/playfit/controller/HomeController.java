package com.java016.playfit.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	
//	// ??????(??????????????????)
//	@RequestMapping("/")
//	public ModelAndView index() {
//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("index");
//		return mv;
//	}
	
	// ??????(????????????)
	@RequestMapping(value = {"/index", "/"})
	public ModelAndView index2() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/index/indexOffical");
		return mv;
	}
	
	// ????????????
	@RequestMapping("/aboutUs")
	public ModelAndView aboutUs() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/aboutUs/aboutUs");
		return mv;
	}
	
	// ???????????????
	@RequestMapping("/calculator")
	public ModelAndView calculator() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("calculator");
		return mv;
	}
	
	// ??????????????????
	@GetMapping("/certificationEmail")
	public ModelAndView certificationEmail() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("certificationEmail");
		return mv;
	}
	
	// ??????????????????
	@RequestMapping("/login")
	public String login_signup( 
			Model model, RedirectAttributes ra, HttpServletRequest request,
			@RequestParam(required = false, name = "logout") String rp,
			@RequestParam(required = false, name = "resetPassword") boolean resetPassword) {
		
		// ????????? model
		model.addAttribute("personalGoal",new PersonalGoal());
		model.addAttribute("healthRecord", new HealthRecord());
		model.addAttribute("user",new User());
		
		// ????????????????????????
		Object isError = request.getAttribute("error");
//		System.out.println(rp);
		
		// ??????????????????
		if(isError != null) {
			if((boolean)isError) {
				ra.addFlashAttribute("error", true);
				return "redirect:/login";
			}
		}
		
		// ????????????
		if(rp != null ) {
			ra.addFlashAttribute("logout", true);
			return "redirect:/login";		
		}	
		
		// ??????????????????
		if (resetPassword) {
			ra.addFlashAttribute("upadtePasswordOK", true);
			return "redirect:/login";
		}
		
		return "login";
	}
	
	// ??????????????????
	@PostMapping(value= "/process_avatar")
	@ResponseBody
	public String processAvatar(
			@RequestBody Map<String, String> avatarInfo,  
			final HttpServletRequest request) 
			throws IOException {
		
		// ????????? user ?????????
		boolean isTempNewMember= false ;
				
		// ?????? /process_register ????????????
		while (!isTempNewMember) {
			if (request.getSession().getAttribute("newMember") != null) {
				isTempNewMember = true ;
			}
		}
				
		User newStoredMember = userService.findByEmail(
			((User)request.getSession().getAttribute("newMember")).getEmail());
		
		// ????????? Avatar ???????????????
		String avatarSize = avatarInfo.get("avatarSize");
		String colorInfo = avatarInfo.get("colorInfo");
		String hatInfo = avatarInfo.get("hatInfo");
		String clothesInfo = avatarInfo.get("clothesInfo");
				
		// ?????? & ??????(??????????????? refresh)
		String avatarFileName ="Avatar_" + newStoredMember.getId();
				
		// ?????????
		BodyType bodyType = bodyTypeService.findByName(avatarSize);
		
		// ????????????
		avatarService.saveAvatarPic(
			bodyType, colorInfo, clothesInfo, hatInfo, avatarFileName);
				
		// ????????????????????????????????????
		AvatarBody avatarBody = avatarService.getAvatarBody(colorInfo, bodyType);
		AvatarClothes avatarClothes = avatarService.getAvatarClothes(bodyType, clothesInfo);
		AvatarHat avatarHat = avatarService.getAvatarHat(bodyType, hatInfo);
				
		// ???Avatar
		Avatar avatar = new Avatar();
		avatar.setFileName(avatarFileName + ".svg");
		avatar.setMimeType("image/svg+xml");
		
		// ??????
		avatar.setImagePath("/images/Avatar/" + avatarFileName + ".svg");
		
		// Set Avatar ??????
		avatar.setAvatarBody(avatarBody);
		avatar.setAvatarClothes(avatarClothes);
		avatar.setAvatarHat(avatarHat);
				
		// ?????? Avatar
		avatar.setName(newStoredMember.getFullName());
		avatarService.saveAvatar(avatar);
				
		// ??? Avatar ??? newMember
		newStoredMember.setAvatar(avatar);
		// ??????User Avatar
		userService.saveUser(newStoredMember);
				
		return "OK";
	}
	
	
	// ??????????????????
//	@PostMapping(value= "/process_avatar")
//	@ResponseBody
//	public String processAvatar(final HttpServletRequest request) 
//			throws IOException {
//		
//		// ????????? user ?????????
//		boolean isTempNewMember= false ;
//		
//		// ?????? /process_register ????????????
//		while (!isTempNewMember) {
//			if (request.getSession().getAttribute("newMember") != null) {
//				isTempNewMember = true ;
//			}
//		}
//		
//		// ??????????????????
//		User newMember = userService.findByEmail(
//				((User)request.getSession().getAttribute("newMember")).getEmail());
//		
//		// ?????? & ??????(??????????????? refresh)
//		String avatarFileName ="Avatar_" + newMember.getId()+ ".svg";
//		String path = "src/main/resources/static/images/Avatar/"; 
//		
//		// ?????????????????? Avatar Folder
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
//		// ???Avatar
//		Avatar avatar = new Avatar();
//		avatar.setImagePath("./images/Avatar/" + avatarFileName);
//		
//		// ?????? Avatar
//		avatar.setName(newMember.getFullName());
//		avatarService.saveAvatar(avatar);
//		
//		// ??? Avatar ??? newMember
//		newMember.setAvatar(avatar);
//		// ??????User Avatar
//		userService.saveUser(newMember);
//		
//		return "OK";
//	}
	
	// ????????????
	@PostMapping("/process_register")
	public String processRegister(User user, 
			PersonalGoal personalGoal, HealthRecord healthRecord, Model model
			) {
		
		// ???????????????
		java.util.Date utilDate = new java.util.Date();
		// ???????????????SQL?????????Date
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		System.out.println("controller > " + user);
		System.out.println("controller > " + healthRecord);
		System.out.println("controller > " + personalGoal);

		// ?????? User
		user.setCertificationStatus(0);
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		
		// ????????????
		user.setRole("ROLE_NORMAL");
		
		userService.saveUser(user);
		
		// ????????????????????????User
		User newMember = userService.findByEmail(user.getEmail());
		
		// ??????????????????
		healthRecord.setUser(newMember);
		healthRecord.setDate(sqlDate);
		healthRecord.setCalorieDeficit(0.0);
		healthRecord = bodyCalculator.calAll(healthRecord, user);
		healthRecordService.saveHealthRecord(healthRecord);
		
		// ??????????????????
		personalGoal.setUser(newMember);
		personalGoal.setCreateDate(sqlDate);
		personalGoal.setStartWeight(healthRecord.getWeight());
		personalGoal.setTotalLost(0);
		personalGoalService.savePersonalGoal(personalGoal);
		
		// ?????????USER ??? Session
		model.addAttribute("newMember",newMember) ;
		
		// ???Security ????????????,?????????(redirect:/MemberPage => MemberPage ??????)
		CustomUserDetails customUserDetails = new CustomUserDetails(newMember);
		
		// ?????? authentication , ?????????????????????????????????
		Authentication authentication = 
				new UsernamePasswordAuthenticationToken
				(customUserDetails, customUserDetails.getPassword(), 
						customUserDetails.getAuthorities());
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		
		return "redirect:/MemberPage"; // ?????? Memberpage
	}
	
	// ??????????????????
	@RequestMapping(value = "/login/failure")
	public String loginFailure(
			@RequestParam(name = "errorMessage") String errorMessage,
//			Model model 
			HttpServletRequest request
			) {
		
		System.out.println(errorMessage);
		
		// ????????????
		if (errorMessage.equals("rgrdsgdfhgnot found")) {
//			model.addAttribute("error", true);
			request.setAttribute("error", true);
		}
		
		// ????????????
		if (errorMessage.equals("Bad credentials")) {
//			model.addAttribute("error", true);
			request.setAttribute("error", true);
		}
		
		// ????????????(???????????????)
//		if (errorMessage.equals("Disabled")) {
//			model.addAttribute("isEnabled", true);
//		}
		
		return "forward:/login";
	}
	
	// ????????????????????????????????? (????????????) ????????????????????? ?????????????????? Id
	@RequestMapping("/createAvatar")
	@ResponseBody
	public String createAvatar() {
		
		// ?????????
		BodyType bodyType = bodyTypeService.findByName("OVERWEIGHT");
		
		// ?????????????????????????????????
		avatarService.saveAvatarPic(
				bodyType, "lightpurple", "Camera", "Fishermenhat", "Avatar_666");

		//		avatarService.saveAvatarPic(
//				bodyType, "lightpurple", "Camera", null, "Avatar_999");
		
		return "OK" ;
	}
	
}
