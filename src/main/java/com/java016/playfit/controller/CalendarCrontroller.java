package com.java016.playfit.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java016.playfit.model.*;
import com.java016.playfit.service.CalendarService;
import com.java016.playfit.service.UserService;
import com.java016.playfit.tool.CalendarTool;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Principal;
import java.sql.Date;
import java.text.ParseException;
import java.util.*;

@Controller
@RequestMapping(value = "/calendar")
public class CalendarCrontroller {
	@Autowired
	UserService userService;
	@Autowired
	CalendarService calenderService;
	@Autowired
	CalendarTool tool;
	private static final Logger logger = LogManager.getLogger(CalendarCrontroller.class);

	public CalendarCrontroller() {
	}
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
	 //	 * @param paramsMap
	 * @param request
	 * @param response
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = "/findToday" ,
			method=RequestMethod.POST)
	@ResponseBody
	public String findActivityByDay(@RequestParam String day,
									HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {
		System.out.println("findActivityByDay in");
		System.out.println(day);

//		String today = (String)paramsMap.get("day");
//		today = today.replaceAll(",", "/");
		String[] split = day.split("/");
		Calendar c = new Calendar.Builder().build();
		c.set(Integer.parseInt(split[0]),Integer.parseInt(split[1])-1,Integer.parseInt(split[2]));
		Date date = new Date(c.getTimeInMillis());

		List<FitAchieve> dailyRecords = calenderService.findByCreatedDate(date);
		System.out.println("dailyRecords");
		ObjectMapper mapper = new ObjectMapper();
		String s = mapper.writeValueAsString(dailyRecords);
		System.out.println("---->>>>");
		System.out.println(s);

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
		mv.setViewName("/calendar/calendar");
		return mv;
	}

	/**
	 * 增加健身計畫
	 * @param paramsMap 日期
	 */
	@RequestMapping("/addActivity")
//	@ResponseBody
	public String addActivity(@RequestBody Map<String,Object> paramsMap) throws ParseException {
		System.out.println("addActivity");
		int loginUserId = userService.getLoginUserId();
		String day = (String) paramsMap.get("day");
//		day.replaceAll("/", "-");
		System.out.println(day);
		List<String> activities = (List<String>) paramsMap.get("activity");

		calenderService.addActivities(day, activities);


		System.out.println("addActivity finish \n");

//		ModelAndView mv = new ModelAndView();
//		mv.setViewName("index");
		return "redirect:/calendar/calendar";
	}

	/**
	 * 找某部位的健身動作
	 * 判斷使用者，轉發不同控制器
	 *  @return 不同權限方法
	 */
	@RequestMapping({"/findActivities"})
	public ModelAndView findActivities(@RequestParam String bodyPartSelect ,
									   RedirectAttributes redirectAttributes) {
		logger.info("findActivities --->  ",bodyPartSelect);
		System.out.println(bodyPartSelect);

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority authority : authorities) {
			String authority1 = authority.getAuthority();
			System.out.println(authority1);
		}

		ModelAndView modelAndView = null;
		if (authentication != null &&
				authentication.getAuthorities().stream().anyMatch(a -> a.getAuthority().equals("ROLE_PRIME"))) {
			logger.info("付費會員");
			redirectAttributes.addFlashAttribute("bodyPartSelect", bodyPartSelect);
			modelAndView = new ModelAndView("redirect:findAllActivities");
//			modelAndView.addObject("bodyPartSelect", bodyPartSelect);
//			return "forward:/findAllActivities";
		} else {
			logger.info("一般會員");
//			modelAndView.addObject("bodyPartSelect", bodyPartSelect);
			redirectAttributes.addFlashAttribute("bodyPartSelect",bodyPartSelect);
			modelAndView = new ModelAndView("redirect:findOneActivities");
//			return "forward:/findOneActivities";
		}
		return modelAndView;
	}

	/**
	 * 付費會員方法
	 * @param bodyPartSelect
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping(value = {"/findAllActivities"} )
	@ResponseBody
	@PreAuthorize("hasRole('PRIME')")
	public String findAllActivities(@ModelAttribute("bodyPartSelect") String bodyPartSelect, Model model) throws JsonProcessingException {
		logger.info("find All Activities in");
		logger.info(bodyPartSelect);
		List<FitActivity> activities = calenderService.findActivities(bodyPartSelect);

		ObjectMapper mapper = new ObjectMapper();
		String s = mapper.writeValueAsString(activities);

		logger.info("findActivities out");
		return s;
	}

	/**
	 * 一般會員方法
	 * @param bodyPartSelect
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping({"/findOneActivities"})
	@ResponseBody
	public String findOneActivities(@ModelAttribute("bodyPartSelect") String bodyPartSelect, Model model) throws JsonProcessingException {
		logger.info("find One Activities in");
		logger.info(bodyPartSelect);
		List<FitActivity> activities = calenderService.findActivities(bodyPartSelect);
		List<Object> activityDef = new ArrayList<>();
	
		for (int j = 0; j < 3; j++) {
			FitActivity fitActivity = activities.get(j);
			logger.info(fitActivity);
			activityDef.add(fitActivity);

		}
		ObjectMapper mapper = new ObjectMapper();
		String s = mapper.writeValueAsString(activityDef);

		logger.info("findActivities out");
		return s;
	}

	@RequestMapping("/getUserRole")
	@ResponseBody
	public String getUserRole(){
		String role = userService.getLoginUser().getRole();
		logger.info(role);

		return role;
	}

	/**
	 * 棄用
	 * @param paramsMap
	 * @return
	 */
	@RequestMapping({"/addFit"})
	public ModelAndView addFit(@RequestParam Map<String, Object> paramsMap) {
		logger.info("addFit");
		logger.info(paramsMap);
		Iterator var2 = paramsMap.keySet().iterator();

		while(var2.hasNext()) {
			String s = (String)var2.next();
			logger.info(s);
		}

		ModelAndView mv = new ModelAndView();
		mv.setViewName("index");
		return mv;
	}
}