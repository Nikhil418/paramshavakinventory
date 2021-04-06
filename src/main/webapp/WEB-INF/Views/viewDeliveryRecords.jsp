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
<div class="m-3">
	<h3 align="center"> Delivery Records</h3>
	<table class="table table-striped table-bordered">
	<thead>
	<tr>
	<th>Param Shavak Varient</th>
	<th>Manufacture</th>
	<th>Machine Model</th>
	<th>Machine Sr. No.</th>
	<th>Dispatch Date</th>
	<th>Sys. Installed By</th>
	<th>Paramshavak Version</th>
	<th>Parallel Studio Licence No</th>
	<th>GPU Card</th>
	<th>GPU Card Sr No.</th>
	<th>Institute Name</th>
	<th>Institude Address</th>
	<th>Contact Person Name</th>
	<th>Mobile No.</th>
	<th>Email Id</th>
	<th>Action</th>
	
	
	</tr>
	</thead>
	<tbody>
	<c:forEach var="s" items="${vlist }">
	<tr>
	<td>${s.paramshavakvarient }</td>
	<td>${s.manufacture }</td>
	<td>${s.machinemodel }</td>
	<td>${s.serialno }</td>
	<td>${s.disptachdate }</td>
	<td>${s.systeminstalledby }</td>
	<td>${s.paramshavakversion }</td>
	<td>${s.studiolicense }</td>
	<td>${s.gpucard }</td>
	<td>${s.gpucardsrno }</td>
	<td>${s.institutename }</td>
	<td>${s.institutaddress }</td>
	<td>${s.contactpersonname }</td>
	<td>${s.mobileno }</td>
	<td>${s.emailid }</td>
	<td>
		<a href="updatedetails/${s.did}" class="btn btn-warning ml-4 float-right">Update</a>
		<a href="deletedetails/${s.did}" class="btn btn-danger ml-4 float-right">Delete</a>
	</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>