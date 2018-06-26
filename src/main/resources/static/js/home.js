
$(function () {
    $('.right').click(function () {
        $(".banner ul").animate({marginLeft:"-800px"},600, function () {
            $(".banner ul>li").eq(0).appendTo($(".banner ul"));
            $(".banner ul").css('marginLeft','0px');
        });
    })
    $('.left').click(function () {
        $(".banner ul").css('marginLeft','-800px');
        $(".banner ul>li").eq(3).prependTo($(".banner ul"));
        $(".banner ul").animate({marginLeft:"0px"},600);
    })
})
