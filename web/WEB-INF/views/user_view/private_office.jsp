<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="language"/>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style_fonts.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style_private_office.css">
    <title><fmt:message key="title.private.account"/></title>
</head>
<body>
<div class = "User">
    <h2><fmt:message key="label.hello"/>, <%=session.getAttribute("userName")%> </h2>
    <h3><fmt:message key="label.cash.account"/>: <%=session.getAttribute("cashAcc")%></h3>
</div>
<div class="buttons">
    <form method="GET" action="">
        <input type="submit" name="ReplenishCash" value=<fmt:message key="button.replenish.account"/>>
    </form>
    <form method="GET" action="${pageContext.request.contextPath}/logout">
        <input type="submit" name="logout" value=<fmt:message key="button.logout"/>>
    </form>
    <form method="GET" action="" autocomplete="off">
        <input type="submit" value=<fmt:message key="button.back"/> onclick="history.back()"/>
    </form>
</div>

<div class="orders">
    <h1><fmt:message key="label.your.orders"/></h1>
    <table>
        <thead>
        <tr>
            <th>#</th>
            <th><fmt:message key="label.describe.problem"/></th>
            <th><fmt:message key="label.price"/></th>
            <th><fmt:message key="label.date"/></th>
            <th><fmt:message key="label.status.order"/></th>
            <th><fmt:message key="label.payment.status"/></th>
            <th></th>
        </tr>
        </thead>
        <tbody>
        <jsp:useBean id="listOrders" scope="request" type="java.util.List"/>
        <c:forEach var="order" items="${listOrders}">
        <tr>
            <td></td>
            <td>${order.orderName}</td>
            <td>${order.orderPrice}</td>
            <td>${order.orderDate}</td>
            <td>${order.orderStatus}</td>
            <td>${order.paymantStatus}</td>
            <td>
                <form method="GET" action="${pageContext.request.contextPath}">
                    <input type="submit" name="Delete" value=<fmt:message key="button.delete"/> />
                </form>
            </td>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

</body>
</html>
