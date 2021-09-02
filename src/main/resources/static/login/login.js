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


    let step2 = document.getElementById('step2');
    let signUpSubmit = document.getElementById('signUpSubmit');
    signUpSubmit.addEventListener('click',e =>{
        step2.style.display = 'inline';
        // When the user clicks anywhere outside of the modal, close it
    //     window.onclick = function(event) {
    //     if (event.target == window) {
    //         step2.style.display = "none";
    //     }
    // }
    })
}





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