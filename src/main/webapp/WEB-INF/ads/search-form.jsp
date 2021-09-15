<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: telvinmathews
  Date: 9/13/21
  Time: 8:39 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>

<title>Title</title>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Search Ads" />
    </jsp:include>
</head>
<body>
<jsp:include page="../partials/logged_navbar.jsp"/>
<div class="container">
    <form action="/ads/search/display" method="post">
        Find ad: <input type="text" name="adToSearchFor">
        <input type="submit" name="Submit"/>
    </form>

    <c:choose>
        <c:when test="${ads != null}">
            <c:forEach var="ad" items="${ads}">
                <h3>
                    <a href="/view-ad?id=${ad.id}">${ad.title}</a>
                    <small>${ad.description}</small>
                </h3>
            </c:forEach>
        </c:when>
    </c:choose>

    <jsp:include page="/WEB-INF/partials/scripts.jsp"/>

</div>
</body>
</html>
