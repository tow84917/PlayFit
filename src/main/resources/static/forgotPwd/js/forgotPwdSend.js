"use strict"

// 使用者輸入欄
let enterEmail = document.querySelector(".enterEmail");
let enterCaptcha = document.querySelector(".enterCaptcha");

// 結果與訊息欄
var result = document.querySelector(".result");

// 顯示訊息 (有錯誤順便刷新驗證碼)
function showMessage(message){
    result.classList.remove("hidden");
    result.classList.remove("success");
    result.classList.add("error");
	
	// 前端檢查(格式不符、尚未輸入)
    if(message == "illegal") {
    	result.textContent = "Email is illegal.";
    	refreshCaptchaPic();
    }
    
    if(message == "notFilled") { 
    	result.textContent = "Email can not be empty.";
    	refreshCaptchaPic();
    }
    // -------------以下回傳結果------------
    
    // 寄信成功
    if(message == "sendSuccess") {
    	result.classList.remove("error");
    	result.classList.add("success");
    	result.innerHTML = `We have sent a reset password link to your email. Please check.`;
    }
    
    // 輸入之 Email 無效
    if(message == "notFound"){ 
    	result.textContent = "Could not find any customer with the email.";
    	refreshCaptchaPic();
    }
    
    // 請求達到每日上限次數
    if(message == "requestsLimit") { 
    	result.innerHTML = `The number of requests today,<br> reached the limit, please try tomorrow`;
    	refreshCaptchaPic();
    }
    
    // 驗證碼錯誤或失效
    if(message == "captchaInvaild") {
    	result.textContent = "Verification code entered incorrectly or has expired";
    	refreshCaptchaPic();
    }
    
    // 寄出失敗
    if(message == "tryLater") {
    	result.textContent = "Failed to send, try again later";
    	refreshCaptchaPic();
    }
}

// 拿信
async function getForgotPwdEmail(inputEmail, inputCaptcha){
	
	await fetch('/sendForgotPwdEmail', {
		method : 'POST',
	    headers : {
	    'Content-Type' : 'application/json',
	    "Accept": "application/json",
	    "X-Requested-With": "XMLHttpRequest",
	    "X-CSRF-Token": token
	    },
	    credentials: "same-origin",
	    body : JSON.stringify({ 
	    	"inputEmail":inputEmail, 
	    	"inputCaptcha":inputCaptcha
	    }) ,	
	})
	
    .then(response => {
//	  console.log(response);      
      return response.json(); 
    })
    
    .then(data => {
      console.log(data["forgetEmailResult"]);
      showMessage(data["forgetEmailResult"]);
    });
}

// 驗證碼圖片
let captchaPic = document.getElementById("captchaPic");

// 刷新驗證碼圖片
function refreshCaptchaPic(){
	//console.log(captchaPic.src);
	captchaPic.src = 'http://localhost:8080/getCaptchaImage?' + Math.random();
}

// 刷新按鈕
let refreshCaptchaBtn = document.getElementById("refreshCaptchaBtn");

refreshCaptchaBtn.addEventListener('click', ()=>{
	refreshCaptchaPic();
})


// 403 錯誤

var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function (e, xhr, options) {
    xhr.setRequestHeader(header, token);
});

// 403 錯誤


// 處理送出
let submitBtn = document.getElementById("confirmSubmit");

// 點擊送出 email 拿信 
submitBtn.addEventListener('click', ()=>{
	
	 let inputEmail = enterEmail.value ;
	 inputEmail = inputEmail.trim(); // 去前後空格
	 //console.log(inputEmail)
	 
	 // 信箱未填
     if(inputEmail.length < 1){
        showMessage("notFilled");
        return ;
     }
	 
	 // 信箱格式錯誤
     let emailRule = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z]+$/; // 格式規則
        
     if(!inputEmail.match(emailRule)){
        showMessage("illegal");
        return ;
     }
     
     let inputCaptcha = enterCaptcha.value 
	 
	 // 拿信
	 getForgotPwdEmail(inputEmail, inputCaptcha);

});













