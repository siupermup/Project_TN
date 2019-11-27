<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f"%>
<%@ include file="/inclue/taglib.jsp"%>
<!DOCTYPE html>

<html>

<head>

<meta charset="UTF-8">
<title>Shipper</title>
<style>
	/* Style the tab */
	.tab {
	  overflow: hidden;
	  border: 1px solid #ccc;
	  background-color: #f1f1f1;
	}
	
	/* Style the buttons inside the tab */
	.tablinks {
	  background-color: inherit;
	  float: left;
	  border: none;
	  outline: none;
	  cursor: pointer;
	  padding: 14px 16px;
	  transition: 0.3s;
	  font-size: 17px;
	}
	
	/* Change background color of buttons on hover */
	.tablinks:hover {
	  background-color: #ddd;
	}
	
	/* Create an active/current tablink class */
	.tablinks.active {
	  background-color: #ccc;
	}
</style>
</head>
<body>
	<div class="tab">
	  <button class="tablinks" onclick="openTab(event, '1')" id="defaultOpen" style="background-color: lightgray;float: left;border: none;outline: none;cursor: pointer;padding: 14px 16px;transition: 0.3s;font-size: 17px;">
	  	Chưa xác nhận
	  </button>
	  <button class="tablinks" onclick="openTab(event, '2')" style="background-color: #f1f1f1;float: left;border: none;outline: none;cursor: pointer;padding: 14px 16px;transition: 0.3s;font-size: 17px;">
	  	Đã xác nhận - Đang giao
	  </button>
	  <button class="tablinks" onclick="openTab(event, '3')" style="background-color: lightgray;float: left;border: none;outline: none;cursor: pointer;padding: 14px 16px;transition: 0.3s;font-size: 17px;">
	  	Hoàn tất giao dịch
	  </button>
	</div>
	<div id="1" class="card-body" style="border: 2px solid lightgray">
	
			<p class="card-description">
				Add Design By :
				<code>Kiet</code>
			</p>
			
			<form action="" method="post">
			
				<div class="" style="">
				<div style="float:right;padding-right: 20px">
				</div>
					<table class="table table-striped table-bordered " id="table">
						<thead >
							<tr >
								<th style="text-align: center;"><Strong class="card-title text-primary">Order ID</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Customer Name</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Phone Number</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Staff Name</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Order Date</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Shipper Name</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Description</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Status</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Action</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Detail</strong></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="l1" items="${list1}">
								<tr>
									<td>${l1[0]}</td>
									<td>${l1[1]}</td>
									<td>${l1[2]}</td>
									<td>
										<!--<select>
											<option selected="selected"  value="">--Chọn--</option>
											<c:forEach var="u" items="${staff}">
												<option value="${u.staffID}">${u.staffName}</option>
											</c:forEach>
										</select>-->
									</td>
									<td>${l1[3]}</td>
									<td>
										<!-- <select>
											<option selected="selected" value="">--Chọn--</option>
											<c:forEach var="u" items="${shipper}">
												<option id="" value="${u.shipperID}">${u.shipperName}</option>
											</c:forEach>
										</select>  -->
									</td>
									<td>${l1[4]}</td>
									<td>Chưa xác nhận</td>
									<td>
										<div style="text-align: center;">
											 <a class="" href="homeAdmin/order/comfirm/${l1[0]}.php"
												title="Update"><i class="mdi mdi-arrow-up-bold-circle"></i></a>
										</div>
									</td>
									<td><a class="" href="homeAdmin/order/order_detail/${l1[0]}.php" title="detail">Detail</a></td>
								</tr>
	
							</c:forEach>
						</tbody>
					</table>
				</div>
			</form>
			
			<ul id="pagination-container" class="pagination"></ul>
	</div>
	<div id="2" class="card-body" style="border: 2px solid #f1f1f1">
	
			<p class="card-description">
				Add Design By :
				<code>Kiet</code>
			</p>
			
			<form action="" method="post">
			
				<div class="" style="">
				<div style="float:right;padding-right: 20px">
				</div>
					<table class="table table-striped table-bordered " id="table">
						<thead >
							<tr >
								<th style="text-align: center;"><Strong class="card-title text-primary">Order ID</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Customer ID</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Phone Number</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Staff ID</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Order Date</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Shipper ID</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Description</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Status</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Action</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Detail</strong></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="l2" items="${list2}">
								<tr>
									<td>${l2[0]}</td>
									<td>${l2[1]}</td>
									<td>${l2[2]}</td>
									<td>${l2[3]}</td>
									<td>${l2[4]}</td>
									<td>${l2[5]}</td>
									<td>${l2[6]}</td>
									<td>Đã xác nhận - đang giao</td>
									<td>
										<div style="text-align: center;">
											 <a class="" href="homeAdmin/order/finish/${l2[0]}.php"
												title="Update"><i class="mdi mdi-arrow-up-bold-circle"></i></a>
										</div>
									</td>
									<td><a class="" href="homeAdmin/order/order_detail/${l2[0]}.php" title="detail">Detail</a></td>
								</tr>
	
							</c:forEach>
						</tbody>
					</table>
				</div>
			</form>
			
			<ul id="pagination-container" class="pagination"></ul>
	</div>
	<div id="3" class="card-body" style="border: 2px solid lightgray">
	
			<p class="card-description">
				Add Design By :
				<code>Kiet</code>
			</p>
			
			<form action="" method="post">
			
				<div class="" style="">
				<div style="float:right;padding-right: 20px">
				</div>
					<table class="table table-striped table-bordered " id="table">
						<thead >
							<tr >
								<th style="text-align: center;"><Strong class="card-title text-primary">Order ID</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Customer ID</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Phone Number</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Staff ID</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Order Date</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Shipper ID</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Description</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Status</strong></th>
								<th style="text-align: center;"><Strong class="card-title text-primary">Detail</strong></th>
							</tr>
						</thead>
						<tbody>
							<c:forEach var="l3" items="${list3}">
								<tr>
									<td>${l3[0]}</td>
									<td>${l3[1]}</td>
									<td>${l3[2]}</td>
									<td>${l3[3]}</td>
									<td>${l3[4]}</td>
									<td>${l3[5]}</td>
									<td>${l3[6]}</td>
									<td>Hoàn tất giao dịch</td>
									<td><a class="" href="homeAdmin/order/order_detail/${l3[0]}.php" title="detail">Detail</a></td>
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
		function openTab(evt, cityName) {
		  var i, tabcontent, tablinks;
		  tabcontent = document.getElementsByClassName("card-body");
		  for (i = 0; i < tabcontent.length; i++) {
		    tabcontent[i].style.display = "none";
		  }
		  tablinks = document.getElementsByClassName("tablinks");
		  for (i = 0; i < tablinks.length; i++) {
		    tablinks[i].className = tablinks[i].className.replace(" active", "");
		  }
		  document.getElementById(cityName).style.display = "block";
		  evt.currentTarget.className += " active";
		}
		// Get the element with id="defaultOpen" and click on it
		document.getElementById("defaultOpen").click();
	</script>
	<script>
		$(document).ready(function() {
			$('table').DataTable({

				"aLengthMenu" : [ [ 5, 10, 25, -1 ], [ 5, 10, 25, "All" ] ],
				"iDisplayLength" : 5
			}

			);
		});
	</script>
</body>
</html>