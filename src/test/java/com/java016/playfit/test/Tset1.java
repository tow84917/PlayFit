package com.java016.playfit.test;

import com.java016.playfit.dao.Fit_achieve_Repository;
import com.java016.playfit.dao.Monthly_record_Repository;
import com.java016.playfit.dao.UserRepository;
import com.java016.playfit.model.FitAchieve;
import com.java016.playfit.model.MonthlyRecord;
import com.java016.playfit.service.CalendarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

public class Tset1 {

    @Autowired
    Fit_achieve_Repository achieveRepository;
    @Autowired
    CalendarService calenderService;
    @Autowired
    Monthly_record_Repository monthlyRecordRepository;
    @Autowired
    UserRepository userRepository;

    @Test
    public void test2(){
        MonthlyRecord monthlyRecord = calenderService.findByUser_idAndMonthly(41, 8, 2021);
        /*if( monthlyRecord == null) {
			Calendar c = new Calendar.Builder().build();
			c.set(2021, 7, 1);
            User user = userRepository.getById(41);
            monthlyRecord = new Monthly_record( user, c, 0, 0, 0);
			monthlyRecordRepository.save(monthlyRecord);
		}
         */


    }

    @Test
    public void test(){

        Calendar date = new Calendar.Builder().build();
        date.set(2021,1,6);

        Date date1 = new Date();

        Timestamp timestamp = new Timestamp(date1.getTime());

        FitAchieve achieve = new FitAchieve( null,null, 1, 1000, date, null , timestamp,"1");

        achieveRepository.save(achieve);

    }
}
