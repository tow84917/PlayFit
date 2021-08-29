package com.java016.playfit.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "monthly_record")
public class MonthlyRecord {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    private Calendar monthly;

    private int finish;

    @Column(name = "monthly_kcal")
    private int monthlyKcal;

    @Column(name = "monthly_time")
    private int monthlyTime;

    public MonthlyRecord(User user, Calendar monthly, int finish, int monthlyKcal, int monthlyTime) {

        this.user = user;
        this.monthly = monthly;
        this.finish = finish;
        this.monthlyKcal = monthlyKcal;
        this.monthlyTime = monthlyTime;
    }

    public MonthlyRecord() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Calendar getMonthly() {
        return monthly;
    }

    public void setMonthly(Calendar monthly) {
        this.monthly = monthly;
    }

    public int getFinish() {
        return finish;
    }

    public void setFinish(int finish) {
        this.finish = finish;
    }

    public int getMonthlyKcal() {
        return monthlyKcal;
    }

    public void setMonthlyKcal(int monthly_kcal) {
        this.monthlyKcal = monthly_kcal;
    }

    public int getMonthlyTime() {
        return monthlyTime;
    }

    public void setMonthlyTime(int monthly_time) {
        this.monthlyTime = monthly_time;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Monthly_record{");
        sb.append("id=").append(id);
        sb.append(", monthly=").append(monthly);
        sb.append(", finish=").append(finish);
        sb.append(", monthly_kcal=").append(monthlyKcal);
        sb.append(", monthly_time=").append(monthlyTime);
        sb.append('}');
        return sb.toString();
    }
}
