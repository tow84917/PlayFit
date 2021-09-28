$(document).ready(init);

let g = 2;
let bmr = 0;

let bottom = null ;

function changeMainSizeToBig(){
	bottom.style="margin-bottom:800px";
}

function changeMainSizeToSmall(){
	bottom.style="margin-bottom:100px";
}

function init(){

	bottom = document.querySelector(".main");
	console.log(bottom);
	changBmibtn();
    $(".male-id").click(() =>{
        changMaleBtn();
        calculator3('male');
        g = 1;
    })
    $(".feMale-id").click(() =>{
        changFemaleBtn();
        calculator3('female');
        g = 0;
    })

    $(".calculator1-id").click(changCalculateBtn1); //變更calculate按鈕樣式 BMI
    $(".recovery1-id").click(changRecoveryBtn1); //變更Start Over按鈕樣式 BMI
    
    $(".calculator2-id").click(changCalculateBtn2); //變更calculate按鈕樣式 BFP
    $(".recovery2-id").click(changRecoveryBtn2); //變更Start Over按鈕樣式 BFP
   
    $(".calculator3-id").click(changCalculateBtn3); //變更calculate按鈕樣式 TDEE
    $(".recovery3-id").click(changRecoveryBtn3); //變更Start Over按鈕樣式 TDEE

    $(".clearall-id").click(clearbtn);//清除鍵

    $(".bmi-id").click(changBmibtn);// 變更BMI按鈕樣式
    $(".bfp-id").click(changBfpbtn);// 變更BFP按鈕樣式
    $(".tdee-id").click(changTdeebtn);// 變更TDEE按鈕樣式
    
}

//變更male按鈕樣式
function changMaleBtn() {
    console.log("進入 點男生 changMaleBtn");
    $(".male-id").addClass("btnVisited");
    $(".feMale-id").removeClass("btnVisited");
}

//變更feMale按鈕樣式
function changFemaleBtn() {
    console.log("進入 點女生 changFemaleBtn");
    $(".feMale-id").addClass("btnVisited");
    $(".male-id").removeClass("btnVisited");
}

// 變更CALCULATE按鈕樣式 BMI
function changCalculateBtn1() {
    let weight = document.getElementById('Weight').value
    let height = document.getElementById('Height').value
    if(weight == '' || height == ''){
    }
    else{       
    $(".calculator1-id").addClass("dis-none");
    $(".recovery1-id").removeClass("dis-none");
    $(".result1").removeClass("dis-none");
    changeMainSizeToBig();
    }
}

// 變更START OVER按鈕樣式 BMI
function changRecoveryBtn1() {
    $(".recovery1-id").addClass("dis-none");
    $(".result1").addClass("dis-none");
    $(".calculator1-id").removeClass("dis-none");
    changeMainSizeToSmall();
}

// 變更CALCULATE2按鈕樣式 BFP
function changCalculateBtn2() {
    let weight = document.getElementById('Weight2').value
    let height = document.getElementById('Height2').value
    let bmi = document.getElementById("Bmi").value;
    let age = document.getElementById("Age2").value;
    if(weight == '' || height == '' || bmi == '' || age == ''){    
    }
    else{       
    $(".calculator2-id").addClass("dis-none");
    $(".recovery2-id").removeClass("dis-none");
    $(".result2").removeClass("dis-none");
    changeMainSizeToBig();
    }
}

// 變更START OVER2按鈕樣式 BFP
function changRecoveryBtn2() {
    $(".recovery2-id").addClass("dis-none");
    $(".calculator2-id").removeClass("dis-none");
    $(".result2").addClass("dis-none");
    changeMainSizeToSmall();
}

// 變更CALCULATE3按鈕樣式 BMR&TDEE
function changCalculateBtn3() {
    let weight = document.getElementById('Weight3').value
    let height = document.getElementById('Height3').value
    let age = document.getElementById('Age3').value
    if(weight == '' || height == ''|| age == ''){}
    else{       
    $(".calculator3-id").addClass("dis-none");
    $(".recovery3-id").removeClass("dis-none");
    $(".result3").removeClass("dis-none");
    changeMainSizeToBig();
    }
}

// 變更START OVER3按鈕樣式 BMR&TDEE
function changRecoveryBtn3() {
    $(".recovery3-id").addClass("dis-none");
    $(".calculator3-id").removeClass("dis-none");
    $(".result3").addClass("dis-none");
    changeMainSizeToSmall();
}

// 變更BMI按鈕樣式
function changBmibtn() {
    $(".recovery2-id").addClass("dis-none");
    $(".calculator2-id").removeClass("dis-none");
    $(".recovery3-id").addClass("dis-none");
    $(".calculator3-id").removeClass("dis-none");

    $(".bmi-id").addClass("active");
    $(".tdee-id").removeClass("active");
    $(".bfp-id").removeClass("active");
    
    $(".result2").addClass("dis-none");
    $(".result3").addClass("dis-none");
    
    $("#tab1").removeClass("dis-none");
    $("#tab2").addClass("dis-none");
    $("#tab3").addClass("dis-none");
    
    changeMainSizeToSmall();
}

// 變更BFP按鈕樣式
function changBfpbtn() {
    $(".recovery1-id").addClass("dis-none");
    $(".calculator1-id").removeClass("dis-none");
    $(".recovery3-id").addClass("dis-none");
    $(".calculator3-id").removeClass("dis-none");

    $(".bfp-id").addClass("active");
    $(".bmi-id").removeClass("active");
    $(".tdee-id").removeClass("active");
    
    $(".result1").addClass("dis-none");
    $(".result3").addClass("dis-none");
    
    $("#tab1").addClass("dis-none");
    $("#tab2").removeClass("dis-none");
    $("#tab3").addClass("dis-none");
    
    changeMainSizeToSmall();
}

// 變更TDEE按鈕樣式
function changTdeebtn() {
    $(".recovery1-id").addClass("dis-none");
    $(".calculator1-id").removeClass("dis-none");
    $(".recovery2-id").addClass("dis-none");
    $(".calculator2-id").removeClass("dis-none");

    $(".tdee-id").addClass("active");
    $(".bmi-id").removeClass("active");
    $(".bfp-id").removeClass("active");
    
    $(".result1").addClass("dis-none");
    $(".result2").addClass("dis-none");
    
    $("#tab1").addClass("dis-none");
    $("#tab2").addClass("dis-none");
    $("#tab3").removeClass("dis-none");
    
    changeMainSizeToSmall();
}

// 默認選擇第一個tab
   (function () {
   if (window.location.hash) {
       window.location.hash;
   } else {
       window.location.hash = '#tab1';
   };
})();

// BMI計算
function calculator() {
    let weight = document.getElementById('Weight').value
    let height = document.getElementById('Height').value
    let bmi = weight / (height / 100 * height / 100);
    let BMI = bmi.toFixed(2);

    //錯誤顏色
    if(weight == ''){
        document.getElementById("Weight").style.backgroundColor = '#ffdddd' ;
    }else if(weight != ''){
        document.getElementById("Weight").style.backgroundColor = '#EBEEF8' ;
    }
    if(height == ''){
        document.getElementById("Height").style.backgroundColor = '#ffdddd' ;
    }else if(weight != ''){
        document.getElementById("Height").style.backgroundColor = '#EBEEF8' ;
    }

    if ( BMI > 25.7){
        text = "Your BMI is more than 25.7, your BMI is within the overweight category. This may not be good for your health.There are many benefits of moving towards a healthier weight, and even losing a small amount of weight can deliver major health benefits.";
        document.getElementById("answerbmi2").style.color = '#FF4040' ;
    }else if ( BMI < 18.2 ){
        text = "Your BMI is less than 18.2, your BMI is within the underweight category. This may not be good for your health.This may not be good for your health. There are many benefits of being a healthy weight. ";
        document.getElementById("answerbmi2").style.color = '#FF4040' ;
    }else {
        text = "Your BMI is between 18.5 and 24.9, your BMI is within the healthy weight category. This is generally good for your health.The challenge is to maintain that weight, and not put on weight as you get older.";
        document.getElementById("answerbmi2").style.color = 'black' ;
    }

    document.getElementById("answerbmi2").innerText = text ;
    document.getElementById('answerbmi').innerText = `BMI: ${BMI}`;

}

//BFP計算
function calculator2(){
    let weight = document.getElementById('Weight2').value
    let height = document.getElementById('Height2').value
    let bmi = document.getElementById("Bmi").value;
    let age = document.getElementById("Age2").value;
    let bfp = 1.2 * bmi + (0.23 * age) -5.4 - 10.8 * g;
    let BFP = Math.round(bfp * 100.0) / 100.0;

    //錯誤顏色
    if(weight == ''){
        document.getElementById("Weight2").style.backgroundColor = '#ffdddd' ;   
    }else if(weight != ''){
        document.getElementById("Weight2").style.backgroundColor = '#EBEEF8' ;
    }
    if(height == ''){
        document.getElementById("Height2").style.backgroundColor = '#ffdddd' ;   
    }else if(height != ''){
        document.getElementById("Height2").style.backgroundColor = '#EBEEF8' ;
    }
    if(bmi == ''){
        document.getElementById("Bmi").style.backgroundColor = '#ffdddd' ;   
    }else if(bmi != ''){
        document.getElementById("Bmi").style.backgroundColor = '#EBEEF8' ;
    }
    if(age == ''){
        document.getElementById("Age2").style.backgroundColor = '#ffdddd' ;
    }else if(age != ''){
        document.getElementById("Age2").style.backgroundColor = '#EBEEF8' ;
    }
    
    document.getElementById("answerbfp").innerText = `BFP: ${BFP}%`;

}


//BMR & TDEE 計算
function calculator3(gender) {
    var weight = document.getElementById('Weight3').value
    var height = document.getElementById('Height3').value
    var age = document.getElementById('Age3').value

    if(gender == 'male'){
    bmr = 66 + (13.7 * weight) + (5 * height) - (6.8 * age);
    }else if (gender == 'female'){
    bmr = 665 + (9.6 * weight) + (1.8 * height) - (4.7 * age);
    }
    document.getElementById('answerbmr2').innerText = `BMR: ${bmr}`;
    
    let exercise = document.getElementById('Exercise').value
    let tdee = bmr * exercise;
    let TDEE = Math.round(tdee * 100.0) / 100.0;
    document.getElementById('answertdee2').innerText = `TDEE: ${TDEE}`;


    //錯誤顏色
    if(weight == ''){
        document.getElementById("Weight3").style.backgroundColor = '#ffdddd' ;
    }else if(weight != ''){
        document.getElementById("Weight3").style.backgroundColor = '#EBEEF8' ;
    }
    if(height == ''){
        document.getElementById("Height3").style.backgroundColor = '#ffdddd' ;
    }else if(weight != ''){
        document.getElementById("Height3").style.backgroundColor = '#EBEEF8' ;
    }
    if(age == ''){
        document.getElementById("Age3").style.backgroundColor = '#ffdddd' ;
    }else if(age != ''){
        document.getElementById("Age3").style.backgroundColor = '#EBEEF8' ;
    }

}

// 清除鍵
function clearbtn() {
    $(".male-id").removeClass("btnVisited");
    $(".feMale-id").removeClass("btnVisited");

    document.getElementById("Weight").value = "";
    document.getElementById("Weight").style.backgroundColor = '#EBEEF8' ;
    document.getElementById("Height").value = "";
    document.getElementById("Height").style.backgroundColor = '#EBEEF8' ;

    document.getElementById("Weight2").value = ""; 
    document.getElementById("Weight2").style.backgroundColor = '#EBEEF8' ;
    document.getElementById("Height2").value = "";
    document.getElementById("Height2").style.backgroundColor = '#EBEEF8' ;
    document.getElementById("Age2").value = "";
    document.getElementById("Age2").style.backgroundColor = '#EBEEF8' ;
    document.getElementById("Bmi").value = "";
    document.getElementById("Bmi").style.backgroundColor = '#EBEEF8' ;

    document.getElementById("Weight3").value = "";
    document.getElementById("Weight3").style.backgroundColor = '#EBEEF8' ;
    document.getElementById("Height3").value = "";
    document.getElementById("Height3").style.backgroundColor = '#EBEEF8' ;
    document.getElementById("Age3").value = "";
    document.getElementById("Age3").style.backgroundColor = '#EBEEF8' ;
    document.getElementById("Exercise").value = "";
    document.getElementById("Exercise").style.backgroundColor = '#EBEEF8' ;
}
