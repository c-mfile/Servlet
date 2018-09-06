<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>公寓管理系统 - 用户添加</title>
	<link rel="stylesheet" href="../../css/main.css">
	<link rel="stylesheet" href="../../lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>用户信息</h3>
	<form action="userUpdate.do" method="post">
	<table class="form-table">
		<tr>
			<td>用户名</td>
			<td colspan="3" class="control">
				<input type="hidden" name="uId" value="${user.uId }">
				<input type="text" name="uUsername" value="${user.uUsername}">
			</td>
		</tr>
		<tr>
			<td>密码</td>
			<td colspan="3" class="control">
				<input type="text" name="uPassword" value="${user.uPassword}">
			</td>
		</tr>
		<tr>
			<td>昵称</td>
			<td colspan="3" class="control">
				<input type="text" name="uName" value="${user.uName}">
			</td>
		</tr>
		<tr>
			<td>电话</td>
			<td colspan="3" class="control">
				<input type="text" name="uTel" value="${user.uTel}">
			</td>
		</tr>
		<tr>
			<td>状态</td>
			<td colspan="3" class="control">
				<input type="text" name="uStatus"value="${user.uStatus}">
			</td>
		</tr>

	</table>
	<div class="buttons">
		<input class="btn btn-primary va-bottom" type="submit" value="保存">&nbsp;&nbsp;
		<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
	</div>
	</form>
</div>
</body>
</html>