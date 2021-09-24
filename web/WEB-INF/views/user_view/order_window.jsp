<%--
  Created by IntelliJ IDEA.
  User: panch
  Date: 06/09/2021
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style_order_window.css">
    <title>ORDER</title>
</head>
<body>
<div class="inf">
    <h1>Important!</h1>
    <h3>Please describe briefly your problem
        and the manager will answer you!</h3>

</div>
<div class="order">
    <form id="set_order" method="POST" action="${pageContext.request.contextPath}/set_order" autocomplete="off">
        <p><label>
            <textarea name="describe" placeholder="Describe your problem"></textarea>
        </label></p>
        <p><input type="submit" value="Enter"/></p>
        <input type="submit" value="Back" onclick="history.back()"/>
    </form>
</div>
</body>
</html>
