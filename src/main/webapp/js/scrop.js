$(function () {
    if ($(document).scrollTop() > 0 && $(document).scrollTop() < 43) {
        //$('.header-fixed').addClass('header-opacity');
        //debugger;
       // $('.header-shadow').hide()
    } else if ($(document).scrollTop() > 0) {
        //	debugger;
        $('.shortcut .gotop').slideDown()
    } else {
    }
});
$(window).scroll(function () {
    if ($(document).scrollTop() > 0 && $(document).scrollTop() < 43) {
        //$('.header-fixed').addClass('header-opacity');
        //$('.header-shadow').hide();
        $('.shortcut .gotop').slideUp()
    } else if ($(document).scrollTop() > 0) {
        //$('.header-fixed').removeClass('header-opacity');
        //$('.header-shadow').show();
        $('.shortcut .gotop').slideDown()
    } else {
        //$('.header-fixed').addClass('header-opacity');
        //$('.header-shadow').hide();
        $('.shortcut .gotop').slideUp()
    }
});