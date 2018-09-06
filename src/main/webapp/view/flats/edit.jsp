<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>XX系统 - 房屋信息更新</title>
	<link rel="stylesheet" href="../../css/main.css">
	<link rel="stylesheet" href="../lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>房屋信息</h3>
	<form action="houseUpdate.do" method="post" enctype="multipart/form-data">
	<table class="form-table">
		<tr>
			<td>地区</td>
			<td colspan="3" class="control">
				<input type="hidden" name="hId" value="${house.hId }">
				<input type="text" name="hArea" placeholder="填写地区" value="${house.hArea}">
			</td>
		</tr>
		<tr>
			<td>小区名字</td>
			<td colspan="3" class="control">
				<input type="text" name="hEstate" placeholder="小区名字" value="${house.hEstate}">
			</td>
		</tr>
		<tr>
			<td>单元号</td>
			<td colspan="3" class="control">
				<input type="text" name="hUnIntegerNumber" placeholder="单元号" value="${house.hUnIntegerNumber}">
			</td>
		</tr>
		<tr>
			<td>楼层</td>
			<td colspan="3" class="control">
				<input type="text" name="hFloor" placeholder="楼层" value="${house.hFloor}">
			</td>
		</tr>
		<tr>
			<td>房间号</td>
			<td colspan="3" class="control">
				<input type="text" name="hRoomno" placeholder="房间号" value="${house.hRoomno}">
			</td>
		</tr>
		<tr>
			<td>面积（平米）</td>
			<td colspan="3" class="control">
				<input type="text" name="hAcreage" placeholder="面积" value="${house.hAcreage}">
			</td>
		</tr>
		<tr>
			<td>朝向</td>
			<td colspan="3" class="control">
				<input type="text" name="hDirection" placeholder="朝向" value="${house.hDirection}">
			</td>
		</tr>
		<tr>
			<td>装修</td>
			<td colspan="3" class="control">
				<input type="text" name="hFitment" placeholder="装修" value="${house.hFitment}">
			</td>
		</tr>
		<tr>
			<td>是否双气</td>
			<td colspan="3" class="control">
				<select name="hIsdoubleair" value="${house.ishIsdoubleair()}">
					<option value="1">有双气</option>
					<option value="0">无双气</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>限住人数</td>
			<td colspan="3" class="control">
				<input type="text" name="hLimit" placeholder="限住人数" value="${house.hLimit}">
			</td>
		</tr>
		<tr>
			<td>配套设施</td>
			<td colspan="3" class="control">
				<input type="text" name="hFacility" placeholder="配套设施" value="${house.hFacility}">
			</td>
		</tr>
		<tr>
			<td>出租价格（元/月）</td>
			<td colspan="3" class="control">
				<input type="text" name="hPrice" placeholder="出租价格" value="${house.hPrice}">
			</td>
		</tr>
		<tr>
			<td>出租状态</td>
			<td colspan="3" class="control" >
				<select name="hStatus" value="${house.hStatus}">
					<option value="1">已出租</option>
					<option value="0">未出租</option>
				</select>
			</td>
		</tr>
		<tr>
			<td>房屋图片</td>
			<td colspan="3" class="control">
				<input type="file" name="hImg" value="${house.hImg}">
			</td>
		</tr>
		<tr>
			<td>完整地址信息</td>
			<td colspan="3" class="control">
				<input type="text" name="hAddress" placeholder="完整地址信息" value="${house.hAddress}">
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