package com.java016.playfit.controller;

import java.security.Principal;
import java.util.Collection;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.java016.playfit.model.Avatar;
import com.java016.playfit.model.FitAchieve;
import com.java016.playfit.model.FitActivity;
import com.java016.playfit.model.FitActivityVideo;
import com.java016.playfit.model.Food;
import com.java016.playfit.model.HealthRecord;
import com.java016.playfit.model.PersonalGoal;
import com.java016.playfit.model.User;
import com.java016.playfit.service.FoodService;
import com.java016.playfit.service.HealthRecordService;
import com.java016.playfit.service.PersonalGoalService;
import com.java016.playfit.service.StartFitService;
import com.java016.playfit.service.UserService;
import com.java016.playfit.service.VideoService;

import javassist.NotFoundException;


@Controller
public class StartFitController {
	
	@Autowired
	StartFitService startFitService;
	@Autowired
	UserService userService;
	@Autowired
	VideoService videoService;
	@Autowired
	PersonalGoalService personalGoalService;
	@Autowired
	HealthRecordService healthRecordService;
	
	@GetMapping("/StartFit")
	public ModelAndView StartFitPage() {
		ModelAndView mv = new ModelAndView();
		List<FitActivity> fitActivities = startFitService.getAllFitActivities();

		
		mv.addObject("fitActivities", fitActivities);
		mv.setViewName("/fitNow/fit-now");
		return mv;
	}
	
	@RequestMapping("/FitActivities")
	@ResponseBody
	public List<FitActivity> getFitActivities() {
		List<FitActivity> fitActivities = startFitService.getAllFitActivities();
		
		fitActivities.forEach(fitA->{
			System.out.println("Name = " + fitA.getName());
		});
		
		return fitActivities;
	}
	
	//直接點擊要健身的項目
	@GetMapping("/fit-activity/{fitId}/{fitName}")
	public ModelAndView fitActivityClicked(@PathVariable("fitName") String fitName,
									@PathVariable("fitId") Integer fitId,
									Principal principal,HttpSession session) throws NotFoundException {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		String authority1 = "ROLE_NORMAL";
		for (GrantedAuthority authority : authorities) {
			authority1 = authority.getAuthority();
			System.out.println("用戶權限" + authority1);
		}
		
		
		
		//登入的使用者帳號(電子信箱)
		String email = userService.getLoginUserEmail();
		//用帳號抓出此用戶的Entity
		User user = userService.findByEmail(email);
		
		
		Integer userId = user.getId();

		ModelAndView mv = new ModelAndView();
		
		FitActivity fitActivity = startFitService.getFitActivityById(fitId);
		if(fitActivity.getRole() && !(authority1.equals("ROLE_PRIME") || authority1.equals("ROLE_DEF"))) {
			throw new NotFoundException("no no no");
		}
		System.out.println("用戶權限");
		FitActivityVideo fitActivityVideo = videoService.getFitActivityVideoById(fitId);
		String path = fitActivity.getBodyPart() + "/" + fitActivityVideo.getFileName();
		System.out.println("Session id : " + session.getId());
		
		// 會員虛擬角色
		Avatar avatar = user.getAvatar();
		mv.addObject("avatar", avatar);
		
		// 取最近健康紀錄
		HealthRecord healthRecord = healthRecordService.findLastDateByUserId(userId);
		mv.addObject("healthRecord", healthRecord);
		
		// 取最近目標紀錄
		PersonalGoal personalGoal = personalGoalService.findLastDateByUserId(userId);
		mv.addObject("personalGoal", personalGoal);
		mv.addObject("fitActivity",fitActivity);
		mv.addObject("fitAchieveId","");
		mv.addObject("fitActivityId",fitId);
		mv.addObject("videoPath",path);
		mv.setViewName("playPage/playPage");
		
		return mv;
	}
	
	//點擊健身計畫->開始健身
	@GetMapping("/fit-activity/{fitAchieveId}")
	public ModelAndView fitAchieveActivityClicked(@PathVariable("fitAchieveId") Integer fitAchieveId,
									Principal principal,HttpSession session) throws NotFoundException {
		
		ModelAndView mv = new ModelAndView();
		
		//登入的使用者帳號(電子信箱)
		String email = userService.getLoginUserEmail();
		//用帳號抓出此用戶的Entity
		User user = userService.findByEmail(email);
		
		Integer userId = user.getId();
		
		FitAchieve fitAchieve = startFitService.getFitAchieveById(fitAchieveId);
		System.out.println(fitAchieve.getStatus());
//		if(!fitAchieve.getStatus().equals("未執行")) throw new NotFoundException("Current user try to access fitAchieve with illegal status");
		boolean isFitAchieveBelongToCurrentUser = startFitService.checkFitAchieveIdIsBelongTo(fitAchieve, user);
		if(!isFitAchieveBelongToCurrentUser) {
			throw new NotFoundException("Current User Try To Access Other Users FitAchieve");
		}
		FitActivity fitActivity = fitAchieve.getFitActivity();
		FitActivityVideo fitActivityVideo = fitAchieve.getFitActivity().getFitActivityVideo();
		String path = fitActivity.getBodyPart() + "/" + fitActivityVideo.getFileName();

		System.out.println("Session id : " + session.getId());
		
		// 會員虛擬角色
		Avatar avatar = user.getAvatar();
		mv.addObject("avatar", avatar);
		
		// 取最近健康紀錄
		HealthRecord healthRecord = healthRecordService.findLastDateByUserId(userId);
		mv.addObject("healthRecord", healthRecord);
		

		// 取最近目標紀錄
		PersonalGoal personalGoal = personalGoalService.findLastDateByUserId(userId);
		mv.addObject("personalGoal", personalGoal);
		mv.addObject("fitActivity",fitActivity);
		mv.addObject("fitAchieveId",fitAchieve.getId());
		mv.addObject("fitActivityId",fitActivity.getId());
		mv.addObject("videoPath",path);
		mv.setViewName("playPage/playPage");
		return mv;
	}
	
	@GetMapping("videoEnded/{fitId}")
	@ResponseBody
	public String videoEnded(@PathVariable("fitId") Integer fitActivityIdFromPath, 
			HttpSession session) throws NotFoundException {
		
		System.out.println("fitActivityIdFromPath = " + fitActivityIdFromPath);
		
		//登入的使用者帳號(電子信箱)
		String email = userService.getLoginUserEmail();
		//用帳號抓出此用戶的Entity
		User user = userService.findByEmail(email);
		
//		long videoEndPoint = (long) session.getAttribute("VideoEndTimePoint");
//		int fitActivityId = (int) session.getAttribute("FitActivityId");
//		boolean isRunAsExpected = startFitService.checkFitActivityRunAsExpected(videoEndPoint);
//		
//		String alertString; 
//		if(isRunAsExpected) {
//			startFitService.saveFitAchieveWithExecuteDirectly(user, fitActivityId);
//			alertString = "成功完成動作";
//		}else {
//			startFitService.saveFitAchieveWithExecuteDirectly(user, fitActivityId);
//			alertString = "快轉";
//		}
		
		startFitService.saveFitAchieveWithExecuteDirectly(user, fitActivityIdFromPath);
		String alertString; 
		alertString = "成功完成動作";
		session.removeAttribute("VideoEndTimePoint");
		session.removeAttribute("FitActivityId");
		
		return alertString;
	}
	
	@GetMapping("videoEnded/{fitActivityId}/{fitAchieveId}")
	@ResponseBody
	public String plannedVideoEnded(@PathVariable("fitActivityId") Integer fitActivityIdFromPath,
									@PathVariable("fitAchieveId") Integer fitAchieveId,
									HttpSession session) throws NotFoundException {
		System.out.println("plannedVideoEnded");
		System.out.println("fitActivityIdFromPath = " + fitActivityIdFromPath);
		
		//登入的使用者帳號(電子信箱)
		String email = userService.getLoginUserEmail();
		//用帳號抓出此用戶的Entity
		User user = userService.findByEmail(email);
		
		FitAchieve fitAchieve = startFitService.getFitAchieveById(fitAchieveId);
		
//		long videoEndPoint = (long) session.getAttribute("VideoEndTimePoint");
//		int fitActivityId = (int) session.getAttribute("FitActivityId");
//		boolean isRunAsExpected = startFitService.checkFitActivityRunAsExpected(videoEndPoint);
//		
//		String alertString; 
//		if(isRunAsExpected) {
//			startFitService.saveFitAchieveWithExecutionPlan(fitAchieve,user);
//			alertString = "成功完成預期動作";
//		}else {
//			startFitService.saveFitAchieveWithExecutionPlan(fitAchieve,user);
//			alertString = "快轉預期動作";
//		}
		
		startFitService.saveFitAchieveWithExecutionPlan(fitAchieve,user);
		String alertString; 
		alertString = "成功完成動作";
	
		session.removeAttribute("VideoEndTimePoint");
		session.removeAttribute("FitActivityId");
		
		return alertString;
	}

}
