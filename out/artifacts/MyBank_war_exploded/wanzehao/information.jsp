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

<title>My JSP 'deposit.jsp' starting page</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<style>
.button:hover {
	cursor: pointer;
}
</style>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<link href="/css/header.css" rel="stylesheet">
<link href="/css/footer.css" rel="stylesheet">
<link href="/css/deposit.css" rel="stylesheet">
<script src="/js/jquery-1.12.4.js"></script>
<script src="/js/overall.js"></script>

<script type="text/javascript">
	
	 function cardBlur() {
            var $obj = $("#bankcardId");
            if ($.trim($obj.val()).length === 0) {
                $obj.next().text("卡号不能为空");
                $obj.removeClass("inputOk");
                $obj.addClass("inputError");
                return false;
            } else if ($.trim($obj.val()).length !== 18) {
                $obj.next().text("卡号必须为18位");
                $obj.removeClass("inputOk");
                $obj.addClass("inputError");
                return false;
            } else {
            	var cardId =  $("#bankcardId").val();
             $.post("<%=path%>/YZCardIdServlet","bankCardId="+cardId+"",function(result){
           
            	if (result === "true") {
                        $obj.next().text("");
                        $obj.removeClass("inputError");
                        $obj.addClass("inputOk");
                        return true;
                    } else if(result==="false"){
                        $obj.next().text("该卡号不存在");
                        $obj.removeClass("inputOk");
                        $obj.addClass("inputError");
                        return false;
                    }else{ 	
                    	$obj.next().text("该卡号是借记卡");
                        $obj.removeClass("inputOk");
                        $obj.addClass("inputError");
                        return false;
                    }
            	})
            
            }
return true;
        }
        
        function moneyBlur() {
            var $obj = $("#money");
        if ($.trim($obj.val()).length === 0) {
            $obj.next().text("贷款金额不能为空");

        } else if (isNaN($.trim($obj.val()))) {
            $obj.next().text("请输入数子");
        } else if ($.trim($obj.val()) < 3000) {
            $obj.next().text("金额必须大于3000");
        } else {
            $obj.next().text("");
            $obj.removeClass("inputError");
            $obj.addClass("inputOk");
            return true;
        }
				return true;
        }
        
        
        function submit() {
        
        if(window.confirm('请问您是否确定贷款吗？')){
       
	       	if (cardBlur()&&moneyBlur()) {

				         var json = {"bankcardId":$.trim($("#bankcardId").val()),
				             "money": $.trim($("#money").val()),"loadDate":$.trim($("#DKDate").val())}

				         $.post("<%=path%>/loanMoneyServlet", json, function(result) {
							alert(result);
							window.location = "wanzehao/index.jsp";
						})
			}else{
			alert("请正确填写贷款信息！");
			}
		} 
		
	}
</script>

<title>网银贷款</title>
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

			<input type="text" placeholder="请输入关键字" size="15"> <input
				type="button">

		</div>
	</div>
	</div>
	</header>
	<div class="title">
		<ul>
			<li><img src="/img/cunzhu.png" width="198" height="50"></li>
			<li>
				<p>|</p></li>
			<li>
				<p>个人网上银行——网银贷款</p></li>
		</ul>

	</div>


	<div class="contene">
		<div class="form">
			<div class="card">
				<p>请输入贷款银行卡号:</p>
				<input id="bankcardId" type="text" size="30" onblur="cardBlur()">
				<span class="error_span"></span>
			</div>
			<div class="price">
				<p>请输入贷款金额:</p>
				<input id="money" type="text" size="30" onblur="moneyBlur()">
				<span class="error_span"></span>
			</div>
			<div class="pwd">
				<p>请选择贷款期限:</p>
				<select name="DKDate"
					style="width:222px;border:1px solid #6E6E6D;height:26px"
					id="DKDate">
					<option value="1">1年</option>
					<option value="2">2年</option>
					<option value="3">3年</option>
					<option value="4">4年</option>
					<option value="5">5年</option>
					<option value="6">6年</option>
					<option value="7">7年</option>
					<option value="8">8年</option>
					<option value="9">9年</option>
					<option value="10">10年</option>
				</select>
			</div>
			<div class="button">
				<input type="button" value="确认" onclick="submit()">

			</div>
		</div>
	</div>


	<footer>
	<div class="footer_div">
		<div class="service">
			<ul>
				<li><a href="javascript:void(0)">网站声明</a></li>
				<li><a href="javascript:void(0)">|</a></li>
				<li><a href="javascript:void(0)">网站地图</a></li>
				<li><a href="javascript:void(0)">|</a></li>
				<li><a href="javascript:void(0)"> 联系我们 </a></li>
				<li><a href="javascript:void(0)">|</a></li>
				<li><a href="javascript:void(0)">客服热线：<span>666666</span>
				</a></li>
			</ul>

			<ul>
				<li><a href="javascript:void(0)">中国郭式银行版权所有</a></li>
				<li><a href="javascript:void(0)">|</a></li>
				<li><a href="javascript:void(0)"><span>京ICP备01234567</span>
				</a></li>
			</ul>
		</div>
	</div>

	</footer>


</body>
</html>
