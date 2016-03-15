<?php
	session_start();
	include 'pages/common/include-headers.php';
	include 'pages/common/menu.php';
?>
<div class="container">
	<div class="col-lg-12">
		<div class="main">
			<div class="row">
				<div class="col-lg-4 col-lg-offset-4">
					<div class="input-group">
						<input type="text" id="search" name="search" class="form-control" placeholder="Enter keyword"/>
						<span class="input-group-btn">
							<button id="searchbtn" name="searchbtn" class="btn btn-default"><span class="glyphicon glyphicon-search"></span>&nbsp;Search</button>
						</span>
					</div>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-3 item-thumbnail">
					<div class="row div-link" data-location="#">
						<div class="col-lg-12">
							image here
							<!-- img class="img-thumbnail" src="${pageContext.request.contextPath}/Image?src=${Property.getPicture()}" /-->
						</div>
						<div class="col-lg-12">
							Code:
						</div>
						<div class="col-lg-12">
							Name:
						</div>
						<div class="col-lg-12">
							Description:
						</div>
						<div class="col-lg-12">
							Tags:
						</div>
						<div class="col-lg-12">
							Price:
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
<?php include 'pages/common/footer.php';?>