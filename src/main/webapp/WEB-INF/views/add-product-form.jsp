<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>
<div class="container mt-3">
	<div class="row">
		<div class="col-md-6 offset-md-3">
		<h1 class="text-center mb-3"> Add form details</h1>
		
			<form action="handle-product" method="post">
			  <div class="form-group">
			    <label for="name">Product Name</label>
			    <input type="text" class="form-control" id="name" name="name" aria-describedby="emailHelp" placeholder="Enter product">
			  </div>
			  <div class="form-group">
			    <label for="description">Description</label>
			    <textarea class="form-control" id="description" name="description" rows="5" placeholder="Add description about it."></textarea>
			  </div>
			  <div class="form-group">
			    <label for="price">Product Price</label>
			    <input type="text" class="form-control" id="price" name="price"  placeholder="Enter product price">
			  </div>
			  
			  <div class="container text-center">
			  	<a href="${pageContext.request.contextPath }/" class="btn btn-outline-danger">Back</a>
			  	<button type="submit" class="btn btn-primary">ADD</button></div>
			 
			</form>
		
		</div>
	</div>
</div>

</body>
</html>