package com.java016.playfit.tool;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.java016.playfit.model.User;
import com.java016.playfit.service.UserService;

@Component
public class EditUserValidator implements Validator {
	// 修改個人資訊專用 Validator
	
	@Autowired
	UserService userService;

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
		(errors, "fullName", "", "FullName required");
		if (user.getFullName().length() > 12) { 
			errors.rejectValue("fullName", "", "FullName oversize");
		}
		
		// Nick Name
		if (!(user.getNickName().isBlank())) {
			if (user.getNickName().length() > 12) {
				errors.rejectValue("nickName", "", "NickName oversize");				
			}
		}
		
		// Email
		ValidationUtils.rejectIfEmptyOrWhitespace
		(errors, "email", "", "Email required");
		
		if (!(user.getEmail().isBlank())) {		
			// 判斷格式
			if (!user.getEmail()
					.matches(
							"^\\w{1,63}@[a-zA-Z0-9]{1,30}\\.[a-zA-Z]{1,30}(\\.[a-zA-Z]{1,30})?(\\.[a-zA-Z]{1,30})?$")
					) {
				errors.rejectValue("email", "", "Email illegal.");
			}
				
			// Email 不可與其他會員重複
			User otherUser = userService.findByEmail(user.getEmail());
			if (otherUser != null) {
				
				if (otherUser.getId() != user.getId()) {
						errors.rejectValue("email", "", "Email duplicate.");					
					}
			}				
		}
		
		// Birthday
		ValidationUtils.rejectIfEmptyOrWhitespace
		(errors, "birthday", "", "Birthday required");
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
				errors.rejectValue("address", "", "address oversize");				
			}
		}
		
	}

}









