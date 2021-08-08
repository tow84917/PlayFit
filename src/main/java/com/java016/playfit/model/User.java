package com.java016.playfit.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="full_name")
	private String fullName;
	
//	private String account;
	
	private String password;
	@Column(name = "nickname")
	private String name;
	
	private String gender;
	
	private String email;
	
	private String phone;
	
	@Temporal(TemporalType.DATE)
	private Date birthday;
	
	@Column(name="created_at", 
			nullable=false, 
			updatable=false, 
			insertable=false, 
			columnDefinition="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	
	private Timestamp createdAt;
	
	@Column(name="certification_status")
	private int certificationStatus;
	
	//bi-directional many-to-one association to Avatar
	@ManyToOne
	private  Avatar avatar;

	@OneToMany(mappedBy = "user_id")
	private Set<Daily_Record> daily_records;

	@OneToMany(mappedBy = "user")
	private Set<Monthly_record> monthly_records;


	public Set<Daily_Record> getDaily_records() {
		return daily_records;
	}

	public void setDaily_records(Set<Daily_Record> daily_records) {
		this.daily_records = daily_records;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

//	public String getAccount() {
//		return account;
//	}
//
//	public void setAccount(String account) {
//		this.account = account;
//	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public int getCertificationStatus() {
		return certificationStatus;
	}

	public void setCertificationStatus(int certificationStatus) {
		this.certificationStatus = certificationStatus;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}
	
	
}
