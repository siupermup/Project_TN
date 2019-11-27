<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inclue/taglib.jsp"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- Bootstrap core CSS -->
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="description" content="OneTech shop project">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/template/web/styles/bootstrap4/bootstrap.min.css'/>">
<link
	href="
<c:url value='/template/web/plugins/fontawesome-free-5.0.1/css/fontawesome-all.css'/>"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/template/web/plugins/OwlCarousel2-2.2.1/owl.carousel.css'/>">

<link rel="stylesheet" type="text/css"
	href="
<c:url value='/template/web/plugins/OwlCarousel2-2.2.1/owl.theme.default.css'/>">
<link rel="stylesheet" type="text/css"
	href="
<c:url value='/template/web/plugins/OwlCarousel2-2.2.1/animate.css'/>">
<link rel="stylesheet" type="text/css"
	href="<c:url value='/template/web/plugins/slick-1.8.0/slick.css'/>
">

<link rel="stylesheet" type="text/css"
	href="
<c:url value='/template/web/styles/main_styles.css'/>
">

<link rel="stylesheet" type="text/css"
	href="<c:url value='/template/web/styles/responsive.css'/>">

<c:choose>
	<c:when test="${keyProduct==null}">
		<title>Trang chủ</title>
	</c:when>
	<c:otherwise>
		<title>Product</title>
		<link rel="stylesheet" type="text/css"
			href="
<c:url value='/template/web/styles/product_styles.css'/>
">
		<link rel="stylesheet" type="text/css"
			href="
<c:url value='/template/web/styles/product_responsive.css'/>
">
	</c:otherwise>
</c:choose>

</head>

<body>
	<div class="super_container">
		<!-- Navigation -->
		<%@ include file="/inclue/web/header.jsp"%>
		<!-- Main -->
		<dec:body />

		<!-- Footer -->
		<%@ include file="/inclue/web/footer.jsp"%>
		<!-- Copyright -->
		<div class="copyright">
			<div class="container">
				<div class="row">
					<div class="col">

						<div
							class="copyright_container d-flex flex-sm-row flex-column align-items-center justify-content-start">
							<div class="copyright_content">
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
								Copyright &copy;
								<script>
									document.write(new Date().getFullYear());
								</script>
								All rights reserved | This template is made with <i
									class="fa fa-heart" aria-hidden="true"></i> by <a
									href="https://colorlib.com" target="_blank">Colorlib</a>
								<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							</div>
							<div class="logos ml-sm-auto">
								<ul class="logos_list">
									<li><a href="#"><img
											src="<c:url value='/template/web/images/logos_1.png'/>
									"
											alt=""></a></li>
									<li><a href="#"><img
											src="<c:url value='/template/web/images/logos_2.png'/>
									"
											alt=""></a></li>
									<li><a href="#"><img
											src="<c:url value='/template/web/images/logos_3.png'/>
									"
											alt=""></a></li>
									<li><a href="#"><img
											src="<c:url value='/template/web/images/logos_4.png'/>
									"
											alt=""></a></li>

								</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="<c:url value='/template/web/js/jquery-3.3.1.min.js'/>
	"></script>
	<script
		src="<c:url value='/template/web/styles/bootstrap4/popper.js'/>
	"></script>
	<script
		src="<c:url value='/template/web/styles/bootstrap4/bootstrap.min.js'/>
	"></script>
	<script
		src="<c:url value='/template/web/plugins/greensock/TweenMax.min.js'/>
	"></script>
	<script
		src="<c:url value='/template/web/plugins/greensock/TimelineMax.min.js'/>
	"></script>

	<script
		src="<c:url value='/template/web/plugins/scrollmagic/ScrollMagic.min.js'/>
	"></script>
	<script
		src="<c:url value='/template/web/plugins/greensock/animation.gsap.min.js'/>
	"></script>
	<script
		src="<c:url value='/template/web/plugins/greensock/ScrollToPlugin.min.js'/>
	"></script>
	<script
		src="<c:url value='/template/web/plugins/OwlCarousel2-2.2.1/owl.carousel.js'/>
	"></script>
	<script
		src="<c:url value='/template/web/plugins/slick-1.8.0/slick.js'/>
	"></script>
	<script src="<c:url value='/template/web/plugins/easing/easing.js'/>
	"></script>
	<script src="<c:url value='/template/web/js/custom.js'/>
	"></script>
	<script src="<c:url value='/template/web/plugins/easing/easing.js'/>
	"></script>
	<script src="
	<c:url value='/template/web/js/product_custom.js'/>"></script>
</body>

</html>