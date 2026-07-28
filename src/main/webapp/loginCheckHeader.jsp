<%@page import="model.entity.UserBean"%>
<%@ page pageEncoding="UTF-8"%>

<%
	//セッションからログインしているユーザの情報を取得
	UserBean user = (UserBean) session.getAttribute("user");
	
	//もし未ログイン状態ならログイン画面へ遷移させる
%>