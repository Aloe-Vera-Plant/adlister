<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="AloeAdlister" />
    </jsp:include>

</head>
<body>
<c:choose>
    <c:when test="${user != null}">
        <jsp:include page="/WEB-INF/partials/logged_navbar.jsp"/>
    </c:when>
    <c:otherwise>
        <jsp:include page="/WEB-INF/partials/default_navbar.jsp"/>
    </c:otherwise>
</c:choose>
    <div class="container">
        <div class="row centered">
            <h1 class="centered" style="justify-content: center">Welcome to the Aloe Adlister!</h1> <hr>
            <h3 class="centered" style="justify-content: center">Anything you need, we probably have! Anything, anywhere!</h3>

        </div>

        <div class="row justify-content-center">
            <img src="http://www.clker.com/cliparts/r/N/5/b/3/s/world-map-transparent-hi.png">
        </div>

    </div>
<jsp:include page="/WEB-INF/partials/scripts.jsp"/>

</body>
</html>
