"use strict"

// 拿信
async function getCertificationEmail(){
	
	await fetch('/sendCertificationEmail')
    .then(response => {
      return response.json(); 
    })
    .then(data => {
    	
      let resultMessage = data["emailResult"];
	  
	  if(resultMessage == "tryLater") showErrorMessage(resultMessage)
	  
	  else showSuccessMessage(resultMessage);
	  
    });
}

// 結果與訊息欄
var result = document.querySelector(".result");

// 取所有input
var inputArr = document.getElementsByTagName("input");

// 訊息類別
let messageType = new Map([
	
	["sendSuccess",
	`Already sent the certification email <br>please enter the verification code below.`],
	
	["alreadySent",
	`Already sent the certification email <br>please enter the verification code below.`],
	
	["activateSuccess",
	`Activate Success ! <br>Go MemberPage 3 Seconds later.`],
	
	["notNum",
	`Please enter number.`],
	
	["notFilled",
	`Verification code not filled.`],
	
	["verificationCodeExpired",
	`Verification code expired, <br> we will sent certification email again later.`],
	
	["verificationCodeFalse",
	`Verification incorrect.`],
	
	["tryLater",
	`Failed to send, try again later`]
	
]);

// 成功訊息
function showSuccessMessage(message){
	
    result.classList.remove("hidden");
    result.classList.remove("error");
    result.classList.add("success");
    
    result.innerHTML = messageType.get(message);
	
	if(message == "activateSuccess"){
		setTimeout(()=>{
	    		window.location.replace('/MemberPage') // 成功跳轉會員頁
	    },3000)
    }
}

// 失敗訊息
function showErrorMessage(message){
	
    result.classList.remove("hidden");
    result.classList.remove("success");
    result.classList.add("error");
    
    result.innerHTML = messageType.get(message);
	
	if(message == "verificationCodeExpired"){
		setTimeout(()=>{
	    	getCertificationEmail();
	    },3000)
    }
}

//// 顯示訊息
//function showMessage(message){
//    result.classList.remove("hidden");
//    result.classList.remove("success");
//    result.classList.add("error");
//	
//	// 前端檢查
//    if(message == "notNum") result.textContent = "Please enter number."
//    if(message == "notFilled") result.textContent = "Verification code not filled."
//    
//    // -------------以下回傳結果------------
//    
//    result.innerHTML = messageType.get(message);
//    
//    // 驗證碼過期
//    if(message == "verificationCodeExpired") {
//    	result.innerHTML = `Verification code expired, already sent certification email again, 
//    	<br>please check your email.`
//    	
//    	// 過期再拿一次信
//    	getCertificationEmail();
//    }
//    
//    // 驗證碼不正確
//    if(message == "verificationCodeFalse") result.textContent = "Verification incorrect."
//    
//    // 已經寄信(含間隔時間過短) (O)
//    if(message == "alreadySent" || message == "sendSuccess") {
//    	result.classList.remove("error");
//    	result.classList.add("success");
//    	result.innerHTML = `Already sent the certification email <br>please enter the verification code below.`
//    }
//    
//    // 驗證成功 (O)
//    if(message == "activateSuccess") {
//    	result.classList.remove("error");
//    	result.classList.add("success");
//    	result.innerHTML = `Activate Success ! <br>Go MemberPage 3 Seconds later.`
//    	
//    	setTimeout(()=>{
//    		//window.location.replace('/MemberPage') // 成功跳轉會員頁
//    	},3000)
//    }
//    
//    // 寄出失敗
//    if(message == "tryLater") result.textContent = "Failed to send, try again later"
//
//}

// 清除錯誤
function cleanErrorMessage(){
    result.classList.add("hidden");
    result.classList.remove("error");
    result.textContent = ""
}

// 驗證碼
var verificationCode = "";

// 鍵盤輸入
window.addEventListener("keyup", (e) => {
 	
 	// Process 處理中文輸入法
    if (e.key != 'Process'){
 	
	    //獲取當前輸入的位置座標
	    let curIndex = e.target.getAttribute("data-index"); 
	    
	    // 驗證碼
	    verificationCode = "";
	
	    // 輸入鍵
	    let inputKey = e.key;
	
	    //如果點選 BackSpace刪除上一格 focus 到上一格
	    if (e && inputKey == "Backspace") {
	
	        if(curIndex == 0) {
	            inputArr[curIndex].value = "" ;
	            cleanErrorMessage();
	        }
	        else{
	            inputArr[curIndex-1].value = ""
	            inputArr[curIndex-1].focus();
	            cleanErrorMessage();
	        }
	        return;
	    }
	    
		// 輸入不是數字
		if (isNaN(inputKey) == true && inputKey != 'Backspace') {
		    	
		    inputArr[curIndex].value = " ";
		    showErrorMessage("notNum");
		    return;
		        
		 }
		
		 // 是數字清除錯誤訊息
		 if (isNaN(inputKey) != true) {
		     cleanErrorMessage();
		     inputArr[curIndex].value = inputKey ;
		 }
	
	    //遍歷陣列的值接成驗證碼字串
	    for (let i = 0; i <= 5; i ++) {
	        // console.log(inputArr[i].value);
	        verificationCode += inputArr[i].value;
	    }
	
	    // 確認拼接成功
	    // console.log(verificationCode);
	
	    //下一個座標
	    var nextIndex = Number(curIndex) + 1;
	
	    //判斷沒有 6 位驗證碼時自動跳轉下一個 autofocus
	    if (curIndex < 6 && verificationCode.length < 6) {
	        
	        // 檢查前面是否有空沒填
	        for (let i = 0; i <= curIndex; i++) {
	            
	            // 判斷前有空沒輸入的情況
	            if (!inputArr[i].value) {
	                inputArr[curIndex].blur(); // 現在位置 focusout
	                // inputArr[i].value = inputArr[curIndex].value;
	                let index = i;
	                inputArr[index].focus(); // focus 未填入的第一個
	                // inputArr[curIndex].value = "";
	                return;
	            } else {
	                // 前都有填 , 前查後面的 ,轉 focus 給下一位沒有的
	                for(let j = Number(curIndex) ; j < 6 ; j++){
	                    if (!inputArr[j].value){
	                        // let nextIndex = Number(curIndex) + 1;
	                        let nextIndex = j;
	                        inputArr[nextIndex].focus();
	                        break
	                    }
	                }
	
	                // console.log("focus ok");
	            }
	        }
	    }
	
	} // Process 處理中文輸入法
});


//---------------------------以下ajax-------------------------

// 403 錯誤
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function (e, xhr, options) {
    xhr.setRequestHeader(header, token);
});
// 403 錯誤

// 處理送出
let submitBtn = document.getElementById("confirmSubmit");

function doFirst(){
     
    //一進來就拿信
    getCertificationEmail();
    
    // 點擊送出驗證碼
    submitBtn.addEventListener('click', async ()=>{
       
        // 驗證碼未填滿
        if(verificationCode.length < 6){
            console.log(verificationCode);
            showErrorMessage("notFilled");
            return ;
        }
        console.log("OK");
		
		// 驗證碼填滿送出
		await fetch('/activateAccount',{
			
			method : 'POST',
	        headers : {
	            'Content-Type' : 'application/json',
	            "Accept": "application/json",
	            "X-Requested-With": "XMLHttpRequest",
	        	"X-CSRF-Token": token
	        },
	        credentials: "same-origin",
	        body :verificationCode,
	    	})
	    	
	    .then(response => {
//		  console.log(response);      
	      return response.json(); 
	    })
	    .then(data => {
		  console.log(data["emailResult"]);
		  
		  let resultMessage = data["emailResult"];
		  
		  // 失敗
		  if(resultMessage == "verificationCodeExpired") showErrorMessage("verificationCodeExpired");
		  if(resultMessage == "verificationCodeFalse") showErrorMessage("verificationCodeFalse");
		  
		  // 成功
		  if(resultMessage == "activateSuccess") showSuccessMessage("activateSuccess");
		  
	    })


    })
}

window.addEventListener('load',doFirst);














