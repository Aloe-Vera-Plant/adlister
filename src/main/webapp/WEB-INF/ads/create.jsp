<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Create a new Ad"/>
    </jsp:include>
</head>
<body>

<jsp:include page="../partials/logged_navbar.jsp"/>


<div class="container">
    <h1>Create New Ad</h1>
    <form action="/ads/create" method="post">

        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text">
        </div>
        <div>
            <label for="img">Include image link:</label>
            <input type="text" id="img" name="img">
        </div>
        <div class="form-group">
            <input type="checkbox" name="categories1" value="1">Goods</input>
            <input type="checkbox" name="categories2" value="2">Services</input>
            <input type="checkbox" name="categories3" value="3">Jobs</input>
            <input type="checkbox" name="categories4" value="4">Personals</input>
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" type="text"></textarea>
        </div>
        <input type="submit" class="btn btn-block btn-primary">
    </form>

</div>

</div>

<jsp:include page="/WEB-INF/partials/scripts.jsp"/>

</body>
</html>
