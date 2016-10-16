<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/
bootstrap.min.css">
<title>Products</title>
</head>
<body>
	<section>
	<div class="jumbotron">
		<a href="<c:url value="/j_spring_security_logout" />"
			class="btn btn-danger btn-mini pull-right">logout</a>
		<div class="container">
			<h1>Products</h1>
			<p>Add products</p>
		</div>
	</div>
	</section>
	<section class="container"> <form:form
		modelAttribute="newProduct" enctype="multipart/form-data" class="form-horizontal">
		<fieldset>
			<legend>Add new product</legend>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="productId">
					<spring:message code="newProduct.id" text="Product-Id" />
				</label>
				<div class="col-lg-10">
					<form:input id="productId" path="productId" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="productId">Product
					Name</label>
				<div class="col-lg-10">
					<form:input id="name" path="name" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="productId">UnitPrice</label>
				<div class="col-lg-10">
					<form:input id="unitPrice" path="unitPrice" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="productId">Manufacturer</label>
				<div class="col-lg-10">
					<form:input id="manufacturer" path="manufacturer" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="productId">Category</label>
				<div class="col-lg-10">
					<form:input id="category" path="category" type="text"
						class="form:input-large" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="productId">unitsInStock</label>
				<div class="col-lg-10">
					<form:input id="unitsInStock" path="unitsInStock" type="text"
						class="form:input-large" />
				</div>
			</div>
			<%-- <div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="productId">unitsInOrder</label>
				<div class="col-lg-10">
					<form:input id="unitsInOrder" path="unitsInOrder" type="text"
						class="form:input-large" />
				</div>
			</div>
			 --%>
			<div class="form-group">
				<label class="control-label col-lg-2" for="description">Description</label>
				<div class="col-lg-10">
					<form:textarea id="description" path="description" rows="2" />
				</div>
			</div>
			<%-- <div class="form-group">
				<label class="control-label col-lg-2" for="discontinued">Discontinued</label>
				<div class="col-lg-10">
					<form:checkbox id="discontinued" path="discontinued" />
				</div>
			</div> --%>
			<div class="form-group">
				<label class="control-label col-lg-2" for="condition">Condition</label>
				<div class="col-lg-10">
					<form:radiobutton path="condition" value="New" />
					New
					<form:radiobutton path="condition" value="Old" />
					Old
					<form:radiobutton path="condition" value="Refurbished" />
					Refurbished
				</div>
			</div>
			
			<div class="form-group">
<label class="control-label col-lg-2" for="productImage">
<spring:message code="addProdcut.form.productImage.label"/>
</label>
<div class="col-lg-10">
<form:input id="productImage" path="productImage" type="file" class="form:input-large" />
</div>
</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn btn-primary"
						value="Add" />
				</div>
			</div>
		</fieldset>
	</form:form> </section>
</body>
</html>