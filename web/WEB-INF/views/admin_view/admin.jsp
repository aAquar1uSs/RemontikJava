<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="language"/>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style_fonts.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style_admin_page.css">
    <title><fmt:message key="title.admin.page"/> </title>
</head>
<body>
<div class = "addManager">

    <h2><fmt:message key="label.add.managers"/> </h2>

    <form id="add_manager" method="POST" action="${pageContext.request.contextPath}/signIn" autocomplete="off">
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
                type="text"
                id="email"
                name="email"
                placeholder=<fmt:message key="placeholder.email"/> />
        <input
                type="password"
                id="pass"
                name="pass"
                placeholder=<fmt:message key="placeholder.password"/> />

        <input type="submit" value="Sign in!"/>
    </form>
    <div class="managers">
        <h1><fmt:message key="label.all.managers"/></h1>
        <table>
            <thead>
            <tr>
                <th>#</th>
                <th><fmt:message key="placeholder.firstname"/></th>
                <th><fmt:message key="placeholder.lastname"/></th>
                <th><fmt:message key="placeholder.email"/> </th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <jsp:useBean id="listManagers" scope="request" type="java.util.List"/>
            <c:forEach var="manager" items="${listManagers}">
                <tr>
                    <td></td>
                    <td>${manager.firstName}</td>
                    <td>${manager.lastName}</td>
                    <td>${manager.email}</td>
                    <c:set var="emailForDelete" value="${manager.email}" scope="session"/>
                    <td>
                        <form method="POST" action="${pageContext.request.contextPath}/delete_users">
                            <input type="submit" name="Delete" value="Delete">
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
</body>
</html>
