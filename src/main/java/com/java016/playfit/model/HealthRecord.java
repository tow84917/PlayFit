package com.java016.playfit.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Health_Record")
public class HealthRecord {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;

	private Integer age;

	private Double height;
	
	private Double weight;
	
	private Double BMI;
	
	private Double BMR;
	
	private Double BFP;
	
	private Double TDEE;
	
	private Double FFMI;
	
	@Column(name="calorie_deficit")
	private Integer calorieDeficit;
	
	@Column(name="exercise_frequency")
	private String exerciseFrequency;
	
	@Temporal(TemporalType.DATE)
	private Date date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	public Double getWeight() {
		return weight;
	}

	public void setWeight(Double weight) {
		this.weight = weight;
	}

	public Double getBMI() {
		return BMI;
	}

	public void setBMI(Double bMI) {
		BMI = bMI;
	}

	public Double getBMR() {
		return BMR;
	}

	public void setBMR(Double bMR) {
		BMR = bMR;
	}

	public Double getBFP() {
		return BFP;
	}

	public void setBFP(Double bFP) {
		BFP = bFP;
	}

	public Double getTDEE() {
		return TDEE;
	}

	public void setTDEE(Double tDEE) {
		TDEE = tDEE;
	}

	public Double getFFMI() {
		return FFMI;
	}

	public void setFFMI(Double fFMI) {
		FFMI = fFMI;
	}

	public String getExerciseFrequency() {
		return exerciseFrequency;
	}

	public void setExerciseFrequency(String exerciseFrequency) {
		this.exerciseFrequency = exerciseFrequency;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getCalorieDeficit() {
		return calorieDeficit;
	}

	public void setCalorieDeficit(Integer calorieDeficit) {
		this.calorieDeficit = calorieDeficit;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HealthRecord [id=");
		builder.append(id);
		builder.append(", user=");
		builder.append(user.getFullName());
		builder.append(", age=");
		builder.append(age);
		builder.append(", height=");
		builder.append(height);
		builder.append(", weight=");
		builder.append(weight);
		builder.append(", BMI=");
		builder.append(BMI);
		builder.append(", BMR=");
		builder.append(BMR);
		builder.append(", BFP=");
		builder.append(BFP);
		builder.append(", TDEE=");
		builder.append(TDEE);
		builder.append(", FFMI=");
		builder.append(FFMI);
		builder.append(", calorieDeficit=");
		builder.append(calorieDeficit);
		builder.append(", exerciseFrequency=");
		builder.append(exerciseFrequency);
		builder.append(", date=");
		builder.append(date);
		builder.append("]");
		return builder.toString();
	}
	
}
















