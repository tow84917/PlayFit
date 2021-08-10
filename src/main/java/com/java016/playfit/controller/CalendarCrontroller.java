package com.java016.playfit.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java016.playfit.model.Monthly_record;
import com.java016.playfit.model.User;
import com.java016.playfit.security.CustomUserDetails;
import com.java016.playfit.service.UserService;
import com.java016.playfit.tool.CalendarTool;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.java016.playfit.service.CalendarService;

@Controller
@RequestMapping(value = "/calendar")
public class CalendarCrontroller {
	@Autowired
	UserService userService;
	@Autowired
	CalendarService calenderService;
	@Autowired
	CalendarTool tool;



	@RequestMapping(value = "/findMonthlyRecord")
	@ResponseBody
	public String findMonthlyRecord(@RequestBody Map<String, Object> monthYear, Principal principal){

		System.out.println("findMonthlyRecord---------");
		Integer month = tool.monthYearMapGetMonth(monthYear);
		Integer year = tool.monthYearMapGetYear(monthYear);
		System.out.println("month:  " + month + ",  year:  " + year);

		Monthly_record record = calenderService.findByUser_idAndMonthly(41, month, year);
		System.out.println("findMonthlyRecord==========");
//		System.out.println(record);
		Map<String, Object> map = new HashMap<>();
		map.put("finish", record.getFinish());				// null
		map.put("monthly_kcal", record.getMonthly_kcal());
		map.put("monthly_time", record.getMonthly_time());
//		轉換成json字串
		ObjectMapper mapper = new ObjectMapper();
		String s;
		try {
			 s = mapper.writeValueAsString(map);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			s = "";
		}

		return s;
	}

	@RequestMapping(value = "/findFitDays")
	@ResponseBody
	public List<Integer> findMonthlyFitDays(@RequestBody Map<String, Object> monthYear){

		Integer month = (Integer) monthYear.get("month") + 1;
		Integer year = (Integer) monthYear.get("year");
		System.out.println("month:  " + month + ",  year:  " + year);

		List<Integer> monthlyFitDays = calenderService.findMonthlyFitDays(month, year);

		System.out.println("----");
//		System.out.println(Arrays.toString(monthlyFitDays));
		System.out.println("----");

//		return  new int[] {10, 20};
		return monthlyFitDays;
	}


	/**
	 * 顯示 點選的日期
	 * @param paramsMap
	 * @param request
	 * @param response
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/findToday" ,
			method=RequestMethod.POST)
	@ResponseBody
	public String calendercopy(@RequestParam Map<String,Object> paramsMap , HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {

		System.out.println(request.getParameter("day"));
		System.out.println(paramsMap);
		
		String date = (String)paramsMap.get("day");
		date = date.replaceAll(",", "/");

		return date; 
	}

	
	@RequestMapping("image")
	public ModelAndView image() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("img");
		return mv;
	}

	/**
	 * 依照 ID 寫出 BLOB 圖片
	 * @param id
	 * @param request
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("/image_test/{id}")
	public void image_test(@PathVariable String id ,HttpServletRequest request, HttpServletResponse response) throws IOException {
		int i = Integer.parseInt(id);
		byte[] findImage = calenderService.findImage(i);
		System.out.println(findImage);
		System.out.println(findImage.length);
		
		response.setContentType("image/*");
		InputStream is = new ByteArrayInputStream(findImage);
		IOUtils.copy(is, response.getOutputStream());
		// 成功
	}

	/**
	 * 顯示 行事曆頁面
	 * @return
	 */
	@RequestMapping("/calendar")
	public ModelAndView calendar(@AuthenticationPrincipal User user) {

		System.out.println("calender**********");
		int userId = userService.getUserId();
		System.out.println(userId);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/calendar/calendar copy.html");
		return mv;
	}

}

// test