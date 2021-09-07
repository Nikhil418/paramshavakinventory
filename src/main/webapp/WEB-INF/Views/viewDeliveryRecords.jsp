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
	<h3 align="center"> Delivery Records</h3>
	<table class="table table-striped table-bordered">
	<thead>
	<tr>
	<th>Param Shavak Variant</th>
	<th>Machine Manufacturer</th>
	<th>Machine Model</th>
	<th>Machine Sr. No.</th>
	<th>Monitor Manufacturer</th>
	<th>Monitor Model</th>
	<th>Monitor Sr. No.</th>
	<th>Dispatch Date</th>
	<th>System Installed By</th>
	<th>Param Shavak Version</th>
	<th>Parallel Studio Licence No</th>
	<th>GPU Card</th>
	<th>GPU Card Sr No.</th>
	<th>Institute Name</th>
	<th>Institute Address</th>
	<th>Contact Person Name</th>
	<th>Mobile No.</th>
	<th>Email Id</th>
	<th>Status</th>
	<th>Action</th>
	
	
	</tr>
	</thead>
	<tbody>
	<c:forEach var="s" items="${vlist }">
	<tr>
	<td>${s.paramShavakVariant }</td>
	<td>${s.machineManufacturer }</td>
	<td>${s.machineModel }</td>
	<td>${s.machineSerialNo }</td>
	<td>${s.monitorManufacturer }</td>
	<td>${s.monitorModel }</td>
	<td>${s.monitorSerialNo }</td>
	<td>${s.disptachDate }</td>
	<td>${s.systemInstalledBy }</td>
	<td>${s.paramShavakVersion }</td>
	<td>${s.studioLicense }</td>
	<td>${s.gpuCard }</td>
	<td>${s.gpuCardSerialNo }</td>
	<td>${s.instituteName }</td>
	<td>${s.institutAddress }</td>
	<td>${s.contactPersonName }</td>
	<td>${s.mobile }</td>
	<td>${s.emailId }</td>
	<td>${s.status }</td>
	<td>
		<a href="update/${s.did}" class="btn btn-warning ml-4 float-right">Update</a>
		<a href="delete/${s.did}" class="btn btn-danger ml-4 float-right">Delete</a>
	</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</div>
</body>
</html>