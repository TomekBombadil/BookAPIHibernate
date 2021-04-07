<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Usuń książkę</title>
</head>
<body>
Czy usunąc?<br>
<form:form method="POST" modelAttribute="bootodelete">
    <form:hidden path="id"/>
    <input type="submit" value="Tak"/>
</form:form>
<form:form method="GET" action="/admin/books/all">
    <input type="submit" value="Nie"/>
</form:form>
</body>
</html>
