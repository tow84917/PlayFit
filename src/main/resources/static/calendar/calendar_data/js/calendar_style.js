function dofirst() {
    date = new Date();
    console.log('date: ', date);
    const today = date.getFullYear() + '/' + (date.getMonth() + 1) + '/' + date.getDate();
    console.log('day: ', today);
    findToday(today);

    let schedulet = getMonthlyFitDays(date);
    renderCalender(schedulet);

    getMonthlyRecord(date);

    day = document.querySelector(".days")
    

    btnDay = document.getElementsByClassName('btn-day');
    
    // get 月份
}

window.addEventListener('load', dofirst);

// scheduled = [10, 20];  // 測試
// scheduled = [];

/**
 * 請求 查詢當月有排成的日期 
 * @param {*} date 
 * @returns 日期陣列
 */
function getMonthlyFitDays(date) {
    let scheduled = [];
    let month =  date.getMonth();
    let year = date.getFullYear();
      $.ajax({
        url:"findFitDays" , 
        type: "POST" , 
        async:false ,
        contentType: "application/json; charset=utf-8",
        dataType: "json", 
        data: JSON.stringify({"month":month , "year":year}),
        // data: json,
        success: function (data) {
            scheduled = data;
            console.log('scheduled: ', scheduled);
            
        },
        error: function () {
        },
    })
    

    return scheduled;
}

//查詢月紀錄
function getMonthlyRecord(date) {
    let month =  date.getMonth();
    let year = date.getFullYear();
      $.ajax({
        url:"findMonthlyRecord" , 
        type: "POST" , 
        async:false ,
        contentType: "application/json; charset=utf-8",
        dataType: "json", 
        data: JSON.stringify({"month":month , "year":year}),
        // data: json,
        success: function (data) {
            console.log('data: ', data);
            console.log(data.finish);
            console.log(data.monthly_kcal);
            console.log(data.monthly_time);

            $('#finish').text(data.finish);
            $('#kcal').text(data.monthly_kcal);
            $('#min').text(data.monthly_time);
        
        },
        error: function () {
        },
    })
}

// 傳入 有排程的日期陣列
const renderCalender = (daysArray) => {
    

    // date.setFullYear(2020);
    // date.setMonth(6);
    

    // 前一個月有幾天
    
    
    const prevLastDate = new Date(date.getFullYear(), date.getMonth(), 0).getDate();
    

    // 當月第一天為星期幾
    date.setDate(1);
    const firstDateIndex = date.getDay();
    

    const monthColl = date.getMonth();
    // 年
    const year = date.getFullYear();

    
    
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
    

    document.querySelector('.date h1').innerHTML = months[monthColl] + ' ' + year;
    // document.querySelector('.date p').innerHTML = new Date().toDateString();

    monthDays = document.querySelector('.days');
    // 當月有幾天
    const lastDays = new Date(date.getFullYear(), date.getMonth() + 1, 0).getDate();
    
    const lastDaysIndex = new Date(date.getFullYear(), date.getMonth() + 1, 0).getDay();
    

    // 加最後7天
    let nextDays = 7 - lastDaysIndex - 1;
    // if(nextDays == 0 ){
    //     nextDays = 7;
    // }
    

    // 新增日期
    let days = "";

    let seven = 1;

    for (let x = firstDateIndex; x > 0; x--) {
        // 
        // 

        days += `<div class="prev-date">${prevLastDate - x + 1}</div>`;
        // 

        if (seven % 7 === 0) {
            sevendays = document.createElement('div');
            sevendays.setAttribute('class', 'sevendays');
            // sevendays.innerHTML  = 'AAAAAAAA';
            // monthDays.appendChild(sevendays);
            // days += `<div class="prev-date">${prevLastDate - x + 1}</div>`;
            // 
            sevendays.innerHTML = days;
            days = '';
            seven = 0;
        }
        seven++;
    }
    // sevendays.innerHTML = days;


    for (let i = 1; i <= lastDays; i++) {
        // 
        // 
        // 

        if (i === new Date().getDate() && date.getMonth() === new Date().getMonth()) {
            // days += `<div class="today">${i}</div>`;
            days += `<button class="today" type="button" value="${year},${month},${i}" name="day">${i}</button>`;

        } else {
            // days += `<div>${i}</div>`;
            let flag = true;
            for (const iterator of daysArray) {
                // 
                if (iterator == i) {
                    // 如果已有排程 增加 scheduled css
                    days += `<button class="btn-day scheduled" type="button" value="${year},${month},${i}" name="day">${i}</button>`;
                    flag = false;
                    break;
                } else {
                    continue;
                }
            }

            if (flag) {
                days += `<button class="btn-day" type="button" value="${year},${month},${i}" name="day">${i}</button>`;

            }
        }
        // 

        if (seven % 7 === 0) {
            sevendays = document.createElement('div');
            sevendays.setAttribute('class', 'sevendays');
            // sevendays.innerHTML  = 'AAAAAAAA';
            if (seven != 0) {
                monthDays.appendChild(sevendays);
                // 
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
        // 
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


// 上一月
document.querySelector(".prev").addEventListener("click", () => {
    date.setMonth(date.getMonth() - 1);
    monthDays.innerHTML = '';
    
    
    let schedulet = getMonthlyFitDays(date);
    renderCalender(schedulet);
    getMonthlyRecord(date);
});
// 下一月
document.querySelector(".next").addEventListener("click", () => {
    date.setMonth(date.getMonth() + 1);
    monthDays.innerHTML = '';
    
    
    let schedulet = getMonthlyFitDays(date);
    renderCalender(schedulet);
    getMonthlyRecord(date);
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
    
    let today = target.value;
    today =  today.replace(/,/g,'/');
    console.log('day: ', today);
    document.getElementById('day').innerText = today;

    findToday(today);

});

const todayFits = document.getElementById('today-fits');

function findToday(today) {
    $.post("findToday", { day: today }, function (data) {

        console.log(data.length);
        for (let i = 0; i < data.length; i++) {
            const element = data[i];
            console.log('element: ', element);
            const path = element.fitActivity.imagePath;
            console.log('path: ', path);
            const fitName = element.fitActivity.name;
            const status = element.status;
            console.log('status: ', status);

            if (status == '直接執行') {
            } else {
                let todayCard = document.createElement('button');    
                let todayFitImg = document.createElement('img');
                let a ;
                let finishIcon;
                if (status == '未執行') {
                    a = document.createElement('a');
                    a.href = 'calendar';
                    todayCard.setAttribute('class', 'today-card div btn');
                    todayFitImg.setAttribute('class' , 'today-fit');
                } else {
                    a = document.createElement('div');
                    todayCard.setAttribute('class', 'today-card today-card-finish div btn')
                    todayFitImg.setAttribute('class' , 'today-fit today-fit-finish');
                    finishIcon = document.createElement('img');
                    finishIcon.setAttribute('class', 'finish-icon');
                    finishIcon.src = '/images/finishl.svg';
                    todayCard.appendChild(finishIcon);
                }

                todayFitImg.src = path;
    
                let todayFitName = document.createElement('span');
                todayFitName.setAttribute('class', 'today-fit-name');
                todayFitName.innerText = fitName;
    
                todayCard.appendChild(todayFitImg);
                todayCard.appendChild(todayFitName);

                a.appendChild(todayCard);
    
                todayFits.appendChild(a);
            }
            
        }
    },'json');
}

