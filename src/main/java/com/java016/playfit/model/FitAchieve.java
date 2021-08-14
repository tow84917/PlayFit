package com.java016.playfit.model;

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
    private FitActivity fit_activity;

    @ManyToOne
    @JoinColumn(name = "daily_record_id")
    private DailyRecord daily_record;

    private int number_groups;

    private int total_kcal;

//    @Column(name = "execution_date",  nullable = false)
//    @Basic
//    @Column
//    @Temporal(TemporalType.DATE)
    @Convert(converter = LocalDateCalendarAttributeConverter.class)
    private Calendar execution_date;

//    @Column(name = "local_date", columnDefinition = "DATE")
//    private LocalDate execution_date;

//    private Date execution_date;

    private Date end_time;

    private Timestamp created_at;

    private String status; // 直接執行  按計畫執行  未執行

    public FitAchieve(FitActivity fit_activity, DailyRecord daily_record, int number_groups, int total_kcal, Calendar execution_date, Date end_time, Timestamp created_at, String status) {

        this.fit_activity = fit_activity;
        this.daily_record = daily_record;
        this.number_groups = number_groups;
        this.total_kcal = total_kcal;
        this.execution_date = execution_date;
        this.end_time = end_time;
        this.created_at = created_at;
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

    public FitActivity getFit_activity() {
        return fit_activity;
    }

    public void setFit_activity(FitActivity fit_activity) {
        this.fit_activity = fit_activity;
    }

    public DailyRecord getDaily_record() {
        return daily_record;
    }

    public void setDaily_record(DailyRecord daily_record) {
        this.daily_record = daily_record;
    }

    public int getNumber_groups() {
        return number_groups;
    }

    public void setNumber_groups(int number_groups) {
        this.number_groups = number_groups;
    }

    public int getTotal_kcal() {
        return total_kcal;
    }

    public void setTotal_kcal(int total_kcal) {
        this.total_kcal = total_kcal;
    }

    public Calendar getExecution_date() {
        return execution_date;
    }

    public void setExecution_date(Calendar execution_date) {
        this.execution_date = execution_date;
    }

    public Date getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Date end_time) {
        this.end_time = end_time;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
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
		builder.append(fit_activity.getName());
		builder.append(", daily_record=");
		builder.append(daily_record.getId());
		builder.append(", number_groups=");
		builder.append(number_groups);
		builder.append(", total_kcal=");
		builder.append(total_kcal);
		builder.append(", execution_date=");
		builder.append(execution_date);
		builder.append(", end_time=");
		builder.append(end_time);
		builder.append(", created_at=");
		builder.append(created_at);
		builder.append(", status=");
		builder.append(status);
		builder.append("]");
		return builder.toString();
	}
    
}
