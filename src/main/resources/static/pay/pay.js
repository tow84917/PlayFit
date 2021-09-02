function dofirst() {
    execTimes = null;
    period = null;
    price = null;
    itemName = null;
}
window.addEventListener('load', () => {
    dofirst();
})

// 403 錯誤
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function (e, xhr, options) {
    xhr.setRequestHeader(header, token);
});
// 403 錯誤

/**
 * 取得...
 * 訂閱次數
 * 週期種類
 * 金額
 * 交易描述
 */
// 取得月付資訊
let month = document.querySelector('.month');
month.addEventListener('click', (e) => {
    console.log('e.target.value: ', e.target.value);
    execTimes = e.target.value;
    period = 'M';
    price = '30';
    itemName = '月付';
})
// 取得年付資訊
let year = document.querySelector('.year');
year.addEventListener('click', (e) => {
    console.log('e.target.value: ', e.target.value);
    execTimes = e.target.value;
    period = 'Y';
    price = '300';
    itemName = '年付';
})


/**
 * 送出結帳資訊
 */

let check = document.getElementById('check');
check.innerHTML
check.addEventListener('click', (e) => {
    console.log(e.target);
    console.log('execTimes: ', execTimes);
    console.log('period: ', period);
    console.log('price: ', price);
    console.log('itemName: ', itemName);

    // 如果付一次，使用單次付款
    if (execTimes == 1) {
        $.ajax({
            url: 'checkOut',
            type: 'POST',
            async: false,
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(
                {
                    execTimes: execTimes, period: period,
                    price: price, itemName: itemName,
                }
            ),
            success: function (data) {
                console.log('data: ', data);
                let body = document.getElementsByTagName('body');
                console.log('body: ', body);
                body.innerHTML = '';
                $('#body').empty();
                // body.innerHTML = data;
    
                $('#body').append(data)
            },
            error: function () {
                console.log("error -------->>>>>>>>>>");
            },
        })
    } else {
        // 定期定額 付款方式
          $.ajax({
        url: 'period',
        type: 'POST',
        async: false,
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(
            {
                execTimes: execTimes, period: period,
                price: price, itemName: itemName,
            }
        ),
        success: function (data) {
            console.log('data: ', data);
            let body = document.getElementsByTagName('body');
            console.log('body: ', body);
            body.innerHTML = '';
            $('#body').empty();
            // body.innerHTML = data;

            $('#body').append(data)
        },
        error: function () {
            console.log("error -------->>>>>>>>>>");
        },
    })
    }
})

