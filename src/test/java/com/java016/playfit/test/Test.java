package com.java016.playfit.test;

import com.java016.playfit.dao.OrderRecordRepository;
import com.java016.playfit.dao.UserRepository;
import com.java016.playfit.model.OrderRecord;
import com.java016.playfit.service.OrderRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest
public class Test {

    @Autowired
    OrderRecordService orderRecordService;
    @Autowired
    OrderRecordRepository orderRecordRepository;
    @Autowired
    UserRepository userRepository;
    @org.junit.jupiter.api.Test
    @Transactional
    public void test1(){
        System.out.println("-->");

        orderRecordService.page();

    }

    @org.junit.jupiter.api.Test
    @Transactional
    public void test2() {
        Pageable firstPageWithTwoElements = PageRequest.of(0,1);
        Page<OrderRecord> allByUserId =
                orderRecordRepository.findAllByUserId(userRepository.findById(41).get(), firstPageWithTwoElements);
        System.out.println(allByUserId);
    }

    @org.junit.jupiter.api.Test
    @Transactional
    public void test3() {
        Pageable firstPageWithTwoElements = PageRequest.of(0,1);
        List<OrderRecord> allByUserId = orderRecordRepository.findAllByTradeAmt(100);
        System.out.println(allByUserId);
    }

    @org.junit.jupiter.api.Test
    @Transactional
    public void test4() {
        Long aLong = orderRecordRepository.countByUserId(userRepository.findById(41).get());
        System.out.println(aLong);
    }

}
