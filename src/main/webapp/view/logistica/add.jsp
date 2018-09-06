<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>公寓管理系统 - 后勤人员添加</title>
	<link rel="stylesheet" href="../../css/main.css">
	<link rel="stylesheet" href="../../lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>添加后勤人员信息</h3>
	<form action="logisticaAdd.do" method="post">
	<table class="form-table">
		<tr>
			<td>姓名</td>
			<td colspan="3" class="control">
				<input type="text" name="laName" placeholder="姓名">
			</td>
		</tr>
		<tr>
			<td>身份证号</td>
			<td colspan="3" class="control">
				<input type="text" name="laIdcard" placeholder="身份证号">
			</td>
		</tr>
		<tr>
			<td>手机号</td>
			<td colspan="3" class="control">
				<input type="text" name="laTel" placeholder="手机号">
			</td>
		</tr>
		<tr>
			<td>性别</td>
			<td colspan="3" class="control">
				<input type="text" name="laSex" placeholder="性别">
			</td>
		</tr>
		<tr>
			<td>部门岗位</td>
			<td colspan="3" class="control">
				<input type="text" name="laDept" placeholder="部门岗位">
			</td>
		</tr>
		<tr>
			<td>工资</td>
			<td colspan="3" class="control">
				<input type="text" name="laSalary" placeholder="工资">
			</td>
		</tr>
		<tr>
			<td>籍贯</td>
			<td colspan="3" class="control">
				<input type="text" name="laHogar" placeholder="籍贯">
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