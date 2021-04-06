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
	<script type="text/javascript">
		$(document).ready(function(){
		
			$('#manufacture').on('click', function(){
				var mfg = $(this).val();
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath }/loadmodelbymanufacture/' + mfg,
					success: function(result) {
						var result = JSON.parse(result);
						var s = '';
						<!-- s += '<option value="' + 0 + '">' + "Select Machine Model" + '</option>'; -->
						for(var i = 0; i < result.length; i++) {
							s += '<option value="' + result[i] + '">' + result[i] + '</option>';
						}
						$('#machinemodel').html(s);
					}
				});
			});
			
			$('#machinemodel').on('click', function(){
				var machmodel = $(this).val();
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath }/loadserialnobymodel/' + machmodel,
					success: function(result) {
						var result = JSON.parse(result);
						var s = '';
						<!-- s += '<option value="' + 0 + '">' + "Select Serial No" + '</option>'; -->
						for(var i = 0; i < result.length; i++) {
							s += '<option value="' + result[i] + '">' + result[i] + '</option>';
						}
						$('#serialno').html(s);
					}
				});
			});
			
			$('#gpucard').on('click', function(){
		console.log("asfdsd");
				var gpucard = $(this).val();
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath }/loadgpuserialnobycard/' + gpucard,
					success: function(result) {
						var result = JSON.parse(result);
						var s = '';
						s += '<option value="' + 0 + '">' + "Select GPU Serial No" + '</option>';
						for(var i = 0; i < result.length; i++) {
							s += '<option value="' + result[i] + '">' + result[i] + '</option>';
						}
						$('#gpucardsrno').html(s);
					}
				});
			});
		
		$('#serialno').on('click', function(){
				var srno = $(this).val();
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath }/loadinbuiltgpucard/' + srno,
					success: function(result) {
						var result = JSON.parse(result);
						$('#inbuiltgpucard').val(result);
					}
				});
			});
			
		$.ajax({
			type: 'GET',
			url: '${pageContext.request.contextPath }/loadgpucard/',
			success: function(result) {
				var result = JSON.parse(result);
				var s = '';
				s += '<option value="' + 0 + '">' + "Select GPU Card" + '</option>';
				for(var i = 0; i < result.length; i++) {
					s += '<option value="' + result[i] + '">' + result[i] + '</option>';
				}
				$('#gpucard').html(s);
			}
		});
		
		});
		
		
		
	</script>

</head>
<body>

<div class="container">
	<h3 align="center">Add Delivery Details</h3>
	<div class="row mt-5">
	        <div class="col-3"></div>
	        <div class="col-6">
		        <form action="/adddeliverydetails">
		        	<div class="mb-3">
					  <label for="paramshavakvarient" class="form-label">Param Shavak Varient</label>
					  <select class="form-select" name="paramshavakvarient" id="paramshavakvarient"  required>
						 	<option value="hpc">hpc</option>
						 	<option value="vr">vr</option>
						 	<option value="dl">dl</option>
					  </select>
					</div>
					<div class="mb-3">
					  <label for="manufacture" class="form-label">manufacture</label>
					  <select class="form-select" name="manufacture" id="manufacture"  required>
						<c:forEach var="manufacture" items="${mlist}">
						 	<option value="${manufacture}">${manufacture}</option>
						 </c:forEach>
					  </select>
					</div>
					<div class="mb-3">
					  <label for="machine_model" class="form-label">Machine Model</label>
					  <select class="form-select"  name="machinemodel" id="machinemodel" required></select>
					</div>
					<div class="mb-3">
					  <label for="serialno" class="form-label">Serial No.</label>
					  <select class="form-select" name="serialno" id="serialno" required></select>
					</div>
					<div class="mb-3">
					  <label for="dispatch_date" class="form-label">Dispatch Date</label>
					  <input class="form-control" type="date" name="dispatch_date" placeholder="Enter dispatch date">
					</div>
					<div class="mb-3">
					  <label for="installed_by" class="form-label">System Installed By</label>
					  <input class="form-control" type="text" name="installed_by" placeholder="Enter installed by">
					</div>
					<div class="mb-3">
					  <label for="param_shavak_version" class="form-label">Param Shavak Version</label>
					  <input class="form-control" type="text" name="param_shavak_version" placeholder="Enter param_shavak_version">
					</div>
					<div class="mb-3">
					  <label for="inbuiltgpucard" class="form-label">In-Built GPU Card</label>
					  <input class="form-control" type="text" id="inbuiltgpucard" name = "inbuiltgpucard" readonly>
					</div>
					<div class="mb-3">
					  <label for="gpucard" class="form-label">GPU Card</label>
					  <select class="form-select"  name="gpucard" id="gpucard" required></select>
					</div>
					<div class="mb-3">
					  <label for="gpucardsrno" class="form-label">GPU Card Serial No.</label>
					  <select class="form-select"  name="gpucardsrno" id="gpucardsrno" required></select>
					</div>
					
					<div class="mb-3">
					  <label for="studio_license_no" class="form-label">Parallel_Studio_LicenseNo</label>
					  <input class="form-control" type="text" name="studio_license_no" placeholder="Enter Studio License no">
					</div>
					
					<div class="mb-3">
					  <label for="institute_name" class="form-label">Institute Name</label>
					  <input class="form-control" type="text" name="institute_name" placeholder="Enter institute name">
					</div>
					<div class="mb-3">
					  <label for="institute_address" class="form-label">Institute Area</label>
					  <input class="form-control" type="text" name="institute_address" placeholder="Enter institute address">
					</div>
					<div class="mb-3">
					  <label for="contact_person_name" class="form-label">Contact Person Name</label>
					  <input class="form-control" type="text" name="contact_person_name" placeholder="Enter Contact person name">
					</div>
					<div class="mb-3">
					  <label for="mobno" class="form-label">Mobile No</label>
					  <input class="form-control" type="number" name="mobno" placeholder="Enter Mobile no">
					</div>
					<div class="mb-3">
					  <label for="emailid" class="form-label">Email Id</label>
					  <input class="form-control" type="email" name="emailid" placeholder="Enter Email Id">
					</div>
					<div class="mb-3">
					  <label for="comment" class="form-label">Comment</label>
					  <textarea class="form-control" name="comment" class="form-control" id="comment" rows="3"></textarea>
					</div>
					<input class="btn btn-success" type="submit" value="Deliver">
				</form>
	        </div>
	        <div class="col-3"></div>
	</div>
</body>
</html>