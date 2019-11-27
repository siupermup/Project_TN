<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inclue/taglib.jsp"%>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">
<title>Trang chủ</title>

</head>
<body>

	<div class="card-body">

		<p class="card-description">
			Add Design By :
			<code></code>
		</p>
		<form action="" method="post">
		
			<div class="" style="">
			<div style="float:right;padding-right: 20px">
			<a href="homeAdmin/product/insertProduct.php">
				<button type="button" class="btn btn-outline-primary btn-icon-text">
                     <i class="mdi mdi-file-check btn-icon-prepend"></i>
                     New Product
                </button>
			</a>
			</div>
				<table class="table table-striped table-bordered " id="table">
					<thead >
						<tr >
							<th><Strong class="card-title text-primary">Choice</strong>
							</th>
							<th><Strong class="card-title text-primary">Code
									Producta</strong></th>
							<th><Strong class="card-title text-primary"> Name
									Producta</strong></th>
							<th><Strong class="card-title text-primary"> Price</strong>
							</th>
							<th style="text-align: center;"><Strong
								class="card-title text-primary"> Images Producta</strong></th>
							<th style="text-align: center;"><Strong
								class="card-title text-primary"> Quantity</strong></th>
							<th style="text-align: center;"><Strong
								class="card-title text-primary"> Status</strong></th>
							<th style="text-align: center;"><Strong
								class="card-title text-primary"> Actiton</strong></th>

						</tr>
					</thead>
					<tbody>
						<c:forEach var="p" items="${products}">
							<tr>
								<td><input type="checkbox" name="chon"
									value="${p.getProductID()}"></td>
								<td>${p.getProductID()}</td>
								<td>${p.productName}</td>
								<td>${p.price}</td>
								<td style="text-align: center;"><img
									src="template/web/images/${p.photo1} " height="300px" width="300px" /></td>
								<td>${p.quantity}</td>
								<td>${p.status}</td>
								<td>
									<div style="text-align: center;">
										<a class="" href="homeAdmin/product/delProduct/${p.getProductID()}.php" title="delete"><i
											class="mdi mdi-delete-forever"></i></a> <a class="" href="homeAdmin/product/editProduct/${p.getProductID()}.php"
											title="Update"><i class="mdi mdi-arrow-up-bold-circle"></i></a>
									</div>
								</td>
							</tr>

						</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="row">
				<button type="submit" class="btn btn-link btn-fw">
					<i class="card-title text-primary">Delete all products?</i>
				</button>

			</div>
		</form>
		<ul id="pagination-container" class="pagination"></ul>

		<!-- content-wrapper ends -->
		<!-- partial:partials/_footer.html -->

		<!-- partial -->
	</div>
	<link
		href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
		rel="stylesheet" id="bootstrap-css">
	<script
		src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<!------ Include the above in your HEAD tag ---------->

	<script
		src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.min.js"></script>
	
	<script>
		$(document).ready(function() {
			$('#table').DataTable({

				"aLengthMenu" : [ [ 5, 10, 25, -1 ], [ 5, 10, 25, "All" ] ],
				"iDisplayLength" : 5
			}

			);
		});
	</script>
</body>
</html>