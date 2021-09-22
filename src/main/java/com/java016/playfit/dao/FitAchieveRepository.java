package com.java016.playfit.dao;

import java.sql.Date;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.java016.playfit.model.DailyRecord;
import com.java016.playfit.model.FitAchieve;
import com.java016.playfit.model.FitActivity;

public interface FitAchieveRepository extends JpaRepository<FitAchieve, Integer> {

//    @Query(value = "SELECT  execution_date FROM Fit_achieve where month(execution_date) = :month and year(execution_date) = :year group by execution_date" , nativeQuery=true)
    @Query(value = "SELECT r.created_date FROM playfit.Fit_achieve a join Daily_Record r on a.daily_record_id = r.id " +
            "where daily_record_id in ( select id from Daily_Record " +
                                    "where user_id = :userId and  month(created_date) = :month and year(created_date) = :year ) " +
            "group by r.created_date;;" , nativeQuery=true)
    List<Date> findByMonthAndYearGroup(int userId ,int month, int year);


    @Query(value = "SELECT * FROM Fit_achieve where month(execution_date) = :month and year(execution_date) = :year" , nativeQuery=true)
    Set<FitAchieve> findByMonthAndYear(int month, int year);
    
    List<FitAchieve> findAllByDailyRecordAndStatus(DailyRecord dailyRecord,String status);
    
	List<FitAchieve> findAllByDailyRecordAndFitActivityAndStatus(DailyRecord dailyRecord,FitActivity fitActivity,String status);
}
