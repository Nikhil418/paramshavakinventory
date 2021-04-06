<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="ISO-8859-1">
	<title>Insert title here</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-eOJMYsd53ii+scO/bJGFsiCZc+5NDVN2yr8+0RDqr0Ql0h+rP48ckxlpbzKgwra6" crossorigin="anonymous">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>

</head>
<body>
<div class="container">
	<h3 align="center">Update Delivery Details</h3>
	<div class="row mt-5">
	        <div class="col-3"></div>
	        <div class="col-6">
		        <form action="/updatedeliverydetails/${record.did}">
		        	<div class="mb-3">
					  <label for="paramshavakvarient" class="form-label">Param Shavak Varient</label>
					  <select class="form-select" name="paramshavakvarient" id="paramshavakvarient">
						<option value="${record.paramshavakvarient}">${record.paramshavakvarient}</option>
					  </select>
					</div>
					<div class="mb-3">
					  <label for="manufacture" class="form-label">Manufacture</label>
					  <select class="form-select" name="manufacture" id="manufacture">
						<option value="${record.manufacture}">${record.manufacture}</option>
					  </select>
					</div>
					<div class="mb-3">
					  <label for="machine_model" class="form-label">Machine Model</label>
					  <select class="form-select"  name="machinemodel" id="machinemodel" required>
					  	<option value="${record.machinemodel}">${record.machinemodel}</option>
					  </select>
					</div>
					<div class="mb-3">
					  <label for="serialno" class="form-label">Serial No.</label>
					  <select class="form-select" name="serialno" id="serialno" required>
					  	<option value="${record.serialno}">${record.serialno}</option>
					  </select>
					</div>
					<div class="mb-3">
					  <label for="dispatch_date" class="form-label">Dispatch Date</label>
					  <input class="form-control" type="date" name="dispatch_date" value="${record.disptachdate }" placeholder="Enter dispatch date">
					</div>
					<div class="mb-3">
					  <label for="installed_by" class="form-label">Sys Installed By</label>
					  <input class="form-control" type="text" name="installed_by" value="${record.systeminstalledby }" placeholder="Enter installed by">
					</div>
					<div class="mb-3">
					  <label for="param_shavak_version" class="form-label">Param Shavak Version</label>
					  <input class="form-control" type="text" name="param_shavak_version" value="${record.paramshavakversion }" placeholder="Enter param_shavak_version">
					</div>
					<div class="mb-3">
					  <label for="gpucard" class="form-label">GPU Card</label>
					  <select class="form-select"  name="gpucard" id="gpucard" required>
					  	<option value="${record.gpucard}">${record.gpucard}</option>
					  </select>
					</div>
					<div class="mb-3">
					  <label for="gpucardsrno" class="form-label">GPU Card Serial No.</label>
					  <select class="form-select"  name="gpucardsrno" id="gpucardsrno" required>
					  	<option value="${record.gpucardsrno}">${record.gpucardsrno}</option>
					  </select>
					</div>
					
					<div class="mb-3">
					  <label for="studio_license_no" class="form-label">Parallel_Studio_LicenseNo</label>
					  <input class="form-control" type="text" name="studio_license_no" value="${record.studiolicense }" placeholder="Enter Studio License no">
					</div>
					
					<div class="mb-3">
					  <label for="institute_name" class="form-label">Institute Name</label>
					  <input class="form-control" type="text" name="institute_name" value="${record.institutename }" placeholder="Enter institute name">
					</div>
					<div class="mb-3">
					  <label for="institute_address" class="form-label">Institute Area</label>
					  <input class="form-control" type="text" name="institute_address" value="${record.institutaddress }" placeholder="Enter institute address">
					</div>
					<div class="mb-3">
					  <label for="contact_person_name" class="form-label">Contact Person Name</label>
					  <input class="form-control" type="text" name="contact_person_name" value="${record.contactpersonname }"  placeholder="Enter Contact person name">
					</div>
					<div class="mb-3">
					  <label for="mobno" class="form-label">Mobile No</label>
					  <input class="form-control" type="number" name="mobno" value="${record.mobileno }"  placeholder="Enter Mobile no">
					</div>
					<div class="mb-3">
					  <label for="emailid" class="form-label">Email Id</label>
					  <input class="form-control" type="email" name="emailid" value="${record.emailid }" placeholder="Enter Email Id">
					</div>
					<input class="btn btn-success" type="submit" value="Update">
				</form>
	        </div>
	        <div class="col-3"></div>
	</div>
</div>
</body>
</html>