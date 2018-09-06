<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
	<meta charset="UTF-8">
	<title>公寓管理系统 - 后台管理</title>
	<link rel="stylesheet" href="css/admin.css">
	<link rel="stylesheet" href="lib/font-awesome/css/font-awesome.css">
</head>
<body>
<div class="header">
	<h1><a href="#">公寓管理系统</a></h1>
	<!--<div class="nav">
		<a target="right" href="#">工作台</a>
		<a target="right" href="#">报表</a>
		<a target="right" href="#">客户信息</a>
		<a target="right" href="#">员工信息</a>
		<a target="right" href="#">公告信息</a>
		<a target="right" href="#">发件箱</a>
	</div>-->
	<div class="user">
		<a href="#">${username}</a>
		<a href="exit.do">退出</a>
	</div>
</div>
<div class="main">
	<ul class="left-side">
		<li class="menu-title active">
			<a href="#">
				<i class=" fa fa-users"></i>&nbsp;&nbsp;公寓管理
			</a>
		</li>
		<li class="sub-menu">
			<ul>
				<c:forEach items="${privileges }" var="p" begin="0" end="3">
				<li class="active">
					<a href="${p.pSourceUrl }"  target="pageBox">
						<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;${p.pSourceName }
					</a>
				</li>
				</c:forEach>
				<!-- <li class="active">
					<a href="view/flats/houseList.do"  target="pageBox">
						<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;房屋信息
					</a>
				</li>
				<li>
					<a target="pageBox" href="view/contract/contractList.do">
						<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;租赁合同
					</a>
				</li>
				<li>
					<a target="pageBox" href="view/lessee/lesseeList.do">
						<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;租户信息
					</a>
				</li>
				<li>
					<a target="pageBox" href="view/rect/rectList.do">
					<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;房租信息
					</a>
				</li> -->

			</ul>
		</li>
		<li class="menu-title">
			<a href="#">
				<i class=" fa fa-file-text"></i>&nbsp;&nbsp;服务管理
			</a>
		</li>
		<li class="sub-menu">
			<ul>
				<c:forEach items="${privileges }" var="p" begin="4" end="6">
				<li class="active">
					<a href="${p.pSourceUrl }"  target="pageBox">
						<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;${p.pSourceName }
					</a>
				</li>
				</c:forEach>
				<!-- <li>
					<a target="pageBox" href="view/logistica/logisticaList.do">
						<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;后勤人员
					</a>
				</li>
				<li>
					<a target="pageBox" href="view/repair/repairList.do">
					<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;修缮记录
					</a>
				</li>
				<li>
					<a target="pageBox" href="view/activity/activityList.do">
					<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;公寓活动
					</a>
				</li>
 -->
			</ul>
		</li>
		<c:forEach items="${privileges }" var="p" begin="7" end="7">
		<c:if test="${!empty p }">
		<li class="menu-title">
			<a href="#" >
				<i class=" fa fa-sitemap"></i>&nbsp;&nbsp;管理员
			</a>
		</li>
		<li class="sub-menu">
			<ul class="menu">
				<c:forEach items="${privileges }" var="p" begin="7" end="8">
				<li class="active">
					<a href="${p.pSourceUrl }"  target="pageBox">
						<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;${p.pSourceName }
					</a>
				</li>
				</c:forEach>
				<!-- <li>
					<a target="pageBox" href="view/role/roleList.do">
					<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;角色管理
					</a>
				</li>
				<li>
					<a target="pageBox" href="view/user/userList.do">
					<i class=" fa fa-circle-thin"></i>&nbsp;&nbsp;用户管理
					</a>
				</li> -->
			</ul>
		</li>
		</c:if>
		</c:forEach>
	</ul>
	<div class="right-side">
		<iframe name="pageBox" src="view/flats/list.jsp"></iframe>
		<div class="footer">
			智游教育 ©2018 河南智游臻龙教育科技有限公司
		</div>
	</div>
</div>
<script src="lib/jquery/jquery.js"></script>
<script src="js/admin.js"></script>
</body>
</html>