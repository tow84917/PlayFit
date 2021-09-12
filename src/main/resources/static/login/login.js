window.addEventListener('load',doFirst);

position = sessionStorage.position;

function doFirst(){     

    //初始化
    if(!position){
        position="left";
    }  
    if(position =="right"){
        swiftBox.style.transform="translate(100%,0)";
        // swiftBox.style.transition="none";
        swiftButton.innerText = `LOG IN`;
        changeTitle.innerHTML = `WELCOME BACK! <br> GORGEOUS!`;
        changeText.innerText=`Play more, fit more!`;
    }
    swiftButton = document.getElementById('swiftButton');
    swiftButton.addEventListener('click',move);


    
    let signUpSubmit = document.getElementById('signUpSubmit');
    let step2Modal = document.getElementById("step2Modal");
    let step2 = document.getElementById('step2');
    
    signUpSubmit.addEventListener('click',e =>{
        step2Modal.style.display = "block";
        step2.style.display = 'inline';
    })

    // Get the <span> element that closes the modal
    let step2Span = document.getElementsByClassName("close")[0];

    // When the user clicks on <span> (x), close the modal
    step2Span.onclick = function() {
    step2Modal.style.display = "none";
    }



//角色的三個部位
clothes = document.getElementById('clothes');
body = document.getElementById('body');
hat = document.getElementById('hat');


//step3元素
let step3Modal = document.getElementById('step3Modal');
let step3 = document.getElementById('step3');
let nextStep = document.getElementById('nextStep');


nextStep.addEventListener('click',e =>{
    step3Modal.style.display = "block";
    step3.style.display="inline";
    step2Modal.style.display = "none";
    //計算BMI
    let avatarSize;
    let currentWeight = document.getElementById('currentWeight').value;
    let height = document.getElementById('height').value;
    console.log(currentWeight);
    console.log(height);
    let BMI = currentWeight/((height/100)*(height/100));
    console.log(BMI);
    //角色初始預覽畫面
    if(BMI>=30.0){
        body.innerHTML= ``;      
        hat.innerHTML = ``;
        clothes.innerHTML = ``;
        avatarSize = 5;  
        // console.log(avatarSize);
    }else if(BMI<30.0 && BMI>=27.0){
        body.innerHTML= ``;      
        hat.innerHTML = ``;
        clothes.innerHTML = ``;
        avatarSize = 4;  
        // console.log(avatarSize);
    }else if(BMI<27.0 && BMI>=24.0){
        body.innerHTML= ``;      
        hat.innerHTML = ``;
        clothes.innerHTML = ``;
        avatarSize = 3;  
        // console.log(avatarSize);
    }else if(BMI<24.0 && BMI>=18.5){
        body.innerHTML= ``;      
        hat.innerHTML = ``;
        clothes.innerHTML = ``;
        avatarSize = 2;  
        // console.log(avatarSize);
    }else if(BMI<18.5){
        body.innerHTML= ``;      
        hat.innerHTML = ``;
        clothes.innerHTML = ``;
        avatarSize = 1;  
        // console.log(avatarSize);
    }

})



//radio選擇項
chooseColor_pink = document.getElementById("tab1-1");
chooseColor_red = document.getElementById("tab1-2");
chooseColor_blue = document.getElementById("tab1-3");
chooseColor_purple = document.getElementById("tab1-4");
chooseColor_lightpurple = document.getElementById("tab1-5");

chooseHat_blank = document.getElementById("tab2-1");
chooseHat_berets = document.getElementById("tab2-2");
chooseHat_orangehat = document.getElementById("tab2-3");
chooseHat_fishermenhat = document.getElementById("tab2-4");
chooseHat_gentlemenhat = document.getElementById("tab2-5");
chooseHat_greenhat = document.getElementById("tab2-6");

chooseClothes_blank = document.getElementById("tab3-1");
chooseClothes_scarf = document.getElementById("tab3-2");
chooseClothes_camera = document.getElementById("tab3-3");
chooseClothes_bowknot = document.getElementById("tab3-4");
chooseClothes_bowtie = document.getElementById("tab3-5");
chooseClothes_greentie = document.getElementById("tab3-6");

//角色整體
avatarPic = document.getElementById('avatarPic');

//判斷換顏色-------------------------------------
chooseColor_pink.addEventListener('click',e => {  
    if(avatarSize == 5){
        body.innerHTML = OBESE_pink;
    }else if(avatarSize == 4){
        body.innerHTML = OVERWEIGHT_pink;
    }else if(avatarSize == 3){
        body.innerHTML = NORMAL_pink;
    }else if(avatarSize == 2){
        body.innerHTML = SLIM_pink;
    }else if(avatarSize == 1){
        body.innerHTML = SKINNY_pink;
    }
    console.log(avatarPic.innerHTML);
});

chooseColor_red.addEventListener('click',e => {  
    if(avatarSize == 5){
        body.innerHTML = OBESE_red;
    }else if(avatarSize == 4){
        body.innerHTML = OVERWEIGHT_red;
    }else if(avatarSize == 3){
        body.innerHTML = NORMAL_red;
    }else if(avatarSize == 2){
        body.innerHTML = SLIM_red;
    }else if(avatarSize == 1){
        body.innerHTML = SKINNY_red;
    }
    console.log(avatarPic.innerHTML);
});

chooseColor_blue.addEventListener('click',e => {  
    if(avatarSize == 5){
        body.innerHTML = OBESE_blue;
    }else if(avatarSize == 4){
        body.innerHTML = OVERWEIGHT_blue;
    }else if(avatarSize == 3){
        body.innerHTML = NORMAL_blue;
    }else if(avatarSize == 2){
        body.innerHTML = SLIM_blue;
    }else if(avatarSize == 1){
        body.innerHTML = SKINNY_blue;
    }
    console.log(avatarPic.innerHTML);
});

chooseColor_purple.addEventListener('click',e => {  
    if(avatarSize == 5){
        body.innerHTML = OBESE_purple;
    }else if(avatarSize == 4){
        body.innerHTML = OVERWEIGHT_purple;
    }else if(avatarSize == 3){
        body.innerHTML = NORMAL_purple;
    }else if(avatarSize == 2){
        body.innerHTML = SLIM_purple;
    }else if(avatarSize == 1){
        body.innerHTML = SKINNY_purple;
    }
    console.log(avatarPic.innerHTML);
});

chooseColor_lightpurple.addEventListener('click',e => {  
    if(avatarSize == 5){
        body.innerHTML = OBESE_lightpurple;
    }else if(avatarSize == 4){
        body.innerHTML = OVERWEIGHT_lightpurple;
    }else if(avatarSize == 3){
        body.innerHTML = NORMAL_lightpurple;
    }else if(avatarSize == 2){
        body.innerHTML = SLIM_lightpurple;
    }else if(avatarSize == 1){
        body.innerHTML = SKINNY_lightpurple;
    }
    console.log(avatarPic.innerHTML);
});


//判斷換帽子-------------------------------------
chooseHat_blank.addEventListener('click',e => {  
    hat.innerHTML=``;
    console.log(avatarPic.innerHTML);
});
chooseHat_berets.addEventListener('click',e => {  
    if(avatarSize == 5){
        hat.innerHTML = OBESE_berets;
    }else if(avatarSize == 4){
        hat.innerHTML = OVERWEIGHT_berets;
    }else if(avatarSize == 3){
        hat.innerHTML = NORMAL_berets;
    }else if(avatarSize == 2){
        hat.innerHTML = SLIM_berets;
    }else if(avatarSize == 1){
        hat.innerHTML = SKINNY_berets;
    }
    console.log(avatarPic.innerHTML);
});
chooseHat_orangehat.addEventListener('click',e => {  
    if(avatarSize == 5){
        hat.innerHTML = OBESE_orangehat;
    }else if(avatarSize == 4){
        hat.innerHTML = OVERWEIGHT_orangehat;
    }else if(avatarSize == 3){
        hat.innerHTML = NORMAL_orangehat;
    }else if(avatarSize == 2){
        hat.innerHTML = SLIM_orangehat;
    }else if(avatarSize == 1){
        hat.innerHTML = SKINNY_orangehat;
    }
    console.log(avatarPic.innerHTML);
});
chooseHat_fishermenhat.addEventListener('click',e => {  
    if(avatarSize == 5){
        hat.innerHTML = OBESE_fishermenhat;
    }else if(avatarSize == 4){
        hat.innerHTML = OVERWEIGHT_fishermenhat;
    }else if(avatarSize == 3){
        hat.innerHTML = NORMAL_fishermenhat;
    }else if(avatarSize == 2){
        hat.innerHTML = SLIM_fishermenhat;
    }else if(avatarSize == 1){
        hat.innerHTML = SKINNY_fishermenhat;
    }
    console.log(avatarPic.innerHTML);
});
chooseHat_gentlemenhat.addEventListener('click',e => {  
    if(avatarSize == 5){
        hat.innerHTML = OBESE_gentlemenhat;
    }else if(avatarSize == 4){
        hat.innerHTML = OVERWEIGHT_gentlemenhat;
    }else if(avatarSize == 3){
        hat.innerHTML = NORMAL_gentlemenhat;
    }else if(avatarSize == 2){
        hat.innerHTML = SLIM_gentlemenhat;
    }else if(avatarSize == 1){
        hat.innerHTML = SKINNY_gentlemenhat;
    }
    console.log(avatarPic.innerHTML);
});
chooseHat_greenhat.addEventListener('click',e => {  
    if(avatarSize == 5){
        hat.innerHTML = OBESE_greenhat;
    }else if(avatarSize == 4){
        hat.innerHTML = OVERWEIGHT_greenhat;
    }else if(avatarSize == 3){
        hat.innerHTML = NORMAL_greenhat;
    }else if(avatarSize == 2){
        hat.innerHTML = SLIM_greenhat;
    }else if(avatarSize == 1){
        hat.innerHTML = SKINNY_greenhat;
    }
    console.log(avatarPic.innerHTML);
});

//判斷換衣服-------------------------------------
chooseClothes_blank.addEventListener('click',e => {  
    clothes.innerHTML=``;
    console.log(avatarPic.innerHTML);
});
chooseClothes_scarf.addEventListener('click',e => {  
    if(avatarSize == 5){
        hat.innerHTML = OBESE_scarf;
    }else if(avatarSize == 4){
        hat.innerHTML = OVERWEIGHT_scarf;
    }else if(avatarSize == 3){
        hat.innerHTML = NORMAL_scarf;
    }else if(avatarSize == 2){
        hat.innerHTML = SLIM_scarf;
    }else if(avatarSize == 1){
        hat.innerHTML = SKINNY_scarf;
    }
    console.log(avatarPic.innerHTML);
});
chooseClothes_camera.addEventListener('click',e => {  
    if(avatarSize == 5){
        hat.innerHTML = OBESE_camera;
    }else if(avatarSize == 4){
        hat.innerHTML = OVERWEIGHT_camera;
    }else if(avatarSize == 3){
        hat.innerHTML = NORMAL_camera;
    }else if(avatarSize == 2){
        hat.innerHTML = SLIM_camera;
    }else if(avatarSize == 1){
        hat.innerHTML = SKINNY_camera;
    }
    console.log(avatarPic.innerHTML);
});
chooseClothes_bowknot.addEventListener('click',e => {  
    if(avatarSize == 5){
        hat.innerHTML = OBESE_bowknot;
    }else if(avatarSize == 4){
        hat.innerHTML = OVERWEIGHT_bowknot;
    }else if(avatarSize == 3){
        hat.innerHTML = NORMAL_bowknot;
    }else if(avatarSize == 2){
        hat.innerHTML = SLIM_bowknot;
    }else if(avatarSize == 1){
        hat.innerHTML = SKINNY_bowknot;
    }
    console.log(avatarPic.innerHTML);
});
chooseClothes_bowtie.addEventListener('click',e => {  
    if(avatarSize == 5){
        hat.innerHTML = OBESE_bowtie;
    }else if(avatarSize == 4){
        hat.innerHTML = OVERWEIGHT_bowtie;
    }else if(avatarSize == 3){
        hat.innerHTML = NORMAL_bowtie;
    }else if(avatarSize == 2){
        hat.innerHTML = SLIM_bowtie;
    }else if(avatarSize == 1){
        hat.innerHTML = SKINNY_bowtie;
    }
    console.log(avatarPic.innerHTML);
});
chooseClothes_greentie.addEventListener('click',e => {  
    if(avatarSize == 5){
        hat.innerHTML = OBESE_greentie;
    }else if(avatarSize == 4){
        hat.innerHTML = OVERWEIGHT_greentie;
    }else if(avatarSize == 3){
        hat.innerHTML = NORMAL_greentie;
    }else if(avatarSize == 2){
        hat.innerHTML = SLIM_greentie;
    }else if(avatarSize == 1){
        hat.innerHTML = SKINNY_greentie;
    }
    console.log(avatarPic.innerHTML);
});



// 403 錯誤
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function (e, xhr, options) {
    xhr.setRequestHeader(header, token);
});
// 403 錯誤



//完成表單 送出請求
let doneBtn = document.getElementById('doneBtn');

doneBtn.addEventListener('click', e => {
    
    let data = getPictureData();
    
    fetch('/process_avatar', {
        method : 'POST',
        headers : {
            'Content-Type' : 'application/json',
            "Accept": "application/json",
            "X-Requested-With": "XMLHttpRequest",
        	"X-CSRF-Token": token
        },
        credentials: "same-origin",
        body :data,
    })
    .then(response => {
       console.log(response); 
       return response.json();
    })
    .then(data =>{ 
    	console.log(data);
    })
});
}




//切換登入-註冊
function move(){
    changeTitle = document.getElementById('changeTitle');
    changeText = document.getElementById('changeText');
    swiftBox = document.getElementById('swiftBox');

    if(position == "left"){
    swiftBox.style.transform="translate(100%,0)";
    swiftButton.innerText = `LOG IN`;
    changeTitle.innerHTML = `WELCOME BACK! <br> GORGEOUS!`;
    changeText.innerText=`Play more, fit more!`;
    position = "right";
    sessionStorage.position= position;
    }else{
    swiftBox.style.transform="translate(0,0)";
    swiftButton.innerText = `SIGN UP`;
    changeTitle.innerHTML = `HELLO,<br>NEW-<br>COMER!`;
    changeText.innerHTML=`Need more exercises?<br>Come join us!`;
    position = "left";
    sessionStorage.position= position;
    }
}



//角色圖片資料
function getPictureData() {
    let header = `<?xml version="1.0" encoding="utf-8"?>
                  <svg version="1.1" id="avatarPic" xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" 
                  viewBox="0 0 300 350" xml:space="preserve">`;
    let style = `<style type="text/css">
  .st0{fill:#A52224;}
  .st1{fill:#D93030;}
  .st2{fill:none;stroke:#040000;stroke-width:5.3533;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:10;}
  .st3{fill:#E83C3C;}
  .st4{fill:#F08E93;}
  .st5{fill:none;stroke:#040000;stroke-width:4.6992;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:10;}
  .st6{fill:#040000;}
  .st7{fill:#DB9451;}
  .st8{fill:#F4B55E;}
  .st9{fill:#EC6519;}
  .st10{fill:#EF7C33;}
  .st11{fill:#CCCCCC;}
  .st12{fill:#E6E6E5;}
  .st13{fill:#B75320;}
  .st14{fill:#B3B3B3;}
  .st15{fill-rule:evenodd;clip-rule:evenodd;fill:#4D4D4D;}
  .st16{fill:#4D4D4D;}
  .st17{fill:#323333;}
  .st18{fill:#9C4623;}
  .st19{fill-rule:evenodd;clip-rule:evenodd;fill:#CBE8F0;}
  .st20{fill-rule:evenodd;clip-rule:evenodd;fill:#E1F0F3;}
  .st21{fill-rule:evenodd;clip-rule:evenodd;fill:#9ECCD5;}
  .st22{fill-rule:evenodd;clip-rule:evenodd;fill:#323333;}
  .st23{fill-rule:evenodd;clip-rule:evenodd;fill:#666666;}
  .st24{fill:none;stroke:#F4B55E;stroke-width:2.378;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:10;}
                 </style>`;
    let data = avatarPic.innerHTML;
  
    return header + style + data + `</svg>`;
  }



//avatar資料

// // skinny
// const SKINNY_pink = ``;
// const SKINNY_red = ``;
// const SKINNY_blue = ``;
// const SKINNY_purple = ``;
// const SKINNY_lightpurple = ``;

// const SKINNY_berets = ``;
// const SKINNY_orangehat = ``;
// const SKINNY_fishermenhat = ``;
// const SKINNY_gentlemenhat = ``;
// const SKINNY_greenhat = ``;

// const SKINNY_scarf = ``;
// const SKINNY_camera = ``;
// const SKINNY_bowknot = ``;
// const SKINNY_bowtie = ``;
// const SKINNY_greentie = ``;

// // slim
// const SLIM_pink;
// const SLIM_red;
// const SLIM_blue;
// const SLIM_purple;
// const SLIM_lightpurple;

// const SLIM_berets = ``;
// const SLIM_orangehat = ``;
// const SLIM_fishermenhat = ``;
// const SLIM_gentlemenhat = ``;
// const SLIM_greenhat = ``;

// const SLIM_scarf = ``;
// const SLIM_camera = ``;
// const SLIM_bowknot = ``;
// const SLIM_bowtie = ``;
// const SLIM_greentie = ``;


// // normal
// const NORMAL_pink =``;
// const NORMAL_red =``;
// const NORMAL_blue =``;
// const NORMAL_purple =``;
// const NORMAL_lightpurple =``;

// const NORMAL_berets = ``;
// const NORMAL_orangehat = ``;
// const NORMAL_fishermenhat = ``;
// const NORMAL_gentlemenhat = ``;
// const NORMAL_greenhat = ``;

// const NORMAL_scarf = ``;
// const NORMAL_camera = ``;
// const NORMAL_bowknot = ``;
// const NORMAL_bowtie = ``;
// const NORMAL_greentie = ``;


// // overweight
// const OVERWEIGHT_pink =``;
// const OVERWEIGHT_red =``;
// const OVERWEIGHT_blue =``;
// const OVERWEIGHT_purple =``;
// const OVERWEIGHT_lightpurple =``;

// const OVERWEIGHT_berets = ``;
// const OVERWEIGHT_orangehat = ``;
// const OVERWEIGHT_fishermenhat = ``;
// const OVERWEIGHT_gentlemenhat = ``;
// const OVERWEIGHT_greenhat = ``;

// const OVERWEIGHT_scarf = ``;
// const OVERWEIGHT_camera = ``;
// const OVERWEIGHT_bowknot = ``;
// const OVERWEIGHT_bowtie = ``;
// const OVERWEIGHT_greentie = ``;


// // obese
// const OBESE_pink =``;
// const OBESE_red =``;
// const OBESE_blue =``;
// const OBESE_purple =``;
// const OBESE_lightpurple =``;

// const OBESE_berets = ``;
// const OBESE_orangehat = ``;
// const OBESE_fishermenhat = ``;
// const OBESE_gentlemenhat = ``;
// const OBESE_greenhat = ``;

// const OBESE_scarf = ``;
// const OBESE_camera = ``;
// const OBESE_bowknot = ``;
// const OBESE_bowtie = ``;
// const OBESE_greentie = ``;
