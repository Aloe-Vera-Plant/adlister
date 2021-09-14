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
        <div class="row d-flex justify-content-center">
            <h1 style="justify-content: center">Welcome to the Aloe Adlister!</h1> <hr>
            <h3 style="justify-content: center">Anything you need, we probably have!</h3>

        </div>
    </div>
<jsp:include page="/WEB-INF/partials/scripts.jsp"/>

</body>
</html>
