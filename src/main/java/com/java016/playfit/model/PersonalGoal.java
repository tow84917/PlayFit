package com.java016.playfit.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="Personal_Goal")
public class PersonalGoal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	@Column(name="start_Weight")
	private Float startWeight;
	
	@Column(name="goal_Weight")
	private Float goalWeight;
	
	@Column(name="total_lost")
	private Integer totalLost;
	
	@Temporal(TemporalType.DATE)
	@Column(name="created_date")
	private Date createDate;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Float getStartWeight() {
		return startWeight;
	}

	public void setStartWeight(Float startWeight) {
		this.startWeight = startWeight;
	}

	public Float getGoalWeight() {
		return goalWeight;
	}

	public void setGoalWeight(Float goalWeight) {
		this.goalWeight = goalWeight;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date date) {
		this.createDate = date;
	}

	public Integer getTotalLost() {
		return totalLost;
	}

	public void setTotalLost(Integer totalLost) {
		this.totalLost = totalLost;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PersonalGoal [id=");
		builder.append(id);
		builder.append(", user=");
		builder.append(user.getFullName());
		builder.append(", startWeight=");
		builder.append(startWeight);
		builder.append(", goalWeight=");
		builder.append(goalWeight);
		builder.append(", totalLost=");
		builder.append(totalLost);
		builder.append(", createDate=");
		builder.append(createDate);
		builder.append("]");
		return builder.toString();
	}
	
}
















