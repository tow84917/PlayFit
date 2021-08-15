package com.java016.playfit.model;

import java.sql.Time;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="fit_activity_video")
public class FitActivityVideo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="file_name")
	private String fileName;

	@Column(name="mime_type")
	private String mimeType;

	private String name;

	private Time time;

	@Lob
	private byte[] video;

	//bi-directional many-to-one association to FitActivity
	@OneToMany(mappedBy="fitActivityVideo")
	private List<FitActivity> fitActivities;

	public FitActivityVideo() {}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public byte[] getVideo() {
		return video;
	}

	public void setVideo(byte[] video) {
		this.video = video;
	}

	public List<FitActivity> getFitActivities() {
		return fitActivities;
	}

	public void setFitActivities(List<FitActivity> fitActivities) {
		this.fitActivities = fitActivities;
	}
	
}

