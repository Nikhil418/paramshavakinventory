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
	<h3 align="center"> Machine Records</h3>
	<table class="table table-striped table-bordered">
	<thead>
	<tr>
	<th>Manufacture</th>
	<th>Machine Model</th>
	<th>Machine Sr. No.</th>
	<th>Issued on Date</th>
	<th>Issued on Name</th>
	<th>GPU Card</th>
	<th>GPU Card Sr No.</th>
	<th>Mobile No.</th>
	<th>Status</th>
	
	
	
	</tr>
	</thead>
	<tbody>
	<c:forEach var="s" items="${vlist }">
	<tr>
	<td>${s.manufacture }</td>
	<td>${s.machinemodel }</td>
	<td>${s.serialno }</td>
	<td>${s.issued_on_date }</td>
	<td>${s.issued_on_name }</td>
	<td>${s.gpu_card }</td>
	<td>${s.gpu_card_serial_number }</td>
	<td>${s.mobile }</td>
	<td>${s.status }</td>
	
	</tr>
	</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>