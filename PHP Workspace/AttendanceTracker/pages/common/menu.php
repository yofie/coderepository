<div id="pageheader"></div>
<nav class="navbar navbar-default" role="navigation">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand pull-left" href="#">Test Online</a>
			<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span> 
			</button>
		</div>
	    
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="#">Home</a></li>
				<li><a href="#">Category 1</a></li>
				<li><a href="#">Category 2</a></li> 
				<li><a href="#">Category 3</a></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<li class="notify-container">
					<button class="btn btn-default btn-lg btn-link" style="font-size:20px;">
						<span class="glyphicon glyphicon-cog"></span>
					</button>
					<span class="badge badge-notify">999</span>									
				</li>
				<li><button class="btn btn-default btn-lg btn-link" style="font-size:20px;"><span class="glyphicon glyphicon-log-out"></span></button></li>				
				<li><button id="loginmodal" class="btn btn-default btn-lg btn-link" style="font-size:20px;"><span class="glyphicon glyphicon-log-in"></span></button></li>
			</ul>
		</div>    
	</div>
</nav>
<?php include 'pages/common/login-modal.php';?>