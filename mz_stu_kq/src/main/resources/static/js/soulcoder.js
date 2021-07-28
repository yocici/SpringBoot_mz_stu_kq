//设置页面的选中状态
var url = window.location.href;
var idVal = url.split("=")[1]
var menuIdStr = "#id_"+idVal;
$("li").removeClass('active');
$(menuIdStr).parent().addClass('active');
$(menuIdStr).parent().parent().parent().addClass('nav-item nav-item-has-subnav open')
//解决菜单扩展开之后，菜单显示不全问题
// function expandNode(){
//     $(menuIdStr).parent().parent().parent().find("ul").css('display','block')
// }