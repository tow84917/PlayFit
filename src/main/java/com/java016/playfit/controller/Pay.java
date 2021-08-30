package com.java016.playfit.controller;

import ecpay.payment.integration.AllInOne;
import example.ExampleAllInOne;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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
    public String point(Model model, String price) {
        System.out.println("pay in1");
        ExampleAllInOne exampleAllInOne = new ExampleAllInOne();
        ExampleAllInOne.initial();
        String check = ExampleAllInOne.genAioCheckOutALL("100", 41);
        System.out.println(check);
        model.addAttribute("check", check);
        return "pay";
    }
}
