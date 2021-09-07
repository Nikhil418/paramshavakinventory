<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body align="center">
	<h3>Welcome to PARAM Shavak Inventory</h3>
	<jsp:include page="header.jsp"/>
	<div class="m-3">
		<a href="/addnew" class="btn btn-warning" type="button" name="add">Add New</a>
		<a href="/viewAll" class="btn btn-success" type="button" name="viewall">View Records</a>
	</div>
</body>
</html> 