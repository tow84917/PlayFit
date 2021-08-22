package com.java016.playfit.test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.java016.playfit.dao.*;
import com.java016.playfit.model.DailyRecord;
import com.java016.playfit.model.FitActivity;
import com.java016.playfit.serviceimpl.CalendarServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;

import com.java016.playfit.model.FitAchieve;
import com.java016.playfit.service.CalendarService;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.annotation.Transient;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;


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
    @Autowired
    DailyRecordRepository dailyRecordRepository;

    @Test
    @Transactional
    public void test3() throws ParseException {
        String activityId = "1";
        String day = "2021/08/22";

        SimpleDateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        java.sql.Date date = new java.sql.Date(df.parse(day).getTime());
        System.out.println(date);
        DailyRecord dailyRecord = dailyRecordRepository.findByUserIdAndDate(41, date);
        System.out.println(dailyRecord);
        System.out.println("\n \n ----------- \n \n ");

        int id = Integer.parseInt(activityId);
        FitActivity activity = fitActivityRepository.findById(id).get();
        System.out.println(activity);
        System.out.println("\n \n ----------- \n \n ");

        FitAchieve fitAchieve = new FitAchieve("未執行", 1, 000, dailyRecord , activity);
        System.out.println(fitAchieve);
    }

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
