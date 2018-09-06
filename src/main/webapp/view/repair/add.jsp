<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
	<h3>添加房屋修缮</h3>
	<form action="repairAdd.do" method="post">
	<table class="form-table">
		<tr>
			<td>房屋信息</td>
			<td colspan="3" class="control">
				<select name="rMessage">
				<c:forEach var="h" items="${houses }">
					<option value="${h.hId }">${h.hEstate }</option>
				</c:forEach>
			</select>
			</td>
		</tr>
		<tr>
			<td>负责人</td>
			<td colspan="3" class="control">
			<select name="rPrincipal">
				<c:forEach var="l" items="${logs }">
					<option value="${l.laId }">${l.laName }</option>
				</c:forEach>
			</select>
			</td>
		</tr>
		<tr>
			<td>修缮说明</td>
			<td colspan="3" class="control">
				<input type="text" name="rExplain" placeholder="修缮说明">
			</td>
		</tr>
		<tr>
			<td>修缮时间</td>
			<td colspan="3" class="control">
				<input type="date" name="rTime" placeholder="修缮时间">
			</td>
		</tr>
		<tr>
			<td>修缮结果</td>
			<td colspan="3" class="control">
				<input type="text" name="rResult" placeholder="修缮结果">
			</td>
		</tr>
		<tr>
			<td>备注说明</td>
			<td colspan="3" class="control">
				<input type="text" name="rRemark" placeholder="备注说明">
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