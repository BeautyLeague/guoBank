<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/12/27
  Time: 12:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示管理员账号申请的用户信息</title>
    <link href="css/header.css" rel="stylesheet">
    <link href="css/footer.css" rel="stylesheet">
    <link href="css/backstage.css" rel="stylesheet">
    <script src="js/jquery-1.12.4.js"></script>
    <style>

        h1 {
            text-align: center;
        }

        table {
            text-align: center;
            margin: auto;
            width: 55%;
        }

        tr:first-child {
            background: rgb(65, 178, 243);
        }

        table .data:nth-of-type(odd) {
            background: rgb(6, 238, 255);
        }

        a {
            text-decoration: none;
        }
    </style>
</head>
<script>
    $(function () {
        $.post("SelectAdminServlet", function (result) {
            var elements;
            var user = "用户";
            var shen = "想注册成为管理员";
            for (var i = 0; i < result.length; i++) {
                var element = "<tr class='data'><td>" + user + "</td><td>" + result[i].adminEmail + "</td><td>" + shen + "</td><td><a href='javascript:void(0)'  adminEmail="+result.adminEmail+" >通过</a></td><td><a href='javascript:void(0)' onclick='adelete(this)' adminEmail="+result.adminEmail+" >否认</a></td></tr>";
                elements += element;
            }
            ;
            $("table").append(elements);

        }, "JSON");
    });

    function adelete(obj){
        var flag = confirm("是否否认此账号成为管理员用户","提示");
        if(flag){
            var adminEmail= $(obj).attr("adminEmail");
            $.post("DeleteServlet","adminEmail="+adminEmail,function(result){
                if(result === "false"){
                    alert("已经成功否定该账号成为管理员用户");
                    $(obj).parent().parent().remove();
                }else{
                    alert("否定失败失败");
                }
            });
        }
    };
</script>
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

            <input type="text" placeholder="请输入关键字" size="15">
            <input type="button">

        </div>
    </div>

</header>

<div class="title">
    <ul>
        <li>
            <img src="img/guobank.png" width="198" height="50">
        </li>
        <li>
            <p>|</p>
        </li>
        <li>
            <p>管理用户信息</p>
        </li>
    </ul>
</div>
<h1>申请管理员账号信息</h1>
<table class="tab">
</br>
    <tr>

    </tr>

</table>


<footer>
    <div class="footer_div">
        <hr>
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
