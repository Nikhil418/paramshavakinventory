<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<title>Insert title here</title>
<link rel="stylesheet" href="/css/design.css">
</head>
<body align="center">
 	<jsp:include page="header.jsp"/>
	<div class="m-4">
		<a href="/machine/add" type="button" class="btn btn-dark">Add Machine</a>
		<a href="/gpu/add" type="button" class="btn btn-warning">Add GPUCard</a>
		<a href="/monitor/add" type="button" class="btn btn-dark">Add Monitor</a>
		<a href="/delivery/add" type="button" class="btn btn-info">Add Delivery details</a>
	</div>
</body>
</html>