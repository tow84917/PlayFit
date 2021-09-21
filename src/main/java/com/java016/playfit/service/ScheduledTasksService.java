package com.java016.playfit.service;

public interface ScheduledTasksService {

	/**
	 * 檢查熱量赤字
	 */
	void upadteCalorieDeficit();
	
	/**
	 * 依體型變化 更新 Avatar
	 */
	void upadteAvatarPicForBodyType();
	
	/**
	 * 刪除過期Token
	 */
	void deleteExpiredToken() ;
}





