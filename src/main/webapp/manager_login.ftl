
<html>
<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <base id="base" href="/fqg/"/>
		<title></title>
		<link rel="stylesheet" href="assets/css/core.css" />
		<link rel="stylesheet" href="assets/css/menu.css" />
		<link rel="stylesheet" href="assets/css/amazeui.css" />
		<link rel="stylesheet" href="assets/css/component.css" />
		<link rel="stylesheet" href="assets/css/page/form.css" />
	</head>
	<body>
		<div class="account-pages">
			<div class="wrapper-page">
				<div class="text-center">
	                <a href="" class="logo"><span>Admin<span>to</span></span></a>
	            </div>
	            
	            <div class="m-t-40 card-box">
	            	<div class="text-center">
	                    <h4 class="text-uppercase font-bold m-b-0">Sign In</h4>
	                </div>

	                <div class="panel-body">
	                	<form class="am-form" action="/fqg/managerUser/amdinLogin" method="post">
	                		<div class="am-g">
	                			<div class="am-form-group">
							      <input type="text" class="am-radius"  name="username" placeholder="Username">
							    </div>
							
							    <div class="am-form-group form-horizontal m-t-20">
							      <input type="password" class="am-radius"  name="password" placeholder="Password">
							    </div>
							    


		                        
		                        <div class="am-form-group ">
		                        	<button type="submit" class="am-btn am-btn-primary am-radius" style="width: 100%;height: 5%;">Log In</button>

							    <div class="am-form-group ">
		                        </div>
	                		</div>
	                	</form>
	                </div>
	            </div>
			</div>
		</div>
	<input type="hidden" id="jsonCode" value="${jsonResult.code!}">
    <input type="hidden" id="jsonMsg" value="${jsonResult.msg!}">
	</body>
</html>

<script type="text/javascript" src="assets/js/jquery-2.1.0.js" ></script>
<script>
	$(function(){
	    var code = $("#jsonCode").val();
        var msg = $("#jsonMsg").val();
		if(code=="1"){
            alert(msg)
		}

//
    });
</script>

