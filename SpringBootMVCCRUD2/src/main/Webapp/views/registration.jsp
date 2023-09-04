<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration JSP</title>
</head>
<body>
<h1>Product Registration</h1>
<form action="saveProduct" method="post">
Product Name : <input type="text" name="pname"><br>
Quantity : <input type="number" name="quantity"><br>
Price : <input type="text" name="price"><br>
<input type="submit" value = "Add Product">
<input type="reset" value="Reset"><br><br>
<a href="viewProducts">View All Products</a>

</form>
</body>
</html>