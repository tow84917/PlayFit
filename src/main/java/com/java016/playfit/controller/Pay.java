package com.java016.playfit.controller;

import ecpay.payment.integration.AllInOne;
import example.ExampleAllInOne;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class Pay {
    private static final Logger logger = LogManager.getLogger(Pay.class);
    public static AllInOne all;

    public Pay() {
    }

    @RequestMapping({"/test"})
    @ResponseBody
    @PreAuthorize("hasRole('PRIME')")
    public String payTest() {
        logger.info("test test test: ");
        return "<h1>Welcome MY~~~~</h1>";
    }

    @RequestMapping({"/pay"})
    public String point() {
        System.out.println("pay in1");

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
    public String payFinish() {
    	logger.info("payFinish-------->>");
    	return "payFinish";
    }
    
    
}




