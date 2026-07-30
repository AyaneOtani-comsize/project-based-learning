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
	<%@ include file="loginCheckHeader.jsp" %>
	<h1>タスク一覧表示</h1>
	
	<hr>
	<br>
	
	<%
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
					<td>
					<%
						if (task.getTaskName() != null) {
							%><%=task.getTaskName() %><%
						}
					%>
					</td>
					<td>
					<%
						if (task.getCategoryName() != null) {
							%><%=task.getCategoryName() %><%
						}
					%>
					</td>
					<td>
					<%
						if (task.getLimitDate() != null) {
							%><%=task.getLimitDate() %><%
						}
					%>
					</td>
					<td>
					<%
						if (task.getUserName() != null) {
							%><%=task.getUserName() %><%
						}
					%>
					</td>
					<td>
					<%
						if (task.getStatusName() != null) {
							%><%=task.getStatusName() %><%
						}
					%>
					</td>
					<td>
					<%
						if (task.getMemo() != null) {
							%><%=task.getMemo() %><%
						}
					%>
					</td>
					<td>
						<%
							if (user.getUserName().equals(task.getUserName())) {
								%>
									<div style="display:inline-flex">
										<form action="edit.jsp?taskName=<%=task.getTaskId() %>" method="get"><input type="submit" value="編集"></form>
										&nbsp<!-- 半角スペース -->
										<form action="rest.jsp?taskName=<%=task.getTaskId() %>" method="get"><input type="submit" value="削除"></form>
									</div>
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