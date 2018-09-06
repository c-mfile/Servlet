<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
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
	<h3>添加房租信息</h3>
	<form action="rectAdd.do" method="post">
	<table class="form-table">
		<tr>
			<td>房屋</td>
			<td colspan="3" class="control">
				<select name="hId">
				<c:forEach var="h" items="${hs }">
					<option value="${h.hId }">${h.hEstate }</option>
				</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>租户</td>
			<td colspan="3" class="control">
				<select name="lId">
				<c:forEach var="l" items="${ls }">
					<option value="${l.lId }">${l.lName }</option>
				</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>租金</td>
			<td colspan="3" class="control">
				<input type="text" name="rMoney" placeholder="租金">
			</td>
		</tr>
		<tr>
			<td>备注</td>
			<td colspan="3" class="control">
				<input type="text" name="rRemark" placeholder="备注">
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