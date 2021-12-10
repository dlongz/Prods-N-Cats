<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>New Category</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container-sm">
		<nav class="navbar">
			<a href="/">Home</a>
		</nav>
		<h1>New Category</h1>
		<div class="row justify-contenet-center">
			<form:form actions="/category/new" method="post" modelAttribute="categoryForm">
				<div class="col-lg-3">
					<form:label path="name" class="form-label">Name:</form:label>
					<form:input path="name" class="form-control"/>
				</div>
				<input type="submit" value="Create" class="btn btn-success"/>
			</form:form>
		</div>
	</div>
</body>
</html>