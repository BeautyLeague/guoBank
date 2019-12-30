<%--
  Created by IntelliJ IDEA.
  User: 闵子龙
  Date: 2019/12/23
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<link href="/css/pwd.css" rel="stylesheet"  type="text/css"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<script src="/js/jquery-1.12.4.js" type="text/javascript"></script>
<script type="text/javascript">
    $(function() {
        $("#sub").on("click",function() {
            var pwd=$("#pwd").val();
            var pwd1=$("#pwd1").val();
            var pwd2=$("#pwd2").val();
            var reg=/^[0-9a-zA-Z]{6,15}$/;
            if (pwd==""){
                alert("请输入原密码！");
                return false;
            }
            if (pwd1==""){
                alert("请输入新密码！");
                return false;
            }
            if(pwd1.length<6){
                alert("密码至少输入6位数字！");
                return false;
            }
            if(!reg.test(pwd1)){
                alert("密码格式不正确！");
                return false;
            }
            if (pwd2==""){
                alert("请再输入新密码！");
                return false;
            }
            if(pwd2.length<6){
                alert("密码至少输入6位数字！");
                return false;
            }
            if(!reg.test(pwd2)){
                alert("密码格式不正确！");
                return false;
            }
            if(pwd1!=pwd2){
                alert("两次密码不一致！");
                return false;
            }
            $.post("<%=path%>/YzPwdServlet","pwd="+pwd, function (result) {

                if(result==1){
                    $("#forms").submit();
                }else{
                    alert("输入的原密码错误！");
                }
            })
        })
    })

    function ispwd() {
        var pwd=$("#pwd").val();

    }
</script>
<html>
<head>
    <title>修改密码</title>
</head>
<body>
<div class="title">
    <ul>
        <li>
            <img src="/img/bank.png" width="198" height="50">
        <li>
            <p>|</p>
        <li>
            <p>个人网上银行——修改密码</p>
    </ul>
</div>
<div id="form">
    <form id="forms" action="/mingzilongupdPwdServlet?pho=${sessionScope.user.pho}" method="post" id="myform">
        <table>
            <div class="list">
                <tr>
                    <td>原密码:</td>
                    <td class="pwd"><input type="text" name="pwd" id="pwd" placeholder="请填写当前密码" onblur="" style="width: 380px;height: 50px;"></td>
                </tr>
            </div>
            <div class="list">
                <tr>
                    <td> 新密码:</td>
                    <td class="pwd1"><input type="password" name="pwd1" id="pwd1" placeholder="请设置新的登录密码"  style="width: 380px;height: 50px;"></td>
                </tr>
            </div>
            <div class="list">
                <tr>
                    <td>再输入新密码:</td>
                    <td class="pwd1"><input type="password" name="pwd2" id="pwd2" placeholder="请再输入新的登录密码"    style="width:380px;height: 50px;"></td>
                </tr>
            </div>
        </table>
        <div id="an">
            <input type="button" value="确定" id="sub">
            <a href="/mingzilongCloseuserinfoServlet"><input type="button" value="取消" id="but" onclick="JavaScript:history.go(-1)"></a>
        </div>
    </form>
</div>
<div id="as">
    <a href="">网站声明</a>|<a href="">网站地图</a>|<a href="">联系我们</a>|<span>联系热线：<a style="color: coral">18170778835</a></span>
    <div style="margin-top: 10px" >
        <a href="">中国郭氏银行版权所有</a>|<a href="" style="color: coral ">京ICP备05049539</a>
    </div>
</body>
</html>
