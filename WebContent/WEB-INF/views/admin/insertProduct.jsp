<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ include file="/inclue/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert</title>
</head>
<body>
${message}
<div class="container">
	<h2>Thêm mới sản phẩm</h2>
	 <form:form action="homeAdmin/product/insertProduct.php" modelAttribute="product"
		entype="multipart/form-data" method="post">
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
			<form:input path="photo1" type="file"/>
		</div>
		<div class="form-group">
			<label>Chọn hình 2</label>
			<form:input path="photo2" type="file"/>
		</div>
		<div class="form-group">
			<label>Chọn hình 3</label>
			<form:input path="photo3" type="file"/>
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
			<button class="btn btn-success" type="submit">Thêm mới</button>
		</div>
	</form:form> 
</div>
</body>
</html>