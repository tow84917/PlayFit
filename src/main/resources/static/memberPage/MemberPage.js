"use strict"

// 關閉修改表單
function toggleEditProFile(){
    $(".overlay").toggleClass("hidden")
    $(".editForm").toggleClass("showEditForm")
}

// 開啟BTN
$(".editProfile").click(toggleEditProFile);

// 點 X 關閉
$(".close").click(toggleEditProFile);

// 點 ProFile 外關閉
$(".overlay").click(toggleEditProFile);

//  [0] : jqery catch Html
let editForm = $(".editForm")[0];

const key = e => {
    // 藉 clg 找到事件屬性
   	    console.log(e);
    //  包含  contains(屬性)
    if (e.key === 'Escape' && editForm.classList.contains('showEditForm')){
        toggleEditProFile();
    };
  };
document.addEventListener('keydown', key);