   // 403 錯誤
   var token = $("meta[name='_csrf']").attr("content");
   var header = $("meta[name='_csrf_header']").attr("content");
   $(document).ajaxSend(function (e, xhr, options) {
       xhr.setRequestHeader(header, token);
   });
   // 403 錯誤
    // count = [[${ count }]];
   function dofirst() {
       // 所有訂單數
        onePageItems = 2;
       console.log('count: ', count);

       if (count <= 2) {
           pageTotal = 1;
       }else{
           pageTotal = parseInt(count / onePageItems);
       }
    //    pageTotal = 3;
       currentPage = 1;
       const item = document.querySelector('.item');
       for (let i = 1; i <= pageTotal; i++) {
           let pageCount = document.createElement('li');
           if (i == 1) {
               pageCount.setAttribute('class', 'page-item page-li active');
           } else {
               pageCount.setAttribute('class', 'page-item page-li');
           }
           pageCount.setAttribute('value', i);
           pageCount.setAttribute('id', i);

           let pageA = document.createElement('a');
           pageA.setAttribute('class', 'page-link page-del');
           pageA.innerText = i;

           pageCount.appendChild(pageA);

           item.appendChild(pageCount);
       }

       console.log('currentPage: ', currentPage);
       findCurrentPage(onePageItems, currentPage);

 
   }
   window.addEventListener('load', dofirst());




   const page = document.getElementById('page');
   console.log('page: ', page);
   page.addEventListener('click', (e) => {
       console.log('e.target: ', e.target.localName);
       console.log('e.target: ', e.target.id);  // a svg paht

       if (e.target.id == 'Next' || e.target.id == 'Previous') {
           // let pageItem = e.target.parentNode.parentNode;
           // console.log('pageItem: ', pageItem);
           deleActive();
           if (e.target.id == 'Next') {
               if (currentPage < pageTotal) {
                   currentPage++;
               }

           } else if (e.target.id == 'Previous') {
               if (currentPage > 1) {
                   currentPage--;
               }
           }
           console.log('currentPage: ', currentPage);

           let newPage = document.getElementById(currentPage);
           newPage.setAttribute('class', 'page-item page-li active');

       } else {

           deleActive();

           let pageNum = e.target.parentNode;
           console.log('pageNum: ', pageNum);
           console.log('pageNum.value', pageNum.value);
           currentPage = pageNum.value;
           // 增加選中的 active
           pageNum.setAttribute('class', 'page-item page-li active');

           console.log('currentPage: ', currentPage);
       }


       console.log('currentPage: ', currentPage);
       findCurrentPage(onePageItems, currentPage);
   })

   function findCurrentPage(onePageItems, currentPage) {
       $(".sub1").empty();
       $.ajax({
           url: "findCurrentPage",
           type: "POST",
           async: true,
           contentType: "application/json; charset=utf-8",
           dataType: "json",
           data: JSON.stringify({ "onePageItems": onePageItems, "currentPage": currentPage }),
           // data: json,
           success: function (data) {
               console.log('data: ', data);
               for (let i = 0; i < data.length; i++) {
                   const renMsg = data[i];
                   console.log('-----renMsg: ', renMsg);

                   let myCol = document.createElement('div');
                   myCol.setAttribute('class', 'col-6 my-col');

                   let myRow = document.createElement('div');
                   const items = 'item-' + i;
                   myRow.setAttribute('class', 'div my-row ' + items);

                   myCol.appendChild(myRow);

                   const orderNumber = document.createElement('h4');
                   orderNumber.innerText = 'Order number: ' + renMsg.merchantTradeNo;
                    myRow.appendChild(orderNumber);

                   const tradeDate = document.createElement('h4')
                   const readeValue = new Date(renMsg.tradeDate)
                   console.log('renMsg.tradeDate: ', renMsg.tradeDate);
                   console.log('readeValue: ', readeValue);
                
                   tradeDate.innerText = 'Order time: ' + formatDate(readeValue);
                    myRow.appendChild(tradeDate);

                   const tradAmt = document.createElement('h4')
                   tradAmt.innerText = 'Order amount: ' + renMsg.tradeAmt;
                    myRow.appendChild(tradAmt);

                   const paymantType = document.createElement('h4')
                   paymantType.innerText = 'Payment type: ' + renMsg.paymentType.replaceAll('_', ' ');
                    myRow.appendChild(paymantType);

                   $(".sub1").append(myCol)
               }
           },
           error: function () {
               console.log('error --- >');
           },
       })
   }

   function deleActive() {
       // 取消原本active
       let active = document.querySelector('.active');
       console.log('active: ', active);
       active.setAttribute('class', 'page-item page-li');
   }


   function formatDate(now) { 
    　　var year=now.getFullYear(); 
    　　var month=now.getMonth()+1; 
    　　var date=now.getDate(); 
    　　var hour=now.getHours(); 
    　　var minute=now.getMinutes(); 
    　　var second=now.getSeconds(); 
    　　return year+"/"+month+"/"+date+" "+hour+":"+minute+":"+second; 
    } 