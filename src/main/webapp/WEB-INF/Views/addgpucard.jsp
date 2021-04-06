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
	<h3 align="center">Add GPU Details</h3>
	<div class="row mt-5">
	        <div class="col-3"></div>
	        <div class="col-6">
		        <form action="/insertgpucard">
					<div class="mb-3">
					  <label for="gpucard" class="form-label">GPU Card</label>
					  <input type="text" name="gpucard" class="form-control" placeholder="Enter the gpucard" >
					</div>
					<div class="mb-3">
					  <label for="gpucard_serial_number" class="form-label">GPU Card Serial Number</label>
					  <input type="text" name="gpucard_serial_number" class="form-control" placeholder="Enter the gpucard serial number" >
					</div>
					<div class="mb-3">
					  <label for="machine_type" class="form-label">Issued On Date</label>
					  <input type="date" name="issued_on_date" class="form-control" placeholder="Enter the issued date" >
					</div>
					<div class="mb-3">
					  <label for="machine_type" class="form-label">Issuded On Name</label>
					  <input type="text" name="issued_on_name" class="form-control" placeholder="Enter issued name">
					</div>
					<div class="mb-3">
					  <label for="machine_type" class="form-label">Mobile</label>
					  <input type="number" name="mobile" class="form-control" placeholder="Enter the mobile number">
					</div>
					<div class="mb-3">
					  <label for="comment" class="form-label">Comment</label>
					  <textarea name="comment" class="form-control" class="form-control" id="comment" rows="3"></textarea>
					</div>
					<input class="btn btn-success" type="submit" value="Add GPU" name="addGPU">
				</form>
	        </div>
	        <div class="col-3"></div>
	</div>
</body>
</html>