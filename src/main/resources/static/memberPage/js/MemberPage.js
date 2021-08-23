"use strict"

let showStatus = sessionStorage.showStatus;

// 初始化位置
function doFirst() {
	if (!showStatus) {
		sessionStorage.showStatus = "hide";
		$(".overlay").addClass("hidden");
		$(".editGoal").removeClass("showEditForm")
	} else {
		if (showStatus == "show") {
			$(".overlay").removeClass("hidden");
			$(".editGoal").addClass("showEditForm")
		}
		if (showStatus == "hide") {
			$(".overlay").addClass("hidden");
			$(".editGoal").removeClass("showEditForm")
		}
	}
	
}

// 記住顯示狀態
function changeStatus() {
	if (sessionStorage.showStatus == "hide") {
		sessionStorage.showStatus = "show";
	} else {
		sessionStorage.showStatus = "hide";
	}
}

// 關閉修改表單
function toggleEditGoal() {
	$(".overlay").toggleClass("hidden")
	$(".editGoal").toggleClass("showEditForm")

	changeStatus();
}

// 開啟BTN
$(".addPersonGoal").click(()=>{
	toggleEditGoal();
	$(".resultMessage").addClass("hidden"); // 第一次顯示必定無訊息
	});

// 點 X 關閉
$(".close").click(toggleEditGoal);

// 點 ProFile 外關閉
$(".overlay").click(toggleEditGoal);

//  [0] : jqery catch Html
let editGoal = $(".editGoal")[0];

// 點 ESC 關閉
const key = e => {
	// 藉 clg 找到事件屬性
	//console.log(e);
	//  包含  contains(屬性)
	if (e.key === 'Escape' && editGoal.classList.contains('showEditForm')) {
		toggleEditGoal();
	};
};
document.addEventListener('keydown', key);

// 初始化
window.addEventListener('load', doFirst);













