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
		
			$('#paramShavakVariant').on('click', function(){
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath }/delivery/loadmachinemanufacture',
					success: function(result) {
						var result = JSON.parse(result);
						var s = '';
						for(var i = 0; i < result.length; i++) {
							s += '<option value="' + result[i] + '">' + result[i] + '</option>';
						}
						$('#machineManufacturer').html(s);
					}
				});
				
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath }/delivery/loadmonitormanufacture',
					success: function(result) {
						var result = JSON.parse(result);
						var s = '';
						for(var i = 0; i < result.length; i++) {
							s += '<option value="' + result[i] + '">' + result[i] + '</option>';
						}
						$('#monitorManufacturer').html(s);
					}
				});
			});
			
			$('#machineManufacturer').on('click', function(){
				var mfg = $(this).val();
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath }/delivery/loadmachinemodelbymanufacture/' + mfg,
					success: function(result) {
						var result = JSON.parse(result);
						var s = '';
						<!-- s += '<option value="' + 0 + '">' + "Select Machine Model" + '</option>'; -->
						for(var i = 0; i < result.length; i++) {
							s += '<option value="' + result[i] + '">' + result[i] + '</option>';
						}
						$('#machineModel').html(s);
					}
				});
			});
			
			$('#machineModel').on('click', function(){
				var machmodel = $(this).val();
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath }/delivery/loadmachineserialnobymodel/' + machmodel,
					success: function(result) {
						var result = JSON.parse(result);
						var s = '';
						for(var i = 0; i < result.length; i++) {
							s += '<option value="' + result[i] + '">' + result[i] + '</option>';
						}
						$('#machineSerialNo').html(s);
					}
				});
			});
			
			$('#monitorManufacturer').on('click', function(){
				var mfg = $(this).val();
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath }/delivery/loadmonitormodelbymanufacture/' + mfg,
					success: function(result) {
						var result = JSON.parse(result);
						var s = '';
						for(var i = 0; i < result.length; i++) {
							s += '<option value="' + result[i] + '">' + result[i] + '</option>';
						}
						$('#monitorModel').html(s);
					}
				});
			});
			
			$('#monitorModel').on('click', function(){
				var machmodel = $(this).val();
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath }/delivery/loadmonitorserialnobymodel/' + machmodel,
					success: function(result) {
						var result = JSON.parse(result);
						var s = '';
						for(var i = 0; i < result.length; i++) {
							s += '<option value="' + result[i] + '">' + result[i] + '</option>';
						}
						$('#monitorSerialNo').html(s);
					}
				});
			});
			
			$('#gpuCard').on('click', function(){
		console.log("asfdsd");
				var gpucard = $(this).val();
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath }/delivery/loadgpuserialnobycard/' + gpucard,
					success: function(result) {
						var result = JSON.parse(result);
						var s = '';
						s += '<option value="' + 0 + '">' + "Select GPU Serial No" + '</option>';
						for(var i = 0; i < result.length; i++) {
							s += '<option value="' + result[i] + '">' + result[i] + '</option>';
						}
						$('#gpuCardSerialNo').html(s);
					}
				});
			});
		
		$('#machineSerialNo').on('click', function(){
				var srno = $(this).val();
				$.ajax({
					type: 'GET',
					url: '${pageContext.request.contextPath }/delivery/loadinbuiltgpucard/' + srno,
					success: function(result) {
						var result = JSON.parse(result);
						$('#inBuiltGpuCard').val(result);
					}
				});
			});
		$('#machineSerialNo').on('click', function(){
			$.ajax({
				type: 'GET',
				url: '${pageContext.request.contextPath }/delivery/loadgpucard/',
				success: function(result) {
					var result = JSON.parse(result);
					var s = '';
					s += '<option value="' + 0 + '">' + "Select GPU Card" + '</option>';
					for(var i = 0; i < result.length; i++) {
						s += '<option value="' + result[i] + '">' + result[i] + '</option>';
					}
					$('#gpuCard').html(s);
				}
			});
		});
		
		});
		
		
		
	</script>

</head>
<body>

<div class="container">
	<c:if test="${record.did == 0}">
		<h3 align="center">Add Delivery Details</h3>
	</c:if>
	<c:if test="${record.did != 0}">
		<h3 align="center">Update Delivery Details</h3>
	</c:if>
	<div class="row mt-5">
	        <div class="col-3"></div>
	        <div class="col-6">
		        <form action="/delivery/add/${map.record.did}" method="POST">
		        	<div class="mb-3">
					  <label for="paramShavakVariant" class="form-label">Param Shavak Variant</label>
					  <select class="form-select" name="paramShavakVariant" id="paramShavakVariant"  required>
						 	<option value="HPC">HPC</option>
						 	<option value="VR">VR</option>
						 	<option value="DL">DL</option>
					  </select>
					</div>
					<div class="mb-3">
					  <label for="machineManufacturer" class="form-label">Machine Manufacturer</label>
						<select class="form-select"  name="machineManufacturer" id="machineManufacturer" required>
					  		<option value="${map.record.machineManufacturer}">${map.record.machineManufacturer}</option>
					  	</select>
					</div>
					<div class="mb-3">
					  <label for="machineModel" class="form-label">Machine Model</label>
					  <select class="form-select"  name="machineModel" id="machineModel" required>
					  	<option value="${map.record.machineModel}">${map.record.machineModel}</option>
					  </select>
					</div>
					<div class="mb-3">
					  <label for="machineSerialNo" class="form-label">Machine Serial No.</label>
					  <select class="form-select" name="machineSerialNo" id="machineSerialNo" required>
					  	<option value="${map.record.machineSerialNo}">${map.record.machineSerialNo}</option>
					  </select>
					</div>
					<div class="mb-3">
					  <label for="monitorManufacturer" class="form-label">Monitor Manufacturer</label>
					  <select class="form-select"  name="monitorManufacturer" id="monitorManufacturer" required>
					  		<option value="${map.record.monitorManufacturer}">${map.record.monitorManufacturer}</option>
					  	</select>
					</div>
					<div class="mb-3">
					  <label for="monitorModel" class="form-label">Monitor Model</label>
					  <select class="form-select"  name="monitorModel" id="monitorModel" required>
					  	<option value="${map.record.monitorModel}">${map.record.monitorModel}</option>
					  </select>
					</div>
					<div class="mb-3">
					  <label for="monitorSerialNo" class="form-label">Monitor Serial No.</label>
					  <select class="form-select" name="monitorSerialNo" id="monitorSerialNo" required>
					  	<option value="${map.record.monitorSerialNo}">${map.record.monitorSerialNo}</option>
					  </select>
					</div>
					<div class="mb-3">
					  <label for="disptachDate" class="form-label">Dispatch Date</label>
					  <input class="form-control" type="date" name="disptachDate" value="${map.record.disptachDate}" placeholder="Enter dispatch date">
					</div>
					<div class="mb-3">
					  <label for="systemInstalledBy" class="form-label">System Installed By</label>
					  <input class="form-control" type="text" name="systemInstalledBy" value="${map.record.systemInstalledBy}" placeholder="Enter installed by">
					</div>
					<div class="mb-3">
					  <label for="paramShavakVersion" class="form-label">Param Shavak Version</label>
					  <input class="form-control" type="text" name="paramShavakVersion" value="${map.record.paramShavakVersion}" placeholder="Enter param_shavak_version">
					</div>
					<div class="mb-3">
					  <label for="inBuiltGpuCard" class="form-label">In-Built GPU Card</label>
					  <input class="form-control" type="text" id="inBuiltGpuCard" name = "inBuiltGpuCard" value="${map.record.inBuiltGpuCard}" readonly>
					</div>
					<div class="mb-3">
					  <label for="gpuCard" class="form-label">GPU Card</label>
					  <select class="form-select"  name="gpuCard" id="gpuCard" required>
					  	<option value="${map.record.gpuCard}">${map.record.gpuCard}</option>
					  </select>
					</div>
					<div class="mb-3">
					  <label for="gpuCardSerialNo" class="form-label">GPU Card Serial No.</label>
					  <select class="form-select"  name="gpuCardSerialNo" id="gpuCardSerialNo" required>
					  	<option value="${map.record.gpuCardSerialNo}">${map.record.gpuCardSerialNo}</option>
					  </select>
					</div>
					
					<div class="mb-3">
					  <label for="studioLicense" class="form-label">Parallel_Studio_LicenseNo</label>
					  <input class="form-control" type="text" name="studioLicense" value="${map.record.studioLicense}" placeholder="Enter Studio License no">
					</div>
					
					<div class="mb-3">
					  <label for="instituteName" class="form-label">Institute Name</label>
					  <input class="form-control" type="text" name="instituteName" value="${map.record.instituteName}" placeholder="Enter institute name">
					</div>
					<div class="mb-3">
					  <label for="institutAddress" class="form-label">Institute Address</label>
					  <input class="form-control" type="text" name="institutAddress" value="${map.record.institutAddress}" placeholder="Enter institute address">
					</div>
					<div class="mb-3">
					  <label for="contactPersonName" class="form-label">Contact Person Name</label>
					  <input class="form-control" type="text" name="contactPersonName" value="${map.record.contactPersonName}" placeholder="Enter Contact person name">
					</div>
					<div class="mb-3">
					  <label for="mobile" class="form-label">Mobile No</label>
					  <input class="form-control" type="number" name="mobile" value="${map.record.mobile}" placeholder="Enter Mobile no">
					</div>
					<div class="mb-3">
					  <label for="emailId" class="form-label">Email Id</label>
					  <input class="form-control" type="email" name="emailId" value="${map.record.emailId}" placeholder="Enter Email Id">
					</div>
					<div class="mb-3">
					  <label for="comment" class="form-label">Comment</label>
					  <textarea class="form-control" name="comment" value="${map.record.comment}" class="form-control" id="comment" rows="3"></textarea>
					</div>
					<c:if test="${record.did == 0}">
						<input class="btn btn-success" type="submit" value="Deliver">
					</c:if>
					<c:if test="${record.did != 0}">
						<input class="btn btn-success" type="submit" value="Update">
					</c:if>
					<c:if test="${record.did == 0}">
						<a href="/addnew"><button class="btn btn-danger" type="button">Cancel</button></a>
					</c:if>
					<c:if test="${record.did != 0}">
						<a href="/delivery/view"><button class="btn btn-danger" type="button">Cancel</button></a>
					</c:if>
				</form>
	        </div>
	        <div class="col-3"></div>
	</div>
</body>
</html>