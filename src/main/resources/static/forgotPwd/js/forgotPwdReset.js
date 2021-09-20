"use strict"

// 使用者輸入欄
let newPassword = document.getElementById("newPassword");
let confimPassword = document.getElementById("confimPassword");

// 重製Token
let resetToken = document.getElementById("resetToken").value;

// 結果與訊息欄
var result = document.querySelector(".result");

// 顯示訊息
function showMessage(message){
    result.classList.remove("hidden");
    result.classList.remove("success");
    result.classList.add("error");
	
	// 前端檢查(尚未輸入)
    if(message == "notFilled") result.innerHTML = `NewPassword or ConfimPassword <br> can not be empty.`
    
    // 確認密碼不同
    if(message == "confimPwdError") result.textContent = "Does not match the confirmed password."
    
    // 密碼長度不足
    if(message == "passwordSizeError") result.innerHTML = `Insufficient password length.`
    
    // -------------以下回傳結果------------
    
    // 修改成功
    if(message == "resetPasswordSuccess") {
    	result.classList.remove("error");
    	result.classList.add("success");
    	result.innerHTML = `You have successfully changed your password, <br>please login again.`
    	
    	setTimeout(()=>{
    		window.location.replace('/login?resetPassword=true') // 成功跳轉會員頁
    	},3000)
    }
    
    // 這是你原本的密碼
    if(message == "isOriginPassword") result.textContent = "New and old passwords are the same."
}

// 重製密碼
async function resetPwd(newPassword, confimPassword , token){
	
	await fetch('/resetPassword', {
		method : 'POST',
	    headers : {
	    'Content-Type' : 'application/json',
	    "Accept": "application/json",
	    },
	    body :JSON.stringify({
	    	"newPwd" : newPassword,
	    	"confimPwd" : confimPassword,
	    	"token" : token,
	    }),	
	})
	
    .then(response => {
//	  console.log(response);      
      return response.json(); 
    })
    
    .then(data => {
      console.log(data["resetPasswordResult"]);
      showMessage(data["resetPasswordResult"]);
    });
}


// 處理送出
let submitBtn = document.getElementById("confirmSubmit");

// 點擊重置密碼
submitBtn.addEventListener('click', ()=>{
	
	 let inputNewPwd = newPassword.value ;
	 let inputConfimPwd = confimPassword.value ;
	 
	 // 去前後空格
	 inputNewPwd = inputNewPwd.trim(); 
	 inputConfimPwd = inputConfimPwd.trim(); 
	 //console.log(inputEmail)
	 
	 // 未填入
     if(inputNewPwd.length < 1 || inputConfimPwd.length < 1){
        showMessage("notFilled");
        return ;
     }
     
     // 長度密碼不足
     if(inputNewPwd.length < 7){
        showMessage("passwordSizeError");
        return ;
     }
     
     // 確認密碼不同
     if(inputNewPwd !== inputConfimPwd){
        showMessage("confimPwdError");
        return ;
     }
     
	 // 重製密碼
	 resetPwd(inputNewPwd, inputConfimPwd, resetToken);

});


//------------------以下檢查密碼強度------------------

// 顯示強度 Box
let Strength = document.getElementById("intension");
// 5個空格
let nodes = Strength.getElementsByTagName("div");

// 每次輸入
newPassword.oninput = function() {
// onkeyup
  let newValue = newPassword.value;

  // 加入Class
  for(let i = 0; i < nodes.length; i++) {
    nodes[i].className = '';
  }
  // 偵測擁有的字 count
  let upperCase = 0 ;
  let lowerCase = 0 ;
  let number = 0 ;
  let specChar = 0 ;
  
  for(let i = 0 ; i < newValue.length ; i++){
    
    let char = newValue[i];
    
    // A-Z
    if(/[A-Z]/.test(char)) {
      upperCase ++ ;
    } ;

    // a-z
    if(/[a-z]/.test(char)) {
      lowerCase ++ ;
    } 
    
    // 0-9
    if(/\d/.test(char)) {
      number ++ ;
    }
    
    // 特殊字元
    if(/\W/.test(char)) {
      specChar ++ ;
    }    
  }

  // console.log(newValue);
  // console.log(upperCase);
  // console.log(lowerCase);
  // console.log(number);
  // console.log(specChar);

  // 四種都有 10 碼以上
  if((upperCase != 0) && (lowerCase != 0) && (number != 0) && (specChar != 0)
      && (number + lowerCase + upperCase >= 10 )){

  nodes[0].className = "strong";
  nodes[1].className = "strong";
  nodes[2].className = "strong";
  nodes[3].className = "strong";
  nodes[4].className = "strong";

  // 有三種 8碼以上  C43 不重複 = 4種組合
  }else if((
  	(upperCase != 0) && (lowerCase != 0) && (number != 0) ||    
  	(upperCase != 0) && (lowerCase != 0) && (specChar != 0) ||  
  	(upperCase != 0) && (number != 0) && (specChar != 0) ||     
  	(number != 0) && (lowerCase != 0) && (specChar != 0)      
  ) && (number + lowerCase + upperCase >= 8 )){

  nodes[0].className = "good";
  nodes[1].className = "good";
  nodes[2].className = "good";
  nodes[3].className = "good";
  
  // 有2種 9碼以上
  }else if(((upperCase != 0) && (lowerCase != 0)) || ((upperCase != 0) && (number != 0))
      || ((lowerCase != 0) && (number != 0))
      && (number + lowerCase + upperCase >= 9 )) {

  nodes[0].className = "normal";
  nodes[1].className = "normal";  
  nodes[2].className = "normal";

  // 有2種 7碼以上 或 1種9碼以上
  }else if((((upperCase != 0) && (lowerCase != 0)) || ((upperCase != 0) && (number != 0))
      || ((lowerCase != 0) && (number != 0)) && (number + lowerCase + upperCase >= 7 )) 
      || (number + lowerCase + upperCase >= 9 )) {

  nodes[0].className = "week";
  nodes[1].className = "week";  

  }else{ // none
    
  nodes[0].className = "none";
  }
}


//------------------以下眼睛功能------------------

let eye1 = document.querySelector(".eye1"); // new pwd
let eye2 = document.querySelector(".eye2"); //comfim pwd

let openEyeSrc = '/editProfileForm/img/eye.png' ;
let closeEyeSrc = '/editProfileForm/img/eyeclosed.png' ;

function toggleEye(type){

	if(type == 1){

		// 改Type
		let type = $("#newPassword").attr("type");
		if(type === "password") $("#newPassword").prop("type","text");
		else $("#newPassword").prop("type","password");

		// 改 icon src
		let eyeSrc = eye1.src ;
		
		//console.log(eyeSrc);
				
		if(eyeSrc === 'http://localhost:8080' + closeEyeSrc) 
		eye1.src = openEyeSrc ;
				
		else 
		eye1.src = closeEyeSrc ;
	}
	
	if(type == 2){
				
		// 改Type
		let type = $("#confimPassword").attr("type");
		if(type === "password") $("#confimPassword").prop("type","text");
		else $("#confimPassword").prop("type","password");
				
		// 改 icon src
		let eyeSrc = eye2.src ;
				
		if(eyeSrc === 'http://localhost:8080' + closeEyeSrc) 
		eye2.src = openEyeSrc ;
				
		else 
		eye2.src = closeEyeSrc ;
	}
			
}

function doFirst(){
			
	// newPwd
	eye1.addEventListener('click', ()=>{
		toggleEye(1)
	});
			
	// confimPwd
	eye2.addEventListener('click', ()=>{
		toggleEye(2)
	});
					
}

window.addEventListener("load", doFirst);























