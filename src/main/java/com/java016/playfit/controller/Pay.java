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
import org.springframework.web.bind.annotation.RequestParam;
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
    public String payFinish(@RequestParam Map<String,Object> paramsMap ,
                            Model model) {
    	logger.info("payFinish-------->>");
    	if (paramsMap.get("RtnCode") == "1"){ // 交易成功
            for (String s : paramsMap.keySet()) {
                System.out.println("----------------");
                System.out.println(s);
                System.out.println(paramsMap.get(s));
                System.out.println("----------------");

                switch (s){
                    case "MerchantTradeNo": // 訂單編號
                        model.addAttribute("MerchantTradeNo", paramsMap.get(s));
                        break;
                    case "PaymentDate": // 付款時間
                        model.addAttribute("PaymentDate", paramsMap.get(s));
                        break;
                    case "PaymentType": // 付款方式
                        model.addAttribute("PaymentType", paramsMap.get(s));
                        break;
                    case "PaymentTypeChargeFee": // 手續費
                        model.addAttribute("PaymentTypeChargeFee", paramsMap.get(s));
                        break;
                    case "TradeAmt": // 交易金額
                        model.addAttribute("TradeAmt", paramsMap.get(s));
                        break;
                    case "TradeDate": // 訂單成立時間
                        model.addAttribute("TradeDate", paramsMap.get(s));
                        break;
                    case "TradeNo": // 綠界的交易編號
                        model.addAttribute("TradeNo", paramsMap.get(s));
                        break;
                }
            }

        } else {
    	    // 交易失敗
            Object rtnMsg = paramsMap.get("RtnMsg");
            model.addAttribute("RtnMsg", rtnMsg);
        }
    	return "payFinish";
    }
}




