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
	<form action="roleUpdate.do" method="post">
	<table class="form-table">
		<tr>
			<td>角色名称</td>
			<td colspan="3" class="control">
				<input type="hidden" name="rId" value="${role.rId }">
				<input type="text" name="rName" value="${role.rName }">
			</td>
		</tr>
		<tr>
			<td>角色描述</td>
			<td colspan="3" class="control">
				<input type="text" name="rDesc" value="${role.rDesc }">
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