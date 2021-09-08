package com.java016.playfit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "avatar_hat")
public class AvatarHat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String name;
	
	@ManyToOne
	@JoinColumn(name = "type", referencedColumnName = "id")
	private BodyType bodyType;
	
	@Lob
	@Column(name = "path_label", columnDefinition = "CLOB")
	private String pathLabel;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BodyType getBodyType() {
		return bodyType;
	}

	public void setBodyType(BodyType bodyType) {
		this.bodyType = bodyType;
	}

	public String getPathLabel() {
		return pathLabel;
	}

	public void setPathLabel(String pathLabel) {
		this.pathLabel = pathLabel;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AvatarHat [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", bodyType=");
		builder.append(bodyType.getName());
		builder.append(", pathLabel=");
		builder.append(pathLabel);
		builder.append("]");
		return builder.toString();
	}
	
	
}














