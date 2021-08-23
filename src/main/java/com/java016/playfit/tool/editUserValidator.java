package com.java016.playfit.tool;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.java016.playfit.model.User;

@Component
public class editUserValidator implements Validator {
	// 修改個人資訊用 Validator

	@Override
	public boolean supports(Class<?> clazz) {
		boolean b = User.class.isAssignableFrom(clazz);
		return b;
	}

	@Override
	public void validate(Object target, Errors errors) {
		User user = (User) target;
		
		// 全名、暱稱12字以內 (符合個人頁)
		// Full Name
		ValidationUtils.rejectIfEmptyOrWhitespace
		(errors, "fullName", "user.fullName.not.empty", "FullName required");
		if (user.getFullName().length() > 12) { 
			errors.rejectValue("fullName", "", "FullName over size");
		}
		
		// Nick Name
		if (!(user.getNickName().isBlank())) {
			if (user.getNickName().length() > 12) {
				errors.rejectValue("nickName", "", "NickName over size");				
			}
		}
		
		// Email
		ValidationUtils.rejectIfEmptyOrWhitespace
		(errors, "email", "user.email.not.empty", "Email required");
		if (!user.getEmail()
				.matches("^\\w{1,63}@[a-zA-Z0-9]{2,63}\\.[a-zA-Z]{2,63}(\\.[a-zA-Z]{2,63})?$")) {
			errors.rejectValue("email", "", "Email illegal.");
		}
		
		// Birthday
		ValidationUtils.rejectIfEmptyOrWhitespace
		(errors, "birthday", "user.birthday.not.empty", "Birthday required");
		// 要大於 14 歲
		if (new BodyCalculator().calAge(user.getBirthday()) < 14) {
			errors.rejectValue("birthday", "", "Have to be 14 or over");
		}
		
		// Phone 台灣
		if (!(user.getPhone().isBlank())) {
			if (!(user.getPhone().matches("09\\d{2}-?(\\d{3})-?(\\d{3})")) && // 手機
				!(user.getPhone().matches("0\\d{1,2}-?(\\d{6,8})")) // 市話
				) {
				errors.rejectValue("phone", "", "Phone illegal.");
			}
		}
		
		// Address 資料庫大小
		if (!(user.getAddress().isBlank())) {
			if (user.getAddress().length() > 100) {
				errors.rejectValue("address", "", "address over size");				
			}
		}
		
	}

}








