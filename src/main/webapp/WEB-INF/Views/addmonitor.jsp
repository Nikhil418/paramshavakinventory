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
	<c:if test="${record.moid == 0}">
		<h3 align="center">Add Monitor Details</h3>
	</c:if>
	<c:if test="${record.moid != 0}">
		<h3 align="center">Update Monitor Details</h3>
	</c:if>
	<div class="row mt-5">
	        <div class="col-3"></div>
	        <div class="col-6">
		        <form action="/monitor/add/${record.moid}" method="POST">
					<div class="mb-3">
					  <label for="manufacturer" class="form-label">Manufacturer</label>
					  <input type="text" name="manufacturer" value="${record.manufacturer}" class="form-control" placeholder="Enter manufacturer">
					</div>
					<div class="mb-3">
					  <label for="monitorModel" class="form-label">Monitor Model</label>
					  <input type="text" name="monitorModel" value="${record.monitorModel}" class="form-control" placeholder="Enter Monitor Model">
					</div>
					<div class="mb-3">
					  <label for="serialNo" class="form-label">Serial No.</label>
					  <input type="text" name="serialNo" value="${record.serialNo}" class="form-control" placeholder="Enter monitor serial number">
					</div>
					<div class="mb-3">
					  <label for="issuedOnDate" class="form-label">Issued On Date</label>
					  <input type="date" name="issuedOnDate" value="${record.issuedOnDate}" class="form-control" placeholder="Enter issued date">
					</div>
					<div class="mb-3">
					  <label for="issuedOnName" class="form-label">Issued On Name</label>
					  <input type="text" name="issuedOnName" value="${record.issuedOnName}" class="form-control" placeholder="Enter issued name">
					</div>
					<div class="mb-3">
					  <label for="mobile" class="form-label">Mobile No</label>
					  <input type="number" name="mobile" value="${record.mobile}" class="form-control" placeholder="Enter the mobile number">
					</div>
					
					<c:if test="${record.moid != 0}">
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
					  <textarea name="comment" value="${record.comment}" class="form-control" id="comment" rows="3"></textarea>
					</div>
					
					<c:if test="${record.moid == 0}">
						<input class="btn btn-success" type="submit" value="Add Monitor">
					</c:if>
					<c:if test="${record.moid != 0}">
						<input class="btn btn-success" type="submit" value="Update Monitor">
					</c:if>
					
					<c:if test="${record.moid == 0}">
						<a href="/addnew"><button class="btn btn-danger" type="button">Cancel</button></a>
					</c:if>
					<c:if test="${record.moid != 0}">
						<a href="/monitor/view"><button class="btn btn-danger" type="button">Cancel</button></a>
					</c:if>
				</form>
	        </div>
	        <div class="col-3"></div>
	</div>
</body>
</html>