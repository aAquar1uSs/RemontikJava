<%--
  Created by IntelliJ IDEA.
  User: panch
  Date: 05/09/2021
  Time: 20:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>REGISTRATION ERROR</title>
</head>
<body>
<H1>User with such email already exists</H1>
<H2>Or there’s a syntactic error in your email</H2>

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

<h3>Registration failed</h3>
<h4><%=message%></h4>
<h4>Session ID = <%=sessionID %></h4>
</body>
</html>
