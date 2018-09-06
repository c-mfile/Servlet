<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>公寓管理系统 - 添加租赁合同信息</title>
	<link rel="stylesheet" href="../../css/main.css">
	<link rel="stylesheet" href="../../lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>添加租赁合同信息</h3>
	<form action="contractUpdate.do" method="post">
	<table class="form-table">
			<tr>
			<td>房屋信息</td>
			<td colspan="3" class="control">
				<select name="hId">
				<c:forEach var="h" items="${hs }">
					<c:choose>
					<c:when test="${h.hId == i.hId }" >
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
			<td>租户信息</td>
			<td colspan="3" class="control">
				<select name="lId">
				<c:forEach var="l" items="${ls }">
					<c:choose>
					<c:when test="${l.lId == i.lId }" >
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
			<td>合同签署日期</td>
			<td colspan="3" class="control">
			<input type="date" name="cStartTime" value="${i.cDate}"></td>
			</tr>
			<tr>
			<td>开始日期</td>
			<td colspan="3" class="control">
			<input type="date" name="cStartTime" value="${i.cStartTime}"></td>
			</tr>
			<tr>
			<td>结束日期</td>
			<td colspan="3" class="control">
			<input type="date" name="cEndTime" value="${i.cEndTime}"></td>
			</tr>
			<tr>
			<td>房租总额</td>
			<td colspan="3" class="control">
			<input type="text" name="cAliquilter" value="${i.cAlquliter}"></td>
			</tr>
			<tr>
			<td>付款方式</td>
			<td colspan="3" class="control">
			<input type="text" name="cPay" value="${i.cPay}"></td>
			</tr>
			<tr>
			<td>押金</td>
			<td colspan="3" class="control">
			<input type="text" name="cDeptsito" value="${i.cDeptsito}"></td>
			</tr>
			<tr>
			<td >付款期数</td>
			<td colspan="3" class="control">
			<input type="text" name="cPaynum" value="${i.cPaynum}"></td>
			</tr>
			<tr>
			<td>合同签署人</td>
			<td colspan="3" class="control">
			<input type="text" name="cName" value="${i.cName}"></td>
			</tr>
			<tr>
			<td>合同状态</td>
			<td colspan="3" class="control">
			<select name="cStatus">
				<option value="1">已生效</option>
				<option value="0">未生效</option>
			</select>
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