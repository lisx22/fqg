
<html>
<head>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>订单管理</title>
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

			</li>
		</ul>
	</div>
</header>
<!-- end page -->


<div class="admin">
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

						</div>
					</div>

					<div class="am-u-sm-12 am-u-md-3">

					</div>
				</div>
				<!-- Row end -->

				<!-- Row start -->
				<div class="am-g">
					<div class="am-u-sm-12">
						<form class="am-form" action=" customer/deletes/" method="post">
							<input type="submit" style="display: none" id="deleteone">

							<table class="am-table am-table-striped am-table-hover table-main">
								<thead>
								<tr>
									<th></th>
									</th><th class="table-id">ID</th>
									<th class="table-title">用户姓名</th>
									<th class="table-type">商品名称</th>
									<th class="table-author am-hide-sm-only">总金额</th>
									<th class="table-date am-hide-sm-only">购买数量</th>
									<th class="table-date am-hide-sm-only">订单编号</th>
									<th class="table-date am-hide-sm-only">期数</th>
									<th class="table-date am-hide-sm-only">每期应还金额</th>
                                    <th class="table-date am-hide-sm-only">订单状态</th>
								</tr>
								</thead>
								<tbody>
<#list orderslist! as orders>
									<tr>
										<td></td>
										<td>${orders.orderId!}</td>
										<td>${orders.customer.username!}</td>
										<td>${orders.commodity.commodityName!}</td>
										<td>${orders.payMoney!?c}</td>
										<td class="am-hide-sm-only">${orders.number!?c}</td>
										<td class="am-hide-sm-only">${orders.orderNum!?c}</td>
										<td class="am-hide-sm-only">${orders.stage!}</td>
										<td class="am-hide-sm-only">${orders.amount!}</td>
										<#if orders.orderState==1>
                                            <td class="am-hide-sm-only">未发货</td>
										</#if>
										<#if orders.orderState==2>
                                            <td class="am-hide-sm-only">已发货</td>
										</#if>
										<#if orders.orderState==3>
                                            <td class="am-hide-sm-only">还款中</td>
										</#if>

									</tr>
</#list>
								</tbody>
							</table>
						</form>
							<div class="am-cf">
								共 ${pageSize!} 条记录
								<div class="am-fr">
									<ul class="am-pagination">
										<li><a href="javascript:upPage()">«上一页</a></li>
										<li><a href="javascript:downPage()">»下一页</a></li>

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
<script type="text/javascript" src="https://cdn.goeasy.io/goeasy.js"></script>
<script type="text/javascript">
    var goEasy = new GoEasy({
        appkey: "BC-55d4d6fb978c46468b41e34193467a75"
    });
    goEasy.subscribe({
        channel: "my_channel",
        onMessage: function (message) {
            alert("Channel:" + message.channel + " content:" + message.content);
        }
    });




</script>
<script>
    document.getElementById("addBut").onclick=function(){
        document.getElementById("add").click();
    }
	function update(cusid){
		document.getElementById("update"+cusid).click();
    }
    function deleteCustomers(){
        document.getElementById("deleteone").click();
	}
    function deleteById(cusid){
        document.getElementById("delete"+cusid).click();
    }

    function upPage(){
        var first = $("#first").val();
        if(first=="0"){
            alert("我已经翻不动了")
		}else{
            var add = parseInt(first)-1;
            window.location = " orders/ordersList/"+add;
            $("#first").val(add);
		}

	}

	function downPage() {
        var first = $("#first").val();
        var pageCount = $("#pageCount").val();
        if(parseInt(first)>=parseInt(pageCount)-1){
            alert("我已经翻不动了")
		}else{
            var jian = parseInt(first)+1;
            window.location = " orders/ordersList/"+jian;
            $("#first").val(jian);
		}

    }

</script>
</body>

</html>

