
/*
*@Name: 特色农产品销售
*@Author: ljh
*@Copyright:layui.com
*/

layui.define(['jquery','layer','mm'],function(exports){
    var $ = layui.jquery,layer = layui.layer,mm = layui.mm;

    var login_on = {
        //用户登录成功
        login_success : function(){
            if(sessionStorage.getItem('login_success') == 0){
                // console.log(sessionStorage.getItem('username'));
                $('.login').text(sessionStorage.getItem('username')).append('&nbsp;&nbsp;&nbsp;&nbsp;<a class="quit">退出</a>');
            }
        },

        //用户退出，清除记录
        login_quit :function () {
            sessionStorage.removeItem('username');
            sessionStorage.removeItem('login_success');
            sessionStorage.removeItem('address1');
            sessionStorage.removeItem('address2');
            sessionStorage.removeItem('address3');

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
                            $('#onpage').hide();
                        }else if(pages === 0){
                            $('#onpage').html('<strong>暂无商品，敬请期待！</strong>');
                        }else{
                            $('#onpage').show();
                        }
                        console.log("我输出了")
                    },
                    error: function(){
                    }
                })
        }
    }


    exports('login_on',login_on)
});