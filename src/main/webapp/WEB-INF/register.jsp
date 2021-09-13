<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Aloe Adlister Sign-Up" />
    </jsp:include>
</head>
<body>
<c:choose>
    <c:when test="${user != null}">
        <jsp:include page="partials/logged_navbar.jsp"/>
    </c:when>
    <c:otherwise>
        <jsp:include page="partials/default_navbar.jsp"/>
    </c:otherwise>
</c:choose>
    <div class="container">
        <h1>Please fill out the required fields.</h1>
        <form action="/register" method="post">
            <c:if test = "${invalidregistration}">
                <p style="color: darkred">Your username was taken or your input was invalid. Please try again.</p>
            </c:if>
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input id="email" name="email" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <div class="form-group">
                <label for="confirm_password">Confirm Password</label>
                <input id="confirm_password" name="confirm_password" class="form-control" type="password">
            </div>
            <input type="submit" class="btn btn-primary btn-block">
        </form>
    </div>
<jsp:include page="partials/scripts.jsp"/>
</body>
</html>
