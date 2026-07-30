<%@page import="model.entity.UserBean"%>
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
		//セッションスコープからユーザ情報を取得
		UserBean user = (UserBean) session.getAttribute("user");
		
		//リクエストスコープからタスクリストを取得
		List<TaskBean> taskList = (List<TaskBean>) request.getAttribute("taskList");
		
		//タスクリストが存在しない、もしくは登録されているタスクが0件である場合
		if (taskList == null || taskList.size() == 0) {
			%>情報が存在しません。<br><%
		} else {		
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
		
		<%
			for (TaskBean task : taskList) {
				%>
				<tr>
					<td><%=task.getTaskName() %></td>
					<td><%=task.getCategoryName() %></td>
					<td><%=task.getLimitDate() %></td>
					<td><%=task.getUserName() %></td>
					<td><%=task.getStatusName() %></td>
					<td><%=task.getMemo() %></td>
					<td>
						<%
							if (user.getUserName().equals(task.getUserName())) {
								%>
									<form action="edit.jsp<?<%=task.getTaskName() %>" method="get"><input type="submit" value="編集"></form>
									<form action="rest.jsp?<%=task.getTaskName() %>" method="get"><input type="submit" value="削除"></form>
								<%
							}
						%>
					</td>
				</tr>
				<%
			}
		%>
	</table>
	<%
		}
	%>
	
	<br>
	<form action="menu.jsp"><input type="submit" value="メニュー画面へ"></form>
	
</body>
</html>