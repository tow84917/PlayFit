package com.java016.playfit.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(
		name = "users"
)
public class User implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(
			strategy = GenerationType.IDENTITY
			
	)
	private Integer id;
	
	@Column(
			name = "full_name"
	)
	private String fullName;
	
	private String password;
	
	@Column(
			name = "nickname"
	)
	private String nickName;
	
	private String gender;
	
	private String email;
	
	private String phone;
	
	private String address;
	
	@DateTimeFormat(
			pattern = "yyyy-MM-dd"
	)
	@Temporal(TemporalType.DATE)
	private Date birthday;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Temporal(TemporalType.DATE)
	private Calendar dateline;
	
	@Column(
			name = "created_at",
			nullable = false,
			updatable = false,
			insertable = false,
			columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP"
	)
	private Timestamp createdAt;
	
	@Column(
			name = "certification_status"
	)
	private int certificationStatus;
	
	@OneToOne
	@JoinColumn(
			name = "avatar_id",
			referencedColumnName = "id"
	)
	private Avatar avatar;
	
	@OneToMany(
			mappedBy = "user",
			cascade = {CascadeType.ALL}
	)
	private List<HealthRecord> healthRecords;
	
	@OneToMany(
			mappedBy = "user",
			cascade = {CascadeType.ALL}
	)
	private List<PersonalGoal> PersonalGoals;
	
	@OneToMany(
			mappedBy = "user"
	)
	private List<DailyRecord> dailyRecords;
	
	@Column(
			name = "role"
	)
	private String role;
	
	public User() {}

//  public User(User user) {}

	public List<DailyRecord> getDailyRecords() {
		return this.dailyRecords;
	}

	public void setDailyRecords(List<DailyRecord> dailyRecords) {
		this.dailyRecords = dailyRecords;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Timestamp getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public int getCertificationStatus() {
		return this.certificationStatus;
	}

	public void setCertificationStatus(int certificationStatus) {
		this.certificationStatus = certificationStatus;
	}

	public String getFullName() {
		return this.fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Avatar getAvatar() {
		return this.avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public List<HealthRecord> getHealthRecords() {
		return this.healthRecords;
	}

	public void setHealthRecords(List<HealthRecord> healthRecords) {
		this.healthRecords = healthRecords;
	}

	public List<PersonalGoal> getPersonalGoals() {
		return this.PersonalGoals;
	}

	public void setPersonalGoals(List<PersonalGoal> personalGoals) {
		this.PersonalGoals = personalGoals;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Calendar getDateline() {
		return dateline;
	}

	public void setDateline(Calendar dateline) {
		this.dateline = dateline;
	}
	

	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", fullName=");
		builder.append(fullName);
		builder.append(", password=");
		builder.append(password);
		builder.append(", nickName=");
		builder.append(nickName);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", email=");
		builder.append(email);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", address=");
		builder.append(address);
		builder.append(", birthday=");
		builder.append(birthday);
		builder.append(", createdAt=");
		builder.append(createdAt);
		builder.append(", certificationStatus=");
		builder.append(certificationStatus);
		builder.append(", role=");
		builder.append(role);
		builder.append("]");
		return builder.toString();
	}

}
