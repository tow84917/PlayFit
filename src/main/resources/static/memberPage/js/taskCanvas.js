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

// ajax 取當日運動完成率
async function getTaskCompletionRate(){
	
	// 傳送今日日期
	fetch('/ajaxTaskCompletionRate', {
        method : 'POST',
        headers : {
            'Content-Type' : 'application/json'
        },
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

function doFirst(){
	
	getTaskCompletionRate();
	
}

window.addEventListener("load", doFirst);











