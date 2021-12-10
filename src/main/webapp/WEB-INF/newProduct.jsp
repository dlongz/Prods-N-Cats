<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>New Product</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	
</head>
<body>
	<div class="container-sm">
		<nav class="navbar">
			<a href="/">Home</a>
		</nav>
		<h1>New Product</h1>
		<div class="row justify-contenet-center">
			<form:form actions="/products/new" method="post" modelAttribute="productForm">
				<div class="col-lg-3">
					<form:label path="name" class="form-label">Name:</form:label>
					<form:input path="name" class="form-control"/>
				</div>
				<div class="col-lg-6">
					<form:label path="description"  class="form-label">Description:</form:label>
					<form:textarea path="description" class="form-control"/>
				</div>
				<div class="col-lg-1">
					<form:label path="price" class="form-label">Price:</form:label>
					<form:input path="price" class="form-control"/>
				</div>
				<input type="submit" value="Create" class="btn btn-success"/>
			</form:form>
		</div>
		
	</div>
</body>
</html>