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
	<form action="repairUpdate.do" method="post">
	<table class="form-table">
		<tr>
			<td>房屋信息</td>
			<td colspan="3" class="control">
				<input type="hidden" name="reId" value="${repair.reId }">
				<select name="rMessage" >
				<c:forEach var="h" items="${houses }">
					<c:choose>
					<c:when test="${h.hId == repair.rMessage }" >
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
			<td>负责人</td>
			<td colspan="3" class="control">
			<select name="rPrincipal" >
				<c:forEach var="l" items="${logs }">
					<c:choose>
					<c:when test="${l.laId == repair.rPrincipal }" >
					<option value="${l.laId }" selected="selected">${l.laName }</option>
					</c:when>
					<c:otherwise>
					<option value="${l.laId }">${l.laName }</option>
					</c:otherwise>
					</c:choose>
					
				</c:forEach>
			</select>
			</td>
		</tr>
		<tr>
			<td>修缮说明</td>
			<td colspan="3" class="control">
				<input type="text" name="rExplain" value="${repair.rExplain }">
			</td>
		</tr>
		<tr>
			<td>修缮时间</td>
			<td colspan="3" class="control">
				<input type="date" name="rTime" value="${repair.rTime }">
			</td>
		</tr>
		<tr>
			<td>修缮结果</td>
			<td colspan="3" class="control">
				<input type="text" name="rResult" value="${repair.rResult }">
			</td>
		</tr>
		<tr>
			<td>备注说明</td>
			<td colspan="3" class="control">
				<input type="text" name="rRemark" value="${repair.rRemark }">
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