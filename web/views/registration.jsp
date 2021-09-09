<%--
  Created by IntelliJ IDEA.
  User: panch
  Date: 03/09/2021
  Time: 18:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link
            rel="stylesheet"
            href="style/style_registration_window.css"
    />
    <title>Registration</title>
</head>
<body>
<div class="name">
    <p>REGISTRATION</p>
</div>
<div class="registration">
    <form id="signin" method="POST" action="${pageContext.request.contextPath}/signIn" autocomplete="off">
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

    <form id ="back" method="POST" action="" autocomplete="off">
        <input type="submit" value="Back" onclick="history.back()"/>
    </form>
</div>
</body>
</html>
