package com.java016.playfit.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.java016.playfit.service.CalenderService;

@Controller
public class CalenderCrontroller {
	
	@Autowired
	CalenderService calenderService;

	@RequestMapping(value = "/calender_controller" , 
			method=RequestMethod.POST)
	@ResponseBody
	public String calendercopy(@RequestParam Map<String,Object> paramsMap , HttpServletRequest request, HttpServletResponse response) throws JsonProcessingException {

		System.out.println(request.getParameter("day"));
		System.out.println(paramsMap);
		
		String date = (String)paramsMap.get("day");
		date = date.replaceAll("\\.", "/");
		
			
		return date; 
	}
	
	@RequestMapping("/calender_image")
	public void fitItem(HttpServletRequest request, HttpServletResponse response) {
		byte[] findImage = calenderService.findImage(1);
		System.out.println(findImage);
		System.out.println(findImage.length);
		
		response.setContentType("image/*");
//		try {
//			OutputStream os = response.getOutputStream();
//			InputStream is = new ByteArrayInputStream(findImage);
//			
//			int length = findImage.length;
//			int len = 0;
//			byte[] bytes = new byte[8192];
//			while ((len = is.read(bytes)) != -1) {
//				os.write(bytes, 0, len);
//			}
//			os.close();
//			is.close();
//			
//		} catch (IOException e) {
//			System.out.println(e.getMessage());
//		}
	}
	
	@RequestMapping("image")
	public ModelAndView image() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("img");
		return mv;
	}
	
	
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

	
	@RequestMapping("/calender")
	public ModelAndView calender() {
		Object principal = 
				SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		String username;
		if (principal instanceof UserDetails) {
		    username = ((UserDetails)principal).getUsername();
		} else {
			username = principal.toString();
		}
		System.out.println(username);
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/calender/calender copy.html");
		return mv;
	}

}
