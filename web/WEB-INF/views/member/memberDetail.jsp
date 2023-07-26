<%--
  Created by IntelliJ IDEA.
  User: gwanii
  Date: 2023/07/26
  Time: 1:21 PM
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
        <form action="/admin/members/${member.userSeq}/delete" method="post">
        <div class="profile-info">
            <p>아이디: ${member.userId}</p>
            <p>핸드폰 번호: ${member.userPhoneNumber}</p>
            <p>상태: ${member.userStatus}</p>
            <p>등급: ${member.userGrade}</p>
            <p>최대 대출 권수: ${member.maxBook}</p>
            <p>대출 정지 일자: ${member.serviceStop == null ? '-' : member.serviceStop}</p>
        </div>

            <button type="submit">회원 삭제하기</button>
        </form>
    </div>


</body>
</html>
