    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>公寓管理系统 - 公寓活动添加</title>
	<link rel="stylesheet" href="../../css/main.css">
	<link rel="stylesheet" href="../../lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>公寓活动</h3>
	<form action="activityUpdate.do" method="post">
	<table class="form-table">
		<tr>
			<td>活动日期</td>
			<td colspan="3" class="control">
				<input type="hidden" name="aId" value="${activity.aId }">
				<input type="text" name="aDate" value="${activity.aDate }">
			</td>
		</tr>
		<tr>
			<td>活动主题</td>
			<td colspan="3" class="control">
				<input type="text" name="aTheme" value="${activity.aTheme }">
			</td>
		</tr>
		<tr>
			<td>活动内容介绍</td>
			<td colspan="3" class="control">
				<input type="text" name="aContet" value="${activity.aContet }">
			</td>
		</tr>
		<tr>
			<td>活动地点</td>
			<td colspan="3" class="control">
				<input type="text" name="aSite" value="${activity.aSite }">
			</td>
		</tr>
		<tr>
			<td>费用</td>
			<td colspan="3" class="control">
				<input type="text" name="aCost" value="${activity.aCost }">
			</td>
		</tr>
		<tr>
			<td>活动组织方</td>
			<td colspan="3" class="control">
				<input type="text" name="aOrganizer" value="${activity.aOrganizer }">
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