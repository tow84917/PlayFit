package com.java016.playfit.tool;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class EmailTool {

	private static final String SYMBOLS = "0123456789"; // 定義隨機號碼

	private static final Random RANDOM = new SecureRandom();

	// 產生6個隨機數
	public String generateVerCode() {
		char[] chars = new char[6];
		for (int i = 0; i < chars.length; i++) {
			chars[i] = SYMBOLS.charAt(RANDOM.nextInt(chars.length));
		}
		return new String(chars);
	}

	// 兩個時間點的分鐘差
	public int getMinute(Date fromDate, Date toDate) {
		return (int) (toDate.getTime() - fromDate.getTime()) / (60 * 1000);
	}

	// 認證 Email 文本格式
	public String generateCertificationText(String newUserName, String verificationCode) {

		String text = "<html lang=\"en\">" + "<body>"
				+ "  <h1 style=\"color: #6460ff;\">PlayFit Certification Letter</h1>" + "  <div>"
				+ "      <p style=\"color:black; font-size: 14px\">" + "			Hello my friend " + newUserName
				+ "		 </p>" + "      <p style=\"color:black; font-size: 14px\">"
				+ "			Glad you joined, Here is your verification code." + "</p>"
				+ "      <p style=\"font-size: 18px;\">"
				+ verificationCode
				+ "		 </p>" + "      <p style=\"color: red;font-size: 14px\">Effective time 5 minutes.</p>"
				+ "  </div>" + "</body>" + "</html>";

		return text;
	}
	
	// 產生 UUID ( Universally Unique Identifier 通用唯一辨識碼)
	public String generateResetPasswordToken() {
		return UUID.randomUUID().toString();
	}
	
	// 忘記密碼 Email 文本格式
	public String generateResetPasswordText(String userName, String link) {

		String text = "<html lang=\"en\">" + "<body>"
				
				+ "<h1 style=\"color: #6460ff;\">PlayFit Reset Password Letter</h1>" + "<div>"
				+ "<p style=\"color:black; font-size: 14px\">Hello my friend " + userName + "</p>"
				
				+ "<p style=\"color:black; font-size: 14px\">You have requested to reset your password, click the link below</p>"
				
				+ "<p><a href=\"" + link + "\">Change my password</a></p>"
				
				+ "<br>"
				
				+ "<p style=\"color:black; font-size: 14px\">Ignore this email if you do remember your password, "
				+ "or you have not made the request.</p>"
				
				+ "<p style=\"color: red;font-size: 14px\">Effective time 24 hours.</p>"
				
				+ "  </div>" + "</body>" + "</html>";

		return text;
	}
}



