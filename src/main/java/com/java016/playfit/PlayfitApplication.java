package com.java016.playfit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling // 可排程註釋
@SpringBootApplication
public class PlayfitApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlayfitApplication.class, args);
		System.out.println("PlayFit Start!!");
	}
	
	// 自動開瀏覽器
//	@EventListener({ApplicationReadyEvent.class})
//	public void applicationReadyEvent() {
//	    System.out.println("Application ready ... open Browser");
//	    String url = "http://localhost:8080/";
//	    Runtime runtime = Runtime.getRuntime();
//	    try {
//	        runtime.exec("rundll32 url.dll,FileProtocolHandler " + url);
//	    } catch (IOException e) {
//	        e.printStackTrace();
//	    }
//	}
}







