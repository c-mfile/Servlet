    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>公寓管理系统 - 房屋修缮添加</title>
	<link rel="stylesheet" href="../../css/main.css">
	<link rel="stylesheet" href="../../lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>房屋修缮</h3>
	<form action="#" method="post">
	<table class="form-table">
		<tr>
				<td class="label">房屋信息</td>
				<td class="detail">
					<a href="houseDetail.do?hid=${repair.rMessage}">房屋信息</a>
				</td>
			</tr>
			<tr>
				<td class="label">负责人</td>
				<td colspan="3" class="detail">
					<a href="logisticaDetail.do?laid=${repair.rPrincipal}">负责人</a>
				</td>
			</tr>
			<tr>
				<td class="label">修缮说明</td>
				<td colspan="3" class="detail">
					${repair.rExplain }
				</td>
			</tr>
			<tr>
				<td class="label">修缮时间</td>
				<td colspan="3" class="detail">
					${repair.rTime }
				</td>
			</tr>
			<tr>
				<td class="label">修缮结果</td>
				<td colspan="3" class="detail">
					${repair.rResult }
				</td>
			</tr>
			<tr>
				<td class="label">备注说明</td>
				<td colspan="3" class="detail">
					${repair.rRemark }
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