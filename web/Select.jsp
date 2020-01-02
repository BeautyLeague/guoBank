<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/11/5
  Time: 15:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link href="css/TransferAccounts.css" rel="stylesheet" type="text/css">
<link href="css/footer.css" rel="stylesheet" type="text/css">
<link href="css/header.css" rel="stylesheet" type="text/css">

<head>
    <title>查询</title>

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

        //判断银行卡格式
        var pattern = /(^\d{16,18}$)/;

        function kaBlur() {
            if (document.getElementById("card").value == "") {
                document.getElementById("ka_error").innerText = "卡号不能为空";
                document.getElementById("price").value="";
                document.getElementById("name").value="";
            } else if (!pattern.test(document.getElementById("card").value)) {
                document.getElementById("ka_error").innerText = "卡号必须是16~18位";
                document.getElementById("price").value="";
                document.getElementById("name").value="";
    ;
            } else {
                cc();
                document.getElementById("ka_error").innerText = "";
            }
        }
        function konfocus(kas) {
            if (kas.value == "请输入您的卡号") {
                kas.value = "";
            }
        }
        
        //清空
        function caler() {
            document.getElementById("price").value="";
            document.getElementById("card").value="";
            document.getElementById("name").value="";
        }
        

        function cc() {
            $.post("/SelectBankIdServlet", 'card=' + document.getElementById("card").value, function (result) {
                if (result === "true") {

                    $.post("/SelectServlet", 'card=' + document.getElementById("card").value, function (result) {
                        $("#price").val("" + result + "");
                    })

                    $.post("/SelectNameServlet", 'card=' + document.getElementById("card").value, function (result) {
                        $("#name").val("" + result + "");
                    })

                } else {
                    document.getElementById("ka_error").innerText = "卡号不存在";
                    document.getElementById("price").value="";
                    document.getElementById("name").value="";
                }
            })
        }

    </script>
</head>

<body>


<script language="JavaScript">
    yourLogo = '查询界面';
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
            <p>个人网上银行——查询</p>
    </ul>

</div>
<div class="com/ntent">
    <div class="form">
        <div class="kahao">
            <p>卡号:</p>
            <i class="kas"></i>
            <input type="text" onblur="kaBlur(this)" onfocus="konfocus(this)" placeholder="请输入您的卡号" class="katu"
                   id="card" style="color: black">
            <span style="color: red;" id="ka_error"></span>
        </div>
        <div class="name">
            <p>姓名:</p>
            <i class="user"></i>
            <input type="text" disabled class="ntu" id="name" style="color: black">
            <span style="color: red;" id="name_error"></span>
        </div>
        <div>
            <p>余额:</p>
            <input id="price" type="text" disabled style="color: black">

        </div>
        <div class="button">
            <input type="button" value="确认查询" onclick="kaBlur()">
            <input type="button" value="取消查询" onclick="caler()">
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
