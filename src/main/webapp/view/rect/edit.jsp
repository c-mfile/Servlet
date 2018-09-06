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
	<form action="rectUpdate.do" method="post">
	<input type="hidden" name="rId" value="${rect.rId }">
	<table class="form-table">
		<tr>
			<td>房屋</td>
			<td colspan="3" class="control">
				<select name="hId" >
				<c:forEach var="h" items="${hs }">
					<c:choose>
					<c:when test="${h.hId == rect.hId }" >
					<option value="${h.hId }" selected="selected">${h.hEstate }</option>
					</c:when>
					<c:otherwise>
					<option value="${h.hId }">${h.hEstate }</option>
					</c:otherwise>
					</c:choose>
					
				</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>租户</td>
			<td colspan="3" class="control">
				<select name="lId" >
				<c:forEach var="l" items="${ls }">
					<c:choose>
					<c:when test="${l.lId == rect.lId }" >
					<option value="${l.lId }" selected="selected">${l.lName }</option>
					</c:when>
					<c:otherwise>
					<option value="${l.lId }">${l.lName }</option>
					</c:otherwise>
					</c:choose>
					
				</c:forEach>
				</select>
			</td>
		</tr>
		<tr>
			<td>租金</td>
			<td colspan="3" class="control">
				<input type="text" name="rMoney" placeholder="租金" value="${rect.rMoney }">
			</td>
		</tr>
		<tr>
			<td>备注</td>
			<td colspan="3" class="control">
				<input type="text" name="rRemark" placeholder="备注" value="${rect.rRemark }">
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