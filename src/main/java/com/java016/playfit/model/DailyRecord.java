package com.java016.playfit.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Daily_Record")
public class DailyRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
    
    @Column(name="kcal_burned")
    private int kcalBurned;
    
    @Column(name="kcal_intake")
    private int kcalIntake;

    private String title;
    
    @Lob
	@Column(name = "content", columnDefinition = "CLOB")
    private String content;

    private Integer status;  //是否為日記  1 是  0 不是   可改成 Boolean?
    
    @Temporal(TemporalType.DATE)
	@Column(name="created_date")
    private Date date;

    @OneToMany(mappedBy = "daily_record")
    private Set<FitAchieve> fit_achieves;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUserId() {
        return userId;
    }

    public void setUserId(User user_id) {
        this.userId = user_id;
    }

    public int getKcalBurned() {
        return kcalBurned;
    }

    public void setKcalBurned(int kcal_burned) {
        this.kcalBurned = kcal_burned;
    }

    public int getKcalIntake() {
        return kcalIntake;
    }

    public void setKcalIntake(int kcal_intake) {
        this.kcalIntake = kcal_intake;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date created_date) {
        this.date = created_date;
    }

    public Set<FitAchieve> getFit_achieves() {
        return fit_achieves;
    }

    public void setFit_achieves(Set<FitAchieve> fit_achieves) {
        this.fit_achieves = fit_achieves;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DailyRecord [id=");
		builder.append(id);
		builder.append(", user_id=");
		builder.append(userId);
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
		builder.append(", created_date=");
		builder.append(date);
		builder.append(", fit_achieves=");
		builder.append(fit_achieves);
		builder.append("]");
		return builder.toString();
	}
}
