<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Książka</title>
</head>
<body>
<a href="/admin/books/all">Wszystkie książki</a><br>
<table border="1">
    <tr>
        <td>Isbn</td><td>${booktoshow.isbn}</td>
    </tr>
    <tr>
        <td>Tytuł</td><td>${booktoshow.title}</td>
    </tr>
    <tr>
        <td>Autor</td><td>${booktoshow.author}</td>
    </tr>
    <tr>
        <td>Wydawca</td><td>${booktoshow.publisher}</td>
    </tr>
    <tr>
        <td>Gatunek</td><td>${booktoshow.type}</td>
    </tr>
</table>
</body>
</html>
