
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
        },

        //修改密码
        login_changeUser :function () {
            layer.open({
                type: 1,
                title: '修改信息',
                area: '800px',
                shade: 0.3,
                content: $('#changeUser').html(),
                success: function (layero, index) {  //弹出成功的回调
                    console.log('弹出了' + layero, index);
                    $('#changeUserId').val(sessionStorage.getItem('changeUserId'));
                    console.log(sessionStorage.getItem('changeUserId'));
                    $('#name').val(sessionStorage.getItem('username'));

                    //表单验证
                    form.verify({
                        name:[/^[a-zA-Z\u4E00-\u9FA5][a-zA-Z0-9\u4E00-\u9FA5_-]{2,11}$/,'请输入正确的3-11位用户名'],
                        pass:[/^(\w){3,11}$/,'请输入正确的3-11位密码,可包括字母、数字和下划线'],
                        province:[/^[\u4e00-\u9fa5]{3,8}$/,'请输入正确地名'],
                        city:[/^[\u4e00-\u9fa5]{3,8}$/,'请输入正确地名'],
                        county:[/^[\u4e00-\u9fa5]{3,8}$/,'请输入正确地名'],
                        detail:[/^[\u4e00-\u9fa5]{9,30}$/,'请输入正确地名']
                    });

                    //验证
                    form.on('submit(changeUser)',function (data) {
                        var field = data.field;

                        $.ajax({
                            type: "get",
                            url: "/main/changeUser",
                            data: field,
                            success: function (res) {
                                // admin.btnLoading('#btnLoading', false);
                                if (res.code == 0) {
                                    layer.msg(res.msg, {icon: 1, time: 1500}, function () {
                                        location.replace('../../page/web/login.html');
                                    });
                                }else{
                                    layer.msg(res.msg);

                                    form.render();
                                }

                            }, error: function () {
                            }
                        });
                        return false;
                    });
                }
            })
        }
    }


    exports('login_on',login_on)
});