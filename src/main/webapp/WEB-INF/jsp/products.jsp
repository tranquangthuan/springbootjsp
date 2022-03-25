<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Product List Page</h1>
		<c:if test="${not empty message}">
		${message}
	</c:if>
		<a href="/product/addnew">Add new Product</a>
		<table border="1" style="width: 700px; text-align: center;">
			<tr>
				<td>Name</td>
				<td>Color</td>
				<td>Quantity</td>
				<td>Edit</td>
				<td>Delete</td>
			</tr>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.name}</td>
					<td>${product.color}</td>
					<td>${product.quantity}</td>
					<td><a href="edit/${product.id}">Edit</a></td>
					<td><a href="delete/${product.id}">Delete</a></td>
				</tr>
			</c:forEach>
		</table>

	</div>

</body>
</html>