<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ include file="/inclue/taglib.jsp"%>
<nav class="sidebar sidebar-offcanvas" id="sidebar">
				<ul class="nav">
					<li class="nav-item nav-profile"><a href="#" class="nav-link">
							<div class="nav-profile-image">
								<img src="
								     <c:url value='/template/admin/images/faces/face1.jpg'/>
								" alt="profile"> <span
									class="login-status online"></span>
								<!--change to offline or busy as needed-->
							</div>
							<div class="nav-profile-text d-flex flex-column">
								<span class="font-weight-bold mb-2">Anh đẹp zai đang onl</span> <span
									class="text-secondary text-small">Project Manager</span>
							</div> <i class="mdi mdi-bookmark-check text-success nav-profile-badge"></i>
					</a></li>
					<li class="nav-item active"><a class="nav-link"
						href="index.html"> <span class="menu-title">Dashboard</span> <i
							class="mdi mdi-home menu-icon"></i>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						data-toggle="collapse" href="#ui-basic" aria-expanded="false"
						aria-controls="ui-basic"> <span class="menu-title">Manage Employe</span> <i class="menu-arrow"></i> <i
							class="mdi mdi-crosshairs-gps menu-icon"></i>
					</a><!--  
						<div class="collapse" id="ui-basic">
							<ul class="nav flex-column sub-menu">
								<li class="nav-item"><a class="nav-link"
									href="pages/ui-features/buttons.html">Views</a></li>
								<li class="nav-item"><a class="nav-link"
									href="pages/ui-features/typography.html">History change</a></li>
							</ul>
						</div>--></li>
					<li class="nav-item"><a class="nav-link"
						href="homeAdmin/product.php"> <span class="menu-title">Manage Product</span>
							<i class="mdi mdi-contacts menu-icon"></i>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="homeAdmin/shipper.php"> <span
							class="menu-title">List Shipper</span> <i
							class="mdi mdi-format-list-bulleted menu-icon"></i>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="homeAdmin/order.php"> <span class="menu-title">Manage Order</span>
							<i class="mdi mdi-chart-bar menu-icon"></i>
					</a></li>
					<li class="nav-item"><a class="nav-link"
						href="pages/tables/basic-table.html"> <span class="menu-title">History Activity</span>
							<i class="mdi mdi-table-large menu-icon"></i>
					</a></li>
					<!-- 
					<li class="nav-item"><a class="nav-link"
						data-toggle="collapse" href="#general-pages" aria-expanded="false"
						aria-controls="general-pages"> <span class="menu-title">Sample
								Pages</span> <i class="menu-arrow"></i> <i
							class="mdi mdi-medical-bag menu-icon"></i>
					</a>
						<div class="collapse" id="general-pages">
							<ul class="nav flex-column sub-menu">
								<li class="nav-item"><a class="nav-link"
									href="pages/samples/blank-page.html"> Blank Page </a></li>
								<li class="nav-item"><a class="nav-link"
									href="pages/samples/login.html"> Login </a></li>
								<li class="nav-item"><a class="nav-link"
									href="pages/samples/register.html"> Register </a></li>
								<li class="nav-item"><a class="nav-link"
									href="pages/samples/error-404.html"> 404 </a></li>
								<li class="nav-item"><a class="nav-link"
									href="pages/samples/error-500.html"> 500 </a></li>
							</ul>
						</div></li> -->
					<li class="nav-item sidebar-actions"><span class="nav-link">
							<div class="border-bottom">
								<h6 class="font-weight-normal mb-3">Projects</h6>
							</div>
							<button class="btn btn-block btn-lg btn-gradient-primary mt-4">+
								Add a project</button>
							<div class="mt-4">
								<div class="border-bottom">
									<p class="text-secondary">Categories</p>
								</div>
								<ul class="gradient-bullet-list mt-4">
									<li>Free</li>
									<li>Pro</li>
								</ul>
							</div>
					</span></li>
				</ul>
			</nav>