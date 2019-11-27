<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ include file="/inclue/taglib.jsp"%>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">
<title>Trang chủ</title>

</head>
<body>
	${message}
	<div class="container">
		<h2>Thêm mới shipper</h2>
		 <form:form action="homeAdmin/shipper/shipper_form.php" modelAttribute="shipper" method="post">
			<div class="form-group">
				<label>Shipper Name</label>
				<form:input path="shipperName" class="form-control" />
			</div>
			<div class="form-group">
				<label>Company Name</label>
				<form:input path="companyName" class="form-control" />
			</div>
			<div class="form-group">
				<label>Phone Number</label>
				<form:input path="phone" class="form-control" />
			</div>
			<div>
				<button class="btn btn-success" type="submit">Thêm mới</button>
			</div>
		</form:form> 
	</div>
</body>
</html>