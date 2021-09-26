$(document).ready(function(){
  
  $(".has_children").click(function(){
      $(this).addClass("highlight")
      .children(".ch").show().end()
      
      .siblings().removeClass("highlight")
      .children(".ch").hide(); 
      
  });




	var oldDiaryModal = document.getElementById("oldModal");

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
				
				$("#oldModal div form .modal-content .modal-body .form__input").val(response.dailyRecord.title);
				$("#oldModal div form .modal-content .modal-body .diary__input").val(response.dailyRecord.content);
				$("#oldModal div form .modal-content .modal-body #date").val(response.dailyRecord.createdDate);
				console.log(response.dailyRecord.title);


				$("#activity-color .activity").empty();
				response.fitAchieves.forEach(function(fitAchieve){
					if(fitAchieve.status != "未執行"){


						  $('<img>').attr({
							id: 'cmopletedPic' + fitAchieve.id,
							src: "/images/finishl.svg"
						  }).appendTo('#activity-color .activity');

						  $('<img>').attr({
							id: 'activityPic' + fitAchieve.id,
							src: fitAchieve.fitActivity.imagePath
						  }).appendTo('#activity-color .activity');


						  $('<p>').attr({
							id: 'activityName' + fitAchieve.id,
							style: "padding-bottom: 10px;"
						  }).text(fitAchieve.fitActivity.name).appendTo('#activity-color .activity');
						  console.log(fitAchieve.fitActivity.name)
					}
				});


				$("#old-diary-meal .meal-container").empty();	
				let oldMealConstainer = $("#old-diary-meal .meal-container")
				
				response.meals.forEach(function(meal){
					let div = document.createElement('div');
					$(div).text(meal.timePeriod.name + "--" + meal.food.name+ "--" + meal.food.kcal + " cal")
						.appendTo('#old-diary-meal .meal-container');

					let btn = $('<button>').attr({
						type: 'button',
						class: 'deleteClass',
						value: meal.id
					}).text('Delete')
						.appendTo(div);

					$(btn).click(function(){
						console.log(oldMealConstainer);
						let hd = document.createElement("input");
						hd.type = "hidden";
						hd.setAttribute('name', "deleteMealHidden");
						hd.value = this.value;
						$(hd).appendTo(oldMealConstainer);
						this.parentNode.parentNode.removeChild(this.parentNode);
					});
					// $('<div>').attr({
					//   }).text(meal.timePeriod.name + "--" + meal.food.name+ "--" + meal.food.kcal + " cal")
					//   .appendTo('#old-diary-meal .meal-container');
				});


			},
			error: function(xhr, textStatus, error) {
			  alert("fail");
			  console.log(xhr.statusText);
			  console.log(textStatus);
			  console.log(error);
			  }
		 });
		 $("#oldModal div form").attr('action', '/processDiaryUpdate/' + this.id);
	  });
	});


	// var addFoodBtnForOldDiary = $("#old-diary-meal #addFoodBtn").get();
	// addFoodBtnForOldDiary[0].addEventListener("click", function(){
	// 	alert(" ");
	// });

	
	var span = document.getElementsByClassName("close")[0];

	
	var addFoodBtnTemp = document.getElementById("addFoodBtnTemp");
	
  var myFood = document.getElementById("myFood");
	
	var addFoodBtns = document.querySelectorAll(".food-plus");
	
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
	
	addFoodBtns.forEach(function(addFoodBtn){
		addFoodBtn.addEventListener("click", function(){
			let myTimePeriod = document.getElementById("myTimePeriod");
			// let myFood = document.getElementById("myFood");
			let myFood = this.nextElementSibling;
			let el = document.createElement("div");
			let hd = document.createElement("input");
			hd.type = "hidden";
			hd.setAttribute('name', "mealHidden");
			el.innerHTML = myTimePeriod.options[myTimePeriod.selectedIndex].text 
						 + " -- " 
						 + myFood.options[myFood.selectedIndex].text
						 + '  <button type="button" class="removeParent">Delete</button>';	 	
				
			
			hd.value = myTimePeriod.value + ',' + myFood.value;
			// insertAfter(myFood, el);
			myFood.nextElementSibling.prepend(el);
			el.appendChild(hd);
			
			let removeParents = document.querySelectorAll("button.removeParent");
		
			removeParents.forEach(function(removeParent) {
			  removeParent.addEventListener("click", function(){ 
				  this.parentNode.parentNode.removeChild(this.parentNode);
			  });
			});
		});
	});


	// addFoodBtn.onclick = function() {
	// 	let myTimePeriod = document.getElementById("myTimePeriod");
	// 	let myFood = document.getElementById("myFood");
	// 	let el = document.createElement("div");
	// 	let hd = document.createElement("input");
	// 	hd.type = "hidden";
	// 	hd.setAttribute('name', "mealHidden");
	// 	el.innerHTML = myTimePeriod.options[myTimePeriod.selectedIndex].text 
	// 				 + " -- " 
	// 				 + myFood.options[myFood.selectedIndex].text
	// 				 + '  <button type="button" class="removeParent">Delete</button>';	 	
			
		
	// 	hd.value = myTimePeriod.value + ',' + myFood.value;
	// 	insertAfter(myFood, el);
	// 	el.appendChild(hd);
		
	// 	let removeParents = document.querySelectorAll("button.removeParent");
	
	// 	removeParents.forEach(function(removeParent) {
	// 	  removeParent.addEventListener("click", function(){ 
	// 	  	this.parentNode.parentNode.removeChild(this.parentNode);
	// 	  });
	// 	});
	    

	// }
	
	
	function insertAfter(referenceNode, newNode) {
	  referenceNode.parentNode.insertBefore(newNode, referenceNode.nextSibling);
	}
    
});