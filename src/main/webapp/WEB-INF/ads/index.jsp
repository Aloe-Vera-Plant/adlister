<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Index of Ads"/>
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
    <div class="row">
        <div class="d-flex justify-content-center">
            <h1>Aloe Adlister</h1>
        </div>
        <div class="d-flex justify-content-center">
            <c:if test="${user == null}">
                <div class="alert alert-primary alert-dismissible fade show" role="alert">
                    <strong>
                        <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor"
                             class="bi bi-exclamation" viewBox="0 0 16 16">
                            <path d="M7.002 11a1 1 0 1 1 2 0 1 1 0 0 1-2 0zM7.1 4.995a.905.905 0 1 1 1.8 0l-.35 3.507a.553.553 0 0 1-1.1 0L7.1 4.995z"/>
                        </svg>
                        You are not currently logged in!</strong> Most of our features require an account to access!
                    Login or register now for full access.
                    <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
                </div>
            </c:if>
        </div>
    </div>


    <div class="bs-example">
        <div class="container">
            <div class="row">
                <div class="card-deck">
                <c:forEach var="ad" items="${ads}">
                    <div class="card" style="width: 350px">
                        <h5 class="text-center">${ad.title}</h5>
                        <p class="cluster text-center">ID#: <c:out value="${ad.id}"></c:out></p>
                        <c:if test="${ad.image != null}">
                            <img src="${ad.image}" class="card-img-top" alt="Card image">
                            <%--                            <hr>--%>
                        </c:if>
                        <div class="card-body ">
                            <h4 class="card-title">Posted by: <c:out value="${ad.username}"></c:out></h4>
                            <p class="card-text">Posted at: ${ad.date}</p>
                            <p class="card-text">${ad.categories}</p>
                            <p class="card-text text-center overflow-auto" style="width: auto; height: 200px;">${ad.description}</p>
                            <a href="/view-ad?id=${ad.id}" class="btn btn-primary">See Ad</a>
                        </div>
                    </div>
                </c:forEach>
            </div>
            </div>
        </div>
    </div>

</div>
<jsp:include page="/WEB-INF/partials/scripts.jsp"/>

</body>
</html>
