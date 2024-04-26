//функция изменения меню-бургера по клику и плавного появления меню-бургера
$(document).ready(function() {
    $('.menu-burger__header').click(function(){
        $('.menu-burger__header').toggleClass('open-menu');
        $('.menu').toggleClass('open-menu');
    });
});
