package com.java016.playfit.config;

import java.util.Properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;

// 圖形驗證碼配置
@Configuration
public class KapthaConfig {
	
	@Bean
	public DefaultKaptcha captchaProducer() {
		
		DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
		
		Properties properties = new Properties();
		
		// 是否有邊框
		properties.setProperty(Constants.KAPTCHA_BORDER, "yes");
		
		// 邊框颜色
        properties.setProperty(Constants.KAPTCHA_BORDER_COLOR, "192,192,192");
		
        // 驗證碼圖片的寬高
        properties.setProperty(Constants.KAPTCHA_IMAGE_WIDTH, "150");
        properties.setProperty(Constants.KAPTCHA_IMAGE_HEIGHT, "45");
        
        // 驗證碼圖片背景漸變
        properties.setProperty(Constants.KAPTCHA_BACKGROUND_CLR_FROM, "224,255,255");
        properties.setProperty(Constants.KAPTCHA_BACKGROUND_CLR_TO, "132,112,255");
        
        // 驗證碼颜色
        properties.setProperty
        (Constants.KAPTCHA_TEXTPRODUCER_FONT_COLOR, "105,105,105");
        
        // 驗證碼字大小
        properties.setProperty
        (Constants.KAPTCHA_TEXTPRODUCER_FONT_SIZE, "32");
        
        // 驗證碼幾個字符
        properties.setProperty
        (Constants.KAPTCHA_TEXTPRODUCER_CHAR_LENGTH, "5");
        
        // 驗證碼隨機字符庫
        properties.setProperty
        (Constants.KAPTCHA_TEXTPRODUCER_CHAR_STRING, "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYAZ");
        
        // 驗證碼圖片default 有干擾, 這裡設置無干擾
        properties.setProperty
        (Constants.KAPTCHA_NOISE_IMPL, "com.google.code.kaptcha.impl.NoNoise");
        
        // 設置 properties 設定給 Kaptcha
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
		
        return defaultKaptcha;
	}
}
















