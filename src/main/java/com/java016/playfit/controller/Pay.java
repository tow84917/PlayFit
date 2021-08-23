package com.java016.playfit.controller;

import ecpay.payment.integration.AllInOne;
import example.ExampleAllInOne;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Pay {

    @RequestMapping("/test")
    public String payTest(Model model){
        System.out.println("test");
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName("pay");
//        return modelAndView;
        model.addAttribute("check" , "<h1>check</h1>");
        return "pay";
    }

    public static AllInOne all;
    @RequestMapping("/pay")
    public String point(Model model, String price){
        System.out.println("pay in1");
        ExampleAllInOne exampleAllInOne = new ExampleAllInOne();
        System.out.println("pay in2");
        ExampleAllInOne.initial();
        System.out.println("pay in3");
//        Integer val = Integer.parseInt(price);
        System.out.println("pay in4");
        String check = exampleAllInOne.genAioCheckOutALL("100",41);
        System.out.println("pay in5");
        System.out.println(check);
        model.addAttribute("check" , check);
        System.out.println("pay in6");
        return "pay";
    }
}
