<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inclue/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<div class="product_panel panel active">
		<div class="featured_slider slider">
			<c:forEach  var="u" items="${data}">
				<div class="featured_slider_item">
					<div class="border_active"></div>
					<div
						class="product_item discount d-flex flex-column align-items-center justify-content-center text-center">
						<div
							class="product_image d-flex flex-column align-items-center justify-content-center">
							<img src="template/web/images/${u.photo1}" alt="" height="100" width="100">
						</div>
						<div class="product_content">
							<div class="product_price discount">
								$${u.price}
							</div>
							<div class="product_name">
								<div>
									<a href="product/${u.productID}.php">${u.productName}</a>
								</div>
							</div>
							<div class="product_extras">
								<div class="product_color">
									<input type="radio" checked name="product_color"
										style="background: #b19c83"> <input type="radio"
										name="product_color" style="background: #000000">
									<input type="radio" name="product_color"
										style="background: #999999">
								</div>
								<a href="#"><button class="product_cart_button">Add to Cart</button></a>
							</div>
						</div>
						<div class="product_fav">
							<i class="fas fa-heart"></i>
						</div>
						<ul class="product_marks">
							<li class="product_mark product_discount">-25%</li>
							<li class="product_mark product_new">new</li>
						</ul>
					</div>
				</div>
			</c:forEach>
		</div>
		<div class="featured_slider_dots_cover"></div>
	</div>
	</div>
</body>
</html>