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
</head>
<body>
<div>
    <form action="/ads/search/display" method="post">
        Find ad: <input type="text" name="adToSearchFor">
        <input type="submit" name="Submit"/>
    </form>
    <c:choose>
        <c:when test="${ads != null}">
            <c:forEach var="ad" items="${ads}">
                <h3>
                        ${ad.title}
                    <small>${ad.description}</small>
                </h3>
            </c:forEach>
        </c:when>
    </c:choose>


</div>
</body>
</html>
