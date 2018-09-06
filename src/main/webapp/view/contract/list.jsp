<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>公寓管理系统 - 租赁合同管理</title>
	<link rel="stylesheet" href="../../css/main.css">
	<link rel="stylesheet" href="../../lib/font-awesome/css/font-awesome.css">
	<link rel="stylesheet" href="../../css/fenye.css">
</head>
<body>
<div class="box">
	<h3>租赁合同管理</h3>
	<div class="actions">
	<c:if test="${role.rId != 3 }">
		<div>
			<a class="btn btn-primary" href="add.do">添加租户信息</a>
		</div>
	</c:if>
	</div>

	<table class="list">
		<tr>
			<th>合同号</th>
			<th>房屋信息</th>
			<th>租户信息</th>
			<th>合同日期</th>
			<th>租赁开始时间</th>
			<th>租赁结束时间</th>
			<th>房租总额</th>
			<th>付款方式</th>
			<th>押金</th>
			<th>付款期数</th>
			<th>合同签署人</th>
			<th>合同状态</th>
			<th>操作</th>
		</tr>
		<tbody id="tbody">
		<c:forEach var="i" items="${cs }">
		<tr>
			<td>${i.cId }</td>
			<td><a href="houseDetail.do?hid=${i.hId }">房屋信息</a></td>
			<td><a href="lesseeDetail.do?lid=${i.lId }">租户信息</a></td>
			<td>${i.cDate}</td>
			<td>${i.cStartTime}</td>
			<td>${i.cEndTime}</td>
			<td>${i.cAlquliter}</td>
			<td>${i.cPay}</td>
			<td>${i.cDeptsito}</td>
			<td>${i.cPaynum}</td>
			<td>${i.cName}</td>
			<td>
			<c:if test="${i.cStatus == 1}">已生效</c:if>
			<c:if test="${i.cStatus == 0}">未生效</c:if>
			</td>
			<td>
				<a class="fa fa-info" title="详情" href="contractDetail.do?cid=${i.cId }"></a>
				&nbsp;&nbsp;
				<c:if test="${role.rId != 3 }">
				<a class="fa fa-pencil" title="编辑" href="contractEdit.do?cid=${i.cId }"></a>
				&nbsp;&nbsp;
				<a class="fa fa-remove" title="删除" onclick="confirmDelete(${i.cId })" id="a${i.cId}"></a>
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
			url:"contractDelete.do",
			data:"cid="+id,
			success:function(){
				$("#a"+id).parent().parent().remove();
				
			}
		});
    }
}
</script>
</body>
</html>