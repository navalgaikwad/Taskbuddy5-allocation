$(function(){
 var current_li;
$("#portfolio img").click(function(){
var src= $(this).attr("src");
 current_li=$(this).parent(); //storing current_li in parent element which is clicked
$("#main").attr("src", src);
$("#frame").fadeIn();
$("#overlay").fadeIn();

});
$("#overlay").click(function(){
    $(this).fadeOut(); 
    $("#frame").fadeOut();

});
$("#right").click(function(){
var next_li=current_li.next();
var next_src=next_li.children("img").attr("src");
$("#main").attr("src",next_src); 
current_li=next_li;
});
$("#left").click(function(){
var next_li=current_li.next();
var next_src=next_li.children("img").attr("src");
$("#main").attr("src",next_src); 
current_li=next_li;    
});

});