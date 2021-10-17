<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="language"/>

<html>
<head>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style_success_page.css">
    <title><fmt:message key="title.success.page"/> </title>
</head>
<body>
    <h1><fmt:message key="label.success"/> </h1>

    <div class="back-to-main">
        <form id="back" method="GET" action="${pageContext.request.contextPath}/main" autocomplete="off">
            <input
                    type="submit"
                    value=<fmt:message key="button.back"/>
            />
        </form>
        </div>
    </div>
</body>
</html>
