package com.java016.playfit.serviceimpl;

import java.sql.Date;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import com.java016.playfit.dao.DailyRecordRepository;
import com.java016.playfit.dao.DiaryPhotoRepository;
import com.java016.playfit.dao.FoodRepository;
import com.java016.playfit.dao.MealRepository;
import com.java016.playfit.dao.TimePeriodRepository;
import com.java016.playfit.dao.UserRepository;
import com.java016.playfit.model.DailyRecord;
import com.java016.playfit.model.DiaryPhoto;
import com.java016.playfit.model.FitAchieve;
import com.java016.playfit.model.Food;
import com.java016.playfit.model.Meal;
import com.java016.playfit.model.TimePeriod;
import com.java016.playfit.model.User;
import com.java016.playfit.service.DailyRecordService;
import com.java016.playfit.service.FitAchieveService;
import com.java016.playfit.service.MealService;

@Service
public class DailyRecordServiceImpl implements DailyRecordService  {

	@Autowired
	DailyRecordRepository dailyRecordRepo;
	@PersistenceContext
    private EntityManager entityManager;
	@Autowired
	UserRepository userRepo;
	@Autowired
	MealRepository mealRepo;
	@Autowired
	FoodRepository foodRepo;
	@Autowired
	TimePeriodRepository timePeriodRepo;
	@Autowired
	MealService mealService;
	@Autowired
	FitAchieveService fitAchiveService;
	@Autowired
	DiaryPhotoRepository diaryPhotoRepo;
	
	// 找特定User所有日記紀錄
	@Override
	public List<DailyRecord> findAllByUser(User user) {
		return dailyRecordRepo.findAllByUser(user);
	};

	// 找User日期區間日記紀錄
	@Override
	public List<DailyRecord> findAllDateBetween(Integer userId, Date startDate, Date endDate) {
		return dailyRecordRepo.findByUserIdAndDateBetween(userId, startDate, endDate);
	};

	// 找特定User、日期日記紀錄
	@Override
	public DailyRecord findByUserIdAndDate(Integer userId, Date date) {
		DailyRecord dailyRecord = dailyRecordRepo.findByUserIdAndDate(userId, date);
		return dailyRecord;
	}
	
	// 找特定日期所有日記紀錄
	@Override
	public List<DailyRecord> findByCreatedDate(Date date) {
		return dailyRecordRepo.findByCreatedDate(date);
	}
	
	//以下陳以文
	//以下陳以文
	//以下陳以文
	@Override
	public Page<DailyRecord> getAllDailyRecordByUserAndPage(User user,int pageNumber) {
		Pageable pageable = PageRequest.of(pageNumber-1, 3,Sort.by("createdDate").descending());
		
		return dailyRecordRepo.findAllByUserAndStatus(user, 1, pageable);
	}

	@Override
	public DailyRecord getDailyRecordByUserAndDate(User user, Date date) {
		DailyRecord dailyRecord = dailyRecordRepo.findByUserIdAndDate(user.getId(), date);
		return dailyRecord;
	}

	@Override
	public void saveDailyRecord(DailyRecord dailyRecord) {
		dailyRecordRepo.save(dailyRecord);
		
	}

	@Override
	public DailyRecord getDailyRecordByIdWithUserCheck(int id, String username) {
		DailyRecord dailyRecord = dailyRecordRepo.getById(id);
		
		if(dailyRecord == null) {
			throw new AccessDeniedException("user attempted to access unexisting daily record.");
		}
		
		User user = dailyRecord.getUser();
		if(!user.getEmail().equals(username)) {
			System.out.println(user.getEmail());
			System.out.println(username);
			throw new AccessDeniedException("user attempted to access another user's daily record.");
		}
		
		System.out.println("檢查 getDailyRecordByIdWithUserCheck 成功!!");
		
		return dailyRecord;
	}

	@Override
	public void updateDailyRecordKcalIntake(DailyRecord dailyRecord) {
		int id = dailyRecord.getId();
		entityManager.detach(dailyRecord);
		dailyRecord = dailyRecordRepo.getById(id);
		
		List<Meal> meals = dailyRecord.getMeals();
		int kcal = 0;
		System.out.println("---------------"+dailyRecord.getUser().getEmail());
		System.out.println("---------------"+dailyRecord.getMeals());
		
		if(meals != null) {
			for (Meal meal : meals) {
				System.out.println(meal.getId());
				kcal += meal.getTotalKcal();
			}
		}
		dailyRecord.setKcalIntake(kcal);
		dailyRecordRepo.save(dailyRecord);
	}

	@Override
	public void updateDailyRecordAndMeal(DailyRecord dailyRecord, String[] timePeriodIdsFoodIdsForUpdate,
			String[] mealIdsForDelete, String username) {
		
		if(!dailyRecord.getUser().getEmail().equals(username)) {
			throw new AccessDeniedException("user attempted to modify another user's daily record.");
		}
		
		
		
		
		//LinkedList才支援remove方法,就算Arrays.asList轉成List也不能用remove方法
		List<String> timePeriodIdFoodIdList = new LinkedList<String>(Arrays.asList(timePeriodIdsFoodIdsForUpdate));
		
	
		//如果沒有新增任何用餐紀錄 List裡面會是 ["last"]
		if(timePeriodIdFoodIdList.size() == 1) {
			System.out.println("timePeriodIdFoodIdArray == null");
		}
		//如果有新增任何用餐紀錄 假設新增兩組用餐紀錄 List裡面會是 ["時段id,食物id","時段id,食物id","last"]
		else {
			System.out.println("timePeriodIdFoodIdArray = " + Arrays.toString(timePeriodIdsFoodIdsForUpdate));
			//把List的最後面的元素"last"移除 List裡面會變成 ["時段id,食物id","時段id,食物id"]
			timePeriodIdFoodIdList.remove(timePeriodIdFoodIdList.size()-1);
			//List裡面會是 ["時段id,食物id","時段id,食物id"]
			//循環List 每次抓出一組字串 "時段id,食物id"
			timePeriodIdFoodIdList.forEach(timePeriodIdFoodId -> {
				// 用split "時段id,食物id" 把時段id與食物id分開
				String[] s = timePeriodIdFoodId.split(",");
				//用時段id去資料庫取出時段的Entity
				TimePeriod timePeriod = timePeriodRepo.findById(Integer.parseInt(s[0]));
				//用食物id去資料庫取出食物的Entity
				Food food = foodRepo.findById(Integer.parseInt(s[1]));
				
				//new 用餐紀錄的物件
				//設定時段,設定食物,設定數量
				Meal meal = new Meal();
				meal.setDailyRecord(dailyRecord);
				meal.setFood(food);
				meal.setTimePeriod(timePeriod);
				meal.setQuantity(1);
				// 食物kacal * 數量 = 此次用餐的攝取量
				int totalKcal = (int) (meal.getQuantity()*food.getKcal());
				meal.setTotalKcal(totalKcal);
				//把以上設定存入資料庫
				mealRepo.save(meal);
			});
			
		}
		
		System.out.println("------------Start------------");
		//如果有要刪除飲食紀錄
		if(mealIdsForDelete != null) {
			for (String id: mealIdsForDelete) {  
			    mealService.deleteMeal(Integer.parseInt(id),username);
			}
		}
		System.out.println("------------End------------");
		
	}

	@Override
	public void updateDailyRecordKcalBurned(DailyRecord dailyRecord,FitAchieve fitAchieve) {
		int kcal = dailyRecord.getKcalBurned();
		System.out.println("dailyRecord.getKcalBurned() ============= " + dailyRecord.getKcalBurned());
		kcal += fitAchieve.getTotalKcal();
		dailyRecord.setKcalBurned(kcal);
		dailyRecordRepo.save(dailyRecord);
	}

	@Override
	public boolean isDailyRecordBecomeDairy(DailyRecord dailyRecord) {
		
		boolean isDiary = false;
		//如果今天的日常紀錄Status欄位為1的話，代表此日常紀錄為日記
		if(dailyRecord != null && dailyRecord.getStatus() == 1) {
			
			isDiary = true;

		}
		return isDiary;
	}
	//以上陳以文
	//以上陳以文
	//以上陳以文

	@Override
	public void saveDiaryPhoto(DiaryPhoto diaryPhoto) {
		// TODO Auto-generated method stub
		diaryPhotoRepo.save(diaryPhoto);
	}

	@Override
	public List<DailyRecord> findAllByCreatedYearAndMonthAndStatus(User user, int year, int month, int status) {
		return dailyRecordRepo.findByCreatedYearAndMonthAndStatus(user.getId(), month, year,status);
	}
}













