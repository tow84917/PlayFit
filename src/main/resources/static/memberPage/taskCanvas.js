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
let progressData = taskCanvas.textContent;

// 動態數字配合 ProgressBar
function dynamicNumber(){
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



function doFirst(){
    // 取進度%數
    // let progressData = taskCanvas.text();
    // 換算畫圖長度
    let taskGraphicLen = progressData * (490 / 100);
    // 確認資訊
    // console.log(taskCanvas);
    // console.log(progressData);
    // console.log(taskGraphicLen);
    drawTaskAnimation(taskGraphicLen);
    dynamicNumber();
}

window.addEventListener("load", doFirst);