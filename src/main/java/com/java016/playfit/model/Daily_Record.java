package com.java016.playfit.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
@Table(name = "Daily_Record")
public class Daily_Record {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user_id;

    private int kcal_burned;

    private int kcal_intake;

    private String title;

    private String content;

    private int status;  //是否為日記  1 是  0 不是   可改成 Boolean?

    private Date created_date;

    @OneToMany(mappedBy = "daily_record")
    private Set<Fit_achieve> fit_achieves;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser_id() {
        return user_id;
    }

    public void setUser_id(User user_id) {
        this.user_id = user_id;
    }

    public int getKcal_burned() {
        return kcal_burned;
    }

    public void setKcal_burned(int kcal_burned) {
        this.kcal_burned = kcal_burned;
    }

    public int getKcal_intake() {
        return kcal_intake;
    }

    public void setKcal_intake(int kcal_intake) {
        this.kcal_intake = kcal_intake;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Set<Fit_achieve> getFit_achieves() {
        return fit_achieves;
    }

    public void setFit_achieves(Set<Fit_achieve> fit_achieves) {
        this.fit_achieves = fit_achieves;
    }
}
