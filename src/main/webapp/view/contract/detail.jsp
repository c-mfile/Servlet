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
			<td>合同号</td>
			<td class="detail">
			${i.cId }
			</td>
			</tr>
			<tr>
			<td>合同签署日期</td>
			<td class="detail">
			${i.cDate}"</td>
			</tr>
			<tr>
			<td>开始日期</td>
			<td class="detail">
			${i.cStartTime}</td>
			</tr>
			<tr>
			<td>结束日期</td>
			<td class="detail">
			${i.cEndTime}</td>
			</tr>
			<tr>
			<td>房租总额</td>
			<td class="detail">
			${i.cAlquliter}</td>
			</tr>
			<tr>
			<td>付款方式</td>
			<td class="detail">
			${i.cPay}"</td>
			</tr>
			<tr>
			<td>押金</td>
			<td class="detail">
			${i.cDeptsito}</td>
			</tr>
			<tr>
			<td >付款期数</td>
			<td class="detail">
			${i.cPaynum}</td>
			</tr>
			<tr>
			<td>合同签署人</td>
			<td class="detail">
			${i.cName}</td>
			</tr>
			<tr>
			<td>合同状态</td>
			<td class="detail">
			<c:if test="${i.cStatus == 1}">已生效</c:if>
			<c:if test="${i.cStatus == 0}">未生效</c:if>
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