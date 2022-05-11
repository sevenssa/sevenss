	
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
    
<%@page import="java.util.List"%>

<%@page import="dao.AbDog"%>
 
<%@page import="dao.AbDog1"%>

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
	rel="stylesheet" type="text/css"></head>
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
							href="../menber.html"> <span data-feather="users"></span>
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
			<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
				<div
					class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<h1 class="h2">棄養管理</h1>
					<div class="btn-toolbar mb-2 mb-md-0">
						<div class="btn-group me-2">
							<button type="button" class="btn btn-sm btn-outline-secondary">Share</button>
							<button type="button" class="btn btn-sm btn-outline-secondary">Export</button>
						</div>
						<button type="button"
							class="btn btn-sm btn-outline-secondary dropdown-toggle">
							<span data-feather="calendar"></span> This week
						</button>
					</div>
				</div>
	<h2></h2>
		<div class="table-responsive">
			<div class="btn-group me-2">
				<a href="<%=request.getContextPath()%>/dogadd.jsp"
				class=" btn btn-sm btn-outline-secondary">新增</a> 
							 
					</div>		
<table class="table table-striped table-sm">
						<thead>
							<tr>
			 
			<td><b>編號</b></td>
			<td><b>客戶</b></td>
			<td><b>電話</b></td>
			<td><b>電郵</b></td>
			<td><b>寵物名</b></td>
			<td><b>所在地</b></td>
			<td><b>型態</b></td>
			<td><b>年紀</b></td>	
			<td><b>操作</b></td>	
			
		</tr>
		
		<%
		List<AbDog>  list =AbDog1.getAll();
		if(list==null || list.size()<1){
			out.print("沒有 資料!");		
			
		}
		else{
			for(AbDog abdog :list){
		
					%>

				<tr>	 			
						<td><%=abdog.getAbid() %></td>
						<td><%=abdog.getAbname() %></td>
						<td><%=abdog.getAbphone() %></td>
						<td><%=abdog.getAbemail()%></td>
						<td><%=abdog.getAbdogname() %></td>
						<td><%=abdog.getAbaddress() %></td>
						<td><%=abdog.getAbtype() %></td>
						<td><%=abdog.getAbage()%></td>
						<td><%=abdog.getAbdate()%></td>
										 
						  <td> 
                                <form action="main" method="get" onsubmit="return check(this);">
                                <input type="hidden" name="op" value="update">
                                <input type="hidden" name="id" value="<%=abdog.getAbid()%>">
                                 姓名<input type="text" name="abname" size="3">
                                 電話<input type="text" name="abphone"size="3">
                                 電郵<input type="text" name="abemail"size="3">
                                 寵物名<input type="text" name="abdogname" size="3">
                                 住址<input type="text" name="abaddress"size="3">
                                 型態<input type="text" name="abtype"size="3">
                                 年紀<input type="text" name="abage"size="3">
                                 日期<input type="text" name="abdate"size="3">
                                 
                                 
                                 <input type="submit" value="修改">  
                               	                               
                              </form>  
						     <a href="main?op=del&id=<%=abdog.getAbid()%> ">删除</a>
				 			</td>		 
						
					</tr>

					<%
				}
		}
		%>
	</table>
	



<script type="text/javascript">
    function check(form){
        with(form){
             
            if(abname.value == ""){
                alert("name");
                return false;
            }
            
            if(abphone.value == ""){
    			alert("電話欄位不能為空值");
    			return false;
    	
    		}
    			if(abemail.value == ""){
    				alert==("信箱不能為空值");
    				return false;
    			
    		}
    			if(abdogname.value == ""){
    				alert("狗名子欄位不可空");
    				return false;
    			
    		}
    			if(abaddress.value == ""){
    				alert("所在地欄位不可空");
    				return false;
    			
    		}	if(abtype.value == ""){
    				alert("種類欄位不可空");
    				return false;
    		
    	}		if(abage.value == ""){
    				alert("年紀欄位不可空");
    				return false;

    }
    			if(abdate.value == ""){
    				alert("日期欄位不可空");
    				return false;

    }
            
            
            
            
            
            
             
        }
    }
</script>

	<br>
<center>

<form   action="dogadd.jsp"  >
 <input type="submit" name="" value="添加数据" >
 <a href="Animallist.jsp">到認養主畫面</a>
</form></center>
	<script
		src="https://cdn.jsdelivr.net/npm/feather-icons@4.28.0/dist/feather.min.js"
		integrity="sha384-uO3SXW5IuS1ZpFPKugNNWqTZRRglnUJK6UAZ/gxOX80nxEkN9NcGZTftn6RzhGWE"
		crossorigin="anonymous"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/chart.js@2.9.4/dist/Chart.min.js"
		integrity="sha384-zNy6FEbO50N+Cg5wap8IKA4M/ZnLJgzc6w2NqACZaK0u0FXfOWRRJOnQtpZun8ha"
		crossorigin="anonymous"></script>
	<script type="text/javascript" language="javascript"
		src="<%=request.getContextPath()%>/js/animal.js"></script>
		

	
</body>
</html>

