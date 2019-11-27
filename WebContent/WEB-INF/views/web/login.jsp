<%@ page pageEncoding="utf-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container"
		style="padding-top: 10px; width: 400px; height: 400px; border: 2px solid blue; border-radius: 10px">
		<h2 style="text-align: center;">Đăng Nhập</h2>
		${message}
		<form:form action="login.php" modelAttribute="Customer">
			<div class="form-group">
				<label>YourEmail</label>
				<form:input path="email" class="form-control" />
			</div>

			<div class="form-group">
				<label>Password</label>
				<form:input path="password" class="form-control" type="password" />
			</div>

			<div>
				<button class="btn btn-success">Login</button>
			</div>
		</form:form>
	</div>
</body>
</html>