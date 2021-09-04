package com.java016.playfit.controller;

import com.java016.playfit.dao.OrderRecordRepository;
import com.java016.playfit.model.OrderRecord;
import com.java016.playfit.model.User;
import com.java016.playfit.security.CustomUserDetails;
import com.java016.playfit.service.OrderRecordService;
import com.java016.playfit.service.UserService;
import ecpay.payment.integration.AllInOne;
import example.ExampleAllInOne;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class Pay {
    private static final Logger logger = LogManager.getLogger(Pay.class);
    public static AllInOne all;

    UserService userService;

    OrderRecordService orderRecordService;

    @Autowired
    public Pay(UserService userService, OrderRecordService orderRecordService) {
        this.userService = userService;
        this.orderRecordService = orderRecordService;
    }
    @Autowired
    OrderRecordRepository orderRecordRepository;

    public Pay() {
    }

    @RequestMapping({"/test"})
    @ResponseBody
    @PreAuthorize("hasRole('PRIME')")
    public String payTest() {
        logger.info("test test test: ");
        return "<h1>Welcome MY~~~~</h1>";
    }

    /**
     * 付款選項頁面
     * @return
     */
    @RequestMapping({"/pay"})
    public String point(HttpSession session) {
        System.out.println("pay in1");
        session.setAttribute("userId", userService.getLoginUserId());
        Object userId = session.getAttribute("userId");
        System.out.println(userId);
        return "subscription";
    }

    /**
     * 定期定額
     * @param model
     * @param paramsMap
     * @return
     */
    @RequestMapping({"/period"})
    @ResponseBody
    public String period(Model model,
                         @RequestBody Map<String,Object> paramsMap) {
        System.out.println("period in -->> ");
        logger.info(paramsMap.get("execTimes"));
        logger.info(paramsMap.get("period"));
        logger.info(paramsMap.get("price"));
        logger.info(paramsMap.get("itemName"));
        ExampleAllInOne exampleAllInOne = new ExampleAllInOne();
        ExampleAllInOne.initial();
        String check = ExampleAllInOne.myGenAioCheckOutPeriod(paramsMap);
        System.out.println(check);
        model.addAttribute("check", check);
        return check;
    }

    /**
     * 單次付款
     * @param model
     * @param paramsMap
     * @return
     */
    @RequestMapping("/checkOut")
    @ResponseBody
    public String checkOut(Model model,
                           @RequestBody Map<String,Object> paramsMap){
        System.out.println("checkOut in -->> ");
        logger.info(paramsMap.get("execTimes"));
        logger.info(paramsMap.get("period"));
        logger.info(paramsMap.get("price"));
        logger.info(paramsMap.get("itemName"));
        ExampleAllInOne exampleAllInOne = new ExampleAllInOne();
        ExampleAllInOne.initial();
        String check = ExampleAllInOne.myGenAioCheckOutALL(paramsMap);
        System.out.println(check);
        model.addAttribute("check", check);
        return check;
    }
    
    /**
     * 測試用
     * @param model
     * @return
     */
    @RequestMapping({"/p"})
    public String p(Model model) {
        System.out.println("-->> ");
        ExampleAllInOne exampleAllInOne = new ExampleAllInOne();
        ExampleAllInOne.initial();
        String check = ExampleAllInOne.genAioCheckOutPeriod();
        System.out.println(check);
        model.addAttribute("check", check);
        return "pay";
    }
    
    @RequestMapping("/payFinish")
    public String payFinish(@RequestParam Map<String,Object> paramsMap ,
                            Model model,
                            HttpSession session) {
    	logger.info("payFinish-------->>");
        Integer userId = (Integer)session.getAttribute("userId");
        logger.info(userId);

        OrderRecord record = orderRecordService.saveOrderRecord(paramsMap, userId);

    	Integer RtnCode = Integer.parseInt((String)paramsMap.get("RtnCode"));
    	logger.info(RtnCode);
    	if (RtnCode == 1){ // 交易成功
    		logger.info("交易成功 payFinish-------->>");
    		model.addAttribute("msg", "交易成功");
        } else {
    	    // 交易失敗
        	logger.info("交易失敗 payFinish-------->>");
        	model.addAttribute("msg", "交易失敗");
        }
        model.addAttribute("RenMsg" , record);
    	return "payFinish";
    }

    /**
     * 測試付款成功
     * @param model
     * @return
     */
    @RequestMapping("/t2")
    public String payTest(Model model) {
    	model.addAttribute("msg", "交易成功");
    	OrderRecord orderRecord = orderRecordRepository.findById(1).get();
		User loginUser = userService.getLoginUser();
		System.out.println(loginUser);
		model.addAttribute("RenMsg", orderRecord);
		return "payFinish";
		
	}
}




