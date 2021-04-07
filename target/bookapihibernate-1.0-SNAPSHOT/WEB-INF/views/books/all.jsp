<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Książki</title>
</head>
<body>
<a href="/admin/books/add">Dodaj książkę</a><br>
<table border="1">
    <thead>
        <th>No</th>
        <th>Isbn</th>
        <th>Tytuł</th>
        <th>Autor</th>
        <th>Wydawca</th>
        <th>Gatunek</th>
        <th></th>
        <th></th>
    </thead>
    <c:forEach items="${books}" var="book" varStatus="vs">
        <tr>
            <td>${vs.index+1}</td>
            <td><c:out value="${book.isbn}"/></td>
            <td><c:out value="${book.title}"/></td>
            <td><c:out value="${book.author}"/></td>
            <td><c:out value="${book.publisher}"/></td>
            <td><c:out value="${book.type}"/></td>
            <td><a href="/admin/books/edit?id=${book.id}">Edytuj</a></td>
            <td><a href="/admin/books/delete?id=${book.id}"/>Usuń</td>
            <td><a href="/admin/books/show?id=${book.id}"/>Pokaż</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
