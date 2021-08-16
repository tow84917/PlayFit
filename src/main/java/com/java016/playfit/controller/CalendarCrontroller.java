package com.java016.playfit.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.sql.Date;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java016.playfit.model.FitAchieve;
import com.java016.playfit.model.MonthlyRecord;
import com.java016.playfit.model.User;
import com.java016.playfit.service.CalendarService;
import com.java016.playfit.service.UserService;
import com.java016.playfit.tool.CalendarTool;

@Controller
@RequestMapping(value = "/calendar")
public class CalendarCrontroller {
	@Autowired
	UserService userService;
	@Autowired
	CalendarService calenderService;
	@Autowired
	CalendarTool tool;

	/**
	 * 找user當月的紀錄
	 * @param monthYear
	 * @param principal
	 * @return
	 */
	@RequestMapping(value = "/findMonthlyRecord")
	@ResponseBody
	public String findMonthlyRecord(@RequestBody Map<String, Object> monthYear, Principal principal){

		System.out.println("findMonthlyRecord---------");
		Integer month = tool.monthYearMapGetMonth(monthYear);
		Integer year = tool.monthYearMapGetYear(monthYear);
		System.out.println("month:  " + month + ",  year:  " + year);

		MonthlyRecord record = calenderService.findByUserIdAndMonthly( month, year);
		System.out.println("findMonthlyRecord==========");
//		System.out.println(record);
		Map<String, Object> map = new HashMap<>();
		map.put("finish", record.getFinish());				// null
		map.put("monthly_kcal", record.getMonthlyKcal());
		map.put("monthly_time", record.getMonthlyTime());
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

	/**
	 * 找user當月哪幾天有排健身
	 * @param monthYear
	 * @return
	 */
	@RequestMapping(value = "/findFitDays")
	@ResponseBody
	public List<Integer> findMonthlyFitDays(@RequestBody Map<String, Object> monthYear){
		System.out.println("找當月排成控制器----------");
		Integer month = (Integer) monthYear.get("month") + 1;
		Integer year = (Integer) monthYear.get("year");
		System.out.println("month:  " + month + ",  year:  " + year);

		// 舊
//		List<Integer> monthlyFitDays = calenderService.findMonthlyFitDays(month, year);
		// 新 排除健身記錄為空或直接執行的日期
		List<Integer> userMonthlyFitDays = calenderService.findUserMonthlyFitDays(month, year);
		System.out.println(userMonthlyFitDays);

		System.out.println("----");
//		System.out.println(Arrays.toString(monthlyFitDays));
		System.out.println("----");

//		return  new int[] {10, 20};
		System.out.println("找當月排成控制器----------");
//		return monthlyFitDays;
		return userMonthlyFitDays;
	}

	/**
	 * 顯示 當日所排程的動作
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

//		System.out.println(request.getParameter("day"));
		System.out.println(paramsMap);
	
		String today = (String)paramsMap.get("day");
//		today = today.replaceAll(",", "/");
		String[] split = today.split("/");
		Calendar c = new Calendar.Builder().build();
		c.set(Integer.parseInt(split[0]),Integer.parseInt(split[1])-1,Integer.parseInt(split[2]));
		java.sql.Date date = new Date(c.getTimeInMillis());

		List<FitAchieve> dailyRecords = calenderService.findByCreatedDate(date);
		System.out.println("dailyRecords");
		ObjectMapper mapper = new ObjectMapper();
		String s = mapper.writeValueAsString(dailyRecords);

		return s;
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
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/calendar/calendar copy.html");
		return mv;
	}

	@RequestMapping("image")
	public ModelAndView image() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("img");
		return mv;
	}
}