function dofirst() {
    

    renderCalender();
     day = document.querySelector(".days")
    console.log('day: ', day);

     btnDay = document.getElementsByClassName('btn-day');
    console.log('btnDay', btnDay);
}

const date = new Date();

const renderCalender = () => {
    // date.setFullYear(2020);
    // date.setMonth(2);
    console.log('date: ', date);
    
    // 前一個月有幾天
    console.log(date.getMonth());
    console.log(new  Date(date.getFullYear(), date.getMonth() , 0));
    const prevLastDate = new  Date(date.getFullYear(), date.getMonth() , 0).getDate();
    console.log('prevLastDate: ', prevLastDate);

    // 當月第一天為星期幾
    date.setDate(1);
    const firstDateIndex = date.getDay();
    console.log('firstDateIndex: ', firstDateIndex);

    const monthColl = date.getMonth();
    const year = date.getFullYear();
    
    console.log('monthColl: ', monthColl);
    console.log('year: ', year);
    const months = [
        "January",
        "Feburary",
        "March",
        "April",
        "May",
        "June",
        "July",
        "August",
        "September",
        "October",
        "November",
        "December"
    ];
    const month = months[monthColl - 1];
    console.log('month: ', month);

    document.querySelector('.date h1').innerHTML = months[monthColl];
    document.querySelector('.date p').innerHTML = new Date().toDateString();

    const monthDays = document.querySelector('.days');
    // 當月有幾天
    const lastDays = new  Date(date.getFullYear(), date.getMonth()+1 , 0).getDate();
    console.log('lastDays: ', lastDays);
    const lastDaysIndex = new  Date(date.getFullYear(), date.getMonth()+1 , 0).getDay();
    console.log('lastDaysIndex: ', lastDaysIndex);

    let nextDays = 7 - lastDaysIndex -1 ;
    if(nextDays == 0 ){
        nextDays = 7;
    }
    console.log('nextDays: ', nextDays);

    let days = "";

    for(let x = firstDateIndex ; x > 0 ; x--) {
        days += `<div class="prev-date">${prevLastDate - x + 1}</div>`;
        console.log('prevLastDate - x + 1: ', prevLastDate - x + 1);

    }
    monthDays.innerHTML = days;

    for(let i = 1 ; i <= lastDays ; i ++) {
        if(i === new Date().getDate() && date.getMonth() === new Date().getMonth()){
            // days += `<div class="today">${i}</div>`;
            days += `<button class="today" type="button" value="${month},${i},${year}" name="day">${i}</button>`;

        } else{
            // days += `<div>${i}</div>`;
            days += `<button class="btn-day" type="button" value="${month}.${i}.${year}" name="day">${i}</button>`;
        }
    }
    monthDays.innerHTML = days;

    for(let j = 1 ; j <= nextDays ; j++) {
        days += `<div class="next-date">${j}</div>`;
        monthDays.innerHTML = days;
    }
}   

window.addEventListener('load', dofirst);

// 上一月
document.querySelector(".prev").addEventListener("click" , () => {
    date.setMonth(date.getMonth() - 1);
    renderCalender();
});
// 下一月
document.querySelector(".next").addEventListener("click" , () => {
    date.setMonth(date.getMonth() + 1);
    renderCalender();
});


let day = document.querySelector(".days");

day.addEventListener("click", (e) => {

    const target = e.target;
    console.log('target: ', target);
    const day = console.log(target.value);
    // document.querySelector('.date p').innerHTML = ;

    $.ajax({
        url: "ajaxServlet", // 请求路径
        type: "POST", //请求方式
        //data: "username=jack&age=23",//请求参数
        data: { "username": "jack", "age": 23, "day": day },
        success: function (data) {
            alert("data");
        },//响应成功后的回调函数
        error: function () {
            alert("出错啦...")
        },//表示如果请求响应出现错误，会执行的回调函数

        dataType: "text"//设置接受到的响应数据的格式
    });
});


