package com.java016.playfit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Timestamp;
import java.util.Date;

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
@Table(name="fit_achieve")
public class FitAchieve {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="execution_date")
	@Temporal(TemporalType.DATE)
	private Date executionDate;
	
	@Column(name="end_time")
	private Timestamp endTime;
	
	@Column(name="created_at", 
			nullable=false, 
			updatable=false, 
			insertable=false, 
			columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	
	private Timestamp createdAt;
	
	private String status;

	@Column(name="number_groups")
	private Integer numberGroups;

	@Column(name="total_kcal")
	private Integer totalKcal;

	//bi-directional many-to-one association to DailyRecord
	@ManyToOne
	@JoinColumn(name="daily_record_id")
	private DailyRecord dailyRecord;

	//bi-directional many-to-one association to FitActivity
	@ManyToOne
	@JoinColumn(name="fit_activity_id")
	private FitActivity fitActivity;

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("FitAchieve{");
		sb.append("id=").append(id);
		sb.append(", executionDate=").append(executionDate);
		sb.append(", endTime=").append(endTime);
		sb.append(", createdAt=").append(createdAt);
		sb.append(", status='").append(status).append('\'');
		sb.append(", numberGroups=").append(numberGroups);
		sb.append(", totalKcal=").append(totalKcal);
		sb.append(", dailyRecord=").append(dailyRecord.getId());
		sb.append(", fitActivity=").append(fitActivity);
		sb.append('}');
		return sb.toString();
	}

	public FitAchieve() {
	}

	public FitAchieve(String status, Integer numberGroups, Integer totalKcal, DailyRecord dailyRecord, FitActivity fitActivity) {
		this.status = status;
		this.numberGroups = numberGroups;
		this.totalKcal = totalKcal;
		this.dailyRecord = dailyRecord;
		this.fitActivity = fitActivity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getExecutionDate() {
		return executionDate;
	}

	public void setExecutionDate(Date executionDate) {
		this.executionDate = executionDate;
	}

	public Timestamp getEndTime() {
		return endTime;
	}

	public void setEndTime(Timestamp endTime) {
		this.endTime = endTime;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Integer getNumberGroups() {
		return numberGroups;
	}

	public void setNumberGroups(Integer numberGroups) {
		this.numberGroups = numberGroups;
	}

	public Integer getTotalKcal() {
		return totalKcal;
	}

	public void setTotalKcal(Integer totalKcal) {
		this.totalKcal = totalKcal;
	}
	@JsonIgnore
	public DailyRecord getDailyRecord() {
		return dailyRecord;
	}
	@JsonIgnore
	public void setDailyRecord(DailyRecord dailyRecord) {
		this.dailyRecord = dailyRecord;
	}

	public FitActivity getFitActivity() {
		return fitActivity;
	}

	public void setFitActivity(FitActivity fitActivity) {
		this.fitActivity = fitActivity;
	}
}
