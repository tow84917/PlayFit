package com.java016.playfit.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Set;

@Entity
@Table
public class Fit_activity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "fit_activity")
    private Set<Fit_achieve> fit_achieve;

    private String name;

    private String body_part;

    private String description;

    private double kcal_burn;

    private String image_path;

    @OneToOne()
    @JoinColumn(name = "video_id")
    private Fit_activity_video video_id;

    private Time time; //運動時間長度

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<Fit_achieve> getFit_achieve() {
        return fit_achieve;
    }

    public void setFit_achieve(Set<Fit_achieve> fit_achieve) {
        this.fit_achieve = fit_achieve;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBody_part() {
        return body_part;
    }

    public void setBody_part(String body_part) {
        this.body_part = body_part;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getKcal_burn() {
        return kcal_burn;
    }

    public void setKcal_burn(double kcal_burn) {
        this.kcal_burn = kcal_burn;
    }

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public Fit_activity_video getVideo_id() {
        return video_id;
    }

    public void setVideo_id(Fit_activity_video video_id) {
        this.video_id = video_id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
