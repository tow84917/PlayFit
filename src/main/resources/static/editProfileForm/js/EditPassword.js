"use strict"

// 新密碼
let newPassword = document.getElementById("newPassword");
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












