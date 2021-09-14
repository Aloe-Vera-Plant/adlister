<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit</title>
  <%@include file="/WEB-INF/partials/head.jsp" %>

</head>
<body>
<jsp:include page="../partials/logged_navbar.jsp"/>

<div class="container">
    <h1>Edit Ad</h1>
    <form action="/ads/edit-ad" method="post">
        <div class="form-group">
            <label for="adid">Ad ID:</label>
            <input id="adid" name="adid" readonly value="<c:out value="${id}"/>">
            <br>
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text" value="<c:out value="${title}"/>">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" type="text"><c:out value="${description}"/></textarea>
        </div>
    <button type="submit" class="btn btn-block btn-primary">Submit</button>
    </form>
</div>

<jsp:include page="/WEB-INF/partials/scripts.jsp"/>

</body>
</html>
