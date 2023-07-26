<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Board List</title>
</head>
<body>
<h1>Board List</h1>
<table>
    <thead>
        <th>번호</th>
        <th>제목</th>
        <th>내용</th>
        <th>작성자</th>
        <th>조회수</th>
        <th>작성일</th>
    </thead>

    <tbody>
    <c:forEach var="board" items="${boards}">
        <tr>
            <td>${board.seq}</td>
            <td>
                <a href="/boards/${board.seq}">${board.title}</a>
            </td>
            <td>${board.content}</td>
            <td>${board.writer}</td>
            <td>${board.readCount}</td>
            <td>${board.createDate}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>

<a href="/boards/registerForm">작성하러 가기</a>
</body>
</html>