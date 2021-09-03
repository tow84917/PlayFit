package com.java016.playfit.controller;

import com.java016.playfit.model.OrderRecord;
import com.java016.playfit.model.User;
import com.java016.playfit.service.UserService;
import ecpay.payment.integration.AllInOne;
import example.ExampleAllInOne;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

    @Autowired
    UserService userService;

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
    	Integer RtnCode = Integer.parseInt((String)paramsMap.get("RtnCode"));
    	logger.info(RtnCode);
    	if (RtnCode == 1){ // 交易成功
    		logger.info("交易成功 payFinish-------->>");
    		model.addAttribute("msg", "交易成功");
            OrderRecord orderRecord = new OrderRecord();
            Date date;
            Calendar calendar;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
            for (String s : paramsMap.keySet()) {
                System.out.println("----------------");
                System.out.println(s);
                System.out.println(paramsMap.get(s));
                System.out.println("----------------");
                switch (s){
                    case "MerchantTradeNo": // 訂單編號
//                        model.addAttribute("MerchantTradeNo", paramsMap.get(s));
                        orderRecord.setMerchantTradeNo((String)paramsMap.get(s));
                        break;
                    case "PaymentDate": // 付款時間
//                        model.addAttribute("PaymentDate", paramsMap.get(s));
                        try {
                            date = dateFormat.parse((String)paramsMap.get(s));
                        } catch (ParseException e) {
                            e.printStackTrace();
                            break;
                        }
                        calendar = Calendar.getInstance();
                        calendar.setTime(date);
                        orderRecord.setPaymentDate(calendar);
                        break;
                    case "PaymentType": // 付款方式
//                        model.addAttribute("PaymentType", paramsMap.get(s));
                        orderRecord.setPaymentType((String)paramsMap.get(s));
                        break;
                    case "PaymentTypeChargeFee": // 手續費
//                        model.addAttribute("PaymentTypeChargeFee", paramsMap.get(s));
                        orderRecord.setPaymentTypeChargeFee(Integer.parseInt((String)paramsMap.get(s)));
                        break;
                    case "TradeAmt": // 交易金額
//                        model.addAttribute("TradeAmt", paramsMap.get(s));
                        orderRecord.setTradeAmt(Integer.parseInt((String)paramsMap.get(s)));
                        break;
                    case "TradeDate": // 訂單成立時間
//                        model.addAttribute("TradeDate", paramsMap.get(s));

                        try {
                            date = dateFormat.parse((String)paramsMap.get(s));
                        } catch (ParseException e) {
                            e.printStackTrace();
                            break;
                        }
                        calendar = Calendar.getInstance();
                        calendar.setTime(date);
                        orderRecord.setTradeDate(calendar);
                        break;
                    case "TradeNo": // 綠界的交易編號
//                        model.addAttribute("TradeNo", paramsMap.get(s));
                        orderRecord.setTradeNo((String)paramsMap.get(s));
                        break;
                }
            }
//            User loginUser = userService.getLoginUser();
//            orderRecord.setUserId(loginUser);
            logger.info(orderRecord);
            System.out.println(orderRecord);
            model.addAttribute("RenMsg" , orderRecord);

        } else {
    	    // 交易失敗
        	logger.info("交易失敗 payFinish-------->>");
        	model.addAttribute("msg", "交易失敗");
            String rtnMsg = (String)paramsMap.get("RtnMsg");
            System.out.println(rtnMsg);
            model.addAttribute("RtnMsg", rtnMsg);
        }
    	return "payFinish";
    }
}




