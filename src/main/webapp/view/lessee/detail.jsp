    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
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
	<h3>租户信息</h3>
	<form action="#" method="post">
	<table class="form-table">
		<tr>
				<td class="label">租户姓名</td>
				<td class="detail">
					${lessee.lId }
				</td>
			</tr>
			<tr>
				<td class="label">租户电话</td>
				<td colspan="3" class="detail">
					${lessee.lTel }
				</td>
			</tr>
			<tr>
				<td class="label">性别</td>
				<td colspan="3" class="detail">
					${lessee.lSex }
				</td>
			</tr>
			<tr>
				<td class="label">籍贯</td>
				<td colspan="3" class="detail">
					${lessee.lNativePlace }
				</td>
			</tr>
			<tr>
				<td class="label">身份证号</td>
				<td colspan="3" class="detail">
					${lessee.lIdcade }
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