<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>公寓管理系统 - 租户信息管理</title>
	<link rel="stylesheet" href="../../css/main.css">
	<link rel="stylesheet" href="../../lib/font-awesome/css/font-awesome.css">
	<link rel="stylesheet" href="../../css/fenye.css">
</head>
<body>
<div class="box">
	<h3>租户信息管理</h3>
	<div class="actions">
	<c:if test="${role.rId != 3 }">
		<div>
			<a class="btn btn-primary" href="add.jsp">添加租户信息</a>
		</div>
		</c:if>
	</div>

	<table class="list">
		<tr>
			<th>序号</th>
			<th>姓名</th>
			<th>电话</th>
			<th>性别</th>
			<th>籍贯</th>
			<th>身份证号</th>
			<th>操作</th>
		</tr>
		<tbody id="tbody">
		<c:forEach var="i" items="${ls }">
		<tr>
			<td>${i.lId }</td>
			<td>${i.lName}</td>
			<td>${i.lTel}</td>
			<td>${i.lSex}</td>
			<td>${i.lNativePlace}</td>
			<td>${i.lIdcade}</td>
			<td>
				<a class="fa fa-info" title="详情" href="lesseeDetail.do?lid=${i.lId }"></a>
				&nbsp;&nbsp;
				<c:if test="${role.rId != 3 }">
				<a class="fa fa-pencil" title="编辑" href="lesseeEdit.do?lid=${i.lId }"></a>
				&nbsp;&nbsp;
				<a class="fa fa-remove" title="删除" onclick="confirmDelete(${i.lId })" id="a${i.lId}"></a>
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
			url:"lesseeDelete.do",
			data:"lid="+id,
			success:function(){
				$("#a"+id).parent().parent().remove();
				
			}
		});
    }
}
</script>
</body>
</html>