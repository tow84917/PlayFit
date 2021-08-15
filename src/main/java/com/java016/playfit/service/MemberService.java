package com.java016.playfit.service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.java016.playfit.model.DailyRecord;
import com.java016.playfit.model.FitActivity;

public interface MemberService {

	// 會員頁日期表示法
	String getFormatMemberPageDate();

	// 任務項目完成 % 數
	Double taskCompletionRate(DailyRecord todayRecord);

	// 取今日運動項目及完成狀態
	LinkedHashMap<FitActivity, String> getTodayActivityAndStatus(DailyRecord todayRecord);

	// 取得今日所有運動項目
	List<FitActivity> getTodayActivity(DailyRecord todayRecord);

	// response 自訂格式化
	String[] formatDataForResponse(String day, Integer kcal);

	// 回傳日期區間運動卡洛里資料(*之後會變更區間)
	Map<Integer, String[]> weekExerciseData(Integer userId);

}