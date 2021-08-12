package com.java016.playfit.serviceimpl;

import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java016.playfit.dao.DailyRecordRepository;
import com.java016.playfit.model.DailyRecord;
import com.java016.playfit.service.DailyRecordService;

@Service
public class DailyRecordServiceImpl implements DailyRecordService {

	@Autowired
	DailyRecordRepository dailyRecordRepo;

	// 找特定User所有日記紀錄
	@Override
	public List<DailyRecord> findByUserId(Integer userId) {
		return dailyRecordRepo.findByUserId(userId);
	};

	// 找User日期區間日記紀錄
	@Override
	public List<DailyRecord> findAllDateBetween(Integer userId, Date startDate, Date endDate) {
		return dailyRecordRepo.findAllDateBetween(userId, startDate, endDate);
	};

	// response 自訂格式化
	@Override
	public String[] formatDataForResponse(String day, Integer kcal) {
		return new String[] { day.replaceAll("-", "/").substring(5), String.valueOf(kcal)};
	}

	// 回傳日期區間運動卡洛里資料(*之後會變更區間)
	@Override
	public Map<Integer, String[]> weekExerciseData(Integer userId) {

		long now = System.currentTimeMillis();
		long weekMillis = 86400 * 7 * 1000;
		long dayMillis = 86400 * 1000;

		// 日期區間
		Date startDate = new Date(now);
		Date endDate = new Date(now + weekMillis);

		// 取資料庫區間資料(*先找1號之後改)
		List<DailyRecord> dailys = findAllDateBetween(userId, startDate, endDate);

		// For response and check date
		String[] days = new String[7];
		for (int i = 0; i < days.length; i++) {
			days[i] = String.valueOf(new Date(now + dayMillis * i));
		}

		// 核對資料 並加入 Json
		int count = 0;
		boolean isData = false;
		Map<Integer, String[]> exerciseData = new LinkedHashMap<Integer, String[]>();
		for (String day : days) {
			// 比對有無資料
			isData = false; // reset
			for (DailyRecord dr : dailys) {
				String dayCheck = String.valueOf(dr.getDate());
				if (day.equals(dayCheck)) {
					exerciseData.put(count, formatDataForResponse(day, dr.getKcalBurned()));
					count++;
					isData = true;
					break;
				}
			}
			// 沒有則加入 0 => 長條圖空
			if (!isData) {
				exerciseData.put(count, formatDataForResponse(day, 0));
				count++;
			}
		}
		return exerciseData;
	}
}













