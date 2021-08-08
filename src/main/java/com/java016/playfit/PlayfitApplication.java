package com.java016.playfit;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

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







