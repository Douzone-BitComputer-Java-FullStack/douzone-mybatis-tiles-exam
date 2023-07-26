<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>LoginForm</title>

	<style>
		.container {
			background-color: #fff;
			padding: 20px;
			border-radius: 5px;
			box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
			width: 300px;
		}

		.form-group {
			margin-bottom: 20px;
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
	<h2>로그인</h2>
	<form action="/member/login" method="post">
		<div class="form-group">
			<label for="id">아이디</label>
			<input type="text" id="id" name="id" required>
		</div>
		<div class="form-group">
			<label for="pass">비밀번호</label>
			<input type="password" id="pass" name="pass" required>
		</div>
		<div class="form-group">
			<button type="submit">로그인</button>
		</div>
	</form>
</div>
</body>
</html>