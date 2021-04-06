<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
	<h3 align="center">Add Machine Details</h3>
	<div class="row mt-5">
	        <div class="col-3"></div>
	        <div class="col-6">
		        <form action="/insertmachine">
					<div class="mb-3">
					  <label for="machine_type" class="form-label">Manufacture</label>
					  <input type="text" name="manufacture" class="form-control" placeholder="Enter Manufacture">
					</div>
					<div class="mb-3">
					  <label for="machine_type" class="form-label">Machine Model</label>
					  <input type="text" name="machine_model" class="form-control" placeholder="Enter machine model">
					</div>
					<div class="mb-3">
					  <label for="machine_type" class="form-label">Serial No.</label>
					  <input type="text" name="serial_number" class="form-control" placeholder="Enter machine serial number">
					</div>
					<div class="mb-3">
					  <label for="machine_type" class="form-label">Issued On Date</label>
					  <input type="date" name="issued_on_date" class="form-control" placeholder="Enter issued date">
					</div>
					<div class="mb-3">
					  <label for="machine_type" class="form-label">Issuded On Name</label>
					  <input type="text" name="issued_on_name" class="form-control" placeholder="Enter issued name">
					</div>
					<div class="mb-3">
					  <label for="machine_type" class="form-label">GPU Card</label>
					  <input type="text" name="GPU_card" class="form-control" placeholder="Enter the GPU card">
					</div>
					<div class="mb-3">
					  <label for="machine_type" class="form-label">GPU Card Sr.No</label>
					  <input type="text" name="GPU_card_serialNumber" class="form-control" placeholder="Enter the GPU card serialNumber">
					</div>
					<div class="mb-3">
					  <label for="machine_type" class="form-label">Mobile No</label>
					  <input type="number" name="mobile" class="form-control" placeholder="Enter the mobile number">
					</div>
					<div class="mb-3">
					  <label for="comment" class="form-label">Comment</label>
					  <textarea name="comment" class="form-control" id="comment" rows="3"></textarea>
					</div>
					<div class="mb-3">
					<input type="hidden" name="status" value="Available" readonly>
					</div>
					<input class="btn btn-success" type="submit" value="Add Machine">
				</form>
	        </div>
	        <div class="col-3"></div>
	</div>
</body>
</html>