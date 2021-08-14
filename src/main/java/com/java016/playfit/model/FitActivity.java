package com.java016.playfit.model;

import javax.persistence.*;
import java.sql.Time;
import java.util.Set;

@Entity
@Table(name = "Fit_activity")
public class FitActivity {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(name = "fit_achieve")
    @OneToMany(mappedBy = "fitActivity")
    private Set<FitAchieve> fitAchieve;

    private String name;
    @Column(name = "body_part")
    private String bodyPart;

    private String description;

    @Column(name = "kcal_burn")
    private double kcalBurn;

    @Column(name = "image_path")
    private String imagePath;

    @OneToOne()
    @JoinColumn(name = "video_id")
    private FitActivityVideo videoId;

    private Time time; //運動時間長度

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Set<FitAchieve> getFitAchieve() {
        return fitAchieve;
    }

    public void setFitAchieve(Set<FitAchieve> fit_achieve) {
        this.fitAchieve = fit_achieve;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public void setBodyPart(String body_part) {
        this.bodyPart = body_part;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getKcalBurn() {
        return kcalBurn;
    }

    public void setKcalBurn(double kcal_burn) {
        this.kcalBurn = kcal_burn;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String image_path) {
        this.imagePath = image_path;
    }

    public FitActivityVideo getVideoId() {
        return videoId;
    }

    public void setVideoId(FitActivityVideo video_id) {
        this.videoId = video_id;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
