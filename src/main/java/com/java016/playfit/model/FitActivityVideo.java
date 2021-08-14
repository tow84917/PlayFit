package com.java016.playfit.model;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table(name = "Fit_activity_video")
public class FitActivityVideo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String name;

    @Column(name = "video_path")
    private String videoPath; //影片路徑

    @Column(name = "file_name")
    private String fileName; //檔名

    @Column(name = "mime_type")
    private String mimeType; //檔案類型

    private Time time; //影片時間長度

    @OneToOne(mappedBy = "videoId")
//    @Column(name = "fit_activity")
    private FitActivity fitActivity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoPath() {
        return videoPath;
    }

    public void setVideoPath(String video_path) {
        this.videoPath = video_path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String file_name) {
        this.fileName = file_name;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mime_type) {
        this.mimeType = mime_type;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public FitActivity getFitActivity() {
        return fitActivity;
    }

    public void setFitActivity(FitActivity fit_activity) {
        this.fitActivity = fit_activity;
    }
}
