<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
</head>
<body>

<jsp:include page="partials/logged_navbar.jsp"/>


<div class="container">

    <div class="row">
        <div class="col-6">

            <h1>Welcome, ${sessionScope.user.username}!</h1>
            <hr>
            <h4>Current contact info: ${sessionScope.user.email}</h4>

        </div>
        <div class="col-6">
            <h3>Your ads:</h3>
            <c:forEach var="ad" items="${ads}">
                <div class="col-md-6">
                    <h2><a href="/view-ad?id=${ad.id}"><c:out value="${ad.title}"></c:out></a></h2>
                    <p style="margin-bottom: 0px">ID#: <c:out value="${ad.id}"></c:out></p>
                    <p style="margin-top: 1px">Listed by: <c:out value="${ad.username}"></c:out></p>
                    <hr>
                    <p><c:out value="${ad.description}"></c:out></p>


                </div>
            </c:forEach>
        </div>
    </div>

</div>
<jsp:include page="partials/scripts.jsp"/>

</body>
</html>
