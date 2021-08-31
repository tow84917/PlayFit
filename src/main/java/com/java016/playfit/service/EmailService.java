package com.java016.playfit.service;

import javax.mail.MessagingException;

public interface EmailService {

	// 發送純文本Email
	void sendMail(String to, String subject, String text);

	// 有支援附件
	void sendRichMail(String to, String subject, String text, String filePath) 
			throws MessagingException;

}








