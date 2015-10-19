<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/pages/commons/scripts.jsp"%>
<title>Pabebe Inventory Store</title>
<c:if test="${empty user}">
    <c:redirect url="Login"/>
</c:if>
</head>
<body>
<%@ include file="/pages/commons/header.jsp"%>
 <div class="container-fluid">
 	<div class="row">
 	<c:if test="${not empty user}">
	 	<div class="col-sm-3 col-md-2 sidebar">
	 		<style>
	 			a > label{
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
		            <li><a href="AddItem"><i class="fa fa-plus-square fa-2x"></i><label>Add New Item</label></a></li>
		            <li><a href="AddUser"><i class="fa fa-plus-square fa-2x"></i><label>Add New User</label></a></li>
					<li class="active"><a href="UserList"><i class="fa fa-users fa-2x"></i><label>User List</label><span class="sr-only">(current)</span></a></li>
		          </ul>
		      </c:if>
	    </div>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    </c:if>
	<c:if test="${empty user}">
		<div class="container">
	</c:if>
	<c:if test="${not empty success}">
		<script type="text/javascript">
			alert("Item successfully added.");
		</script>
		<c:remove var="success" scope="request"/>	
	</c:if>
	<c:choose>
		<c:when test="${not empty user}">
			<h1>Welcome back <c:out value="${user.firstName}"/>!</h1><br>
		</c:when>
		<c:otherwise>
			<h5>Hello please click <a href="Login">Login</a></h5>
		</c:otherwise>
	</c:choose>
			
		<div class="col-lg-8 col-md-12">
			<h3>User List</h3>
			<a href="ItemList"><button class="btn btn-success"><i class="fa fa-arrow-circle-left"></i> Item List</button></a>
			
			<table class="table table-striped table-hover pull-left">
						<thead>
							<tr>
								<th>User Name</th>
								<th>First Name</th>
								<th>Last Name</th>
								<th>Department</th>
								<c:if test="${not empty user}">
									<th>Action</th>
								</c:if>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${users}" var="users">
								<tr>
									<td>
				                		<form id="viewUser<c:out value="${users.id}"/>" action="ViewUser" method="POST">
				                    		<a href="#" onclick="document.forms['viewUser<c:out value="${users.id}"/>'].submit();return false;"><c:out value="${users.userName}"/></a>
				                    		<input type="hidden" id="id" name="id" value="<c:out value="${users.id}"/>"/>
				                    	</form>
									</td>
										
									<td><c:out value="${users.firstName}" /></td>
									<td><c:out value="${users.lastName}" /></td>
									<td><c:out value="${users.department}" /></td>
									<td>
										<form id="deleteUser<c:out value="${users.id}"/>" method="POST"
											action="DeleteUser">
											<input type="hidden" id="id" name="id"
												value="<c:out value="${users.id}"/>" />
											<button type="submit"
												value="Delete"
												class="btn btn-danger"
												onclick="return confirm('Are you sure to delete this user?')">
												<i class="fa fa-trash-o"></i> Delete
											</button>
										</form>
									</td>
								</tr>
							</c:forEach>
						</tbody>
		    </table>
	    </div>
    </div>
    </div>
</div>
<c:if test="${not empty success}">
	<script type="text/javascript">
		alert("User successfully added.");
	</script>
	<c:remove var="success" scope="request" />
</c:if>




<!--
	<c:if test="${not empty success}">
		<script type="text/javascript">
			alert("User successfully added.");
		</script>
		<c:remove var="success" scope="request" />
	</c:if>
		Hi <c:out value="${user.firstName}" />!<br>
		<a href="LogOut">Logout</a>
		<a href="AddUser">Add new User</a>
		<a href="ItemList">Item List</a>
	<table>
		<tr>
			<td>
				<form id="searchItem" method="POST" action="UserList">
					<input type="text" id="searchkeyword" name="searchkeyword"
						value="<c:out value="${searchkeyword}"/>" /><input type="submit"
						value="Search" />
				</form>
			</td>
			<td>
				<form id="resetItem" method="GET" action="UserList">
					<input type="submit" value="Reset" />
				</form>
			</td>
		</tr>
	</table>
	<table border=1>
		<thead>
			<tr>
				<th>User Name</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Department</th>
				<c:if test="${not empty user}">
					<th>Action</th>
				</c:if>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="users">
				<tr>
					<td>
                		<form id="viewUser<c:out value="${users.id}"/>" action="ViewUser" method="POST">
                    		<a href="#" onclick="document.forms['viewUser<c:out value="${users.id}"/>'].submit();return false;"><c:out value="${users.userName}"/></a>
                    		<input type="hidden" id="id" name="id" value="<c:out value="${users.id}"/>"/>
                    	</form>
					</td>
						
					<td><c:out value="${users.firstName}" /></td>
					<td><c:out value="${users.lastName}" /></td>
					<td><c:out value="${users.department}" /></td>
					<td>
						<form id="deleteUser<c:out value="${users.id}"/>" method="POST"
							action="DeleteUser">
							<input type="hidden" id="id" name="id"
								value="<c:out value="${users.id}"/>" /> <input type="submit"
								value="Delete"
								onclick="return confirm('Are you sure to delete this user?')" />
						</form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
-->
</body>
</html>