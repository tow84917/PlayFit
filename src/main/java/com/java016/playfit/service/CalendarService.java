package com.java016.playfit.service;

import java.sql.Date;
import java.text.ParseException;
import java.util.List;

import com.java016.playfit.model.FitAchieve;
import com.java016.playfit.model.FitActivity;
import com.java016.playfit.model.MonthlyRecord;

public interface CalendarService {

	public byte[] findImage(int id);
//	public int[] findMonthlyFitDays(int month, int year);
	public List<Integer> findMonthlyFitDays(int month, int year);
	public MonthlyRecord findByUserIdAndMonthly(int monthly, int year);

    List<FitAchieve> findByCreatedDate(Date date);

    List<Integer> findUserMonthlyFitDays(int month, int year);

    List<FitActivity> findActivities(String bodyPartSelect);

    void addActivities( String day, List<String> activities) throws ParseException;
}
