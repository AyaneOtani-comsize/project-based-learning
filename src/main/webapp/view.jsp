<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.List, java.util.ArrayList,model.entity.TaskBean"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>タスク一覧表示画面</title>
</head>
<body>
	<h1>タスク一覧表示</h1>
	
	<hr>
	<br>
	
	<%
		//
		
		
		//リクエストスコープからタスクリストを取得
		List<TaskBean> taskList = (List<TaskBean>) request.getAttribute("taskList");
		
		
		
	%>
	
	<table border="1" style="border-collapse: collapse; border-color: black">
		<tr>
			<th>タスク</th>
			<th>カテゴリ</th>
			<th>期限</th>
			<th>担当者</th>
			<th>ステータス</th>
			<th>メモ</th>
			<th></th>
		</tr>
		
		
		
		
	</table>
	<br>
	<form action="menu.jsp"><input type="submit" value="メニュー画面へ"></form>
	<form action="edit.jsp"><input type="submit" value="編集"></form>
	<form action="rest.jsp"><input type="submit" value="削除"></form>
	
</body>
</html>