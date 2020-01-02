<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    
    <title>银行卡挂失</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	  <style type="text/css">
		  .div_ul li{
			  display: inline-block;
			  padding: 10px 10px ;
			  font-size: 18px;
		  }
	  </style>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	
	-->
	<link rel="stylesheet" type="text/css" href="/guopeng/css/ReportLoss.css"><!-- 头部 -->
	<link href="/guopeng/css/deposit.css" rel="stylesheet"><!-- 主体部 -->
	<link rel="stylesheet" type="text/css" href="/guopeng/css/header.css"><!-- 底部 -->
	<link rel="stylesheet" href="/guopeng/layui/css/layui.css">
	<script src="/guopeng/js/jquery-1.11.0.min.js" type="text/javascript"></script>
	<script src="/guopeng/layui/layui.js"></script>
	<script>
		//Demo
		layui.use(['form','jquery','layer'], function(){
		  var form = layui.form;
		  var $=layui.jquery;
		  var layer=layui.layer;
		  
		  form.verify({
			　　　　bankCardId: [
			　　　　　　/(^\d{18}$)/  //正则表达式
			　　　　　　,'卡号只能18位数'  //提示信息
			　　　　] 
			　　});
		  
		  //点击获取验证码
		  $("#sms").click(function(){
			  var phone=$("#phone").val();
			  if(phone!=null&&phone!=""){
				  $.ajax({
						type:"post",
						url:"/guoPengSMSServlet",
						data:{"phone":phone},
						success:function(result){
							if(result.length>5){
								$("#smsCode").val(result);
								layer.msg('短信发送成功', {icon: 6}); 
							}
							if(result==-41){
								layer.msg('手机号不能为空！', {icon: 2}); 
							}
						}
					})
					return false;
			  }else{
				  layer.msg('手机号不能为空！', {icon: 2}); 
				  return false;
			  }
		  })
		   
		  //监听提交
		  form.on('submit(formDemo)',function(data){
			  var smsCode=$("#smsCode").val();
			  var bankCardId=$("#bankCardId").val();
			  var yzm=$("#yzm").val();
			  if($("#bankCardId").val()==null || $("#bankCardId").val()==""){
				  layer.msg('银行卡号不能为空', {icon: 2}); 
				  return false;
			  }
			  if($("#yzm").val()!=smsCode){
				  layer.msg('验证码不一致', {icon: 2}); 
				  return false;
			  }
			  $.ajax({
					type:"post",
					url:"<%=path%>/AjaxUpdateBankCardIdServlet",
					data:$("#addGoodsForm").serialize(),
					success:function(result){
						if(result=="挂失成功"){
							layer.msg('挂失成功<br>请您耐心等待，我们会尽快处理！', {
								time: 20000, //20s后自动关闭
								btn: ['好的','知道了','关闭']
							});
						}else if(result=="银行卡已挂失"){
							layer.msg('银行卡已挂失',{icon:2});
						}else{
							layer.msg('没有此银行卡号请重新输入',{icon:2});
						}
					},
					 error:function(e){
				            layer.msg('提交失败',{icon:2})
				     },
				});
			  $("#addGoodsForm")[0].reset();
              form.render();
		    return false;
		  });
		});
	</script>
  </head>
  
  <body>
  <header>
            <div class="header_div">

                <ul>
                    <li>
                        <a href="wanzehao/index.jsp">网站首页</a>
                    </li>
                    <li>
                        ｜
                    </li>
                    <li>
                        <a href="javascript:void(0)">网点查询</a>
                    </li>
                </ul>
                <div class="search">
                    
                        <input type="text" placeholder="请输入关键字" size="10">
                        <input type="button">
                    
                </div>
            </div>
            </div>
        </header>
        
        <div class="title">
            <ul>
                <li>
                    <img src="/guopeng/img/郭氏银行.png" width="198" height="50">
                </li>
                <li>
                    <p>|</p>
                </li>
                <li>
                    <p>个人网上银行——挂失</p>
                </li>
            </ul>

        </div>
        
       <!--<form action="" method="get" class="layui-form" >
       <div class="contene "  >
            <div class="form">
                <div class="price">
                    <p>请输入身份证:</p>
                    <input type="text" maxlength="18" size="30">
                </div>
                <div class="pwd">
                    <p>请输入预留手机号:</p>
                    <input type="text" maxlength="11" size="30">
                </div>
                <div class="yzm">
                    <p>请输入验证码:</p>
                    <input type="text" maxlength="6" size="30">
                </div>
                <div class="button">
                    <input type="button" value="确认">
                </div>
            </div>
        </div>
  	</form> --> 
  	<div style="width: 50% ;height: 50%; margin: 0 auto; margin-top: 1% ; border: 1px solid #ccc; background-color: white;line-height: 20px;">
  	<form class="layui-form"  style="margin-top: 80px;"  id="addGoodsForm">
  	<input type="hidden" id="smsCode" name="smsCode" value=""/>
	  <div class="layui-form-item">
	    <label class="layui-form-label" style="width: 250px;">请输入卡号:</label>
	    <div class="layui-input-block">
	      <input type="text" maxlength="18" style="width: 250px;" id="bankCardId" name="bankCardId" required lay-verify="bankCardId"  placeholder="请输入卡号" autocomplete="off" class="layui-input">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label" style="width: 250px;">请输入预留手机号:</label>
	    <div class="layui-input-block">
	      <input type="text" style="width: 250px;"  maxlength="11" id="phone" name="phone" style="width: 250px;" required  lay-verify="phone" placeholder="请输入预留手机号" autocomplete="off" class="layui-input">
	    </div>
	  </div>
	  <div class="layui-form-item">
	    <label class="layui-form-label" style="width: 250px;">请输入验证码:</label>
	    <div class="layui-input-inline" style="width: 110px;">
	      <input type="text" style="width: 110px;" maxlength="6" id="yzm" name="yzm"required  lay-verify="number" placeholder="请输入验证码" autocomplete="off" class="layui-input">
	      
	    </div>
	    <div class="layui-input-inline">
	    <input type="button" class="layui-btn  layui-btn-normal" id="sms"  style="width: 130px;" value="点击获取验证码">
	    </div>
	  </div>
		<div class="layui-form-item">
			<div class="layui-input-block"  style="width: 50%; margin: 0 auto;	margin-left:290px">
				<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
				<button type="reset" class="layui-btn layui-btn-primary">重置</button>
			</div>
		</div>
	</form>
  	</div>
  	
  	
  
    <div class="footer_div">
   	<footer>
   		<div class="bottom">
  			<hr>
  			<div class="div_ul">
  				<ul>
  					<li><a href="javascript:void(0)">网站声明</a><li>
  					<li><a href="javascript:void(0)">|</a><li>
  					<li><a href="javascript:void(0)">网站地图</a><li>
  					<li><a href="javascript:void(0)">|</a><li>
  					<li><a href="javascript:void(0)">联系我们</a><li>
  					<li><a href="javascript:void(0)">|</a><li>
  					<li><a href="javascript:void(0)">客服热线：<span class="span">666666</span></a><li>
  				</ul>
  				<ul>
  					<li><a href="javascript:void(0)">中国郭氏银行版权所有</a></li>
  					<li><a href="javascript:void(0)">|</a></li>
  					<li><a href="javascript:void(0)"><span class="a">京ICP备05049539</span></a></li>
  				</ul>
  			</div>
  		</div>
  	</footer>
  	</div>
  </body>
</html>
