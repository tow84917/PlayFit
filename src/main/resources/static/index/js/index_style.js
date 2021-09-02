const hamburger = document.querySelector(".hamburger");
const navMenu = document.querySelector(".nav-menu");

hamburger.addEventListener("click", mobileMenu);

function mobileMenu() {
    hamburger.classList.toggle("active");
    navMenu.classList.toggle("active");

}

const navLink = document.querySelectorAll(".nav-link");

navLink.forEach(n => n.addEventListener("click", closeMenu));

function closeMenu() {
    hamburger.classList.remove("active");
    navMenu.classList.remove("active");
}


//if (height > 100) document.getElementById('footer').classList.add('footer-fixed');

$(window).scroll(function () {
    if ($(window).scrollTop() > 500) {
        $('.header').addClass('visible');
        $('.header').animate({
            top: '0px'
        });
        //$(window).unbind('scroll');
    }
    if ($(window).scrollTop() < -1) {
        $('.header').removeClass('visible');
        $('.header').removeAttr('style');
    }
});



