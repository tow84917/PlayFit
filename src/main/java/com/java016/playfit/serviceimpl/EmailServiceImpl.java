package com.java016.playfit.serviceimpl;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.java016.playfit.service.EmailService;

@Service
public class EmailServiceImpl implements EmailService {
	
	@Autowired
	JavaMailSender javaMailSender;
	
	// 發送者
	@Value("${spring.mail.username}")
	String from;
	
	// 發送純文本Email
    @Override
	public void sendMail(String to, String subject, String text) {
        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom(from);
        message.setTo(to);
        message.setSubject(subject);
        message.setText(text);
        javaMailSender.send(message);
    }
    
    // 有支援附件
    @Override
	public void sendRichMail(String to, String subject, String text, String filePath) 
    		throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper =new MimeMessageHelper(mimeMessage, true);
        helper.setFrom(from);
        helper.setTo(to);
        helper.setSubject(subject);

        helper.setText(text, true); // true => 有支援 html
        
        // 發送附件用
//      helper.addInline("qr",new FileSystemResource(filePath));
        
        javaMailSender.send(mimeMessage);

    }
}









