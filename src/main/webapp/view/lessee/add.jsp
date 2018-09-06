<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>公寓管理系统 - 租户信息添加</title>
	<link rel="stylesheet" href="../../css/main.css">
	<link rel="stylesheet" href="../../lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>添加租户信息</h3>
	<form action="lesseeAdd.do" method="post">
	<table class="form-table">
		<tr>
			<td>租户姓名</td>
			<td colspan="3" class="control">
				<input type="text" name="lName" placeholder="租户姓名">
			</td>
		</tr>
		<tr>
			<td>租户电话</td>
			<td colspan="3" class="control">
				<input type="text" name="lTel" placeholder="租户电话">
			</td>
		</tr>
		<tr>
			<td>性别</td>
			<td colspan="3" class="control">
				<input type="text" name="lSex" placeholder="性别">
			</td>
		</tr>
		<tr>
			<td>籍贯</td>
			<td colspan="3" class="control">
				<input type="text" name="lNativePlace" placeholder="籍贯">
			</td>
		</tr>
		<tr>
			<td>身份证号</td>
			<td colspan="3" class="control">
				<input type="text" name="lIdcade" placeholder="身份证号">
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