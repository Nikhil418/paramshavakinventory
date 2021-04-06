<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
<link rel="stylesheet" href="/css/design.css">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
<script type="text/javascript">
		$(document).ready(function(){
			console.log("Count Displayed");
			$.ajax({
				type: 'GET',
				url: '${pageContext.request.contextPath }/deliverycount/',
				success: function(result) {
					var result = JSON.parse(result);
					var s = '';
					for(var i = 0; i < result.length; i++) {
						s += '<tr><td>'+result[i].paramshavakversion+'</td><td>'+result[i].count+'</td></tr>';
					}
					$('#devcount').html(s);
				}
			});
		});
</script>


</head>
<body>

<div class="container">
	<h3 align="center">Param Shavak Inventory System</h3>
	
	<div class="row mt-4">
        <div class="col-4"></div>
        <div class="col-4">
        	<div class="card">
			  <img src="/images/paramshavak.jpg" class="card-img-top" alt="...">
			  <div class="card-body">
			    <form action="/authenticate"align="center" method="post">
			  		<input type="text" name="uname" class="form-control" placeholder="Username">
			  		<input type="password" name="password" class="form-control" placeholder="Password">
					<h5 class="msg">${message }</h5>
			    	<input type="submit" class="btn btn-primary" value="Login"/>
			    </form>
			  </div>
			</div>
		</div>
	<div class="col-4"></div>
	</div>
	
	<div class="row mt-5">
        <div class="col-4"> </div>
        <div class="col-4">
        	<table class="table table-success table-bordered">
				<thead>
					<tr>
						<th>Paramshavak Version</th>
						<th>Machine Delivered</th>
					</tr>
				</thead>
				<tbody id="devcount">
				</tbody>
			</table>
		</div>
	<div class="col-4"></div>
</div>


</body>
</html>