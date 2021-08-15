package com.java016.playfit.serviceimpl;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java016.playfit.dao.DailyRecordRepository;
import com.java016.playfit.model.DailyRecord;
import com.java016.playfit.model.FitAchieve;
import com.java016.playfit.model.FitActivity;
import com.java016.playfit.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	DailyRecordRepository dailyRecordRepo;
	
	// 會員頁日期表示法
	@Override
	public String getFormatMemberPageDate() {
		java.util.Date utilDate = new java.util.Date();
		String weekDay = utilDate.toString().split(" ")[0];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String today = sdf.format(utilDate) + " " + weekDay + " ." ;
		return today;
	}
	
	// 任務項目完成 % 數
	@Override
	public Double taskCompletionRate(DailyRecord todayRecord) {
		double completionRate = 0;
		List<FitAchieve> achieves = todayRecord.getFitAchieves();

		int taskNum = achieves.size();
		int completeNum = taskNum;

		for (FitAchieve achieve : achieves) {
			if (achieve.getStatus().equals("未執行")) {
				completeNum--;
			}
		}

		completionRate = 100 / taskNum * completeNum;
		return Math.round(completionRate * 10) / 10.0;
	}

	// 取今日運動項目及完成狀態
	@Override
	public LinkedHashMap<FitActivity, String> getTodayActivityAndStatus(DailyRecord todayRecord) {
		List<FitAchieve> achieves = todayRecord.getFitAchieves();
		LinkedHashMap<FitActivity, String> activityStatus = new LinkedHashMap<FitActivity, String>();
		// 未完成List
		List<FitActivity> unDoneActivity = new LinkedList<FitActivity>();
		// 按順序排列
		// 先加入完成項目
		for (FitAchieve achieve : achieves) {

			String status = achieve.getStatus();

			if (!(status.equals("未執行"))) {
				activityStatus.put(achieve.getFitActivity(), "done");
			}
			if (status.equals("未執行")) {
				unDoneActivity.add(achieve.getFitActivity());
			}
		}
		// 最後加入未完成
		for (FitActivity activity : unDoneActivity) {
			activityStatus.put(activity, "undone");
		}

		return activityStatus;
	}

	// 取得今日所有運動項目
	@Override
	public List<FitActivity> getTodayActivity(DailyRecord todayRecord) {
		List<FitAchieve> achieves = todayRecord.getFitAchieves();
		List<FitActivity> activitys = new LinkedList<FitActivity>();

		for (FitAchieve achieve : achieves) {
			activitys.add(achieve.getFitActivity());
		}
		return activitys;
	}

	// response 自訂格式化
	@Override
	public String[] formatDataForResponse(String day, Integer kcal) {
		return new String[] { day.replaceAll("-", "/").substring(5), String.valueOf(kcal) };
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

		// 取資料庫區間資料
		List<DailyRecord> dailys = dailyRecordRepo.findByUserIdAndDateBetween(userId, startDate, endDate);

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
				String dayCheck = String.valueOf(dr.getCreatedDate());
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
