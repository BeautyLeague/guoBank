<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <style>
   #ss{
   margin-left:450px;
   margin-top:30px;
   display: inline-block;
   }
      #as *:not(#ss){
        margin:100px 30px;
        
      }
      #as{
      border-top:1px solid;
      width:100%;
        margin-top:30px;
        height:60px;
      }
      #div11,#p:hover{
      cursor:pointer;
      }
      #moveBar {     
        z-index:999; 
        display: inline-block;
	    position: absolute;
	    width: 1110px;
	    height: 356px;
	    background: white;
	    color:#000;
	    border: solid 1px #000;
	    display:none;
	    }
	    #banner {
	    
	    background: #ddd;
	    cursor: move;
	    height: 40px;
	    line-height: 40px;
	    font-size: 18px;
	    font-weight: bold;
	    }
	    #banner img{
	    margin-left: 500px;
	    height:40px;
	    float:left;
	    }
	    #table{
	    font-weight: bold;
	    text-align: center;
	    }
   </style>
 
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link type="text/css" rel="stylesheet" href="/css/zhu/index.css"/>
  </head>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
  <body>
  <!--可移动的Div  -->
  <div id="moveBar">
        <div id="banner"><img src="/img/lxsm.png"><span id="p">利息说明</span></div>
        <div id="content">    
	        <table border="1" id="table">
			    <tr>
			        <td height="50" width="100">等级\年利率</td>
			        <%
			        	for(int i=1;i<=10;i++){
						    String td = "<td width='100'>"+i+"年</td>";
						    out.print(td);
					    }
			     	 %>
			        			        
			    </tr>			    
			    <%
			        	for(int i=1;i<=5;i++){
			        	double rate=0;
			        	double addrate=0;
			        	
			        	switch (i) {
						case 1:
							rate=5;
							addrate=0.2;
						break;
						case 2:
							rate=4.98;
							addrate=0.198;
						break;
						case 3:
							rate=4.96;
							addrate=0.196;
						break;
						case 4:
							rate=4.94;
							addrate=0.194;
						break;
						case 5:
							rate=4.92;
							addrate=0.192;
						break;
						}
			        	
						   out.print("<tr>");
						   out.print("<td height='50'>VIP"+i+"</td>");
						   DecimalFormat df = new DecimalFormat("#.000");
				        	for(int j=1;j<=10;j++){
				        	    String result=df.format(rate+(addrate*j));
							    out.print("<td>"+result+"%</td>");
							}
							out.print("</tr>");
					    }
			    %>
			</table>       
        </div>
    </div>
  
  
    <!--首页头部-->
		<div id="div1">
			
			<span>
			<img src="/img/one.png" id="img2"/>客服服务|
			<img src="/img/two.png" id="img3"/>119329
			</span>
			<div id="div2" style="width: 220px;">
				&nbsp;&nbsp;<a href="/mingzilongqueryUserinfoServlet"><img src="/img/three.png" id="img4"/></a>&nbsp;&nbsp;&nbsp;
				
				<c:if test="${sessionScope.uname==null }">
					<a href="/wanzehao/login.jsp">用户登录/注册</a>
					<a href="BackstageLogin.jsp">管理员登录/注册</a>

				</c:if>
				<c:if test="${sessionScope.uname!=null }">
					<a href="/mingzilongqueryUserinfoServlet">${sessionScope.uname }</a>
				</c:if>
				<a href="TuiChuServlet"><img src="/img/tuichu.png"  id="tuichu"/></a>
			</div>
			
			
			<div id="div3" style="margin-left: 230px;">
				<a href="#">郭氏集团|</a>
				<a href="#">国内分行|</a>
				<a href="#">关于本行</a>
			</div>
			
		</div>
		
		<div id="div4">
			<img src="/img/cunzhu.png" id="img1" style="height:70px" />
		
			
			<p>项目制作人：郭鹏&nbsp;&nbsp;&nbsp;&nbsp;&;nbsp杨昆&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;彭亮&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;闵子龙&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;万泽豪</p>
			
		</div>
		
		<!--首页--活动滚动-->
		<div id="div12">
			<img src="img/1.jpg" id="img5"/>
			<ul>
				<li style="background:#FFA500">1</li>
				<li>2</li>
				<li>3</li>
				<li>4</li>
				<li>5</li>
			</ul>
			<div class="arrowLeft"><</div><div class="arrowRight">></div>
		</div>
		
		<img src="/img/timg (2).gif" id="img6"/>
		
		
		<!--首页--主体-->
		<div id="div5">
			<div id="div6">
			<ul id="ul1">
				<li id="lione">银&nbsp;&nbsp;行&nbsp;&nbsp;卡&nbsp;&nbsp;管&nbsp;&nbsp;理</li>
				<li><a href="/guopeng/index01.jsp">银行卡开户</a></li>
				<li><a href="/guopeng/ReportLoss.jsp">银行卡挂失</a></li>
				<li><a href="/guopeng/SalesAccount.jsp">银行卡销户</a></li>
			</ul>
			</div>
			<div id="div7">
			<ul id="ul2">
				<li id="lione">资&nbsp;&nbsp;产&nbsp;&nbsp;管&nbsp;&nbsp;理</li>
				<li><a href="/deposit.html">存款</a></li>
				<li><a href="/takemoney.html">取款</a></li>
				<li><a href="/Trans.jsp">转账</a></li>
			</ul>
			</div>
			<div id="div8">
			<ul id="ul3">
				<li id="lione">业&nbsp;&nbsp;务&nbsp;&nbsp;查&nbsp;&nbsp;询</li>
				<li><a href="/Select.jsp">账户余额查询</a></li>
				<li><a href="/wanzehao/fail.jsp">贷款业务查询</a></li>
				<li><a href="/checkdetails.html">近期账单查询</a></li>
			</ul>
			</div>
			
			<div id="div9">
				<img src="/img/five.png" /><div id="div10"><a href="/wanzehao/information.jsp">贷款</a></div>
				<img src="/img/1D.png" id="img7"/>
				<div id="div11">利息说明</div>
			</div>
		</div>
		
		<!-- 底部样式 -->
	<div id="as">
<div id="ss">
      <a href="">网站声明</a>|<a href="">网站地图</a>|<a href="">联系我们</a>|<span>联系热线：<a style="color: coral">18170778835</a></span>
    <div style="margin-top: 10px;">
      <a href="">中国郭氏银行版权所有</a>|<a href="" style="color: coral  ">京ICP备05049539</a>
    </div>
</div>    
</div>
  </body>
  
 <script src="/js/jquery-1.12.4.js" type="text/javascript"></script>
 <script src="<%=path %>/js/overall.js"></script>
 <script>
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
 
 		$("#div11").click(function(){
		
			$("#moveBar").css({"display":"inline-block","left":"200px","top":"800px"});
			
		});
 
 </script>
<script type="text/javascript">
	var i =1;
	$(function()
	{	
	    $("#div12 ul li").mousemove(function()
		{
			i=$(this).html();

			$("#img5").attr("src","img/"+i+".jpg");
			$("#div12 li:nth-of-type("+i+")").css("background","#FFA500").siblings().css("background","#333");
		})

		
		$("#tuichu").mousemove(function()
		{
		
			$("#tuichu").css("cursor","pointer");
			$("#tuichu").attr("src","/img/tuichu1.png");
			
		}).mouseout(function()
		{
			$("#tuichu").attr("src","/img/tuichu.png");
		});
		
		
		$("#div12").mousemove(function()
		{
			$(".arrowLeft,.arrowRight").show();
		}).mouseout(function()
		{
			$(".arrowLeft,.arrowRight").hide();
		});
		
		$(".arrowRight").click(function()
		{
			if($("#div12 ul li").length==i)
			{
				i=1;
			}
			else
			{
			i++;
			}
			
			$("#img5").attr("src","img/"+i+".jpg");
			$("#div12 li:nth-of-type("+i+")").css("background","#FFA500").siblings().css("background","#333");
		});
		$(".arrowLeft").click(function()
		{
			if(1==i)
			{
				i=5;
			}
			else{
			i--;
			}
			
			$("#img5").attr("src","img/"+i+".jpg");
			$("#div12 li:nth-of-type("+i+")").css("background","#FFA500").siblings().css("background","#333");
		});
		
		 
	});		
	
	
			function show(){
				
					if(i==5){		
						i=1				
					}else{
						i++;
					}
				
					$("#img5").attr("src","img/"+i+".jpg");
					$("#div12 li:nth-of-type("+i+")").css("background","#FFA500").siblings().css("background","#333");
			}
			
 			setInterval("show()",3000);
</script>
</html>
