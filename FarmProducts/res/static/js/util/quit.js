
/*
*@Name: 特色农产品销售
*@Author: ljh
*@Copyright:layui.com
*/

layui.define(['jquery','layer'],function(exports){
    var $ = layui.jquery,layer = layui.layer;

    var quit = {
        login_quit :function () {
            // $('.quit').css('visibility','hidden');
            // $('.login').text('登录');
            console.log('1')
            layer.msg('已成功退出',{icon:1,time:1500},function () {
                sessionStorage.removeItem('username');
                sessionStorage.removeItem('login_success');
                location.replace('../html/commodity.html');
            })
        }
    }


    exports('quit',quit)
});