<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/1
  Time: 15:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="css/TransferAccounts.css" rel="stylesheet" type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">

<head>
    <title>转账</title>
    <script src="js/jquery-1.12.4.js"></script>
    <script type="text/javascript">

        !function (e, t, a) {
            function r() {
                for (var e = 0; e < s.length; e++) s[e].alpha <= 0 ? (t.body.removeChild(s[e].el), s.splice(e, 1)) : (s[e].y--, s[e].scale += .004, s[e].alpha -= .013, s[e].el.style.cssText = "left:" + s[e].x + "px;top:" + s[e].y + "px;opacity:" + s[e].alpha + ";transform:scale(" + s[e].scale + "," + s[e].scale + ") rotate(45deg);background:" + s[e].color + ";z-index:99999");
                requestAnimationFrame(r)
            }

            function n() {
                var t = "function" == typeof e.onclick && e.onclick;
                e.onclick = function (e) {
                    t && t(), o(e)
                }
            }

            function o(e) {
                var a = t.createElement("div");
                a.className = "heart", s.push({
                    el: a,
                    x: e.clientX - 5,
                    y: e.clientY - 5,
                    scale: 1,
                    alpha: 1,
                    color: c()
                }), t.body.appendChild(a)
            }

            function i(e) {
                var a = t.createElement("style");
                a.type = "text/css";
                try {
                    a.appendChild(t.createTextNode(e))
                } catch (t) {
                    a.styleSheet.cssText = e
                }
                t.getElementsByTagName("head")[0].appendChild(a)
            }

            function c() {
                return "rgb(" + ~~(255 * Math.random()) + "," + ~~(255 * Math.random()) + "," + ~~(255 * Math.random()) + ")"
            }

            var s = [];
            e.requestAnimationFrame = e.requestAnimationFrame || e.webkitRequestAnimationFrame || e.mozRequestAnimationFrame || e.oRequestAnimationFrame || e.msRequestAnimationFrame || function (e) {
                setTimeout(e, 1e3 / 60)
            }, i(".heart{width: 10px;height: 10px;position: fixed;background: #f00;transform: rotate(45deg);-webkit-transform: rotate(45deg);-moz-transform: rotate(45deg);}.heart:after,.heart:before{content: '';width: inherit;height: inherit;background: inherit;border-radius: 50%;-webkit-border-radius: 50%;-moz-border-radius: 50%;position: fixed;}.heart:after{top: -5px;}.heart:before{left: -5px;}"), n(), r()
        }(window, document);

    </script>


    <script>
        var pattern = /(^\d{16,18}$)/;

        //判断卡号
        function ka() {
            if (document.getElementById("ka").value == "") {

                document.getElementById("ka_error").innerText = "账号不能为空";
                return false;
            } else if (!pattern.test(document.getElementById("ka").value)) {
                document.getElementById("ka_error").innerText = "账号必须是16~18位";
                return false;
            }  else if (document.getElementById("ka").value == document.getElementById("card").value) {
                document.getElementById("kahao_error").innerText = "两个卡号不能一致";
                document.getElementById("ka_error").innerText = "两个卡号不能一致";
                return  false;
            }else {
                $.post("/SelectBankIdServlet", 'card=' + document.getElementById("ka").value, function (result) {
                    if (result === "false") {
                        document.getElementById("ka_error").innerText = "转账的银行卡不存在";
                        return  false;
                    } else {
                        document.getElementById("ka_error").innerText = "";
                        return  true;
                    }
                })
                return true;
            }
        }

        //判断密码
        function pwd() {
            if (document.getElementById("pwd").value == "") {
                document.getElementById("pwd_error").innerText = "密码不为空";
                return false;

            } else if (!parseFloat(document.getElementById("pwd").value)) {
                document.getElementById("pwd_error").innerText = "密码必须为数字";
                return false;
            } else if (document.getElementById("pwd").value.length != 6) {
                document.getElementById("pwd_error").innerText = "密码必须为六位数";
                return false;
            }else{
                document.getElementById("pwd_error").innerText = "";
                return true;
            }
        }

        //判断输入金额格式
        function moneys() {
            if (document.getElementById("money").value <= 0) {
                document.getElementById("qian_error").innerText = "转账金额必须大于零";
                return false;

            } else if (!parseFloat(document.getElementById("money").value)) {
                document.getElementById("qian_error").innerText = "钱只能为数字";
                return false;

            } else {
                document.getElementById("qian_error").innerText = "";
                return true;
            }
        }

        //判断收账卡号格式
        function kahaoBlur() {

            if (document.getElementById("card").value == "") {
                document.getElementById("kahao_error").innerText = "收账卡号不能为空";
                return false;

            } else if (!pattern.test(document.getElementById("card").value)) {
                document.getElementById("kahao_error").innerText = "收账卡号必须是16~18位";
                return false;

            }  else if (document.getElementById("ka").value == document.getElementById("card").value) {
                document.getElementById("kahao_error").innerText = "两个卡号不能一致";
                document.getElementById("ka_error").innerText = "两个卡号不能一致";
                return false;
            }
            else {
                $.post("/BankIdsServlet", 'card=' + document.getElementById("card").value, function (result) {

                    if (result === "false") {
                        document.getElementById("kahao_error").innerText = "收账银行卡不存在";
                        return false;
                    } else  {
                        document.getElementById("kahao_error").innerText = "";
                        return true;
                    }

                })
                return  true;
            }
        }


        //判断备注
        function transInfo() {
            if (document.getElementById("transInfos").value == "") {
                document.getElementById("trans_error").innerText = "转账备注不能为空";
                return false;

            }else {
                document.getElementById("trans_error").innerText = "";
                return true;
            }
        }


        function konfocus(kas) {
            if (kas.value == "请输入您的卡号") {
                kas.value = "";
            }
        }

        function ponfocus(pwd) {
            if (pwd.value == "请输入您的密码") {
                pwd.value = "";
            }
        }

        function jonfocus(money) {
            if (money.value == "请输入转账金额") {
                money.value = "";
            }
        }

        function kanfocus(ka) {
            if (ka.value == "请输入收账的卡号") {
                ka.value = "";
            }
        }

        function transFoucs(trans) {
            if (trans.value == "请输入你的备注") {
                trans.value = "";
            }
        }

    </script>
</head>

<body>

<script language="JavaScript">
    yourLogo = '页面转账';
    logoFont = 'Arial';
    logoSize = 1; // 1-7 only! for larger font sizes alter logoWidth/Height accordingly!
    logoColor = '811188';
    logoWidth = 70;
    logoHeight = 70;
    logoSpeed = 0.03;


    //Nothing needs altering below!
    yourLogo = yourLogo.split('');
    L = yourLogo.length;
    Result = "<font face=" + logoFont + " size=" + logoSize + " color=" + logoColor + ">";
    TrigSplit = 360 / L;
    br = (document.layers) ? 1 : 0;
    if (br) {
        for (i = 0; i < L; i++)
            document.write('<layer name="ns' + i + '" top=0 left=0 width=14 height=14">' + Result + yourLogo[i] + '</layer>');
    } else {
        document.write('<div id="outer" style="position:absolute;top:0px;left:0px"><div style="position:relative">');
        for (i = 0; i < L; i++)
            document.write('<div id="ie" style="position:absolute;top:0px;left:0px;width:14px;height:14px">' + Result + yourLogo[i] + '</div>');
        document.write('</div></div>');
    }
    ypos = 0;
    xpos = 0;
    step = logoSpeed;
    currStep = 0;
    Y = new Array();
    X = new Array();
    Yn = new Array();
    Xn = new Array();
    for (i = 0; i < L; i++) {
        Yn[i] = 0;
        Xn[i] = 0;
    }
    (document.layers) ? window.captureEvents(Event.MOUSEMOVE) : 0;

    function Mouse(evnt) {
        ypos = (document.layers) ? evnt.pageY : event.y;
        xpos = (document.layers) ? evnt.pageX : event.x;
    }

    (document.layers) ? window.onMouseMove = Mouse : document.onmousemove = Mouse;

    function animateLogo() {
        if (!br) outer.style.pixelTop = document.body.scrollTop;
        for (i = 0; i < L; i++) {
            var layer = (document.layers) ? document.layers['ns' + i] : ie[i].style;
            layer.top = Y[i] + logoHeight * Math.sin(currStep + i * TrigSplit * Math.PI / 180);
            layer.left = X[i] + logoWidth * Math.cos(currStep + i * TrigSplit * Math.PI / 180);
        }
        currStep -= step;
    }

    function Delay() {
        for (i = L; i >= 0; i--) {
            Y[i] = Yn[i] += (ypos - Yn[i]) * (0.1 + i / L);
            X[i] = Xn[i] += (xpos - Xn[i]) * (0.1 + i / L);
        }
        animateLogo();
        setTimeout('Delay()', 30);
    }

    window.onload = Delay;
</script>

<script language="JavaScript">
    function kaa() {
        if (document.getElementById("ka").value == document.getElementById("card").value) {
            document.getElementById("kahao_error").innerText = "两个卡号不能一致";
            document.getElementById("ka_error").innerText = "两个卡号不能一致";
        }else if(ka() && pwd() && moneys() && kahaoBlur() && transInfo()  ){

            var json = {
                'ka': "" + document.getElementById("ka").value + "",
                'pwd': "" + document.getElementById("pwd").value + "",
                'card': "" + document.getElementById("card").value + "",
                'money': "" + document.getElementById("money").value + ""

            };

            $.post("/TransMoneyServlet", json, function (result) {
                if(result!="密码错误" && result!="卡号"+document.getElementById("ka").value+"已挂失，无法进行转账" &&result!="卡号"+document.getElementById("card").value+"已挂失，无法进行转账" && result!="金额不足"){
                   alert("卡号"+document.getElementById("ka").value+"向卡号"+document.getElementById("card").value+"转出金额"+document.getElementById("money").value)
                    Add();
                }else if(result=="密码错误"){
                    alert(result);
                }else if(result=="金额不足")
                {
                    alert(result);
                }else{
                    alert(result);
                }
            });

            document.getElementById("kahao_error").innerText = "";
            document.getElementById("ka_error").innerText = "";
        }

    }


    function Add() {
        var jsons = {
            'ka': "" + document.getElementById("ka").value + "",
            'card': "" + document.getElementById("card").value + "",
            'money': "" + document.getElementById("money").value + "",
            'transInfos': "" + document.getElementById("transInfos").value + "",
        }
        $.post("/AddServlet", jsons, function (result) {
            alert(result);
        })
    }

    //清空
    function clears() {
        document.getElementById("money").value="";
        document.getElementById("card").value="";
        document.getElementById("ka").value="";
        document.getElementById("transInfos").value="";
        document.getElementById("pwd").value="";
    }

</script>
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
            <img src="img/bank.png" width="198" height="50">

        <li>
            <p>|</p>
        <li>
            <p>个人网上银行——转账</p>
    </ul>

</div>
<div class="content">
    <div class="form">

        <div class="kahao">
            <p>转账卡号:</p>
            <i class="kas"></i>
            <input type="text" value="请输入您的卡号" class="katu" id="ka" onfocus="konfocus(this)" onblur="ka()"style="color: black">
            <span style="color: red;" id="ka_error"></span>
           </div>

        <div class="pwd">
            <p>支付密码:</p>
            <i class="pwds"></i>
            <input type="password" value="" class="ptu" id="pwd" onfocus="ponfocus(this)" onblur="pwd()"style="color: black">
            <span style="color: red" id="pwd_error"></span>
        </div>

        <div class="price">
            <p>转账金额:</p>
            <i class="prices"></i>
            <input type="pa" value="请输入转账金额" class="qtu" id="money" onfocus="jonfocus(this)" onblur="moneys()"style="color: black">
            <span style="color:red;" id="qian_error"></span>
        </div>

        <div class="bzkahao">
            <p>收账卡号:</p>
            <i class="z"></i>
            <input type="text" onblur="kahaoBlur()" value="请输入收账的卡号" onfocus="kanfocus(this)" class="ktu" id="card"style="color: black">
            <span style="color: red;" id="kahao_error"></span>
        </div>
        <div class="beizhu">
            <p>转账备注:</p>
            <i class="bei" ></i>
            <input type="text" style="width: 200px; color: black; height: 30px" id="transInfos"  value="请输入你的备注"  onblur="transInfo()" class="beitu"  onfocus="transFoucs(this)" >
            <span style="color: red;" id="trans_error"></span>
        </div>

        <div class="button">
            <input type="button" value="确认转账" onclick="kaa()">
            <input type="button" value="取消转账" onclick="clears()">
        </div>
    </div>

</div>
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
                    <a href="javascript:void(0)">中国农业银行版权所有</a>
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
