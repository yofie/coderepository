<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/pages/commons/scripts.jsp"%>
<title>Pabebe Inventory Store</title>
</head>
<c:if test="${empty user}">
	<c:redirect url="Login" />
</c:if>
<body>
	<%@ include file="/pages/commons/header.jsp"%>
	<div class="container-fluid">
		<div class="row">
			<c:if test="${not empty user}">
				<div class="col-sm-3 col-md-2 sidebar">
					<style>
a>label {
	left: 73px;
	top: 15px;
	position: absolute;
}
</style>
					<ul class="nav nav-sidebar">
						<li><a href="ItemList"><i class="fa fa-book fa-2x"></i><label>Overview</label></a></li>
					</ul>
					<c:if test="${not empty user}">
						<ul class="nav nav-sidebar">
							<li class="active"><a href="#"><i
									class="fa fa-plus-square fa-2x"></i><label>Add New Item</label><span
									class="sr-only">(current)</span></a></li>
							<li><a href="AddUser"><i class="fa fa-plus-square fa-2x"></i><label>Add
										New User</label></a></li>
							<li><a href="UserList"><i class="fa fa-users fa-2x"></i><label>User
										List</label></a></li>
						</ul>
					</c:if>
				</div>
				<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
					<div class="row">
						<div class="col-lg-6 col-md-6">
							<div class="pull-right">
								<a href="ItemList"><button class="btn btn-success">
										<i class="fa fa-arrow-circle-left"></i> Go to item list
									</button></a>
							</div>
						</div>
					</div>
			</c:if>
			<c:if test="${empty user}">
				<div class="container">
			</c:if>

			<div class="col-md-6 col-lg-4">
				<div class="jumbotron" style="padding: 10px">
					<h2>Update Item:</h2>

					<form role="form" action="UpdateItem" method="POST">
						<div class="form-group">
							<label for="itemname">Item name:</label> <input type="hidden"
								id="id" name="id" value="<c:out value="${id}"/>" /> 
								<input type="text" id="itemname" class="form-control" name="itemname"
								value="<c:out value="${itemname}"/>" /> <i><c:out
									value="${itemnameerrmsg}" /></i>
						</div>
						<div class="form-group">
							<label for="itemdescription">Item Description:</label> <input
								type="text" id="itemdescription" class="form-control"
								name="itemdescription"
								value="<c:out value="${itemdescription}"/>" /> <i><c:out
									value="${itemdescriptionerrmsg}" /></i>
						</div>
						<div class="form-group">
							<label for="itemprice">Item Price:</label> <input type="text"
								id="itemprice" class="form-control" name="itemprice"
								value="<c:out value="${itemprice}"/>" /> <i><c:out
									value="${itempriceerrmsg}" /></i>
						</div>
						<div class="form-group">
							<label for="itemquantity">Item Quantity:</label> <input
								type="text" id="itemquantity" class="form-control"
								name="itemquantity" value="<c:out value="${itemquantity}"/>" />
							<i><c:out value="${itemquantityerrmsg}" /></i>
						</div>
						<div class="pull-right">
							<button type="submit" class="btn btn-primary">
								<i class="fa fa-floppy-o"></i> Update
							</button>
						</div>
					</form>
					<br>
					<br>
				</div>
			</div>

		</div>
	</div>



</body>
</html>