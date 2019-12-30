<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
      <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <title>My JSP 'deposit.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="ie=edge">
        <link href="<%=path %>/css/header.css" rel="stylesheet">
        <link href="<%=path %>/css/footer.css" rel="stylesheet">
        <link href="<%=path %>/css/deposit.css" rel="stylesheet">
        <script src="<%=path %>/js/jquery-1.12.4.js"></script>
        <script src="<%=path %>/js/overall.js"></script>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmts"%>
        <script>
        var moneys="";
        var cardss="";
        var btns="";
        var loanid="";
        $(function(){
        
        $("#p").click(function(){
		
		$("#moveBar").css("display","none");
		
		})
        
        $("#buttonmm").click(function(){
    
        var pwd = $("#pwd").val();
        var json = {"cardid":cardss,"pwd":pwd};
        $.get("<%=path%>/IsPassServlet",json, function (result) {
         
	         if(result=="支付密码输入正确"){
	         	
					     var json = {"cards":cardss,"money":moneys,"loanid":loanid}
				       	 $.get("<%=path%>/MoneyServlet",json, function (result) {
						         if(result=="false"){
						         	alert("对不起！您的账户余额不足，无法返款！");							         
						         }else{							            
							             $.get("<%=path%>/addhkServlet",json, function (result) {

                                             $("#moveBar").css("display","none");
                                             alert(result);
                                             $(btns).attr({"value":"已还款","disabled":"disabled"});
							             })
						         }                                                
				         })
	         	
	         }else{
	        	alert("对不起你输入的密码错误");
	        	$("#pwd").val("");
	         }                                              
        })
        
        
        
        
       
        
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

        });


        pageInfo(1);

        function pageInfo(y){
            $("#divul").html(" ");
            $.get("<%=path%>/QueryLoanInfoServlet?pageNo="+y, function (results) {

                for(var i=0;i<results.resultList.length;i++){
                    var but="";
                    var  result=results.resultList[i];
                    if(result.is_loan==0){
                        but = "<input type='button' value='还款' onclick='huankuan(\""+result.allMoney+"\",\""+result.cards+"\",this,\""+result.loanId+"\")'>";
                    }else{
                        but = "<input type='button' value='已还款' disabled='disabled'>";
                    }
                    var temp= "<ul>"
                        +"<li>"+result.loanId+"</li>"
                        +"<li>"
                        +"<fmt:formatNumber value="3242342342" type="currency"/>"
                        +"</li>"
                        +"<li>"+result.cards+"</li>"
                        +"<li>"+result.loanDate+"</li>"
                        +"<li>"+result.allMoney+"</li>"
                        +"<li>"+but+"</li>"
                        +"</ul>";
                    $("#divul").append(temp);
                }
                $("#divul").append("<div id='page'></div>");
                var pageStr="";
                pageStr=pageStr+"<p style='display: inline-block;margin-left: 23%' align='left'>"
                    +"共"
                    +results.totalCount
                    +"条数据,当前页数：["
                    +results.pageNo
                    +"/"+results.totalPage+"]&nbsp;";

                var pageTemp1="";
                if(results.pageNo>1){
                    pageTemp1="<div onclick='pageInfo(1)'><a href='javascript:void(0);' >首页</a></div>"
                        +"<div onClick='pageInfo("+(results.pageNo-1)+")'><a href='javascript:void(0);' >上一页</a></div>";
                }else{
                    pageTemp1="<div style='background: darkkhaki;'><a href='javascript:void(0);' >首页</a></div>"
                        +"<div style='background: darkkhaki;'><a href='javascript:void(0);' >上一页</a></div>";
                }
                for(var i=1;i<=results.totalPage;i++){
                    if(i==results.pageNo){
                        pageTemp1=pageTemp1+"<div style='background: darkkhaki;'><a href='javascript:void(0);' >"+i+"</a></div>";
                    }else{
                        pageTemp1=pageTemp1+"<div onclick='pageInfo("+i+")'><a href='javascript:void(0);' >"+i+"</a></div>";
                    }

                }

                var pageTemp2="";
                if(results.pageNo<results.totalPage){
                    pageTemp2="<div onclick='pageInfo("+(results.pageNo+1)+")'><a href='javascript:void(0);' >下一页</a></div>"
                        +"<div onClick='pageInfo("+results.totalPage+")'><a href='javascript:void(0);' >末页</a></div>";
                }else{
                    pageTemp2="<div style='background: darkkhaki;'><a href='javascript:void(0);' >下一页</a></div>"
                        +"<div style='background: darkkhaki;'><a href='javascript:void(0);' >末页</a></div>";
                }


                pageStr=pageStr+"</p>";
                $("#page").append(pageStr+pageTemp1+pageTemp2);
            },"json")

        }

        function huankuan(money,cards,btn,loanids){
       loanid=loanids;
       	moneys=money;
       	cardss=cards;
       	btns=btn;
       	var value = getMousePos(window.event);
       	$("#moveBar").css({"display":"inline-block","left":value.x-200,"top":value.y-50});
                      
        }

        function getMousePos(event) {
		    var e = event || window.event;
		    var scrollX = document.documentElement.scrollLeft || document.body.scrollLeft;
		    var scrollY = document.documentElement.scrollTop || document.body.scrollTop;
		    var x = e.pageX || e.clientX + scrollX;
		    var y = e.pageY || e.clientY + scrollY;
		    return { 'x': x, 'y': y };
		}
        </script>
        <title>存款</title>
    </head>
<style>
    #dkul1 li{
        display: inline-block;
        width:16%;
        height: 40px;
        font-size: 18px;
        font-weight: bold;
        text-align: center;

    }
    #dkul1{

        border-bottom: 1px solid #000000;
    }
    #divul ul{
    border-bottom: 1px solid;
    }
    #divul ul li{
        display: inline-block;
        width:16%;
        height: 100px;
        font-size: 18px;
        font-weight: bold;
        text-align: center;
        line-height: 100px;
    }
    #divul ul li input{
    height: 40px;
    width:100px;
    }
    #divul ul li input:hover{
    cursor: pointer;
    }
    #moveBar {

    z-index:999;
    display: inline-block;
    position: absolute;
    width: 400px;
    height: 100px;
    left:600px;
    top:180px;
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
    margin-left: 270px;
    height:40px;
    float:left;
    }
    #buttonmm{
    margin-top:10px;
    height: 30px;
    width:100px;
    }
    #page{
        margin-top: 20px;
    }
    #page div{
        cursor: pointer;
        margin-left: 10px;
        display: inline-block;
        height: 70px;
        width: 70px;
        line-height: 70px;
        text-align: center;
        border: 1px solid;
    }
    #page a{
        text-decoration: none;
    }
</style>
    <body>
    <div id="moveBar">
        <div id="banner"><img src="/img/zfmm.png"><span id="p">支付密码</span></div>
        <div id="content">
        <input type="password" id="pwd" placeholder="请输入支付密码" style="height:30px;width:300px"><input id="buttonmm" type="button" value="确定">
        </div>
    </div>
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

            <input type="text" placeholder="请输入关键字" size="15">
            <input type="button">

        </div>
    </div>
    </div>
</header>
<div class="title">
    <ul>
        <li>
            <img src="/img/cunzhu.png" width="198" height="50">
        </li>
        <li>
            <p>|</p>
        </li>
        <li>
            <p>个人网上银行——贷款业务查询</p>
        </li>
    </ul>

</div>

	<ul id="dkul1">
		<li>序号</li>
		<li>贷款金额</li>
		<li>贷款卡号</li>
		<li>贷款日期</li>
		<li>还款金额</li>
		<li>是否还款</li>
	</ul>
	<div id="divul">
		
	</div>
<footer>
    <div class="footer_div">
        <div class="service">
            <ul>
                <li>
                    <a href="javascript:void(0)">网站声明</a>
                </li>
                <li>
                    <a href="javascript:void(0)">|</a>
                </li>
                <li>
                    <a href="javascript:void(0)">网站地图</a>
                </li>
                <li>
                    <a href="javascript:void(0)">|</a>
                </li>
                <li>
                    <a href="javascript:void(0)"> 联系我们 </a>
                </li>
                <li>
                    <a href="javascript:void(0)">|</a>
                </li>
                <li>
                    <a href="javascript:void(0)">客服热线：<span>666666</span></a>
                </li>
            </ul>

            <ul>
                <li>
                    <a href="javascript:void(0)">中国郭式银行版权所有</a>
                </li>
                <li>
                    <a href="javascript:void(0)">|</a>
                </li>
                <li>
                    <a href="javascript:void(0)"><span>京ICP备01234567</span></a>
                </li>
            </ul>
        </div>
    </div>

</footer>


</body>
</html>
