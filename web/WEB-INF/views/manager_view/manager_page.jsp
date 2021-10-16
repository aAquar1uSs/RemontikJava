<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="language"/>

<html>
<head>
    <title><fmt:message key="title.manager.page"/></title>
</head>
<body>
<div class="orders">
    <h1><fmt:message key="label.all.orders"/></h1>
    <table>
        <thead>
        <tr>
            <th>#</th>
            <th><fmt:message key="placeholder.firstname"/> </th>
            <th><fmt:message key="placeholder.lastname"/></th>
            <th><fmt:message key="label.describe.problem"/></th>
            <th><fmt:message key="label.price"/></th>
            <th><fmt:message key="label.status.order"/></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="manager" items="${listOrders}">
            <tr>
                <td></td>
                <td></td>
                <td></td>
                <td></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
