package com.java016.playfit.dao;

import com.java016.playfit.model.MonthlyRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

@Repository
public interface MonthlyRecordRepository extends JpaRepository<MonthlyRecord, Integer> {


    @Nullable
    @Query(value = "SELECT * FROM monthly_record where user_id = :user_id and month(monthly) = :monthly and year(monthly) = :year" , nativeQuery = true)
    MonthlyRecord findByUserIdAndMonthly(@Param("user_id") int userId, @Param("monthly") int monthly, @Param("year") int year);
}
