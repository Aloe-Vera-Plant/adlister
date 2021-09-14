<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Index of Ads" />
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
    <h3>Here is a listing of our current ads:</h3>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2><a href="/view-ad?id=${ad.id}">${ad.title}</a></h2>
            <p>${ad.description}</p>
        </div>
    </c:forEach>
</div>
<jsp:include page="/WEB-INF/partials/scripts.jsp"/>

</body>
</html>
