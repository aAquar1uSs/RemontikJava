<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="language"/>

<html>
<meta charset="UTF-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>

<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style_login_window.css">
    <title><fmt:message key="title.login.page"/></title>
</head>
<body>
<div class="name">
    <p><fmt:message key="title.login.upper.case"/> </p>
</div>
<div class="login">
    <form id="signin" method="GET" action="${pageContext.request.contextPath}/authorization" autocomplete="off">
        <input
                type="text"
                id="email"
                name="email"
                placeholder=<fmt:message key="placeholder.email"/>
        />
        <input
                type="password"
                id="pass"
                name="pass"
                placeholder=<fmt:message key="placeholder.password"/>
        />
        <input
                type="submit"
                value=<fmt:message key="button.enter"/>
        />
    </form>
    <form id="registration" method="GET" action="${pageContext.request.contextPath}/registration_page" autocomplete="off">
        <input
                type="submit"
                value=<fmt:message key="button.registration"/>
        />
    </form>
</div>
</body>
</html>
