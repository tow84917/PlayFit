package com.java016.playfit.model;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Collection;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="users")
public class User implements UserDetails, Serializable{
	
	private static final long serialVersionUID = 1L;

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
	@ManyToOne
	@JoinColumn(name = "avatar_id", referencedColumnName = "id")
	private Avatar avatar;
	
	@OneToMany(mappedBy = "userId")
	private Set<DailyRecord> daily_records;

	@OneToMany(mappedBy = "user")
	private Set<Monthly_record> monthly_records;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	@Override
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

	public Set<DailyRecord> getDaily_records() {
		return daily_records;
	}

	public void setDaily_records(Set<DailyRecord> daily_records) {
		this.daily_records = daily_records;
	}

	public Set<Monthly_record> getMonthly_records() {
		return monthly_records;
	}

	public void setMonthly_records(Set<Monthly_record> monthly_records) {
		this.monthly_records = monthly_records;
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
		builder.append(", daily_records=");
		builder.append(daily_records);
		builder.append(", monthly_records=");
		builder.append(monthly_records);
		builder.append("]");
		return builder.toString();
	}

	// 以下為 UserDetails
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null; // 未設	
	}
	
	@Override
	public String getUsername() {
		return this.fullName; // 用戶全名
	}

	@Override
	public boolean isAccountNonExpired() {
		return true; // 帳號是否未過期
	}

	@Override
	public boolean isAccountNonLocked() {
		return true; // 用戶是否未被鎖
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true; // 憑證是否未過期
	}

	@Override
	public boolean isEnabled() {
		return true; // 用戶是否啟用
	}
}