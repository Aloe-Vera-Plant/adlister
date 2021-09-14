<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="/WEB-INF/partials/head.jsp"%>
</head>
<body>
    <%@include file="/WEB-INF/partials/navbar.jsp"%>
    <div class="container">
        <h1>${title}</h1>
        <p>${description}</p>
        <p>Ad id: ${id}</p>
        <p>Posted by: ${username}</p>
        <p>Email: ${email}</p><%-- Not sure about this, may be privacy issue --%>
    </div>
</body>
</html>
