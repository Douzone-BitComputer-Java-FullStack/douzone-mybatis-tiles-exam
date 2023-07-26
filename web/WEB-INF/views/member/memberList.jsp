<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member List</title>
</head>
<body>
<h1>Member List</h1>

<table>
    <thead>
        <th>번호</th>
        <th>아이디</th>
        <th>핸드폰번호</th>
        <th>상태</th>
        <th>등급</th>
        <th>최대 대출 갯수</th>
        <th>대출 정지 일자</th>
    </thead>

    <tbody>
    <c:forEach var="member" items="${members}">
        <tr>
            <td>${member.userSeq}</td>
            <td>
                <a href="/admin/members/${member.userSeq}">
                    ${member.userId}
                </a>
            </td>
            <td>${member.userPhoneNumber}</td>
            <td>${member.userStatus}</td>
            <td>${member.userGrade}</td>
            <td>${member.maxBook}</td>
            <td>${member.serviceStop == null ? '-' : member.serviceStop}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>



</body>
</html>