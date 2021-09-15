package com.java016.playfit.service;

import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.java016.playfit.model.DailyRecord;
import com.java016.playfit.model.FitAchieve;
import com.java016.playfit.model.FitActivity;
import com.java016.playfit.model.User;

public interface MemberService {

	/**
	 * 會員頁日期表示法
	 * @return String
	 */
	String getFormatMemberPageDate();

	/**
	 * 任務項目完成 % 數
	 * @param todayRecord
	 * @return Double
	 */
	Double getTaskCompletionRate(DailyRecord todayRecord);
	
	/**
	 * 取今日運動項目訂單及實際動作
	 * @param todayRecord
	 * @return LinkedHashMap<FitActivity, String>
	 */
	LinkedHashMap<FitAchieve, FitActivity> getTodayAchieveAndActivity(DailyRecord todayRecord); 
	
	/**
	 * 取得今日所有運動項目
	 * @param todayRecord
	 * @return List<FitActivity>
	 */
	List<FitActivity> getTodayActivity(DailyRecord todayRecord);
	
	/**
	 * 算兩日期差幾天
	 * @param dateStart
	 * @param dateEnd
	 * @return Integer
	 */
	Integer getDiscrepantDays(Date dateStart, Date dateEnd);
	
	/**
	 * response 自訂格式化
	 * @param day
	 * @param kcal
	 * @return String[]
	 */
	String[] getFormatDataForResponse(String day, Integer kcal);

	/**
	 * 回傳日期區間運動卡洛里資料
	 * @param user
	 * @return Map<Integer, String[]>
	 */
	Map<Integer, String[]> getWeekExerciseData(User user);

}












