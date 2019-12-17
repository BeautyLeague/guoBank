<%@page import="com.guobank.minzilong.entity.Userinfo"%>
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
    <title>My JSP 'index.jsp' starting page</title>
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
	<script src="/js/overall.js"></script>
	<script type="text/javascript">
	  
	
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
	
		
		})


		
		$("#sub").on("click", function(){

			var userName =$("#userName").val();
			var pho=$("#pho").val();
			var id=$("#id").val();
			var date=$("#bornDate").val();
			var msg = /^\d{4}\-\d{2}\-\d{2}$/;
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
			if(id==""){
				alert("请输入身份证号码");
				return false;
			}
			if(id.length!=18){
				alert("身份证必须是18位数");
				return false;
			}
			if(!msg.test(date)) {
				alert("请输入正确的日期！！");
				return false;
			}
			$(this).submit();
		  	alert("修改成功");
		})
	});
	</script>
	
  </head>
  
  <body>
  <div id="moveBar">
        <div id="banner"><img src="/img/vip.png"><span id="p">升级VIP</span></div>
        <div id="content">
   			<span style="color:red;">备注：每升一级需要1000元，最高5级！！！</span>
   			<input type="text" id="pwd" placeholder="请输入支付密码" style="height:30px;width:300px"><input id="buttonmm" style="height: 30px;width:100px; " type="button" value="确定">
        </div>
    </div>  

    	<div class="title">
    <ul>
        <li>
            <img src="/img/bank.png" width="198" height="50">
        <li>
            <p>|</p>
        <li>
            <p>个人网上银行——用户信息</p>
    </ul>
  </div>
		<div class="user" >
		<form action="/mingzilongaddUserinfoServlet" method="get">
			<div id="kname">
			姓名:&nbsp;<input type="text" id="userName" name="userName" style="width: 264px; height:36px ;" value="${userinfo1.userName}"/>
			<p id="name" style="display:inline-block"> </p>
			<br/>
	     </div>
	    
	     <div id="ksex">
             <c:if test="${userinfo1.sex=='男'||userinfo1.sex==null}">
		          性别:&nbsp;<input type="radio"name="sex" value="男" checked="checked"/>男
		        <input type="radio"name="sex" value="女"/>女<br/>
		        </c:if>
		        <c:if test="${userinfo1.sex=='女'}">
		          性别:&nbsp;<input type="radio"name="sex" value="男"/>男
		        <input type="radio"name="sex" value="女" checked="checked"/>女<br/>
		        </c:if>
		 </div>
		 <div id="kage">
		          年龄:&nbsp;<input type="number" min="1" name="age" style="width: 60px; height:36px;" value="${userinfo1.age}"/><br/>
		</div>
		<div id="karade">
		   信誉等级:&nbsp;<input type="text" id="leven" name="leven" min="1"  max="5" style="width: 60px; height:36px;" value="${userinfo1.leven}" readonly="readonly"/><input style="width: 70px; height:40px;margin-left: 20px;" type="button" id="vip" value="升级">
		 </div>
		 <div id="kphone">
		      手机号:&nbsp;<input type="tel"name="pho" id="pho" style="width: 215px; height:36px;" value="${userinfo1.pho}" readonly="readonly"/><br/>
		</div>
		<div id="knumber">
		  身份证号:&nbsp;<input type="text" name="id"  id="id" style="width: 270px; height:36px;" value="${userinfo1.id}"/><br/>
		</div>
		<div id="kdate">
		  出生年月:&nbsp;<input type="datetime" name="bornDate"  id="bornDate" style="width: 270px; height:36px;"value="${userinfo1.bornDate}" /><br/>
		</div>
		<div id="kdate">
			用户密码:&nbsp;<input type="datetime" name="Pass"  id="Pass" style="width: 270px; height:36px;"value="${userinfo1.pwd}" /><br/>
		</div>
		 <div id="kbutton">
		<input type="submit" value="更  改" style="width: 70px; height:40px;" id="sub"/>
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
