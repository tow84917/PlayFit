"use strict"

// 使用者出入信箱欄
let enterEmail = document.querySelector(".enterEmail");

// 結果與訊息欄
var result = document.querySelector(".result");

// 顯示訊息
function showMessage(message){
    result.classList.remove("hidden");
    result.classList.remove("success");
    result.classList.add("error");
	
	// 前端檢查(格式不符、尚未輸入)
    if(message == "illegal") result.textContent = "Email is illegal."
    if(message == "notFilled") result.textContent = "Email can not be empty."
    
    // -------------以下回傳結果------------
    
    // 寄信成功
    if(message == "sendSuccess") {
    	result.classList.remove("error");
    	result.classList.add("success");
    	result.innerHTML = `We have sent a reset password link to your email. Please check.`
    }
    
}

// 拿信
async function getForgotPwdEmail(inputEmail){
	
	await fetch('/sendForgotPwdEmail', {
		method : 'POST',
	    headers : {
	    'Content-Type' : 'application/json',
	    "Accept": "application/json",
	    "X-Requested-With": "XMLHttpRequest",
	    "X-CSRF-Token": token
	    },
	    credentials: "same-origin",
	    body :JSON.inputEmail,	
	})
	
    .then(response => {
//	  console.log(response);      
      return response.json(); 
    })
    
    .then(data => {
//    console.log(data["forgetEmailResult"]);
      showMessage(data["forgetEmailResult"]);
    });
}

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
	 
	 getForgotPwdEmail(inputEmail);

});













