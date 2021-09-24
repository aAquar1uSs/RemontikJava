<%--
  Created by IntelliJ IDEA.
  User: panch
  Date: 06/09/2021
  Time: 12:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style_about_us_page.css">
    <title>About Us</title>
</head>
<body>
    <div class = "text_about_us">
        <h3><p>We are a repair company for computer, mobile and household appliances.</p>
            <p>Our branches in almost all cities of Ukraine.</p>
        </h3>
    </div>

    <form id ="back" method="GET" action="" autocomplete="off">
        <input type="submit" value="Back" onclick="history.back()"/>
    </form>
</body>
</html>
