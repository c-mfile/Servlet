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
	<form action="contractAdd.do" method="post">
	<table class="form-table">
		<tr>
			<tr>
			<td>房屋信息</td>
			<td colspan="3" class="control">
			<select name="hId">
				<c:forEach var="h" items="${hs }">
					<option value="${h.hId }">${h.hEstate }</option>
				</c:forEach>
			</select>
			</td>
			</tr>
			<tr>
			<td>租户信息</td>
			<td colspan="3" class="control">
				<select name="lId">
				<c:forEach var="l" items="${ls }">
					<option value="${l.lId }">${l.lName }</option>
				</c:forEach>
				</select>
			</td>
			</tr>
			<tr>
			<td>开始日期</td>
			<td colspan="3" class="control">
			<input type="date" name="cStartTime" placeholder="合同日期"></td>
			</tr>
			<tr>
			<td>结束日期</td>
			<td colspan="3" class="control">
			<input type="date" name="cEndTime" placeholder="合同日期"></td>
			</tr>
			<tr>
			<td>房租总额</td>
			<td colspan="3" class="control">
			<input type="text" name="cAliquilter" placeholder="房租总额"></td>
			</tr>
			<tr>
			<td>付款方式</td>
			<td colspan="3" class="control">
			<input type="text" name="cPay" placeholder="付款方式"></td>
			</tr>
			<tr>
			<td>押金</td>
			<td colspan="3" class="control">
			<input type="text" name="cDeptsito" placeholder="押金"></td>
			</tr>
			<tr>
			<td >付款期数</td>
			<td colspan="3" class="control">
			<input type="text" name="cPaynum" placeholder="付款期数"></td>
			</tr>
			<tr>
			<td>合同签署人</td>
			<td colspan="3" class="control">
			<input type="text" name="cName" placeholder="合同签署人"></td>
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