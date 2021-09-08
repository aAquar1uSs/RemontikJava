<%--
  Created by IntelliJ IDEA.
  User: panch
  Date: 06/09/2021
  Time: 16:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link
        rel="stylesheet"
        href= "../../views/style/style_order_window.css"
/>

<head>
    <title>ORDER</title>
</head>
<body>
<h2>Important</h2>
<div class="order">
    <form id="set_order" method="POST" action="../../set_order" autocomplete="off">
        <p><textarea name="describe" placeholder="Describe your problem"></textarea></p>
        <p><input type="submit" value="Enter"/></p>
    </form>
</div>
</body>
</html>
