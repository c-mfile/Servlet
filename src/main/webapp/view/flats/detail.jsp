<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>XX系统 - 房屋信息详情查看</title>
	<link rel="stylesheet" href="../../css/main.css">
	<link rel="stylesheet" href="../../lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="box">
	<h3>房屋信息详情</h3>
	<form action="#" method="post">
		<table class="form-table">
			<tr>
				<td class="label">地区</td>
				<td class="detail">
					${house.hArea}
				</td>
			</tr>
			<tr>
				<td class="label">小区</td>
				<td colspan="3" class="detail">
					${house.hEstate}
				</td>
			</tr>
			<tr>
				<td class="label">单元号</td>
				<td colspan="3" class="detail">
					${house.hUnIntegerNumber}
				</td>
			</tr>
			<tr>
				<td class="label">楼层</td>
				<td colspan="3" class="detail">
					${house.hFloor}
				</td>
			</tr>
			<tr>
				<td class="label">房间号</td>
				<td colspan="3" class="detail">
					${house.hRoomno}
				</td>
			</tr>
			<tr>
				<td class="label">面积(平米)</td>
				<td colspan="3" class="detail">
					${house.hAcreage}
				</td>
			</tr>
			<tr>
				<td class="label">朝向</td>
				<td colspan="3" class="detail">
					${house.hDirection}
				</td>
			</tr>
			<tr>
				<td class="label">装修</td>
				<td colspan="3" class="detail">
					${house.hFitment}
				</td>
			</tr>
			<tr>
				<td class="label">是否双气</td>
				<td colspan="3" class="detail">
					${house.ishIsdoubleair()}
				</td>
			</tr>
			<tr>
				<td class="label">限住人数</td>
				<td colspan="3" class="detail">
					${house.hLimit}
				</td>
			</tr>
			<tr>
				<td class="label">配套设施</td>
				<td colspan="3" class="detail">
					${house.hFacility}
				</td>
			</tr>
			<tr>
				<td class="label">出租价格(元/月)</td>
				<td colspan="3" class="detail">
					${house.hPrice}
				</td>
			</tr>
			<tr>
				<td class="label">出租状态</td>
				<td colspan="3" class="detail">
					${house.hStatus}
				</td>
			</tr>
			<tr>
				<td class="label">房屋图片</td>
				<td colspan="3" class="detail">
					<img src="${house.hImg }" width="300px" height="200px">
				</td>
			</tr>
			<tr>
				<td class="label">完整地址信息</td>
				<td colspan="3" class="detail">
					${house.hAddress}
				</td>
			</tr>
			<tr>
				<td class="label">添加时间</td>
				<td colspan="3" class="detail">
					${house.hAddtime}
				</td>
			</tr>
			<tr>
				<td class="label">更新时间</td>
				<td colspan="3" class="detail">
					${house.hUpdateTime}
				</td>
			</tr>

		</table>
		<div class="buttons">
			<a class="btn btn-default" href="javascript:history.go(-1)">返回</a>
		</div>
	</form>
</div>
</body>
</html>