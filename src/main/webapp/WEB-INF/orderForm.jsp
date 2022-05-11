<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author"
	content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
<meta name="generator" content="Hugo 0.88.1">
<title>訂單管理</title>
<!-- Bootstrap core CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">

<style>
.bd-placeholder-img {
	font-size: 1.125rem;
	text-anchor: middle;
	-webkit-user-select: none;
	-moz-user-select: none;
	user-select: none;
}

@media ( min-width : 768px) {
	.bd-placeholder-img-lg {
		font-size: 3.5rem;
	}
}

</style>


<!-- Custom styles for this template -->
<link href="<%=request.getContextPath()%>/css/order.css"
	rel="stylesheet" type="text/css">
<link href="<%=request.getContextPath()%>/css/orderform.css"
	rel="stylesheet" type="text/css">

</head>
<body>
	<header
		class="navbar navbar-dark sticky-top bg-dark flex-md-nowrap p-0 shadow">
		<a class="navbar-brand col-md-3 col-lg-2 me-0 px-3"
			href="../index.html">浪孩和平</a>
		<button class="navbar-toggler position-absolute d-md-none collapsed"
			type="button" data-bs-toggle="collapse" data-bs-target="#sidebarMenu"
			aria-controls="sidebarMenu" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<input class="form-control form-control-dark w-100" type="text"
			placeholder="Search" aria-label="Search">
		<div class="navbar-nav">
			<div class="nav-item text-nowrap">
				<a class="nav-link px-3" href="#">Sign out</a>
			</div>
		</div>
	</header>

	<div class="container-fluid">
		<div class="row">
			<nav id="sidebarMenu"
				class="col-md-2 col-lg-2 d-md-block bg-light sidebar collapse">
				<div class="position-sticky pt-3">
					<ul class="nav flex-column ">
						<li class="nav-item m-2"><a class="nav-link"
							href="../member/member.html"> <span data-feather="users"></span>
								會員管理
						</a></li>
						<li class="nav-item m-2"><a class="nav-link"
							href="../product.html"> <span data-feather="file"></span>
								商品管理
						</a></li>
						<li class="nav-item m-2"><a class="nav-link active"
							href="../order.html"> <span data-feather="shopping-cart"></span>
								訂單管理
						</a></li>
						<li class="nav-item m-2"><a class="nav-link"
							href="../announcement.html"> <span data-feather="users"></span>
								公告管理
						</a></li>
						<li class="nav-item m-2"><a class="nav-link"
							href="../volun.html"> <span data-feather="bar-chart-2"></span>
								志工管理
						</a></li>
						<li class="nav-item m-2"><a class="nav-link"
							href="../adoption.html"> <span data-feather="layers"></span>
								領養管理
						</a></li>
					</ul>

					<h6
						class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
						<span>Saved reports</span> <a class="link-secondary" href="#"
							aria-label="Add a new report"> <span
							data-feather="plus-circle"></span>
						</a>
					</h6>
					<ul class="nav flex-column mb-2">
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="file-text"></span> ""
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="file-text"></span> ""
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="file-text"></span> ""
						</a></li>
						<li class="nav-item"><a class="nav-link" href="#"> <span
								data-feather="file-text"></span> ""
						</a></li>
					</ul>
				</div>
			</nav>
			<!-- 這裡寫內容 -->

			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">訂單管理</h1>
				</div>


				<!-- <canvas class="my-4 w-100" id="myChart" width="900" height="380"></canvas> -->

				<h2></h2>
				<div class="container">
					<div class="title">
						<c:if test="${order != null}">
							<h2>修改訂單</h2>
						</c:if>
						<c:if test="${order == null}">
							<h2>新增訂單</h2>
						</c:if>
					</div>
					<div class="d-flex">
						<c:if test="${order != null}">
							<form action="update" method="post">
						</c:if>
						<c:if test="${order == null}">
							<form action="insert" method="post">
						</c:if>
						<c:if test="${order != null}">
							<input type="hidden" name="od_id"
								value="<c:out value='${order.od_id}' />" />
						</c:if>
						<label> <span>商品名稱</span> <input type="text"
							value="<c:out value='${order.od_name}'/>" name="od_name"
							class="form-control">
						</label> <label> <span>商品目錄</span> <input type="text"
							value="<c:out value='${order.od_catalogue}'/>"
							name="od_catalogue" class="form-control">
						</label> <label> <span>訂單內容</span> <input type="text"
							value="<c:out value='${order.od_content}' />" name="od_content"
							class="form-control">
						</label> <label> <span>訂單規格</span> <input type="text"
							value="<c:out value='${order.od_amount}' />" name="od_amount"
							class="form-control">
						</label> <label> <span>訂單數量</span> <input type="text"
							value="<c:out value='${order.od_number}' />" name="od_number"
							class="form-control">
						</label> <label> <span>訂單金額</span> <input type="text"
							value="<c:out value='${order.od_money}' />" name="od_money"
							class="form-control">
						</label>
						<div class="d-grid gap-2 d-md-flex justify-content-md-end">
							<button type="submit" class="btn btn-sm btn-secondary">送出</button>
						</div>
						</form>
					</div>
				</div>
			</main>
		</div>
	</div>





	<script
		src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js"
		integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"
		integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha"
		crossorigin="anonymous"></script>
	<script type="text/javascript" language="javascript"
		src="<%=request.getContextPath()%>/js/order.js"></script>
</body>
</html>