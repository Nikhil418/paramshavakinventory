<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>

<div class="container">
	<c:if test="${record.gpuid == 0}">
		<h3 align="center">Add GPU Details</h3>
	</c:if>
	<c:if test="${record.gpuid != 0}">
		<h3 align="center">Update GPU Details</h3>
	</c:if>
	<div class="row mt-5">
	        <div class="col-3"></div>
	        <div class="col-6">
		        <form action="/gpu/add/${record.gpuid}" method="POST">
					<div class="mb-3">
					  <label for="gpucard" class="form-label">GPU Card</label>
					  <input type="text" name="gpuCard" value="${record.gpuCard}" class="form-control" placeholder="Enter the gpucard" >
					</div>
					<div class="mb-3">
					  <label for="gpucard_serial_number" class="form-label">GPU Card Serial Number</label>
					  <input type="text" name="gpuCardSerialNumber" value="${record.gpuCardSerialNumber}" class="form-control" placeholder="Enter the gpucard serial number" >
					</div>
					<div class="mb-3">
					  <label for="machine_type" class="form-label">Issued On Date</label>
					  <input type="date" name="issuedOnDate" value="${record.issuedOnDate}" class="form-control" placeholder="Enter the issued date" >
					</div>
					<div class="mb-3">
					  <label for="machine_type" class="form-label">Issued On Name</label>
					  <input type="text" name="issuedOnName" value="${record.issuedOnName}" class="form-control" placeholder="Enter issued name">
					</div>
					<div class="mb-3">
					  <label for="machine_type" class="form-label">Mobile</label>
					  <input type="number" name="mobile" value="${record.mobile}" class="form-control" placeholder="Enter the mobile number">
					</div>
					
					<c:if test="${record.gpuid != 0}">
						<div class="mb-3">
						  <label for="status" class="form-label">Status</label>
						  <select class="form-select" name="status" id="status" required>
						    <option value="${record.status}" selected="selected"> ${record.status} </option>
						    <c:if test="${record.status == 'Available'}">
						    	<option value="Dispatch">Dispatch</option>
						    </c:if>
						    <c:if test="${record.status == 'Dispatch'}">
						    	<option value="Available">Available</option>
						    </c:if>
						  </select>
						</div>
					</c:if>
					
					<div class="mb-3">
					  <label for="comment" class="form-label">Comment</label>
					  <textarea name="comment" value="${record.comment}" class="form-control" class="form-control" id="comment" rows="3"></textarea>
					</div>
					<c:if test="${record.gpuid == 0}">
						<input class="btn btn-success" type="submit" value="Add GPU">
					</c:if>
					<c:if test="${record.gpuid != 0}">
						<input class="btn btn-success" type="submit" value="Update GPU">
					</c:if>
					<c:if test="${record.gpuid == 0}">
						<a href="/addnew"><button class="btn btn-danger" type="button">Cancel</button></a>
					</c:if>
					<c:if test="${record.gpuid != 0}">
						<a href="/gpu/view"><button class="btn btn-danger" type="button">Cancel</button></a>
					</c:if>
					
				</form>
	        </div>
	        <div class="col-3"></div>
	</div>
</div>
</body>
</html>