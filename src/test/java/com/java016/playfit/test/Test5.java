package com.java016.playfit.test;

import com.java016.playfit.dao.OrderRecordRepository;
import com.java016.playfit.dao.UserRepository;
import com.java016.playfit.model.OrderRecord;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Calendar;

@SpringBootTest
public class Test5 {

    @Autowired
    UserRepository userRepository;

    @Test
    @Transactional
    public void test1(){
        System.out.println("-->");

//        System.out.println(orderRecord);
        System.out.println("--->>");
    }
}
