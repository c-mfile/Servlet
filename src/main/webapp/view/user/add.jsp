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
	<form action="userAdd.do" method="post">
	<table class="form-table">
		<tr>
			<td>用户名</td>
			<td colspan="3" class="control">
				<input type="text" name="uUsername" placeholder="用户名">
			</td>
		</tr>
		<tr>
			<td>密码</td>
			<td colspan="3" class="control">
				<input type="text" name="uPassword" placeholder="密码">
			</td>
		</tr>
		<tr>
			<td>昵称</td>
			<td colspan="3" class="control">
				<input type="text" name="uName" placeholder="昵称">
			</td>
		</tr>
		<tr>
			<td>电话</td>
			<td colspan="3" class="control">
				<input type="text" name="uTel" placeholder="电话">
			</td>
		</tr>
		<tr>
			<td>状态</td>
			<td colspan="3" class="control">
				<input type="text" name="uStatus" placeholder="状态">
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