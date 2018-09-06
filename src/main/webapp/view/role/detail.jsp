    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>公寓管理系统 - 角色添加</title>
	<link rel="stylesheet" href="../../css/main.css">
	<link rel="stylesheet" href="../../lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>角色</h3>
	<form action="#" method="post">
	<table class="form-table">
			<tr>
				<td class="label">角色名称</td>
				<td colspan="3" class="detail">
					${role.rName }
				</td>
			</tr>
			<tr>
				<td class="label">角色描述</td>
				<td colspan="3" class="detail">
					${role.rDesc }
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