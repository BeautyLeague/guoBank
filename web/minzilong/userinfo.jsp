<%@page import="com.guobank.wanzehao.entity.UserInfo"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>编辑资料</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link href="/css/bank.css" rel="stylesheet"  type="text/css"/>
	<script src="/js/jquery-1.12.4.js" type="text/javascript"></script>
	  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<script src="/js/overall.js"></script>
	<script type="text/javascript">
	  function sss(){

		  $("#pathimg").submit();
	  }


	$(function(){
	
		$("#p").click(function(){
		
		$("#moveBar").css("display","none");
		
		})
		
    	//设置一个可以拖拽的div
        dragPanelMove("#banner","#moveBar");
        function dragPanelMove(downDiv,moveDiv){
            $(downDiv).mousedown(function (e) {
                    var isMove = true;
                    var div_x = e.pageX - $(moveDiv).offset().left;
                    var div_y = e.pageY - $(moveDiv).offset().top;
                    $(document).mousemove(function (e) {
                        if (isMove) {
                            var obj = $(moveDiv);
                            obj.css({"left":e.pageX - div_x, "top":e.pageY - div_y});
                        }
                    }).mouseup(
                        function () {
                        isMove = false;
                    });
            });

         }
		$("#vip").click(function(){
			var vip=$("#leven").val();
			if(vip==5){
			alert("您已经成为本银行最高等级用户了！无需升级！");
			return false;
			}
		    $("#moveBar").css("display","inline-block");
		
		})
		
		$("#buttonmm").click(function(){
			var json = {"pass":$("#pwd").val(),"money":$("#money").val(),"bank":$("#bank").val()}
			$.post("<%=path%>/YZpassServlet",json,function (result) {
				if(result=="支付密码输入错误"){
					alert("您输入的支付密码错误，请重新输入");
					$("#pwd").val();
				}else{
					$.post("<%=path%>/UpdateMoneyServlet",json,function (result) {
						if(result=="false"){
							alert("对不起！您的账户余额不足，无法升级！");
						}else{
							$.post("<%=path%>/addInfoServlet",json, function (result) {

								$("#moveBar").css("display","none");
								$("#leven").val(${sessionScope.user.leven+1});
								alert(result);

							})
						}
					})
				}
			})
		})


		
		$("#sub").on("click", function(){

			var userName =$("#userName").val();
			var pho=$("#pho").val();
			var id=$("#id").val();
			var date=$("#bornDate").val();
			var msg = /^\d{4}\-\d{2}\-\d{2}$/;
			var nn=/^[\u4e00-\u9fa5]{2,4}$/;
			if(userName==""){
				alert("请输入姓名");
				return false;
			}
			if(pho==""){
				alert("请输入电话号码");
				return false;
			}
			if(pho.length!=11){
				alert("电话号码必须是11位数");
				return false;
			}
			if(!msg.test(date)){
				alert("请输入正确的日期！！");
				return false;
			}
			$("#user").submit();
		  	alert("修改成功");
		})
	});
	

	</script>
	<style>
		.file {
			position: relative;
			display: inline-block;
			background: #D0EEFF;
			border: 1px solid #99D3F5;
			border-radius: 4px;
			padding: 4px 12px;
			overflow: hidden;
			color: #1E88C7;
			text-decoration: none;
			text-indent: 0;
			line-height: 20px;
		}
		.file input {
			position: absolute;
			font-size: 100px;
			right: 0;
			top: 0;
			opacity: 0;
		}
		.file:hover {
			background: #AADFFD;
			border-color: #78C3F3;
			color: #004974;
			text-decoration: none;
		}
	</style>
  </head>
  
  <body>
  <div id="moveBar">
        <div id="banner"><img src="/img/vip.png"><span id="p">升级VIP</span></div>
        <div id="content">
   			<span style="color:red;">备注：每升一级需要（100*等级）元，最高5级！！！</span>
			<input type="hidden" id="money" value="${sessionScope.user.leven*100}">
			<select id="bank" name="bank" style="margin-top:10px;height:30px;width:300px">
				<option value="0">--请选择支付卡号--</option>
				<c:forEach items="${bankList}" var="bank">
					<option value="${bank.bankCardId}">${bank.bankCardId}</option>
				</c:forEach>
			</select>

   			<input type="password" id="pwd" placeholder="请输入支付密码" style="margin-top:10px;height:30px;width:300px"><input id="buttonmm" style="height: 30px;width:100px; " type="button" value="确定">
        </div>
    </div>
    	<div class="title">
    <ul>
        <li>
            <img src="/img/bank.png" width="198" height="50">
        <li>
            <p>|</p>
        <li>
            <p>个人网上银行——用户编辑资料</p>
    </ul>
  </div>
		<div class="user" style="border-radius: 5%;height: 600px;" >
		<form id="pathimg" action="<%=path%>/UpdatePathServlet" method="post" enctype="multipart/form-data">
			<div style="width:500px;margin-left: 230px;">
				头像:<img src="${sessionScope.user.path}" style="margin-left:50px;width:100px;height:100px;border-radius: 50%;border: 1px solid;">
				<a href="javascript:;" class="file">上传头像
					<input type="file" name="path" onchange="sss()">
				</a>
			</div>
		</form>
		<form id="user" action="/mingzilongaddUserinfoServlet" method="post">
			<div id="kname">
			昵称:&nbsp;<input type="text" id="userName" name="userName" style="width: 264px; height:36px ;" value="${userinfo.userName}"/>
			<p id="name" style="display:inline-block"> </p>
			<br/>
	     </div>
	     <div id="ksex">
             <c:if test="${userinfo.sex=='男'||userinfo.sex==null}">
		          性别:&nbsp;<input type="radio"name="sex" value="男" checked="checked"/>男
		        <input type="radio"name="sex" value="女"/>女<br/>
		        </c:if>
		        <c:if test="${userinfo.sex=='女'}">
		          性别:&nbsp;<input type="radio"name="sex" value="男"/>男
		        <input type="radio"name="sex" value="女" checked="checked"/>女<br/>
		        </c:if>
		 </div>
		 <div id="kage">
		          年龄:&nbsp;<input type="number" min="1" name="age" style="width: 60px; height:36px;" value="${userinfo.age}"/><br/>
		</div>
		<div id="karade">
		   信誉等级:&nbsp;<input type="text" id="leven" name="leven" min="1"  max="5" style="width: 60px; height:36px;" value="${userinfo.leven}" readonly="readonly"/><input style="width: 70px; height:40px;margin-left: 20px;" type="button" id="vip" value="升级">
		 </div>
		 <div id="kphone">
		      手机号:&nbsp;<input type="tel"name="pho" id="pho" style="width: 215px; height:36px;" value="${userinfo.pho}" readonly="readonly"/><br/>
		</div>
		<div id="kdate">
		 	 出生年月:&nbsp;<input type="datetime" name="bornDate"  id="bornDate" style="width: 270px; height:36px;"value="${userinfo.bornDate}" /><br/>
		</div>
		 <div id="kbutton">
		<input type="button"  value="更  改" style="width: 70px; height:40px;" id="sub"/>
		<a href="/mingzilongCloseuserinfoServlet"><input type="button" value="取  消" style="width: 70px; height:40px;"/></a>
		  </div>

		  </form>
 		</div>
		<div id="as">
     <a href="">网站声明</a>|<a href="">网站地图</a>|<a href="">联系我们</a>|<span>联系热线：<a style="color: coral">18170778835</a></span>
	<div style="margin-top: 10px" >
      	<a href="">中国郭氏银行版权所有</a>|<a href="" style="color: coral ">京ICP备05049539</a>
	</div>
</div>
  </body>
</html>
