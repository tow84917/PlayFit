package com.java016.playfit.service;

import com.java016.playfit.model.FitAchieve;
import com.java016.playfit.model.MonthlyRecord;

import java.sql.Date;
import java.util.List;
import java.util.Set;

public interface CalendarService {

	public byte[] findImage(int id);
//	public int[] findMonthlyFitDays(int month, int year);
	public List<Integer> findMonthlyFitDays(int month, int year);
	public MonthlyRecord findByUserIdAndMonthly(int monthly, int year);

    List<FitAchieve> findByCreatedDate(Date date);

    Set<Integer> findUserMonthlyFitDays(int month, int year);
}
