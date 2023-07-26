<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"
         isELIgnored="false" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>

<!DOCTYPE html>
<html>
<meta charset="UTF-8">
<head>
    <title>헤더</title>
</head>
<b ody>
<table border=0 width="100%">
    <tr>
        <td>
            <img alt="image" src="<c:url value='/resources/image/duke_swing.gif'/>"/>
        </td>
        <td>
            <h1><font size=30>스프링실습 홈페이지!!</font></h1>
        </td>

        <td>
            <c:choose>
                <c:when test="${user != null}">
                    <h3>환영합니다. ${user.userId }님!</h3>
                    <a href="${contextPath}/member/logout"><h3>로그아웃</h3></a>
                </c:when>
                <c:otherwise>
                    <a href="${contextPath}/member/loginForm"><h3>로그인</h3></a>
                    <a href="${contextPath}/member/registerForm"><h3>회원가입</h3></a>
                </c:otherwise>
            </c:choose>
        </td>
    </tr>
</table>


</body>
</html>