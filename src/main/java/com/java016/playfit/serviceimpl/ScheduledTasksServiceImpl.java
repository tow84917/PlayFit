package com.java016.playfit.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.java016.playfit.model.DailyRecord;
import com.java016.playfit.model.HealthRecord;
import com.java016.playfit.model.User;
import com.java016.playfit.service.DailyRecordService;
import com.java016.playfit.service.HealthRecordService;
import com.java016.playfit.service.ScheduledTasksService;
import com.java016.playfit.service.UserService;
import com.java016.playfit.tool.BodyCalculator;

@Service
public class ScheduledTasksServiceImpl implements ScheduledTasksService {

	@Autowired
	DailyRecordService dailyRecordService;

	@Autowired
	HealthRecordService healthRecordService;

	@Autowired
	UserService userService;

	@Autowired
	BodyCalculator bodyCalculator;

	@Override
	@Scheduled(cron = "10 06 17 * * ?") // 指定時間執行 0時(24)
	public void upadteCalorieDeficit() {

		long now = System.currentTimeMillis();
		int dayMillis = 86400000;

		// 昨天的日期 util
		java.util.Date utilYestoday = new java.util.Date(now - dayMillis);
		// 把日期轉成SQL型態的Date
		java.sql.Date sqlYestoday = new java.sql.Date(utilYestoday.getTime());

		System.out.println(sqlYestoday);

		// 找昨天所有紀錄
		List<DailyRecord> dailyRecords = dailyRecordService.findByCreatedDate(sqlYestoday);

//		dailyRecords.forEach(d -> {
//			System.out.println(d.getUser().getId() + " : " 
//							 + d.getKcalBurned()   + " : " 
//							 + d.getKcalIntake()
//							 );
//		});

		for (DailyRecord dr : dailyRecords) {
			// 此紀錄主人
			User tempDrUser = dr.getUser();
			
			// 找 User "最近"健康紀錄
			HealthRecord healthRecordLast = 
					healthRecordService.findLastDateByUserId(tempDrUser.getId());
			// 昨日熱量赤字
			double calorieDeficitYestoday = 
					bodyCalculator.calCalorieDeficit(healthRecordLast, dr);
			
			// 更新後的熱量赤字
			double calorieDeficitUpdated = 
					healthRecordLast.getCalorieDeficit() + calorieDeficitYestoday ;
//			System.out.println(healthRecordLastUpdated.getCalorieDeficit());
			
			// 達成"減"一公斤
			if (calorieDeficitUpdated <= -7700) {
				// 找user 昨天是否有紀錄
				HealthRecord healthRecordYestoday = 
						healthRecordService.findByUserIdAndDate(tempDrUser.getId(),
						sqlYestoday);
				// 無紀錄則創建
				if (healthRecordYestoday == null) {
					healthRecordService.createNewRecord(
							healthRecordLast, tempDrUser, sqlYestoday);
					// 再取昨天紀錄(剛創好的)
					HealthRecord healthRecordYestodayNew = 
							healthRecordService.findByUserIdAndDate(tempDrUser.getId(),
							sqlYestoday);
					// 消除熱量赤字 7700
					healthRecordYestodayNew.setCalorieDeficit(calorieDeficitUpdated + 7700);
					// 減一公斤
					healthRecordYestodayNew.setWeight(
							healthRecordYestodayNew.getWeight() - 1);
					// 更新紀錄並儲存
					healthRecordService.updateHealthRecord(tempDrUser, healthRecordYestodayNew);
				}

				// 有紀錄則更新
				if (healthRecordYestoday != null) {
					// 消除熱量赤字 7700
					healthRecordYestoday.setCalorieDeficit(calorieDeficitUpdated + 7700);
					// 減一公斤
					healthRecordYestoday.setWeight(healthRecordYestoday.getWeight() - 1);
					healthRecordService.updateHealthRecord(tempDrUser, healthRecordYestoday);
				}
			}

			// 達成"加"一公斤
			if (calorieDeficitUpdated >= 7700) {
				// 找user 昨天是否有紀錄
				HealthRecord healthRecordYestoday = 
						healthRecordService.findByUserIdAndDate(tempDrUser.getId(),
						sqlYestoday);
				// 無紀錄則創建
				if (healthRecordYestoday == null) {
					healthRecordService.createNewRecord(
							healthRecordLast, tempDrUser, sqlYestoday);
					// 再取昨天紀錄(剛創好的)
					HealthRecord healthRecordYestodayNew = 
							healthRecordService.findByUserIdAndDate(tempDrUser.getId(),
							sqlYestoday);
					// 消除熱量赤字 7700
					healthRecordYestodayNew.setCalorieDeficit(calorieDeficitUpdated - 7700);
					// 減一公斤
					healthRecordYestodayNew.setWeight(healthRecordYestodayNew.getWeight() + 1);
					// 更新紀錄並儲存
					healthRecordService.updateHealthRecord(tempDrUser, healthRecordYestodayNew);
				}

				// 有紀錄則更新
				if (healthRecordYestoday != null) {
					// 消除熱量赤字 7700
					healthRecordYestoday.setCalorieDeficit(calorieDeficitUpdated - 7700);
					// 減一公斤
					healthRecordYestoday.setWeight(healthRecordYestoday.getWeight() + 1);
					healthRecordService.updateHealthRecord(tempDrUser, healthRecordYestoday);
				}
			}
			
			// 未達熱量赤字增減值
			if (calorieDeficitUpdated > -7700 && calorieDeficitUpdated < 7700) {
				// 更新最近健康紀錄內熱量赤字
				healthRecordService.updateCalorieDeficit(healthRecordLast.getId(),
						healthRecordLast.getCalorieDeficit() + calorieDeficitYestoday);				
			}
		}

	}
}









