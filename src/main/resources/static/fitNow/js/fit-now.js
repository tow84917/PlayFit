window.onload = function () {

	var role = document.getElementById("role").getAttribute('data');
	
	console.log(role);

	//全部的fitActivity
	var fitActivityList = [];
    //全部的fitActivity 但是存成二維陣列 [Array(8), Array(8)]
	var fitActivityGrouped = [];
    //只存部位為Upper的fitActivity
	var upperFitActivity = [];
    //只存部位為Core的fitActivity
    var coreFitActivity = [];
    //只存部位為Lower的fitActivity
    var lowerFitActivity = [];
    //只存部位為HIIT的fitActivity
    var HIITFitActivity = [];

    var upperPartPoint = document.getElementById("upperPartPoint");
    upperPartPoint.addEventListener("click",function(){
        if(currentPart == "UPPER"){
            this.style.backgroundColor = "";
            currentPart = "ALL TRAINING";
            fitCategory.innerHTML = currentPart;
            generateAllFitActivityBtn();
        }else{
            corePartPoint.style.backgroundColor = '';
            HIITPartPoint.style.backgroundColor = '';
            lowerPartPoint.style.backgroundColor = '';
            this.style.backgroundColor = 'rgb(' + 255 + ',' + 53 + ',' + 59 + ')';
            $('.fit-name').remove();
            currentPart = 1
            currentPart = "UPPER";
            fitCategory.innerHTML = currentPart;
            generateFitActivityBtnByBodyPartActivity(upperFitActivity);
            console.log("刪除");
        }

    });

    var corePartPoint = document.getElementById("corePartPoint");
    corePartPoint.addEventListener("click",function(){
        if(currentPart == "CORE"){
            this.style.backgroundColor = "";
            currentPart = "ALL TRAINING";
            fitCategory.innerHTML = currentPart;
            generateAllFitActivityBtn();
        }else{
            upperPartPoint.style.backgroundColor = '';
            HIITPartPoint.style.backgroundColor = '';
            lowerPartPoint.style.backgroundColor = '';
            this.style.backgroundColor = 'rgb(' + 255 + ',' + 53 + ',' + 59 + ')';
            $('.fit-name').remove();
            currentPage = 1
            currentPart = "CORE";
            fitCategory.innerHTML = currentPart;
            generateFitActivityBtnByBodyPartActivity(coreFitActivity);
            console.log("刪除");
        }
    });
    
    var HIITPartPoint = document.getElementById("HIITPartPoint");
    HIITPartPoint.addEventListener("click",function(){
        if(currentPart == "HIIT"){
            this.style.backgroundColor = "";
            currentPart = "ALL TRAINING";
            fitCategory.innerHTML = currentPart;
            generateAllFitActivityBtn();
        }else{
            upperPartPoint.style.backgroundColor = '';
            corePartPoint.style.backgroundColor = '';
            lowerPartPoint.style.backgroundColor = '';
            this.style.backgroundColor = 'rgb(' + 255 + ',' + 53 + ',' + 59 + ')';
            $('.fit-name').remove();
            currentPage = 1
            currentPart = "HIIT";
            fitCategory.innerHTML = currentPart;
            generateFitActivityBtnByBodyPartActivity(HIITFitActivity);
            console.log("刪除");
        }
    });

    var lowerPartPoint = document.getElementById("lowerPartPoint");
    lowerPartPoint.addEventListener("click",function(){
        if(currentPart == "LOWER"){
            this.style.backgroundColor = "";
            currentPart = "ALL TRAINING";
            fitCategory.innerHTML = currentPart;
            generateAllFitActivityBtn();
        }else{
            upperPartPoint.style.backgroundColor = '';
            corePartPoint.style.backgroundColor = '';
            HIITPartPoint.style.backgroundColor = '';
            this.style.backgroundColor = 'rgb(' + 255 + ',' + 53 + ',' + 59 + ')';
            $('.fit-name').remove();
            currentPage = 1
            currentPart = "LOWER";
            fitCategory.innerHTML = currentPart;
            generateFitActivityBtnByBodyPartActivity(lowerFitActivity);
            console.log("刪除");
        }
    });

    //上一頁按鈕(清單頁)    
    var previousSlideBtn = document.getElementById("svg-arrow-left");
    //上一頁按鈕點擊事件
    previousSlideBtn.addEventListener("click",function(){
        if(currentPart == "ALL TRAINING") previousSlide();
    });
    //下一頁按鈕(清單頁)
    var nextSlideBtn = document.getElementById("svg-arrow-right");
    //下一頁按鈕點擊事件
    nextSlideBtn.addEventListener("click",function(){
        if(currentPart == "ALL TRAINING") nextSlide();
    });




    const f = document.getElementsByClassName("fit-category");
    const fitCategory = f[0];
    
    var currentPage = 1;
    var currentPart = "ALL TRAINING";
    
	$.ajax({
	    url: "/FitActivities",
	    type: "GET", //send it through POST method
	    contentType: "application/json; charset=utf-8",
	    dataType: "json",
	    success: function(response) {
	      	//Do Something on successful Ajax call	      	
	      	console.log(response);
			$.each(response,function(index, value){

                //fitActivityList裝全部的健身項目
				fitActivityList.push(value);
                //以下在個別以健身部位做分類
			    switch (value.bodyPart) {
                    case 'Upper':
                        upperFitActivity.push(value);
                        break;
                    case 'Core':
                        coreFitActivity.push(value);
                        break;
                    case 'Lower':
                        lowerFitActivity.push(value);
                        break;
                    case 'HIIT':
                        HIITFitActivity.push(value);
                        break;
                    default:
                        console.log(`Sorry, we are out of ${value.bodyPart}.`);
                  }
			}); 	
            
        
            //全部的fitActivity 但是存成二維陣列 [Array(8), Array(8)]
			fitActivityGrouped = splitIntoGroups(fitActivityList,8);

            console.log(fitActivityGrouped);

            console.log(upperFitActivity);
            console.log(coreFitActivity);
            console.log(lowerFitActivity);
            console.log(HIITFitActivity);

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
	
    //把陣列a[]以size分組
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
            
            //window.location.href=""
        });
    });

    function insertAfter(newNode, existingNode) {
        existingNode.parentNode.insertBefore(newNode, existingNode.nextSibling);
    }

    function previousSlide(){

        
        if(currentPage == 1){
            console.log("已是第一頁");
        }else{
            $('.fit-name').remove();
            console.log("刪除");
            currentPage -= 1;
            generateAllFitActivityBtn();
        }
        console.log(currentPage + "  " + fitActivityGrouped.length);
    }

    function nextSlide(){
        if(currentPage == fitActivityGrouped.length){
            console.log("已是最後頁");
        }else{
            $('.fit-name').remove();
            console.log("刪除");
            currentPage += 1;
            generateAllFitActivityBtn();
        }
        console.log(currentPage + "  " + fitActivityGrouped.length);
    }

    
    function generateAllFitActivityBtn(){
        $('.fit-name').remove();
        for(var i=fitActivityGrouped[currentPage-1].length-1;i>=0;i--){
            let newButton = document.createElement("Button");
            newButton.className = "fit-name";
            newButton.innerText = fitActivityGrouped[currentPage-1][i].name;
            newButton.value = fitActivityGrouped[currentPage-1][i].id;

            if(fitActivityGrouped[currentPage-1][i].role == true && role == "ROLE_NORMAL"){
                newButton.style.backgroundColor = "rgba(0, 0, 0, 0.1)";
                newButton.style.color = "rgba(255, 255, 255, 0.1)";
                newButton.addEventListener("click",function(){
                    //alert(this.value);
                    window.location.href="/pay";
                    console.log(contextPath);
                });
            }else{
                newButton.addEventListener("click",function(){
                    //alert(this.value);
                    window.location.href="/fit-activity/" + this.value + "/" + this.innerText;
                    console.log(contextPath);
                });
            }
            insertAfter(newButton, fitCategory);
        }
    }

    function generateFitActivityBtnByBodyPartActivity(bodyPartFitActivity){
        for(var i=bodyPartFitActivity.length-1;i>=0;i--){
            let newButton = document.createElement("Button");
            newButton.className = "fit-name";
            newButton.innerText = bodyPartFitActivity[i].name;
            newButton.value = bodyPartFitActivity[i].id;



            if(fitActivityGrouped[currentPage-1][i].role == true && role == "ROLE_NORMAL"){
                newButton.style.backgroundColor = "rgba(0, 0, 0, 0.1)";
                newButton.style.color = "rgba(255, 255, 255, 0.1)";
                newButton.addEventListener("click",function(){
                    //alert(this.value);
                    window.location.href="/pay";
                    console.log(contextPath);
                });
            }else{
                newButton.addEventListener("click",function(){
                    //alert(this.value);
                    window.location.href="/fit-activity/" + this.value + "/" + this.innerText;
                    console.log(contextPath);
                });
            }
            insertAfter(newButton, fitCategory);
        }
    }


}



