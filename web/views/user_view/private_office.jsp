<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.mysql.cj.Session" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.model.Order" %><%--
  Created by IntelliJ IDEA.
  User: panch
  Date: 01.09.2021
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<!--<link rel="stylesheet" href="" type="text/css">-->
<style>
    <%@ include file="/views/style/style_private_office.css" %>
</style>

<head>
    <title>Private Office</title>
</head>
<body>
<div class = "User">
    <h2>Hello, <%=session.getAttribute("userName")%> </h2>
    <h3> Cash account: <%=session.getAttribute("cashAcc")%></h3>
</div>
<div class="buttons">
    <form method="GET" action="">
        <input type="submit" name="ReplenishCash" value="Replenish your account">
    </form>
    <form method="GET" action="${pageContext.request.contextPath}/logout">
        <input type="submit" name="logout" value="Logout">
    </form>
    <form method="GET" action="" autocomplete="off">
        <input type="submit" value="Back" onclick="history.back()"/>
    </form>
</div>

<div class="orders">
    <h1>Your orders</h1>
    <table>
        <thead>
        <tr>
            <th>#</th>
            <th>Describe problem</th>
            <th>Price</th>
            <th>Date</th>
            <th>Status order</th>
            <th>Paymant status</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="order" items="${listOrders}">
        <tr>
            <td></td>
            <td>${order.orderName}</td>
            <td>${order.orderPrice}</td>
            <td>${order.orderDate}</td>
            <td>${order.orderStatus}</td>
            <td>${order.paymantStatus}</td>
            <td>
                <form method="GET" action="${pageContext.request.contextPath}/delete_order">
                <input type="submit" name="Delete" value="Delete">
            </form>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
