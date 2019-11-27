<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/inclue/taglib.jsp"%>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">
<title>Shipper</title>

</head>
<body>
	<div class="card-body">
	
			<p class="card-description">
				Add Design By :
				<code>Kiet</code>
			</p>
			<form action="" method="post">
			
				<div class="" style="">
				<div style="float:right;padding-right: 20px">
				<a href="homeAdmin/shipper/shipper_form.php">
					<button type="button" class="btn btn-outline-primary btn-icon-text">
	                     <i class="mdi mdi-file-check btn-icon-prepend"></i>
	                     New Shipper
	                </button>
				</a>
				</div>
					<table class="table table-striped table-bordered " id="table">
						<thead >
							<tr >
								<th style="text-align: center;"><Strong class="card-title text-primary">Choice</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Shipper ID</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Shipper Name</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Company Name</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Phone</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Actiton</strong></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="p" items="${shipper}">
								<tr>
									<td><input type="checkbox" name="chon"
										value=""></td>
									<td>${p.shipperID}</td>
									<td>${p.shipperName}</td>
									<td>${p.companyName}</td>
									<td>${p.phone}</td>
									<td>
										<div style="text-align: center;">
											 <a class="" href="homeAdmin/shipper/shipper_edit/${p.getShipperID()}.php"
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