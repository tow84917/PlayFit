package com.java016.playfit.Exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/error")
public class ErrorController {

    /**
     * 404頁面
     */
    @GetMapping(value = "/404")
    public String error_404() {
        return "404";
    }

    /**
     * 500頁面
     */
    @GetMapping(value = "/500")
    public String error_500() {
        return "500";
    }

    /**
     * 測試500錯誤
     * @return
     */
    @RequestMapping("/custom")
    public String errorCustom() {
        return "custom";
    }

    /**
     * 測試算數錯誤
     */
    @RequestMapping("/arithmeticError")
    public String arithmeticError(){
        System.out.println(1/0);
        return "index";
    }
}
