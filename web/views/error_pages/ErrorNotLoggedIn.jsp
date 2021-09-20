<%--
  Created by IntelliJ IDEA.
  User: panch
  Date: 01.09.2021
  Time: 20:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Error</title>
    <style>
        .text {
            text-align:  center;
        }
    </style>
</head>
<body>
<div class = "text_content">
        <h1>COULD NOT LOG IN</h1>

        <%
            String message = null;
            String sessionID = null;
            Cookie[] cookies = request.getCookies();
            if(cookies != null){
                for(Cookie cookie : cookies){
                    if(cookie.getName().equals("message")) message = cookie.getValue();
                    if(cookie.getName().equals("JSESSIONID")) sessionID = cookie.getValue();
                }
            }
        %>

        <h3>LogIn failed</h3>
        <h4><%=message%></h4>
        <h4>Session ID = <%=sessionID %></h4>
</div>
</body>
</html>
