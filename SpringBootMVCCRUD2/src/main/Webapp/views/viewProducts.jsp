<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--It is JSTL Core Tag and the Dependancy is added in pom.xml file --%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View All Products</title>
</head>
<body>
<table border="1" width="80%">
<tr><th>Product_ID</th><th>Product_Name</th><th>Quantity</th><th>Price</th><th>Edit</th><th>Delete</th></tr>
<c:forEach items="${products}" var="product">
<tr>
<td>${product.pid}</td>
<td>${product.pname}</td>
<td>${product.quantity}</td>
<td>${product.price}</td>
<td><a href="editProduct/${product.pid}">Edit</a></td>
<td><a href="deleteproduct/${product.pid}">Delete</a></td>
</tr>
</c:forEach>
</table>
</body>
</html>