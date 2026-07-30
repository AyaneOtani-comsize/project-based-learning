<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
</head>
<body>
	<h1>ログイン</h1>
	
	<hr>
	
	<%
		if (session.getAttribute("loginErr") != null) {
			%><font color="red">ログインに失敗しました。</font><br><%
		}
	%>
	
	<form action="login-servlet" method="post">
		ユーザIDとパスワードを入力して下さい。
		<table border="1">
			<tr>
				<td align="center">ユーザID</td>
				<td><input type="text" name="userId" required maxlength="24"></td>
			</tr>
			<tr>
				<td align="center">パスワード</td>
				<td><input type="password" name="password" required maxlength="32"></td>
			</tr>
		</table>
		<input type="submit" value="ログイン">
		<input type="reset" value="クリア">
	</form>
</body>
</html>