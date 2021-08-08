package com.java016.playfit.dao;

import com.java016.playfit.converter.LocalDateCalendarAttributeConverter;
import com.java016.playfit.model.Fit_achieve;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.persistence.Convert;
import java.sql.Date;
import java.util.Calendar;

import java.util.List;
import java.util.Set;

public interface Fit_achieve_Repository extends JpaRepository<Fit_achieve, Integer> {

    @Query(value = "SELECT  execution_date FROM Fit_achieve where month(execution_date) = :month and year(execution_date) = :year group by execution_date" , nativeQuery=true)
    List<Date> findByMonthAndYearGroup(int month, int year);

    @Query(value = "SELECT * FROM Fit_achieve where month(execution_date) = :month and year(execution_date) = :year" , nativeQuery=true)
    Set<Fit_achieve> findByMonthAndYear(int month, int year);
}
