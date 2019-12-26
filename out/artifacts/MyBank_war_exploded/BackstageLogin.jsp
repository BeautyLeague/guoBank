<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link href="/css/BackstageLogin.css" rel='stylesheet'>

    <title>注册</title>
    <script src="/js/jquery-1.12.4.js"></script>
</head>

<body>
<div class="context">
    <div class="registeForm">
        <div class="headPortrait">
            <img src="img/default.jpg" class="headPortraitImg">
            <input type="file" id="file" hidden accept=".jpg,.png,.jpeg,.gif">
        </div>
        <div class="emailDiv">
            <input type="email" id="email" oninput="emailPattern(this)">
            <span class="tips">电子邮箱</span>
        </div>
        <div class="nameDiv">
            <input type="text" id="name" oninput="namePattern(this)">
            <span class="tips">昵称</span>
        </div>
        <div class="pwdDiv">
            <input type="password" id="pwd" oninput="pwdPattern(this)">
            <span class="tips">密码</span>
        </div>
        <div class="registerDiv">
            <input type="button" id="register" value="注册" onclick="registeBtn()">
        </div>
        <div class="yiyouDiv">
            <a href="javascript:void(0)" onclick="yiyouBtn()">已有账户?</a>
        </div>
    </div>
    <div class="loginForm" hidden>
        <div class="emailDiv">
            <input type="email" id="loginEmail" oninput="emailPattern(this)">
            <span class="tips">电子邮箱</span>
        </div>
        <div class="pwd">
            <input type="password" id="loginPwd" oninput="pwdPattern(this)">
            <span class="tips">密码</span>
        </div>
        <div class="loginDiv">
            <input type="button" id="login" value="登录" onclick="loginBtn()">
        </div>
        <div class="yiyouDiv">
            <a href="javascript:void(0)" onclick="createBtn()">创建账户</a>
        </div>
    </div>
    <div class="registeLayer">
        注册中...
    </div>
    <div id="fade" class="black_overlay"></div>
</div>
</body>

<script>
    //用来检查邮箱是否存在
    emailFlag = false;
    //用来判断用户是登录还是注册
    effectFlag = true;
    //保存可以选择的文件格式
    var imgSuffixs = new Array(".jpg", ".png", ".jpeg", ".gif");
    //用来保存上一次选择的文件
    // var prevFile = document.getElementById("file").files[0];
    var prevFile = new File([document.getElementById("file").files[0]], "default");
    $(function () {
        //点击图片显示选择文件框
        $(".headPortraitImg").click(function () {
            $("#file").click();
        })
        //将选择的图片文件显示在img中
        $("#file").change(function () {
            //获取选择的文件  如果用户点了取消没选择文件的话 就是上一个选择的文件
            var imgFile = document.getElementById("file").files[0] || prevFile;
            //获取文件后缀  文件的格式
            var suffix = imgFile.name.substring(imgFile.name.lastIndexOf('.'));
            //判断是否是图片格式
            if (contain(imgSuffixs, suffix)) {
                //记录用户选择的文件   为了下次用户选择文件的时候点了取消而为空
                prevFile = imgFile;
                var fr = new FileReader();
                fr.onload = function () {
                    $(".headPortraitImg").attr("src", fr.result);
                };
                // 注意要先设置回调再读取文件
                fr.readAsDataURL(imgFile);
            }
        })
        //判断array数组中是否存在element
        function contain(array, element) {
            for (var i = 0; i < array.length; i++) {
                if (array[i] == element) {
                    return true;
                }
            }
            return false;

        }
        // input的提示文字在获得焦点的时候将文字往上移
        $(".context div input").bind("focus",function(){
            $(this).next().animate({ top: "-7px", fontSize: "11px" }, 300)
        })
        // input的提示文字在失去焦点的时候将文字往下移
        $(".context div input").bind("blur",function(){
            if ($(this).val() == "" && $(this).next().css("color")!="rgb(255, 0, 0)") {
                $(this).next().animate({ top: "5px", fontSize: "13px" }, 300)
            }
        })
    })
    //邮箱验证
    function emailPattern(obj) {
        var pattern = /^([A-Za-z0-9_\-\.])+\@([A-Za-z0-9_\-\.])+\.([A-Za-z]{2,4})$/;
        if (pattern.test($.trim($(obj).val()))) {
            $(obj).next().text("正确的邮箱");
            yesPattern(obj);
            if(effectFlag==true){
                emailExists();}
            return true;
        } else if ($.trim($(obj).val()) == "") {
            $(obj).next().text("电子邮箱");
            emptyPattern(obj);
        } else {
            $(obj).next().text("错误的邮箱");
            errorPattern(obj);
        }
        return false;
    }
    function namePattern(obj) {
        if ($.trim($(obj).val()) == "") {
            $(obj).next().text("昵称");
            emptyPattern(obj);
        } else if ($.trim($(obj).val()).length <= 20) {
            $(obj).next().text("正确的昵称");
            yesPattern(obj);
            return true;
        } else {
            $(obj).next().text("长度不能大于20");
            errorPattern(obj);
        }
        return false;
    }
    function pwdPattern(obj) {
        if ($(obj).val().length >= 6 && $(obj).val().length <= 20) {
            $(obj).next().text("密码格式正确");
            yesPattern(obj);
            return true;
        } else if ($.trim($(obj).val()) == "") {
            $(obj).next().text("密码");
            emptyPattern(obj);
        } else {
            $(obj).next().text("长度必须大于6位,小于20位");
            errorPattern(obj);
        }
        return false;
    }
    //input格式正确时将文字颜色和input的边框颜色设为输入正确的颜色
    function yesPattern(obj) {
        $(obj).next().css({ "color": "rgb(0, 255, 34)" })
        $(obj).css("border-color", "rgb(0, 255, 34)")
    }
    //input格式错误时将文字颜色和input的边框颜色设为格式错误的颜色
    function errorPattern(obj) {
        $(obj).next().css("color", "red")
        $(obj).css("border-color", "red")
    }
    //input为空将文字颜色和input的边框颜色设为默认颜色
    function emptyPattern(obj) {
        $(obj).next().css({ "color": "rgb(143, 143, 142)" });
        $(obj).css("border-color", "rgb(110, 110, 109) ")
    }
    function checkPattern(obj){
        $(obj).next().css({ "color": "rgb(0,164,245)" });
        $(obj).css("border-color", "rgb(0,164,245)")
    }

    // 点击已有账号
    function yiyouBtn() {
        effectFlag = false;
        $(".loginForm").show();
        $(".registeForm").hide();
    }
    // 点击注册显示注册的页面
    function createBtn() {
        effectFlag = true;
        $(".loginForm").hide();
        $(".registeForm").show();
    }
    //点击登录按钮
    function loginBtn() {

        if(loginBtnEmail() & loginBtnPwd()){
            var json = {
                "email":$("#loginEmail").val(),
                "pwd": $("#loginPwd").val()
            };
            $.ajax({
                url : "login",
                type : 'POST',
                data : json,
                beforeSend:function(){
                    $(".registeLayer").css("display","block");
                    $(".black_overlay").css("display","block");
                    $(".registeLayer").text("正在登录，请稍候");
                    console.log("正在登录，请稍候");
                },
                success : function(result) {
                    if(result=="成功"){
                        yesGetInto("登录成功");
                    }else{
                        noGetInto(result);
                    }
                },
                error : function(responseStr) {
                    console.log("error");
                    noGetInto("出现异常");
                }
            });
        }
    }
    //点击注册按钮
    function registeBtn() {
        effectFlag = true;
        if(emailFlag & registeBtnEmail() & registeBtnName() & registeBtnPwd() ){
            var formData = new FormData();
            formData.append("adminName",$("#name").val());
            formData.append("adminEmail",$("#email").val());
            formData.append("adminPwd",$("#pwd").val());
            formData.append("adminPortrait",prevFile);
            $.ajax({
                url : "AdminInfoServlet?action=register",
                type : 'POST',
                data : formData,
                // 告诉jQuery不要去处理发送的数据
                processData : false,
                // 告诉jQuery不要去设置Content-Type请求头
                contentType : false,
                beforeSend:function(){
                    $(".registeLayer").css("display","block");
                    $(".black_overlay").css("display","block");
                    $(".registeLayer").text("正在进行，请稍候");
                    console.log("正在进行，请稍候");
                },
                success : function(result) {
                    if(result==="true"){
                        yesGetInto("注册成功");
                    }else{
                        noGetInto("注册失败");
                    }
                },
                error : function(responseStr) {
                    console.log(responseStr);
                    console.log("error");
                }
            });
        }
    }

    function yesGetInto(message){
        var i = 3;
        $(".registeLayer").text(""+message+",即将跳转主页面:"+i);
        setInterval(function(){
            i--;
            if(i==0){
                window.location.href="displaydata.html";
            }
            $(".registeLayer").text(""+message+",即将跳转主页面:"+i);

        },1000)
    }
    function noGetInto(message){
        var i = 2;
        $(".registeLayer").text(message);
        setInterval(function(){
            if(i==0){
                $(".registeLayer").css("display","none");
                $(".black_overlay").css("display","none");
            }
            i--;
        },1000)
    }
    //点击注册验证email
    function registeBtnEmail(){
        if (emailPattern($("#email")) === false) {
            if ($("#email").val() == "") {
                $("#email").next().text("需要邮箱")
                $("#email").next().animate({ top: "-7px", fontSize: "11px" }, 300)
                errorPattern($("#email"));
            }
            return false;

        }
        return true;
    }
    function registeBtnName(){
        if (namePattern($("#name")) === false) {
            if ($("#name").val() == "") {
                $("#name").next().text("需要昵称")
                $("#name").next().animate({ top: "-7px", fontSize: "11px" }, 300)
                errorPattern($("#name"));
            }
            return false;
        }
        return true;
    }
    function registeBtnPwd(){
        if (pwdPattern($("#pwd")) === false) {
            if ($("#pwd").val() == "") {
                $("#pwd").next().text("需要密码")
                $("#pwd").next().animate({ top: "-7px", fontSize: "11px" }, 300)
                errorPattern($("#pwd"));
            }

            return false;
        }
        return true;
    }

    function loginBtnEmail(){
        if (emailPattern($("#loginEmail")) === false) {
            if ($("#loginEmail").val() == "") {
                $("#loginEmail").next().text("需要邮箱")
                $("#loginEmail").next().animate({ top: "-7px", fontSize: "11px" }, 300)
                errorPattern($("#loginEmail"));
            }
            return false;
        }
        return true;
    }
    function loginBtnPwd(){
        if (pwdPattern($("#loginPwd")) === false) {
            if ($("#loginPwd").val() == "") {
                $("#loginPwd").next().text("需要密码");
                $("#loginPwd").next().animate({ top: "-7px", fontSize: "11px" }, 300)
                errorPattern($("#loginPwd"));
            }
            return false;
        }
        return true;
    }


    function emailExists(){
        emailFlag = false;
        $.ajax({
            url : "AdminInfoServlet?action=checkEmail",
            type : 'POST',
            dataType:'text',
            data : "email="+$("#email").val(),
            beforeSend:function(){
                $("#email").next().text("正在验证，请稍候");
                checkPattern( $("#email"));
            },
            success : function(result) {
                if(result === "false"){
                    $("#email").next().text("验证完成，可用");
                    yesPattern($("#email"));
                    emailFlag = true;
                }else{
                    $("#email").next().text("该邮箱已存在,不可用");
                    errorPattern($("#email"));
                }
            },
            error : function(responseStr) {
                console.log(responseStr);
                console.log("error");
            }
        });
    }
</script>

</html>