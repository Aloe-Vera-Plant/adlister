<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
</head>
<body>
<c:choose>
    <c:when test="${user != null}">
        <jsp:include page="../partials/logged_navbar.jsp"/>
    </c:when>
    <c:otherwise>
        <jsp:include page="../partials/default_navbar.jsp"/>
    </c:otherwise>
</c:choose>

<div class="container">
    <h1>Here is a listing of our current ads:</h1>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
            <p>ID#: <c:out value="${ad.id}"></c:out></p>
            <h5>Posted by: <c:out value="${ad.username}"></c:out></h5>
        </div>
    </c:forEach>
</div>
<jsp:include page="/WEB-INF/partials/scripts.jsp"/>

</body>
</html>
