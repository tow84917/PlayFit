"use strict"

// Canvas(525*200)
// 取Canves
let canvas = document.getElementById("canvas");
let context = canvas.getContext("2d");
context.beginPath();
context.font = "bold 12px Montserrat";

// 繪圖動畫一次畫 1/16
function drawAnimation(dailyBurn, graphicLen, intervalH) {
  if(graphicLen == 0) return ;

  let perPx = (graphicLen / 16); // 每次單位
  let bottom = 176.1 ; //繪製 y 座標底部
  let count = 0 ;
      setInterval(()=>{
          if(count == 16) {
              context.fillStyle = "#6460ff"
              context.fillRect(intervalH + 50 ,bottom , 30, -9.6); // 補上最後 少 -9.6 px
              clearInterval() ;
          }
          else {
              context.fillStyle = "#6460ff"
              context.fillRect(intervalH + 50, bottom , 30, perPx);
              bottom += perPx + 0.6  ;
              count ++ ;
          }
      },50)
}

// 渲染數據
// 之後作為非同步請求Ajax OK
// 之後要做 取七天期間日期 解決 NULL + 顯示控長條圖******
function renderExerciseData() {
  
  for (let i = 0; i < 7; i++) {
    // 日期顏色
    context.fillStyle = "#343633"
    // 間隔
    let intervalH = i * 70;
    // 抓近七天 ***
    // let weekDays = ["8/2", "8/3", "8/4", "8/5", "8/6", "8/7", "8/8"];
    context.fillText(weekDays[i], intervalH + 50, 197);
    
    // 長條圖顏色
    context.fillStyle = "#6460ff"
    // 長條圖 ***
    // let kaclData = [428, 526, 377, 668, 762, 536, 294];
    // context.fillRect(X,Y,寬,消耗Kcal/(100/17))
    let graphicLen = -(kaclData[i] / (100/17));
    let dailyBurn = kaclData[i];
    drawAnimation(dailyBurn, graphicLen, intervalH) ;
    // // context.fillRect(intervalH + 30, 205 - graphicLen, 30, graphicLen);
    // // 每日消耗卡洛里
    setTimeout(()=>{
      context.fillStyle = "#ff353b"
      context.fillText(dailyBurn, intervalH + 55, 178 + graphicLen - 7);
    },700)
  
  }
}

// 錯誤Icon
var errorImage = new Image();
errorImage.src = "/memberPage/img/errorIcon.png"

// error fnc
function getDataFaild(error){
    // error clg
    console.log(error); 
    // errorImage
    context.drawImage(errorImage,190,20);
    // error message
    context.font = "bold 12px Montserrat";
    context.fillStyle = "#ff353b"
    context.fillText("Oops! something wrong,try again later.", 140, 170);
}

// 非同步請求
// To Server requset for UserDailyRecord
let weekDays = [] ;
let kaclData = [] ;
// async 非同步 fnc
async function getUserDailyRecord() {
   await fetch(`/weeklyExerciseData`) 
    .then(response => {
      return response.json(); 
    })
    .then(data => {
      console.log(data);
      for(let i = 0; i < 7; i++){
        weekDays.push(data[i][0]) ;
        kaclData.push(data[i][1]) ;
      }
    }).then(() => 
      renderExerciseData()
    ).catch(error => getDataFaild(error));
}

// window load 開始畫基本Canvas
function doFirst() {
  // 繪製卡路里開始
  for (let i = 0; i < 11; i++) {
    // 間隔 (每100 kcal)
    let intervalV = i * 17;

    let kcalLevel = 1000;

    //消耗kcal
    //+n = 起始點
    context.fillStyle = "#343633"
    context.moveTo(43, intervalV + 5);
    context.lineTo(canvas.width-15, intervalV + 5);
    context.fillText(kcalLevel - (i * 100), 10, intervalV + 9);
  }

  // 渲染數據
  getUserDailyRecord();

  //橫線條
  context.strokeStyle = "rgba(0,0,0,0.10)";
  context.stroke();

  // 標記 kcal
  context.beginPath();
  context.font = "bold 12px Montserrat";
  context.fillStyle = "#ff353b"
  context.fillText("kcal", 10, 197);
  context.stroke();
}

window.addEventListener("load", doFirst);
