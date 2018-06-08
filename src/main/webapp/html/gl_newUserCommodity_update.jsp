<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/5/8 0008
  Time: 下午 4:33
  To change this template use File | Settings | File Templates.
--%>
<%	String basePath = request.getContextPath();%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<base href="<%=request.getContextPath()%>/html/"/>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>修改优惠商品</title>
		<link rel="stylesheet" href="../assets/css/amazeui.css" />
		<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
		<link rel="stylesheet" href="../assets/css/core.css" />
		<link rel="stylesheet" href="../assets/css/menu.css" />
		<link rel="stylesheet" href="../assets/css/index.css" />
		<link rel="stylesheet" href="../assets/css/admin.css" />
		<link rel="stylesheet" href="../assets/css/page/typography.css" />
		<link rel="stylesheet" href="../assets/css/page/form.css" />
	</head>
	<body>
		<!-- Begin page -->
		<header class="am-topbar am-topbar-fixed-top">		
			<div class="am-topbar-left am-hide-sm-only">
                <a href="index.ftl" class="logo"><span>Admin<span>to</span></span><i class="zmdi zmdi-layers"></i></a>
            </div>
	
			<div class="contain">
				<ul class="am-nav am-navbar-nav am-navbar-left">

					<li><h4 class="page-title">修改信息</h4></li>
				</ul>
				
				<ul class="am-nav am-navbar-nav am-navbar-right">
					<li class="inform"><i class="am-icon-bell-o" aria-hidden="true"></i></li>
					<li class="hidden-xs am-hide-sm-only">
                        <form role="search" class="app-search">
                            <input type="text" placeholder="Search..." class="form-control">
                            <a href=""><img src="../assets/img/search.png"></a>
                        </form>
                    </li>
				</ul>
			</div>
		</header>
		<!-- end page -->
		
		
		<div class="admin">
			<!--<div class="am-g">-->
		<!-- ========== Left Sidebar Start ========== -->
		<!--<div class="left side-menu am-hide-sm-only am-u-md-1 am-padding-0">
			<div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 548px;">
				<div class="sidebar-inner slimscrollleft" style="overflow: hidden; width: auto; height: 548px;">-->
                  <!-- sidebar start -->
				  <div class="admin-sidebar am-offcanvas  am-padding-0" id="admin-offcanvas">
				    <div class="am-offcanvas-bar admin-offcanvas-bar">
				    	<!-- User -->
						<div class="user-box am-hide-sm-only">
	                        <div class="user-img">
	                            <img src="../assets/img/avatar-1.jpg" alt="user-img" title="Mat Helme" class="img-circle img-thumbnail img-responsive">
	                            <div class="user-status offline"><i class="am-icon-dot-circle-o" aria-hidden="true"></i></div>
	                        </div>
	                        <h5><a href="#">Mat Helme</a> </h5>
	                        <ul class="list-inline">
	                            <li>
	                                <a href="#">
	                                    <i class="am-icon-cog" aria-hidden="true"></i>
	                                </a>
	                            </li>
	
	                            <li>
	                                <a href="#" class="text-custom">
	                                    <i class="am-icon-cog" aria-hidden="true"></i>
	                                </a>
	                            </li>
	                        </ul>
	                    </div>
	                    <!-- End User -->

						<ul class="am-list admin-sidebar-list">
							<li><a href="<%=basePath %>/manager_index.jsp"><span class="am-icon-home"></span> 首页</a></li>
							<li class="admin-parent">
								<a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-table"></span> 管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
								<ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav1">
									<li><a href="<%=basePath %>/customer/customerList/0" class="am-cf">用户管理</span></a></li>
									<li><a href="<%=basePath %>/commodity/commodityList/0,1">商品管理</a></li>
									<li><a href="gl_orders.ftl">订单管理</a></li>
									<li><a href="gl_change.ftl" class="am-cf"> 退换货管理</span></a></li>
									<li><a href="gl_activity.ftl" class="am-cf"> 活动管理</span></a></li>
									<li><a href="gl_blackCustomer.ftl" class="am-cf"> 黑名单管理</span></a></li>
									<li><a href="gl_interest.ftl" class="am-cf"> 利息管理</span></a></li>
								</ul>
							</li>
							<li class="admin-parent">
								<a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}"><i class="am-icon-line-chart" aria-hidden="true"></i> 其他 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
								<ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav2">
									<li><a href="qt_coupon.ftl" class="am-cf"> 优惠券发布</span></a></li>
									<li><a href="qt_repay.ftl" class="am-cf">还款信息</span></a></li>

								</ul>
							</li>
							<li class="admin-parent">
								<a class="am-cf" data-am-collapse="{target: '#collapse-nav5'}"><span class="am-icon-file"></span> 上架 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
								<ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav5">
									<li><a href="sj_kill.ftl" class="am-cf"> 秒杀商品上架</a></li>
									<li><a href="sj_new_user.ftl">新人优惠商品上架</a></li>
								</ul>
							</li>
						</ul>
				</div>
				  </div>
				  <!-- sidebar end -->
    
				<!--</div>
			</div>
		</div>-->
		<!-- ========== Left Sidebar end ========== -->
		
		
		
	<!--	<div class="am-g">-->
		<!-- ============================================================== -->
		<!-- Start right Content here -->
		<div class="content-page">
			<!-- Start content -->
			<div class="content">
				<div class="am-g">
					<!-- Row start -->
						<div class="am-u-sm-12">
							<div class="card-box">
								<ul class="am-nav am-fr">
								  <li class="am-dropdown" data-am-dropdown>
								    <a class="am-dropdown-toggle" data-am-dropdown-toggle href="javascript:;">
								       <span class="am-icon-caret-down"></span>
								    </a>
								    <ul class="am-dropdown-content">
								      <li>1231234</li>
								      <li>1231234</li>
								      <li>1231234</li>
								      <li>1231234</li>
								    </ul>
								  </li>
								</ul>
								
								<form action="/fqg/newUserCommodity/update" method="post" class="am-form" accept-charset="UTF-8" data-am-validator>
								  <fieldset>
								    <legend>修改优惠商品信息</legend>
									  <input type="hidden" id="doc-vld-id-2" name="newUerCommodityId" value="${newUserCommodity.newUerCommodityId}" required/>
									  <input type="hidden" id="doc-vld-id-3" name="createTime" value="${newUserCommodity.createTime}" required/>

									  <div class="am-form-group">
								      <label for="doc-vld-name-2">商品id</label>
								      <input type="text" id="doc-vld-name-2" name="commodityId"  value="${newUserCommodity.commodityId}" required/>
								    </div>

									  <div class="am-form-group">
										  <label for="doc-vld-name-2">优惠价格</label>
										  <input type="text" id="doc-vld-name-3" name="price"  value="${newUserCommodity.price}" required/>
									  </div>

								    <button class="am-btn am-btn-secondary" type="submit">提交</button>
								  </fieldset>
								</form>
								
								
							</div>
						</div>
					<!-- Row end -->
				</div>
			
			
			
			
			</div>
		</div>
		<!-- end right Content here -->
		<!--</div>-->
		</div>
		</div>
		
		<!-- navbar -->
		<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>
		
		<script type="text/javascript" src="../assets/js/jquery-2.1.0.js" ></script>
		<script type="text/javascript" src="../assets/js/amazeui.min.js"></script>
		<script type="text/javascript" src="../assets/js/app.js" ></script>
		<script type="text/javascript" src="../assets/js/blockUI.js" ></script>
	</body>
	
</html>
