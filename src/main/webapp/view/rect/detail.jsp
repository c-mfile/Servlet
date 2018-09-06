    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>公寓管理系统 - 房租信息</title>
	<link rel="stylesheet" href="../../css/main.css">
	<link rel="stylesheet" href="../../lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>房租信息</h3>
	<form action="#" method="post">
	<table class="form-table">
		<tr>
				<td class="label">缴纳金额</td>
				<td class="detail">
					${rect.rMoney }
				</td>
			</tr>
			<tr>
				<td class="label">缴纳时间</td>
				<td colspan="3" class="detail">
					${rect.rTime }
				</td>
			</tr>
			<tr>
				<td class="label">备注</td>
				<td colspan="3" class="detail">
					${rect.rRemark }
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