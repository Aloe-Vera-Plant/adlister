<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
    <%@include file="partials/head.jsp" %>

</head>
<body>
<jsp:include page="partials/logged_navbar.jsp"/>

<div class="container">
    <form action="/update-profile" method="post">
        <h3>Edit User Info</h3>
        <div class="form-group">
            <label for="username">Username</label>
            <input id="username" name="username"value="<c:out value="${user.username}"/>">
            <br>
            <label for="email">Email</label>
            <input id="email" name="email" value="<c:out value="${user.email}"/>">
        </div>
        <button type="submit" class="btn btn-block btn-primary">Update</button>
    </form>
</div>

<div class="container">
    <c:if test="${success != null}">
        <h5 style="color: lightgreen">Password was updated.</h5>
    </c:if>
    <form action="/update-password" method="post">
        <h3>Update Password</h3>
        <div class="form-group">
            <label for="currentPassword">Enter current password:</label>
            <input type="password" name="currentPassword" id="currentPassword">
            <br>
            <label for="newPassword">New Password</label>
            <input type="password" name="newPassword" id="newPassword">
            <label for="verifyPassword">Verify Password</label>
            <input type="password" name="verifyPassword" id="verifyPassword">
        </div>
        <button type="submit" class="btn btn-block btn-primary">Update</button>
    </form>
</div>

<jsp:include page="partials/scripts.jsp"/>

</body>
</html>
