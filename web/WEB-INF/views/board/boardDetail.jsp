<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: gwanii
  Date: 2023/07/26
  Time: 3:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 디테일 페이지</title>
    <style>
        .container {
            max-width: 800px;
            margin: 20px auto;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            padding: 20px;
        }

        .post-title {
            font-size: 24px;
            font-weight: bold;
            margin-bottom: 10px;
        }

        .post-info {
            color: #666;
            margin-bottom: 10px;
        }

        .post-content {
            margin-bottom: 20px;
            line-height: 1.6;
        }

        .attachment {
            margin-bottom: 20px;
        }

        .attachment-label {
            font-weight: bold;
        }

        .attachment-data {
            border: 1px solid #ccc;
            padding: 10px;
            border-radius: 5px;
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
<div class="container">
    <h1 class="post-title">${board.title}</h1>
    <div class="post-info">
        작성자: ${board.writer} | 작성일자: ${board.createDate} | 조회수: ${board.readCount}
    </div>
    <div class="post-content">
        <p>
            ${board.content}
        </p>
    </div>
    <div class="attachment">
        <span class="attachment-label">
            <p>첨부파일</p>
            <c:if test="${board.attatchData != null}">
                <img src="/boards/display/${board.attatchData}">
            </c:if>
        </span>
        <div class="attachment-data">
            <c:if test="${board.attatchData != null}">
                <a href="/boards/download/${board.attatchData}">다운로드</a>
            </c:if>
        </div>
    </div>

    <div class="deleteBox">
        <input type="password" id="password" name="password" placeholder="비밀번호를 입력하시오.">
        <button type="button" id="deleteFormBtn" onclick="deleteFunc()">삭제하기</button>
    </div>
</div>

<script>

    async function deleteFunc() {

        let data = {
            seq: ${board.seq},
            password: document.querySelector("#password").value
        };

        await fetch("/boards/${board.seq}", {
            method: "DELETE",
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(data)
        })
            .then(response => {
                if (response.status >= 400) {
                    alert("삭제에 실패하였습니다. 비밀번호를 다시 확인해주세요.")
                    return;
                }

                location.href = "/boards";
            })
    }

</script>
</body>
</html>
