<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="language"/>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style_order_window.css">
    <title><fmt:message key="title.order.page"/></title>
</head>
<body>
<div class="inf">
    <h1><fmt:message key="label.information.for.customers"/></h1>
    <h3><fmt:message key="label.information.for.customers2"/></h3>

</div>
<div class="order">
    <form id="set_order" method="POST" action="${pageContext.request.contextPath}/set_order" autocomplete="off">
        <p>
            <label>
                <textarea
                        name="describe"
                        placeholder=<fmt:message key="label.placeholder.describe.problem"/>
                ></textarea>
            </label>
        </p>
        <p>
            <input
                    type="submit"
                    value=<fmt:message key="button.enter" />
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
