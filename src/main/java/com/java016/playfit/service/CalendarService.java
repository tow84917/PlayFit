package com.java016.playfit.service;

import com.java016.playfit.model.MonthlyRecord;

import java.util.List;

public interface CalendarService {

	public byte[] findImage(int id);
//	public int[] findMonthlyFitDays(int month, int year);
	public List<Integer> findMonthlyFitDays(int month, int year);
	public MonthlyRecord findByUser_idAndMonthly(int user_id, int monthly, int year);

}
