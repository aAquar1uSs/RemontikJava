<%--
  Created by IntelliJ IDEA.
  User: panch
  Date: 03/09/2021
  Time: 18:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<html>
<head>
    <meta charset="UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <link
            rel="stylesheet"
            href="style/style_main_window.css"

    />
    <script src="https://kit.fontawesome.com/e7cb8c5be7.js" crossorigin="anonymous"></script>
    <title>Remontik</title>
</head>
<body>
<header>
    <div class="upper-line">
        <nav role="navigation">
            <div id="menuToggle">
                <input type="checkbox"/>
                <span></span>
                <span></span>
                <span></span>
                <ul id="menu">
                    <a href="#">
                        <li>About us</li>
                    </a>
                    <a href="#">
                        <li>Contacts</li>
                    </a>
                    <a href="#">
                        <li>Leave Feedback</li>
                    </a>

                    <a href="https://erikterwan.com/" target="_blank">
                        <li>Show me more</li>
                    </a>
                </ul>

            </div>
        </nav>
        <div class="buttons">
            <div class="info">
                <form method="GET" action="">
                    <a
                            href="${pageContext.request.contextPath}/about_page"
                            class="btn btn-sm animated-button thar-two"
                    >About us</a>
                </form>
            </div>
            <div class="contacts">
                <form method="GET" action="">
                    <a
                            href="${pageContext.request.contextPath}/contacts_page"
                            class="btn btn-sm animated-button thar-two"
                    >Contacts</a>
                </form>
            </div>
            <div class="feedback">
                <form method="GET" action="ServletName">
                    <a
                            href="http://google.com"
                            class="btn btn-sm animated-button thar-two"
                    >Leave Feedback</a>
                </form>
            </div>

        </div>
        <form id = "listLanguage" method="GET" action="">
            <select id="language" name="language" onchange="submit()">
                <option value="en">English</option>
                <option value="nl">Russian</option>
                <option value="es">Ukrainian</option>
            </select>
        </form>
        <div class="account">
            <a href="${pageContext.request.contextPath}/secured/*"><i class="fas fa-user-circle"></i></a></button>
        </div>
    </div>

    <div class="head">
        <div class="name-company">
            <h1>Remontik</h1>
            <h3>Repair of computer, mobile and household equipment.</h3>
        </div>
        <div class="registration"></div>
        <div class ="set_order">
            <a href="${pageContext.request.contextPath}/set_new_order_secured/*" class="pressed-button">Submit a request for repair</a>
        </div>
    </div>
</header>

<main></main>

<footer></footer>
<footer></footer>
</body>
</html>
