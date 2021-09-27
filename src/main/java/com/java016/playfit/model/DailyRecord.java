package com.java016.playfit.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.query.criteria.internal.BasicPathUsageException;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Daily_Record")
public class DailyRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@JsonIgnore
	@ManyToOne
	private User user;

	@Column(name = "kcal_burned")
	private Integer kcalBurned;

	@Column(name = "kcal_intake")
	private Integer kcalIntake;

	private String title;

	@Lob
	@Column(name = "content", columnDefinition = "CLOB")
	private String content;

	private Integer status; // 是否為日記 1 是 0 不是 可改成 Boolean?

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	@Column(name = "created_date")
	private Date createdDate;

	@JsonIgnore
	@OneToMany(mappedBy = "dailyRecord")
	private List<FitAchieve> fitAchieves;

	// bi-directional many-to-one association to Meal
	@JsonIgnore
	@OneToMany(mappedBy = "dailyRecord")
	private List<Meal> meals;
	
	@JsonIgnore
	@OneToMany(mappedBy = "dailyRecord")
	private List<DiaryPhoto> diaryPhotos;

	public DailyRecord() {
		this.kcalBurned = 0;
		this.kcalIntake = 0;
	}

	public DailyRecord(User user, Integer status, Date createdDate) {
		this.user = user;
		this.status = status;
		this.createdDate = createdDate;
		this.kcalBurned = 0;
		this.kcalIntake = 0;
	}

	@JsonIgnore
	public Integer getId() {
		return id;
	}
	
	@JsonIgnore
	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getKcalBurned() {
		return kcalBurned;
	}

	public void setKcalBurned(Integer kcalBurned) {
		this.kcalBurned = kcalBurned;
	}

	public Integer getKcalIntake() {
		return kcalIntake;
	}

	public void setKcalIntake(Integer kcalIntake) {
		this.kcalIntake = kcalIntake;
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	@JsonIgnore
	public List<FitAchieve> getFitAchieves() {
		return fitAchieves;
	}
	
	@JsonIgnore
	public void setFitAchieves(List<FitAchieve> fitAchieves) {
		this.fitAchieves = fitAchieves;
	}
	@JsonIgnore
	public List<Meal> getMeals() {
		return meals;
	}
	@JsonIgnore
	public void setMeals(List<Meal> meals) {
		this.meals = meals;
	}

	@JsonIgnore
	public List<DiaryPhoto> getDiaryPhotos() {
		return diaryPhotos;
	}
	@JsonIgnore
	public void setDiaryPhotos(List<DiaryPhoto> diaryPhotos) {
		this.diaryPhotos = diaryPhotos;
	}
	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DailyRecord [id=");
		builder.append(id);
//		builder.append(", user=");
//		builder.append(user.getFullName());
		builder.append(", kcalBurned=");
		builder.append(kcalBurned);
		builder.append(", kcalIntake=");
		builder.append(kcalIntake);
		builder.append(", title=");
		builder.append(title);
		builder.append(", content=");
		builder.append(content);
		builder.append(", status=");
		builder.append(status);
		builder.append(", createdDate=");
		builder.append(createdDate);
		builder.append("]");
		return builder.toString();
	}
}
