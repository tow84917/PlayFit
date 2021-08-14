package com.java016.playfit.model;

import javax.persistence.*;
import java.sql.Time;

@Entity
@Table
public class FitActivityVideo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    private String name;

    private String video_path; //影片路徑

    private String file_name; //檔名

    private String mime_type; //檔案類型

    private Time time; //影片時間長度

    @OneToOne(mappedBy = "video_id")
    private FitActivity fit_activity;

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

    public String getVideo_path() {
        return video_path;
    }

    public void setVideo_path(String video_path) {
        this.video_path = video_path;
    }

    public String getFile_name() {
        return file_name;
    }

    public void setFile_name(String file_name) {
        this.file_name = file_name;
    }

    public String getMime_type() {
        return mime_type;
    }

    public void setMime_type(String mime_type) {
        this.mime_type = mime_type;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public FitActivity getFit_activity() {
        return fit_activity;
    }

    public void setFit_activity(FitActivity fit_activity) {
        this.fit_activity = fit_activity;
    }
}
