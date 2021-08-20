package com.java016.playfit.tool;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.java016.playfit.model.HealthRecord;
import com.java016.playfit.model.User;

@Component
public class BodyCalculator {
	
	/**
	 * lackHealthRecord to completeHealthRecord.
	 * @param healthRecord
	 * @param user
	 * @return healthRecord
	 */
	public HealthRecord calAll(HealthRecord healthRecord, User user) {
		//User column
		String gender = user.getGender();
		Date birthday = user.getBirthday();
		
		int age = calAge(birthday);
		healthRecord.setAge(age);
		
		double BMI = calBMI(healthRecord);
		healthRecord.setBMI(BMI);
		
		double BMR = calBMR(healthRecord, gender);
		healthRecord.setBMR(BMR);
		
		double BFP = calBFP(healthRecord, gender, BMI);
		healthRecord.setBFP(BFP);
		
		double TDEE = calTDEE(healthRecord, BMR);
		healthRecord.setTDEE(TDEE);
		
		double FFMI = calFFMI(healthRecord, BFP);
		healthRecord.setFFMI(FFMI);
		
		return healthRecord ;
	}
	
	/**
	 * 
	 * @param healthRecord
	 * @return BMI
	 */
	public double calBMI(HealthRecord healthRecord) {
		double BMI = healthRecord.getWeight() / 
				Math.pow(healthRecord.getHeight()/100.0, 2);
		return roundTwoDecimal(BMI) ;
	}
	
	/**
	 * 
	 * @param healthRecord
	 * @return BMR
	 */
	public double calBMR(HealthRecord healthRecord, String gender) {
		double BMR = 0 ;
		double height = healthRecord.getHeight();
		double weight = healthRecord.getWeight();
		double age = healthRecord.getAge() ;
		
		if (gender.equalsIgnoreCase("Male")) 
			BMR = 66 + (13.7 * weight) + (5 * height) - (6.8 * age); 
		else if(gender.equalsIgnoreCase("Female"))
			BMR = 665 + (9.6 * weight) + (1.8 * height) - (4.7 * age) ; 
		
		return roundTwoDecimal(BMR);
	}
	
	/**
	 * 
	 * @param healthRecord
	 * @param gender
	 * @param BMI
	 * @return BFP
	 */
	public double calBFP(HealthRecord healthRecord, String gender, double BMI) {
		double BFP = 0 ;
		double age = healthRecord.getAge() ;
		
		if (gender.equalsIgnoreCase("Male")) 
			BFP = (1.2 * BMI) + (0.23 * age) - 5.4 - 10.8 * 1;
		else if(gender.equalsIgnoreCase("Female"))
			BFP = (1.2 * BMI) + (0.23 * age) - 5.4 - 10.8 * 0;
		
		return roundTwoDecimal(BFP);
	}
	
	/**
	 * 
	 * @param healthRecord
	 * @param BFP
	 * @return FFMI
	 */
	public double calFFMI(HealthRecord healthRecord, double BFP) {
		double FFMI = 0 ;
		double height = healthRecord.getHeight();
		double weight = healthRecord.getWeight() ;
		
		FFMI = weight * ((100 - BFP) / 100.0) / Math.pow(height / 100.0, 2);
		
		return roundTwoDecimal(FFMI);
	}
	
	/**
	 * 
	 * @param healthRecord
	 * @param BMR
	 * @return TDEE
	 */
	public double calTDEE(HealthRecord healthRecord, double BMR) {
		double TDEE = 0 ;
		String exerciseFrequency = healthRecord.getExerciseFrequency();
		
		if(exerciseFrequency.equalsIgnoreCase("Sedentary")){
	        TDEE = BMR * 1.2 ;
	    }
	    if(exerciseFrequency.equalsIgnoreCase("LightExercise")){
	        TDEE = BMR * 1.4 ;
	    }
	    if(exerciseFrequency.equalsIgnoreCase("ModerateExercise")){
	        TDEE = BMR * 1.6 ;
	    }
	    if(exerciseFrequency.equalsIgnoreCase("HeavyExercise")){
	        TDEE = BMR * 1.8 ;
	    }
	    if(exerciseFrequency.equalsIgnoreCase("Athlete")){
	        TDEE = BMR * 2 ;
	    }
	    return roundTwoDecimal(TDEE);
	}
	
	/**
	 * 
	 * @param birthday
	 * @return age
	 */
	public int calAge(Date birthday) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date today = new Date();
		int age = 0 ;
		
		// 轉換年月日 數字List
		List<String> tsl =  Arrays.asList(sdf.format(today).split("-")) ;
		List<Integer> til = tsl.stream().map(s -> Integer.parseInt(s))
				.collect(Collectors.toList());
		
		List<String> bsl =  Arrays.asList(sdf.format(birthday).split("-")) ;
		List<Integer> bil = bsl.stream().map(s -> Integer.parseInt(s))
				.collect(Collectors.toList());
		
		// 年份相減
		age = til.get(0) - bil.get(0);
		// 月日小於生日歲數減1
		if (til.get(1) < bil.get(1) && til.get(2) < bil.get(2)) {
			age -= 1 ;
		}		
		return age;
	}
	
	/**
	 * 
	 * @param number
	 * @return TwoDecimal
	 */
	public double roundTwoDecimal(double number) {
		return Math.round(number * 100)/100.0;
	}
}






















