<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="language"/>

<html lang="${sessionScope.lang}">
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style_fonts.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style_registration_window.css">
    <title><fmt:message key="title.registration.page"/></title>
</head>
<body>
<div class="name">
    <p><fmt:message key="label.registration.upper.case"/></p>
</div>
<div class="registration">
    <form id="registration_form" method="POST" action="${pageContext.request.contextPath}/signIn" autocomplete="off">
        <input
                type="text"
                id="firstname"
                name="firstname"
                placeholder=<fmt:message key="placeholder.firstname"/>
        />
        <input
                type="text"
                id="lastname"
                name="lastname"
                placeholder=<fmt:message key="placeholder.lastname"/>
        />
        <input
                type="email"
                id="email"
                name="email"
                placeholder=<fmt:message key="placeholder.email"/>
        /> <span class="form_error_message_for_email">
                <fmt:message key="label.describe.problem.about.validation.email"/>
            </span>
        <label for="pass"></label><input
                type="password"
                id="pass"
                name="pass"
                pattern="(\w{4,})"
                placeholder=<fmt:message key="placeholder.password"/>
        /> <span class="form_error_message_for_password">
                <fmt:message key="label.describe.problem.about.validation.password"/>
            </span>

        <input type="submit" value=<fmt:message key="button.enter" />/>

        <input type="submit" value=<fmt:message key="button.back"/> onclick="history.back()"/>
    </form>
</div>
</body>
</html>
