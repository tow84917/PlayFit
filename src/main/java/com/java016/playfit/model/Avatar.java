package com.java016.playfit.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "avatar")
public class Avatar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String name;
	
	@ManyToOne
	@JoinColumn(name = "avatar_body_id", referencedColumnName = "id")
	private AvatarBody avatarBody;
	
	@ManyToOne
	@JoinColumn(name = "avatar_clothes_id", referencedColumnName = "id")
	private AvatarClothes avatarClothes;
	
	@ManyToOne
	@JoinColumn(name = "avatar_hat_id", referencedColumnName = "id")
	private AvatarHat avatarHat;

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
	@OneToOne(mappedBy = "avatar")
	private User user;

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

	public AvatarBody getAvatarBody() {
		return avatarBody;
	}

	public void setAvatarBody(AvatarBody avatarBody) {
		this.avatarBody = avatarBody;
	}

	public AvatarClothes getAvatarClothes() {
		return avatarClothes;
	}

	public void setAvatarClothes(AvatarClothes avatarClothes) {
		this.avatarClothes = avatarClothes;
	}

	public AvatarHat getAvatarHat() {
		return avatarHat;
	}

	public void setAvatarHat(AvatarHat avatarHat) {
		this.avatarHat = avatarHat;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Avatar [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", image=");
		builder.append(Arrays.toString(image));
		builder.append(", ImagePath=");
		builder.append(ImagePath);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append(", mimeType=");
		builder.append(mimeType);
		builder.append("]");
		return builder.toString();
	}
}
