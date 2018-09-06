<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>公寓管理系统 - 公寓活动管理</title>
	<link rel="stylesheet" href="../../css/main.css">
	<link rel="stylesheet" href="../../lib/font-awesome/css/font-awesome.css">
	<link rel="stylesheet" href="../../css/fenye.css">
</head>
<body>
<div class="box">
	<h3>公寓活动管理</h3>
	<div class="actions">
	<c:if test="${role.rId != 3 }">
		<div>
			<a class="btn btn-primary" href="add.jsp">添加公寓活动</a>
		</div>
	</c:if>
	</div>

	<table class="list">
		<tr>
			<th>序号</th>
			<th>活动日期</th>
			<th>活动主题</th>
			<th>活动内容介绍</th>
			<th>活动地点</th>
			<th>费用</th>
			<th>活动组织方</th>
			<th>操作</th>
		</tr>
		<tbody id="tbody">
		<c:forEach var="i" items="${as }">
		<tr>
			<td>${i.aId }</td>
			<td>${i.aDate}</td>
			<td>${i.aTheme}</td>
			<td>${i.aContet}</td>
			<td>${i.aSite}</td>
			<td>${i.aCost}</td>
			<td>${i.aOrganizer}</td>
			<td>
				<a class="fa fa-info" title="详情" href="activityDetail.do?aid=${i.aId }"></a>
				&nbsp;&nbsp;
				<c:if test="${role.rId != 3 }">
				<a class="fa fa-pencil" title="编辑" href="activityEdit.do?aid=${i.aId }"></a>
				&nbsp;&nbsp;
				<a class="fa fa-remove" title="删除" onclick="confirmDelete(${i.aId })" id="a${i.aId}"></a>
				</c:if>
			</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>

</div>
<script src="../../lib/jquery/jquery.js">
</script>
<script src="../../js/fenye.js"></script>
<script src="../../js/jquery-1.11.1.js"></script>
<script>
function confirmDelete(id){
    var statu = confirm("确认删除选中项吗！");//在js里面写confirm，在页面中弹出提示信息。
    if(!statu)//如果点击的是取消
    {
        return false;//返回页面
    }
    else{//如果点击确定，就继续执行下面的操作
    	$.ajax({
			url:"activityDelete.do",
			data:"aid="+id,
			success:function(){
				$("#a"+id).parent().parent().remove();
				
			}
		});
    }
}
</script>
</body>
</html>