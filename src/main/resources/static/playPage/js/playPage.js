var video = document.querySelector(".video");
var juice = document.querySelector(".orangeJuice");
var btn = document.getElementById("playPause");

console.log(fitActivityId);


function togglePlayPause() {
if(video.paused){
    btn.className = "pause";
    video.play();
} else {
    btn.className = "play";
    video.pause();
}

}


// var video1 = document.getElementById('video');
// var xhr = new XMLHttpRequest();
// xhr.open('GET', 'http://192.168.1.2:8081/video/stream/mp4/10_min_BLIT', true);
// xhr.responseType = 'arraybuffer';

// xhr.onload = function(e) {
//   var blob = new Blob([xhr.response])
//   var url = URL.createObjectURL(blob);
//   console.log(xhr.response);
//   console.log(url);
//   video1.src = url
// };

// xhr.send();


btn.onclick = function() {
    togglePlayPause();
    

    // $.ajax({
	//     url: "http://192.168.1.2:8081/video/stream",
	//     type: "GET", //send it through POST method
	//     contentType: "text/plain",
	//     success: function(response) {
	// 		console.log(response);
    //     },
	//     error: function(xhr) {

	//   	}
	//  });
};

video.addEventListener("timeupdate", function(){
    var juicePos = video.currentTime / video.duration;
    juice.style.width = juicePos * 100 + "%";
    console.log(video.duration);
});


video.addEventListener("waiting", function(){
    console.log("waiting for video load...");
});

video.addEventListener("seeking", function(){
    console.log("user is seeking");
});

video.addEventListener("ended", function(){
    $.ajax({
	    url: "/videoEnded" + "/" + fitActivityId + "/" + fitAchieveId,
	    type: "GET", //send it through POST method
	    contentType: "text/plain",
	    success: function(response) {
			modal.style.display = "block";
			finishModalContent.style.display = "flex";
			setTimeout(function(){
				window.location.href = '/MemberPage';
			}, 5000);
		
			setTimeout(countDown,1000);
		
			var n = countDownValue.innerText;
			function countDown(){
				n--;
				countDownValue.innerText = n;
				if(n > 0){
					setTimeout(countDown,1000);
				}
			}
        },
	    error: function(xhr, textStatus, error) {
	      alert("fail");
	      console.log(xhr.statusText);
	      console.log(textStatus);
	      console.log(error);
	  	}
	 });
});


// window.onload = function () {
//     $.ajax({
//         url: "/checkSession" + "/" + fitActivityId + "/" + fitAchieveId,
//         type: "GET", //send it through POST method
//         contentType: "application/json;charset=utf-8",
//         success: function(response) {
//         	if(response.status){
//                 modal.style.display = "block";
//         		console.log("之前有正在進行的健身動作");
//         	}else{
//         		console.log("歡迎開始健身");
//         	}
            
//         },
//         error: function(xhr, textStatus, error) {
//           alert("fail");
//           console.log(xhr.statusText);
//           console.log(textStatus);
//           console.log(error);
//           }
//      });
      
// }


// Get the modal
var modal = document.getElementById("myModal");

var countDownValue = document.getElementById("countDown");

// Get the <span> element that closes the modal
var modalCloseBtn = document.getElementsByClassName("welcome-modal-content-bottom-close")[0];

var welcomeModalContent = document.getElementsByClassName("welcome-modal-content")[0];

var finishModalContent = document.getElementsByClassName("finish")[0];

var html = document.getElementsByTagName('html')[0];

// When the user clicks on <span> (x), close the modal
modalCloseBtn.onclick = function() {
	modal.style.display = "none";
	welcomeModalContent.parentNode.removeChild(welcomeModalContent);
	html.style.overflow = "visible";
  }
// When the user clicks anywhere outside of the modal, close it
// window.onclick = function(event) {
// 	if (event.target == modal) {
// 	  modal.style.display = "none";
// 	}
//   }