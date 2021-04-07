<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Dodaj książkę</title>
    <style>
        .error {
            color: red;
        }
    </style>
</head>
<body>
<form:form method="POST" modelAttribute="newbook">
    Isbn:
    <form:input path="isbn"/><form:errors path="isbn" cssClass="error"/><br>
    Tytuł:
    <form:input path="title"/><form:errors path="title" cssClass="error"/><br>
    Autor:
    <form:input path="author"/><form:errors path="author" cssClass="error"/><br>
    Wydawca:
    <form:input path="publisher"/><form:errors path="publisher" cssClass="error"/><br>
    Gatunek:
    <form:select path="type">
        <form:options items="${alltypes}"/>
    </form:select><form:errors path="type" cssClass="error"/><br>
    <input type="submit" value="Wyślij"/>
</form:form>
</body>
</html>
