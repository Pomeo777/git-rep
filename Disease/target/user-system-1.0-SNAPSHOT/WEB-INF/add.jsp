
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags/form" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <spring:form modelAttribute="filePath" method="post" action="/user-system/hello/addDisease">
        <spring:input path="searchName"/>
        <spring:button>SEARCH</spring:button>
    </spring:form>
</body>
</html>
</body>
</html>