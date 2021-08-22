package com.java016.playfit.Exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerAdvice {
    @ExceptionHandler(value = Exception.class)
    public ModelAndView exception(Exception ex, WebRequest request){
        ModelAndView modelAndView = new ModelAndView();

        // 判斷是哪種例外
        if (ex instanceof ArithmeticException){
            modelAndView.setViewName("Exception");
            return modelAndView;
        }

        // 增加錯誤訊息在這方法在利用前台映射取出數值
        modelAndView.addObject("errorSomething","somerror");

        // 返回的錯誤頁面
        modelAndView.setViewName("error");
        return modelAndView;
    }

    //如果我們要讓所有的@RequestMapping擁有此鍵值
    @ModelAttribute
    public void addAttribute(Model md){
        md.addAttribute("message","你可以設定一些錯誤訊息");
    }
}
