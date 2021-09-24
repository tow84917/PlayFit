$(document).ready(function(){
  
  $(".has_children").click(function(){
      $(this).addClass("highlight")
      .children(".ch").show().end()
      
      .siblings().removeClass("highlight")
      .children(".ch").hide(); 
      
  });

$(".item").on("mouseenter mouseleave", function (moveout) { //挷定滑鼠進入及離開事件
  if (moveout.type == "mouseenter") {
    $(this).css({"overflow-y": "scroll"}); //滑鼠進入
  } else {
    $(this).scrollTop(0).css({"overflow-y": "hidden"}); //滑鼠離開
  }
});



	var diarys = document.querySelectorAll("div.diarys");
	
	diarys.forEach(function(diary) {
	  diary.addEventListener("click", function(){ 
		$.ajax({
			url: "/diaryData" + "/" + this.id,
			type: "GET", //send it through POST method
			contentType: "application/json; charset=utf-8",
			dataType: "json",
			success: function(response) {
				console.log(response);
			},
			error: function(xhr, textStatus, error) {
			  alert("fail");
			  console.log(xhr.statusText);
			  console.log(textStatus);
			  console.log(error);
			  }
		 });
	  });
	});






	
	var span = document.getElementsByClassName("close")[0];

	
	var addFoodBtnTemp = document.getElementById("addFoodBtnTemp");
	
  var myFood = document.getElementById("myFood");
	
	var addFoodBtn = document.getElementById("addFoodBtn");
	
	var mealHidden = document.getElementById("mealHidden");
	

	var deleteButtons = document.querySelectorAll("button.deleteClass");
	
	deleteButtons.forEach(function(deleteButton) {
	  deleteButton.addEventListener("click", function(){ 
      let hd = document.createElement("input");
      hd.type = "hidden";
      hd.setAttribute('name', "deleteMealHidden");
      hd.value = this.value;
      insertAfter(myFood, hd);
      this.parentNode.parentNode.removeChild(this.parentNode);
	  });
	});
	
	
	addFoodBtn.onclick = function() {
		let myTimePeriod = document.getElementById("myTimePeriod");
		let myFood = document.getElementById("myFood");
		let el = document.createElement("div");
		let hd = document.createElement("input");
		hd.type = "hidden";
		hd.setAttribute('name', "mealHidden");
		el.innerHTML = myTimePeriod.options[myTimePeriod.selectedIndex].text 
					 + " -- " 
					 + myFood.options[myFood.selectedIndex].text
					 + '  <button type="button" class="removeParent">Delete</button>';	 	
			
		
		hd.value = myTimePeriod.value + ',' + myFood.value;
		insertAfter(myFood, el);
		el.appendChild(hd);
		
		let removeParents = document.querySelectorAll("button.removeParent");
	
		removeParents.forEach(function(removeParent) {
		  removeParent.addEventListener("click", function(){ 
		  	this.parentNode.parentNode.removeChild(this.parentNode);
		  });
		});
	    

	}
	
	
	function insertAfter(referenceNode, newNode) {
	  referenceNode.parentNode.insertBefore(newNode, referenceNode.nextSibling);
	}
    
});