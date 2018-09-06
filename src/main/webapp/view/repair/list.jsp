<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>公寓管理系统 - 房屋修缮管理</title>
	<link rel="stylesheet" href="../../css/main.css">
	<link rel="stylesheet" href="../../lib/font-awesome/css/font-awesome.css">
	<link rel="stylesheet" href="../../css/fenye.css">
</head>
<body>
<div class="box">
	<h3>房屋修缮管理</h3>
	<div class="actions">
	<c:if test="${role.rId != 3 }">
		<div>
			<a class="btn btn-primary" href="add.do">添加房屋修缮</a>
		</div>
		</c:if>
	</div>

	<table class="list">
		<tr>
			<th>序号</th>
			<th>房屋信息</th>
			<th>负责人</th>
			<th>修缮说明</th>
			<th>修缮时间</th>
			<th>修缮结果</th>
			<th>备注说明</th>
			<th>操作</th>
		</tr>
		<tbody id="tbody">
		<c:forEach var="i" items="${rs }">
		<tr>
			<td>${i.reId }</td>
			<td><a href="houseDetail.do?hid=${i.rMessage}">房屋信息</a></td>
			<td><a href="logisticaDetail.do?laid=${i.rPrincipal}">负责人</a></td>
			<td>${i.rExplain}</td>
			<td>${i.rTime}</td>
			<td>${i.rResult}</td>
			<td>${i.rRemark}</td>
			<td>
				<a class="fa fa-info" title="详情" href="repairDetail.do?rid=${i.reId }"></a>
				&nbsp;&nbsp;
				<c:if test="${role.rId != 3 }">
				<a class="fa fa-pencil" title="编辑" href="repairEdit.do?rid=${i.reId }"></a>
				&nbsp;&nbsp;
				<a class="fa fa-remove" title="删除" onclick="confirmDelete(${i.reId })" id="a${i.reId}"></a>
				</c:if>
			</td>
		</tr>
		</c:forEach>
		<tbody id="tbody">
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
			url:"repairDelete.do",
			data:"rid="+id,
			success:function(){
				$("#a"+id).parent().parent().remove();
				
			}
		});
    }
}
</script>
</body>
</html>