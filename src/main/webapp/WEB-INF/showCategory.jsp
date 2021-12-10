<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>${cat.name}</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="container-sm">
		<nav class="navbar">
			<a href="/categories">Category Catalog</a>
		</nav>
		<h1>${cat.name}</h1>
		
		
		<div class="row justify-content-center">
			<div class="col-lg-6">
				<h2>Products:</h2>
				<ul>
				<c:forEach items="${cat.product}" var="prod">
					<li>${prod.name}</li>
				</c:forEach>
				</ul>
			</div>
			<div class="col-lg-6">
				<form action="/prodToCat/${cat.id}" method="post">
					<div>
						<label for="prods" class="form-label">Add Category: </label>
						<select name="prods" class="form-select">
							<c:forEach items="${prodsLeft}" var="cat">
							<option value="${cat.id}">${cat.name}</option>
							</c:forEach>
						</select>
					</div>
					<div>
						<input type="submit" value="Add" class="btn btn-success"/>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>