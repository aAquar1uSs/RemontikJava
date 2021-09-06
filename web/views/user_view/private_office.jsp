<%@ page import="com.mysql.cj.Session" %><%--
  Created by IntelliJ IDEA.
  User: panch
  Date: 01.09.2021
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Private Office</title>
</head>
<body>
Hello, <%=session.getAttribute("userName")%>

<div class="buttons">
    <form method="POST" action="../../logout">
        <input type="submit" name="logout" value="Logout">
    </form>
</div>

</body>
</html>
