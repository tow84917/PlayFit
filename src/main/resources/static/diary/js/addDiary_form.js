window.onload = function () {
	
	var modal = document.getElementById("myModal");
	
	var span = document.getElementsByClassName("close")[0];
	
	// Get the button that opens the modal
	var select = document.getElementById("mySelect");
	
	var addFoodBtnTemp = document.getElementById("addFoodBtnTemp");
	
	
	var addFoodBtn = document.getElementById("addFoodBtn");
	
	var mealHidden = document.getElementById("mealHidden");
	

	var deleteButtons = document.querySelectorAll("button.deleteClass");
	
	deleteButtons.forEach(function(deleteButton) {
	  deleteButton.addEventListener("click", function(){ 
	  	let hd = document.createElement("input");
		hd.type = "hidden";
		hd.setAttribute('name', "deleteMealHidden");
		hd.value = this.value;
	  	insertAfter(addFoodBtnTemp, hd);
	  	this.parentNode.parentNode.removeChild(this.parentNode);
	  });
	});
	
	addFoodBtnTemp.onclick = function() {
	  modal.style.display = "block";
	}
	
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
		insertAfter(addFoodBtnTemp, el);
		el.appendChild(hd);
		
		let removeParents = document.querySelectorAll("button.removeParent");
	
		removeParents.forEach(function(removeParent) {
		  removeParent.addEventListener("click", function(){ 
		  	this.parentNode.parentNode.removeChild(this.parentNode);
		  });
		});
		
		modal.style.display = "none";
		
		var p = myTimePeriod.options[myTimePeriod.selectedIndex].text;
		var f = myFood.options[myFood.selectedIndex].text;
		var json = { "timePeriod" : p , "food" : f };
		
	    let token = $("meta[name='_csrf']").attr("content");
	    let header = $("meta[name='_csrf_header']").attr("content");
	    $(document).ajaxSend(function(e, xhr, options) {
	        xhr.setRequestHeader(header, token);
	    });
	    
//		$.ajax({
//		    url: "/jsTest",
//		    type: "POST", //send it through POST method
//		    data: JSON.stringify(json),
//		    contentType: "application/json; charset=utf-8",
//		    dataType: "json",
//		    success: function(response) {
//		    	alert("success"); 
//		      	//Do Something on successful Ajax call
//		     	var respContent ="";
//		     	respContent += "<span class='success'>Was created: [";
//           	 	respContent += response.timePeriod + " : ";
//            	respContent += response.food + "]</span>";
//            	$("#sFromResponse").html(respContent);  
//		    },
//		    error: function(xhr) {
//		      alert("fail");
//		  	}
//		 });

	}
	
	function removeParent(){
		alert(this.value);
	}
	
	// When the user clicks on <span> (x), close the modal
	span.onclick = function() {
	  modal.style.display = "none";
	}
	
	// When the user clicks anywhere outside of the modal, close it
	window.onclick = function(event) {
	  if (event.target == modal) {
	    modal.style.display = "none";
	  }
	}
	
	function insertAfter(referenceNode, newNode) {
	  referenceNode.parentNode.insertBefore(newNode, referenceNode.nextSibling);
	}
	
	
	
	
	

}