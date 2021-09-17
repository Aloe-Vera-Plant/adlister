<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/WEB-INF/partials/head.jsp" %>
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
    <a href="/ads" style="margin-bottom: 15px"><button type="button" class="btn btn-primary"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-arrow-return-left" viewBox="0 0 16 16">
        <path fill-rule="evenodd" d="M14.5 1.5a.5.5 0 0 1 .5.5v4.8a2.5 2.5 0 0 1-2.5 2.5H2.707l3.347 3.346a.5.5 0 0 1-.708.708l-4.2-4.2a.5.5 0 0 1 0-.708l4-4a.5.5 0 1 1 .708.708L2.707 8.3H12.5A1.5 1.5 0 0 0 14 6.8V2a.5.5 0 0 1 .5-.5z"/>
    </svg> Return to Ads</button></a>
    <div class="row d-flex justify-content-center" style="margin-top: 25px">
        <h1>${title}</h1>
    </div>
    <div class="row justify-content-end">
        <c:if test="${user.username == username || user.username == 'admin'}">
            <div class="dropdown">
                <a class="btn btn-danger dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false" style="margin-right: 0">
                </a><hr>

                <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <li><a class="dropdown-item" href="/ads/edit-ad?id=${id}&uid=${username}">Edit</a></li>
                    <li><a class="dropdown-item" href="/ads/delete?id=${id}&uid=${username}">Delete</a></li>
                </ul>
            </div>
        </c:if>
    </div>
    <div class="row d-flex justify-space-between">
        <div class="col-4">
            <p>Posted by: ${username}</p><br>
            <p class="cluster">Posted at: ${date}</p>
        </div>
        <div class="col-4">
            <p>Ad ID: ${id}</p>
        </div>
        <div class="col-4">
            <p>Email: ${email}</p><%-- Not sure about this, may be privacy issue --%>
        </div>
    </div>
    <div class="row">
        <img class="viewPage" src="${img}">
        <hr>
    </div>
    <div class="row">
        <p>${description}</p>
        <hr>
    </div>
</div>
<jsp:include page="/WEB-INF/partials/scripts.jsp"/>

</body>
</html>
