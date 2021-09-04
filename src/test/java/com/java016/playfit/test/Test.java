package com.java016.playfit.test;

import com.java016.playfit.dao.OrderRecordRepository;
import com.java016.playfit.model.OrderRecord;
import com.java016.playfit.service.OrderRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class Test {

    @Autowired
    OrderRecordService orderRecordService;

    @org.junit.jupiter.api.Test
    @Transactional
    public void test1(){
        System.out.println("-->");

        orderRecordService.page();

    }
}
