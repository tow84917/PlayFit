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
import com.java016.playfit.dao.HealthRecordRepository;
import com.java016.playfit.dao.UserRepository;
import com.java016.playfit.model.DailyRecord;
import com.java016.playfit.model.FitAchieve;
import com.java016.playfit.model.FitActivity;
import com.java016.playfit.model.User;
import com.java016.playfit.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	DailyRecordRepository dailyRecordRepo;

	@Autowired
	UserRepository userRepo;

	@Autowired
	HealthRecordRepository healthRecordRepo;

	/**
	 * 會員頁日期表示法
	 * 
	 * @return String
	 */
	@Override
	public String getFormatMemberPageDate() {
		java.util.Date utilDate = new java.util.Date();
		String weekDay = utilDate.toString().split(" ")[0];
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		String today = sdf.format(utilDate) + " " + weekDay + ".";
		return today;
	}

	/**
	 * 任務項目完成 % 數
	 * 
	 * @param todayRecord
	 * @return Double
	 */
	@Override
	public Double getTaskCompletionRate(DailyRecord todayRecord) {
		double completionRate = 0;
		List<FitAchieve> achieves = todayRecord.getFitAchieves();

		int taskNum = achieves.size();
		int completeNum = taskNum;

		if (taskNum == 0) {
			return 0.0;
		}

		for (FitAchieve achieve : achieves) {
			if (achieve.getStatus().equals("未執行")) {
				completeNum--;
			}
		}

		completionRate = 100.0 / taskNum * completeNum; // 100.0 注意 Double 修正 
		return Math.round(completionRate * 10) / 10.0;
	}
	
	/**
	 * 取今日運動項目訂單及實際動作
	 * @param todayRecord
	 * @return LinkedHashMap<FitActivity, String>
	 */
	public LinkedHashMap<FitAchieve, FitActivity> getTodayAchieveAndActivity(
			DailyRecord todayRecord) {
		
		// 今日所有運動項目訂單
		List<FitAchieve> achieves = todayRecord.getFitAchieves();
		
		// 要回傳Map
		LinkedHashMap<FitAchieve, FitActivity> achievesAndActivities = 
				new LinkedHashMap<FitAchieve, FitActivity>();
		
		// 未完成Map
		LinkedHashMap<FitAchieve, FitActivity> undoneActivity = 
				new LinkedHashMap<FitAchieve, FitActivity>();
		
		// 按順序排列
		// 先加入完成項目
		for (FitAchieve achieve : achieves) {

			String status = achieve.getStatus();

			if (!(status.equals("未執行"))) {
				achievesAndActivities.put(achieve, achieve.getFitActivity());
			}
			if (status.equals("未執行")) {
				undoneActivity.put(achieve, achieve.getFitActivity());
			}
		}
		
		// 最後加入未完成
		for (Map.Entry<FitAchieve, FitActivity> entry : undoneActivity.entrySet()) {
			achievesAndActivities.put(entry.getKey(), entry.getValue());
		}

		return achievesAndActivities;
	}

	/**
	 * 取得今日所有運動項目
	 * 
	 * @param todayRecord
	 * @return List<FitActivity>
	 */
	@Override
	public List<FitActivity> getTodayActivity(DailyRecord todayRecord) {
		
		List<FitAchieve> achieves = todayRecord.getFitAchieves();
		List<FitActivity> activitys = new LinkedList<FitActivity>();

		for (FitAchieve achieve : achieves) {
			activitys.add(achieve.getFitActivity());
		}
		
		return activitys;
	}

	/**
	 * 算某日到某日差幾天
	 * 
	 * @param dateStart
	 * @param dateEnd
	 * @return Integer
	 */
	public Integer getDiscrepantDays(Date dateStart, Date dateEnd) {
		return (int) ((dateEnd.getTime() - dateStart.getTime()) / 1000 / 60 / 60 / 24) ;
	}

	/**
	 * response 自訂格式化
	 * 
	 * @param day
	 * @param kcal
	 * @return String[]
	 */
	@Override
	public String[] getFormatDataForResponse(String day, Integer kcal) {
		return new String[] { day.replaceAll("-", "/").substring(5), String.valueOf(kcal) };
	}

	/**
	 * 回傳日期區間運動卡洛里資料
	 * 
	 * @param user
	 * @return Map<Integer, String[]>
	 */
	@Override
	public Map<Integer, String[]> getWeekExerciseData(User user) {
		
		// 一周區間為已註冊日為基準每七天為一個區間
		
		long now = System.currentTimeMillis();
		long dayMillis = 86400 * 1000;

		// 註冊日
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date registerDate = Date.valueOf(sdf.format(user.getCreatedAt()));
		
		// 今天的日期
		java.util.Date utilDate = new java.util.Date();
		// 把日期轉成SQL型態的Date
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		// 相差天數
		int discrepantDays = getDiscrepantDays(registerDate, sqlDate);
//		System.out.println(discrepantDays);
		
		// 區間定位
		int weekPos = discrepantDays % 7 ;
		
		// 日期區間
		Date startDate = new Date(now - weekPos * dayMillis); 
//		System.out.println(startDate);
		Date endDate = new Date(now + (7 - weekPos) * dayMillis);
//		System.out.println(endDate);

		// 取資料庫區間資料
		List<DailyRecord> dailys = 
				dailyRecordRepo.findByUserIdAndDateBetween(user.getId(), startDate, endDate);

		// For response and check date
		String[] days = new String[7];
		for (int i = 0; i < days.length; i++) {
			days[i] = String.valueOf(new Date(startDate.getTime() + dayMillis * i));
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
					exerciseData.put(count, getFormatDataForResponse(day, dr.getKcalBurned()));
					count++;
					isData = true;
					break;
				}
			}
			// 沒有則加入 0 => 長條圖空
			if (!isData) {
				exerciseData.put(count, getFormatDataForResponse(day, 0));
				count++;
			}
		}
		return exerciseData;
	}

}










