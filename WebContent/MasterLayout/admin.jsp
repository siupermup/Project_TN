<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inclue/taglib.jsp"%>


<!DOCTYPE html>
<html>
<head>

<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<title>Purple Admin</title>
<!-- plugins:css -->
<link rel="stylesheet"
	href="
	<c:url value='/template/admin/vendors/iconfonts/mdi/css/materialdesignicons.min.css'/>
	">
<link rel="stylesheet"
	href="
	<c:url value='/template/admin/vendors/css/vendor.bundle.base.css'/>
">
<!-- endinject -->
<!-- inject:css --><base href="${pageContext.servletContext.contextPath}/">
<link rel="stylesheet"
	href="
<c:url value='/template/admin/css/style.css'/>
">
<!-- endinject -->
<link rel="shortcut icon"
	href="
<c:url value='/template/admin/images/favicon.png'/>
">
<style type="text/css">/* Chart.js */
@
keyframes chartjs-render-animation {
	from {opacity: .99
}

to {
	opacity: 1
}

}
.chartjs-render-monitor {
	animation: chartjs-render-animation 1ms
}

.chartjs-size-monitor, .chartjs-size-monitor-expand,
	.chartjs-size-monitor-shrink {
	position: absolute;
	direction: ltr;
	left: 0;
	top: 0;
	right: 0;
	bottom: 0;
	overflow: hidden;
	pointer-events: none;
	visibility: hidden;
	z-index: -1
}

.chartjs-size-monitor-expand>div {
	position: absolute;
	width: 1000000px;
	height: 1000000px;
	left: 0;
	top: 0
}

.chartjs-size-monitor-shrink>div {
	position: absolute;
	width: 200%;
	height: 200%;
	left: 0;
	top: 0
}
</style>
</head>
<body>
	<div class="container-scroller">
		<!-- partial:partials/_navbar.html -->
		<%@ include file="/inclue/admin/header.jsp"%>
		<!-- partial -->
		<div class="container-fluid page-body-wrapper">
			<!-- partial:partials/_sidebar.html -->
			<%@ include file="/inclue/admin/leftMenu.jsp"%>
			<!-- partial -->
			<div class="main-panel">
				<dec:body />
				<!-- content-wrapper ends -->
				<!-- partial:partials/_footer.html -->
				<%@ include file="/inclue/admin/footer.jsp"%>
				<!-- partial -->
			</div>
			<!-- main-panel ends -->
		</div>
		<!-- page-body-wrapper ends -->
	</div>
	<!-- plugins:js -->
	<script
		src="
  <c:url value='/template/admin/vendors/js/vendor.bundle.base.js'/>
 "></script>
	<script
		src="
    <c:url value='/template/admin/vendors/js/vendor.bundle.addons.js'/>
"></script>
	<!-- endinject -->
	<!-- Plugin js for this page-->
	<!-- End plugin js for this page-->
	<!-- inject:js -->
	<script src="
    <c:url value='/template/admin/js/off-canvas.js'/>
"></script>
	<script src="
   <c:url value='/template/admin/js/misc.js'/>
"></script>
	<!-- endinject -->
	<!-- Custom js for this page-->
	<script
		src="
     <c:url value='/template/admin/js/dashboard.js'/>
  "></script>
	<!-- End custom js for this page-->
	<link
		href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		rel="stylesheet" id="bootstrap-css">
	<script
		src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<!------ Include the above in your HEAD tag ---------->

	<script
		src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	<script
		src="https://cdn.datatables.net/1.10.16/js/dataTables.bootstrap4.min.js"></script>

	<script>
		$(document).ready(function() {
			$('#table').DataTable({

				"aLengthMenu" : [ [ 5, 10, 25, -1 ], [ 5, 10, 25, "All" ] ],
				"iDisplayLength" : 5
			}

			);
		});
</body>
</html>