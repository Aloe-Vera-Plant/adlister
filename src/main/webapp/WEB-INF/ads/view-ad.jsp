<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/WEB-INF/partials/head.jsp"%>
</head>
<body>
    <%@include file="/WEB-INF/partials/navbar.jsp"%>
    <div class="container">
        <h1>${param.title}</h1>
        <p>${param.description}</p>
    </div>
</body>
</html>
