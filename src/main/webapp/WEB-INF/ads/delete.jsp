<%--
  Created by IntelliJ IDEA.
  User: deceir
  Date: 9/14/21
  Time: 12:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Delete Ad</title>
    <%@include file="/WEB-INF/partials/head.jsp" %>
</head>
<body>
<jsp:include page="../partials/logged_navbar.jsp"/>

<div class="container">
    <form method="post" action="/ads/delete">
        <label for="adid">Ad ID:</label><br>
        <input id="adid" name="adid" readonly value="${id}"><br>
        <label for="confirm">Are you sure you want to delete this ad? This process is irreversible.</label><br>
        <select name="confirm" id="confirm">
            <option value="1">Yes</option>
            <option selected value="0">No</option>
        </select><br>
        <button type="submit" class="btn btn-danger">Delete</button>

    </form>
</div>


<jsp:include page="/WEB-INF/partials/scripts.jsp"/>

</body>
</html>
