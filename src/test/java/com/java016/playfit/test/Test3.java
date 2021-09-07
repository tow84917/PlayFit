package com.java016.playfit.test;

import com.java016.playfit.dao.FitActivityRepository;
import com.java016.playfit.dao.UserRepository;
import com.java016.playfit.model.FitActivity;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class Test3 {

    @Autowired
    UserRepository userRepository;
    
    @Autowired
    FitActivityRepository fitActivityRepository;

    @Test
    @Transactional
    public void test1(){
        System.out.println("-->");
        FitActivity fitActivity = fitActivityRepository.findById(3).get();
        Boolean role = fitActivity.getRole();
        System.out.println(role);
        
    }
}
