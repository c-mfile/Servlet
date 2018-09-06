    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
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
	<h3>后勤人员信息</h3>
	<form action="logisticaUpdate.do" method="post">
	<table class="form-table">
		<tr>
			<td>后勤人员姓名</td>
			<td colspan="3" class="control">
				<input type="hidden" name="laId" value="${log.laId }">
				<input type="text" name="laName" value="${log.laName }">
			</td>
		</tr>
		<tr>
			<td>身份证号</td>
			<td colspan="3" class="control">
				<input type="text" name="laIdcard" value="${log.laIdcard }">
			</td>
		</tr>
		<tr>
			<td>手机号</td>
			<td colspan="3" class="control">
				<input type="text" name="laTel" value="${log.laTel }">
			</td>
		</tr>
		<tr>
			<td>性别</td>
			<td colspan="3" class="control">
				<input type="text" name="laSex"  value="${log.laSex }">
			</td>
		</tr>
		<tr>
			<td>部门岗位</td>
			<td colspan="3" class="control">
				<input type="text" name="laDept"  value="${log.laDept }">
			</td>
		</tr>
		<tr>
			<td>工资</td>
			<td colspan="3" class="control">
				<input type="text" name="laSalary"  value="${log.laSalary }">
			</td>
		</tr>
		<tr>
			<td>籍贯</td>
			<td colspan="3" class="control">
				<input type="text" name="laHogar"  value="${log.laHogar }">
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