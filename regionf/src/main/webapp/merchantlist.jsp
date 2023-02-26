<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>User Management Application</title>

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-md navbar-dark bg-dark text-white">
			<div>
				<a href="<%=request.getContextPath()%>/" class="navbar-brand"> RegionalFood </a>
			</div>

			<ul class="navbar-nav  text-white">
			<div class="d-flex ">
				<li><a href="<%=request.getContextPath()%>"
					class="nav-link px-3 mx-3">Customer</a></li>
				<li><a href="<%=request.getContextPath()%>/merchant"
					class="nav-link px-3 mx-3">Merchant</a></li>
			</div>
			</ul>
		</nav>
	</header>
	<br>

	<div class="row">
		<!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

		<div class="container">
			<h3 class="text-center">List of Merchants</h3>
			<hr>
			<div class="container text-left">

				<a href="<%=request.getContextPath()%>/merchant/news" class="btn btn-success">Add
					New Merchant</a>
			</div>
			<br>
			<table class="table table-bordered">
				<thead>
					<tr>
						<th>ID</th>
						<th>Name</th>
						<th>Email</th>
						<th>Address</th>
						<th>Phone</th>
						<th>Pincode</th>
						<th>Receipe Style</th>
						<th>Price</th>
						<th>Actions</th>
					</tr>
				</thead>
				<tbody>
					<!--   for (Todo todo: todos) {  -->
					<c:forEach var="merchant" items="${listMerchant}">

						<tr>
							<td><c:out value="${merchant.m_id}" /></td>
							<td><c:out value="${merchant.m_name}" /></td>
							<td><c:out value="${merchant.m_mail}" /></td>
							<td><c:out value="${merchant.m_address}" /></td>
							<td><c:out value="${merchant.m_phone}" /></td>
							<td><c:out value="${merchant.m_pincode}" /></td>
							<td><c:out value="${merchant.receipe_style}" /></td>
							<td><c:out value="${merchant.receipe_price}" /></td>
							<td><a href="merchant/edit?id=<c:out value='${merchant.m_id}' />">Edit</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a
								href="merchant/delete?id=<c:out value='${merchant.m_id}' />">Delete</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>

			</table>
		</div>
	</div>
</body>
</html>
