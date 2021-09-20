<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile"/>
    </jsp:include>
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>

<jsp:include page="partials/logged_navbar.jsp"/>


<div class="container">

<div class="row">
<div class="col-6">

    <h1>Welcome, ${sessionScope.user.username}!</h1>

    <hr>

    <img class="pfp" src="${profilepic}">
    <div class="container">
        <div class="dropdown update">
            <a class="btn btn-primary dropdown-toggle" href="#" role="button" id="dropdownMenuLink"
               data-bs-toggle="dropdown" aria-expanded="false" style="margin-right: 0"> +
            </a>

            <ul class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                <li><a class="dropdown-item" href="/update-profile">Update Profile</a></li>

            </ul>

        </div>
    </div>

    <h4>Current contact info: ${sessionScope.user.email}</h4>

</div>
<div class="col-6">
<h3>Your ads:</h3>
    <c:forEach var="ad" items="${ads}">
        <div class="container, col-md-10 ">
            <h2>${ad.title}</h2>
            <p class="cluster">ID#: <c:out value="${ad.id}"></c:out></p>
            <div class="card" style="width:400px">
                <c:if test="${ad.image != null}">
                    <img class="card-img-top" src="${ad.image}" alt="Card image" style="width:100%">
                    <hr>
                </c:if>
                <div class="card-body">
                    <h4 class="card-title">Posted by: <c:out value="${ad.username}"></c:out></h4>
                    <p class="card-text">Posted at: ${ad.date}</p>
                    <p class="card-text">${ad.categories}</p>
                    <p class="card-text text-center overflow-auto" style="width: auto; height: 200px;">${ad.description}</p>
                    <a href="/view-ad?id=${ad.id}" class="btn btn-primary">See Ad</a>
                </div>
            </div>
            <br>
        </div>
    </c:forEach>
    </div>
    </div>

    </div>
    <jsp:include page="partials/scripts.jsp"/>

    </body>
    </html>
