<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>メニュー画面</title>
</head>
<body>
	<%@ include file="loginCheckHeader.jsp" %>
	<h1>メニュー</h1>
	
	<hr>
	<br>
	
	<form action="taskRegister.jsp" method="post">
		<input type="submit" value="タスクを登録">
	</form>
	
	<br>
	
	<form action="view-servlet" method="post">
		<input type="submit" value="タスク一覧を表示">
	</form>
	
	<br>
	
	<form action="logout-servlet" method="post">
		<input type="submit" value="ログアウト">
	</form>
</body>
</html>