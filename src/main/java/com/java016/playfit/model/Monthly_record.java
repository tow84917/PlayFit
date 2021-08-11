package com.java016.playfit.model;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "monthly_record")
public class Monthly_record {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User user;

    private Calendar monthly;

    private int finish;

    private int monthly_kcal;

    private int monthly_time;

    public Monthly_record( User user, Calendar monthly, int finish, int monthly_kcal, int monthly_time) {

        this.user = user;
        this.monthly = monthly;
        this.finish = finish;
        this.monthly_kcal = monthly_kcal;
        this.monthly_time = monthly_time;
    }

    public Monthly_record() {
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Monthly_record{");
        sb.append("id=").append(id);
        sb.append(", user=").append(user);
        sb.append(", monthly=").append(monthly);
        sb.append(", finish=").append(finish);
        sb.append(", monthly_kcal=").append(monthly_kcal);
        sb.append(", monthly_time=").append(monthly_time);
        sb.append('}');
        return sb.toString();
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

    public int getMonthly_kcal() {
        return monthly_kcal;
    }

    public void setMonthly_kcal(int monthly_kcal) {
        this.monthly_kcal = monthly_kcal;
    }

    public int getMonthly_time() {
        return monthly_time;
    }

    public void setMonthly_time(int monthly_time) {
        this.monthly_time = monthly_time;
    }
}
