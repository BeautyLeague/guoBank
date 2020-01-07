<%--
  Created by IntelliJ IDEA.
  User: 闵子龙
  Date: 2019/12/19
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="/css/list.css" rel="stylesheet"  type="text/css"/>
<%@ page contentType="text/html;charset=UTF-8"  language="java" %>
<html>
<head>
    <title>个人资料</title>
</head>
<style>
    body{
        background: #9196A1;
    }
</style>
<body>
<div class="title">
    <ul>
        <li>
            <img src="/img/bank.png" width="198" height="50">
        <li>
            <p>|</p>
        <li>
            <p>个人网上银行——个人资料</p>
    </ul>
</div>
<form>
    <div id="d">
        <div style="width: 100%;height: 60px;border-bottom: solid royalblue 2px;">
            <div style="font-size: 20px;display:inline-block;float:left;border-left: solid royalblue 4px;margin-left: 10px;height: 30px;margin-top: 15px;line-height: 30px;">&nbsp;&nbsp;&nbsp;账号信息</div>
        </div>
        <div style="height: 180px;border-bottom: 1px darkgray solid">
            <img src="${sessionScope.user.path}" style="margin-top:15px;width:150px;height:150px;border-radius:50%;border: 1px solid;"></img><br>
        </div>
        <table id="messid">
            <tr>
                <td id="nu">昵称:</td>
                <td style="font-size: 20px;text-align: left;color: #1E9FFF;">${userinfo1.userName}</td>
                <td>性别:</td>
                <c:if test="${userinfo1.sex=='男'}">
                    <td style="font-size: 20px;text-align: left; color: #1E9FFF;">男♂</td>
                </c:if>
                <c:if test="${userinfo1.sex=='女'}">
                    <td style="font-size: 20px;text-align: left; color: #1E9FFF;">女♀</td>
                </c:if>
            </tr>
            <tr>
                <td>年龄:</td>
                <td style="font-size: 20px;text-align: left;color: #1E9FFF;">${userinfo1.age}</td>
                <td>等级:</td>
                <td style="font-size: 20px;text-align: left;color: green;">${userinfo1.leven}</td>
            </tr>
            <tr>
                <td>手机号:</td>
                <td style="font-size: 20px;text-align: left; color: #1E9FFF;">${userinfo1.pho}</td>
                <td>出生日期:</td>
                <td style="font-size:20px;text-align: left;  color: #1E9FFF;">${userinfo1.bornDate}</td>
            </tr>
        </table>
        <a href="/mingzilongqueryBankServlet?userId=${userinfo1.userId}" id="x">显示账号所有银行卡号</a>

        <a href="/mingzilongqueryUserServlet?userid=${userinfo1.userId}" id="xiu">编辑资料</a>

        <a href="/minzilong/pass.jsp?pho=${userinfo1.pho}" id="pwd">修改密码</a>

        <a href="/mingzilongCloseUserServlet" id="f">返回</a>
    </div>

    <div id="as" style="line-height: 40px;">
        <a href="">网站声明</a>|<a href="">网站地图</a>|<a href="">联系我们</a>|<span>联系热线：<a style="color: coral">18170778835</a></span>
        <div style="margin-top: 10px" >
            <a href="">中国郭氏银行版权所有</a>|<a href="" style="color: coral ">京ICP备05049539</a>
        </div>
</form>

</html>
