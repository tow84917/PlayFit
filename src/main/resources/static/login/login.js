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


    //step1欄位
    let email = document.getElementById('email');
    let fullName = document.getElementById('fullName');
    let password = document.getElementById('password');

    //step2欄位
    let currentWeight = document.getElementById('currentWeight');
    let targetWeight = document.getElementById('targetWeight');
    let height = document.getElementById('height');
    let birthday = document.getElementById('birthday');
    let activityLevel = document.getElementById('activityLevel');


    
    let signUpSubmit = document.getElementById('signUpSubmit');
    let step2Modal = document.getElementById("step2Modal");
    let step2 = document.getElementById('step2');

    // When the user starts to type something inside the password field
    emailValid = false;
    email.addEventListener('keyup',emailValidate);
    email.addEventListener('change',emailValidate);

    function emailValidate() {
        emailValid = false;
        email.style.background = '#EBEEF8';
        email.style.color = 'black';
        //Regular expression Testing
        let emailRule = /^\w+((-\w+)|(\.\w+))*\@[A-Za-z0-9]+((\.|-)[A-Za-z0-9]+)*\.[A-Za-z]+$/;
        if(email.value.match(emailRule)){
            email.style.color = '#2E1ED3';
            emailValid = true;
        }
    }


    fullName.onkeyup = function() {
        fullName.style.background = '#EBEEF8';
        fullNameValid = true;
    }
    password.onkeyup = function() {
        password.style.background = '#EBEEF8';
        passwordValid = true;
    }


    signUpSubmit.addEventListener('click',e =>{
        // 判斷step1必填是否合法
        if(!emailValid){
            email.style.background = '#ffdddd';
        }
        if(fullName.value == `` ){
            fullName.style.background = '#ffdddd';
            fullNameValid = false;
        }
        if(password.value == `` ){
            password.style.background = '#ffdddd';
            passwordValid = false;
        }
        
        if(emailValid & fullNameValid & passwordValid){
            step2Modal.style.display = "block";
            step2.style.display = 'inline';
        }
    });

    // Get the <span> element that closes the modal
    let step2Span = document.getElementsByClassName("close")[0];

    // When the user clicks on <span> (x), close the modal
    step2Span.onclick = function() {
    step2Modal.style.display = "none";
    currentWeight.style.background = '#EBEEF8';
    targetWeight.style.background = '#EBEEF8';
    height.style.background = '#EBEEF8';
    birthday.style.background = '#EBEEF8';
    activityLevel.style.background = '#EBEEF8';
    }

    // Get the <span> element that closes the modal
    let step3Span = document.getElementsByClassName("close")[1];

    // When the user clicks on <span> (x), close the modal
    step3Span.onclick = function() {
    step3Modal.style.display = "none";
    colorInfo = 'pink';
    hatInfo = null;
    clothesInfo = null;
    let cube = document.getElementsByClassName('segmented-control__color');
    for(let i = 0; i < cube.length; i++){
        cube[i].style.transform= 'translateX(0)';
        }
    }



//角色的三個部位
clothes = document.getElementById('clothes');
body = document.getElementById('body');
hat = document.getElementById('hat');

//step3元素
let avatarSize;
let step3Modal = document.getElementById('step3Modal');
let step3 = document.getElementById('step3');
let nextStep = document.getElementById('nextStep');


// When the user starts to type something inside the password field
    currentWeightValid = false;
    currentWeight.addEventListener('keyup',currentWeightValidate);
    currentWeight.addEventListener('change',currentWeightValidate);

    function currentWeightValidate() {
        currentWeightValid = false;
        currentWeight.style.color = 'black';
        currentWeight.style.background = '#EBEEF8';    
        if(currentWeight.value>=35 && currentWeight.value<=300){
            currentWeight.style.color = '#2E1ED3';
            currentWeightValid = true;
        }
    }

    targetWeightValid = false;
    targetWeight.addEventListener('keyup',targetWeightValidate);
    targetWeight.addEventListener('change',targetWeightValidate);

    // targetWeight.onkeyup = function(){a()};
    // targetWeight.onchange = function(){a()};

    function targetWeightValidate() {
        targetWeightValid = false;
        targetWeight.style.color = 'black';
        targetWeight.style.background = '#EBEEF8';    
        if(targetWeight.value>=35 && targetWeight.value<=300){
            targetWeight.style.color = '#2E1ED3';
            targetWeightValid = true;
        }
    }

    heightValid = false;
    height.addEventListener('keyup',heightValidate);
    height.addEventListener('change',heightValidate);

    function heightValidate() {
        heightValid = false;
        height.style.color = 'black';
        height.style.background = '#EBEEF8';    
        if(height.value>=50 && height.value<=300){
            height.style.color = '#2E1ED3';
            heightValid = true;
        }
    }

    birthdayValid = false;
    birthday.addEventListener('keyup',birthdayValidate);
    birthday.addEventListener('change',birthdayValidate);

    function birthdayValidate() {
        birthdayValid = false;
        birthday.style.color = 'black';
        birthday.style.background = '#EBEEF8';  
        let dateReg = /^[1-9]\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;  
        if(birthday.value.match(dateReg)){
            birthday.style.color = '#2E1ED3';
            birthdayValid = true;
        }
    }

    activityLevelValid = false;
    activityLevel.onchange = function() {
        activityLevel.style.background = '#EBEEF8';    
        if(activityLevel.value != ``){
            activityLevelValid = true;
            activityLevel.style.color = '#2E1ED3';
        }else{
            activityLevelValid = false;
            activityLevel.style.color = 'black';
        }
    }



nextStep.addEventListener('click',e =>{

    //判斷step2是否合法
    if(!currentWeightValid ){
        currentWeight.style.background = '#ffdddd';
    }
    if(!targetWeightValid ){
        targetWeight.style.background = '#ffdddd';
    }
    if(!heightValid ){
        height.style.background = '#ffdddd';
    }
    if(!birthdayValid ){
        birthday.style.background = '#ffdddd';
    }
    if(!activityLevelValid ){
        activityLevel.style.background = '#ffdddd';
    }

    if(currentWeightValid & targetWeightValid & heightValid & birthdayValid & activityLevelValid){
        step3Modal.style.display = "block";
        step3.style.display="inline";
        step2Modal.style.display = "none";
    }


    //計算BMI
    let currentWeightVal = currentWeight.value;
    let heightVal = height.value;
    console.log(currentWeightVal);
    console.log(heightVal);
    let BMI = currentWeightVal/((heightVal/100)*(heightVal/100));
    console.log(BMI);
    //角色初始預覽畫面
    if(BMI>=32.0){
        body.innerHTML= OBESE_pink;      
        hat.innerHTML = ``;
        clothes.innerHTML = ``;
        avatarSize = 'OBESE';  
        // console.log(avatarSize);
    }else if(BMI<32.0 && BMI>=24.5){
        body.innerHTML= OVERWEIGHT_pink;      
        hat.innerHTML = ``;
        clothes.innerHTML = ``;
        avatarSize = 'OVERWEIGHT';  
        // console.log(avatarSize);
    }else if(BMI<24.5 && BMI>=18.5){
        body.innerHTML= NORMAL_pink;      
        hat.innerHTML = ``;
        clothes.innerHTML = ``;
        avatarSize = 'NORMAL';  
        // console.log(avatarSize);
    }else if(BMI<18.5 && BMI>=16.0){
        body.innerHTML= SLIM_pink;      
        hat.innerHTML = ``;
        clothes.innerHTML = ``;
        avatarSize = 'SLIM';  
        // console.log(avatarSize);
    }else if(BMI<16.0){
        body.innerHTML= SKINNY_pink;      
        hat.innerHTML = ``;
        clothes.innerHTML = ``;
        avatarSize = 'SKINNY';  
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

let colorInfo = `pink`;
chooseColor_pink.addEventListener('click',e => {  
    if(avatarSize == 'OBESE'){
        body.innerHTML = OBESE_pink;
    }else if(avatarSize == 'OVERWEIGHT'){
        body.innerHTML = OVERWEIGHT_pink;
    }else if(avatarSize == 'NORMAL'){
        body.innerHTML = NORMAL_pink;
    }else if(avatarSize == 'SLIM'){
        body.innerHTML = SLIM_pink;
    }else if(avatarSize == 'SKINNY'){
        body.innerHTML = SKINNY_pink;
    }
    // console.log(avatarPic.innerHTML);
    colorInfo = `pink`;
    console.log(avatarSize,hatInfo,clothesInfo,colorInfo);
});

chooseColor_red.addEventListener('click',e => {  
    if(avatarSize == 'OBESE'){
        body.innerHTML = OBESE_red;
    }else if(avatarSize == 'OVERWEIGHT'){
        body.innerHTML = OVERWEIGHT_red;
    }else if(avatarSize == 'NORMAL'){
        body.innerHTML = NORMAL_red;
    }else if(avatarSize == 'SLIM'){
        body.innerHTML = SLIM_red;
    }else if(avatarSize == 'SKINNY'){
        body.innerHTML = SKINNY_red;
    }
    // console.log(avatarPic.innerHTML);
    colorInfo = 'red';
    console.log(avatarSize,hatInfo,clothesInfo,colorInfo);
});

chooseColor_blue.addEventListener('click',e => {  
    if(avatarSize == 'OBESE'){
        body.innerHTML = OBESE_blue;
    }else if(avatarSize == 'OVERWEIGHT'){
        body.innerHTML = OVERWEIGHT_blue;
    }else if(avatarSize == 'NORMAL'){
        body.innerHTML = NORMAL_blue;
    }else if(avatarSize == 'SLIM'){
        body.innerHTML = SLIM_blue;
    }else if(avatarSize == 'SKINNY'){
        body.innerHTML = SKINNY_blue;
    }
    // console.log(avatarPic.innerHTML);
    colorInfo = 'blue';
    console.log(avatarSize,hatInfo,clothesInfo,colorInfo);
});

chooseColor_purple.addEventListener('click',e => {  
    if(avatarSize == 'OBESE'){
        body.innerHTML = OBESE_purple;
    }else if(avatarSize == 'OVERWEIGHT'){
        body.innerHTML = OVERWEIGHT_purple;
    }else if(avatarSize == 'NORMAL'){
        body.innerHTML = NORMAL_purple;
    }else if(avatarSize == 'SLIM'){
        body.innerHTML = SLIM_purple;
    }else if(avatarSize == 'SKINNY'){
        body.innerHTML = SKINNY_purple;
    }
    // console.log(avatarPic.innerHTML);
    colorInfo = 'purple';
    console.log(avatarSize,hatInfo,clothesInfo,colorInfo);
});

chooseColor_lightpurple.addEventListener('click',e => {  
    if(avatarSize == 'OBESE'){
        body.innerHTML = OBESE_lightpurple;
    }else if(avatarSize == 'OVERWEIGHT'){
        body.innerHTML = OVERWEIGHT_lightpurple;
    }else if(avatarSize == 'NORMAL'){
        body.innerHTML = NORMAL_lightpurple;
    }else if(avatarSize == 'SLIM'){
        body.innerHTML = SLIM_lightpurple;
    }else if(avatarSize == 'SKINNY'){
        body.innerHTML = SKINNY_lightpurple;
    }
    // console.log(avatarPic.innerHTML);
    colorInfo = 'lightpurple';
    console.log(avatarSize,hatInfo,clothesInfo,colorInfo);
});


//判斷換帽子-------------------------------------

let hatInfo = null;
chooseHat_blank.addEventListener('click',e => {  
    hat.innerHTML=``;
    // console.log(avatarPic.innerHTML);
    hatInfo = null;
    console.log(avatarSize,hatInfo,clothesInfo,colorInfo);
});
chooseHat_berets.addEventListener('click',e => {  
    if(avatarSize == 'OBESE'){
        hat.innerHTML = OBESE_berets;
    }else if(avatarSize == 'OVERWEIGHT'){
        hat.innerHTML = OVERWEIGHT_berets;
    }else if(avatarSize == 'NORMAL'){
        hat.innerHTML = NORMAL_berets;
    }else if(avatarSize == 'SLIM'){
        hat.innerHTML = SLIM_berets;
    }else if(avatarSize == 'SKINNY'){
        hat.innerHTML = SKINNY_berets;
    }
    // console.log(avatarPic.innerHTML);
    hatInfo = 'Berets';
    console.log(avatarSize,hatInfo,clothesInfo,colorInfo);
});
chooseHat_orangehat.addEventListener('click',e => {  
    if(avatarSize == 'OBESE'){
        hat.innerHTML = OBESE_orangehat;
    }else if(avatarSize == 'OVERWEIGHT'){
        hat.innerHTML = OVERWEIGHT_orangehat;
    }else if(avatarSize == 'NORMAL'){
        hat.innerHTML = NORMAL_orangehat;
    }else if(avatarSize == 'SLIM'){
        hat.innerHTML = SLIM_orangehat;
    }else if(avatarSize == 'SKINNY'){
        hat.innerHTML = SKINNY_orangehat;
    }
    // console.log(avatarPic.innerHTML);
    hatInfo = 'Orangehat';
    console.log(avatarSize,hatInfo,clothesInfo,colorInfo);
});
chooseHat_fishermenhat.addEventListener('click',e => {  
    if(avatarSize == 'OBESE'){
        hat.innerHTML = OBESE_fishermenhat;
    }else if(avatarSize == 'OVERWEIGHT'){
        hat.innerHTML = OVERWEIGHT_fishermenhat;
    }else if(avatarSize == 'NORMAL'){
        hat.innerHTML = NORMAL_fishermenhat;
    }else if(avatarSize == 'SLIM'){
        hat.innerHTML = SLIM_fishermenhat;
    }else if(avatarSize == 'SKINNY'){
        hat.innerHTML = SKINNY_fishermenhat;
    }
    // console.log(avatarPic.innerHTML);
    hatInfo = 'Fishermenhat';
    console.log(avatarSize,hatInfo,clothesInfo,colorInfo);
});
chooseHat_gentlemenhat.addEventListener('click',e => {  
    if(avatarSize == 'OBESE'){
        hat.innerHTML = OBESE_gentlemenhat;
    }else if(avatarSize == 'OVERWEIGHT'){
        hat.innerHTML = OVERWEIGHT_gentlemenhat;
    }else if(avatarSize == 'NORMAL'){
        hat.innerHTML = NORMAL_gentlemenhat;
    }else if(avatarSize == 'SLIM'){
        hat.innerHTML = SLIM_gentlemenhat;
    }else if(avatarSize == 'SKINNY'){
        hat.innerHTML = SKINNY_gentlemenhat;
    }
    // console.log(avatarPic.innerHTML);
    hatInfo = 'gentlemenhat';
    console.log(avatarSize,hatInfo,clothesInfo,colorInfo);
});
chooseHat_greenhat.addEventListener('click',e => {  
    if(avatarSize == 'OBESE'){
        hat.innerHTML = OBESE_greenhat;
    }else if(avatarSize == 'OVERWEIGHT'){
        hat.innerHTML = OVERWEIGHT_greenhat;
    }else if(avatarSize == 'NORMAL'){
        hat.innerHTML = NORMAL_greenhat;
    }else if(avatarSize == 'SLIM'){
        hat.innerHTML = SLIM_greenhat;
    }else if(avatarSize == 'SKINNY'){
        hat.innerHTML = SKINNY_greenhat;
    }
    // console.log(avatarPic.innerHTML);
    hatInfo = 'GreeHat';
    console.log(avatarSize,hatInfo,clothesInfo,colorInfo);
});

//判斷換衣服-------------------------------------

let clothesInfo = null;
chooseClothes_blank.addEventListener('click',e => {  
    clothes.innerHTML=``;
    // console.log(avatarPic.innerHTML);
    clothesInfo = null;
    console.log(avatarSize,hatInfo,clothesInfo,colorInfo);
});
chooseClothes_scarf.addEventListener('click',e => {  
    if(avatarSize == 'OBESE'){
        clothes.innerHTML = OBESE_scarf;
    }else if(avatarSize == 'OVERWEIGHT'){
        clothes.innerHTML = OVERWEIGHT_scarf;
    }else if(avatarSize == 'NORMAL'){
        clothes.innerHTML = NORMAL_scarf;
    }else if(avatarSize == 'SLIM'){
        clothes.innerHTML = SLIM_scarf;
    }else if(avatarSize == 'SKINNY'){
        clothes.innerHTML = SKINNY_scarf;
    }
    // console.log(avatarPic.innerHTML);
    clothesInfo = 'Scarf';
    console.log(avatarSize,hatInfo,clothesInfo,colorInfo);
});
chooseClothes_camera.addEventListener('click',e => {  
    if(avatarSize == 'OBESE'){
        clothes.innerHTML = OBESE_camera;
    }else if(avatarSize == 'OVERWEIGHT'){
        clothes.innerHTML = OVERWEIGHT_camera;
    }else if(avatarSize == 'NORMAL'){
        clothes.innerHTML = NORMAL_camera;
    }else if(avatarSize == 'SLIM'){
        clothes.innerHTML = SLIM_camera;
    }else if(avatarSize == 'SKINNY'){
        clothes.innerHTML = SKINNY_camera;
    }
    // console.log(avatarPic.innerHTML);
    clothesInfo = 'Camera';
    console.log(avatarSize,hatInfo,clothesInfo,colorInfo);
});
chooseClothes_bowknot.addEventListener('click',e => {  
    if(avatarSize == 'OBESE'){
        clothes.innerHTML = OBESE_bowknot;
    }else if(avatarSize == 'OVERWEIGHT'){
        clothes.innerHTML = OVERWEIGHT_bowknot;
    }else if(avatarSize == 'NORMAL'){
        clothes.innerHTML = NORMAL_bowknot;
    }else if(avatarSize == 'SLIM'){
        clothes.innerHTML = SLIM_bowknot;
    }else if(avatarSize == 'SKINNY'){
        clothes.innerHTML = SKINNY_bowknot;
    }
    // console.log(avatarPic.innerHTML);
    clothesInfo = 'Bowknot';
    console.log(avatarSize,hatInfo,clothesInfo,colorInfo);
});
chooseClothes_bowtie.addEventListener('click',e => {  
    if(avatarSize == 'OBESE'){
        clothes.innerHTML = OBESE_bowtie;
    }else if(avatarSize == 'OVERWEIGHT'){
        clothes.innerHTML = OVERWEIGHT_bowtie;
    }else if(avatarSize == 'NORMAL'){
        clothes.innerHTML = NORMAL_bowtie;
    }else if(avatarSize == 'SLIM'){
        clothes.innerHTML = SLIM_bowtie;
    }else if(avatarSize == 'SKINNY'){
        clothes.innerHTML = SKINNY_bowtie;
    }
    // console.log(avatarPic.innerHTML);
    clothesInfo = 'Bowtie';
    console.log(avatarSize,hatInfo,clothesInfo,colorInfo);
});
chooseClothes_greentie.addEventListener('click',e => {  
    if(avatarSize == 'OBESE'){
        clothes.innerHTML = OBESE_greentie;
    }else if(avatarSize == 'OVERWEIGHT'){
        clothes.innerHTML = OVERWEIGHT_greentie;
    }else if(avatarSize == 'NORMAL'){
        clothes.innerHTML = NORMAL_greentie;
    }else if(avatarSize == 'SLIM'){
        clothes.innerHTML = SLIM_greentie;
    }else if(avatarSize == 'SKINNY'){
        clothes.innerHTML = SKINNY_greentie;
    }
    // console.log(avatarPic.innerHTML);
    clothesInfo = 'GreenTie';
    console.log(avatarSize,hatInfo,clothesInfo,colorInfo);
    
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
        // body: data,
        body :JSON.stringify({
            "avatarSize":avatarSize,
            "colorInfo":colorInfo,
            "hatInfo":hatInfo,
            "clothesInfo":clothesInfo})
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
	.st2{fill:none;stroke:#18191F;stroke-width:4.2762;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:10;}
	.st3{fill:#E83C3C;}
	.st4{fill:none;stroke:#18191F;stroke-width:5.4044;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:10;}
	.st5{fill:#F08E93;}
	.st6{fill:#18191F;}
	.st7{fill:#FF353B;}
	.st8{fill:#FFFFFF;}
	.st9{fill:#23B5F3;}
	.st10{fill:#CCCCFF;}
	.st11{fill:#6460FF;}
	.st12{fill:#DB9451;}
	.st13{fill:#F4B55E;}
	.st14{fill:#EC6519;}
	.st15{fill:#EF7C33;}
	.st16{fill:#CCCCCC;}
	.st17{fill:#E6E6E5;}
	.st18{fill:#B75320;}
	.st19{fill:#B3B3B3;}
	.st20{fill-rule:evenodd;clip-rule:evenodd;fill:#4D4D4D;}
	.st21{fill:#4D4D4D;}
	.st22{fill:#323333;}
	.st23{fill:#9C4623;}
	.st24{fill-rule:evenodd;clip-rule:evenodd;fill:#CBE8F0;}
	.st25{fill-rule:evenodd;clip-rule:evenodd;fill:#E1F0F3;}
	.st26{fill-rule:evenodd;clip-rule:evenodd;fill:#9ECCD5;}
	.st27{fill-rule:evenodd;clip-rule:evenodd;fill:#323333;}
	.st28{fill-rule:evenodd;clip-rule:evenodd;fill:#666666;}
	.st29{fill:none;stroke:#F4B55E;stroke-width:2.051;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:10;}
	.st30{fill:#C7B79C;}
	.st31{fill:#D4C9B4;}
	.st32{fill:#51524E;}
	.st33{fill:#E1E1E1;}
	.st34{fill:#43312B;}
	.st35{fill:#C6C6C6;}
	.st36{fill:#AAAAAA;}
	.st37{fill:#939393;}
	.st38{fill:#E0E0E0;}
	.st39{fill:#2B451C;}
	.st40{fill:#395527;}
	.st41{fill:none;stroke:#18191F;stroke-width:5.3533;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:10;}
	.st42{fill:none;stroke:#18191F;stroke-width:4.5;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:10;}
	.st43{fill:none;stroke:#F4B55E;stroke-width:2.378;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:10;}
	.st44{fill:none;stroke:#F4B55E;stroke-width:3.459;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:10;}
	.st45{fill:#FF9398;}
	.st46{fill:none;stroke:#18191F;stroke-width:4.5;stroke-linecap:round;stroke-miterlimit:10;}
	.st47{fill:none;stroke:#18191F;stroke-width:4.0241;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:10;}
	.st48{fill:none;stroke:#F4B55E;stroke-width:1.5623;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:10;}
	.st49{fill:none;stroke:#18191F;stroke-width:3.0579;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:10;}
	.st50{fill:none;stroke:#18191F;stroke-width:2.7483;stroke-linecap:round;stroke-linejoin:round;stroke-miterlimit:10;}
</style>`;
    let data = avatarPic.innerHTML;
  
    return header + style + data + `</svg>`;
  }



//avatar資料

// skinny
const SKINNY_pink = `<path class="st45" d="M223.8,124.1c-5.2-5.2-17.4,1.1-22.7,6.1c-1,0.9-2.5,0.1-2.4-1.2c0.9-14.6,1.2-25.4-0.4-40.1
c-1.6-14.6-5.2-32.9-17-43c-15.2-13-34.7-5.9-46.6,8.6c-9,10.9-14.2,24-16.9,37.8c-1.3,7-2,14.1-2.5,21.2
c-0.3,4.5,0.9,13.5-3.4,16.4c-2.6,1.8-6.6,2.8-9.5,2.1c-6.4-1.7-22.8-6.1-26.8,1.4c-6.6,12.5,22.9,20.1,29.7,21.8
c4.5,1.1,7.6,5.1,7.6,9.7c0,10.9-0.1,30.4-0.1,41.8c0,31.8-7,86.6,17.2,112.7c2.1,2.3,5.3,6.3,6.7,9.2c2.3,4.9,3.3,20.6,10.6,21.4
c8.7,1,8.1-12.2,8.8-16.7c0.3-1.7,1.7-2.9,3.3-2.9c1.5-0.1,3-0.2,4.5-0.4c1.8-0.2,3.6,0.8,3.9,2.7c1.5,8.2,1.4,15.4,6,15.8
c7.2,0.7,8.1-9,9.5-18.7c0.7-4.7,3.2-8.7,6.2-12.4c8.2-10.4,9.1-22.9,9.5-28.1c2-26.1-0.6-51.7-2.9-82.5
c-1.1-15.1-0.4-30.2,0.6-45.3c0.2-2.5,1.2-4.8,3-6.5C216.9,138.1,230.3,130.6,223.8,124.1z"/>
<path class="st6" d="M149.3,68c-1.1,2.7-3.5,4.2-5.5,3.5c-2-0.8-2.7-3.6-1.7-6.3c0.3-0.7,0.6-1.3,1-1.8c1.2-1.5,3-2.3,4.4-1.7
C149.6,62.5,150.3,65.3,149.3,68z"/>
<path class="st6" d="M161.9,73c-1.1,2.7-3.5,4.2-5.5,3.5c-2-0.8-2.7-3.6-1.7-6.3c0.5-1.2,1.2-2.1,2-2.8c1.1-0.8,2.3-1.1,3.4-0.7
C162.2,67.5,163,70.3,161.9,73z"/>
<path class="st46" d="M137.1,51.6c0,0,10.5-6.5,12.9,2.8"/>
<path class="st46" d="M158.3,57.8c0,0,11.4-4,16.2,5"/>`;
const SKINNY_red = `<path class="st7" d="M223.8,124.1c-5.2-5.2-17.4,1.1-22.7,6.1c-1,0.9-2.5,0.1-2.4-1.2c0.9-14.6,1.2-25.4-0.4-40.1
c-1.6-14.6-5.2-32.9-17-43c-15.2-13-34.7-5.9-46.6,8.6c-9,10.9-14.2,24-16.9,37.8c-1.3,7-2,14.1-2.5,21.2
c-0.3,4.5,0.9,13.5-3.4,16.4c-2.6,1.8-6.6,2.8-9.5,2.1c-6.4-1.7-22.8-6.1-26.8,1.4c-6.6,12.5,22.9,20.1,29.7,21.8
c4.5,1.1,7.6,5.1,7.6,9.7c0,10.9-0.1,30.4-0.1,41.8c0,31.8-7,86.6,17.2,112.7c2.1,2.3,5.3,6.3,6.7,9.2c2.3,4.9,3.3,20.6,10.6,21.4
c8.7,1,8.1-12.2,8.8-16.7c0.3-1.7,1.7-2.9,3.3-2.9c1.5-0.1,3-0.2,4.5-0.4c1.8-0.2,3.6,0.8,3.9,2.7c1.5,8.2,1.4,15.4,6,15.8
c7.2,0.7,8.1-9,9.5-18.7c0.7-4.7,3.2-8.7,6.2-12.4c8.2-10.4,9.1-22.9,9.5-28.1c2-26.1-0.6-51.7-2.9-82.5
c-1.1-15.1-0.4-30.2,0.6-45.3c0.2-2.5,1.2-4.8,3-6.5C216.9,138.1,230.3,130.6,223.8,124.1z"/>
<path class="st8" d="M149.3,68c-1.1,2.7-3.5,4.2-5.5,3.5c-2-0.8-2.7-3.6-1.7-6.3c0.3-0.7,0.6-1.3,1-1.8c1.2-1.5,3-2.3,4.4-1.7
C149.6,62.5,150.3,65.3,149.3,68z"/>
<path class="st8" d="M161.9,73c-1.1,2.7-3.5,4.2-5.5,3.5c-2-0.8-2.7-3.6-1.7-6.3c0.5-1.2,1.2-2.1,2-2.8c1.1-0.8,2.3-1.1,3.4-0.7
C162.2,67.5,163,70.3,161.9,73z"/>
<path class="st46" d="M137.1,51.6c0,0,10.5-6.5,12.9,2.8"/>
<path class="st46" d="M158.3,57.8c0,0,11.4-4,16.2,5"/>`;
const SKINNY_blue = `<path class="st9" d="M223.8,124.1c-5.2-5.2-17.4,1.1-22.7,6.1c-1,0.9-2.5,0.1-2.4-1.2c0.9-14.6,1.2-25.4-0.4-40.1
c-1.6-14.6-5.2-32.9-17-43c-15.2-13-34.7-5.9-46.6,8.6c-9,10.9-14.2,24-16.9,37.8c-1.3,7-2,14.1-2.5,21.2
c-0.3,4.5,0.9,13.5-3.4,16.4c-2.6,1.8-6.6,2.8-9.5,2.1c-6.4-1.7-22.8-6.1-26.8,1.4c-6.6,12.5,22.9,20.1,29.7,21.8
c4.5,1.1,7.6,5.1,7.6,9.7c0,10.9-0.1,30.4-0.1,41.8c0,31.8-7,86.6,17.2,112.7c2.1,2.3,5.3,6.3,6.7,9.2c2.3,4.9,3.3,20.6,10.6,21.4
c8.7,1,8.1-12.2,8.8-16.7c0.3-1.7,1.7-2.9,3.3-2.9c1.5-0.1,3-0.2,4.5-0.4c1.8-0.2,3.6,0.8,3.9,2.7c1.5,8.2,1.4,15.4,6,15.8
c7.2,0.7,8.1-9,9.5-18.7c0.7-4.7,3.2-8.7,6.2-12.4c8.2-10.4,9.1-22.9,9.5-28.1c2-26.1-0.6-51.7-2.9-82.5
c-1.1-15.1-0.4-30.2,0.6-45.3c0.2-2.5,1.2-4.8,3-6.5C216.9,138.1,230.3,130.6,223.8,124.1z"/>
<path class="st6" d="M149.3,68c-1.1,2.7-3.5,4.2-5.5,3.5c-2-0.8-2.7-3.6-1.7-6.3c0.3-0.7,0.6-1.3,1-1.8c1.2-1.5,3-2.3,4.4-1.7
C149.6,62.5,150.3,65.3,149.3,68z"/>
<path class="st6" d="M161.9,73c-1.1,2.7-3.5,4.2-5.5,3.5c-2-0.8-2.7-3.6-1.7-6.3c0.5-1.2,1.2-2.1,2-2.8c1.1-0.8,2.3-1.1,3.4-0.7
C162.2,67.5,163,70.3,161.9,73z"/>
<path class="st46" d="M137.1,51.6c0,0,10.5-6.5,12.9,2.8"/>
<path class="st46" d="M158.3,57.8c0,0,11.4-4,16.2,5"/>`;
const SKINNY_purple = `<path class="st11" d="M223.8,124.1c-5.2-5.2-17.4,1.1-22.7,6.1c-1,0.9-2.5,0.1-2.4-1.2c0.9-14.6,1.2-25.4-0.4-40.1
c-1.6-14.6-5.2-32.9-17-43c-15.2-13-34.7-5.9-46.6,8.6c-9,10.9-14.2,24-16.9,37.8c-1.3,7-2,14.1-2.5,21.2
c-0.3,4.5,0.9,13.5-3.4,16.4c-2.6,1.8-6.6,2.8-9.5,2.1c-6.4-1.7-22.8-6.1-26.8,1.4c-6.6,12.5,22.9,20.1,29.7,21.8
c4.5,1.1,7.6,5.1,7.6,9.7c0,10.9-0.1,30.4-0.1,41.8c0,31.8-7,86.6,17.2,112.7c2.1,2.3,5.3,6.3,6.7,9.2c2.3,4.9,3.3,20.6,10.6,21.4
c8.7,1,8.1-12.2,8.8-16.7c0.3-1.7,1.7-2.9,3.3-2.9c1.5-0.1,3-0.2,4.5-0.4c1.8-0.2,3.6,0.8,3.9,2.7c1.5,8.2,1.4,15.4,6,15.8
c7.2,0.7,8.1-9,9.5-18.7c0.7-4.7,3.2-8.7,6.2-12.4c8.2-10.4,9.1-22.9,9.5-28.1c2-26.1-0.6-51.7-2.9-82.5
c-1.1-15.1-0.4-30.2,0.6-45.3c0.2-2.5,1.2-4.8,3-6.5C216.9,138.1,230.3,130.6,223.8,124.1z"/>
<path class="st10" d="M149.3,68c-1.1,2.7-3.5,4.2-5.5,3.5c-2-0.8-2.7-3.6-1.7-6.3c0.3-0.7,0.6-1.3,1-1.8c1.2-1.5,3-2.3,4.4-1.7
C149.6,62.5,150.3,65.3,149.3,68z"/>
<path class="st10" d="M161.9,73c-1.1,2.7-3.5,4.2-5.5,3.5c-2-0.8-2.7-3.6-1.7-6.3c0.5-1.2,1.2-2.1,2-2.8c1.1-0.8,2.3-1.1,3.4-0.7
C162.2,67.5,163,70.3,161.9,73z"/>
<path class="st46" d="M137.1,51.6c0,0,10.5-6.5,12.9,2.8"/>
<path class="st46" d="M158.3,57.8c0,0,11.4-4,16.2,5"/>`;
const SKINNY_lightpurple = `<path class="st10" d="M223.8,124.1c-5.2-5.2-17.4,1.1-22.7,6.1c-1,0.9-2.5,0.1-2.4-1.2c0.9-14.6,1.2-25.4-0.4-40.1
c-1.6-14.6-5.2-32.9-17-43c-15.2-13-34.7-5.9-46.6,8.6c-9,10.9-14.2,24-16.9,37.8c-1.3,7-2,14.1-2.5,21.2
c-0.3,4.5,0.9,13.5-3.4,16.4c-2.6,1.8-6.6,2.8-9.5,2.1c-6.4-1.7-22.8-6.1-26.8,1.4c-6.6,12.5,22.9,20.1,29.7,21.8
c4.5,1.1,7.6,5.1,7.6,9.7c0,10.9-0.1,30.4-0.1,41.8c0,31.8-7,86.6,17.2,112.7c2.1,2.3,5.3,6.3,6.7,9.2c2.3,4.9,3.3,20.6,10.6,21.4
c8.7,1,8.1-12.2,8.8-16.7c0.3-1.7,1.7-2.9,3.3-2.9c1.5-0.1,3-0.2,4.5-0.4c1.8-0.2,3.6,0.8,3.9,2.7c1.5,8.2,1.4,15.4,6,15.8
c7.2,0.7,8.1-9,9.5-18.7c0.7-4.7,3.2-8.7,6.2-12.4c8.2-10.4,9.1-22.9,9.5-28.1c2-26.1-0.6-51.7-2.9-82.5
c-1.1-15.1-0.4-30.2,0.6-45.3c0.2-2.5,1.2-4.8,3-6.5C216.9,138.1,230.3,130.6,223.8,124.1z"/>
<path class="st6" d="M149.3,68c-1.1,2.7-3.5,4.2-5.5,3.5c-2-0.8-2.7-3.6-1.7-6.3c0.3-0.7,0.6-1.3,1-1.8c1.2-1.5,3-2.3,4.4-1.7
C149.6,62.5,150.3,65.3,149.3,68z"/>
<path class="st6" d="M161.9,73c-1.1,2.7-3.5,4.2-5.5,3.5c-2-0.8-2.7-3.6-1.7-6.3c0.5-1.2,1.2-2.1,2-2.8c1.1-0.8,2.3-1.1,3.4-0.7
C162.2,67.5,163,70.3,161.9,73z"/>
<path class="st46" d="M137.1,51.6c0,0,10.5-6.5,12.9,2.8"/>
<path class="st46" d="M158.3,57.8c0,0,11.4-4,16.2,5"/>`;

const SKINNY_berets = `<path class="st0" d="M172.7,13.9c0,0-1.7-4.1,1.6-4.9c0,0,3-0.8,3.1-1c0,0,1.5,0.6,0.2,1.9c0,0-3.5,2.2-3.1,4.4L172.7,13.9z"/>
<path class="st1" d="M198.3,27.5c-7.1-12-24.2-14.6-24.2-14.6s-17-3.9-27.9,4.6c0,0-3.8,2.7-2.4,6.4l3.2,7.9l22.6,4.4l22.6,4.4
	l6-6.3C200.9,31.4,198.3,27.5,198.3,27.5z"/>`;
const SKINNY_orangehat = `<path class="st12" d="M199.4,36.3c0,0,1-3.9-4.4-6c-7,0.2-13.4-0.9-18.8-2.4c-3.5-1-6.5-2.2-9.1-3.4c-4.3-2-7.7-4-9.9-5.6
c-2.1-0.2-6.7-0.2-7.4,2.8c0,0-1.5,4.9,7,9.6c0,0,13,7.3,34.3,8.9C191.1,40.2,198.6,40,199.4,36.3z"/>
<path class="st13" d="M195.3,28.1l1.8-7.7c0,0,1.1-6.7-4.9-10.6c0,0-9.1-5.3-18.8-6.3c0,0-8.2-0.6-11.2,6.2l-3.3,7.7
c2.2,1.5,5.3,3.3,9.2,5.1C174.5,25.3,184.1,28.5,195.3,28.1z"/>`;
const SKINNY_fishermenhat = `<path class="st30" d="M157.8,16.8c0-0.5,0.5-0.7,0.8-1c1.5-1.6,3-3.3,4.7-4.8c3.2-2.9,7.2-4.6,11.8-5.2c3.8-0.5,7.5,0.2,11.1,2
c3.9,2,6.9,4.9,9.2,8.4c2.2,3.3,3.5,6.9,4.1,10.6c0.2,1.3,0.5,2.5,0.8,3.7c-0.7,0.3-1.4,0.1-2.1,0.2c-3.2,0.3-6.4,0.5-9.7,0.2
c-3.9-0.3-7.7-1-11.4-2.3c-6.1-2.1-11.4-5.3-16.2-9.4c-0.8-0.7-1.4-1.5-2.2-2.2C158.5,16.9,158.2,16.8,157.8,16.8z"/>
<path class="st31" d="M200.2,34.3c2,2.8,3.9,5.7,5.9,8.5c0.2,0.4,0.5,0.7,0.7,1.1c-0.2,0.2-0.4,0.2-0.6,0.2
c-7.7,1.4-15.4,1.6-23.4-0.4c-3-0.8-6-1.6-8.9-2.9c-1.9-0.8-3.8-1.5-5.7-2.4c-6.5-2.9-12.5-6.5-17.8-11.1c-1.3-1.1-2.5-2.3-3.6-3.7
c0.8-0.6,1.9-0.9,2.8-1.3c2.7-1.1,5.2-2.5,7.4-4.2c0.2,0.3,0,0.6-0.2,0.8c-0.6,0.7-0.5,1.5,0.1,2.3c1.3,2,3,3.7,4.9,5.3
c2.4,1.9,5.1,3.5,8,4.8c4.3,2.1,8.9,3.6,13.5,4.7c3.7,0.9,7.4,1.4,11.1,0.8c2.1-0.3,4-0.9,5.4-2.4C199.9,34.4,200,34.3,200.2,34.3z"
/>
<path class="st30" d="M146.8,23.7c0.3,0.1,0.5,0.3,0.7,0.5c3.3,3.7,7.4,6.7,11.7,9.3c2.3,1.4,4.7,2.7,7.1,3.9c3.2,1.6,6.5,3,9.9,4.2
c5.9,2.1,11.9,3.4,18.1,3.4c3.9,0,7.6-0.4,11.4-1c0.3-0.1,0.7-0.1,1-0.1c0.1,0.2,0.2,0.4,0.3,0.6c0.4,0.7,0.2,1.1-0.6,1.3
c-1.5,0.4-3,0.9-4.4,1.3c-5.8,1.8-11.9,2.6-18.2,1.9c-3.3-0.4-6.6-1.1-9.8-2.2c-2.7-0.9-5.3-2-7.8-3.2c-6.5-3.1-12.4-7-17.3-12.2
c-1.7-1.8-3-3.9-4.5-5.8c-0.2-0.3-0.1-0.4,0.1-0.6C145.2,24.5,146,24,146.8,23.7z"/>
<path class="st32" d="M200.2,34.3c-1.4,1.8-3.5,2.5-5.8,2.8c-3.1,0.5-6.3,0.2-9.5-0.5c-7.6-1.6-14.8-4.2-21.3-8.5
c-2.9-1.9-5.3-4.3-7.1-7.1c-0.4-0.6-0.4-1.2-0.1-1.7c0.2-0.3,0.4-0.7,0.6-1.1c0.3-0.5,0.5-0.9,0.8-1.4c0.3-0.4,0.5-0.4,0.9,0
c2.4,2.6,5.2,4.8,8.3,6.8c3.1,2,6.4,3.6,10,4.9c7.1,2.5,14.2,2.9,21.4,2.1c0.7-0.1,1.3-0.1,2,0C200.3,31.8,200.3,33.1,200.2,34.3z"
/>
<path class="st33" d="M180.3,26c-0.5,1.2-1.5,1.5-2.9,0.9c-1-0.4-1.5-1.6-1.1-2.6c0.4-1,1.8-1.4,3-0.9C180.3,23.8,180.7,25,180.3,26
z"/>
<path class="st33" d="M169.9,21.9c0.4-1.3,1.6-1.3,2.9-0.9c1,0.3,1.4,1.6,1,2.6c-0.5,1.1-1.5,1.4-2.7,0.9
C169.9,24,169.5,23,169.9,21.9z"/>
<path class="st34" d="M179.7,25.7c-0.3,0.7-1.1,1-1.9,0.7c-0.8-0.3-1.1-1.1-0.8-1.9c0.3-0.7,1.2-1,2-0.7
C179.7,24.2,180,25,179.7,25.7z"/>
<path class="st34" d="M173.3,23.3c-0.3,0.7-1.1,1.1-1.9,0.7c-0.8-0.3-1.2-1.1-0.9-1.9c0.3-0.7,1.2-1,2-0.7
C173.2,21.7,173.6,22.5,173.3,23.3z"/>`;
const SKINNY_gentlemenhat = `<path class="st6" d="M195.9,37.5c0.2-1.4-1.6-1.7-1.6-1.7l-4.6-0.7l2.3-14.6c0.8-5-2.8-5.6-2.8-5.6l-16.2-2.6l-16.2-2.6
c0,0-3.6-0.6-4.4,4.4l-2.3,14.6l-4.6-0.7c0,0-1.8-0.2-2,1.2c0,0-0.4,1.2,1.7,1.5l24.3,3.9l24.3,3.9
C195.9,38.7,195.9,37.5,195.9,37.5z"/>`;
const SKINNY_greenhat = `<path class="st39" d="M206.4,43.6c0.3-4.7-9.9-9-13.2-7.6c-6,2.8-37.2-1.6-42.7-13.2c-15.4-3.1-16.1,3.9-16.1,3.9
c-3.3,15.8,31.9,22.5,31.9,22.5C206.6,57.7,206.4,43.6,206.4,43.6z"/>
<path class="st40" d="M192.5,32.8c3.4-21.5-4.4-23.3-4.4-23.3c-3.2-2.1-8,0.5-8,0.5c-10.5-8.1-16.2-6.4-16.2-6.4
c-6.9,1.6-10.4,11.5-11.8,16.5C158.8,30.7,182.7,34.3,192.5,32.8z"/>`;

const SKINNY_scarf = `<path class="st50" d="M99.7,151.3l-7,7.4"/>
<path class="st50" d="M92.5,146.3l-7,7.4"/>
<path class="st50" d="M105,155.7l-3.9,7.6"/>
<path class="st50" d="M111.4,157.2l-2.2,8.7"/>
<path class="st3" d="M111,111.1c0,0,50.7,16.1,90.1,2.3c0,0,9.3-0.3,1.9,7.8c0,0,9.5,2.1,3.5,8c-5.9,5.9-32.7,24.9-100.4,0.6
	c0,0-10.1-10,0.8-8.8C107,121,99,110.5,111,111.1z"/>
<path class="st3" d="M111.7,128.1c0,0-18.9,6.5-22.9,17.8c0,0,15.6,13.4,25.7,11.3l10.6-23.3L111.7,128.1z"/>`;
const SKINNY_camera = `<path class="st14" d="M117.1,149.1l53.3,3.6l-2.1,31.5l-53.3-3.6L117.1,149.1z"/>
<path class="st15" d="M163.9,160.1l6,0.4l-1.1,15.8l-6-0.4L163.9,160.1z"/>
<path class="st16" d="M115,180.4l53.3,3.6l-0.5,7.8l-53.3-3.6L115,180.4z"/>
<path class="st17" d="M162.3,183.6l6,0.4l-0.5,7.8l-6-0.4L162.3,183.6z"/>
<path class="st16" d="M117.1,149.1l53.3,3.6l-0.5,7.8l-53.3-3.6L117.1,149.1z"/>
<path class="st18" d="M116.5,156.9l6,0.4l-1.1,15.8l-6-0.4L116.5,156.9z"/>
<path class="st19" d="M115,180.4l6,0.4l-0.5,7.8l-6-0.4L115,180.4z"/>
<path class="st20" d="M136.1,146.4c4.8,0.3,11.1,0.8,16,1.1l1.2,4c-5.8-0.4-13.1-0.9-18.9-1.3L136.1,146.4z"/>
<path class="st21" d="M159,149.2l6.9,0.5l-0.2,2.7l-6.9-0.5L159,149.2z"/>
<path class="st21" d="M122,146.7l6.9,0.5l-0.2,2.7l-6.9-0.5L122,146.7z"/>
<path class="st22" d="M162.2,149.4l0.5,0l-0.2,2.7l-0.5,0L162.2,149.4z"/>
<path class="st22" d="M164.6,149.5l0.5,0l-0.2,2.7l-0.5,0L164.6,149.5z"/>
<path class="st22" d="M163.4,149.5l0.5,0l-0.2,2.7l-0.5,0L163.4,149.5z"/>
<path class="st22" d="M161.1,149.3l0.5,0l-0.2,2.7l-0.5,0L161.1,149.3z"/>
<path class="st22" d="M159.9,149.2l0.5,0l-0.2,2.7l-0.5,0L159.9,149.2z"/>
<path class="st18" d="M122.5,157.3l41.4,2.8l-0.1,0.8l-41.4-2.8L122.5,157.3L122.5,157.3z"/>
<path class="st23" d="M116.5,156.9l6,0.4l-0.1,0.8l-6-0.4L116.5,156.9z"/>
<path class="st14" d="M163.9,160.1l6,0.4l-0.1,0.8l-6-0.4L163.9,160.1z"/>
<path class="st18" d="M121.5,172.3l41.4,2.8l-0.1,0.8l-41.4-2.8L121.5,172.3L121.5,172.3z"/>
<path class="st23" d="M115.5,171.9l6,0.4l-0.1,0.8l-6-0.4L115.5,171.9z"/>
<path class="st14" d="M162.9,175.1l6,0.4l-0.1,0.8l-6-0.4L162.9,175.1z"/>
<path class="st21" d="M141.7,180.1c-7.4-0.6-13-7-12.4-14.5c0.6-7.4,7-13,14.5-12.4c7.4,0.6,13,7,12.4,14.5
	C155.5,175.1,149.1,180.6,141.7,180.1z"/>
<path class="st24" d="M132.2,165.9c0.4-5.8,5.4-10.2,11.3-9.8c5.8,0.4,10.2,5.4,9.8,11.3c-0.4,5.8-5.4,10.2-11.3,9.8
	C136.2,176.8,131.8,171.7,132.2,165.9z"/>
<path class="st25" d="M147.2,164.5c-2.3-2.7-3.9-5.7-4.6-8.4c0.2,0,0.5,0,0.8,0c5.8,0.4,10.2,5.4,9.8,11.3c0,0.7-0.2,1.4-0.3,2.1
	C150.9,168.2,148.9,166.6,147.2,164.5z"/>
<path class="st26" d="M139.3,166.4c0.1-1.9,1.8-3.4,3.7-3.2c1.9,0.1,3.4,1.8,3.2,3.7c-0.1,1.9-1.8,3.4-3.7,3.2
	C140.6,169.9,139.1,168.3,139.3,166.4z"/>
<path class="st27" d="M136.1,146.4l5,0.3l-1.8,3.8l-4.9-0.3L136.1,146.4z"/>
<path class="st28" d="M170.9,156.8l-0.7,0l0.1-1l1.3,0.1c0.4,0,0.7,0.4,0.7,0.8L172,159c0,0.4-0.4,0.8-0.8,0.7l-1.3-0.1l0.1-1l0.7,0
	c0.2,0,0.3-0.2,0.3-0.3l0.1-1.1C171.2,157,171.1,156.9,170.9,156.8z"/>
<path class="st48" d="M201,130.2c0,0-13.6,23.9-31.8,27.6"/>
<path class="st28" d="M116,155.1l0.7,0l-0.1,1l-1.3-0.1c-0.4,0-0.7-0.4-0.7-0.8l0.2-2.3c0-0.4,0.4-0.8,0.8-0.7l1.3,0.1l-0.1,1
	l-0.7,0c-0.2,0-0.3,0.2-0.3,0.3l-0.1,1.1C115.6,154.8,115.8,155,116,155.1z"/>
<path class="st48" d="M118.5,154.8c0,0-6.8-15.2-6.7-24.9"/>
<path class="st17" d="M164.4,152.3l6,0.4l-0.5,7.8l-6-0.4L164.4,152.3z"/>
<path class="st19" d="M117.1,149.1l6,0.4l-0.5,7.8l-6-0.4L117.1,149.1z"/>`;
const SKINNY_bowknot = `<path class="st35" d="M145.1,120.9c1.4-0.6,2.8-1.2,4.2-1.9c3.9-1.8,7.8-3.6,11.7-5.3c2.6-1.2,5.3-0.6,7.1,1.6
c1.2,1.4,1.5,3.1,1.5,5c-0.1,4.4-0.2,8.7-0.3,13.1c0,0.1,0,0.2,0,0.3c-0.2,0-0.2-0.1-0.2-0.3c-0.3-1.3-1.2-2.1-2.2-2.7
c-1.6-1-3.4-1.5-5.2-1.8c-4.4-0.8-8.8,0-13.1,1.1c-1.1,0.3-2.2,0.5-3.2,0.8c-0.3,0.1-0.5,0.2-0.8,0.1c-0.3-0.2-0.2-0.5-0.1-0.8
c0.2-2.2,0.5-4.4,0.7-6.6c0.1-0.7,0.2-1.3,0.1-2C145,121.3,145,121.1,145.1,120.9z"/>
<path class="st35" d="M109.8,127.6c0.3-1.8,0.7-3.7,1-5.5c0.5-2.8,1.1-5.6,1.6-8.4c0.9-4.6,5.6-6.8,9.2-4.3c3,2.1,5.9,4.3,8.8,6.4
c1.8,1.3,3.6,2.7,5.4,4c0,0,0.1,0,0.2,0.1c0.1,0.1,0.1,0.2,0.1,0.3c-0.6,2.8-0.7,5.6-1,8.4c-0.1,0.4,0,0.8-0.3,1.1
c-0.4,0.2-0.6,0-0.9-0.2c-3-1.6-6-3-9.1-4c-3.3-1.1-6.7-1.5-10.2-1c-1.3,0.2-2.6,0.6-3.7,1.5c-0.4,0.3-0.7,0.7-0.9,1.2
C110.1,127.5,110,127.6,109.8,127.6z"/>
<path class="st36" d="M151.2,135.8c0.1,0.9,0.5,1.6,0.8,2.4c1.9,5.2,3.7,10.3,5.6,15.5c0.1,0.2,0.2,0.5,0.2,0.7
c-0.3,0.1-0.5-0.1-0.6-0.3c-2.1-1.4-4.2-2.8-6.2-4.3c-0.4-0.2-0.5-0.3-0.7,0.3c-0.6,2.7-1.3,5.4-1.9,8c0,0.2-0.1,0.3-0.1,0.4
c-0.2,0-0.2-0.2-0.3-0.3c-2.9-8.1-5.9-16.3-8.9-24.4c0-0.1-0.1-0.2-0.1-0.3c0-0.1,0-0.2-0.1-0.3c-0.2-0.5-0.2-0.6,0.4-0.6
c0.4,0,0.8,0,1.1,0.1c0.9,0.1,1.8,0,2.5-0.7c0.2-0.2,0.4-0.3,0.6-0.3c0.7,0.7,1.5,1,2.3,1.4c1.5,0.8,3.1,1.5,4.7,2.2
C150.9,135.5,151.1,135.6,151.2,135.8z"/>
<path class="st36" d="M138.7,133.4c-1.3,2-2.5,4.1-3.8,6.1c-3.3,5.4-6.7,10.8-10,16.1c-0.1,0.2-0.2,0.4-0.5,0.7
c0-1.4-0.1-2.6-0.1-3.8c0-1.7-0.1-3.4-0.1-5.2c0-0.5-0.1-0.6-0.6-0.4c-2.3,1-4.7,2-7,2.9c-0.2,0.1-0.4,0.1-0.6,0.2
c-0.1-0.3,0.1-0.4,0.2-0.6c3.2-5.2,6.4-10.3,9.6-15.5c0.1-0.2,0.3-0.4,0.3-0.7c0.2-0.4,0.6-0.3,0.8-0.4c2.5-0.4,4.9-1,7.3-1.8
c0.4-0.1,0.6-0.3,0.8-0.7c0.4,0,0.6,0.4,0.7,0.7c0.3,0.8,1,1,1.7,1.2c0.3,0.1,0.5,0.1,0.8,0.1C138.9,132.7,139,132.8,138.7,133.4z"
/>
<path class="st37" d="M135.1,130.7c0.1,0.5,0,0.6-0.5,0.8c-2.6,0.8-5.3,1.5-8.1,1.9c-0.1,0-0.3,0.1-0.4,0.1
c-2.6,0.4-5.2,0.7-7.9,0.3c-2.2-0.3-4.3-0.8-6.2-2c-0.8-0.5-1.5-1.1-1.9-1.9c-0.4-0.7-0.5-1.4-0.3-2.2c0.7-2.1,2.4-2.6,4.1-3
c1.5-0.4,3-0.4,4.5-0.4c4,0.1,7.6,1.5,11.2,3.1c1.7,0.8,3.3,1.6,5,2.5C135.1,129.9,135.2,130.2,135.1,130.7z"/>
<path class="st37" d="M151.2,135.8c-2.4-1-4.8-2.2-7.1-3.4c-0.2-0.1-0.5-0.2-0.4-0.6c0.1-0.5,0.3-0.9,0.8-1c3.8-1.1,7.6-2,11.4-2.4
c2.6-0.2,5.1,0,7.6,0.7c1.5,0.4,2.9,0.9,4.1,1.9c0.8,0.7,1.5,1.4,1.7,2.6c0.1,1.3-0.5,2.2-1.4,2.9c-1.6,1.1-3.4,1.4-5.3,1.5
c-3.6,0.3-7-0.5-10.3-1.8C151.9,136.1,151.5,136,151.2,135.8z"/>
<path class="st38" d="M144.5,130.8c-0.4,0.2-0.5,0.7-0.8,1c-0.2,0.2-0.4,0.3-0.6,0.5c-0.7,0.6-1.4,0.9-2.3,0.7
c-0.4-0.1-0.7-0.1-1.1-0.1c-0.7-0.1-0.7-0.1-0.6,0.7c-0.1-0.1-0.1-0.6-0.5-0.2c0.2-0.6-0.1-0.7-0.6-0.7c-0.5,0-1-0.1-1.4-0.3
c-0.5-0.2-0.8-0.5-1.1-1c-0.1-0.2-0.2-0.6-0.5-0.8c-0.1-0.3-0.1-0.7-0.4-0.9c0.2-0.2,0.2-0.5,0.2-0.7c0.2-2.3,0.5-4.6,0.7-6.9
c0.1-0.8,0.1-1.5,0.5-2.2c0.6-1.3,1.6-1.9,3-1.8c1.2,0.1,2.4,0.2,3.5,0.4c1.3,0.2,2.2,1,2.5,2.4c0.1,0.8,0.1,1.6,0,2.4
c-0.3,2.4-0.5,4.9-0.8,7.3C144.3,130.7,144.3,130.8,144.5,130.8z"/>`;
const SKINNY_bowtie = `<path class="st6" d="M158.2,115.4l-5,2.4c-0.6,0.3-1.2,0-1.6-0.5c-1.1-1.6-2.8-2.6-4.9-2.8c-2.1-0.2-3.9,0.6-5.3,2
c-0.5,0.5-1.1,0.6-1.7,0.2l-4.6-3.2l-7.8-5.4c-1.4-1-3.3,0-3.4,1.6c2.3,6.2,1.7,13.1-1.5,18.9c-0.1,1.7,1.6,2.9,3.2,2.2l8.6-4.1
l5-2.4c0.6-0.3,1.2,0,1.6,0.5c1.1,1.6,2.8,2.6,4.9,2.8c2.1,0.2,3.9-0.6,5.3-2c0.5-0.5,1.1-0.6,1.7-0.2l4.6,3.2l7.8,5.4
c1.4,1,3.3,0,3.4-1.6c-2.3-6.2-1.7-13.1,1.5-18.9c0.1-1.7-1.6-2.9-3.2-2.2L158.2,115.4z"/>`;
const SKINNY_greentie = `<path class="st40" d="M147.3,128c0.6,0.1,1.3,0.2,2,0.3c0.7,0,1.4-0.1,2.2-0.1c0.3,0,0.3,0.1,0.3,0.3c0,0.1,0.1,0.3,0.1,0.4
c3.8,10,6.4,19.8,7.7,30.5c0.8,6.6,2.1,13.4,2.3,20.1c0,0.3-0.1,0.5-0.3,0.7c-2.2,2.6-9.6,9.2-11.8,11.8c-0.3,0.3-0.4,0.3-0.7,0
c-1.9-2.2-4.7-4.5-6.7-7.1c-1.6-2.1-4.3-4.7-4.2-7.6c0.3-8.3,1.8-16.5,2.6-24.8c0.4-4.2,1.1-8.4,2.1-12.5c1-3.9,2.1-7,3.4-10.6
c0.1-0.3,0.2-0.7,0.2-1.1c0-0.1,0-0.2,0.1-0.2C146.8,127.9,147.1,128,147.3,128z"/>
<path class="st39" d="M150.3,127.4c-0.5,0-0.9,0.1-1.4,0c-0.6,0-1.2-0.1-1.8-0.2c-0.5-0.1-0.8-0.5-1.2-0.8c-0.4-0.4-0.8-0.8-1.1-1.3
c-0.7-0.9-1.3-1.9-1.8-2.9c-0.6-1-0.7-1.9-0.3-3.1c0.3-0.8,0.7-1.2,1.6-1.4c3.6-0.7,7.3-0.7,10.9,0.1c0.2,0.1,0.5,0,0.6,0.4
c0.6,1.5,0.9,2.8-0.1,4.3c-0.6,0.9-1.2,1.9-1.9,2.8c-0.5,0.7-1.1,1.3-1.9,1.7c-0.1,0-0.1,0.1-0.2,0.1
C151.3,127.3,150.8,127.3,150.3,127.4z"/>`;

// slim
const SLIM_pink=`<path class="st45" d="M220.1,267.8c-3.5-37.9-17.2-73.1-21.5-110.3c-3.2-28.1,4.9-56.6-4.4-84.2c-6.3-18.9-21-30.8-37-33.6
c-16.7-2.9-34.9,4.1-46.1,23.5c-8.5,14.6-10.9,31.8-13.2,48.5c-5.4,39.6-10.7,79.2-16.1,118.8c-1.6,11.9-3.2,23.9-1.6,35.8
c2.7,20.7,14.4,34.9,30,43.8c7.4,4.2,9.8,12.8,10.5,19.9c0.4,4.7,0.8,10.6,3.7,14.3c3.4,4.3,8.4,4.6,12.5,1.9
c6.9-4.5,6.6-15.4,8.7-22.8c0.4-1.4,1.7-2.2,3.1-2.1c3.4,0.3,6.9,0.4,10.3,0.4c1.4,0,2.6,1,2.9,2.3c1.6,7,1.4,15.2,5,21.8
c4.2,7.7,13.2,3.6,15.5-3.5c3-9.2,2.1-19.6,11.3-26c4.7-3.3,10.7-4.5,15-8.5C219.2,298,221.4,282.1,220.1,267.8z"/>
<path class="st42" d="M106.2,211.6c0,0,3.1,21.6,16,17.7c9.4-2.9,5-26.9,5-26.9"/>
<path class="st42" d="M144.2,205.4c0,0-9.3,19.3,0,25.1c8.5,5.3,15.7-10,15.7-10"/>
<path class="st6" d="M126.2,90.2c0,3.2-1.9,5.9-4.2,5.9c-2.4,0-4.3-2.6-4.3-5.8c0-3.2,1.9-5.9,4.2-5.9c1.2,0,2.3,0.6,3,1.7
C125.7,87.1,126.2,88.6,126.2,90.2z"/>
<path class="st6" d="M141.4,90.1c0,3.2-1.9,5.9-4.2,5.9c-2.4,0-4.3-2.6-4.3-5.8c0-3.2,1.9-5.9,4.2-5.9c1.2,0,2.3,0.6,3,1.7
S141.4,88.5,141.4,90.1z"/>
<path class="st42" d="M106.2,77.3c0,0,5-12.5,16.5-6.5"/>
<path class="st42" d="M130.6,70.7c0,0,10.5-10.3,26.1,4"/>`;
const SLIM_red=`<path class="st7" d="M220.1,267.8c-3.5-37.9-17.2-73.1-21.5-110.3c-3.2-28.1,4.9-56.6-4.4-84.2c-6.3-18.9-21-30.8-37-33.6
c-16.7-2.9-34.9,4.1-46.1,23.5c-8.5,14.6-10.9,31.8-13.2,48.5c-5.4,39.6-10.7,79.2-16.1,118.8c-1.6,11.9-3.2,23.9-1.6,35.8
c2.7,20.7,14.4,34.9,30,43.8c7.4,4.2,9.8,12.8,10.5,19.9c0.4,4.7,0.8,10.6,3.7,14.3c3.4,4.3,8.4,4.6,12.5,1.9
c6.9-4.5,6.6-15.4,8.7-22.8c0.4-1.4,1.7-2.2,3.1-2.1c3.4,0.3,6.9,0.4,10.3,0.4c1.4,0,2.6,1,2.9,2.3c1.6,7,1.4,15.2,5,21.8
c4.2,7.7,13.2,3.6,15.5-3.5c3-9.2,2.1-19.6,11.3-26c4.7-3.3,10.7-4.5,15-8.5C219.2,298,221.4,282.1,220.1,267.8z"/>
<path class="st42" d="M106.2,211.6c0,0,3.1,21.6,16,17.7c9.4-2.9,5-26.9,5-26.9"/>
<path class="st42" d="M144.2,205.4c0,0-9.3,19.3,0,25.1c8.5,5.3,15.7-10,15.7-10"/>
<path class="st8" d="M126.2,90.2c0,3.2-1.9,5.9-4.2,5.9c-2.4,0-4.3-2.6-4.3-5.8c0-3.2,1.9-5.9,4.2-5.9c1.2,0,2.3,0.6,3,1.7
C125.7,87.1,126.2,88.6,126.2,90.2z"/>
<path class="st8" d="M141.4,90.1c0,3.2-1.9,5.9-4.2,5.9c-2.4,0-4.3-2.6-4.3-5.8c0-3.2,1.9-5.9,4.2-5.9c1.2,0,2.3,0.6,3,1.7
S141.4,88.5,141.4,90.1z"/>
<path class="st42" d="M106.2,77.3c0,0,5-12.5,16.5-6.5"/>
<path class="st42" d="M130.6,70.7c0,0,10.5-10.3,26.1,4"/>`;
const SLIM_blue=`<path class="st9" d="M220.1,267.8c-3.5-37.9-17.2-73.1-21.5-110.3c-3.2-28.1,4.9-56.6-4.4-84.2c-6.3-18.9-21-30.8-37-33.6
c-16.7-2.9-34.9,4.1-46.1,23.5c-8.5,14.6-10.9,31.8-13.2,48.5c-5.4,39.6-10.7,79.2-16.1,118.8c-1.6,11.9-3.2,23.9-1.6,35.8
c2.7,20.7,14.4,34.9,30,43.8c7.4,4.2,9.8,12.8,10.5,19.9c0.4,4.7,0.8,10.6,3.7,14.3c3.4,4.3,8.4,4.6,12.5,1.9
c6.9-4.5,6.6-15.4,8.7-22.8c0.4-1.4,1.7-2.2,3.1-2.1c3.4,0.3,6.9,0.4,10.3,0.4c1.4,0,2.6,1,2.9,2.3c1.6,7,1.4,15.2,5,21.8
c4.2,7.7,13.2,3.6,15.5-3.5c3-9.2,2.1-19.6,11.3-26c4.7-3.3,10.7-4.5,15-8.5C219.2,298,221.4,282.1,220.1,267.8z"/>
<path class="st42" d="M106.2,211.6c0,0,3.1,21.6,16,17.7c9.4-2.9,5-26.9,5-26.9"/>
<path class="st42" d="M144.2,205.4c0,0-9.3,19.3,0,25.1c8.5,5.3,15.7-10,15.7-10"/>
<path class="st6" d="M126.2,90.2c0,3.2-1.9,5.9-4.2,5.9c-2.4,0-4.3-2.6-4.3-5.8c0-3.2,1.9-5.9,4.2-5.9c1.2,0,2.3,0.6,3,1.7
C125.7,87.1,126.2,88.6,126.2,90.2z"/>
<path class="st6" d="M141.4,90.1c0,3.2-1.9,5.9-4.2,5.9c-2.4,0-4.3-2.6-4.3-5.8c0-3.2,1.9-5.9,4.2-5.9c1.2,0,2.3,0.6,3,1.7
S141.4,88.5,141.4,90.1z"/>
<path class="st42" d="M106.2,77.3c0,0,5-12.5,16.5-6.5"/>
<path class="st42" d="M130.6,70.7c0,0,10.5-10.3,26.1,4"/>`;
const SLIM_purple=`<path class="st11" d="M220.1,267.8c-3.5-37.9-17.2-73.1-21.5-110.3c-3.2-28.1,4.9-56.6-4.4-84.2c-6.3-18.9-21-30.8-37-33.6
c-16.7-2.9-34.9,4.1-46.1,23.5c-8.5,14.6-10.9,31.8-13.2,48.5c-5.4,39.6-10.7,79.2-16.1,118.8c-1.6,11.9-3.2,23.9-1.6,35.8
c2.7,20.7,14.4,34.9,30,43.8c7.4,4.2,9.8,12.8,10.5,19.9c0.4,4.7,0.8,10.6,3.7,14.3c3.4,4.3,8.4,4.6,12.5,1.9
c6.9-4.5,6.6-15.4,8.7-22.8c0.4-1.4,1.7-2.2,3.1-2.1c3.4,0.3,6.9,0.4,10.3,0.4c1.4,0,2.6,1,2.9,2.3c1.6,7,1.4,15.2,5,21.8
c4.2,7.7,13.2,3.6,15.5-3.5c3-9.2,2.1-19.6,11.3-26c4.7-3.3,10.7-4.5,15-8.5C219.2,298,221.4,282.1,220.1,267.8z"/>
<path class="st42" d="M106.2,211.6c0,0,3.1,21.6,16,17.7c9.4-2.9,5-26.9,5-26.9"/>
<path class="st42" d="M144.2,205.4c0,0-9.3,19.3,0,25.1c8.5,5.3,15.7-10,15.7-10"/>
<path class="st10" d="M126.2,90.2c0,3.2-1.9,5.9-4.2,5.9c-2.4,0-4.3-2.6-4.3-5.8c0-3.2,1.9-5.9,4.2-5.9c1.2,0,2.3,0.6,3,1.7
C125.7,87.1,126.2,88.6,126.2,90.2z"/>
<path class="st10" d="M141.4,90.1c0,3.2-1.9,5.9-4.2,5.9c-2.4,0-4.3-2.6-4.3-5.8c0-3.2,1.9-5.9,4.2-5.9c1.2,0,2.3,0.6,3,1.7
S141.4,88.5,141.4,90.1z"/>
<path class="st42" d="M106.2,77.3c0,0,5-12.5,16.5-6.5"/>
<path class="st42" d="M130.6,70.7c0,0,10.5-10.3,26.1,4"/>`;
const SLIM_lightpurple=`<path class="st10" d="M220.1,267.8c-3.5-37.9-17.2-73.1-21.5-110.3c-3.2-28.1,4.9-56.6-4.4-84.2c-6.3-18.9-21-30.8-37-33.6
c-16.7-2.9-34.9,4.1-46.1,23.5c-8.5,14.6-10.9,31.8-13.2,48.5c-5.4,39.6-10.7,79.2-16.1,118.8c-1.6,11.9-3.2,23.9-1.6,35.8
c2.7,20.7,14.4,34.9,30,43.8c7.4,4.2,9.8,12.8,10.5,19.9c0.4,4.7,0.8,10.6,3.7,14.3c3.4,4.3,8.4,4.6,12.5,1.9
c6.9-4.5,6.6-15.4,8.7-22.8c0.4-1.4,1.7-2.2,3.1-2.1c3.4,0.3,6.9,0.4,10.3,0.4c1.4,0,2.6,1,2.9,2.3c1.6,7,1.4,15.2,5,21.8
c4.2,7.7,13.2,3.6,15.5-3.5c3-9.2,2.1-19.6,11.3-26c4.7-3.3,10.7-4.5,15-8.5C219.2,298,221.4,282.1,220.1,267.8z"/>
<path class="st42" d="M106.2,211.6c0,0,3.1,21.6,16,17.7c9.4-2.9,5-26.9,5-26.9"/>
<path class="st42" d="M144.2,205.4c0,0-9.3,19.3,0,25.1c8.5,5.3,15.7-10,15.7-10"/>
<path class="st6" d="M126.2,90.2c0,3.2-1.9,5.9-4.2,5.9c-2.4,0-4.3-2.6-4.3-5.8c0-3.2,1.9-5.9,4.2-5.9c1.2,0,2.3,0.6,3,1.7
C125.7,87.1,126.2,88.6,126.2,90.2z"/>
<path class="st6" d="M141.4,90.1c0,3.2-1.9,5.9-4.2,5.9c-2.4,0-4.3-2.6-4.3-5.8c0-3.2,1.9-5.9,4.2-5.9c1.2,0,2.3,0.6,3,1.7
S141.4,88.5,141.4,90.1z"/>
<path class="st42" d="M106.2,77.3c0,0,5-12.5,16.5-6.5"/>
<path class="st42" d="M130.6,70.7c0,0,10.5-10.3,26.1,4"/>`;

const SLIM_berets = `<path class="st0" d="M161.3,8.2c0,0-1.9-4.7,1.8-5.6c0,0,3.4-0.9,3.6-1.2c0,0,1.7,0.7,0.2,2.1c0,0-4,2.5-3.6,5L161.3,8.2z"/>
<path class="st1" d="M190.7,23.7C182.6,10,163,6.9,163,6.9s-19.4-4.4-31.9,5.3c0,0-4.4,3-2.8,7.3l3.7,9.1l25.9,5l25.9,5l6.8-7.2
	C193.6,28.1,190.7,23.7,190.7,23.7z"/>`;
const SLIM_orangehat = `<path class="st12" d="M194.6,37.2c0,0,1.1-4.3-4.8-6.5c-7.6,0.3-14.6-1-20.5-2.7c-3.8-1.1-7.1-2.4-9.9-3.7
c-4.6-2.1-8.3-4.4-10.8-6.1c-2.3-0.2-7.3-0.2-8.1,3.1c0,0-1.6,5.3,7.7,10.4c0,0,14.2,8,37.4,9.7C185.6,41.4,193.7,41.2,194.6,37.2z"
/>
<path class="st13" d="M190.1,28.1l2-8.4c0,0,1.2-7.3-5.3-11.6c0,0-9.9-5.7-20.5-6.8c0,0-8.9-0.6-12.2,6.8l-3.6,8.4
c2.4,1.6,5.8,3.6,10,5.6C167.5,25.2,177.9,28.6,190.1,28.1z"/>`;
const SLIM_fishermenhat = `<path class="st30" d="M140.8,15.6c0-0.6,0.6-0.8,0.9-1.2c1.7-1.9,3.4-3.9,5.3-5.7c3.6-3.5,8.2-5.6,13.6-6.4c4.4-0.7,8.8,0,13,1.9
c4.7,2.2,8.3,5.4,11.1,9.5c2.7,3.8,4.3,7.9,5.2,12.3c0.3,1.5,0.7,2.9,1,4.3c-0.8,0.3-1.6,0.2-2.5,0.3c-3.7,0.5-7.5,0.8-11.3,0.6
c-4.5-0.2-9-0.9-13.4-2.3c-7.1-2.2-13.5-5.8-19.2-10.4c-0.9-0.8-1.7-1.6-2.6-2.4C141.6,15.7,141.3,15.6,140.8,15.6z"/>
<path class="st31" d="M190.8,34.6c2.4,3.2,4.7,6.5,7.1,9.7c0.3,0.4,0.6,0.8,0.8,1.3c-0.2,0.2-0.4,0.2-0.7,0.3
c-8.9,1.9-18,2.4-27.3,0.4c-3.6-0.8-7.1-1.7-10.5-3.1c-2.2-0.9-4.5-1.7-6.7-2.6c-7.6-3.2-14.8-7.2-21.1-12.4c-1.6-1.3-3-2.6-4.3-4.2
c1-0.7,2.1-1.1,3.3-1.6c3.1-1.4,6-3.1,8.5-5.2c0.3,0.4,0.1,0.7-0.1,1c-0.7,0.9-0.5,1.8,0.2,2.7c1.6,2.3,3.6,4.3,5.9,6
c2.9,2.2,6.1,3.9,9.4,5.4c5.1,2.3,10.4,3.9,15.9,5c4.3,0.9,8.7,1.4,13,0.6c2.4-0.4,4.6-1.2,6.2-3C190.4,34.7,190.6,34.6,190.8,34.6z
"/>
<path class="st30" d="M128.2,24c0.3,0.1,0.6,0.3,0.8,0.6c4,4.3,8.9,7.5,14,10.5c2.7,1.6,5.6,3,8.4,4.3c3.8,1.8,7.7,3.3,11.7,4.6
c6.9,2.3,14,3.5,21.3,3.4c4.5-0.1,8.9-0.7,13.2-1.6c0.4-0.1,0.8-0.1,1.2-0.2c0.1,0.2,0.3,0.4,0.4,0.6c0.5,0.8,0.2,1.3-0.7,1.5
c-1.7,0.5-3.4,1.1-5.1,1.7c-6.7,2.3-13.7,3.4-21.2,2.8c-3.9-0.3-7.7-1-11.5-2.2c-3.2-1-6.2-2.1-9.3-3.4c-7.7-3.4-14.7-7.8-20.6-13.6
c-2.1-2.1-3.6-4.4-5.4-6.7c-0.3-0.3-0.1-0.5,0.1-0.7C126.3,25,127.2,24.4,128.2,24z"/>
<path class="st32" d="M190.8,34.6c-1.5,2.2-4,3-6.6,3.5c-3.7,0.7-7.4,0.4-11.1-0.3c-8.9-1.6-17.4-4.4-25.1-9.2
c-3.4-2.2-6.4-4.8-8.5-8.1c-0.5-0.7-0.5-1.3-0.1-2c0.3-0.4,0.4-0.8,0.6-1.3c0.3-0.6,0.6-1.1,0.9-1.7c0.3-0.5,0.6-0.5,1,0
c2.9,3,6.3,5.5,9.9,7.6c3.7,2.2,7.6,4,11.8,5.3c8.4,2.7,16.7,2.9,25,1.8c0.8-0.1,1.5-0.2,2.3-0.1C190.9,31.7,190.8,33.2,190.8,34.6z
"/>
<path class="st33" d="M167.3,25.6c-0.5,1.4-1.7,1.8-3.3,1.2c-1.2-0.5-1.8-1.8-1.3-3c0.5-1.2,2-1.7,3.4-1.1
C167.2,23.1,167.7,24.4,167.3,25.6z"/>
<path class="st33" d="M155.1,21.2c0.4-1.5,1.8-1.5,3.4-1.1c1.1,0.3,1.7,1.8,1.3,3c-0.5,1.2-1.7,1.7-3.1,1.1
C155.1,23.6,154.6,22.5,155.1,21.2z"/>
<path class="st34" d="M166.6,25.3c-0.3,0.9-1.2,1.2-2.2,0.9c-0.9-0.3-1.4-1.3-1-2.1c0.3-0.8,1.4-1.2,2.3-0.9
C166.6,23.5,167,24.4,166.6,25.3z"/>
<path class="st34" d="M159,22.7c-0.3,0.9-1.2,1.3-2.2,0.9c-0.9-0.3-1.4-1.3-1.1-2.1c0.3-0.8,1.4-1.2,2.3-0.9
C158.9,20.9,159.3,21.8,159,22.7z"/>`;
const SLIM_gentlemenhat = `<path class="st6" d="M188,37.4c0.2-1.5-1.7-1.9-1.7-1.9l-4.9-0.8l2.5-15.7c0.9-5.4-3-6-3-6l-17.4-2.8l-17.4-2.8c0,0-3.8-0.7-4.7,4.7
L138.9,28l-4.9-0.8c0,0-1.9-0.2-2.2,1.3c0,0-0.4,1.2,1.8,1.6l26.1,4.2l26.1,4.2C188,38.7,188,37.4,188,37.4z"/>`;
const SLIM_greenhat = `<path class="st39" d="M198.4,44.6c0.3-5-10.6-9.7-14-8.1c-6.4,3-39.7-1.7-45.6-14c-16.4-3.3-17.2,4.1-17.2,4.1
c-3.6,16.8,34.1,24,34.1,24C198.6,59.7,198.4,44.6,198.4,44.6z"/>
<path class="st40" d="M183.6,33.1c3.7-23-4.6-24.9-4.6-24.9c-3.4-2.2-8.5,0.5-8.5,0.5c-11.2-8.6-17.3-6.8-17.3-6.8
c-7.3,1.7-11.1,12.2-12.5,17.6C147.6,30.9,173.1,34.6,183.6,33.1z"/>`;

const SLIM_scarf = `<path class="st49" d="M84.7,164.1l-7.8,8.2"/>
<path class="st49" d="M76.7,158.6l-7.8,8.2"/>
<path class="st49" d="M90.7,169l-4.3,8.4"/>
<path class="st49" d="M97.7,170.7l-2.4,9.6"/>
<path class="st3" d="M97.3,119.4c0,0,56.4,17.9,100.3,2.6c0,0,10.4-0.4,2.1,8.7c0,0,10.6,2.3,3.9,8.9c-6.6,6.6-36.4,27.7-111.7,0.7
	c0,0-11.2-11.2,0.8-9.8C92.9,130.5,84,118.7,97.3,119.4z"/>
<path class="st3" d="M98,138.3c0,0-21,7.2-25.5,19.8c0,0,17.4,15,28.5,12.6l11.8-25.9L98,138.3z"/>`;
const SLIM_camera = `<path class="st14" d="M105.9,149.1l53.3,3.6l-2.1,31.5l-53.3-3.6L105.9,149.1z"/>
<path class="st15" d="M152.7,160.1l6,0.4l-1.1,15.8l-6-0.4L152.7,160.1z"/>
<path class="st16" d="M103.8,180.4l53.3,3.6l-0.5,7.8l-53.3-3.6L103.8,180.4z"/>
<path class="st17" d="M151.1,183.6l6,0.4l-0.5,7.8l-6-0.4L151.1,183.6z"/>
<path class="st16" d="M105.9,149.1l53.3,3.6l-0.5,7.8l-53.3-3.6L105.9,149.1z"/>
<path class="st18" d="M105.4,156.9l6,0.4l-1.1,15.8l-6-0.4L105.4,156.9z"/>
<path class="st19" d="M103.8,180.4l6,0.4l-0.5,7.8l-6-0.4L103.8,180.4z"/>
<path class="st20" d="M124.9,146.4c4.8,0.3,11.1,0.8,16,1.1l1.2,4c-5.8-0.4-13.1-0.9-18.9-1.3L124.9,146.4z"/>
<path class="st21" d="M147.8,149.2l6.9,0.5l-0.2,2.7l-6.9-0.5L147.8,149.2z"/>
<path class="st21" d="M110.8,146.7l6.9,0.5l-0.2,2.7l-6.9-0.5L110.8,146.7z"/>
<path class="st22" d="M151.1,149.4l0.5,0l-0.2,2.7l-0.5,0L151.1,149.4z"/>
<path class="st22" d="M153.4,149.5l0.5,0l-0.2,2.7l-0.5,0L153.4,149.5z"/>
<path class="st22" d="M152.2,149.5l0.5,0l-0.2,2.7l-0.5,0L152.2,149.5z"/>
<path class="st22" d="M149.9,149.3l0.5,0l-0.2,2.7l-0.5,0L149.9,149.3z"/>
<path class="st22" d="M148.7,149.2l0.5,0L149,152l-0.5,0L148.7,149.2z"/>
<path class="st18" d="M111.3,157.3l41.4,2.8l-0.1,0.8l-41.4-2.8L111.3,157.3L111.3,157.3z"/>
<path class="st23" d="M105.4,156.9l6,0.4l-0.1,0.8l-6-0.4L105.4,156.9z"/>
<path class="st14" d="M152.7,160.1l6,0.4l-0.1,0.8l-6-0.4L152.7,160.1z"/>
<path class="st18" d="M110.3,172.3l41.4,2.8l-0.1,0.8l-41.4-2.8L110.3,172.3L110.3,172.3z"/>
<path class="st23" d="M104.3,171.9l6,0.4l-0.1,0.8l-6-0.4L104.3,171.9z"/>
<path class="st14" d="M151.7,175.1l6,0.4l-0.1,0.8l-6-0.4L151.7,175.1z"/>
<path class="st21" d="M130.5,180.1c-7.4-0.6-13-7-12.4-14.5c0.6-7.4,7-13,14.5-12.4c7.4,0.6,13,7,12.4,14.5
	C144.4,175.1,137.9,180.6,130.5,180.1z"/>
<path class="st24" d="M121,165.9c0.4-5.8,5.4-10.2,11.3-9.8c5.8,0.4,10.2,5.4,9.8,11.3c-0.4,5.8-5.4,10.2-11.3,9.8
	C125,176.8,120.6,171.7,121,165.9z"/>
<path class="st25" d="M136,164.5c-2.3-2.7-3.9-5.7-4.6-8.4c0.2,0,0.5,0,0.8,0c5.8,0.4,10.2,5.4,9.8,11.3c0,0.7-0.2,1.4-0.3,2.1
	C139.7,168.2,137.7,166.6,136,164.5z"/>
<path class="st26" d="M128.1,166.4c0.1-1.9,1.8-3.4,3.7-3.2c1.9,0.1,3.4,1.8,3.2,3.7c-0.1,1.9-1.8,3.4-3.7,3.2
	C129.4,169.9,127.9,168.3,128.1,166.4z"/>
<path class="st27" d="M124.9,146.4l5,0.3l-1.8,3.8l-4.9-0.3L124.9,146.4z"/>
<path class="st28" d="M159.7,156.8l-0.7,0l0.1-1l1.3,0.1c0.4,0,0.7,0.4,0.7,0.8l-0.2,2.3c0,0.4-0.4,0.8-0.8,0.7l-1.3-0.1l0.1-1
	l0.7,0c0.2,0,0.3-0.2,0.3-0.3l0.1-1.1C160,157,159.9,156.9,159.7,156.8z"/>
<path class="st48" d="M198.1,139.5c0,0-21.9,14.5-40.1,18.3"/>
<path class="st28" d="M104.8,155.1l0.7,0l-0.1,1l-1.3-0.1c-0.4,0-0.7-0.4-0.7-0.8l0.2-2.3c0-0.4,0.4-0.8,0.8-0.7l1.3,0.1l-0.1,1
	l-0.7,0c-0.2,0-0.3,0.2-0.3,0.3l-0.1,1.1C104.4,154.8,104.6,155,104.8,155.1z"/>
<path class="st48" d="M107.3,154.8c0,0-11.2-20.9-11.1-30.6"/>
<path class="st17" d="M153.3,152.3l6,0.4l-0.5,7.8l-6-0.4L153.3,152.3z"/>
<path class="st19" d="M105.9,149.1l6,0.4l-0.5,7.8l-6-0.4L105.9,149.1z"/>`;
const SLIM_bowknot = `<path class="st35" d="M138.6,130.5c1.3-0.7,2.7-1.4,4-2.2c3.8-2.1,7.5-4.1,11.3-6.2c2.5-1.4,5.2-1,7.2,1c1.3,1.3,1.7,3,1.8,4.9
c0.2,4.4,0.5,8.7,0.7,13.1c0,0.1,0,0.2,0,0.3c-0.2,0-0.2-0.1-0.3-0.2c-0.4-1.3-1.4-2-2.4-2.5c-1.7-0.9-3.5-1.2-5.4-1.4
c-4.5-0.4-8.8,0.7-13,2.1c-1.1,0.3-2.1,0.7-3.2,1.1c-0.3,0.1-0.5,0.2-0.8,0.1c-0.3-0.2-0.2-0.5-0.2-0.7c0.1-2.2,0.1-4.4,0.2-6.7
c0-0.7,0.1-1.3-0.1-2C138.5,130.9,138.4,130.7,138.6,130.5z"/>
<path class="st35" d="M103.9,139.9c0.2-1.9,0.4-3.7,0.6-5.5c0.3-2.8,0.6-5.7,0.9-8.5c0.5-4.6,5.1-7.2,8.9-5c3.1,1.8,6.2,3.8,9.3,5.7
c1.9,1.2,3.8,2.4,5.7,3.6c0,0,0.1,0,0.2,0c0.1,0.1,0.1,0.2,0.1,0.3c-0.4,2.8-0.2,5.7-0.4,8.5c0,0.4,0,0.8-0.2,1.1
c-0.3,0.2-0.6,0-0.9-0.1c-3.1-1.3-6.2-2.5-9.4-3.3c-3.4-0.8-6.8-1-10.2-0.2c-1.3,0.3-2.6,0.7-3.5,1.8c-0.3,0.4-0.7,0.7-0.8,1.2
C104.2,139.7,104.1,139.9,103.9,139.9z"/>
<path class="st36" d="M145.8,144.9c0.2,0.9,0.6,1.6,1,2.4c2.3,5,4.5,10,6.8,15c0.1,0.2,0.2,0.4,0.3,0.7c-0.3,0.1-0.5-0.1-0.6-0.2
c-2.2-1.3-4.4-2.5-6.5-3.8c-0.4-0.2-0.6-0.3-0.6,0.3c-0.4,2.7-0.9,5.4-1.3,8.2c0,0.2-0.1,0.3-0.1,0.4c-0.2,0-0.2-0.2-0.3-0.3
c-3.6-7.9-7.1-15.8-10.7-23.7c0-0.1-0.1-0.2-0.1-0.3c0-0.1-0.1-0.2-0.1-0.3c-0.3-0.5-0.2-0.6,0.3-0.7c0.4,0,0.8,0,1.1,0
c0.9,0.1,1.8-0.2,2.4-0.9c0.2-0.2,0.3-0.4,0.6-0.4c0.7,0.6,1.6,0.9,2.4,1.2c1.6,0.7,3.2,1.3,4.9,1.9
C145.5,144.6,145.7,144.7,145.8,144.9z"/>
<path class="st36" d="M133.1,143.5c-1.1,2.1-2.2,4.3-3.3,6.4c-2.9,5.6-5.8,11.2-8.8,16.9c-0.1,0.2-0.2,0.4-0.4,0.7
c-0.2-1.4-0.3-2.6-0.4-3.8c-0.2-1.7-0.3-3.4-0.5-5.1c0-0.5-0.2-0.6-0.6-0.4c-2.3,1.2-4.5,2.3-6.8,3.4c-0.2,0.1-0.4,0.2-0.6,0.3
c-0.1-0.3,0.1-0.4,0.2-0.6c2.8-5.4,5.6-10.8,8.4-16.2c0.1-0.2,0.3-0.4,0.2-0.7c0.2-0.4,0.5-0.3,0.8-0.4c2.4-0.6,4.8-1.4,7.1-2.3
c0.4-0.1,0.6-0.4,0.7-0.8c0.4,0,0.6,0.4,0.7,0.6c0.4,0.8,1.1,0.9,1.8,1.1c0.3,0.1,0.6,0,0.8,0C133.3,142.7,133.4,142.8,133.1,143.5z
"/>
<path class="st37" d="M129.3,141c0.2,0.4,0,0.6-0.4,0.8c-2.6,1-5.2,1.9-7.9,2.5c-0.1,0-0.3,0.1-0.4,0.1c-2.6,0.6-5.2,1.1-7.8,0.9
c-2.2-0.2-4.3-0.5-6.4-1.5c-0.8-0.4-1.6-0.9-2.1-1.8c-0.4-0.7-0.7-1.4-0.4-2.2c0.5-2.1,2.2-2.7,3.9-3.3c1.4-0.5,2.9-0.6,4.4-0.7
c4-0.2,7.7,0.9,11.5,2.2c1.7,0.6,3.5,1.4,5.2,2.1C129.3,140.2,129.4,140.5,129.3,141z"/>
<path class="st37" d="M145.8,144.9c-2.5-0.8-4.9-1.8-7.3-2.8c-0.2-0.1-0.5-0.2-0.4-0.6c0-0.5,0.2-0.9,0.7-1.1
c3.7-1.4,7.4-2.6,11.2-3.2c2.5-0.4,5.1-0.3,7.6,0.1c1.5,0.3,2.9,0.7,4.2,1.6c0.9,0.6,1.6,1.3,1.9,2.5c0.2,1.3-0.3,2.2-1.2,3
c-1.5,1.3-3.3,1.7-5.1,1.9c-3.5,0.5-7,0-10.4-1C146.5,145.1,146.1,145,145.8,144.9z"/>
<path class="st38" d="M138.7,140.4c-0.4,0.3-0.4,0.7-0.7,1.1c-0.2,0.2-0.4,0.3-0.6,0.5c-0.6,0.7-1.3,1-2.2,0.9c-0.4,0-0.7,0-1.1,0
c-0.7,0-0.7,0-0.6,0.7c-0.1-0.1-0.2-0.5-0.5-0.2c0.1-0.6-0.2-0.7-0.6-0.6c-0.5,0-1,0-1.4-0.2c-0.5-0.2-0.9-0.4-1.2-0.9
c-0.1-0.2-0.3-0.6-0.6-0.7c-0.2-0.3-0.2-0.7-0.5-0.8c0.2-0.2,0.1-0.5,0.1-0.7c0.1-2.3,0.1-4.6,0.2-7c0-0.8,0-1.5,0.3-2.3
c0.5-1.3,1.5-2,2.8-2c1.2,0,2.4,0,3.6,0.1c1.4,0.1,2.2,0.8,2.7,2.2c0.2,0.8,0.2,1.6,0.2,2.4c-0.1,2.5-0.2,4.9-0.3,7.3
C138.5,140.4,138.6,140.4,138.7,140.4z"/>`;
const SLIM_bowtie = `<path class="st6" d="M141.5,130.8l-4.9,2.6c-0.6,0.3-1.2,0.1-1.6-0.4c-1.2-1.5-3-2.5-5-2.5c-2.1-0.1-3.9,0.8-5.1,2.3
c-0.4,0.5-1.1,0.7-1.6,0.3l-4.7-2.9l-8.1-5c-1.4-0.9-3.3,0.1-3.4,1.8c2.6,6.1,2.4,13-0.5,18.9c0,1.7,1.8,2.8,3.3,2l8.3-4.5l4.9-2.6
c0.6-0.3,1.2-0.1,1.6,0.4c1.2,1.5,3,2.5,5,2.5c2.1,0.1,3.9-0.8,5.1-2.3c0.4-0.5,1.1-0.7,1.6-0.3l4.7,2.9l8.1,5
c1.4,0.9,3.3-0.1,3.4-1.8c-2.6-6.1-2.4-13,0.5-18.9c0-1.7-1.8-2.8-3.3-2L141.5,130.8z"/>`;
const SLIM_greentie = `<path class="st40" d="M127.9,131c0.6,0.1,1.3,0.2,2,0.3c0.7,0,1.4-0.1,2.2-0.1c0.3,0,0.3,0.1,0.3,0.3c0,0.1,0.1,0.3,0.1,0.4
c3.8,10,6.4,19.8,7.7,30.5c0.8,6.6,2.1,13.4,2.3,20.1c0,0.3-0.1,0.5-0.3,0.7c-2.2,2.6-9.6,9.2-11.8,11.8c-0.3,0.3-0.4,0.3-0.7,0
c-1.9-2.2-4.7-4.5-6.7-7.1c-1.6-2.1-4.3-4.7-4.2-7.6c0.3-8.3,1.8-16.5,2.6-24.8c0.4-4.2,1.1-8.4,2.1-12.5c1-3.9,2.1-7,3.4-10.6
c0.1-0.3,0.2-0.7,0.2-1.1c0-0.1,0-0.2,0.1-0.2C127.5,130.9,127.7,131,127.9,131z"/>
<path class="st39" d="M131,130.4c-0.5,0-0.9,0.1-1.4,0c-0.6,0-1.2-0.1-1.8-0.2c-0.5-0.1-0.8-0.5-1.2-0.8c-0.4-0.4-0.8-0.8-1.1-1.3
c-0.7-0.9-1.3-1.9-1.8-2.9c-0.6-1-0.7-1.9-0.3-3.1c0.3-0.8,0.7-1.2,1.6-1.4c3.6-0.7,7.3-0.7,10.9,0.1c0.2,0.1,0.5,0,0.6,0.4
c0.6,1.5,0.9,2.8-0.1,4.3c-0.6,0.9-1.2,1.9-1.9,2.8c-0.5,0.7-1.1,1.3-1.9,1.7c-0.1,0-0.1,0.1-0.2,0.1
C131.9,130.3,131.4,130.3,131,130.4z"/>`;


// normal
const NORMAL_pink =`<path class="st5" d="M260,293.2c-0.8-4.6-5.2-7.9-11.3-9.2c-3.2-0.7-5.4-4.1-4.7-7.5c1.2-5.9,2-12.1,2.3-18.8
c2.4-50.7-23.5-104-65.2-129.4C162.8,117,159.4,91.7,148,73.7c-13.6-21.4-33.9-34.9-58.7-27.4c-15.5,4.7-53.1,12.5-49.2,147.3
c3.9,134.7,57,161.9,117,155.6c29.6-3.1,54.1-14.5,70-34.8c1.2-1.6,3.1-2.4,5-2.4c2.4,0.1,4.9-0.1,7.5-0.7
C252.2,308.9,261.3,300.7,260,293.2z"/>
<path class="st42" d="M105.9,174.2c2.3,10.5,7,21.5,13.1,21.3c14.2-0.4,8.6-24.3,8.6-24.3"/>
<path class="st42" d="M165.6,161.1c1.8,11.2-1.1,28.6-14.3,25.9c-5.9-1.2-8.5-10.6-6-20.4"/>
<path class="st42" d="M155.8,293.3c11.6-6.8,24.4-6.7,28.5,0.4c4.1,7-2,12.4-13.6,19.2"/>
<path class="st6" d="M91.4,64.5c1.5,2.9,1,6.2-1.2,7.3s-5.1-0.4-6.6-3.3c-1.5-2.9-1-6.2,1.2-7.3c1-0.5,2.3-0.5,3.5,0.1
C89.4,61.9,90.6,63,91.4,64.5z"/>
<path class="st6" d="M105.1,57.4c1.5,2.9,1,6.2-1.2,7.3s-5.1-0.4-6.6-3.3c-1.5-2.9-1-6.2,1.2-7.3c1.3-0.7,3-0.4,4.4,0.7
C103.8,55.5,104.6,56.3,105.1,57.4z"/>
<path class="st42" d="M72,58.2c0,0,0.7-10.8,8.1-14"/>
<path class="st42" d="M88.2,40.2c0,0,5.2-2.7,15,0"/>`;
const NORMAL_red =`<path class="st7" d="M260,293.2c-0.8-4.6-5.2-7.9-11.3-9.2c-3.2-0.7-5.4-4.1-4.7-7.5c1.2-5.9,2-12.1,2.3-18.8
c2.4-50.7-23.5-104-65.2-129.4C162.8,117,159.4,91.7,148,73.7c-13.6-21.4-33.9-34.9-58.7-27.4c-15.5,4.7-53.1,12.5-49.2,147.3
c3.9,134.7,57,161.9,117,155.6c29.6-3.1,54.1-14.5,70-34.8c1.2-1.6,3.1-2.4,5-2.4c2.4,0.1,4.9-0.1,7.5-0.7
C252.2,308.9,261.3,300.7,260,293.2z"/>
<path class="st42" d="M105.9,174.2c2.3,10.5,7,21.5,13.1,21.3c14.2-0.4,8.6-24.3,8.6-24.3"/>
<path class="st42" d="M165.6,161.1c1.8,11.2-1.1,28.6-14.3,25.9c-5.9-1.2-8.5-10.6-6-20.4"/>
<path class="st42" d="M155.8,293.3c11.6-6.8,24.4-6.7,28.5,0.4c4.1,7-2,12.4-13.6,19.2"/>
<path class="st8" d="M91.4,64.5c1.5,2.9,1,6.2-1.2,7.3s-5.1-0.4-6.6-3.3c-1.5-2.9-1-6.2,1.2-7.3c1-0.5,2.3-0.5,3.5,0.1
C89.4,61.9,90.6,63,91.4,64.5z"/>
<path class="st8" d="M105.1,57.4c1.5,2.9,1,6.2-1.2,7.3s-5.1-0.4-6.6-3.3c-1.5-2.9-1-6.2,1.2-7.3c1.3-0.7,3-0.4,4.4,0.7
C103.8,55.5,104.6,56.3,105.1,57.4z"/>
<path class="st42" d="M72,58.2c0,0,0.7-10.8,8.1-14"/>
<path class="st42" d="M88.2,40.2c0,0,5.2-2.7,15,0"/>`;
const NORMAL_blue =`<path class="st9" d="M260,293.2c-0.8-4.6-5.2-7.9-11.3-9.2c-3.2-0.7-5.4-4.1-4.7-7.5c1.2-5.9,2-12.1,2.3-18.8
c2.4-50.7-23.5-104-65.2-129.4C162.8,117,159.4,91.7,148,73.7c-13.6-21.4-33.9-34.9-58.7-27.4c-15.5,4.7-53.1,12.5-49.2,147.3
c3.9,134.7,57,161.9,117,155.6c29.6-3.1,54.1-14.5,70-34.8c1.2-1.6,3.1-2.4,5-2.4c2.4,0.1,4.9-0.1,7.5-0.7
C252.2,308.9,261.3,300.7,260,293.2z"/>
<path class="st42" d="M105.9,174.2c2.3,10.5,7,21.5,13.1,21.3c14.2-0.4,8.6-24.3,8.6-24.3"/>
<path class="st42" d="M165.6,161.1c1.8,11.2-1.1,28.6-14.3,25.9c-5.9-1.2-8.5-10.6-6-20.4"/>
<path class="st42" d="M155.8,293.3c11.6-6.8,24.4-6.7,28.5,0.4c4.1,7-2,12.4-13.6,19.2"/>
<path class="st6" d="M91.4,64.5c1.5,2.9,1,6.2-1.2,7.3s-5.1-0.4-6.6-3.3c-1.5-2.9-1-6.2,1.2-7.3c1-0.5,2.3-0.5,3.5,0.1
C89.4,61.9,90.6,63,91.4,64.5z"/>
<path class="st6" d="M105.1,57.4c1.5,2.9,1,6.2-1.2,7.3s-5.1-0.4-6.6-3.3c-1.5-2.9-1-6.2,1.2-7.3c1.3-0.7,3-0.4,4.4,0.7
C103.8,55.5,104.6,56.3,105.1,57.4z"/>
<path class="st42" d="M72,58.2c0,0,0.7-10.8,8.1-14"/>
<path class="st42" d="M88.2,40.2c0,0,5.2-2.7,15,0"/>`;
const NORMAL_purple =`<path class="st11" d="M260,293.2c-0.8-4.6-5.2-7.9-11.3-9.2c-3.2-0.7-5.4-4.1-4.7-7.5c1.2-5.9,2-12.1,2.3-18.8
c2.4-50.7-23.5-104-65.2-129.4C162.8,117,159.4,91.7,148,73.7c-13.6-21.4-33.9-34.9-58.7-27.4c-15.5,4.7-53.1,12.5-49.2,147.3
c3.9,134.7,57,161.9,117,155.6c29.6-3.1,54.1-14.5,70-34.8c1.2-1.6,3.1-2.4,5-2.4c2.4,0.1,4.9-0.1,7.5-0.7
C252.2,308.9,261.3,300.7,260,293.2z"/>
<path class="st42" d="M105.9,174.2c2.3,10.5,7,21.5,13.1,21.3c14.2-0.4,8.6-24.3,8.6-24.3"/>
<path class="st42" d="M165.6,161.1c1.8,11.2-1.1,28.6-14.3,25.9c-5.9-1.2-8.5-10.6-6-20.4"/>
<path class="st42" d="M155.8,293.3c11.6-6.8,24.4-6.7,28.5,0.4c4.1,7-2,12.4-13.6,19.2"/>
<path class="st10" d="M91.4,64.5c1.5,2.9,1,6.2-1.2,7.3s-5.1-0.4-6.6-3.3c-1.5-2.9-1-6.2,1.2-7.3c1-0.5,2.3-0.5,3.5,0.1
C89.4,61.9,90.6,63,91.4,64.5z"/>
<path class="st10" d="M105.1,57.4c1.5,2.9,1,6.2-1.2,7.3s-5.1-0.4-6.6-3.3c-1.5-2.9-1-6.2,1.2-7.3c1.3-0.7,3-0.4,4.4,0.7
C103.8,55.5,104.6,56.3,105.1,57.4z"/>
<path class="st42" d="M72,58.2c0,0,0.7-10.8,8.1-14"/>
<path class="st42" d="M88.2,40.2c0,0,5.2-2.7,15,0"/>`;
const NORMAL_lightpurple =`<path class="st10" d="M260,293.2c-0.8-4.6-5.2-7.9-11.3-9.2c-3.2-0.7-5.4-4.1-4.7-7.5c1.2-5.9,2-12.1,2.3-18.8
c2.4-50.7-23.5-104-65.2-129.4C162.8,117,159.4,91.7,148,73.7c-13.6-21.4-33.9-34.9-58.7-27.4c-15.5,4.7-53.1,12.5-49.2,147.3
c3.9,134.7,57,161.9,117,155.6c29.6-3.1,54.1-14.5,70-34.8c1.2-1.6,3.1-2.4,5-2.4c2.4,0.1,4.9-0.1,7.5-0.7
C252.2,308.9,261.3,300.7,260,293.2z"/>
<path class="st42" d="M105.9,174.2c2.3,10.5,7,21.5,13.1,21.3c14.2-0.4,8.6-24.3,8.6-24.3"/>
<path class="st42" d="M165.6,161.1c1.8,11.2-1.1,28.6-14.3,25.9c-5.9-1.2-8.5-10.6-6-20.4"/>
<path class="st42" d="M155.8,293.3c11.6-6.8,24.4-6.7,28.5,0.4c4.1,7-2,12.4-13.6,19.2"/>
<path class="st6" d="M91.4,64.5c1.5,2.9,1,6.2-1.2,7.3s-5.1-0.4-6.6-3.3c-1.5-2.9-1-6.2,1.2-7.3c1-0.5,2.3-0.5,3.5,0.1
C89.4,61.9,90.6,63,91.4,64.5z"/>
<path class="st6" d="M105.1,57.4c1.5,2.9,1,6.2-1.2,7.3s-5.1-0.4-6.6-3.3c-1.5-2.9-1-6.2,1.2-7.3c1.3-0.7,3-0.4,4.4,0.7
C103.8,55.5,104.6,56.3,105.1,57.4z"/>
<path class="st42" d="M72,58.2c0,0,0.7-10.8,8.1-14"/>
<path class="st42" d="M88.2,40.2c0,0,5.2-2.7,15,0"/>`;

const NORMAL_berets = `<path class="st0" d="M64.6,14.8c0,0-4.3-2.7-1.9-5.6c0,0,2.2-2.8,2.2-3.1c0,0,1.8-0.4,1.4,1.6c0,0-1.8,4.4,0.1,6.2L64.6,14.8z"/>
<path class="st1" d="M97.4,10c-14.6-6.3-32.2,2.8-32.2,2.8s-18.3,7.8-22.7,23.1c0,0-1.7,5,2.1,7.6l8.3,5.2l23.8-11.2l23.8-11.2
	l1.3-9.8C102.3,11.9,97.4,10,97.4,10z"/>`;
const NORMAL_orangehat = `<path class="st12" d="M102.4,19.6c0,0-1.7-4-7.8-2.3c-5.9,4.8-12.2,8.1-17.9,10.3c-3.7,1.4-7.1,2.4-10.1,3c-5,1.1-9.3,1.6-12.3,1.7
c-1.9,1.2-5.9,4.2-4.6,7.3c0,0,1.9,5.2,12.4,3.6c0,0,16.1-2.2,35.6-15C97.8,28.4,104.1,23.3,102.4,19.6z"/>
<path class="st13" d="M93.4,15.1l-3.5-7.9c0,0-3.5-6.6-11.2-6c0,0-11.4,1.4-20.5,7c0,0-7.5,4.9-5.6,12.8l2.2,8.9
c2.9-0.2,6.8-0.6,11.3-1.6C73.5,26.5,84,22.9,93.4,15.1z"/>`;
const NORMAL_fishermenhat = `<path class="st30" d="M89.1,14.1c-0.8,0.7-1.5,1.6-2.4,2.3c-5.2,4.3-11,7.7-17.5,9.8c-4,1.3-8.1,2.1-12.3,2.3
c-3.5,0.2-6.9,0-10.3-0.4c-0.8-0.1-1.6,0-2.3-0.2c0.3-1.3,0.6-2.7,0.9-4c0.7-4,2.2-7.8,4.6-11.3c2.5-3.7,5.8-6.8,10-8.8
c3.8-1.8,7.8-2.5,11.9-1.9c4.9,0.7,9.2,2.5,12.6,5.7c1.7,1.6,3.3,3.5,4.9,5.2c0.3,0.3,0.9,0.5,0.9,1.1
C89.7,13.7,89.4,13.8,89.1,14.1z"/>
<path class="st31" d="M45,32c1.5,1.6,3.5,2.3,5.7,2.6c3.9,0.6,7.9,0.2,11.9-0.7c5-1.1,9.9-2.6,14.5-4.8c3-1.4,6-3,8.6-5
c2.1-1.6,3.9-3.4,5.3-5.6c0.6-0.8,0.8-1.6,0.1-2.4c-0.2-0.2-0.4-0.5-0.1-0.9c2.3,1.9,5,3.4,7.8,4.6c1,0.4,2.1,0.8,3,1.4
c-1.1,1.4-2.4,2.7-3.9,3.9c-5.8,4.8-12.3,8.6-19.2,11.6c-2,0.9-4.1,1.6-6.1,2.5c-3.1,1.3-6.3,2.2-9.6,2.9c-8.5,2-16.8,1.7-25,0
c-0.2-0.1-0.5-0.1-0.6-0.3c0.2-0.4,0.5-0.8,0.7-1.2c2.1-3,4.3-6,6.4-9C44.7,31.8,44.8,31.9,45,32z"/>
<path class="st30" d="M104.3,22.7c0.2,0.2,0.4,0.3,0.1,0.6c-1.6,2.1-3,4.3-4.9,6.2c-5.3,5.4-11.7,9.6-18.7,12.7
c-2.8,1.2-5.6,2.3-8.5,3.3c-3.5,1.1-7,1.9-10.5,2.2c-6.8,0.6-13.3-0.3-19.5-2.3c-1.6-0.5-3.1-1-4.7-1.4c-0.8-0.2-1-0.6-0.6-1.4
c0.1-0.2,0.2-0.4,0.4-0.6c0.4,0,0.7,0.1,1.1,0.1c4,0.7,8,1.2,12.2,1.3c6.6,0.1,13.1-1.2,19.5-3.4c3.6-1.2,7.2-2.7,10.7-4.3
c2.6-1.3,5.2-2.5,7.7-4c4.7-2.8,9.1-5.8,12.7-9.8c0.2-0.2,0.4-0.4,0.7-0.5C102.7,21.6,103.6,22.1,104.3,22.7z"/>
<path class="st32" d="M44.4,27.8c0.7-0.1,1.4,0,2.1,0c7.7,0.9,15.3,0.7,23-1.9c3.8-1.3,7.3-3,10.7-5.1c3.3-2,6.3-4.4,9-7.1
c0.4-0.4,0.6-0.4,0.9,0c0.3,0.5,0.6,1,0.8,1.5c0.2,0.4,0.3,0.8,0.6,1.2c0.4,0.6,0.3,1.1-0.1,1.8c-2,3-4.6,5.5-7.7,7.5
c-7,4.5-14.8,7.2-22.9,8.8c-3.4,0.7-6.9,1-10.2,0.4c-2.4-0.4-4.7-1.1-6.1-3.1C44.4,30.5,44.4,29.1,44.4,27.8z"/>
<path class="st33" d="M67,20.5c1.3-0.5,2.7-0.1,3.1,1c0.4,1.1-0.1,2.3-1.2,2.8c-1.5,0.6-2.6,0.2-3.1-1C65.5,22.2,66,20.9,67,20.5z"
/>
<path class="st33" d="M75.8,21.8c-1.3,0.5-2.4,0.1-2.9-1C72.5,19.7,73,18.3,74,18c1.5-0.4,2.7-0.4,3.1,1
C77.6,20.2,77.1,21.2,75.8,21.8z"/>
<path class="st34" d="M67.4,21c0.9-0.3,1.8,0,2.1,0.8c0.3,0.8-0.1,1.6-0.9,2c-0.9,0.3-1.7,0-2-0.8C66.2,22.1,66.6,21.3,67.4,21z"/>
<path class="st34" d="M74.3,18.5c0.9-0.3,1.9,0,2.2,0.8c0.3,0.8-0.1,1.7-0.9,2c-0.8,0.3-1.7,0-2-0.8C73.2,19.6,73.6,18.8,74.3,18.5z
"/>`;
const NORMAL_gentlemenhat = `<path class="st6" d="M102.6,24.3c-0.5-1.3-2.2-0.7-2.2-0.7L96,25.2l-5.3-13.8C88.9,6.7,85.5,8,85.5,8l-15.3,5.9l-15.3,5.9
c0,0-3.4,1.2-1.6,6l5.3,13.8l-4.3,1.7c0,0-1.7,0.7-1.2,2c0,0,0.3,1.2,2.2,0.4l23-8.8l23-8.8C103.2,25.3,102.6,24.3,102.6,24.3z"/>`;
const NORMAL_greenhat = `<path class="st39" d="M95.7,11.3c-2.7-3-11.7,0.5-12.8,3.5C81,20.1,59,36.6,48.5,32.9C37.1,40.4,41,45.2,41,45.2
c7.6,11.8,33.5-5.8,33.5-5.8C104.5,19.8,95.7,11.3,95.7,11.3z"/>
<path class="st40" d="M80.4,13.2c-11.1-15.4-17-11.7-17-11.7c-3.2,0.7-4.6,5.2-4.6,5.2c-11.5,1.5-13.9,6.1-13.9,6.1
c-3.3,5.2,0.7,13.5,2.9,17.4C58.4,32.6,75.3,20.1,80.4,13.2z"/>`;

const NORMAL_scarf = `<path class="st47" d="M36.7,192.3l-7.2,13.1"/>
<path class="st47" d="M24.7,187.9L17.5,201"/>
<path class="st47" d="M46,196.5l-2.7,12.2"/>
<path class="st47" d="M55.5,196.3l0.2,13.1"/>
<path class="st3" d="M37.8,131.2c0,0,77.8,3.9,128.5-30.4c0,0,13.1-4,5.6,10.3c0,0,14.2-0.6,8,10c-6.2,10.6-37,47.5-141.9,38.4
	c0,0-18-10.5-2.2-12.7C35.8,146.7,20.5,134.8,37.8,131.2z"/>
<path class="st3" d="M45,154.9c0,0-24.3,16.2-25.8,33.7c0,0,27.1,13.2,40.5,6.4l6.4-36.9L45,154.9z"/>`;
const NORMAL_camera = `<path class="st14" d="M148.8,126l-53.3,3.6l2.1,31.5l53.3-3.6L148.8,126z"/>
<path class="st15" d="M102,137l-6,0.4l1.1,15.8l6-0.4L102,137z"/>
<path class="st16" d="M150.9,157.3l-53.3,3.6l0.5,7.8l53.3-3.6L150.9,157.3z"/>
<path class="st17" d="M103.5,160.5l-6,0.4l0.5,7.8l6-0.4L103.5,160.5z"/>
<path class="st16" d="M148.8,126l-53.3,3.6l0.5,7.8l53.3-3.6L148.8,126z"/>
<path class="st18" d="M149.3,133.8l-6,0.4l1.1,15.8l6-0.4L149.3,133.8z"/>
<path class="st19" d="M150.9,157.3l-6,0.4l0.5,7.8l6-0.4L150.9,157.3z"/>
<path class="st20" d="M129.8,123.3c-4.8,0.3-11.1,0.8-16,1.1l-1.2,4c5.8-0.4,13.1-0.9,18.9-1.3L129.8,123.3z"/>
<path class="st21" d="M106.9,126.1l-6.9,0.5l0.2,2.7l6.9-0.5L106.9,126.1z"/>
<path class="st21" d="M143.9,123.6l-6.9,0.5l0.2,2.7l6.9-0.5L143.9,123.6z"/>
<path class="st22" d="M103.6,126.3l-0.5,0l0.2,2.7l0.5,0L103.6,126.3z"/>
<path class="st22" d="M101.3,126.5l-0.5,0l0.2,2.7l0.5,0L101.3,126.5z"/>
<path class="st22" d="M102.4,126.4l-0.5,0l0.2,2.7l0.5,0L102.4,126.4z"/>
<path class="st22" d="M104.8,126.2l-0.5,0l0.2,2.7l0.5,0L104.8,126.2z"/>
<path class="st22" d="M106,126.2l-0.5,0l0.2,2.7l0.5,0L106,126.2z"/>
<path class="st18" d="M143.4,134.2L102,137l0.1,0.8l41.4-2.8L143.4,134.2L143.4,134.2z"/>
<path class="st23" d="M149.3,133.8l-6,0.4l0.1,0.8l6-0.4L149.3,133.8z"/>
<path class="st14" d="M102,137l-6,0.4l0.1,0.8l6-0.4L102,137z"/>
<path class="st18" d="M144.4,149.3L103,152l0.1,0.8l41.4-2.8L144.4,149.3L144.4,149.3z"/>
<path class="st23" d="M150.3,148.9l-6,0.4l0.1,0.8l6-0.4L150.3,148.9z"/>
<path class="st14" d="M103,152l-6,0.4l0.1,0.8l6-0.4L103,152z"/>
<path class="st21" d="M124.2,157c7.4-0.6,13-7,12.4-14.5c-0.6-7.4-7-13-14.5-12.4s-13,7-12.4,14.5C110.3,152,116.8,157.6,124.2,157z
	"/>
<path class="st24" d="M133.7,142.9c-0.4-5.8-5.4-10.2-11.3-9.8c-5.8,0.4-10.2,5.4-9.8,11.3c0.4,5.8,5.4,10.2,11.3,9.8
	C129.7,153.7,134.1,148.6,133.7,142.9z"/>
<path class="st25" d="M118.7,141.5c2.3-2.7,3.9-5.7,4.6-8.4c-0.2,0-0.5,0-0.8,0c-5.8,0.4-10.2,5.4-9.8,11.3c0,0.7,0.2,1.4,0.3,2.1
	C115,145.1,116.9,143.5,118.7,141.5z"/>
<path class="st26" d="M126.6,143.3c-0.1-1.9-1.8-3.4-3.7-3.2s-3.4,1.8-3.2,3.7s1.8,3.4,3.7,3.2C125.3,146.8,126.8,145.2,126.6,143.3
	z"/>
<path class="st27" d="M129.8,123.3l-5,0.3l1.8,3.8l4.9-0.3L129.8,123.3z"/>
<path class="st28" d="M95,133.8l0.7,0l-0.1-1l-1.3,0.1c-0.4,0-0.7,0.4-0.7,0.8l0.2,2.3c0,0.4,0.4,0.8,0.8,0.7l1.3-0.1l-0.1-1l-0.7,0
	c-0.2,0-0.3-0.2-0.3-0.3l-0.1-1.1C94.7,134,94.8,133.8,95,133.8z"/>
<path class="st48" d="M44.6,111c0,0,33.8,20,52,23.7"/>
<path class="st28" d="M149.9,132l-0.7,0l0.1,1l1.3-0.1c0.4,0,0.7-0.4,0.7-0.8l-0.2-2.3c0-0.4-0.4-0.8-0.8-0.7l-1.3,0.1l0.1,1l0.7,0
	c0.2,0,0.3,0.2,0.3,0.3l0.1,1.1C150.3,131.8,150.1,132,149.9,132z"/>
<path class="st48" d="M147.4,131.7c0,0,17.4-15.9,17.3-25.5"/>
<path class="st17" d="M101.4,129.2l-6,0.4l0.5,7.8l6-0.4L101.4,129.2z"/>
<path class="st19" d="M148.8,126l-6,0.4l0.5,7.8l6-0.4L148.8,126z"/>`;
const NORMAL_bowknot = `<path class="st35" d="M130.3,124.5c1.5-1.3,3-2.6,4.5-3.9c4.2-3.7,8.3-7.4,12.5-11.1c2.8-2.5,6.4-2.7,9.4-0.8c2,1.3,3.1,3.3,3.8,5.7
c1.5,5.5,3.1,10.9,4.7,16.3c0,0.1,0,0.2,0,0.3c-0.2,0.1-0.3-0.1-0.4-0.2c-0.9-1.5-2.3-2.1-3.8-2.5c-2.4-0.6-4.8-0.5-7.2-0.2
c-5.8,0.8-10.9,3.4-15.9,6.4c-1.2,0.8-2.5,1.5-3.7,2.3c-0.3,0.2-0.6,0.4-1,0.4c-0.4-0.1-0.4-0.5-0.5-0.9c-0.6-2.8-1.1-5.7-1.7-8.5
c-0.2-0.8-0.3-1.7-0.7-2.5C130.3,125.1,130.2,124.8,130.3,124.5z"/>
<path class="st35" d="M89.1,146.6c-0.3-2.4-0.6-4.8-0.9-7.2c-0.4-3.7-0.9-7.3-1.3-11c-0.7-6,4.3-10.6,9.8-8.9c4.5,1.4,9,3,13.5,4.5
c2.8,0.9,5.5,1.9,8.3,2.9c0.1,0,0.2,0,0.2,0c0.1,0.1,0.2,0.2,0.2,0.4c0.3,3.7,1.4,7.2,2,10.9c0.1,0.5,0.3,1,0.1,1.5
c-0.4,0.4-0.8,0.2-1.2,0.1c-4.3-0.8-8.5-1.4-12.9-1.4c-4.5-0.1-8.9,0.7-13,2.8c-1.5,0.8-3,1.7-4,3.3c-0.3,0.5-0.6,1.1-0.6,1.8
C89.4,146.3,89.4,146.6,89.1,146.6z"/>
<path class="st36" d="M143.6,140.7c0.5,1,1.3,1.8,2,2.7c4.3,5.7,8.7,11.4,13,17.1c0.2,0.3,0.4,0.5,0.6,0.8c-0.4,0.2-0.6,0-0.9-0.1
c-3.1-1-6.3-1.9-9.4-2.9c-0.6-0.2-0.8-0.2-0.7,0.6c0.3,3.6,0.5,7.1,0.7,10.7c0,0.2,0,0.4,0,0.6c-0.3,0.1-0.3-0.1-0.4-0.3
c-6.8-9-13.7-17.9-20.5-26.9c-0.1-0.1-0.2-0.2-0.2-0.4c0-0.1-0.1-0.2-0.2-0.3c-0.5-0.5-0.4-0.7,0.2-0.9c0.5-0.2,1-0.2,1.5-0.3
c1.2-0.2,2.2-0.7,2.8-1.9c0.2-0.3,0.3-0.5,0.6-0.6c1.1,0.6,2.3,0.7,3.5,0.9c2.2,0.4,4.5,0.7,6.7,0.9
C143.2,140.5,143.5,140.5,143.6,140.7z"/>
<path class="st36" d="M127.2,142.6c-0.8,3-1.5,6-2.3,9.1c-2,8-4.1,16-6.2,23.9c-0.1,0.3-0.2,0.6-0.3,1.1c-0.6-1.7-1.1-3.2-1.6-4.6
c-0.7-2.1-1.4-4.2-2.1-6.4c-0.2-0.6-0.4-0.7-0.9-0.3c-2.5,2.1-5,4.2-7.6,6.3c-0.2,0.2-0.4,0.3-0.7,0.5c-0.2-0.3,0-0.6,0.1-0.8
c2-7.7,3.9-15.3,5.9-23c0.1-0.3,0.3-0.6,0.1-0.9c0.1-0.5,0.6-0.6,0.9-0.8c2.9-1.5,5.7-3.2,8.3-5c0.4-0.3,0.7-0.6,0.7-1.2
c0.5-0.1,0.9,0.3,1.1,0.6c0.7,0.9,1.7,0.9,2.6,0.8c0.4,0,0.7-0.1,1.1-0.2C127.2,141.6,127.3,141.7,127.2,142.6z"/>
<path class="st37" d="M121.7,140.6c0.4,0.5,0.2,0.8-0.3,1.2c-3,2-6,3.9-9.2,5.5c-0.2,0.1-0.3,0.2-0.5,0.3c-3.1,1.5-6.2,2.9-9.7,3.4
c-2.8,0.4-5.7,0.6-8.5-0.1c-1.1-0.3-2.3-0.7-3.1-1.6c-0.7-0.7-1.2-1.6-1.2-2.7c0.1-2.9,2-4.1,3.9-5.3c1.7-1.1,3.5-1.7,5.4-2.2
c5-1.4,10-1.2,15.2-0.5c2.4,0.3,4.8,0.7,7.2,1.1C121.4,139.6,121.6,140,121.7,140.6z"/>
<path class="st37" d="M143.6,140.7c-3.4-0.3-6.8-0.8-10.1-1.5c-0.3-0.1-0.7-0.1-0.7-0.6c-0.1-0.7,0-1.2,0.5-1.6
c4.3-2.8,8.6-5.5,13.3-7.4c3.1-1.3,6.3-1.9,9.7-2.1c2-0.1,3.9,0,5.8,0.8c1.3,0.5,2.4,1.2,3.1,2.6c0.7,1.6,0.3,2.9-0.6,4.1
c-1.5,2-3.7,3.1-5.9,4c-4.3,1.7-8.9,2.1-13.5,1.7C144.6,140.8,144.2,140.8,143.6,140.7z"/>
<path class="st38" d="M133.4,137.1c-0.4,0.4-0.3,1-0.5,1.6c-0.2,0.3-0.4,0.5-0.6,0.8c-0.6,1-1.4,1.6-2.5,1.8
c-0.5,0.1-0.9,0.2-1.4,0.3c-0.9,0.2-0.9,0.2-0.5,1.1c-0.2-0.1-0.4-0.6-0.6-0.1c0-0.8-0.4-0.8-1-0.6c-0.6,0.2-1.2,0.3-1.9,0.2
c-0.7-0.1-1.2-0.3-1.7-0.9c-0.2-0.2-0.5-0.7-0.9-0.8c-0.3-0.3-0.4-0.8-0.9-0.9c0.2-0.3,0-0.6,0-0.9c-0.6-2.9-1.2-5.9-1.8-8.9
c-0.2-1-0.5-1.9-0.3-3c0.3-1.9,1.3-3,3-3.4c1.5-0.3,3-0.6,4.5-0.9c1.7-0.3,3.1,0.4,4.1,2c0.4,0.9,0.7,1.9,0.9,3
c0.6,3.1,1.2,6.2,1.8,9.4C133.1,137.1,133.2,137.1,133.4,137.1z"/>`;
const NORMAL_bowtie = `<path class="st6" d="M126.4,101.4l-3.5,5.1c-0.4,0.6-1.2,0.7-1.8,0.4c-1.9-0.9-4.2-1-6.3,0s-3.5,2.8-4,4.9c-0.2,0.7-0.7,1.2-1.5,1.2
l-6.2-0.5l-10.6-0.8c-1.9-0.1-3.2,1.8-2.4,3.5c5.7,4.7,9.1,11.7,9.2,19.2c0.8,1.7,3.2,1.9,4.3,0.3l6-8.8l3.5-5.1
c0.4-0.6,1.2-0.7,1.8-0.4c1.9,0.9,4.2,1,6.3,0s3.5-2.8,4-4.9c0.2-0.7,0.7-1.2,1.5-1.2l6.2,0.5l10.6,0.8c1.9,0.1,3.2-1.8,2.4-3.5
c-5.7-4.7-9.1-11.7-9.2-19.2c-0.8-1.7-3.2-1.9-4.3-0.3L126.4,101.4z"/>`;
const NORMAL_greentie = `<path class="st40" d="M124.3,112.9c0,0,0.1,0.1,0.1,0.2c0.1,0.3,0.2,0.6,0.4,0.9c2,2.9,3.6,5.3,5.2,8.5c1.7,3.3,3.2,6.8,4.5,10.4
c2.5,7,5.5,13.8,7.5,21c0.7,2.5-1.1,5.3-2,7.5c-1.2,2.7-3.2,5.3-4.4,7.6c-0.2,0.3-0.3,0.4-0.6,0.1c-2.5-1.8-10.2-6-12.7-7.8
c-0.2-0.1-0.3-0.3-0.4-0.6c-1.2-5.8-1.6-12-2.2-17.9c-1.1-9.5-0.9-18.6,0.3-28.1c0-0.1,0.1-0.3,0-0.4c0-0.2,0-0.3,0.2-0.3
c0.6-0.1,1.3-0.2,1.9-0.3c0.6-0.2,1.1-0.4,1.7-0.7C123.9,113,124.1,112.8,124.3,112.9z"/>
<path class="st39" d="M119.8,113.2c-0.1,0-0.1,0-0.2,0c-0.8-0.2-1.4-0.6-2-1.1c-0.8-0.6-1.5-1.3-2.2-2c-1.2-1.1-1.2-2.3-1-3.7
c0.1-0.3,0.3-0.4,0.4-0.5c3-1.5,6.1-2.3,9.4-2.4c0.8,0,1.2,0.2,1.6,0.9c0.6,0.9,0.7,1.8,0.4,2.8c-0.3,1-0.6,1.9-1,2.9
c-0.2,0.5-0.5,0.9-0.7,1.3c-0.2,0.3-0.5,0.8-0.8,1c-0.5,0.2-1,0.4-1.5,0.5c-0.4,0.1-0.8,0.2-1.2,0.3
C120.6,113.2,120.2,113.3,119.8,113.2z"/>`;


// overweight
const OVERWEIGHT_pink =`<path class="st5" d="M259,126.7c-3.4-4.6-12.1-4.1-21,0.6c-0.7,0-1.2,0.1-1.2,0.1l-7.6-38.7c0-0.2-0.1-0.3-0.1-0.5
c-10.4-30.2-36.8-50-68.9-49.2c-18.1,0.4-37.1,8.7-47,18.8c-8.3,8.4-23,24.8-30.5,35.1c-4.8-5.3-10.2-7.9-14.3-6.1
c-6.4,2.8-7.2,14.9-1.9,27c0.3,0.8,0.7,1.5,1.1,2.2c1.6,3.1,1.7,6.7,0.4,10c-3.4,8.1-6.6,14.1-9.5,22.3c-3.3,9.4-3.1,9.5-5.8,19.1
c-2.9,10.2-5.4,20.5-7.3,30.9c-1.9,10.3-3.4,20.8-4,31.3c-0.6,9.9-0.4,20,0.9,29.8c1.2,9.1,3.5,18.1,7.4,26.4
c3.7,8,8.8,15.2,15.3,21.1c7.1,6.4,15.7,11,24.8,13.9c3.4,1.1,6.8,1.9,10.3,2.6c1.9,0.4,3.8,0.7,5.6,1c0.1,0,0.2,0,0.3,0.1
c0.1,0.1,0.1,0.2,0.1,0.3c0.6,3.1,1.2,6.3,2.1,9.4c0.9,3,2.1,5.9,3.9,8.5c0,0.1,0.2,0.2,0.2,0.3c2.4,3.2,6.1,5.9,10.3,5
c4.4-0.9,6.2-5.1,7-9.1c0.4-2.1,0.6-4.3,0.8-6.5c0.1-1.5-0.3-5.2,1.5-5.6c0.6-0.1,1.1,0,1.7,0c3.1,0.4,6.1,0.7,9.2,0.9
c2.2,0.1,4.4,0.1,6.7,0.1c1.3,0,2.2,1.4,1.7,2.7c-1.5,3.4-2.6,6.8-2.4,10.6c0.1,3.1,1.2,6.2,4,7.8c5.6,3.2,15.5-3.4,22.1-14.9
c0.5-0.8,0.9-1.6,1.3-2.4c1.1-2.2,3.1-3.8,5.6-4.2c7.4-1.3,15-2.4,21.7-6.2c6.6-3.7,12.6-8.5,17.6-14.1
c9.5-10.5,15.6-23.7,18.4-37.6c7.3-36,3.6-75.5,0.6-111.9c-0.1-1.4,0.6-2.8,1.9-3.5c1.7-0.9,3.5-2.1,5.2-3.3
C257.9,143.2,263.1,132.3,259,126.7z"/>
<path class="st6" d="M149.3,65.5c1.8-2.9,4.9-3.4,6.9-1.3c2,2.1,2.2,6.2,0.4,9c-1.8,2.9-4.9,3.4-6.9,1.3
C147.7,72.4,147.5,68.4,149.3,65.5z"/>
<path class="st6" d="M166,68.1c1.8-2.9,4.9-3.4,6.9-1.3c2,2.1,2.2,6.2,0.4,9c-1.8,2.9-4.9,3.4-6.9,1.3C164.4,75,164.2,70.9,166,68.1
z"/>`;
const OVERWEIGHT_red =`<path class="st7" d="M259,126.7c-3.4-4.6-12.1-4.1-21,0.6c-0.7,0-1.2,0.1-1.2,0.1l-7.6-38.7c0-0.2-0.1-0.3-0.1-0.5
c-10.4-30.2-36.8-50-68.9-49.2c-18.1,0.4-37.1,8.7-47,18.8c-8.3,8.4-23,24.8-30.5,35.1c-4.8-5.3-10.2-7.9-14.3-6.1
c-6.4,2.8-7.2,14.9-1.9,27c0.3,0.8,0.7,1.5,1.1,2.2c1.6,3.1,1.7,6.7,0.4,10c-3.4,8.1-6.6,14.1-9.5,22.3c-3.3,9.4-3.1,9.5-5.8,19.1
c-2.9,10.2-5.4,20.5-7.3,30.9c-1.9,10.3-3.4,20.8-4,31.3c-0.6,9.9-0.4,20,0.9,29.8c1.2,9.1,3.5,18.1,7.4,26.4
c3.7,8,8.8,15.2,15.3,21.1c7.1,6.4,15.7,11,24.8,13.9c3.4,1.1,6.8,1.9,10.3,2.6c1.9,0.4,3.8,0.7,5.6,1c0.1,0,0.2,0,0.3,0.1
c0.1,0.1,0.1,0.2,0.1,0.3c0.6,3.1,1.2,6.3,2.1,9.4c0.9,3,2.1,5.9,3.9,8.5c0,0.1,0.2,0.2,0.2,0.3c2.4,3.2,6.1,5.9,10.3,5
c4.4-0.9,6.2-5.1,7-9.1c0.4-2.1,0.6-4.3,0.8-6.5c0.1-1.5-0.3-5.2,1.5-5.6c0.6-0.1,1.1,0,1.7,0c3.1,0.4,6.1,0.7,9.2,0.9
c2.2,0.1,4.4,0.1,6.7,0.1c1.3,0,2.2,1.4,1.7,2.7c-1.5,3.4-2.6,6.8-2.4,10.6c0.1,3.1,1.2,6.2,4,7.8c5.6,3.2,15.5-3.4,22.1-14.9
c0.5-0.8,0.9-1.6,1.3-2.4c1.1-2.2,3.1-3.8,5.6-4.2c7.4-1.3,15-2.4,21.7-6.2c6.6-3.7,12.6-8.5,17.6-14.1
c9.5-10.5,15.6-23.7,18.4-37.6c7.3-36,3.6-75.5,0.6-111.9c-0.1-1.4,0.6-2.8,1.9-3.5c1.7-0.9,3.5-2.1,5.2-3.3
C257.9,143.2,263.1,132.3,259,126.7z"/>
<path class="st8" d="M149.3,65.5c1.8-2.9,4.9-3.4,6.9-1.3c2,2.1,2.2,6.2,0.4,9c-1.8,2.9-4.9,3.4-6.9,1.3
C147.7,72.4,147.5,68.4,149.3,65.5z"/>
<path class="st8" d="M166,68.1c1.8-2.9,4.9-3.4,6.9-1.3c2,2.1,2.2,6.2,0.4,9c-1.8,2.9-4.9,3.4-6.9,1.3C164.4,75,164.2,70.9,166,68.1
z"/>`;
const OVERWEIGHT_blue =`<path class="st9" d="M259,126.7c-3.4-4.6-12.1-4.1-21,0.6c-0.7,0-1.2,0.1-1.2,0.1l-7.6-38.7c0-0.2-0.1-0.3-0.1-0.5
c-10.4-30.2-36.8-50-68.9-49.2c-18.1,0.4-37.1,8.7-47,18.8c-8.3,8.4-23,24.8-30.5,35.1c-4.8-5.3-10.2-7.9-14.3-6.1
c-6.4,2.8-7.2,14.9-1.9,27c0.3,0.8,0.7,1.5,1.1,2.2c1.6,3.1,1.7,6.7,0.4,10c-3.4,8.1-6.6,14.1-9.5,22.3c-3.3,9.4-3.1,9.5-5.8,19.1
c-2.9,10.2-5.4,20.5-7.3,30.9c-1.9,10.3-3.4,20.8-4,31.3c-0.6,9.9-0.4,20,0.9,29.8c1.2,9.1,3.5,18.1,7.4,26.4
c3.7,8,8.8,15.2,15.3,21.1c7.1,6.4,15.7,11,24.8,13.9c3.4,1.1,6.8,1.9,10.3,2.6c1.9,0.4,3.8,0.7,5.6,1c0.1,0,0.2,0,0.3,0.1
c0.1,0.1,0.1,0.2,0.1,0.3c0.6,3.1,1.2,6.3,2.1,9.4c0.9,3,2.1,5.9,3.9,8.5c0,0.1,0.2,0.2,0.2,0.3c2.4,3.2,6.1,5.9,10.3,5
c4.4-0.9,6.2-5.1,7-9.1c0.4-2.1,0.6-4.3,0.8-6.5c0.1-1.5-0.3-5.2,1.5-5.6c0.6-0.1,1.1,0,1.7,0c3.1,0.4,6.1,0.7,9.2,0.9
c2.2,0.1,4.4,0.1,6.7,0.1c1.3,0,2.2,1.4,1.7,2.7c-1.5,3.4-2.6,6.8-2.4,10.6c0.1,3.1,1.2,6.2,4,7.8c5.6,3.2,15.5-3.4,22.1-14.9
c0.5-0.8,0.9-1.6,1.3-2.4c1.1-2.2,3.1-3.8,5.6-4.2c7.4-1.3,15-2.4,21.7-6.2c6.6-3.7,12.6-8.5,17.6-14.1
c9.5-10.5,15.6-23.7,18.4-37.6c7.3-36,3.6-75.5,0.6-111.9c-0.1-1.4,0.6-2.8,1.9-3.5c1.7-0.9,3.5-2.1,5.2-3.3
C257.9,143.2,263.1,132.3,259,126.7z"/>
<path class="st6" d="M149.3,65.5c1.8-2.9,4.9-3.4,6.9-1.3c2,2.1,2.2,6.2,0.4,9c-1.8,2.9-4.9,3.4-6.9,1.3
C147.7,72.4,147.5,68.4,149.3,65.5z"/>
<path class="st6" d="M166,68.1c1.8-2.9,4.9-3.4,6.9-1.3c2,2.1,2.2,6.2,0.4,9c-1.8,2.9-4.9,3.4-6.9,1.3C164.4,75,164.2,70.9,166,68.1
z"/>`;
const OVERWEIGHT_purple =`<path class="st11" d="M259,126.7c-3.4-4.6-12.1-4.1-21,0.6c-0.7,0-1.2,0.1-1.2,0.1l-7.6-38.7c0-0.2-0.1-0.3-0.1-0.5
c-10.4-30.2-36.8-50-68.9-49.2c-18.1,0.4-37.1,8.7-47,18.8c-8.3,8.4-23,24.8-30.5,35.1c-4.8-5.3-10.2-7.9-14.3-6.1
c-6.4,2.8-7.2,14.9-1.9,27c0.3,0.8,0.7,1.5,1.1,2.2c1.6,3.1,1.7,6.7,0.4,10c-3.4,8.1-6.6,14.1-9.5,22.3c-3.3,9.4-3.1,9.5-5.8,19.1
c-2.9,10.2-5.4,20.5-7.3,30.9c-1.9,10.3-3.4,20.8-4,31.3c-0.6,9.9-0.4,20,0.9,29.8c1.2,9.1,3.5,18.1,7.4,26.4
c3.7,8,8.8,15.2,15.3,21.1c7.1,6.4,15.7,11,24.8,13.9c3.4,1.1,6.8,1.9,10.3,2.6c1.9,0.4,3.8,0.7,5.6,1c0.1,0,0.2,0,0.3,0.1
c0.1,0.1,0.1,0.2,0.1,0.3c0.6,3.1,1.2,6.3,2.1,9.4c0.9,3,2.1,5.9,3.9,8.5c0,0.1,0.2,0.2,0.2,0.3c2.4,3.2,6.1,5.9,10.3,5
c4.4-0.9,6.2-5.1,7-9.1c0.4-2.1,0.6-4.3,0.8-6.5c0.1-1.5-0.3-5.2,1.5-5.6c0.6-0.1,1.1,0,1.7,0c3.1,0.4,6.1,0.7,9.2,0.9
c2.2,0.1,4.4,0.1,6.7,0.1c1.3,0,2.2,1.4,1.7,2.7c-1.5,3.4-2.6,6.8-2.4,10.6c0.1,3.1,1.2,6.2,4,7.8c5.6,3.2,15.5-3.4,22.1-14.9
c0.5-0.8,0.9-1.6,1.3-2.4c1.1-2.2,3.1-3.8,5.6-4.2c7.4-1.3,15-2.4,21.7-6.2c6.6-3.7,12.6-8.5,17.6-14.1
c9.5-10.5,15.6-23.7,18.4-37.6c7.3-36,3.6-75.5,0.6-111.9c-0.1-1.4,0.6-2.8,1.9-3.5c1.7-0.9,3.5-2.1,5.2-3.3
C257.9,143.2,263.1,132.3,259,126.7z"/>
<path class="st10" d="M149.3,65.5c1.8-2.9,4.9-3.4,6.9-1.3c2,2.1,2.2,6.2,0.4,9c-1.8,2.9-4.9,3.4-6.9,1.3
C147.7,72.4,147.5,68.4,149.3,65.5z"/>
<path class="st10" d="M166,68.1c1.8-2.9,4.9-3.4,6.9-1.3c2,2.1,2.2,6.2,0.4,9c-1.8,2.9-4.9,3.4-6.9,1.3
C164.4,75,164.2,70.9,166,68.1z"/>`;
const OVERWEIGHT_lightpurple =`<path class="st10" d="M259,126.7c-3.4-4.6-12.1-4.1-21,0.6c-0.7,0-1.2,0.1-1.2,0.1l-7.6-38.7c0-0.2-0.1-0.3-0.1-0.5
c-10.4-30.2-36.8-50-68.9-49.2c-18.1,0.4-37.1,8.7-47,18.8c-8.3,8.4-23,24.8-30.5,35.1c-4.8-5.3-10.2-7.9-14.3-6.1
c-6.4,2.8-7.2,14.9-1.9,27c0.3,0.8,0.7,1.5,1.1,2.2c1.6,3.1,1.7,6.7,0.4,10c-3.4,8.1-6.6,14.1-9.5,22.3c-3.3,9.4-3.1,9.5-5.8,19.1
c-2.9,10.2-5.4,20.5-7.3,30.9c-1.9,10.3-3.4,20.8-4,31.3c-0.6,9.9-0.4,20,0.9,29.8c1.2,9.1,3.5,18.1,7.4,26.4
c3.7,8,8.8,15.2,15.3,21.1c7.1,6.4,15.7,11,24.8,13.9c3.4,1.1,6.8,1.9,10.3,2.6c1.9,0.4,3.8,0.7,5.6,1c0.1,0,0.2,0,0.3,0.1
c0.1,0.1,0.1,0.2,0.1,0.3c0.6,3.1,1.2,6.3,2.1,9.4c0.9,3,2.1,5.9,3.9,8.5c0,0.1,0.2,0.2,0.2,0.3c2.4,3.2,6.1,5.9,10.3,5
c4.4-0.9,6.2-5.1,7-9.1c0.4-2.1,0.6-4.3,0.8-6.5c0.1-1.5-0.3-5.2,1.5-5.6c0.6-0.1,1.1,0,1.7,0c3.1,0.4,6.1,0.7,9.2,0.9
c2.2,0.1,4.4,0.1,6.7,0.1c1.3,0,2.2,1.4,1.7,2.7c-1.5,3.4-2.6,6.8-2.4,10.6c0.1,3.1,1.2,6.2,4,7.8c5.6,3.2,15.5-3.4,22.1-14.9
c0.5-0.8,0.9-1.6,1.3-2.4c1.1-2.2,3.1-3.8,5.6-4.2c7.4-1.3,15-2.4,21.7-6.2c6.6-3.7,12.6-8.5,17.6-14.1
c9.5-10.5,15.6-23.7,18.4-37.6c7.3-36,3.6-75.5,0.6-111.9c-0.1-1.4,0.6-2.8,1.9-3.5c1.7-0.9,3.5-2.1,5.2-3.3
C257.9,143.2,263.1,132.3,259,126.7z"/>
<path class="st6" d="M149.3,65.5c1.8-2.9,4.9-3.4,6.9-1.3c2,2.1,2.2,6.2,0.4,9c-1.8,2.9-4.9,3.4-6.9,1.3
C147.7,72.4,147.5,68.4,149.3,65.5z"/>
<path class="st6" d="M166,68.1c1.8-2.9,4.9-3.4,6.9-1.3c2,2.1,2.2,6.2,0.4,9c-1.8,2.9-4.9,3.4-6.9,1.3C164.4,75,164.2,70.9,166,68.1
z"/>`;

const OVERWEIGHT_berets = `<path class="st0" d="M185.7,8.5c0,0-2-5,1.9-6c0,0,3.6-1,3.8-1.3c0,0,1.8,0.8,0.3,2.3c0,0-4.3,2.7-3.8,5.4L185.7,8.5z"/>
<path class="st1" d="M217.1,25c-8.7-14.6-29.6-17.9-29.6-17.9s-20.8-4.8-34.2,5.7c0,0-4.7,3.3-3,7.8l4,9.7l27.7,5.4l27.7,5.4
	l7.3-7.7C220.2,29.8,217.1,25,217.1,25z"/>`;
const OVERWEIGHT_orangehat = `<path class="st12" d="M228.2,44.2c0,0,1.7-4.7-4.7-7.8c-8.6-0.5-16.3-2.6-22.7-5.2c-4.1-1.6-7.7-3.5-10.7-5.2
c-5-2.9-8.9-5.8-11.5-7.9c-2.5-0.5-8.1-1-9.4,2.6c0,0-2.3,5.8,7.5,12.5c0,0,15,10.5,40.9,14.8C217.6,48,226.8,48.6,228.2,44.2z"/>
<path class="st13" d="M224.2,33.6l3.1-9.2c0,0,2.1-8.1-4.7-13.5c0,0-10.5-7.5-22.3-9.8c0,0-9.9-1.7-14.4,6.3l-5,9
c2.5,2,6.1,4.6,10.6,7.3C199.1,27.9,210.4,32.9,224.2,33.6z"/>`;
const OVERWEIGHT_fishermenhat = `<path class="st30" d="M185.2,11.5c0.1-0.6,0.7-0.8,1.1-1.1c2.1-1.7,4-3.6,6.2-5.2c4.2-3.1,9.2-4.7,14.8-4.8c4.6-0.1,9,1.1,13.1,3.7
c4.5,2.8,7.8,6.7,10.1,11.2c2.3,4.3,3.4,8.8,3.7,13.3c0.1,1.5,0.3,3.1,0.5,4.6c-0.8,0.2-1.7,0-2.6,0c-3.9,0-7.8-0.2-11.7-0.9
c-4.6-0.8-9.1-2.2-13.5-4.2c-7.1-3.2-13.1-7.8-18.4-13.2c-0.9-0.9-1.6-1.9-2.4-2.9C186,11.7,185.7,11.5,185.2,11.5z"/>
<path class="st31" d="M234.1,37.7c2,3.6,4,7.3,6,11c0.2,0.5,0.5,0.9,0.7,1.4c-0.2,0.2-0.5,0.2-0.7,0.2c-9.4,0.8-18.8,0-28.1-3.3
c-3.6-1.3-7.1-2.7-10.4-4.5c-2.2-1.2-4.4-2.3-6.6-3.6c-7.4-4.3-14.3-9.4-20.1-15.5c-1.4-1.5-2.8-3.1-3.8-4.9
c1.1-0.6,2.4-0.9,3.6-1.2c3.4-1,6.5-2.4,9.4-4.2c0.2,0.4,0,0.7-0.3,1c-0.8,0.8-0.7,1.7-0.2,2.8c1.4,2.6,3.1,4.9,5.3,6.9
c2.7,2.6,5.8,4.8,9,6.8c5,3.1,10.2,5.4,15.7,7.3c4.3,1.5,8.8,2.5,13.3,2.3c2.5-0.1,4.9-0.6,6.7-2.2
C233.7,37.7,233.9,37.6,234.1,37.7z"/>
<path class="st30" d="M171.1,18.5c0.3,0.1,0.5,0.4,0.7,0.7c3.6,4.9,8.1,8.9,13,12.6c2.6,2,5.3,3.8,8.1,5.5c3.7,2.3,7.5,4.4,11.4,6.3
c6.8,3.3,14,5.5,21.4,6.3c4.7,0.5,9.3,0.5,13.8,0.1c0.4,0,0.8,0,1.2,0c0.1,0.2,0.2,0.5,0.3,0.7c0.4,0.9,0.1,1.3-0.9,1.5
c-1.9,0.3-3.7,0.7-5.5,1c-7.2,1.4-14.6,1.7-22.2,0.1c-4-0.8-7.8-2.1-11.5-3.8c-3.1-1.4-6.1-3-9.1-4.8c-7.5-4.5-14.1-9.9-19.4-16.7
c-1.9-2.4-3.1-5-4.7-7.6c-0.2-0.4,0-0.5,0.2-0.7C169,19.2,170,18.7,171.1,18.5z"/>
<path class="st32" d="M234.1,37.7c-1.8,2-4.5,2.5-7.3,2.7c-3.8,0.2-7.7-0.6-11.4-1.8c-8.9-2.8-17.3-6.8-24.6-12.8
c-3.2-2.7-5.9-5.8-7.7-9.4c-0.4-0.8-0.4-1.4,0.1-2.1c0.3-0.4,0.5-0.8,0.8-1.2c0.4-0.5,0.8-1.1,1.1-1.6c0.4-0.4,0.6-0.4,1,0.1
c2.6,3.4,5.7,6.5,9.2,9.2c3.5,2.8,7.3,5.1,11.4,7.1c8.3,3.9,16.8,5.2,25.5,5.1c0.8,0,1.6,0,2.4,0.2
C234.6,34.7,234.3,36.2,234.1,37.7z"/>
<path class="st33" d="M211.1,25.3c-0.7,1.3-2,1.6-3.6,0.7c-1.2-0.7-1.6-2.1-1-3.2c0.6-1.2,2.3-1.5,3.7-0.7
C211.3,22.7,211.7,24.1,211.1,25.3z"/>
<path class="st33" d="M199.1,19.1c0.7-1.5,2-1.3,3.6-0.7c1.1,0.5,1.5,2.1,0.9,3.3c-0.7,1.2-2,1.5-3.4,0.7
C198.8,21.6,198.4,20.4,199.1,19.1z"/>
<path class="st34" d="M210.5,24.9c-0.5,0.9-1.4,1.1-2.4,0.6c-0.9-0.5-1.2-1.5-0.8-2.3c0.5-0.8,1.6-1.1,2.5-0.6
C210.7,23,210.9,24,210.5,24.9z"/>
<path class="st34" d="M203,21.1c-0.5,0.9-1.4,1.1-2.4,0.7c-0.9-0.5-1.3-1.5-0.8-2.3c0.4-0.8,1.6-1.1,2.5-0.6
C203.1,19.3,203.4,20.3,203,21.1z"/>`;
const OVERWEIGHT_gentlemenhat = `<path class="st6" d="M223.5,45.4c0.5-1.8-1.9-2.7-1.9-2.7l-6.2-1.8l5.6-19.7c1.9-6.8-2.9-8.1-2.9-8.1l-21.9-6.2l-21.9-6.2
c0,0-4.8-1.5-6.8,5.4L162,25.7l-6.2-1.8c0,0-2.5-0.6-3,1.3c0,0-0.7,1.5,2,2.3l32.9,9.3l32.9,9.3C223.3,47,223.5,45.4,223.5,45.4z"/>`;
const OVERWEIGHT_greenhat = `<path class="st39" d="M229.6,44.6c0.3-5-10.6-9.7-14-8.1c-6.4,3-39.7-1.7-45.6-14c-16.4-3.3-17.2,4.1-17.2,4.1
c-3.6,16.8,34.1,24,34.1,24C229.8,59.7,229.6,44.6,229.6,44.6z"/>
<path class="st40" d="M214.7,33.1c3.7-23-4.6-24.9-4.6-24.9c-3.4-2.2-8.5,0.5-8.5,0.5c-11.2-8.6-17.3-6.8-17.3-6.8
c-7.3,1.7-11.1,12.2-12.5,17.6C178.8,30.9,204.2,34.6,214.7,33.1z"/>`;

const OVERWEIGHT_scarf = `<path class="st2" d="M66.7,122.4l-13.4,8.5"/>
<path class="st2" d="M57.7,112.1l-13.4,8.5"/>
<path class="st2" d="M73.2,131l-8.7,10"/>
<path class="st2" d="M82.2,135.7L75.7,148"/>
<path class="st3" d="M98.9,66c0,0,70.5,43.4,135.2,37.3c0,0,14.2,3,0,12.5c0,0,13.5,6.7,2.3,13.5c-11.2,6.7-58.8,25.3-151.8-36.8
	c0,0-11.4-18.9,4.5-13C89.2,79.4,81.1,60.5,98.9,66z"/>
<path class="st3" d="M93.5,91.8c0,0-31,2.6-41.3,18.2c0,0,18.5,26.2,34.5,26.7l24.8-31.2L93.5,91.8z"/>`;
const OVERWEIGHT_camera = `<path class="st14" d="M91.4,164.1l68.5,15.3l9-40.4l-68.5-15.3L91.4,164.1z"/>
<path class="st15" d="M154.5,167.5l7.7,1.7l4.5-20.3l-7.7-1.7L154.5,167.5z"/>
<path class="st16" d="M89.2,173.9l68.5,15.3l2.2-10l-68.5-15.3L89.2,173.9z"/>
<path class="st17" d="M150,187.4l7.7,1.7l2.2-10l-7.7-1.7L150,187.4z"/>
<path class="st16" d="M98.1,133.7l68.5,15.3l2.2-10l-68.5-15.3L98.1,133.7z"/>
<path class="st18" d="M93.6,154l7.7,1.7l4.5-20.3l-7.7-1.7L93.6,154z"/>
<path class="st19" d="M89.2,173.9l7.7,1.7l2.2-10l-7.7-1.7L89.2,173.9z"/>
<path class="st20" d="M122.5,128.5c7.5,1.7,16.8,3.8,24.3,5.4l-0.8-5.5c-6.2-1.4-14.3-3.2-20.5-4.6L122.5,128.5z"/>
<path class="st21" d="M154,135.6l8.8,2l0.8-3.5l-8.8-2L154,135.6z"/>
<path class="st21" d="M106.4,125l8.8,2l0.8-3.5l-8.8-2L106.4,125z"/>
<path class="st22" d="M158.1,136.6l0.7,0.2l0.8-3.5l-0.7-0.2L158.1,136.6z"/>
<path class="st22" d="M161.2,137.2l0.7,0.2l0.8-3.5l-0.7-0.2L161.2,137.2z"/>
<path class="st22" d="M159.7,136.9l0.7,0.2l0.8-3.5l-0.7-0.2L159.7,136.9z"/>
<path class="st22" d="M156.6,136.2l0.7,0.2l0.8-3.5l-0.7-0.2L156.6,136.2z"/>
<path class="st22" d="M155.1,135.9l0.7,0.2l0.8-3.5l-0.7-0.2L155.1,135.9z"/>
<path class="st18" d="M105.9,135.4l-0.2,1l53.1,11.8l0.2-1L105.9,135.4L105.9,135.4z"/>
<path class="st23" d="M97.9,134.7l7.7,1.7l0.2-1l-7.7-1.7L97.9,134.7z"/>
<path class="st14" d="M158.8,148.3l7.7,1.7l0.2-1l-7.7-1.7L158.8,148.3z"/>
<path class="st18" d="M101.6,154.7l-0.2,1l53.1,11.8l0.2-1L101.6,154.7L101.6,154.7z"/>
<path class="st23" d="M93.6,154l7.7,1.7l0.2-1l-7.7-1.7L93.6,154z"/>
<path class="st14" d="M154.5,167.5l7.7,1.7l0.2-1l-7.7-1.7L154.5,167.5z"/>
<path class="st21" d="M147.4,155.5c2.2-9.5-3.7-19.1-13.3-21.3c-9.5-2.2-19.1,3.7-21.3,13.3c-2.2,9.5,3.7,19.1,13.3,21.3
	C135.6,171,145.1,165.1,147.4,155.5z"/>
<path class="st24" d="M127.1,165.1c7.5,1.7,14.9-3.1,16.6-10.5c1.7-7.5-3.1-14.9-10.5-16.6c-7.5-1.7-14.9,3.1-16.6,10.5
	C115,155.9,119.6,163.4,127.1,165.1z"/>
<path class="st25" d="M142.9,157.2c0.3-0.8,0.6-1.7,0.8-2.6c1.7-7.5-3-14.9-10.5-16.6c-0.4-0.1-0.8-0.1-1.1-0.2
	c0.4,3.7,1.8,7.9,4.3,11.9C138.3,152.7,140.5,155.2,142.9,157.2z"/>
<path class="st26" d="M129.2,156c2.4,0.5,4.9-1,5.4-3.4c0.5-2.4-1-4.9-3.4-5.4c-2.4-0.5-4.9,1-5.4,3.4
	C125.2,153,126.7,155.3,129.2,156z"/>
<path class="st27" d="M122.6,128.6l6.4,1.4l3-4.6l-6.4-1.4L122.6,128.6z"/>
<path class="st28" d="M168.9,145.1l-0.3,1.5c-0.1,0.2-0.3,0.4-0.5,0.4l-0.9-0.2l-0.3,1.2l1.6,0.4c0.5,0.1,1-0.3,1.1-0.8l0.7-3
	c0.1-0.5-0.2-1.1-0.7-1.2l-1.6-0.4l-0.3,1.3l0.9,0.2C168.9,144.5,169,144.8,168.9,145.1z"/>
<path class="st29" d="M166.3,145.3c24.4-1.2,70.5-17.8,70.5-17.8"/>
<path class="st28" d="M97.5,130.7l0.3-1.5c0.1-0.2,0.3-0.4,0.5-0.4l0.9,0.2l0.3-1.3l-1.6-0.4c-0.5-0.1-1,0.3-1.1,0.8l-0.7,3
	c-0.1,0.5,0.2,1.1,0.7,1.2l1.6,0.4l0.3-1.3l-0.9-0.2C97.5,131.2,97.3,130.9,97.5,130.7z"/>
<path class="st29" d="M83.5,92.4c-2.1,12.5,17.6,39,17.6,39"/>
<path class="st17" d="M159,147.3l7.7,1.7l2.2-10l-7.7-1.7L159,147.3z"/>
<path class="st19" d="M98.1,133.7l7.7,1.7l2.2-10l-7.7-1.7L98.1,133.7z"/>`;
const OVERWEIGHT_bowknot = `<path class="st35" d="M160.1,133.5c1.9-0.7,3.7-1.4,5.6-2.1c5.2-2,10.4-4,15.7-5.9c3.5-1.3,6.9-0.3,9,2.6c1.4,1.9,1.7,4.2,1.5,6.6
c-0.5,5.6-1,11.3-1.5,16.9c0,0.1-0.1,0.2-0.1,0.3c-0.2,0-0.3-0.2-0.3-0.4c-0.3-1.7-1.4-2.8-2.7-3.7c-2-1.4-4.3-2.2-6.7-2.8
c-5.7-1.4-11.4-0.7-17.1,0.3c-1.4,0.3-2.8,0.5-4.3,0.8c-0.3,0.1-0.7,0.2-1.1,0c-0.3-0.3-0.2-0.6-0.1-1c0.5-2.8,1-5.7,1.4-8.5
c0.1-0.8,0.3-1.7,0.3-2.6C159.8,134.1,159.9,133.8,160.1,133.5z"/>
<path class="st35" d="M113.8,139.4c0.6-2.4,1.1-4.7,1.7-7c0.9-3.6,1.8-7.2,2.7-10.7c1.5-5.8,7.8-8.4,12.3-4.8
c3.7,2.9,7.3,6,10.9,9.1c2.2,1.9,4.5,3.8,6.7,5.7c0.1,0.1,0.2,0,0.2,0.1c0.1,0.1,0.1,0.3,0.1,0.4c-1,3.6-1.3,7.3-2,10.9
c-0.1,0.5-0.1,1-0.5,1.4c-0.5,0.2-0.8-0.1-1.2-0.3c-3.7-2.3-7.5-4.3-11.5-6c-4.2-1.7-8.6-2.5-13.1-2.1c-1.7,0.1-3.4,0.5-4.9,1.7
c-0.5,0.4-1,0.8-1.2,1.5C114.1,139.2,114,139.4,113.8,139.4z"/>
<path class="st36" d="M166.7,153.4c0.1,1.1,0.5,2.2,0.9,3.2c2,6.9,4,13.7,6,20.6c0.1,0.3,0.2,0.6,0.2,0.9c-0.4,0.1-0.6-0.2-0.8-0.4
c-2.6-2-5.2-4-7.7-6c-0.5-0.3-0.7-0.4-0.9,0.3c-1,3.4-2.1,6.9-3.1,10.3c-0.1,0.2-0.1,0.4-0.2,0.6c-0.3,0-0.3-0.3-0.3-0.4
c-3.2-10.8-6.3-21.6-9.5-32.4c0-0.1-0.1-0.3-0.1-0.4c0-0.1,0-0.2-0.1-0.3c-0.3-0.7-0.1-0.8,0.5-0.8c0.5,0,1,0.1,1.5,0.2
c1.2,0.3,2.3,0.1,3.3-0.8c0.2-0.2,0.5-0.4,0.8-0.4c0.8,1,1.9,1.4,2.9,2c1.9,1.2,3.9,2.3,6,3.3C166.4,153,166.7,153.2,166.7,153.4z"
/>
<path class="st36" d="M150.7,149.3c-1.8,2.5-3.6,5.1-5.4,7.6c-4.8,6.7-9.6,13.4-14.3,20.1c-0.2,0.2-0.3,0.5-0.6,0.9
c0.1-1.8,0.1-3.3,0.2-4.9c0.1-2.2,0.2-4.5,0.3-6.7c0-0.6-0.1-0.8-0.7-0.6c-3.1,1.1-6.2,2.1-9.3,3.2c-0.3,0.1-0.5,0.2-0.8,0.3
c-0.1-0.4,0.2-0.5,0.3-0.7c4.6-6.5,9.2-12.9,13.7-19.3c0.2-0.3,0.5-0.5,0.4-0.8c0.3-0.5,0.7-0.4,1.1-0.4c3.2-0.4,6.4-0.9,9.6-1.7
c0.5-0.1,0.9-0.4,1.1-0.9c0.5,0.1,0.7,0.6,0.8,0.9c0.4,1.1,1.3,1.4,2.1,1.7c0.3,0.1,0.7,0.1,1.1,0.2
C151.1,148.4,151.1,148.5,150.7,149.3z"/>
<path class="st37" d="M146.3,145.4c0.1,0.6-0.1,0.8-0.7,1c-3.5,0.8-7,1.5-10.6,1.8c-0.2,0-0.4,0.1-0.6,0.1
c-3.4,0.3-6.9,0.4-10.2-0.3c-2.8-0.6-5.5-1.4-7.9-3.1c-1-0.7-1.8-1.5-2.4-2.6c-0.4-0.9-0.6-1.9-0.2-2.9c1.1-2.6,3.3-3.1,5.6-3.6
c2-0.4,3.9-0.3,5.9-0.1c5.1,0.5,9.8,2.5,14.3,4.9c2.1,1.1,4.2,2.4,6.3,3.6C146.3,144.4,146.5,144.8,146.3,145.4z"/>
<path class="st37" d="M166.7,153.4c-3-1.5-6-3.2-8.9-5c-0.3-0.2-0.6-0.3-0.4-0.8c0.1-0.7,0.4-1.1,1.1-1.3c5-1.1,10-2,15-2.1
c3.3-0.1,6.6,0.5,9.7,1.5c1.9,0.6,3.6,1.4,5.2,2.8c1,0.9,1.8,2,1.9,3.5c0.1,1.7-0.8,2.8-2.1,3.6c-2.2,1.4-4.5,1.5-6.9,1.6
c-4.7,0-9-1.3-13.2-3.2C167.6,153.9,167.2,153.7,166.7,153.4z"/>
<path class="st38" d="M158.4,146.4c-0.5,0.3-0.7,0.9-1.1,1.3c-0.3,0.2-0.6,0.4-0.8,0.6c-0.9,0.8-1.9,1-3,0.8
c-0.5-0.1-0.9-0.2-1.4-0.2c-0.9-0.2-0.9-0.2-0.9,0.8c-0.2-0.2-0.1-0.7-0.6-0.3c0.3-0.8-0.1-0.9-0.7-0.9c-0.6,0-1.3-0.2-1.8-0.5
c-0.6-0.3-1-0.7-1.3-1.4c-0.1-0.3-0.3-0.8-0.6-1.1c-0.2-0.4-0.1-0.9-0.5-1.2c0.3-0.2,0.3-0.6,0.3-0.9c0.5-3,1-5.9,1.5-8.9
c0.2-1,0.3-2,0.8-2.9c0.9-1.6,2.3-2.4,4-2.1c1.5,0.2,3.1,0.5,4.6,0.8c1.7,0.3,2.7,1.4,3.1,3.3c0.1,1,0,2.1-0.2,3.1
c-0.6,3.1-1.1,6.3-1.7,9.4C158.2,146.3,158.3,146.3,158.4,146.4z"/>`;
const OVERWEIGHT_bowtie = `<path class="st6" d="M165.2,130.4l-5.9,1.8c-0.7,0.2-1.4-0.2-1.7-0.8c-1-1.9-2.7-3.4-5-3.9c-2.3-0.5-4.5,0.1-6.2,1.4
c-0.6,0.4-1.3,0.5-1.9,0l-4.6-4.2l-7.8-7.3c-1.4-1.3-3.7-0.6-4.1,1.3c1.5,7.3-0.2,14.8-4.8,20.7c-0.4,1.9,1.3,3.5,3.2,2.9l10.2-3.1
l5.9-1.8c0.7-0.2,1.4,0.2,1.7,0.8c1,1.9,2.7,3.4,5,3.9c2.3,0.5,4.5-0.1,6.2-1.4c0.6-0.4,1.3-0.5,1.9,0l4.6,4.2l7.8,7.3
c1.4,1.3,3.7,0.6,4.1-1.3c-1.5-7.3,0.2-14.8,4.8-20.7c0.4-1.9-1.3-3.5-3.2-2.9L165.2,130.4z"/>`;
const OVERWEIGHT_greentie = `<path class="st40" d="M149.8,131.3c0.6,0.2,1.3,0.4,1.9,0.6c0.7,0.2,1.4,0.2,2.1,0.2c0.3,0,0.2,0.1,0.2,0.3c0,0.1,0.1,0.3,0.1,0.4
c2.1,10.5,3.1,20.6,2.7,31.3c-0.3,6.7-0.1,13.6-1,20.2c0,0.3-0.1,0.5-0.4,0.7c-2.6,2.2-11,7.5-13.6,9.7c-0.3,0.3-0.4,0.2-0.7-0.1
c-1.5-2.5-3.9-5.2-5.5-8.1c-1.3-2.3-3.5-5.4-2.9-8.2c1.6-8.2,4.4-16,6.6-24.1c1.1-4.1,2.4-8.1,4.1-12c1.6-3.7,3.1-6.5,5.1-9.9
c0.2-0.3,0.3-0.7,0.4-1c0-0.1,0.1-0.2,0.1-0.2C149.3,131.1,149.6,131.2,149.8,131.3z"/>
<path class="st39" d="M152.9,131.1c-0.5,0-0.9-0.1-1.4-0.2c-0.6-0.1-1.2-0.3-1.7-0.4c-0.4-0.1-0.8-0.6-1-1c-0.3-0.5-0.6-0.9-0.9-1.4
c-0.5-1-1-2.1-1.3-3.1c-0.4-1.1-0.4-2,0.2-3.1c0.5-0.8,0.9-1.1,1.8-1.1c3.7-0.1,7.3,0.5,10.7,1.9c0.2,0.1,0.4,0.1,0.5,0.5
c0.4,1.5,0.4,2.9-0.8,4.2c-0.8,0.8-1.5,1.7-2.3,2.4c-0.6,0.6-1.3,1.1-2.1,1.4c-0.1,0-0.1,0-0.2,0.1
C153.8,131.3,153.3,131.2,152.9,131.1z"/>`;


// obese
const OBESE_pink =`<path class="st5" d="M296.6,206.3c0-24.5-7-49.3-18.9-72.2c-2.9-5.6-1.8-12.7,2.4-17.1c9-9.3,13.2-19.7,9.9-26.8
c-4.2-9-19.2-9.9-35.6-3c-4.5,1.9-9.5,0.8-13.1-2.7C213.7,57.2,179.1,39,145.3,39C71.6,39.1,4.4,133,3.4,214.3
c-0.8,62.1,49.2,78.1,69.8,89.9c5.7,3.2,11.5,9.6,12.3,16.6c0,0,0,0,0,0.1c2.9,17.6,11.8,30.6,24.7,28.9
c10-1.3,17.3-12.8,19.1-27.9c0.4-3.9,3.5-6.7,7-6.6c2.7,0.1,5.4,0.1,8.2,0.1c6.4,0,12.8-0.2,19.2-0.6c3.5-0.3,6.6,2.7,6.9,6.6
c1.6,15.4,9,28.4,19.2,28.6c9.3,0.2,22.4-16.8,24.1-34.8l0.3-2.4c0.4-4.1,3-7.6,6.6-9C262,288.3,296.6,257.3,296.6,206.3z"/>
<path class="st42" d="M95.2,119c14.5-1.2,26.9,4.8,27.6,13.2c0.7,8.4-10.6,16.3-25.1,17.4L84,150.7"/>
<path class="st6" d="M142.2,69.8c2.9-1.5,3.6-5.9,1.6-9.9c-2.1-4-6-6-9-4.5c-2.9,1.5-3.6,5.9-1.6,9.9
C135.3,69.4,139.3,71.4,142.2,69.8z"/>
<path class="st6" d="M160.9,60.3c2.9-1.5,3.6-5.9,1.6-9.9c-2.1-4-6-6-9-4.5c-2.9,1.5-3.6,5.9-1.6,9.9C154,59.8,158,61.8,160.9,60.3
z"/>
<path class="st42" d="M106.7,58.5c0,0,2.6-26.1,23.5-21.4c4,0.9,7.9-0.3,11-2.9c3.8-3.1,10.2-5.9,19.8-1.9"/>`;
const OBESE_red =`<path class="st7" d="M296.6,206.3c0-24.5-7-49.3-18.9-72.2c-2.9-5.6-1.8-12.7,2.4-17.1c9-9.3,13.2-19.7,9.9-26.8
c-4.2-9-19.2-9.9-35.6-3c-4.5,1.9-9.5,0.8-13.1-2.7C213.7,57.2,179.1,39,145.3,39C71.6,39.1,4.4,133,3.4,214.3
c-0.8,62.1,49.2,78.1,69.8,89.9c5.7,3.2,11.5,9.6,12.3,16.6c0,0,0,0,0,0.1c2.9,17.6,11.8,30.6,24.7,28.9c10-1.3,17.3-12.8,19.1-27.9
c0.4-3.9,3.5-6.7,7-6.6c2.7,0.1,5.4,0.1,8.2,0.1c6.4,0,12.8-0.2,19.2-0.6c3.5-0.3,6.6,2.7,6.9,6.6c1.6,15.4,9,28.4,19.2,28.6
c9.3,0.2,22.4-16.8,24.1-34.8l0.3-2.4c0.4-4.1,3-7.6,6.6-9C262,288.3,296.6,257.3,296.6,206.3z"/>
<path class="st42" d="M95.2,119c14.5-1.2,26.9,4.8,27.6,13.2c0.7,8.4-10.6,16.3-25.1,17.4L84,150.7"/>
<path class="st8" d="M142.2,69.8c2.9-1.5,3.6-5.9,1.6-9.9c-2.1-4-6-6-9-4.5c-2.9,1.5-3.6,5.9-1.6,9.9
C135.3,69.4,139.3,71.4,142.2,69.8z"/>
<path class="st8" d="M160.9,60.3c2.9-1.5,3.6-5.9,1.6-9.9c-2.1-4-6-6-9-4.5c-2.9,1.5-3.6,5.9-1.6,9.9C154,59.8,158,61.8,160.9,60.3z
"/>
<path class="st42" d="M106.7,58.5c0,0,2.6-26.1,23.5-21.4c4,0.9,7.9-0.3,11-2.9c3.8-3.1,10.2-5.9,19.8-1.9"/>`;
const OBESE_blue =`<path class="st9" d="M296.6,206.3c0-24.5-7-49.3-18.9-72.2c-2.9-5.6-1.8-12.7,2.4-17.1c9-9.3,13.2-19.7,9.9-26.8
c-4.2-9-19.2-9.9-35.6-3c-4.5,1.9-9.5,0.8-13.1-2.7C213.7,57.2,179.1,39,145.3,39C71.6,39.1,4.4,133,3.4,214.3
c-0.8,62.1,49.2,78.1,69.8,89.9c5.7,3.2,11.5,9.6,12.3,16.6c0,0,0,0,0,0.1c2.9,17.6,11.8,30.6,24.7,28.9c10-1.3,17.3-12.8,19.1-27.9
c0.4-3.9,3.5-6.7,7-6.6c2.7,0.1,5.4,0.1,8.2,0.1c6.4,0,12.8-0.2,19.2-0.6c3.5-0.3,6.6,2.7,6.9,6.6c1.6,15.4,9,28.4,19.2,28.6
c9.3,0.2,22.4-16.8,24.1-34.8l0.3-2.4c0.4-4.1,3-7.6,6.6-9C262,288.3,296.6,257.3,296.6,206.3z"/>
<path class="st42" d="M95.2,119c14.5-1.2,26.9,4.8,27.6,13.2c0.7,8.4-10.6,16.3-25.1,17.4L84,150.7"/>
<path class="st6" d="M142.2,69.8c2.9-1.5,3.6-5.9,1.6-9.9c-2.1-4-6-6-9-4.5c-2.9,1.5-3.6,5.9-1.6,9.9
C135.3,69.4,139.3,71.4,142.2,69.8z"/>
<path class="st6" d="M160.9,60.3c2.9-1.5,3.6-5.9,1.6-9.9c-2.1-4-6-6-9-4.5c-2.9,1.5-3.6,5.9-1.6,9.9C154,59.8,158,61.8,160.9,60.3z
"/>
<path class="st42" d="M106.7,58.5c0,0,2.6-26.1,23.5-21.4c4,0.9,7.9-0.3,11-2.9c3.8-3.1,10.2-5.9,19.8-1.9"/>`;
const OBESE_purple =`<path class="st11" d="M296.6,206.3c0-24.5-7-49.3-18.9-72.2c-2.9-5.6-1.8-12.7,2.4-17.1c9-9.3,13.2-19.7,9.9-26.8
c-4.2-9-19.2-9.9-35.6-3c-4.5,1.9-9.5,0.8-13.1-2.7C213.7,57.2,179.1,39,145.3,39C71.6,39.1,4.4,133,3.4,214.3
c-0.8,62.1,49.2,78.1,69.8,89.9c5.7,3.2,11.5,9.6,12.3,16.6c0,0,0,0,0,0.1c2.9,17.6,11.8,30.6,24.7,28.9c10-1.3,17.3-12.8,19.1-27.9
c0.4-3.9,3.5-6.7,7-6.6c2.7,0.1,5.4,0.1,8.2,0.1c6.4,0,12.8-0.2,19.2-0.6c3.5-0.3,6.6,2.7,6.9,6.6c1.6,15.4,9,28.4,19.2,28.6
c9.3,0.2,22.4-16.8,24.1-34.8l0.3-2.4c0.4-4.1,3-7.6,6.6-9C262,288.3,296.6,257.3,296.6,206.3z"/>
<path class="st42" d="M95.2,119c14.5-1.2,26.9,4.8,27.6,13.2c0.7,8.4-10.6,16.3-25.1,17.4L84,150.7"/>
<path class="st10" d="M142.2,69.8c2.9-1.5,3.6-5.9,1.6-9.9c-2.1-4-6-6-9-4.5c-2.9,1.5-3.6,5.9-1.6,9.9
C135.3,69.4,139.3,71.4,142.2,69.8z"/>
<path class="st10" d="M160.9,60.3c2.9-1.5,3.6-5.9,1.6-9.9c-2.1-4-6-6-9-4.5c-2.9,1.5-3.6,5.9-1.6,9.9C154,59.8,158,61.8,160.9,60.3
z"/>
<path class="st42" d="M106.7,58.5c0,0,2.6-26.1,23.5-21.4c4,0.9,7.9-0.3,11-2.9c3.8-3.1,10.2-5.9,19.8-1.9"/>`;
const OBESE_lightpurple =`<path class="st10" d="M296.6,206.3c0-24.5-7-49.3-18.9-72.2c-2.9-5.6-1.8-12.7,2.4-17.1c9-9.3,13.2-19.7,9.9-26.8
c-4.2-9-19.2-9.9-35.6-3c-4.5,1.9-9.5,0.8-13.1-2.7C213.7,57.2,179.1,39,145.3,39C71.6,39.1,4.4,133,3.4,214.3
c-0.8,62.1,49.2,78.1,69.8,89.9c5.7,3.2,11.5,9.6,12.3,16.6c0,0,0,0,0,0.1c2.9,17.6,11.8,30.6,24.7,28.9c10-1.3,17.3-12.8,19.1-27.9
c0.4-3.9,3.5-6.7,7-6.6c2.7,0.1,5.4,0.1,8.2,0.1c6.4,0,12.8-0.2,19.2-0.6c3.5-0.3,6.6,2.7,6.9,6.6c1.6,15.4,9,28.4,19.2,28.6
c9.3,0.2,22.4-16.8,24.1-34.8l0.3-2.4c0.4-4.1,3-7.6,6.6-9C262,288.3,296.6,257.3,296.6,206.3z"/>
<path class="st42" d="M95.2,119c14.5-1.2,26.9,4.8,27.6,13.2c0.7,8.4-10.6,16.3-25.1,17.4L84,150.7"/>
<path class="st6" d="M142.2,69.8c2.9-1.5,3.6-5.9,1.6-9.9c-2.1-4-6-6-9-4.5c-2.9,1.5-3.6,5.9-1.6,9.9
C135.3,69.4,139.3,71.4,142.2,69.8z"/>
<path class="st6" d="M160.9,60.3c2.9-1.5,3.6-5.9,1.6-9.9c-2.1-4-6-6-9-4.5c-2.9,1.5-3.6,5.9-1.6,9.9C154,59.8,158,61.8,160.9,60.3z
"/>
<path class="st42" d="M106.7,58.5c0,0,2.6-26.1,23.5-21.4c4,0.9,7.9-0.3,11-2.9c3.8-3.1,10.2-5.9,19.8-1.9"/>`;

const OBESE_berets = `<path class="st0" d="M85.1,11.4c0,0-5.2-3.7-1.9-7.2c0,0,3-3.3,3-3.7c0,0,2.3-0.4,1.7,2.1c0,0-2.6,5.4-0.4,7.8L85.1,11.4z"/>
<path class="st1" d="M126.9,8C109-1.1,86,8.9,86,8.9s-23.7,8.4-30.5,27.3c0,0-2.6,6.2,2,9.7l10.1,7.2l31-12.2l31-12.2l2.4-12.3
	C133,10.8,126.9,8,126.9,8z"/>`;
const OBESE_orangehat = `<path class="st12" d="M123.6,20c0,0-2.3-4.5-9.2-2.1c-6.5,6-13.5,10.2-19.9,13.2c-4.1,1.9-8,3.2-11.4,4.2c-5.7,1.6-10.6,2.5-14,2.9
c-2.1,1.5-6.5,5.3-4.7,8.8c0,0,2.6,5.8,14.6,3.3c0,0,18.4-3.7,40-19.9C118.9,30.6,125.8,24.2,123.6,20z"/>
<path class="st13" d="M112.9,15.5l-4.7-8.8c0,0-4.5-7.3-13.4-6.1c0,0-13,2.5-23.1,9.6c0,0-8.3,6.2-5.5,15.1l3.2,10.1
c3.3-0.4,7.8-1.2,12.9-2.7C90.8,30.1,102.6,25.2,112.9,15.5z"/>`;
const OBESE_fishermenhat = `<path class="st30" d="M55.8,39.3c-0.5-0.4-0.3-1.1-0.4-1.6c-0.4-2.8-1-5.5-1.3-8.4c-0.5-5.5,0.8-10.8,3.8-15.9
c2.4-4.2,5.9-7.5,10.4-9.7c5-2.5,10.2-3.3,15.5-3c5.1,0.3,9.7,1.7,13.9,3.9c1.4,0.7,2.9,1.4,4.4,2.1c-0.2,0.9-0.9,1.5-1.4,2.3
c-2.1,3.5-4.4,6.8-7.1,10c-3.2,3.7-6.9,7-11,9.8c-6.7,4.5-14,7.5-21.8,9.2c-1.3,0.3-2.6,0.3-3.8,0.6C56.4,38.7,56.1,38.9,55.8,39.3z
"/>
<path class="st31" d="M105.7,9.8c4.4,0.2,8.7,0.4,13.1,0.6c0.5,0,1.1,0.1,1.6,0.2c0,0.3-0.1,0.5-0.2,0.8
c-4.4,8.9-10.2,16.8-18.2,23.3c-3.1,2.5-6.2,4.8-9.7,6.8c-2.3,1.3-4.5,2.7-6.8,3.9c-7.9,4.3-16.1,7.6-24.8,9.5
c-2.1,0.5-4.3,0.8-6.4,0.8c0-1.3,0.5-2.6,0.8-3.8c0.9-3.6,1.4-7.1,1.4-10.7c0.5,0,0.6,0.4,0.7,0.8c0.3,1.2,1.2,1.6,2.4,1.7
c3,0.2,6-0.2,9-0.9c3.8-1,7.4-2.6,10.9-4.4c5.4-2.8,10.4-6.2,15-10.1c3.7-3.1,7-6.4,9.3-10.6c1.3-2.3,2.1-4.7,1.7-7.2
C105.6,10.2,105.6,10,105.7,9.8z"/>
<path class="st30" d="M54.4,55.7c0.3-0.2,0.7-0.2,1-0.3c6.3-0.5,12.4-2.4,18.4-4.8c3.2-1.2,6.3-2.7,9.3-4.2c4.1-2,8-4.3,11.8-6.8
c6.6-4.3,12.5-9.5,17.3-15.7c3-3.9,5.4-8,7.6-12.3c0.2-0.4,0.5-0.7,0.7-1.1c0.3,0,0.6,0,0.8,0.1c1,0.2,1.2,0.7,0.8,1.6
c-0.7,1.8-1.4,3.6-2.1,5.5c-2.6,7.2-6.4,14-12,19.9c-2.9,3.1-6.1,5.8-9.7,8.2c-3,2-6,3.8-9.2,5.5c-8.1,4.3-16.6,7.2-25.5,8.2
c-3.1,0.4-6.2,0.1-9.3,0.1c-0.5,0-0.5-0.2-0.5-0.6C53.9,57.9,54,56.8,54.4,55.7z"/>
<path class="st32" d="M105.7,9.8c0.8,2.8-0.2,5.4-1.6,8c-1.9,3.5-4.7,6.5-7.8,9.3C89,33.5,80.9,38.8,71.6,42
c-4.1,1.4-8.4,2.1-12.6,1.8c-0.9-0.1-1.5-0.4-1.8-1.2c-0.2-0.5-0.4-0.9-0.7-1.4c-0.3-0.6-0.5-1.3-0.8-1.9c-0.2-0.6,0-0.8,0.7-0.9
c4.5-0.5,8.9-1.6,13.2-3.2c4.4-1.6,8.6-3.7,12.5-6.3c8-5.2,13.8-12.2,18.5-20c0.4-0.7,0.9-1.4,1.5-2C103.3,7.8,104.6,8.8,105.7,9.8z
"/>
<path class="st33" d="M82.2,23.6c0.8,1.4,0.4,2.7-1.3,3.6c-1.2,0.7-2.7,0.3-3.4-0.9c-0.7-1.2-0.1-2.9,1.4-3.7
C80,22,81.5,22.5,82.2,23.6z"/>
<path class="st33" d="M70.1,31c-1-1.4-0.1-2.5,1.3-3.6c1-0.8,2.7-0.2,3.4,1c0.7,1.3,0.3,2.6-1.2,3.4C72.2,32.6,70.9,32.3,70.1,31z"
/>
<path class="st34" d="M81.5,24c0.5,0.9,0.2,1.9-0.7,2.5c-0.9,0.6-2,0.3-2.5-0.6c-0.5-0.9-0.1-2,0.8-2.6C79.9,22.8,81,23.1,81.5,24z"
/>
<path class="st34" d="M74.1,28.7c0.5,0.9,0.2,1.9-0.7,2.5c-0.9,0.5-2,0.3-2.5-0.6c-0.5-0.8-0.1-2,0.8-2.6
C72.5,27.5,73.5,27.8,74.1,28.7z"/>`;
const OBESE_gentlemenhat = `<path class="st6" d="M130.9,19.6c-1-1.6-3.2-0.5-3.2-0.5l-5.5,3.3L111.7,4.8c-3.6-6.1-7.9-3.4-7.9-3.4L84.2,13L64.7,24.7
c0,0-4.4,2.5-0.7,8.6l10.5,17.6l-5.5,3.3c0,0-2.1,1.4-1.1,3c0,0,0.6,1.5,3.1,0.1l29.3-17.5l29.3-17.5
C132,20.9,130.9,19.6,130.9,19.6z"/>`;
const OBESE_greenhat = `<path class="st39" d="M124.6,12.1c-3.1-3.4-13.1,0.6-14.4,3.9C108,22,83.3,40.7,71.4,36.5c-12.9,8.5-8.5,13.9-8.5,13.9
c8.6,13.3,37.8-6.6,37.8-6.6C134.5,21.7,124.6,12.1,124.6,12.1z"/>
<path class="st40" d="M107.4,14.2C94.9-3.1,88.2,1,88.2,1C84.5,1.8,83,6.9,83,6.9C70,8.6,67.3,13.8,67.3,13.8
c-3.7,5.9,0.8,15.2,3.3,19.6C82.6,36.2,101.6,22,107.4,14.2z"/>`;

const OBESE_scarf = `<path class="st41" d="M31.4,142.7L16.6,156"/>
<path class="st41" d="M18.2,131.9L3.4,145.2"/>
<path class="st41" d="M41.2,151.9l-8.7,14.1"/>
<path class="st41" d="M53.3,155.9l-5.5,16.5"/>
<path class="st3" d="M60.1,66.7c0,0,99.8,28.1,175.6-1.4c0,0,18.2-1.3,4.2,15c0,0,18.6,3.5,7.4,15.4c-11.2,11.9-62.1,50.6-195.4,7.7
	c0,0-20.3-18.9,0.9-17.1C52.9,86.2,36.7,66.2,60.1,66.7z"/>
<path class="st3" d="M52,103.3c0,0-31.5,5.7-41.1,27.1c0,0,28.3,28.4,48.1,25.8l24.1-43.7L52,103.3z"/>`;
const OBESE_camera = `<path class="st14" d="M213,110.1l-81.2,5.5l3.2,47.9l81.2-5.5L213,110.1z"/>
<path class="st15" d="M141.7,126.9l-9.1,0.6l1.6,24l9.1-0.6L141.7,126.9z"/>
<path class="st16" d="M216.3,157.7l-81.2,5.5l0.8,11.9l81.2-5.5L216.3,157.7z"/>
<path class="st17" d="M144.2,162.6l-9.1,0.6l0.8,11.9l9.1-0.6L144.2,162.6z"/>
<path class="st16" d="M213,110.1l-81.2,5.5l0.8,11.9l81.2-5.5L213,110.1z"/>
<path class="st18" d="M213.8,122l-9.1,0.6l1.6,24l9.1-0.6L213.8,122z"/>
<path class="st19" d="M216.3,157.7l-9.1,0.6l0.8,11.9l9.1-0.6L216.3,157.7z"/>
<path class="st20" d="M184.2,106c-7.3,0.5-17,1.1-24.3,1.6l-1.9,6.1c8.9-0.6,20-1.3,28.8-1.9L184.2,106z"/>
<path class="st21" d="M149.2,110.2l-10.4,0.7l0.3,4.2l10.4-0.7L149.2,110.2z"/>
<path class="st21" d="M205.6,106.4l-10.4,0.7l0.3,4.2l10.4-0.7L205.6,106.4z"/>
<path class="st22" d="M144.3,110.6l-0.8,0.1l0.3,4.2l0.8-0.1L144.3,110.6z"/>
<path class="st22" d="M140.7,110.8l-0.8,0.1l0.3,4.2l0.8-0.1L140.7,110.8z"/>
<path class="st22" d="M142.5,110.7l-0.8,0.1l0.3,4.2l0.8-0.1L142.5,110.7z"/>
<path class="st22" d="M146.1,110.4l-0.8,0.1l0.3,4.2l0.8-0.1L146.1,110.4z"/>
<path class="st22" d="M147.9,110.3l-0.8,0.1l0.3,4.2l0.8-0.1L147.9,110.3z"/>
<path class="st18" d="M204.8,122.6l-63,4.3l0.1,1.2l62.9-4.2L204.8,122.6L204.8,122.6z"/>
<path class="st23" d="M213.8,122l-9.1,0.6l0.1,1.2l9.1-0.6L213.8,122z"/>
<path class="st14" d="M141.7,126.9l-9.1,0.6l0.1,1.2l9.1-0.6L141.7,126.9z"/>
<path class="st18" d="M206.3,145.5l-63,4.3l0.1,1.2l62.9-4.2L206.3,145.5L206.3,145.5z"/>
<path class="st23" d="M215.4,144.8l-9.1,0.6l0.1,1.2l9.1-0.6L215.4,144.8z"/>
<path class="st14" d="M143.3,149.7l-9.1,0.6l0.1,1.2l9.1-0.6L143.3,149.7z"/>
<path class="st21" d="M175.6,157.3c11.3-0.9,19.8-10.7,18.9-22c-0.9-11.3-10.7-19.8-22-18.9s-19.8,10.7-18.9,22
	C154.5,149.7,164.4,158.1,175.6,157.3z"/>
<path class="st24" d="M190.1,135.7c-0.6-8.8-8.2-15.6-17.1-15c-8.8,0.6-15.6,8.2-15,17.1c0.6,8.8,8.2,15.6,17.1,15
	C184,152.2,190.7,144.5,190.1,135.7z"/>
<path class="st25" d="M167.3,133.6c3.5-4.2,5.9-8.7,7-12.9c-0.4,0-0.8,0-1.3,0c-8.9,0.6-15.6,8.2-15,17.1c0.1,1.1,0.2,2.2,0.5,3.2
	C161.5,139.2,164.6,136.7,167.3,133.6z"/>
<path class="st26" d="M179.3,136.4c-0.2-2.9-2.7-5.1-5.6-4.9s-5.1,2.7-4.9,5.6s2.7,5.1,5.6,4.9C177.3,141.8,179.5,139.3,179.3,136.4
	z"/>
<path class="st27" d="M184.2,106l-7.6,0.5l2.7,5.8l7.5-0.5L184.2,106z"/>
<path class="st28" d="M131.1,121.9l1.1-0.1l-0.1-1.5l-1.9,0.1c-0.6,0-1.1,0.6-1,1.3l0.2,3.5c0,0.6,0.5,1.1,1.2,1.1l1.9-0.1l-0.1-1.5
	l-1.1,0.1c-0.3,0-0.5-0.2-0.5-0.5l-0.1-1.7C130.7,122.2,130.8,121.9,131.1,121.9z"/>
<path class="st43" d="M54.5,87.2c0,0,51.5,30.4,79.2,36.1"/>
<path class="st28" d="M214.8,119.2l-1.1,0.1l0.1,1.5l1.9-0.1c0.6,0,1.1-0.6,1-1.3l-0.2-3.5c0-0.6-0.5-1.1-1.2-1.1l-1.9,0.1l0.1,1.5
	l1.1-0.1c0.3,0,0.5,0.2,0.5,0.5l0.1,1.7C215.3,118.9,215,119.2,214.8,119.2z"/>
<path class="st43" d="M210.9,118.8c0,0,26.6-24.2,26.4-38.9"/>
<path class="st17" d="M140.9,115l-9.1,0.6l0.8,11.9l9.1-0.6L140.9,115z"/>
<path class="st19" d="M213,110.1l-9.1,0.6l0.8,11.9l9.1-0.6L213,110.1z"/>`;
const OBESE_bowknot = `<path class="st35" d="M190.4,107.5c1.3-1.5,2.6-3,3.9-4.5c3.6-4.3,7.2-8.5,10.8-12.8c2.4-2.8,5.9-3.6,9.2-2.1c2.2,1,3.5,2.9,4.5,5.1
c2.3,5.2,4.7,10.3,7,15.5c0,0.1,0.1,0.2,0.1,0.3c-0.2,0.1-0.3,0-0.4-0.2c-1.1-1.4-2.6-1.7-4.1-1.9c-2.5-0.3-4.8,0.2-7.2,0.8
c-5.6,1.6-10.3,4.9-14.8,8.6c-1.1,0.9-2.2,1.8-3.3,2.8c-0.3,0.2-0.5,0.5-0.9,0.5c-0.4-0.1-0.5-0.5-0.6-0.8c-1-2.7-1.9-5.4-2.9-8.2
c-0.3-0.8-0.6-1.6-1-2.4C190.4,108.1,190.3,107.8,190.4,107.5z"/>
<path class="st35" d="M152.7,135.2c-0.6-2.3-1.3-4.6-1.9-7c-0.9-3.6-1.9-7.1-2.8-10.7c-1.5-5.8,2.7-11.1,8.4-10.2
c4.7,0.8,9.3,1.7,14,2.6c2.9,0.5,5.7,1.1,8.6,1.7c0.1,0,0.2,0,0.2,0c0.1,0.1,0.2,0.2,0.3,0.3c0.8,3.6,2.4,7,3.5,10.5
c0.1,0.5,0.4,0.9,0.3,1.5c-0.3,0.4-0.7,0.3-1.2,0.3c-4.3-0.2-8.7-0.1-12.9,0.4c-4.5,0.6-8.7,2-12.5,4.6c-1.4,1-2.7,2.1-3.5,3.8
c-0.2,0.6-0.5,1.2-0.4,1.9C152.9,134.9,153,135.1,152.7,135.2z"/>
<path class="st36" d="M205.8,121.7c0.7,0.9,1.5,1.6,2.3,2.4c5.1,5,10.2,10,15.3,15.1c0.2,0.2,0.4,0.5,0.7,0.7
c-0.3,0.3-0.6,0.1-0.9,0c-3.2-0.5-6.5-1-9.7-1.5c-0.6-0.1-0.8-0.1-0.6,0.7c0.8,3.5,1.5,7,2.3,10.5c0,0.2,0.1,0.4,0.1,0.6
c-0.3,0.1-0.4-0.1-0.5-0.2c-8-7.9-16-15.8-24.1-23.7c-0.1-0.1-0.2-0.2-0.3-0.3c-0.1-0.1-0.2-0.2-0.2-0.3c-0.6-0.5-0.5-0.7,0.1-1
c0.4-0.2,0.9-0.4,1.4-0.5c1.2-0.4,2.1-1,2.5-2.3c0.1-0.3,0.2-0.6,0.5-0.7c1.2,0.5,2.4,0.3,3.5,0.4c2.3,0.1,4.5,0.1,6.8,0
C205.4,121.5,205.7,121.5,205.8,121.7z"/>
<path class="st36" d="M189.8,125.9c-0.3,3.1-0.6,6.2-1,9.3c-0.9,8.2-1.8,16.4-2.7,24.6c0,0.3-0.1,0.6-0.1,1.1
c-0.8-1.6-1.5-3-2.2-4.4c-1-2-2-4-3-6c-0.3-0.6-0.5-0.6-0.9-0.2c-2.2,2.5-4.4,4.9-6.6,7.3c-0.2,0.2-0.4,0.4-0.6,0.6
c-0.3-0.3-0.1-0.6-0.1-0.8c0.9-7.9,1.7-15.7,2.6-23.6c0-0.3,0.2-0.6,0-0.9c0-0.5,0.5-0.7,0.8-0.9c2.6-1.9,5.2-3.9,7.6-6.1
c0.4-0.4,0.6-0.7,0.5-1.3c0.5-0.2,0.9,0.2,1.2,0.4c0.9,0.8,1.8,0.6,2.7,0.4c0.3-0.1,0.7-0.2,1-0.3
C189.7,124.9,189.8,125,189.8,125.9z"/>
<path class="st37" d="M184.1,124.6c0.4,0.5,0.4,0.8-0.1,1.2c-2.7,2.4-5.4,4.7-8.4,6.8c-0.2,0.1-0.3,0.3-0.4,0.4
c-2.9,1.9-5.8,3.7-9.1,4.7c-2.7,0.8-5.5,1.4-8.4,1.1c-1.2-0.1-2.3-0.4-3.3-1.2c-0.8-0.6-1.4-1.4-1.6-2.5c-0.3-2.8,1.4-4.4,3.1-5.9
c1.5-1.3,3.3-2.2,5.1-2.9c4.7-2.1,9.8-2.6,14.9-2.7c2.4-0.1,4.8,0,7.3,0.1C183.7,123.8,183.9,124,184.1,124.6z"/>
<path class="st37" d="M205.8,121.7c-3.4,0.2-6.8,0.1-10.2,0c-0.4,0-0.7,0-0.8-0.5c-0.2-0.6-0.2-1.2,0.3-1.6
c3.8-3.4,7.7-6.6,12.1-9.2c2.9-1.7,6-2.8,9.3-3.4c1.9-0.3,3.9-0.5,5.9-0.1c1.4,0.3,2.6,0.8,3.4,2.1c0.9,1.4,0.7,2.9,0,4.2
c-1.2,2.2-3.2,3.6-5.3,4.8c-4,2.3-8.5,3.3-13.1,3.6C206.8,121.6,206.4,121.7,205.8,121.7z"/>
<path class="st38" d="M195.2,119.6c-0.3,0.5-0.2,1.1-0.3,1.6c-0.2,0.3-0.3,0.6-0.5,0.9c-0.4,1.1-1.2,1.8-2.3,2.1
c-0.5,0.1-0.9,0.3-1.3,0.5c-0.9,0.3-0.9,0.3-0.4,1.1c-0.2-0.1-0.5-0.6-0.6,0c-0.1-0.8-0.5-0.7-1-0.5c-0.6,0.3-1.2,0.4-1.8,0.5
c-0.7,0-1.2-0.1-1.8-0.6c-0.3-0.2-0.6-0.6-1-0.6c-0.3-0.3-0.5-0.7-1-0.8c0.2-0.3-0.1-0.6-0.2-0.9c-1-2.8-2-5.7-3-8.5
c-0.3-0.9-0.7-1.9-0.7-2.9c0-1.9,0.8-3.2,2.5-3.8c1.4-0.5,2.9-1.1,4.4-1.6c1.7-0.6,3.1-0.1,4.3,1.4c0.5,0.9,1,1.8,1.3,2.8
c1,3,2.1,6,3.1,9C194.9,119.6,195,119.6,195.2,119.6z"/>`;
const OBESE_bowtie = `<path class="st6" d="M183.1,107.9l-4.2,4.5c-0.5,0.5-1.3,0.6-1.9,0.1c-1.8-1.2-4-1.6-6.3-0.9c-2.2,0.7-3.8,2.3-4.7,4.3
c-0.3,0.7-0.9,1.1-1.6,0.9l-6.1-1.4l-10.4-2.4c-1.9-0.4-3.5,1.3-2.9,3.1c5,5.5,7.3,13,6.2,20.3c0.6,1.8,2.9,2.3,4.2,0.9l7.2-7.8
l4.2-4.5c0.5-0.5,1.3-0.6,1.9-0.1c1.8,1.2,4,1.6,6.3,0.9c2.2-0.7,3.8-2.3,4.7-4.3c0.3-0.7,0.9-1.1,1.6-0.9l6.1,1.4l10.4,2.4
c1.9,0.4,3.5-1.3,2.9-3.1c-5-5.5-7.3-13-6.2-20.3c-0.6-1.8-2.9-2.3-4.2-0.9L183.1,107.9z"/>`;
const OBESE_greentie = `<path class="st40" d="M173.6,114.1c0.1,0,0.1,0.1,0.1,0.2c0.1,0.3,0.3,0.7,0.5,1c2.2,3.2,4,6,5.8,9.5c2,3.7,3.6,7.7,5,11.6
c2.8,7.8,6.2,15.5,8.4,23.5c0.8,2.8-1.2,6-2.3,8.4c-1.4,3-3.6,5.9-4.9,8.5c-0.2,0.4-0.3,0.4-0.6,0.2c-2.8-2-11.5-6.7-14.3-8.7
c-0.2-0.2-0.4-0.3-0.4-0.6c-1.3-6.5-1.7-13.4-2.5-20c-1.2-10.7-1.1-20.8,0.3-31.4c0-0.1,0.1-0.3,0.1-0.4c0-0.2,0-0.3,0.2-0.4
c0.7-0.1,1.4-0.2,2.1-0.4c0.6-0.2,1.3-0.4,1.9-0.7C173.2,114.1,173.4,114,173.6,114.1z"/>
<path class="st39" d="M168.6,114.4c-0.1,0-0.2,0-0.2,0c-0.9-0.2-1.6-0.7-2.2-1.2c-0.9-0.7-1.6-1.5-2.5-2.3c-1.3-1.2-1.4-2.6-1.1-4.1
c0.1-0.4,0.3-0.4,0.5-0.5c3.3-1.6,6.8-2.6,10.6-2.7c0.9,0,1.3,0.3,1.8,1c0.7,1,0.8,2,0.4,3.1c-0.3,1.1-0.6,2.2-1.1,3.2
c-0.2,0.5-0.5,1-0.8,1.5c-0.2,0.4-0.5,0.9-0.9,1.1c-0.5,0.2-1.2,0.4-1.7,0.6c-0.5,0.1-0.9,0.2-1.4,0.3
C169.5,114.3,169,114.5,168.6,114.4z"/>`;
