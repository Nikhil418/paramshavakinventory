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
	<c:if test="${record.mid == 0}">
		<h3 align="center">Add Machine Details</h3>
	</c:if>
	<c:if test="${record.mid != 0}">
		<h3 align="center">Update Machine Details</h3>
	</c:if>
	<div class="row mt-5">
	        <div class="col-3"></div>
	        <div class="col-6">
		        <form action="/machine/add/${record.mid}" method="POST">
					<div class="mb-3">
					  <label for="manufacturer" class="form-label">Manufacturer</label>
					  <input type="text" name="manufacturer" value="${record.manufacturer}" class="form-control" placeholder="Enter Manufacturer">
					</div>
					<div class="mb-3">
					  <label for="machineModel" class="form-label">Machine Model</label>
					  <input type="text" name="machineModel" value="${record.machineModel}" class="form-control" placeholder="Enter machine model">
					</div>
					<div class="mb-3">
					  <label for="serialNo" class="form-label">Serial No.</label>
					  <input type="text" name="serialNo" value="${record.serialNo}" class="form-control" placeholder="Enter machine serial number">
					</div>
					<div class="mb-3">
					  <label for="issuedOnDate" class="form-label">Issued On Date</label>
					  <input type="date" name="issuedOnDate" value="${record.issuedOnDate}" class="form-control" placeholder="Enter issued date">
					</div>
					<div class="mb-3">
					  <label for="issuedOnName" class="form-label">Issuded On Name</label>
					  <input type="text" name="issuedOnName" value="${record.issuedOnName}" class="form-control" placeholder="Enter issued name">
					</div>
					<div class="mb-3">
					  <label for="gpuCard" class="form-label">GPU Card &nbsp&nbsp&nbsp&nbsp</label>
					  <input type="radio" name="command" value="0" onclick="test(1)"/>Yes
					  <input type="radio" name="command" value="1" onclick="test(0)"/>No
					  <input type="text" name="gpuCard" value="${record.gpuCard}" class="form-control" placeholder="Enter the GPU card">
					</div>
					<div class="mb-3">
					  <label for="gpuCardSerialNumber" class="form-label" id="123" >GPU Card Sr.No</label>
					  <input type="text" name="gpuCardSerialNumber" value="${record.gpuCardSerialNumber}" class="form-control" placeholder="Enter the GPU card serialNumber">
					</div>
					<div class="mb-3">
					  <label for="mobile" class="form-label">Mobile No</label>
					  <input type="number" name="mobile" value="${record.mobile}" class="form-control" placeholder="Enter the mobile number">
					</div>
					<div class="mb-3">
					  <label for="vendorName" class="form-label">Vendor Name</label>
					  <input type="text" name="vendorName" value="${record.vendorName}" class="form-control" placeholder="Vendor Name">
					</div>
					<c:if test="${record.mid != 0}">
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
					
					<c:if test="${record.mid == 0}">
						<input class="btn btn-success" type="submit" value="Add Machine">
					</c:if>
					<c:if test="${record.mid != 0}">
						<input class="btn btn-success" type="submit" value="Update Machine">
					</c:if>
					
					<c:if test="${record.mid == 0}">
						<a href="/addnew"><button class="btn btn-danger" type="button">Cancel</button></a>
					</c:if>
					<c:if test="${record.mid != 0}">
						<a href="/machine/view"><button class="btn btn-danger" type="button">Cancel</button></a>
					</c:if>
				</form>
	        </div>
	        <div class="col-3"></div>
	</div>
</body>
<script type="text/javascript">
	function test(state){
		if(state == 0){
			document.getElementsByName("command")[1].checked = true
			document.getElementsByName("gpuCard")[0].style.display = "none";
			document.getElementsByName("gpuCardSerialNumber")[0].style.display = "none";
			
			document.getElementsByName("gpuCard")[0].value = "";
			document.getElementsByName("gpuCardSerialNumber")[0].value = "";
			
			document.getElementById("123").style.display = "none";
		}else{
			document.getElementsByName("command")[0].checked = true
			document.getElementsByName("gpuCard")[0].style.display = "block";
			document.getElementsByName("gpuCardSerialNumber")[0].style.display = "block";
			
			document.getElementsByName("gpuCard")[0].value = "${record.gpuCard}";
			document.getElementsByName("gpuCardSerialNumber")[0].value = "${record.gpuCardSerialNumber}";
			
			document.getElementById("123").style.display = "block";
		}
	}
	console.log("${record.gpuCard}")
	if("${record.gpuCard}" != ""){
		test(1)
	}else{
		test(0)
	}
</script>
</html>