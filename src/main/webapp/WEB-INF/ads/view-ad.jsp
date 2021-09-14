<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/WEB-INF/partials/head.jsp"%>
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
        <h1>${title}</h1>
        <p>${description}</p>
        <p>Ad ID: ${id}</p>
        <p>Posted by: ${username}</p>
        <p>Email: ${email}</p><%-- Not sure about this, may be privacy issue --%>
    </div>
<jsp:include page="/WEB-INF/partials/scripts.jsp"/>

</body>
</html>
