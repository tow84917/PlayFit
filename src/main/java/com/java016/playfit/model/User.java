package com.java016.playfit.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="full_name")
	private String fullName;
	
	private String password;
	
	@Column(name="nickname")
	private String nickName;
	
	private String gender;
	
	private String email;
	
	private String phone;
	
	private String address;
	
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
	
	//bi
	@OneToOne
	@JoinColumn(name = "avatar_id", referencedColumnName = "id")
	private Avatar avatar;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	@Override
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
		builder.append(", avatar=");
		builder.append(avatar);
		builder.append("]");
		return builder.toString();
	}
}



















