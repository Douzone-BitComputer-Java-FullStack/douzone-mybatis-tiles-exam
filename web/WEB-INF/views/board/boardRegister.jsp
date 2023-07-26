<%--
  Created by IntelliJ IDEA.
  User: gwanii
  Date: 2023/07/26
  Time: 3:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시글 작성</title>
    <style>
        .container {
            max-width: 800px;
            margin: 20px auto;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            padding: 20px;
            height: 100%;
        }

        .form-group {
            margin-bottom: 20px;
        }

        .form-group label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
        }

        .form-group input{
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .form-group button {
            padding: 10px 20px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }

        .form-group button:hover {
            background-color: #0056b3;
        }

        .form-group #content {
            width: 600px;
            height: 150px;
            border: solid 1px black;
            border-radius: 5px;
            resize: none;
            margin-bottom: 20px;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>게시글 작성</h1>
    <form action="/boards/register" method="post" enctype="multipart/form-data">
        <div class="form-group">
            <label for="title">제목</label>
            <input type="text" id="title" name="title" required>
        </div>
        <div class="form-group">
            <label for="writer">작성자</label>
            <input type="text" id="writer" name="writer" required>
        </div>
        <div class="form-group" style="height: 150px">
            <label for="content">내용</label>
            <textarea id="content" name="content" required ></textarea>
        </div>

        <div class="form-group">
            <labe for="uploadFile">첨부파일</labe>
            <input type="file" id="uploadFile" name="uploadFile">
        </div>

        <div class="form-group">
            <labe for="password">비밀번호</labe>
            <input type="password" id="password" name="password">
        </div>

        <div class="form-group">
            <button type="submit">작성하기</button>
        </div>

    </form>
</div>
</body>
</html>

