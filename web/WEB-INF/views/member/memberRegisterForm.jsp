<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"   isELIgnored="false"
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입 폼</title>
    <style>
        .container {
            background-color: #fff;
            padding: 60px;
            border-radius: 5px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            width: 300px;
            margin: 0 auto;
        }

        .form-group {
            margin-bottom: 15px;
        }

        .form-group label {
            display: block;
            font-weight: bold;
            margin-bottom: 5px;
        }

        .form-group input {
            width: 100%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        .form-group button {
            width: 100%;
            padding: 10px;
            background-color: #007bff;
            color: #fff;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        .form-group button:hover {
            background-color: #0056b3;
        }
    </style>
</head>
<body>
<div class="container">
    <h2>회원가입</h2>
    <form action="/member/register" method="post" id="registerForm" onsubmit="return validateForm()">
        <div class="form-group">
            <label for="username">아이디</label>
            <input type="text" id="username" name="userId" required>
            <button onclick="idCheckFunc()">아이디 확인</button>
        </div>
        <div class="form-group">
            <label for="password">비밀번호</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div class="form-group">
            <label for="phone">핸드폰번호</label>
            <input type="tel" id="phone" name="phone" required>
        </div>

        <input hidden="hidden" id="idValidationFlag" value="false">
        <div class="form-group">
            <button type="submit">가입하기</button>
        </div>
    </form>
</div>

<script>
    function validateForm() {
        event.preventDefault();
        console.log("실행은 됨??")
        const idValidationFlag = document.querySelector("#idValidationFlag").value;

        if (!idValidationFlag) {
            alert("아이디 중복확인을 확인해 주세요!");
            return false;
        }

        const phoneInput = document.querySelector('#phone');
        const phoneValue = phoneInput.value.trim();

        const phonePattern = /^[0-9]{3}-[0-9]{3,4}-[0-9]{4}$/;

        if (!phonePattern.test(phoneValue)) {
            alert("올바른 핸드폰번호를 입력해주세요. (예: 010-1234-5678)");
            return false;
        }

        document.querySelector("#registerForm").submit();

        return true;
    }

    async function idCheckFunc() {
        let userId = document.querySelector("#username").value;

        if (userId === undefined || userId === null || userId === "") {
            alert("다시 확인해주세요");
            return;
        }

        await fetch("/async/member/duplicateCheck?memberId=".concat(userId))
            .then(response => {
                if (response.status === 200) {
                    alert("사용 가능한 아이디 입니다.")
                    document.querySelector("#idValidationFlag").value = true;
                } else {
                    alert("사용할 수 없는 아이디 입니다.");
                }
            });
    }
</script>
</body>
</html>
