"use strict"

// 關閉修改表單
function toggleEditGoal(){
    $(".overlay").toggleClass("hidden")
    $(".editGoal").toggleClass("showEditForm")
}

// 開啟BTN
$(".addPersonGoal").click(toggleEditGoal);

// 點 X 關閉
$(".close").click(toggleEditGoal);

// 點 ProFile 外關閉
$(".overlay").click(toggleEditGoal);

//  [0] : jqery catch Html
let editGoal = $(".editGoal")[0];

const key = e => {
    // 藉 clg 找到事件屬性
   	    console.log(e);
    //  包含  contains(屬性)
    if (e.key === 'Escape' && editGoal.classList.contains('showEditForm')){
        toggleEditGoal();
    };
  };
document.addEventListener('keydown', key);