<%--
  Created by IntelliJ IDEA.
  User: panch
  Date: 03/09/2021
  Time: 18:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="UTF-8"/>
<meta http-equiv="X-UA-Compatible" content="IE=edge"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<link
        rel="stylesheet"
        href="style/style_login_window.css"
/>
<title>Login</title>
<head>
    <title>Login</title>
</head>
<body>
<div class="name">
    <p>LOGIN</p>
</div>
<div class="login">
    <form id="signin" method="POST" action="../AuthServlet" autocomplete="off">
        <input
                type="text"
                id="email"
                name="email"
                placeholder="Email"
        />
        <input type="password" id="pass" name="pass" placeholder="Password"/>
        <input type="submit" value="Enter"/>
        <input type="submit" value="Registration"/>

    </form>
</div>
</body>
</html>
