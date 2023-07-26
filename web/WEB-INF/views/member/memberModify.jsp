<%--
  Created by IntelliJ IDEA.
  User: gwanii
  Date: 2023/07/26
  Time: 1:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <style>
        .container {
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            width: 300px;
        }

        .profile-info {
            text-align: center;
            margin-top: 20px;
        }

        .profile-info h2 {
            margin-bottom: 10px;
        }

        .profile-info p {
            margin: 5px 0;
        }
    </style>
</head>
<body>
<div class="container">
    <form action="/members/${member.userSeq}/modify">
        <div class="profile-info">
            <input type="hidden" value="${member.userSeq}">
            <h2>${member.userId}</h2>
            <input type="text" name="phoneNumber" value="${member.userPhoneNumber}">
            <p>${member.userStatus}</p>
            <p>${member.userGrade}</p>
            <p>${member.maxBook}</p>
            <p>${member.serviceStop == null ? '-' : member.serviceStop}</p>
        </div>

        <button type="submit">수정하기</button>
    </form>
</div>


</body>
</html>

