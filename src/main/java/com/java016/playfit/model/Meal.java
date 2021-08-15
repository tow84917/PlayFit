package com.java016.playfit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Meal {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	private Integer quantity;

	@Column(name="total_kcal")
	private Integer totalKcal;

	//bi-directional many-to-one association to DailyRecord
	@ManyToOne
	@JoinColumn(name="daily_record_id")
	private DailyRecord dailyRecord;

	//bi-directional many-to-one association to Food
	@ManyToOne
	private Food food;

	//bi-directional many-to-one association to TimePeriod
	@ManyToOne
	@JoinColumn(name="time_period_id")
	private TimePeriod timePeriod;

	public Meal() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getTotalKcal() {
		return totalKcal;
	}

	public void setTotalKcal(Integer totalKcal) {
		this.totalKcal = totalKcal;
	}

	public DailyRecord getDailyRecord() {
		return dailyRecord;
	}

	public void setDailyRecord(DailyRecord dailyRecord) {
		this.dailyRecord = dailyRecord;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public TimePeriod getTimePeriod() {
		return timePeriod;
	}

	public void setTimePeriod(TimePeriod timePeriod) {
		this.timePeriod = timePeriod;
	}
	
	
}
