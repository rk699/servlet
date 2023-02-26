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
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${merchantuser != null}">
					<form action="merchant/update" method="post">
				</c:if>
				<c:if test="${merchantuser == null}">
					<form action="merchant/insert" method="post">
				</c:if>

				<caption>
					<h2>
						<c:if test="${merchantuser != null}">
            			Edit User
            		</c:if>
						<c:if test="${merchantuser == null}">
            			Add New User
            		</c:if>
					</h2>
				</caption>

				<c:if test="${merchantuser != null}">
					<input type="hidden" name=m_id value="<c:out value='${merchantuser.id}' />" />
				</c:if>

				<fieldset class="form-group">
					<label>Merchant Name</label> <input type="text"
						value="<c:out value='${merchantuser.m_name}' />" class="form-control"
						name="m_name" required="required">
				</fieldset>

				<fieldset class="form-group">
					<label>Merchant Email</label> <input type="text"
						value="<c:out value='${merchantuser.m_mail}' />" class="form-control"
						name="m_mail">
				</fieldset>

				<fieldset class="form-group">
					<label>Merchant Address</label> <input type="text"
						value="<c:out value='${merchantuser.m_address}' />" class="form-control"
						name="m_address">
				</fieldset>
				<fieldset class="form-group">
					<label>Merchant Phone</label> <input type="text"
						value="<c:out value='${merchantuser.m_phone}' />" class="form-control"
						name="m_phone">
				</fieldset>
				<fieldset class="form-group">
					<label>Merchant Pincode</label> <input type="text"
						value="<c:out value='${merchantuser.m_pincode}' />" class="form-control"
						name="m_pincode">
				</fieldset>
				<fieldset class="form-group">
					<label>Merchant Receipe style</label> <input type="text"
						value="<c:out value='${merchantuser.receipe_style}' />" class="form-control"
						name="receipe_style">
				</fieldset>
				<fieldset class="form-group">
					<label>Merchant Receipe Price</label> <input type="text"
						value="<c:out value='${merchantuser.receipe_price}' />" class="form-control"
						name="receipe_price">
				</fieldset>

				<button type="submit" class="btn btn-success">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
