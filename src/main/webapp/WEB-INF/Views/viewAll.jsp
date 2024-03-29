<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Page</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
</head>
<body align="center">
<h3>View Records</h3>
	<jsp:include page="header.jsp"/>
	<div class="m-4">
		<a href="/machine/view" type="button" class="btn btn-dark">View Machine Details</a>
		<a href="/gpu/view" type="button" class="btn btn-dark">View GPU details</a>
		<a href="/monitor/view" type="button" class="btn btn-dark">View Monitor Details</a>
		<a href="/delivery/view" type="button" class="btn btn-dark">View Delivery details</a>
	</div>
</body>
</html>