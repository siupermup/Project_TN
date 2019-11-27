<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ include file="/inclue/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	${message}
<div class="container">
	<h2>Cập nhật sản phẩm</h2>
	<form:form action="homeAdmin/product/editProduct.php" modelAttribute="product"
		entype="multipart/form-data" method="post">
		<div class="form-group">
			<label>Ma sản phẩm</label>
			<form:input path="ProductID"/>
		</div>
		<div class="form-group">
			<label>Ten sản phẩm</label>
			<form:input path="productName"/>
		</div>
		
		<div>
			<label>Nha cung cap</label>
			<form:select path="supplier.supplierID" items="${supplier}" itemValue="supplierID" itemLabel="supplierName"/>
		</div>

		<div class="form-group">
			<label>Nha san xuat</label>
			<form:select path="manufacturer.manufacturerID" items="${manufacturer}" itemValue="manufacturerID" itemLabel="manufacturerName"/>
		</div>
		<div class="form-group">
			<label>Danh muc</label>
			<form:select path="category.CategoryID" items="${category}" itemValue="CategoryID" itemLabel="categoryName"/>
		</div>
		<div class="form-group">
			<label>Chọn hình 1</label>
			<form:input path="photo1" type="file" name="file"/>
			
		</div>
		<div class="form-group">
			<label>Chọn hình 2</label>
			<form:input path="photo2" type="file"  name="file"/>
			
		</div>
		<div class="form-group">
			<label>Chọn hình 3</label>
			<form:input path="photo3" type="file"  name="file"/>
			
		</div>
		<div>
			<label>Gia</label>
			<form:input path="price"/>
		</div>
		<div>
			<label>So luong</label>
			<form:input path="quantity" class="form-control" />
		</div>
		<div>
		<label>Mo ta</label>
		<form:textarea path="description" class="form-control" />
		</div>
		

		<div>
			<button class="btn btn-success" type="submit">Update</button>
		</div>
	</form:form> 
</div>
</body>
</html>