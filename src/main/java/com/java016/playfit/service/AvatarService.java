package com.java016.playfit.service;

import com.java016.playfit.model.Avatar;
import com.java016.playfit.model.AvatarBody;
import com.java016.playfit.model.AvatarClothes;
import com.java016.playfit.model.AvatarHat;
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
	
	public AvatarBody getAvatarBody(String color,Integer typeId) ;
	
	
	public AvatarHat getAvatarHat(BodyType type,String name);
	
	public AvatarClothes getAvatarClothes(BodyType type,String name);
	
}













