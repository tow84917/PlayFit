var video = document.querySelector(".video");
var juice = document.querySelector(".orangeJuice");
var btn = document.getElementById("playPause");

function togglePlayPause() {
if(video.paused){
    btn.className = "pause";
    video.play();
} else {
    btn.className = "play";
    video.pause();
}

}


btn.onclick = function() {
    togglePlayPause();
};

video.addEventListener("timeupdate", function(){
    var juicePos = video.currentTime / video.duration;
    juice.style.width = juicePos * 100 + "%";
});

