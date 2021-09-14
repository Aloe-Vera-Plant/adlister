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
    <div class="row d-flex justify-content-center">
        <h1>${title}</h1>
    </div>
    <div class="row justify-content-end">
        <c:if test="${user.username == username || user.username == 'admin'}">
            <div class="dropdown">
                <a class="btn btn-danger dropdown-toggle" href="#" role="button" id="dropdownMenuLink" data-bs-toggle="dropdown" aria-expanded="false" style="margin-right: 0">
                </a>

                <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                    <li><a class="dropdown-item" href="/ads/edit-ad?id=${id}&uid=${username}">Edit</a></li>
                    <li><a class="dropdown-item" href="/ads/delete?id=${id}&uid=${username}">Delete</a></li>
                </ul>
            </div>
        </c:if>
    </div>
    <div class="row d-flex justify-space-between">
        <div class="col-4">
            <p>Posted by: ${username}</p>
        </div>
        <div class="col-4">
            <p>Ad ID: ${id}</p>
        </div>
        <div class="col-4">
            <p>Email: ${email}</p><%-- Not sure about this, may be privacy issue --%>
        </div>
    </div>
    <div class="row">
        <p>${description}</p>
    </div>
</div>
<jsp:include page="/WEB-INF/partials/scripts.jsp"/>

</body>
</html>
