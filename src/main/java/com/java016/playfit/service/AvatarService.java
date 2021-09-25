package com.java016.playfit.service;

import com.java016.playfit.model.Avatar;
import com.java016.playfit.model.AvatarBody;
import com.java016.playfit.model.AvatarClothes;
import com.java016.playfit.model.AvatarHat;
import com.java016.playfit.model.BodyType;

public interface AvatarService {

	/**
	 * 依 Id 找 Avatar
	 */
	Avatar getAvatarById(Integer id);

	/**
	 * 儲存 Avatar 
	 */
	Avatar saveAvatar(Avatar avatar);

	/**
	 * 找 Avatar Body
	 */
	AvatarBody getAvatarBody(String color, BodyType type);

	/**
	 * 找 Avatar Hat
	 */
	AvatarHat getAvatarHat(BodyType type, String name);

	/**
	 * 找 Avatar Clothes
	 */
	AvatarClothes getAvatarClothes(BodyType type, String name);
	
	/**
	 * 更新Avatar 配件資料
	 */
	void updateAvatarAccessory(Avatar userAvatar, BodyType bodyType, 
			String color, String clothesName, String hatName);
	
	/**
	 * 儲存 Avatar "圖片"
	 */
	void saveAvatarPic(BodyType bodyType, String color, 
			String clothesName, String hatName, String saveFileName);

}












