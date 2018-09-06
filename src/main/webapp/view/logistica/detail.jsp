    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>公寓管理系统 - 后勤人员信息添加</title>
	<link rel="stylesheet" href="../../css/main.css">
	<link rel="stylesheet" href="../../lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>后勤人员信息</h3>
	<form action="#" method="post">
	<table class="form-table">
		<tr>
				<td class="label">后勤人员姓名</td>
				<td class="detail">
					${log.laName }
				</td>
			</tr>
			<tr>
				<td class="label">身份证号</td>
				<td colspan="3" class="detail">
					${log.laIdcard }
				</td>
			</tr>
			<tr>
				<td class="label">手机号</td>
				<td colspan="3" class="detail">
					${log.laTel }
				</td>
			</tr>
			<tr>
				<td class="label">性别</td>
				<td colspan="3" class="detail">
					${log.laSex }
				</td>
			</tr>
			<tr>
				<td class="label">部门岗位</td>
				<td colspan="3" class="detail">
					${log.laDept }
				</td>
			</tr>
			<tr>
				<td class="label">工资</td>
				<td colspan="3" class="detail">
					${log.laSalary }
				</td>
			</tr>
			<tr>
				<td class="label">籍贯</td>
				<td colspan="3" class="detail">
					${log.laHogar }
				</td>
			</tr>
		</table>
		<div class="buttons">
			<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
		</div>
	</form>
</div>
</body>
</html>