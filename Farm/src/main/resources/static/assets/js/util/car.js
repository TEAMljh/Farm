/*
*@Name: 特色农产品销售
*@Author: ljh
*@Copyright:layui.com
*/

layui.define(['layer','jquery'],function(exports){
	var layer = layui.layer,$ = layui.jquery;
	
var car = {
  init : function(){
  		var uls = document.getElementById('list-cont').getElementsByTagName('ul');//每一行
  		var checkInputs = document.getElementsByClassName('check'); // 所有勾选框
      var checkAll = document.getElementsByClassName('check-all'); //全选框
      var SelectedPieces = document.getElementsByClassName('Selected-pieces')[0];//总件数
      var piecesTotal = document.getElementsByClassName('pieces-total')[0];//总价
      var batchdeletion = document.getElementsByClassName('batch-deletion')[0]//批量删除按钮
      //计算
      function getTotal(){
          var seleted = 0,price = 0;
          for(var i = 0; i < uls.length;i++){
        			if(uls[i].getElementsByTagName('input')[0].checked){
                seleted += parseInt(uls[i].getElementsByClassName('Quantity-input')[0].value);
                price += parseFloat(uls[i].getElementsByClassName('sum')[0].innerHTML);
              }
      		}
          SelectedPieces.innerHTML = seleted;
          piecesTotal.innerHTML = '￥' + price.toFixed(2);
      }

      function fn1(){
        alert(1)
      }
      // 小计
      function getSubTotal(ul){
        var unitprice = parseFloat(ul.getElementsByClassName('th-su')[0].innerHTML);
        var count = parseInt(ul.getElementsByClassName('Quantity-input')[0].value);
        var SubTotal = parseFloat(unitprice*count)
        ul.getElementsByClassName('sum')[0].innerHTML = SubTotal.toFixed(2);
      }

      for(var i = 0;i < checkInputs.length;i++){
        checkInputs[i].onclick = function(){
          if(this.className === 'check-all check'){
            for(var j = 0;j < checkInputs.length; j++){
              checkInputs[j].checked = this.checked;
            }
          }
          if(this.checked == false){
            for(var k = 0;k < checkAll.length;k++){
              checkAll[k].checked = false;
            }
          }
          getTotal()
        }
      }
       //批量删除存数组
      var arry = [];
      for(var i = 0; i < uls.length;i++){
        uls[i].onclick = function(e){
          e = e || window.event;
          var el = e.srcElement;
          var cls = el.className;
          var input = this.getElementsByClassName('Quantity-input')[0];
          var less = this.getElementsByClassName('less')[0];
          var val = parseInt(input.value);
          var that = this;

          switch(cls){
            case 'add layui-btn':
              input.value = val + 1;
              getSubTotal(this)
              break;
            case 'less layui-btn':
              if(val > 1){
                input.value = val - 1;
              }
              getSubTotal(this)
              break;
            case 'dele-btn':
              layer.confirm('你确定要删除吗?',{
                yes:function(index,layero){
                  layer.close(index);
                    var id = $(that).attr("id");

                    //逻辑删除
                    $.ajax({
                      type:"post",
                      url: "/main/shopping/del/" + id,
                      dataType:"json",
                      success:function () {
                          getTotal();
                      },error:function (msg) {
                        console.log(msg);
                      }
                    });
                    that.parentNode.removeChild(that);
                }
              })
              break;
          }
          getTotal()
        }
      }
      batchdeletion.onclick = function(){
        if(SelectedPieces.innerHTML != 0){
          layer.confirm('你确定要删除吗!!!',{
            yes:function(index,layero){
              layer.close(index)
              for(var i = 0;i < uls.length;i++){
                var input = uls[i].getElementsByTagName('input')[0];
                if(input.checked){
                  arry = ($(uls[i]).attr('id'));
                    $.ajax({
                        type:"post",
                        url: "/main/shopping/del/" + arry,
                        dataType:"json",
                        success:function () {
                            getTotal();
                        },error:function (msg) {
                            console.log(msg);
                        }
                    });
                  uls[i].parentNode.removeChild(uls[i]);
                  i--;
                }
                // console.log(arry)
              }
              getTotal() 
            }

          })
        }else{
          layer.msg('请选择商品')
        }
        
      }
        checkAll[0].checked = true;
        checkAll[0].onclick();

        //选择支付
      $('.pay').click(function () {
          if($('.pieces-total').text() != '￥0.00' ){
              layer.msg("购物成功！欢迎下次再来！",{icon:1,time:4000


              },setTimeout(function () {
                  for(var i = 0;i < uls.length;i++){
                      var input = uls[i].getElementsByTagName('input')[0];
                      if(input.checked){
                          arry = ($(uls[i]).attr('id'));

                          //打印支付商品id
                          console.log(arry);
                          $.ajax({
                              type:"post",
                              url: "/main/shopping/bought/" + arry,
                              dataType:"json",
                              success:function () {
                              },error:function (msg) {
                                  console.log(msg);
                              }
                          });


                          uls[i].parentNode.removeChild(uls[i]);
                          i--;
                      }
                  }
                  getTotal();
              },1000));
          }else{
              layer.msg('请选购后再结算',{icon:0,time:1500})
          }
      });
  	  }  	

  }


  exports('car',car)
}); 