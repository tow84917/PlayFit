package com.java016.playfit.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
public class OrderController {
    private static final Logger logger = LogManager.getLogger(OrderController.class);
    public static AllInOne all;

    UserService userService;

    OrderRecordService orderRecordService;

    @Autowired
    public OrderController(UserService userService, OrderRecordService orderRecordService) {
        this.userService = userService;
        this.orderRecordService = orderRecordService;
    }
    @Autowired
    OrderRecordRepository orderRecordRepository;

    public OrderController() {
    }

    /**
     * 付款選項頁面
     * @return
     */
    @RequestMapping({"/pay"})
    public String point(HttpSession session) {
        System.out.println("pay in1");
        session.setAttribute("userId", userService.getLoginUser());
        Object userId = session.getAttribute("userId");
        System.out.println(userId);
        return "subscription";
    }

    /**
     * 付款完成後畫面
     * @param paramsMap
     * @param model
     * @param session
     * @return
     */
    @RequestMapping("/payFinish")
    public String payFinish(@RequestParam Map<String,Object> paramsMap ,
                            Model model,
                            HttpSession session) {
        logger.info("payFinish-------->>");
        // 從session讀取登入的userId
        User userId = (User)session.getAttribute("userId");
        logger.info(userId);
        logger.info(paramsMap);
        OrderRecord record = orderRecordService.saveOrderRecord(paramsMap, userId.getId());

        userService.updateUserDateline(session, userId.getId() , record);
        System.out.println("updateDateline - ");
        Integer RtnCode = Integer.parseInt((String)paramsMap.get("RtnCode"));

        logger.info("交易結果: " + RtnCode);
        if (RtnCode == 1){ // 交易成功
            logger.info("交易成功 payFinish-------->>");
            model.addAttribute("msg", "交易成功");
            userService.updateUserRole(userId.getId(), "ROLE_PRIME");
        } else { // 交易失敗
            logger.info("交易失敗 payFinish-------->>");
            model.addAttribute("msg", "交易失敗");
        }
        
     	
     	// 新增 authentication 
        Authentication auth = 
        		SecurityContextHolder.getContext().getAuthentication();
     	
        List<GrantedAuthority> updatedAuthorities = new ArrayList<>(auth.getAuthorities());
        updatedAuthorities.add(new SimpleGrantedAuthority("ROLE_PRIME")); 
        
        Authentication newAuth = 
        		new UsernamePasswordAuthenticationToken(auth.getPrincipal(), auth.getCredentials(), updatedAuthorities);
        
        SecurityContextHolder.getContext().setAuthentication(newAuth);
        
     	model.addAttribute("RenMsg" , record);
        
        return "payFinish";
    }

    /**
     * 訂單查詢
     * @param model 到期日 總訂單數
     * @return OrderRecord
     */
    @RequestMapping("/orderRecord")
    public String orderRecord(Model model){
        Long count = orderRecordService.findCountByUserId();
        System.out.println(count);
        Calendar dateline = userService.getLoginUser().getDateline();
        String role = userService.getLoginUser().getRole();
        String s ;
        if( !role.equals("ROLE_PRIME") ){
             s = "非付費會員";
        }else{
             s = "會員到期: " + dateline.get(Calendar.YEAR) + "/" +
                    dateline.get(Calendar.MONTH) + "/" +
                    dateline.get(Calendar.DATE) ;
        }
        model.addAttribute("dateline", s);
        model.addAttribute("count" , count);
        return "/pay/OrderRecord";
    }

    @RequestMapping("/findCurrentPage")
    @ResponseBody
    public String findCurrentPage(@RequestBody Map<String,String> paramsMap) throws JsonProcessingException {
        Page<OrderRecord> allByUserId = orderRecordService.findCurrentPage(paramsMap);
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(allByUserId.getContent());
        return s;
    }


    /**
     * 測試定期定額
     * @param model
     * @param paramsMap
     * @return
     */
    @RequestMapping({"/period"})
    @ResponseBody
    public String period(Model model,
                         @RequestBody Map<String,Object> paramsMap,
                         HttpSession session) {
        System.out.println("period in -->> ");
        logger.info(paramsMap.get("execTimes"));
        logger.info(paramsMap.get("period"));
        logger.info(paramsMap.get("price"));
        logger.info(paramsMap.get("itemName"));
        session.setAttribute("execTimes", paramsMap.get("execTimes"));
        session.setAttribute("itemName", paramsMap.get("itemName"));
        ExampleAllInOne exampleAllInOne = new ExampleAllInOne();
        ExampleAllInOne.initial();
        String check = ExampleAllInOne.myGenAioCheckOutPeriod(paramsMap);
        System.out.println(check);
        model.addAttribute("check", check);
        return check;
    }

    /**
     * 測試單次付款
     * @param model
     * @param paramsMap
     * @return
     */
    @RequestMapping("/checkOut")
    @ResponseBody
    public String checkOut(Model model,
                           @RequestBody Map<String,Object> paramsMap,
                           HttpSession session){
        System.out.println("checkOut in -->> ");
        logger.info(paramsMap.get("execTimes"));
        logger.info(paramsMap.get("period"));
        logger.info(paramsMap.get("price"));
        logger.info(paramsMap.get("itemName"));
        session.setAttribute("execTimes", paramsMap.get("execTimes"));
        session.setAttribute("itemName", paramsMap.get("itemName"));

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

    /**
     * 測試權限
     * @return
     */
    @RequestMapping({"/test"})
    @ResponseBody
    @PreAuthorize("hasRole('PRIME')")
    public String payTest() {
        logger.info("test test test: ");
        return "<h1>Welcome MY~~~~</h1>";

    }
}




