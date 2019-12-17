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

<title>银行卡户</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" type="text/css" href="/guopeng/css/ReportLoss.css">
<!-- 头部 -->
<link href="/guopeng/css/deposit.css" rel="stylesheet">
<!-- 头部 -->
<link rel="stylesheet" type="text/css" href="/guopeng/css/header.css">
<!-- 底部 -->
<link rel="stylesheet" href="/guopeng/layui/css/layui.css">
<script src="/guopeng/js/jquery-1.11.0.min.js" type="text/javascript"></script>
<script src="/guopeng/layui/layui.js"></script>
<script>
	//Demo
	layui.use(['form','jquery','layer'], function() {
		var form = layui.form;
		var $=layui.jquery;
		var layer=layui.layer;
		form.verify({
					username : function(value, item) { //value：表单的值、item：表单的DOM对象
						if (value == null || value == "") {
							return '用户名不能为空';
						}
						if (!new RegExp("^[a-zA-Z0-9_\u4e00-\u9fa5\\s·]+$")
								.test(value)) {
							return '用户名不能有特殊字符';
						}
						if (/(^\_)|(\__)|(\_+$)/.test(value)) {
							return '用户名首尾不能出现下划线\'_\'';
						}
						if (/^\d+\d+\d$/.test(value)) {
							return '用户名不能全为数字';
						}
					}
					//我们既支持上述函数式的方式，也支持下述数组的形式
					//数组的两个值分别代表：[正则匹配、匹配不符时的提示文字]
					,
					pass : [ /^[\S]{6}$/, '密码必须6位，且不能出现空格' ]
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
								layer.msg('手机号不能为空', {icon: 2}); 
							}
						}
					})
			  }else{
				  layer.msg('手机号不能为空', {icon: 2}); 
			  }
				
		  })
		

		//监听提交
		form.on('submit(formDemo)', function(data) {
				var password=$("#password").val();
				var repwd=$("#repwd").val();
				var yzm=$("#yzm").val();
				var monery=$("#monery").val();
				var type = $("#select option:selected") .val();
				var typename = $("#selectname option:selected") .val();
				var smsCode=$("#smsCode").val();
				if(password!=repwd){
					layer.msg('支付密码和确认支付密码不一致',{icon:2});
					return false;
				}
				
				if(yzm!=smsCode){
					layer.msg('验证码不一致',{icon:2});
					return false;
				}
				//执行开户
				$.ajax({
					type:"post",
					url:"<%=path%>/AjaxInsertOpenAccount",
					data:$("#addGoodsForm").serialize(),
					dataType:"json",
					success:function(result){
						layer.msg('开户成功<br>欢迎加入郭氏银行大家庭<br>您的卡号:'+result+'<br>请您妥善保管。', {
					        time: 20000, //20s后自动关闭
					        btn: ['好的','知道了','关闭']
					      });
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
				<p>个人网上银行——开户</p>
			</li>
		</ul>

	</div>
	<div
		style="width: 50% ;height: 65%; margin: 0 auto; margin-top: 1% ; border: 1px solid #ccc; background-color: white;line-height: 20px;">
		<form class="layui-form" action="" style="margin-top: 80px;"
			id="addGoodsForm">
			<div class="layui-form-item">
				<label class="layui-form-label" style="width: 250px;font-size: 20px;">请输入预留手机号:</label>
				<div class="layui-input-block">
					<input type="text" style="width: 250px;" name="phone"
						style="width: 250px;font-size: 20px;" required lay-verify="phone"
						placeholder="请输入预留手机号" id="phone" autocomplete="off" maxlength="11" class="layui-input">
				</div>
			</div>
			<input type="hidden" id="smsCode" name="smsCode" value=""/>
			<div class="layui-form-item">
				<label class="layui-form-label" style="width: 250px;font-size: 20px;">请输入支付密码:</label>
				<div class="layui-input-block">
					<input type="password" style="width: 250px;font-size: 20px;" id="password" name="password" required
						lay-verify="pass" placeholder="请输入支付密码" maxlength="6" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label" style="width: 250px;font-size: 20px;">请输入确认支付密码:</label>
				<div class="layui-input-block">
					<input type="password" style="width: 250px;font-size: 20px;" id="repwd" name="repwd" required
						lay-verify="pass" placeholder="请输入确认支付密码" maxlength="6" autocomplete="off"
						class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label" style="width: 250px;font-size: 20px;">请输入验证码:</label>
				<div class="layui-input-inline" style="width: 110px;font-size: 15px;">
					<input type="text" style="width: 110px;font-size: 15px;" id="yzm"name="yzm" required
						lay-verify="number" placeholder="请输入验证码" maxlength="6" autocomplete="off"
						class="layui-input">

				</div>
				<div class="layui-input-inline">
					<button type="button" id="sms" class="layui-btn layui-btn-normal"
						style="width: 130px;font-size: 15px;">点击获取验证码</button>
				</div>
				</div>
			<div class="layui-form-item">
				<label class="layui-form-label" style="width: 250px;font-size: 20px;">请输入开户金额:</label>
				<div class="layui-input-block">
					<input type="text" style="width: 250px;" name="monery"
						style="width: 250px;font-size: 20px;" required 
						placeholder="请输入开户金额" id="monery" autocomplete="off" maxlength="8" class="layui-input">
				</div>
			</div>
				
				<div class="layui-form-item">
					<label class="layui-form-label" style="width: 250px;font-size: 20px;">开户银行卡类型</label>
					<div class="layui-input-inline" style="width: 250px;font-size: 20px;">
						<select name="cardTypeId" id="select" lay-filter="aihao">
						 	<option value="" select="">请选择</option>
							<option value="1">储存卡</option>
							<option value="2">准贷记卡</option>
							<option value="3">贷记卡</option>
						</select>
					</div>
				</div>
				<div class="layui-form-item">
					<label class="layui-form-label" style="width: 250px;font-size: 20px;">开户地址</label>
					<div class="layui-input-inline" style="width: 250px;font-size: 20px;" >
						<select name="address" id="selectname" lay-filter="aihao">
							<option value="" select="">请选择</option>
							<option value="南昌总行">南昌分行</option>
							<option value="赣州分行">赣州分行</option>
							<option value="上海分行">上海分行</option>
							<option value="石城分行">石城分行</option>
							<option value="宁都总行">宁都总行</option>
							<option value="兴国分行">兴国分行</option>
						</select>
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
