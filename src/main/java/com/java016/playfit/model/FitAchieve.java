package com.java016.playfit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.java016.playfit.converter.LocalDateCalendarAttributeConverter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

@Entity
@Table(name = "Fit_achieve")
public class FitAchieve {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "fit_activity_id")
    private FitActivity fitActivity;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "daily_record_id")
    private DailyRecord dailyRecord;

    @Column(name = "number_groups")
    private int numberGroups;

    @Column(name = "total_kcal")
    private int totalKcal;

    @Column(name = "execution_date")
    @Convert(converter = LocalDateCalendarAttributeConverter.class)
    private Calendar executionDate;

    @Column(name = "end_time")
    private Date endTime;

    @Column(name = "created_at")
    private Timestamp createdAt;

    private String status; // 直接執行  按計畫執行  未執行

    public FitAchieve(FitActivity fitActivity, DailyRecord dailyRecord, int numberGroups, int totalKcal, Calendar executionDate, Date endTime, Timestamp createdAt, String status) {

        this.fitActivity = fitActivity;
        this.dailyRecord = dailyRecord;
        this.numberGroups = numberGroups;
        this.totalKcal = totalKcal;
        this.executionDate = executionDate;
        this.endTime = endTime;
        this.createdAt = createdAt;
        this.status = status;
    }

    public FitAchieve() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public FitActivity getFitActivity() {
        return fitActivity;
    }

    public void setFitActivity(FitActivity fit_activity) {
        this.fitActivity = fit_activity;
    }
    @JsonIgnore
    public DailyRecord getDailyRecord() {
        return dailyRecord;
    }
    @JsonIgnore
    public void setDailyRecord(DailyRecord daily_record) {
        this.dailyRecord = daily_record;
    }

    public int getNumberGroups() {
        return numberGroups;
    }

    public void setNumberGroups(int number_groups) {
        this.numberGroups = number_groups;
    }

    public int getTotalKcal() {
        return totalKcal;
    }

    public void setTotalKcal(int total_kcal) {
        this.totalKcal = total_kcal;
    }

    public Calendar getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(Calendar execution_date) {
        this.executionDate = execution_date;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date end_time) {
        this.endTime = end_time;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp created_at) {
        this.createdAt = created_at;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Fit_achieve [id=");
		builder.append(id);
		builder.append(", fit_activity=");
		builder.append(fitActivity.getName());
		builder.append(", daily_record=");
		builder.append(dailyRecord.getId());
		builder.append(", number_groups=");
		builder.append(numberGroups);
		builder.append(", total_kcal=");
		builder.append(totalKcal);
		builder.append(", execution_date=");
		builder.append(executionDate);
		builder.append(", end_time=");
		builder.append(endTime);
		builder.append(", created_at=");
		builder.append(createdAt);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
    
}
