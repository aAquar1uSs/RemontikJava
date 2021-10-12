<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style_admin_page.css">
    <title>ADMIN-Title</title>
</head>
<body>
<div class = "addManager">

    <h2>Add manager</h2>

    <form id="add_manager" method="POST" action="${pageContext.request.contextPath}/signIn" autocomplete="off">
        <input
                type="text"
                id="firstname"
                name="firstname"
                placeholder="Firstname"
        />
        <input
                type="text"
                id="lastname"
                name="lastname"
                placeholder="Lastname"
        />
        <input
                type="text"
                id="email"
                name="email"
                placeholder="Email" />
        <input
                type="password"
                id="pass"
                name="pass"
                placeholder="Password" />

        <input type="submit" value="Sign in!"/>
    </form>
    <div class="managers">
        <h1>All Managers</h1>
        <table>
            <thead>
            <tr>
                <th>#</th>
                <th>First name</th>
                <th>Last name</th>
                <th>Email: </th>
                <th></th>
            </tr>
            </thead>
            <tbody>
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
