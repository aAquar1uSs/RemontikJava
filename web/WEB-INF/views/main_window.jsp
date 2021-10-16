
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<fmt:setLocale value="${sessionScope.lang}"/>
<fmt:setBundle basename="language"/>

<html>
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/style/style_main_window.css">
    <script src="https://kit.fontawesome.com/e7cb8c5be7.js" crossorigin="anonymous"></script>

    <title><fmt:message key="label.company.name"/></title>
</head>
<body>
<!- HEADER -->
<header>
    <div class="upper-line">
        <nav role="navigation">
            <div id="menuToggle">
                <input type="checkbox"/>
                <span></span>
                <span></span>
                <span></span>
                <ul id="menu">
                    <a href="#aboutUs">
                        <li><fmt:message key="href.about.us"/></li>
                    </a>
                    <a href="#contacts">
                        <li><fmt:message key="href.contacts"/></li>
                    </a>
                    <a href="#feedback">
                        <li><fmt:message key = "href.leave.feedback"/></li>
                    </a>
                    <a href="https://erikterwan.com/" target="_blank">
                        <li><fmt:message key="href.show.me.more"/></li>
                    </a>
                </ul>
            </div>
        </nav>
        <div class="buttons">
            <div class="info">
                <form method="GET" action="">
                    <a
                            href="#aboutUs"
                            class="btn btn-sm animated-button thar-two"
                    ><fmt:message key="href.about.us"/></a>
                </form>
            </div>
            <div class="contacts">
                <form method="GET" action="">
                    <a
                            href="#contacts"
                            class="btn btn-sm animated-button thar-two"
                    ><fmt:message key="href.contacts"/></a>
                </form>
            </div>
            <div class="feedback">
                <form method="GET" action="">
                    <a
                            href="#feedback"
                            class="btn btn-sm animated-button thar-two"
                    ><fmt:message key = "href.leave.feedback"/></a>
                </form>
            </div>

        </div>
        <div class="localization">
            <a href="?lang=en">ENG</a>
            <a href="?lang=ru">RUS</a>
            <a href="?lang=ua">UA</a>
        </div>
        <div class="account">
            <a href="${pageContext.request.contextPath}/secured/private_account"><i class="fas fa-user-circle"></i></a></button>
        </div>
    </div>

    <div class="head">
        <div class="name-company">
            <h1><fmt:message key="label.company.name"/></h1>
            <h3><fmt:message key = "label.company.description"/></h3>
        </div>
        <div class ="set_order">
        <c:choose>
            <c:when test="${sessionScope.userRole.name.equals('USER')}">
                <a href="${pageContext.request.contextPath}/set_new_order_page" class="pressed-button"><fmt:message key="button.set.order"/></a>
            </c:when>
            <c:when test="${sessionScope.userRole.name.equals('ADMIN')}">
                <a href="${pageContext.request.contextPath}/secured/private_account" class="pressed-button"><fmt:message key="button.to.private.account"/></a>
            </c:when>
            <c:when test = "${sessionScope.userRole.name.equals('MANAGER')}">
                <a href="${pageContext.request.contextPath}/secured/private_account" class="pressed-button"><fmt:message key="title.manager.page"/></a>
            </c:when>
            <c:otherwise>
                <a href="${pageContext.request.contextPath}/secured/private_account" class="pressed-button"><fmt:message key="title.login.page"/></a>
            </c:otherwise>
        </c:choose>
            </div>
    </div>
</header>

<!- MAIN -->
    <main>
        <div id = "aboutUs">
            <div class = "text_about_us">
                <h3>
                    <p><fmt:message key="label.description.company1"/></p>
                    <p><fmt:message key="label.description.company2"/></p>
                </h3>
            </div>
        </div>

        <div id = "contacts">


        </div>

        <div id = "feedback">


        </div>
    </main>
</body>
</html>
