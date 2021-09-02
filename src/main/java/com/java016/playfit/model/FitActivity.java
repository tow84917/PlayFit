package com.java016.playfit.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.sql.Time;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "fit_activity")
public class FitActivity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "body_part")
	private String bodyPart;

	private String description;

	@Column(name = "kcal_burn")
	private Integer kcalBurn;

	@Column(name = "image_path")
	private String imagePath;

	private String name;

	private Time time;
	
	private Boolean role;

	// bi-directional many-to-one association to FitAchieve
	@JsonIgnore
	@OneToMany(mappedBy = "fitActivity")
	private List<FitAchieve> fitAchieves;

	// bi-directional many-to-one association to FitActivityVideo
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "video_id")
	private FitActivityVideo fitActivityVideo;

	public FitActivity() {
	}

	@Override
	public String toString() {
		final StringBuffer sb = new StringBuffer("FitActivity{");
		sb.append("id=").append(id);
		sb.append(", bodyPart='").append(bodyPart).append('\'');
		sb.append(", name='").append(name).append('\'');
		sb.append(", time=").append(time);
		sb.append('}');
		return sb.toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBodyPart() {
		return bodyPart;
	}

	public void setBodyPart(String bodyPart) {
		this.bodyPart = bodyPart;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getKcalBurn() {
		return kcalBurn;
	}

	public void setKcalBurn(Integer kcalBurn) {
		this.kcalBurn = kcalBurn;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
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
	@JsonIgnore
	public List<FitAchieve> getFitAchieves() {
		return fitAchieves;
	}
	@JsonIgnore
	public void setFitAchieves(List<FitAchieve> fitAchieves) {
		this.fitAchieves = fitAchieves;
	}

	
	public Boolean getRole() {
		return role;
	}

	public void setRole(Boolean role) {
		this.role = role;
	}

	public FitActivityVideo getFitActivityVideo() {
		return fitActivityVideo;
	}

	public void setFitActivityVideo(FitActivityVideo fitActivityVideo) {
		this.fitActivityVideo = fitActivityVideo;
	}

}
