<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--It is an Spring Form Tag  --%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EditProduct JSP</title>
</head>
<body>
<h1>Edit Product</h1>
<form:form action="/updateProduct" method="post" modelAttribute="product">
Product ID : <form:input path="pid" disabled="false"/><br>
Product Name : <form:input path="pname" /><br>
Quantity : <form:input path="quantity" /><br>
Price : <form:input path="price" /><br>
<input type="submit" value = "Edit Product">
<input type="reset" value="Reset"><br><br>
<a href="viewProducts">View All Products</a>

</form:form>
</body>
</html>