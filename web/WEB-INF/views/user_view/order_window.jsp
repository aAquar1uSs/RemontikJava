<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@page language="java" contentType="text/html;charset=utf-8" pageEncoding="utf-8"%>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="language"/>

<html lang="${sessionScope.lang}">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style_order_window.css">
    <title><fmt:message key="title.order.page"/></title>
</head>
<body>
<div class="inf">
    <h1><fmt:message key="label.information.for.customers"/></h1>
    <h3><fmt:message key="label.information.for.customers2"/></h3>
</div>

<div class="order">
    <form id="set_order" method="POST" accept-charset="UTF-8" action="${pageContext.request.contextPath}/set_order">
        <p>
            <label>
                <textarea
                    name="problemDescription"
                    placeholder=<fmt:message key="label.placeholder.describe.problem"/>
                ></textarea>
            </label>
        </p>
        <p>
            <input
                    type="submit"
                    value=<fmt:message key="button.submit" />
            />
        </p>
        <input
                type="submit"
                value=<fmt:message key="button.back"/>
                        onclick="history.back()"
        />
    </form>
</div>
</body>
</html>
