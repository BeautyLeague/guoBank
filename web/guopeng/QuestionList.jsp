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

<title>问题大全</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="/guopeng/css/ReportLoss.css">
<!-- 头部 -->
<link href="/guopeng/css/deposit.css" rel="stylesheet">
<!-- 主体部 -->
<link rel="stylesheet" type="text/css" href="/guopeng/css/header.css">
<!-- 底部 -->
<link type="text/css" href="/guopeng/css/content.css" rel="stylesheet">
<script type="text/javascript" src="<%=path%>/js/jquery-1.12.4.js"></script>
</head>
	<script type="text/javascript">
        $(function(){
            $(".main_left li").on("click",function(){
                var address =$(this).attr("data-src");
                $("iframe").attr("src",address);
            });
        });
    </script>
<body>
	<header>
	<div class="header_div">

		<ul>
			<li><a href="javascript:void(0)">网站首页</a>
			</li>
			<li>｜</li>
			<li><a href="javascript:void(0)">网点查询</a>
			</li>
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
			<li><img src="img/guobank.png" width="198" height="50">
			</li>
			<li>
				<p>|</p>
			</li>
			<li>
				<p>问题大全</p>
			</li>
		</ul>
	</div>
	<div class="content_ul">
	<div class="main_left">
            <ul>
                <li data-src="guopeng/roadlist.html" style="color: #f9f6f6; line-height: 100px;font-size:25px;text-align:center;">转账汇款</li>
                <li data-src="guopeng/Batch.html"style="color: #f9f6f6; line-height: 100px;font-size:25px;text-align:center;">批量业务</li>
                <li data-src="guopeng/vip.html"style="color: #f9f6f6; line-height: 100px;font-size:25px;text-align:center;">会员中心</li>
                <li data-src="guopeng/userInfo.html" style="color: #f9f6f6; line-height: 100px;font-size:25px;text-align:center;">用户信息</li>
                <li data-src="guopeng/eTicket.html"style="color: #f9f6f6; line-height: 100px;font-size:25px;text-align:center;">电子票据</li>
                <li data-src="guopeng/userService.html"style="color: #f9f6f6; line-height: 100px;font-size:25px;text-align:center;">账号服务</li>
                <li data-src="guopeng/openHelp.html"style="color: #f9f6f6; line-height: 100px;font-size:25px;text-align:center;">开户帮助</li>
            </ul>
    </div>
     <div class="main_right">
            <iframe frameborder="0" scrolling="yes" style="width:80%;height:100%" src="guopeng/roadlist.html" id="aa"></iframe>
    </div>
	</div>


	<div class="footer_div">
		<footer>
		<div class="bottom">
			<hr>
			<div class="div_ul">
				<ul class="footer_ul li">
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
				<ul class="footer_ul li">
					<li><a href="javascript:void(0)">中国郭氏银行版权所有</a></li>
					<li><a href="javascript:void(0)">|</a></li>
					<li><a href="javascript:void(0)"><span class="a">京ICP备05049539</span>
					</a></li>
				</ul>
			</div>
		</div>
		</footer>
	</div>
</body>
</html>
