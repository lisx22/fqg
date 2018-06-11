<html>
<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>商品管理</title>
<#assign base=request.contextPath />
    <base id="base" href="${base}/"/>
		<link rel="stylesheet" href=" assets/css/amazeui.css" />
		<link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
		<link rel="stylesheet" href=" assets/css/core.css" />
		<link rel="stylesheet" href=" assets/css/menu.css" />
		<link rel="stylesheet" href=" assets/css/index.css" />
		<link rel="stylesheet" href=" assets/css/admin.css" />
		<link rel="stylesheet" href=" assets/css/page/typography.css" />
		<link rel="stylesheet" href=" assets/css/page/form.css" />
	</head>
<body>
<!-- Begin page -->
<header class="am-topbar am-topbar-fixed-top">
	<div class="am-topbar-left am-hide-sm-only">
		<a href="index.ftl" class="logo"><span>Admin<span>to</span></span><i class="zmdi zmdi-layers"></i></a>
	</div>

	<div class="contain">
		<ul class="am-nav am-navbar-nav am-navbar-left">

			<li><h4 class="page-title">基本表格</h4></li>
		</ul>

		<ul class="am-nav am-navbar-nav am-navbar-right">
			<li class="inform"><i class="am-icon-bell-o" aria-hidden="true"></i></li>
			<li class="hidden-xs am-hide-sm-only">
				<form role="search" class="app-search">
					<input type="text" placeholder="Search..." class="form-control">
					<a href=""><img src=" assets/img/search.png"></a>
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
					<img src=" assets/img/avatar-1.jpg" alt="user-img" title="Mat Helme" class="img-circle img-thumbnail img-responsive">
					<div class="user-status offline"><i class="am-icon-dot-circle-o" aria-hidden="true"></i></div>
				</div>
				<h5><a href="#">Mat Helme</a> </h5>
				<ul class="list-inline">
					<li>
						<a href="#">
							<i class="fa fa-cog" aria-hidden="true"></i>
						</a>
					</li>

					<li>
						<a href="#" class="text-custom">
							<i class="fa fa-cog" aria-hidden="true"></i>
						</a>
					</li>
				</ul>
			</div>
			<!-- End User -->

            <ul class="am-list admin-sidebar-list">
                <li><a href=""><span class="am-icon-home"></span> 首页</a></li>
                <li class="admin-parent">
                    <a class="am-cf" data-am-collapse="{target: '#collapse-nav1'}"><span class="am-icon-table"></span> 管理 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                    <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav1">
                        <li><a href="customer/customerList/0" class="am-cf">用户管理</span></a></li>
                        <li><a href="commodity/commodityList/0,1">商品管理</a></li>
                        <li><a href="orders/ordersList/0">订单管理</a></li>
                        <li><a href="blackCustomer/blackCustomerList/0" class="am-cf"> 黑名单管理</span></a></li>
                    </ul>
                </li>
                <li class="admin-parent">
                    <a class="am-cf" data-am-collapse="{target: '#collapse-nav2'}"><i class="am-icon-line-chart" aria-hidden="true"></i> 其他 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                    <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav2">
                        <li><a href=" coupon/couponList/1" class="am-cf"> 优惠券发布</span></a></li>

                    </ul>
                </li>
                <li class="admin-parent">
                    <a class="am-cf" data-am-collapse="{target: '#collapse-nav5'}"><span class="am-icon-file"></span> 上架 <span class="am-icon-angle-right am-fr am-margin-right"></span></a>
                    <ul class="am-list am-collapse admin-sidebar-sub am-in" id="collapse-nav5">
                        <li><a href=" killCommodity/killCommodityList/0" class="am-cf">秒杀商品上架</a></li>
                        <li><a href=" newUserCommodity/newUserCommodityList/0">新人优惠商品上架</a></li>
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
			<div class="card-box">
				<!-- Row start -->
				<div class="am-g">
					<div class="am-u-sm-12 am-u-md-6">
						<div class="am-btn-toolbar">
							<div class="am-btn-group am-btn-group-xs">
								<button type="button" id="addBut2" class="am-btn am-btn-default"><span class="am-icon-plus"></span> 新增</button>

								<div class="am-form-group">

								</div>


							</div>
						</div>
					</div>

					<div class="am-u-sm-12 am-u-md-3">
						<div class="am-input-group am-input-group-sm">
							<input type="text" class="am-form-field">
							<span class="am-input-group-btn">
				            <button class="am-btn am-btn-default" type="button">搜索</button>
				          </span>
						</div>
					</div>
				</div>
				<!-- Row end -->

				<!-- Row start -->
				<h4>${typeName}:</h4>
				<div class="am-g">
					<div class="am-u-sm-12">
						<form>

							<table class="am-table am-table-striped am-table-hover table-main" style="table-layout: fixed;">
<#if ListType == 1>

								<thead>
								<tr>
									</th><th class="table-id">ID</th>
									<th class="table-title">期数</th>
									<th class="table-type">数量</th>
									<th class="table-set">操作</th>
								</tr>
								</thead>
								<tbody>


<#list CouponList as coupons>
									<tr>
										<td>${coupons.couponId}</td>
										<td>${coupons.nointerestContent}</td>
										<td>${coupons.number}</td>

										<td>
											<div class="am-btn-toolbar">
												<div class="am-btn-group am-btn-group-xs">
													<button id="deletebut${coupons.couponId}${ListType}" onclick="deleteById2(${coupons.couponId},${ListType})" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
													<a href="  coupon/deleteById/${coupons.couponId},${ListType}" id="delete${coupons.couponId}${ListType}"></a>
												</div>
											</div>
										</td>
									</tr>
</#list>


								</tbody>
</#if>

<#if ListType == 2>
									<thead>
									<tr>
										</th><th class="table-id">ID</th>
										<th class="table-title">应满足金额</th>
										<th class="table-type">优惠金额</th>
										<th class="table-set">操作</th>
									</tr>
									</thead>
									<tbody>
<#list CouponList as coupons>
										<tr>
											<td>${coupons.couponId}</td>
											<td>${coupons.conditionAmount}</td>
											<td>${coupons.reduceAmount}</td>
											<td>${coupons.number}</td>
											<td>
												<div class="am-btn-toolbar">
													<div class="am-btn-group am-btn-group-xs">

														<button id="deletebut${coupons.couponId}${ListType}" onclick="deleteById2(${coupons.couponId},${ListType})" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
														<a href="  coupon/deleteById/${coupons.couponId},${ListType}"  id="delete${coupons.couponId}${ListType}"></a>
													</div>
												</div>
											</td>
										</tr>
</#list>
									</tbody>
</#if>

<#if ListType == 3>
									<thead>
									<tr>
										</th><th class="table-id">ID</th>
										<th class="table-title">期数</th>
										<th class="table-type">数量</th>
										<th class="table-set">类型名称</th>
									</tr>
									</thead>
									<tbody>
<#list CouponList as coupons>
										<tr>
											<td>${coupons.couponId}</td>
											<td>${coupons.nointerestContent}</td>
											<td>${coupons.number}</td>
											<td>${coupons.typeOne.typeOneName}</td>
											<td>
												<div class="am-btn-toolbar">
													<div class="am-btn-group am-btn-group-xs">
														<button id="deletebut${coupons.couponId}${ListType}" onclick="deleteById2(${coupons.couponId},${ListType})" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
														<a href="  coupon/deleteById/${coupons.couponId},${ListType}"  id="delete${coupons.couponId}${ListType}"></a>	</div>
												</div>
											</td>
										</tr>
</#list>
									</tbody>
</#if>

	<#if ListType == 4>
									<thead>
									<tr>
										</th><th class="table-id">ID</th>
										<th class="table-title">满足金额</th>
										<th class="table-type">优惠金额</th>
										<th class="table-set">数量</th>
										<th class="table-set">类型名称</th>
									</tr>
									</thead>
									<tbody>
<#list CouponList as coupons>
										<tr>
											<td>${coupons.couponId}</td>
											<td>${coupons.conditionAmount}</td>
											<td>${coupons.reduceAmount}</td>
											<td>${coupons.number}</td>
											<td>${coupons.typeOne.typeOneName}</td>
											<td>
												<div class="am-btn-toolbar">
													<div class="am-btn-group am-btn-group-xs">
														<button id="deletebut${coupons.couponId}${ListType}" onclick="deleteById2(${coupons.couponId},${ListType})" class="am-btn am-btn-default am-btn-xs am-text-danger am-hide-sm-only"><span class="am-icon-trash-o"></span> 删除</button>
														<a href="  coupon/deleteById/${coupons.couponId},${ListType}"  id="delete${coupons.couponId}${ListType}"></a></div>
												</div>
											</td>
										</tr>
</#list>
									</tbody>
	</#if>
							</table>

						</form>
							<div class="am-cf">
								<div class="am-fr">
									<ul class="am-pagination">

										<li><a href="  coupon/couponList/1"> 利息优惠券</a></li>
										<li><a href="  coupon/couponList/2">价格优惠券</a></li>
										<li><a href="  coupon/couponList/3">类型利息优惠券</a></li>
										<li><a href="  coupon/couponList/4">类型价格优惠券</a></li>


									</ul>
								</div>
							</div>
							<hr />
							<p>注：.....</p>


					</div>
				</div>

				<!-- Row end -->
			</div>
		</div>
	</div>
</div>

<input type="hidden" value="${first!}" id="first">
<input type="hidden" value="${pageCount!}" id="pageCount">
<!-- end right Content here -->
<!--</div>-->
</div>
</div>

<!-- navbar -->
<a href="admin-offcanvas" class="am-icon-btn am-icon-th-list am-show-sm-only admin-menu" data-am-offcanvas="{target: '#admin-offcanvas'}"><!--<i class="fa fa-bars" aria-hidden="true"></i>--></a>

<script type="text/javascript" src=" assets/js/jquery-2.1.0.js" ></script>
<script type="text/javascript" src=" assets/js/amazeui.min.js"></script>
<script type="text/javascript" src=" assets/js/app.js" ></script>
<script type="text/javascript" src=" assets/js/blockUI.js" ></script>
<script>



    document.getElementById("addBut2").onclick=function(){
        window.location = "  coupon/preAdd/"+${ListType};
    }

	function update(cusid){
		document.getElementById("update"+cusid).click();
    }

    function deleteById2(cusid,id){
        document.getElementById("delete"+cusid+id).click();
    }





</script>
</body>

</html>

