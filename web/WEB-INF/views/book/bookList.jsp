<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>
</head>
<body>
<h1>Book List</h1>
<table>
    <thead>
        <th>책 번호</th>
        <th>ISBN</th>
        <th>책 제목</th>
        <th>저자</th>
        <th>출판일</th>
        <th>책 위치</th>
        <th>책 상캐</th>
    </thead>

    <tbody>
        <c:forEach var="book" items="${books}">
            <tr>
                <td>${book.bookSeq}</td>
                <td>${book.bookIsbn}</td>
                <td>${book.bookTitle}</td>
                <td>${book.bookAuthor}</td>
                <td>${book.bookPublishedDate}</td>
                <td>${book.bookPosition}</td>
                <td>${book.bookStatus}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>