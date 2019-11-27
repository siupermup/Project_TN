<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inclue/taglib.jsp"%>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">
<title>Order Detail</title>

</head>
<body>
	<div class="card-body">
	
			<p class="card-description">
				Add Design By :
				<code>Kiet</code>
			</p>
			<form action="" method="get">
			
				<div class="" style="">
				<div style="float:right;padding-right: 20px">
				</div>
					<table class="table table-striped table-bordered " id="table">
						<thead >
							<tr >
								<th style="text-align: center;"><Strong class="card-title text-primary">Order ID</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Product Name</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Price</strong></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="p" items="${list}">
								<tr>
									<td>${p[1]}</td>
									<td>${p[2]}</td>
									<td>${p[3]}</td>
								</tr>
	
							</c:forEach>
						</tbody>
					</table>
				</div>
			</form>
			<ul id="pagination-container" class="pagination"></ul>
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