var didScroll;
var lastScrollTop;
var delta;
var navbarHeight;


$(document).ready(function () {
    navbarHeight = $('.topper_nav').outerHeight() - 80;
    lastScrollTop = 0;
    delta = 5;
})

$(window).scroll(function (event) {
    didScroll = true;
});

setInterval(function () {
    if (didScroll) {
        hasScrolled();
        didScroll = false;
    }
}, 250);

function hasScrolled() {
    var st = $(this).scrollTop(); 

    if (st > 49) {
        //내려갈때
        $('.nav_logo').removeClass('gone');
        $('.nav_user_icons').removeClass('gone');
        $('#header_nav').removeClass('nav-down').addClass('nav-up');
        
    }

    if (st < 50) {
        //올라가다가 천장을 만나면
        $('#header_nav').removeClass('nav-up');
        $('.nav_user_icons').addClass('gone');
        $('.nav_logo').addClass('gone');
    }
    // console.log("lastScrollTop, delta, st : " + lastScrollTop + "/" + delta + "/" + st);
} 