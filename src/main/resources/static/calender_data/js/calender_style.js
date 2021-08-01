function dofirst() {


    renderCalender(scheduled);
    day = document.querySelector(".days")
    console.log('day: ', day);

    btnDay = document.getElementsByClassName('btn-day');
    console.log('btnDay', btnDay);

    // get 月份
}

const date = new Date();

scheduled = [10, 20];  // 測試

// 傳入 月份
const renderCalender = (daysArray) => {
    // date.setFullYear(2020);
    // date.setMonth(6);
    console.log('date: ', date);

    // 前一個月有幾天
    console.log(date.getMonth());
    console.log(new Date(date.getFullYear(), date.getMonth(), 0));
    const prevLastDate = new Date(date.getFullYear(), date.getMonth(), 0).getDate();
    console.log('prevLastDate: ', prevLastDate);

    // 當月第一天為星期幾
    date.setDate(1);
    const firstDateIndex = date.getDay();
    console.log('firstDateIndex: ', firstDateIndex);

    const monthColl = date.getMonth();
    // 年
    const year = date.getFullYear();

    console.log('monthColl: ', monthColl);
    console.log('year: ', year);
    let months = [
        "January",
        "Feburary",
        "March",
        "April",
        "May",
        "June",
        "Jul",
        "August",
        "September",
        "October",
        "November",
        "December"
    ];
    months = [
        "01",
        "02",
        "03",
        "04",
        "05",
        "06",
        "07",
        "08",
        "09",
        "10",
        "11",
        "12"
    ];
    const month = months[monthColl];
    console.log('month: ', month);

    document.querySelector('.date h1').innerHTML = months[monthColl] + ' ' + year;
    // document.querySelector('.date p').innerHTML = new Date().toDateString();

    monthDays = document.querySelector('.days');
    // 當月有幾天
    const lastDays = new Date(date.getFullYear(), date.getMonth() + 1, 0).getDate();
    console.log('lastDays: ', lastDays);
    const lastDaysIndex = new Date(date.getFullYear(), date.getMonth() + 1, 0).getDay();
    console.log('lastDaysIndex: ', lastDaysIndex);

    // 加最後7天
    let nextDays = 7 - lastDaysIndex - 1;
    // if(nextDays == 0 ){
    //     nextDays = 7;
    // }
    console.log('nextDays: ', nextDays);


    // 新增日期
    let days = "";



    let seven = 1;

    for (let x = firstDateIndex; x > 0; x--) {
        // console.log('x: ', x);
        // console.log('seven:  ', seven);

        days += `<div class="prev-date">${prevLastDate - x + 1}</div>`;
        // console.log('prevLastDate - x + 1: ', prevLastDate - x + 1);

        if (seven % 7 === 0) {
            sevendays = document.createElement('div');
            sevendays.setAttribute('class', 'sevendays');
            // sevendays.innerHTML  = 'AAAAAAAA';
            // monthDays.appendChild(sevendays);
            // days += `<div class="prev-date">${prevLastDate - x + 1}</div>`;
            // console.log('prevLastDate - x + 1: ', prevLastDate - x + 1);
            sevendays.innerHTML = days;
            days = '';
            seven = 0;
        }
        seven++;
    }
    // sevendays.innerHTML = days;


    for (let i = 1; i <= lastDays; i++) {
        // console.log('i: ', i);
        // console.log('lastDays: ', lastDays);
        // console.log('seven: ++++ ', seven);

        if (i === new Date().getDate() && date.getMonth() === new Date().getMonth()) {
            // days += `<div class="today">${i}</div>`;
            days += `<button class="today" type="button" value="${month},${i},${year}" name="day">${i}</button>`;

        } else {
            // days += `<div>${i}</div>`;
            for (const iterator of daysArray) {
                console.log('iterator: ', iterator);
                if (iterator == i) {
                    // 如果已有排程 增加 scheduled css
                    days += `<button class="btn-day scheduled" type="button" value="${year},${month},${i}" name="day">${i}</button>`;
                    break;
                } else {
                    continue;
                }
            }
            // 沒排程，也不是當天
            // days += `<div>${i}</div>`;
            days += `<button class="btn-day" type="button" value="${month}.${i}.${year}" name="day">${i}</button>`;
        }
        // console.log('days: ', days);

        if (seven % 7 === 0) {
            sevendays = document.createElement('div');
            sevendays.setAttribute('class', 'sevendays');
            // sevendays.innerHTML  = 'AAAAAAAA';
            if (seven != 0) {
                monthDays.appendChild(sevendays);
                // console.log('*******************************************');
            }

            sevendays.innerHTML = days;
            days = '';

            seven = 0;
        }

        seven++;
    }

    // sevendays.innerHTML = days;
    // monthDays.appendChild(sevendays);
    // sevendays.innerHTML = days;
    // days = '';

    for (let j = 1; j <= nextDays; j++) {
        // console.log('seven: >> ', seven);
        days += `<div class="next-date">${j}</div>`;
        // sevendays.innerHTML = days;
        if (seven % 7 === 0) {
            sevendays = document.createElement('div');
            sevendays.setAttribute('class', 'sevendays');
            // sevendays.innerHTML  = 'AAAAAAAA';
            monthDays.appendChild(sevendays);

            sevendays.innerHTML = days;
            days = '';

            seven = 0;
        }


        seven++;
    }
}

window.addEventListener('load', dofirst);

// 上一月
document.querySelector(".prev").addEventListener("click", () => {
    date.setMonth(date.getMonth() - 1);
    monthDays.innerHTML = '';
    renderCalender();
});
// 下一月
document.querySelector(".next").addEventListener("click", () => {
    date.setMonth(date.getMonth() + 1);
    monthDays.innerHTML = '';
    renderCalender();
});

// 403 錯誤
var token = $("meta[name='_csrf']").attr("content");
var header = $("meta[name='_csrf_header']").attr("content");
$(document).ajaxSend(function (e, xhr, options) {
    xhr.setRequestHeader(header, token);
});
// 403 錯誤

let day = document.querySelector(".days");
day.addEventListener("click", (e) => {

    const target = e.target;
    console.log('target: ', target);
    const day = target.value;
    $.post("calender_controller", { day: day }, function (data) {
        //判断userExsit键的值是否是true
        console.log('day: ', data);
        document.getElementById('day').innerText = data;

    });

    $.post("calender_image", {}, function (data) {
        //判断userExsit键的值是否是true
        console.log('img: ', data);
        document.getElementById('today-img').src = data;

    });

    // $.ajax({
    //     url: "calender_controller", // 请求路径
    //     // url:"ajaxServlet",
    //     type: "POST", //请求方式
    //     // data: "username=jack&age=23&day=" + day,//请求参数
    //     contentType: "application/json; charset=utf-8",
    //     data: JSON.stringify({'day': day }) ,
    //     dataType: "json", //设置接受到的响应数据的格式
    //     success: function (data) {
    //         if (data.userExsit) {
    //         //用户名存在
    //         console.log(data.msg);
    //         } else {
    //             //用户名不存在
    //             console.log(data.msg);
    //         }

    //     },//响应成功后的回调函数
    //     error: function () {
    //         alert("出错啦...")
    //     },//表示如果请求响应出现错误，会执行的回调函数
    // });
});


