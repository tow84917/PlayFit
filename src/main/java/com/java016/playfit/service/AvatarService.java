package com.java016.playfit.service;

import com.java016.playfit.model.Avatar;
import com.java016.playfit.model.BodyType;

public interface AvatarService {
	
	/**
	 * 儲存 Avatar 
	 */
	Avatar getAvatarById(Integer id);
	
	/**
	 * 儲存 Avatar 
	 */
	Avatar saveAvatar(Avatar avatar);
	
	/**
	 * 儲存 Avatar 圖片
	 */
	void saveAvatarPic(BodyType bodyType, String color, 
			String clothesName, String hatName, String saveFileName);
}













