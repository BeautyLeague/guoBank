<%--
  Created by IntelliJ IDEA.
  User: 闵子龙
  Date: 2019/12/22
  Time: 16:46
  To change this template use File | Settings | File Templates.
--%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<link href="/css/acc.css" rel="stylesheet"  type="text/css"/>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
%>
<html>
<head>
    <title>用户卡号</title>
</head>
<body>
<div class="title">
    <ul>
        <li>
            <img src="/img/bank.png" width="198" height="50">
        <li>
            <p>|</p>
        <li>
            <p>个人网上银行——用户卡号</p>
    </ul>
</div>
<div id="tab">
    <table style="text-align: center">
        <tr style="background-color: #9196A1">
            <td>卡号</td>
            <td>类型</td>
            <td>是否挂失</td>
            <td>地址</td>
            <td>时间</td>
        </tr>
        <c:forEach items="${requestScope.page.resultList}" var="bank" varStatus="status">
            <tr>
                <td>${bank.bankCardId}</td>
                <c:if test="${bank.cardTypeId==1}">
                    <td>借记卡</td>
                </c:if>
                <c:if test="${bank.cardTypeId==2}">
                    <td>准贷记卡</td>
                </c:if>
                <c:if test="${bank.cardTypeId==3}">
                    <td>贷记卡</td>
                </c:if>

                <c:if test="${bank.is_ds==0}">
                    <td>未挂失</td>
                </c:if>
                <c:if test="${bank.is_ds==1}">
                    <td>已挂失</td>
                </c:if>
                <td>${bank.address}</td>
                <td>${bank.date}</td>
            </tr>
        </c:forEach>
        <tr>
            <td align="middle" colspan="5">
                <c:if test="${page.pageNo>1}">
                    <a href="/mingzilongqueryBankServlet?pageNo=1">首页</a>
                    <a href="/mingzilongqueryBankServlet?pageNo=${page.pageNo-1}">上一页</a>
                </c:if>
                <c:if test="${page.pageNo<page.totalPage}">
                    <a href="/mingzilongqueryBankServlet?pageNo=${page.pageNo+1}">下一页</a>
                    <a href="/mingzilongqueryBankServlet?pageNo=${page.totalPage}">末页</a>
                </c:if>
                <br>
                <a>
                当前第${page.pageNo}页/共${page.totalPage}页
                共${page.totalCount}条记录</a>
            </td>
        </tr>
    </table>
</div>
<div id="but">
    <a href="/mingzilongCloseuserinfoServlet"><input type="button" value="返回" id="bu"></a>
</div>
<div id="as">
    <a href="">网站声明</a>|<a href="">网站地图</a>|<a href="">联系我们</a>|<span>联系热线：<a style="color: coral">18170778835</a></span>
    <div style="margin-top: 10px" >
        <a href="">中国郭氏银行版权所有</a>|<a href="" style="color: coral ">京ICP备05049539</a>
    </div>
</body>
</html>
