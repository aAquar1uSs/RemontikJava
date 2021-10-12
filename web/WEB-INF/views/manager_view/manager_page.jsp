<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title><fmt:message key="title.manager.page"/></title>
</head>
<body>
<div class="orders">
    <h1>All Orders</h1>
    <table>
        <thead>
        <tr>
            <th>#</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Description order</th>
            <th>Price</th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="manager" items="${listOrders}">
            <tr>
                <td></td>
                <td>${manager.firstName}</td>
                <td>${manager.lastName}</td>
                <td>${manager.email}</td>
                <c:set var="emailForDelete" value="${manager.email}" scope="session"/>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
