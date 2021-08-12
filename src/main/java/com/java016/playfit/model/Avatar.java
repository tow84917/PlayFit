package com.java016.playfit.model;

import java.util.Arrays;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "avatar")
public class Avatar {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;

	private String name;
	
	private String description;

	@Lob
	@Column(name = "image", columnDefinition = "BLOB")
	private byte[] image;
	
	@Column(name =  "image_path")
	private String ImagePath;
	
	@Column(name="file_name")
	private String fileName;

	@Column(name="mime_type")
	private String mimeType;
	
	// bi
	@OneToMany(mappedBy="avatar")
	private List<User> users;

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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public byte[] getImage() {
		return image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getImagePath() {
		return ImagePath;
	}

	public void setImagePath(String imagePath) {
		ImagePath = imagePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getMimeType() {
		return mimeType;
	}

	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Avatar [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", image=");
		builder.append(Arrays.toString(image));
		builder.append(", ImagePath=");
		builder.append(ImagePath);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append(", mimeType=");
		builder.append(mimeType);
		builder.append(", users=");
		builder.append(users);
		builder.append("]");
		return builder.toString();
	}
}
