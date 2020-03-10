
/*
*@Name: 特色农产品销售
*@Author: ljh
*@Copyright:layui.com
*/

layui.define(['jquery','layer'],function(exports){
    var $ = layui.jquery,layer = layui.layer;

    var login_on = {
        //用户登录成功
        login_success : function(){
            if(sessionStorage.getItem('login_success') == 0){
                console.log(sessionStorage.getItem('username'));
                $('.login').text(sessionStorage.getItem('username')).append('&nbsp;&nbsp;&nbsp;&nbsp;<a class="quit">退出</a>');
            }
        },

        //用户退出，清除记录
        login_quit :function () {
            sessionStorage.removeItem('username');
            sessionStorage.removeItem('login_success');
        }
    }


    exports('login_on',login_on)
});