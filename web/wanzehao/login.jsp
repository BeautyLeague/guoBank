<%@ page language="java" import="java.util.*" pageEncoding="utf-8" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <style>
        * {
            padding: 0px;
            margin: 0px;
        }

        a, #btn, #p:hover {
            cursor: pointer;
        }

        #divhode:hover {
            cursor: pointer;
        }

        a {
            text-decoration: none;
        }

        li {
            list-style-type: none;
            display: inline-block;
        }

        .m-language * {
            display: inline-block;
            font-size: 12px;
            height: 12px;
        }

        #box * {
            display: inline-block;
        }

        #as * {
            margin: 100px 30px;
        }

        #as {

            margin-top: 30px;
        }

        #zc1 input {
            width: 300px;
            height: 30px;
            line-height: 30px;
            margin-top: 10px;
        }

        #zc1 input[type=button] {
            background-color: #3BBDA9;
            color: white;
            font-weight: bold;
        }

        #liss {
            margin: 15px;
        }

        #uls li {
            margin: 20px;
        }

        #uls li img {
            margin: 15px;
        }

        footer * {

            font-size: 12px;
        }

        #liss input {
            margin-top: 15px;
            width: 300px;
            height: 30px;
            line-height: 30px;
        }

        #liss input[type=button] {
            background-color: #3BBDA9;
            color: white;
            font-weight: bold;
        }

        #wjmm2 input {
            margin-top: 15px;
            width: 300px;
            height: 30px;
            line-height: 30px;
        }

        #wjmm2 input[type=button] {
            background-color: #3BBDA9;
            color: white;
            font-weight: bold;
        }

        #moveBar {

            z-index: 999;
            display: inline-block;
            position: absolute;
            width: 400px;
            height: 250px;
            left: 600px;
            top: 180px;
            background: white;
            color: #000;
            border: solid 1px #000;
            display: none;
        }

        #banner {

            background: #ddd;
            cursor: move;
            height: 40px;
            line-height: 40px;
            font-size: 18px;
            font-weight: bold;
        }

        #banner img {
            margin-left: 270px;
            height: 40px;
            float: left;
        }
    </style>
    <base href="<%=basePath%>">

    <title>登录</title>

    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <script src="/guopeng/layui/layui.js"></script>
    <!--
    <link rel="stylesheet" type="text/css" href="styles.css">
    -->

</head>

<body>
<div id="moveBar">
    <div id="banner"><img src="/img/wjmm.png"><span id="p">忘记密码？</span></div>
    <div id="content">
        <form action="" id="wjmm2" style="text-align: center">
            <input type="text" id="pho3" maxlength="11" placeholder="密保手机号">
            <input type="hidden" id="pho6" value="">
            <input type="text" id="wjmmyzm" placeholder="验证码" style="width:150px">
            <input type="hidden" id="yzm2" value="">
            <input type="button" value="获取验证码" id="btn4" style="width:150px;paging-top:5px;height:32px"><br>
            <input type="button" value="重置密码" id="but5">
        </form>

    </div>
</div>
<header>
    <div style="height: 3px;background-color: #3BBDA9">

    </div>
    <div style="height: 30px;background-color: #F7F7F7;">
        <div style="position: absolute;    left: 60%;">
            <ul class="m-language">

                <li>
                    <a href="wanzehao/index.jsp">网站首页</a>
                </li>
                |
                <li>
                    <a href="">网点查询</a>
                </li>
            </ul>

        </div>
    </div>

</header>

<div>

    <div style="height: 82px;background-color: #FFFFFF;margin-bottom: 10px;margin-left: 80px;">

        <a href="index.jsp"><img src="/img/cunzhu.png" style="height:70px;position: relative;top:30px;"></a>

    </div>

    <div style="height: 430px;">

        <img src="/img/banner.png">

        <div style="width: 330px;height: 360px ;background-color: white ;position: absolute; left: 59%;top:20%;">

            <div id="div20"
                 style="font-size: 20px;font-weight: bold;display: inline-block;border-bottom:2px #00D3C4 solid; line-height: 50px;width:150px;height:50px;margin:0px;margin-left:15px;text-align: center;">
                <a id="dl">登&nbsp;&nbsp;录</a></div>
            <div style="font-size: 20px;font-weight: bold;width:150px;height:50px;margin:0px; line-height: 50px;border-bottom:1px #DDDDDD solid;display: inline-block;text-align: center;" id="div21"><a id="zc">注&nbsp;&nbsp;册</a></div>

            <div id="divdl">
                <form action="" id="liss" style="text-align: center">
                    <input type="text" id="userName" placeholder="请输入手机号/身份证号">
                    <input type="password" id="password" placeholder="请输入6~15位密码"><br>
                    <input type="button" value="登录" id="btn">

                </form>

                <h4 id="divhode" style="margin-left: 20px;">忘记密码？</h4>
            </div>

            <div id="divzc" style="display:none;">
                <form action="" id="zc1" style="text-align: center">
                    <input type="text" id="uname" placeholder="请输入昵称">
                    <input type="text" id="cardId" placeholder="请输入身份证号码" maxlength="18">
                    <input type="password" id="password1" placeholder="请输入6~15密码"><br>
                    <input type="password" id="pwd" placeholder="确认密码"><br>
                    <input type="text" id="pho" name="phone" placeholder="请输入手机号" maxlength="11">
                    <input type="hidden" id="pho2" value=""><br>
                    <input type="text" id="is_ho" placeholder="验证码" style="width:150px">
                    <input type="button" value="获取验证码" id="btn3" style="width:150px;paging-top:5px;height:32px"><br>
                    <input type="button" value="注册" id="btn2">
                </form>
            </div>

        </div>
    </div>


</div>

<footer style="text-align: center; ">

    <div id="box" style="height: 70px;">
        <div>
            <hr style="width: 367px"/>
        </div>

        <div style="padding: 20px">
            <h2 style="font-size: 24px">用户服务</h2>
        </div>

        <div>
            <hr style="width: 367px"/>
        </div>
    </div>

    <div style="height: 165px;">
        <div style="width: 990px;height: 165px;background-color:white;position: absolute; left: 25%">

            <ul id="uls">

                <li><img src="/img/HKVFAXY%5BINC0UU7CE0NG6L9.png"><br><a href="">证书下载</a></li>
                <li><img src="/img/66$U%60C%5DRTTW%5DBUEIH8C97PL.png"><br><a href="/guopeng/QuestionList.jsp">问题大全</a></li>
                <li><img src="/img/H(8D$OA~Q902K3G8QPZ%25ESN.png"><br><a href="">登录</a></li>
                <li><img src="/img/}HU`A21X4~6ISIQ3V(}NX$W.png"><br><a href="/help.html">常见问题</a></li>
            </ul>

        </div>
    </div>

    <div>
        <hr/>
    </div>

    <div id="as">

        <a href="">网站声明</a>|<a href="">网站地图</a>|<a href="">联系我们</a>|<span>联系热线：<a
            style="color: coral">18170778835</a></span>


        <div style="margin-top: 10px">
            <a href="">中国郭氏银行版权所有</a>|<a href="" style="color: coral  ">京ICP备05049539</a>
        </div>
    </div>
</footer>
</body>

<script src="/js/jquery-1.12.4.js" type="text/javascript"></script>
<script src="<%=path %>/js/overall.js"></script>
<script type="text/javascript">

    $(function () {

        $("#p").click(function () {

            $("#moveBar").css("display", "none");

        })

        //设置一个可以拖拽的div
        dragPanelMove("#banner", "#moveBar");

        function dragPanelMove(downDiv, moveDiv) {
            $(downDiv).mousedown(function (e) {
                var isMove = true;
                var div_x = e.pageX - $(moveDiv).offset().left;
                var div_y = e.pageY - $(moveDiv).offset().top;
                $(document).mousemove(function (e) {
                    if (isMove) {
                        var obj = $(moveDiv);
                        obj.css({"left": e.pageX - div_x, "top": e.pageY - div_y});
                    }
                }).mouseup(
                    function () {
                        isMove = false;
                    });
            });

        }

        //单击注册时显示注册页面
        $("#zc").click(function () {
            $("#divdl").css("display", "none");
            $("#divzc").css("display", "inline-block");
            $("#div20").css("border-bottom", "1px #DDDDDD solid");
            $("#div21").css("border-bottom", "2px #00D3C4 solid");

        });

        //单击忘记密码重新定位页面
        $("#divhode").click(function () {

            $("#moveBar").css({"display": "inline-block", "left": "600px", "top": "180px"});

        });

        //单击登录时显示登陆页面
        $("#dl").click(function () {

            $("#divdl").css("display", "inline-block");
            $("#divzc").css("display", "none");
            $("#div20").css("border-bottom", "2px #00D3C4 solid");
            $("#div21").css("border-bottom", "1px #DDDDDD solid");
        });

        //单击登录根据输入的信息进行表单验证，然后经过ajax验证后转到主页面
        $("#btn").click(function () {

            var userName = $("#userName").val();
            var password = $("#password").val();
            //判断输入的是否是中文的正则表达式
            var Name = /[\u4E00-\u9FA5]/g;

            if (Name.test(userName) == true) {
                alert("不能输入中文");
                return false;
            }
            if (userName == "") {
                alert("请输入账号！！！");
                return false;
            }
            if (password == "") {
                alert("请输入密码！！！");
                return false;
            }


            $.ajax({
                type: "get",
                url: "<%=path%>/AjaxLoginServlet",
                data: {"username": userName, "password": password},
                dataType: "text",
                success: function (result) {
                    alert(result);
                    if (result == "登录成功") {
                        //如果登录成功则跳转主页面
                        window.location = "/wanzehao/index.jsp";
                    }
                },
                error: function (err) {
                    alert(err);
                }

            })
        });

        //注册提交
        $("#btn2").click(function () {
            var isho = $("#is_ho").val();
            var yzm = $("#yzm").val();
            var uname = $("#uname").val();
            var password = $("#password1").val();
            var pwd = $("#pwd").val();
            var pho = $("#pho").val();
            var pho2 = $("#pho2").val();
            var cardId = $("#cardId").val();
            var Name = /[\u4E00-\u9FA5]/g;

            if (uname == "") {
                alert("请输入昵称！！！");
                return false;
            }
            if (cardId == "") {
                alert("请输入身份证号码！！！");
                return false;
            }
            if (cardId.length!=18) {
                alert("身份证必须输入18位数！！！");
                return false;
            }
            if (password == "") {
                alert("请输入密码！！！");
                return false;
            }
            if(password.length<6){
                alert("请输入6~15密码！！！");
                return false;
            }
            if(password.length>15){
                alert("请输入6~15密码！！！");
                return false;
            }
            if (pwd == "") {
                alert("请确认密码！！！");
                return false;
            }
            if (password != pwd) {
                alert("两次输入的密码不同！！！");
                return false;
            }
            if (pho == "") {
                alert("请输入电话号码！！！");
                return false;
            }
            if (Name.test(pho) == true) {
                alert("电话号码不能输入中文");
                return false;
            }
            if (pho.length != 11) {
                alert("电话号码必须是11位数");
                return false;
            }
            if (pho2 != isho) {
                alert("验证码输入错误");
                return false;
            }
            if (pho2 == "失败") {
                alert("该手机号码已被注册");
                return false;
            }

            $.ajax({
                type: "post",
                url: "<%=path%>/AjaxAddUserInfoServlet",
                data: {"uname": uname, "pwd": pwd, "pho": pho,"cardId":cardId},
                dataType: "text",
                success: function (result) {
                    alert(result)
                    if (result == "注册成功") {
                        window.location = "wanzehao/login.jsp";
                    }
                },
                error: function (err) {
                    alert(err);
                }

            })
        });


    });
    //设置计算器变量
    var realTimeClData = null;
    var realTimeClDatas = null;
    //单击获取验证码按钮进行电话号码表单验证后发送验证码到手机上
    $("#btn3").click(function () {


        var pho = $("#pho").val();
        var Name = /[\u4E00-\u9FA5]/g;


        if (pho == "") {
            alert("请输入电话号码！！！");
            return false;
        }
        if (Name.test(pho) == true) {
            alert("电话号码不能输入中文");
            return false;
        }
        if (pho.length != 11) {
            alert("电话号码必须是11位数");
            return false;
        }
        //判断手机号是否被注册
        $.ajax({
            type: "get",
            url: "<%=path%>/AjaxYZPhoServlet",
            data: {"pho": pho},
            dataType: "text",
            success: function (result) {
                $("#pho2").val(result);
            }
        })

        $.ajax({
            type: "post",
            url: "<%=path%>/SMSServlet",
            data: {"phone": pho},
            success: function (result) {
                if (result.length > 5) {
                    $("#pho2").val(result);
                }
                if (result == -41) {
                   alert("手机号不能为空！");
                }
            }
        })

        $("#btn3").css("background-color", "#D3D3D3");
        $("#btn3").css("color", "#000000");
        $("#btn3").attr("disabled", "disabled");
        $("#btn3").attr("value", "已发送(60s)");
        realTimeClDatas = setInterval("times()", 1000);
    });


    var s = 60;

    function times() {
        if (s == 0) {
           s = 60;
            $("#btn3").css("background-color", "#3BBDA9");
            $("#btn3").css("color", "white");
            $("#btn3").removeAttr("disabled");
            $("#btn3").attr("value", "获取验证码");
            clearInterval(realTimeClDatas);
            return false;
        }
        s--;
        $("#btn3").attr("value", "已发送(" + s + "s)")

    }

    //单击获取密码
    $("#but5").click(function () {

        var pho3 = $("#pho3").val();
        var pho = $("#pho6").val();
        var yzm = $("#yzm2").val();
        var mmyzm = $("#wjmmyzm").val();

        if (pho3 == "") {
            alert("请输入密保手机号");
            return false;
        }
        if (mmyzm == "") {
            alert("请输入验证码");
            return false;
        }
        if (190283 != mmyzm) {
            alert("验证码输入错误");
            return false;
        }
        if (pho == "成功") {
            alert("对不起，该号码没有注册过！无法获取密码");
            return false;
        }

        //获取密码的Ajax
        $.ajax({
            type: "get",
            url: "<%=path%>/AjaxGetPwdServlet",
            data: {"pho": pho3},
            dataType: "text",
            success: function (result) {
                alert(result);
                window.location="/wanzehao/login.jsp";
            }
        })


    })
    //单击获取验证码按钮进行电话号码表单验证后发送验证码到手机上
    $("#btn4").click(function () {

        var pho = $("#pho3").val();
        var Name = /[\u4E00-\u9FA5]/g;


        if (pho == "") {
            alert("请输入电话号码！！！");
            return false;
        }
        if (Name.test(pho) == true) {
            alert("电话号码不能输入中文");
            return false;
        }
        if (pho.length != 11) {
            alert("电话号码必须是11位数");
            return false;
        }

        //判断手机号是否被注册
        $.ajax({
            type: "get",
            url: "<%=path%>/AjaxYZPhoServlet",
            data: {"pho": pho},
            dataType: "text",
            success: function (result) {
                $("#pho6").val(result);
            }
        })


        $.ajax({
            type: "post",
            url: "<%=path%>/SMSServlet",
            data: {"pho": pho},
            success: function (result) {
                var layer = layui.layer;

                if (result.length > 5) {
                    $("#yzm2").val(result);

                }
                if (result == -41) {
                    layer.msg('手机号不能为空！', {icon: 2});
                }
            }
        })

        $("#btn4").css("background-color", "#D3D3D3");
        $("#btn4").css("color", "#000000");
        $("#btn4").attr("disabled", "disabled");
        $("#btn4").attr("value", "已发送(60s)");
        realTimeClData = setInterval("time()", 1000);
    });


    var i = 60;

    function time() {
        if (i == 0) {
            i = 60;
            $("#btn4").css("background-color", "#3BBDA9");
            $("#btn4").css("color", "white");
            $("#btn4").removeAttr("disabled");
            $("#btn4").attr("value", "获取验证码");
            clearInterval(realTimeClData);
            return false;
        }
        i--;
        $("#btn4").attr("value", "已发送(" + i + "s)")

    }
</script>
</html>
