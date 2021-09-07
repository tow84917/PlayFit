package com.java016.playfit.tool;

import java.security.SecureRandom;
import java.util.Date;
import java.util.Random;

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

	// Email 文本格式
	public String generateText(String newUserName, String verificationCode) {

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
	
}



