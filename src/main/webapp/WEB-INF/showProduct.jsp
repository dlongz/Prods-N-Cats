<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>${prod.name}</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>	
	<div class="container-sm">
		<nav class="navbar">
			<a href="/products">Product Catalog</a>
		</nav>
		<h1>${prod.name}</h1>
		<p>${prod.description}</p>
		<p>$${prod.price}</p>
		<div class="row justify-content-center">
			<div class="col-lg-6">
				<h2>Categories:</h2>
				<ul>
				<c:forEach items="${prod.category}" var="cat">
					<li>${cat.name}</li>
				</c:forEach>
				</ul>
			</div>
			<div class="col-lg-6">
				<form action="/catToProd/${prod.id}" method="post">
					<div>
						<label for="cats" class="form-label">Add Category: </label>
						<select name="cats" class="form-select">
							<c:forEach items="${catsLeft}" var="cat">
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