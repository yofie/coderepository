<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/pages/commons/scripts.jsp"%>
<title>Pabebe Inventory Store - Add user</title>
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
		            <li class="active"><a href="#"><i class="fa fa-plus-square fa-2x"></i><label>Add New User</label></a></li>
					<li><a href="UserList"><i class="fa fa-users fa-2x"></i><label>User List</label></a></li>
		          </ul>
		      </c:if>
	    </div>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
            <div class="row">
                <div class="col-lg-6 col-md-6">
			<div class="pull-right">
				<a href="ItemList"><button class="btn btn-success"><i class="fa fa-arrow-circle-left"></i> Go to item list</button></a>
			</div>
		</div>
            </div>
    </c:if>
	<c:if test="${empty user}">
		<div class="container">
	</c:if>
                    
	<div class="col-md-6 col-lg-4">
		<div class="jumbotron" style="padding: 10px">
			<h2>Add User:</h2>
			
			<form role="form" id="adduser" action="AddUser" method="POST">
				<div class="form-group">
						<label for="username">User name:</label>
						<input type="hidden" id="id" name="id" value="<c:out value="${id}"/>" />
						<input type="text"  id="username" name="username" class="form-control" value="<c:out value="${username}"/>" />
						<i><c:out value="${usernameerrmsg}" /></i>
				</div>
				<div class="form-group">
						<label for="firstname">First Name:</label>
						<input type="text" class="form-control" id="firstname" name="firstname"
							value="<c:out value="${firstname}"/>" />
						<i><c:out value="${firstnameerrmsg}" /></i>
				</div>
				<div class="form-group">
						<label for="lastname">Last Name:</label>
						<input type="text" class="form-control" id="lastname" name="lastname"
							value="<c:out value="${lastname}"/>" />
						<i><c:out value="${lastnameerrmsg}" /></i>
				</div>
				<div class="form-group">
						<label for="confirmpassword">Password:</label>
						<input type="password" class="form-control" id="password" name="password" 
							value="<c:out value="${password}"/>"/>
						<i><c:out value="${passworderrmsg}" /></i>
				</div>
				<div class="form-group">
						<label for="confirmpassword">Confirm Password:</label>
						<input type="password" class="form-control" id="confirmpassword" name="confirmpassword" 
							value="<c:out value="${confirmpassword}"/>"/>
						<i><c:out value="${confirmpassworderrmsg}"/></i>
				</div>
				<div class="form-group">
						<label for="itemquantity">Department:</label>
						<input type="text" class="form-control" id="department" name="department"
							value="<c:out value="${department}"/>" />
						<i><c:out value="${departmenterrmsg}" /></i>
				</div>
				<div class="pull-right">
						<button type="submit" class="btn btn-primary"><i class="fa fa-floppy-o"></i> Save</button>
				</div>
			</form>
			<br><br>
		</div>
	</div>
		
    </div>
</div>




<!--
	<form id="adduser" action="AddUser" method="POST">
		<table align="center" width="400px">
			<tr>
				<td>Username:</td>
				<td><input type="text" id="username" name="username" value="<c:out value="${username}"/>"/></td>
				<td><c:out value="${usernameerrmsg}"/></td>
			</tr>
			<tr>
				<td>First Name:</td>
					<td><input type="text" id="firstname" name="firstname" value="<c:out value="${firstname}"/>"/></td>
					<td><c:out value="${firstnameerrmsg}"/></td>
			</tr>				
			<tr>
				<td>Last Name:</td>
					<td><input type="text" id="lastname" name="lastname" value="<c:out value="${lastname}"/>"/></td>
					<td><c:out value="${lastnameerrmsg}"/></td>
			</tr>				
			<tr>
				<td>Password:</td>
				<td><input type="password" id="password" name="password" value="<c:out value="${password}"/>"/></td>
				<td><c:out value="${passworderrmsg}"/></td>
			</tr>
			<tr>
				<td> Confirm Password:</td>
					<td><input type="password" id="confirmpassword" name="confirmpassword" value="<c:out value="${confirmpassword}"/>"/></td>
					<td><c:out value="${confirmpassworderrmsg}"/></td>
			</tr>
			<tr>
				<td>Department:</td>
				<td><input type="text" id="department" name="department" value="<c:out value="${department}"/>"/></td>
				<td><c:out value="${departmenterrmsg}"/></td>
			</tr>				
			<tr>
				<td colspan="3" align="center"><input type="submit" value="Save"/></td>
			</tr>
		</table>
	</form>
	<a href="UserList">Go to user list</a>
	-->
</body>
</html>