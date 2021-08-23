window.onload = function () {

	
	var fitActivityList = [];
	var fitActivityGrouped = [];
	
    //上一頁按鈕(清單頁)
    var previousSlideBtn = document.getElementsByClassName("fit-button-left");
    //上一頁按鈕點擊事件
    previousSlideBtn[0].addEventListener("click",function(){
        previousSlide();
    });

    //下一頁按鈕(清單頁)
    var nextSlideBtn = document.getElementsByClassName("fit-button-right");
    //下一頁按鈕點擊事件
    nextSlideBtn[0].addEventListener("click",function(){
        nextSlide();
    });





    const f = document.getElementsByClassName("fit-category");
    const fitCategory = f[0];
    
    var currnetPage = 1;
    
	$.ajax({
	    url: "/FitActivities",
	    type: "GET", //send it through POST method
	    contentType: "application/json; charset=utf-8",
	    dataType: "json",
	    success: function(response) {
	      	//Do Something on successful Ajax call	      	
	      	
			$.each(response,function(index, value){

				fitActivityList.push(value);
			    
			}); 	
            
        
            
			fitActivityGrouped = splitIntoGroups(fitActivityList,8);

            console.log(fitActivityGrouped);

            // for(var i=fitActivityGrouped[0].length-1;i>=0;i--){
            //     let newButton = document.createElement("Button");
            //     newButton.className = "fit-name";
            //     newButton.innerText = fitActivityGrouped[0][i].name;
            //     newButton.value = fitActivityGrouped[0][i].id;
            //     newButton.addEventListener("click",function(){
            //     	console.log(fitActivityGrouped);
            //     	alert(this.value);
            //     });
            //     insertAfter(newButton, fitCategory);
            //     console.log(fitActivityGrouped[0][i].id);
            // }

            generateAllFitActivityBtn();
            
	    },
	    error: function(xhr) {
	      alert("fail");
	  	}
	 });
	
	//.ajaxComplete() fires after completion of each AJAX request on your page.
	$( document ).ajaxComplete(function() {
		
	});

	
	//.ajaxStop() fires after completion of all AJAX requests on your page.
	$( document ).ajaxStop(function() {
  		
	});
	
    function splitIntoGroups(a,size){

        var arrays = [];
            
        for (let i = 0; i < a.length; i += size)
        arrays.push(a.slice(i, i + size));

		return arrays;
    }


    var fitNames = document.querySelectorAll("button.fit-name");




    fitNames.forEach(fitName => {
        fitName.addEventListener("click", function() {
            console.log(fitActivityList);
        });
    });

    function insertAfter(newNode, existingNode) {
        existingNode.parentNode.insertBefore(newNode, existingNode.nextSibling);
    }

    function previousSlide(){

        
        if(currnetPage == 1){
            console.log("已是第一頁");
        }else{
            $('.fit-name').remove();
            console.log("刪除");
            currnetPage -= 1;
            generateAllFitActivityBtn();
        }
        console.log(currnetPage + "  " + fitActivityGrouped.length);
    }

    function nextSlide(){
        if(currnetPage == fitActivityGrouped.length){
            console.log("已是最後頁");
        }else{
            $('.fit-name').remove();
            console.log("刪除");
            currnetPage += 1;
            generateAllFitActivityBtn();
        }
        console.log(currnetPage + "  " + fitActivityGrouped.length);
    }

    function generateAllFitActivityBtn(){
        for(var i=fitActivityGrouped[currnetPage-1].length-1;i>=0;i--){
            let newButton = document.createElement("Button");
            newButton.className = "fit-name";
            newButton.innerText = fitActivityGrouped[currnetPage-1][i].name;
            newButton.value = fitActivityGrouped[currnetPage-1][i].id;
            newButton.addEventListener("click",function(){
                alert(this.value);
            });
            insertAfter(newButton, fitCategory);
        }
    }


}



