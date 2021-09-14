<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>

        <jsp:include page="partials/logged_navbar.jsp"/>



    <div class="container">
        <h1>Welcome, ${sessionScope.user.username}!</h1>
    </div>
<jsp:include page="partials/scripts.jsp"/>

    <div>
        <a href="/ads/search">Searching for an ad?</a>
    </div>

</body>
</html>
