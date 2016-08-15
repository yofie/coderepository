<?php
	session_start();
	include 'pages/common/include-headers.php';
	$absoluteFileLocation = explode("/", $_SERVER['REQUEST_URI']);
	define(__BEEMO_BASE_URL__, $_SERVER["DOCUMENT_ROOT"]."/".$absoluteFileLocation[1]);	
?>
<div ng-app="AttTrac" class="container">
	<div class="col-lg-12" style="padding-bottom: 30px">
		<div class="main">
			<div class="row">
				<div class="col-lg-4 col-lg-offset-4">
					<div class="input-group">
						<input type="text" id="search" name="search" class="form-control" placeholder="Enter employee number or name"/>
						<span class="input-group-btn">
							<button id="searchbtn" name="searchbtn" class="btn btn-default"><span class="glyphicon glyphicon-search"></span>&nbsp;Search</button>
						</span>
					</div>
				</div>
			</div>
		</div>
	</div>

	<table ng-controller="Tracker" class="table table-bordered table-hover">
		<thead>
			<td>Employee Number</td>
			<td>Name</td>
			<td>Time In</td>
			<td>Time Out</td>
			<td>Shift code</td>
			<td>WS</td>						
		</thead>
	</table>
</div>
<?php include 'pages/common/footer.php';?>