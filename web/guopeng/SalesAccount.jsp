<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>银行卡销户</title>

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
<link rel="stylesheet" type="text/css" href="/guopeng/css/ReportLoss.css">
<!-- 头部 -->
<link href="/guopeng/css/deposit.css" rel="stylesheet">
<!-- 主体部 -->
<link rel="stylesheet" type="text/css" href="/guopeng/css/header.css">
<!-- 底部 -->
<link rel="stylesheet" href="/guopeng/layui/css/layui.css">
<script src="/guopeng/js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="/guopeng/layui/layui.js"></script>
<script>
	
	
	
		//Demo
		layui.use(['form','rate','jquery','layer'], function(){
		  var form = layui.form;
		  var $=layui.jquery;
		  var layer=layui.layer;
		//点击获取验证码
			$("#sms").click(function(){
				var phone=$("#phone").val();
				if(phone!=null&&phone!=""){
					$.ajax({
						type:"post",
						url:"/guoPengSMSServlet",
						data:{"phone":phone},
						success:function(result){
							$("#smsCode").val(123123);
							layer.msg('短信发送成功', {icon: 6});
						}
					})
				}else{
					layer.msg('手机号不能为空', {icon: 2});
				}

			})
		  form.verify({
			  username: function(value, item){ //value：表单的值、item：表单的DOM对象
				 if(value==null||value==""){
					 return '姓名不能为空';
				 }
			    if(!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$").test(value)){
			      return '姓名不能有特殊字符';
			    }
			    if(/(^\_)|(\__)|(\_+$)/.test(value)){
			      return '用户名首尾不能出现下划线\'_\'';
			    }
			    if(/^\d+\d+\d$/.test(value)){
			      return '用户名不能全为数字';
			    }
			  }
			  //我们既支持上述函数式的方式，也支持下述数组的形式
			  //数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
			  ,pass: [
			    /^[\S]{6,12}$/
			    ,'密码必须6到12位，且不能出现空格'
			  ],
			  bankCardId: [
				/(^\d{18}$)/  //正则表达式
				,'卡号只能18位数'  //提示信息
			　] 
			}); 
		  
		  //监听提交
		  form.on('submit(formDemo)', function(data){
			  var smsCode=$("#smsCode").val();
			  var yzm=$("#yzm").val();
			  if(yzm!=smsCode){
				  layer.msg('验证码不一致', {icon: 2}); 
				  return false;
			  }
			  $.ajax({
					type:"post",
					url:"/AjaxDeleteBankCardIdServlet",
					data:$("#addGoodsForm").serialize(),
					success:function(result){
						if(result=="销户成功"){
							layer.msg('销户成功<br>是什么原因让你销户的呢？', {
						        time: 20000, //20s后自动关闭
						        btn: ['不好用','因为不常用','都不是']
						      });
						}else if(result=="电话号码不一致"){
							layer.msg('请跟注册的电话号码一致',{icon:2});
						}
						else{
							layer.msg('没有此银行卡号和姓名请重新输入',{icon:2});
						}
					},
					 error:function(e){
				            layer.msg('提交失败',{icon:2})
				     },
				});
			  $("#addGoodsForm")[0].reset();
              layui.form.render();
		    return false;
		});
	});
	</script>
</head>

<body>
	<header>
	<div class="header_div">

		<ul>
			<li><a href="wanzehao/index.jsp">网站首页</a></li>
			<li>｜</li>
			<li><a href="javascript:void(0)">网点查询</a></li>
		</ul>
		<div class="search">

			<input type="text" placeholder="请输入关键字" size="10"> <input
				type="button">

		</div>
	</div>
	</div>
	</header>

	<div class="title">
		<ul>
			<li><img src="/guopeng/img/郭氏银行.png" width="198" height="50"></li>
			<li>
				<p>|</p></li>
			<li>
				<p>个人网上银行——销户</p></li>
		</ul>



	</div>
	<div
		style="width: 50% ;height: 50%; margin: 0 auto; margin-top: 1% ; border: 1px solid #ccc; background-color: white;line-height: 20px;">
		<form class="layui-form" action="" style="margin-top: 80px;"
			id="addGoodsForm">
			<input type="hidden" id="smsCode" name="smsCode" value=""/>
			<div class="layui-form-item">
				<label class="layui-form-label" style="width: 250px;">请输入姓名:</label>
				<div class="layui-input-block">
					<input type="text" maxlength="6" style="width: 250px;" id="userName" name="userName" required
						lay-verify="username" placeholder="请输入姓名" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label" style="width: 250px;">请输入银行卡号:</label>
				<div class="layui-input-block">
					<input type="text" maxlength="18" style="width: 250px;" id="bankCardId" name="bankCardId" required
						lay-verify="bankCardId" placeholder="请输入银行卡号" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label" style="width: 250px;">请输入预留手机号:</label>
				<div class="layui-input-block">
					<input type="text" maxlength="11" style="width: 250px;" name="phone"
						style="width: 250px;" required lay-verify="phone"
						placeholder="请输入预留手机号"  id="phone" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label" style="width: 250px;">请输入验证码:</label>
				<div class="layui-input-inline" style="width: 110px;">
					<input type="text" maxlength="6" style="width: 110px;"id="yzm" name="yzm" required
						lay-verify="number" placeholder="请输入验证码" autocomplete="off"
						class="layui-input">

				</div>
				<div class="layui-input-inline">
					<button type="button" id="sms" class="layui-btn layui-btn-normal"
						style="width: 130px;">点击获取验证码</button>
				</div>
			</div>
			<div class="layui-form-item">
				<div class="layui-input-block"
					style="width: 50%; margin: 0 auto;	margin-left:290px">
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
					<li><a href="javascript:void(0)">网站声明</a>
					<li>
					<li><a href="javascript:void(0)">|</a>
					<li>
					<li><a href="javascript:void(0)">网站地图</a>
					<li>
					<li><a href="javascript:void(0)">|</a>
					<li>
					<li><a href="javascript:void(0)">联系我们</a>
					<li>
					<li><a href="javascript:void(0)">|</a>
					<li>
					<li><a href="javascript:void(0)">客服热线：<span class="span">666666</span>
					</a>
					<li>
				</ul>
				<ul>
					<li><a href="javascript:void(0)">中国郭氏银行版权所有</a>
					</li>
					<li><a href="javascript:void(0)">|</a>
					</li>
					<li><a href="javascript:void(0)"><span class="a">京ICP备05049539</span>
					</a>
					</li>
				</ul>
			</div>
		</div>
		</footer>
	</div>
</body>
</html>
