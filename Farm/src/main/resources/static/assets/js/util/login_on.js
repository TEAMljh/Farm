
/*
*@Name: 特色农产品销售
*@Author: ljh
*@Copyright:layui.com
*/

layui.define(['jquery','layer','mm', 'form'],function(exports){
    var $ = layui.jquery,layer = layui.layer,mm = layui.mm,form = layui.form;

    var login_on = {
        //用户登录成功
        login_success : function(){
            if(sessionStorage.getItem('login_success') == 0){
                // console.log(sessionStorage.getItem('username'));
                $('.login').text(sessionStorage.getItem('username')).append('&nbsp;&nbsp;&nbsp;&nbsp;<span id="change">修改信息</span>&nbsp;&nbsp;&nbsp;&nbsp;<a class="quit">退出</a>');
            }
        },

        //用户退出，清除记录
        login_quit :function () {
            sessionStorage.removeItem('username');
            sessionStorage.removeItem('login_success');
            sessionStorage.removeItem('address1');
            sessionStorage.removeItem('address2');
            sessionStorage.removeItem('address3');
            sessionStorage.removeItem('tel');

        },

        //搜索商品
        login_search :function (p) {
                // window.location.href = '/page/web/commodity.html';
                var html = demo.innerHTML;
                var listCont = document.getElementById('list-cont');
                // console.log(layui.router("#/about.html"))
                mm.request({
                    url: '/main/productdisplay/all?name='+ p,
                    async: false,
                    success : function(res){
                        listCont.innerHTML = mm.renderHtml(html,res);
                        pages = res.data.pages;
                        current = res.data.current;
                        if (pages === 1  ) {
                            $('#onpage,#pro_tips').hide();
                        }else if(pages === 0){
                            $('#onpage').hide();
                            $('#pro_tips').show();
                        }else{
                            $('#onpage').show();
                            $('#pro_tips').hide();
                        }
                        console.log("我输出了")
                    },
                    error: function(){
                    }
                })
        }

        //修改密码
        // login_changePassword : function () {
        //     admin.open({
        //         type: 1,
        //         title: '修改密码',
        //         content: $('#changePwd').html(),
        //         success: function (index, layero) {
        //             form.on('submit(submitPsw)', function (data) {
        //                 var formData = data.field;
        //                 console.log(formData);
        //                 //若两次新密码不一致
        //                 if(formData.password != formData.repassword){
        //                     layer.msg('两次输入的新密码不一致', {icon: 2});
        //                 }else{
        //                     admin.req('/admin/user/changePassword', formData, function (res) {
        //                         if (res.code == 0){
        //                             layer.msg(res.msg, {icon: 1});
        //                             admin.req('/logout', {}, function () {
        //                                 window.location.href = '/page/admin/login.html';
        //                             }, 'GET');
        //                         } else{
        //                             layer.msg(res.msg, {icon: 2});
        //                         }
        //                     }, 'POST');
        //                 }
        //                 return false;
        //             });
        //         }
        //
        //     });
        // }
    }


    exports('login_on',login_on)
});