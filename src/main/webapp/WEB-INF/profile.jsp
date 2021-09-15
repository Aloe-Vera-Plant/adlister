<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <h3>Your posted ads:</h3>
        <c:forEach var="ad" items="${ads}">
            <div class="col-md-6">
                <h2><a href="/view-ad?id=${ad.id}"><c:out value="${ad.title}"></c:out></a></h2>
                <p><c:out value="${ad.description}"></c:out></p>
                <p>ID#: <c:out value="${ad.id}"></c:out></p>
                <h5>Posted by: <c:out value="${ad.username}"></c:out></h5>
            </div>
        </c:forEach>
    </div>
<jsp:include page="partials/scripts.jsp"/>

</body>
</html>
