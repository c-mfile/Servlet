<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>公寓管理系统 - 登录页面</title>
	<link rel="stylesheet" href="http://localhost:8080/Project1/css/index.css">
</head>
<body>
<div class="login">
	<img src="http://localhost:8080/Project1/image/logo.png" alt="智游">
	<p>公寓管理系统</p>
	<form action="userlogin.do" method="post">
	<div>
		<input type="text" id="username" name="username" value="" placeholder="请输入用户名">
	</div>
	<div>
		<input type="password" id="password" name="password" value="" placeholder="请输入密码">
	</div>
	<div>
	<input name="vcode"/>
		<img src="http://localhost:8080/Project1/code" onclick="this.src='http://localhost:8080/Project1/code?'+Math.random();"
		class="s1" title="点击更换">
	</div>
	<div>
		<p class="error-message">${msg }</p>
		<input type="submit" value="登录">
	</div>
	</form>
</div>
<script>
	if (window.top !== window) {
		window.top.location.reload();
	}
	
</script>
</body>
</html>