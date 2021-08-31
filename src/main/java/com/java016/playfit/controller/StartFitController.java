package com.java016.playfit.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.java016.playfit.model.FitActivity;
import com.java016.playfit.model.Food;
import com.java016.playfit.model.User;
import com.java016.playfit.service.FoodService;
import com.java016.playfit.service.StartFitService;
import com.java016.playfit.service.UserService;


@Controller
public class StartFitController {
	
	@Autowired
	StartFitService startFitService;

	
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
	
	//點擊要健身的項目
	@GetMapping("/fit-activity/{fitId}/{fitName}")
	@ResponseBody
	public String fitActivityClicked(@PathVariable("fitName") String fitName,
									@PathVariable("fitId") String fitId,
									Principal principal) {
		
		return fitId + " <br>" + fitName + " <br>" + principal.getName();
	}

}
