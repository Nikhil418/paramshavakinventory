<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
<jsp:include page="header.jsp"/>
<div class="m-3">
	<h3 align="center"> GPUCard Records</h3>
	<table class="table table-striped table-bordered">
	<thead>
	<tr>
	<th>GPU Card</th>
	<th>GPU Card Sr No.</th>
	<th>Issued on Date</th>
	<th>Issued on Name</th>
	<th>Mobile No.</th>
	<th>status</th>
	<th>Action</th>
	
	</tr>
	</thead>
	<tbody>
	<c:forEach var="s" items="${vlist }">
	<tr>
	<td>${s.gpuCard }</td>
	<td>${s.gpuCardSerialNumber }</td>
	<td>${s.issuedOnDate }</td>
	<td>${s.issuedOnName }</td>
	<td>${s.mobile }</td>
	<td>${s.status }</td>
	<td>
		<a href="update/${s.gpuid}" class="btn btn-warning ml-4 float-right">Update</a>
		<a href="delete/${s.gpuid}" class="btn btn-danger ml-4 float-right">Delete</a>
	</td>
	
	</tr>
	</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>