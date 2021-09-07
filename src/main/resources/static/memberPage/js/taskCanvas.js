"use strict"

// Canvas(490*15)
// ProgressBar column
let taskCanvas = document.getElementById("taskProgressBar");
let taskContext = taskCanvas.getContext("2d");
taskContext.beginPath();

// 繪圖動畫一次畫 1/18 s
function drawTaskAnimation(taskGraphicLen) {

    if(taskGraphicLen == 0) return ;
  
    let perPx = (taskGraphicLen / 20); // 每次單位
    let startPos = 0 ; //繪製 x 軸座標開始
    let count = 0 ;

    setInterval(()=>{
        if(count == 20) {
            taskContext.fillStyle = "#6460ff"
            taskContext.fillRect(startPos ,0 , 12, 25); // 補上最後 少 12 px
            clearInterval() ;
        }else {
            taskContext.fillStyle = "#6460ff"
            taskContext.fillRect(startPos, 0 , perPx, 25);
            startPos += perPx - 0.6 ;
            count ++ ;
        }
    },45)
}

let changeNumber = document.getElementById("progressNumber");

// 動態數字配合 ProgressBar
function dynamicNumber(progressData){
    let num = 0 ;
    // 每次增加數字
    let perNum = (progressData / 8).toFixed(1); 
    let count = 0 ;
    setInterval(()=>{
        if(count == 8) {
            changeNumber.textContent = `${progressData}% Done`;
            clearInterval() ; 
        }else{
            changeNumber.textContent = `${num.toFixed(1)}% Done`;
            num += parseFloat(perNum) ;
            count ++ ;
        }
    },112.5)
} 


// 今天日期、格式化
let date = new Date();
let today = date.getFullYear() + "-" + (date.getMonth() + 1) + "-" + date.getDate();


// 403 錯誤
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function (e, xhr, options) {
    xhr.setRequestHeader(header, token);
});
// 403 錯誤

// ajax 取當日運動完成率
async function getTaskCompletionRate(){
	
	// 傳送今日日期
	await fetch('/taskCompletionRate', {
        method : 'POST',
        headers : {
            'Content-Type' : 'application/json',
            "Accept": "application/json",
            "X-Requested-With": "XMLHttpRequest",
        	"X-CSRF-Token": token
        },
        credentials: "same-origin",
        body :JSON.stringify(date),
    })
    .then(response => {
//    	console.log(response);
    	return response.json()
    })
    .then(data => {
      console.log(data);
	  
	  // 取進度%數
      let progressData = data["completionRate"];
      
      // 換算畫圖長度
      let taskGraphicLen = progressData * (490 / 100);
      
      drawTaskAnimation(taskGraphicLen);
      dynamicNumber(progressData);
    })
}

function getTaskCompletionRate2(){
	
	$.ajax({
        url:'/taskCompletionRate' , 
        type: "POST" , 
        async:false , // Synchronous XMLHttpRequest on the main thread
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(date),
        success: function (data) {
          console.log('data: ', data);
          // 取進度%數
      	  let progressData = data["completionRate"];
      
		  // 換算畫圖長度
		  let taskGraphicLen = progressData * (490 / 100);
      
	      drawTaskAnimation(taskGraphicLen);
	      dynamicNumber(progressData);
	      
        },
        error: function () {
            console.log("error ---------->>>>>>>>>>>");
        },
    })

}

function doFirst(){
	
	getTaskCompletionRate();
//	getTaskCompletionRate2();
	
}

window.addEventListener("load", doFirst);











