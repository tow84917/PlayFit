package com.java016.playfit.service;

import com.java016.playfit.model.Monthly_record;

import java.util.ArrayList;
import java.util.List;

public interface CalendarService {

	public byte[] findImage(int id);
//	public int[] findMonthlyFitDays(int month, int year);
	public List<Integer> findMonthlyFitDays(int month, int year);
	public Monthly_record findByUser_idAndMonthly(int user_id, int monthly, int year);

}
