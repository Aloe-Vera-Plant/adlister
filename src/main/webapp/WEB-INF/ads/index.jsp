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

    <c:if test="${user == null}">
        <div class="alert alert-primary alert-dismissible fade show" role="alert">
            <strong><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-exclamation" viewBox="0 0 16 16">
                <path d="M7.002 11a1 1 0 1 1 2 0 1 1 0 0 1-2 0zM7.1 4.995a.905.905 0 1 1 1.8 0l-.35 3.507a.553.553 0 0 1-1.1 0L7.1 4.995z"/>
            </svg> You are not currently logged in!</strong> Most of our features require an account to access! Login or register now for full access.
            <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
        </div>
    </c:if>


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
