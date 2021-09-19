package com.java016.playfit.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "reset_password_token")
public class ResetPasswordToken {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	@JoinColumn(name = "user_id", referencedColumnName = "id")
	private User user;
	
	@Column(name="reset_token")
	private String resetToken;
	
	@Column(name="mail_create", 
			columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	@Temporal(TemporalType.TIMESTAMP)
	private Date mailCreate;
	
	@Column(name="mail_modify")
	@Temporal(TemporalType.TIMESTAMP)
	private Date mailModify;

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

	public String getResetToken() {
		return resetToken;
	}

	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}

	public Date getMailCreate() {
		return mailCreate;
	}

	public void setMailCreate(Date mailCreate) {
		this.mailCreate = mailCreate;
	}

	public Date getMailModify() {
		return mailModify;
	}

	public void setMailModify(Date mailModify) {
		this.mailModify = mailModify;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ResetPasswordToken [id=");
		builder.append(id);
		builder.append(", resetToken=");
		builder.append(resetToken);
		builder.append(", mailCreate=");
		builder.append(mailCreate);
		builder.append(", mailModify=");
		builder.append(mailModify);
		builder.append("]");
		return builder.toString();
	}
	
}




















