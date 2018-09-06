<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>公寓管理系统 - 房屋信息管理</title>
	<link rel="stylesheet" href="../../css/main.css">
	<link rel="stylesheet" href="../../lib/font-awesome/css/font-awesome.css">
	<link rel="stylesheet" href="../../css/fenye.css">
</head>
<body>
<div class="box">
	<h3>房屋信息管理</h3>
	<div class="actions">
		<c:if test="${role.rId != 3 }">
		<div>
			<a class="btn btn-primary" href="add.jsp">添加房屋信息</a>
		</div>
		</c:if>
	</div>

	<table class="list">
		<tr>
			<th>序号</th>
			<th>所属地区</th>
			<th>所属小区</th>
			<th>单元号</th>
			<th>所属楼层</th>
			<th>房间号</th>
			<th>面积</th>
			<th>朝向</th>
			<th>限住人数</th>
			<th>出租价格(元)</th>
			<th>出租状态</th>
			<th>操作</th>
		</tr>
		<tbody id="tbody">
		<c:forEach var="i" items="${houses }">
		<tr>
			<td>${i.hId }</td>
			<td>${i.hArea}</td>
			<td>${i.hEstate}</td>
			<td>${i.hUnIntegerNumber}</td>
			<td>${i.hFloor}</td>
			<td>${i.hRoomno}</td>
			<td>${i.hAcreage}</td>
			<td>${i.hDirection}</td>
			<td>${i.hLimit}</td>
			<td>${i.hPrice}</td>
			<td>
			<c:if test="${i.hStatus == 1}">已出租</c:if>
			<c:if test="${i.hStatus == 0}">未出租</c:if>
			</td>
			<td>
				<a class="fa fa-info" title="详情" href="houseDetail.do?hid=${i.hId }"></a>
				&nbsp;&nbsp;
				<c:if test="${role.rId != 3 }">
				<a class="fa fa-pencil" title="编辑" href="houseEdit.do?hid=${i.hId }"></a>
				&nbsp;&nbsp;
				<a class="fa fa-remove" title="删除" onclick="confirmDelete(${i.hId })" id="a${i.hId}"></a>
				</c:if>
			</td>
		</tr>
		</c:forEach>
		</tbody>
	</table>
</div>
<script src="../../lib/jquery/jquery.js"></script>
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
			url:"houseDelete.do",
			data:"hid="+id,
			success:function(){
				$("#a"+id).parent().parent().remove();
				
			}
		});
    }
}
</script>
</body>
</html>