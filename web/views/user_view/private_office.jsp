<%@ page import="com.mysql.cj.Session" %>
<%@ page import="java.util.List" %>
<%@ page import="com.project.model.Order" %><%--
  Created by IntelliJ IDEA.
  User: panch
  Date: 01.09.2021
  Time: 17:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link
        rel="stylesheet"
        href= "../style/style_private_office.css"
        type="text/css"
/>

<head>
    <title>Private Office</title>
</head>
<body>

<h2>Hello, <%=session.getAttribute("userName")%> </h2>
<h3> Cash account: <%=session.getAttribute("cashAcc")%></h3>
<div class="buttons">
    <form method="POST" action="">
        <input type="submit" name="ReplenishCash" value="Replenish your account">
    </form>
    <form method="GET" action="${pageContext.request.contextPath}/logout">
        <input type="submit" name="logout" value="Logout">
    </form>
</div>

<div class="orders">
    <%=request.getAttribute("listOrders")%>
    <table>
        <tr>
            <th>Name</th>
            <th>Age</th>
            <th>Email</th>
        </tr>

    </table>



</div>

</body>
</html>
