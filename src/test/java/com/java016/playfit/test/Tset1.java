package com.java016.playfit.test;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.java016.playfit.dao.FitActivityRepository;
import com.java016.playfit.model.FitActivity;
import com.java016.playfit.serviceimpl.CalendarServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.java016.playfit.dao.FitAchieveRepository;
import com.java016.playfit.dao.MonthlyRecordRepository;
import com.java016.playfit.dao.UserRepository;
import com.java016.playfit.model.FitAchieve;
import com.java016.playfit.service.CalendarService;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;


@SpringBootTest
public class Tset1 {

    @Autowired
    FitAchieveRepository achieveRepository;
    @Autowired
    FitActivityRepository fitActivityRepository;
    @Autowired
    MonthlyRecordRepository monthlyRecordRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    public void test2(){
//        CalendarServiceImpl calendarService = new CalendarServiceImpl();
//        List<FitActivity> activities = calendarService.findActivities("Upper");

        List<FitActivity> upper = fitActivityRepository.findAllByBodyPart("Upper");
        for (FitActivity fitActivity : upper) {
        System.out.println(fitActivity.getName());

        }

    }

    @Test
    public void test(){

        Calendar date = new Calendar.Builder().build();
        date.set(2021,1,6);

        Date date1 = new Date();

        Timestamp timestamp = new Timestamp(date1.getTime());

        FitAchieve achieve = new FitAchieve();

        achieveRepository.save(achieve);

    }
}
