<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	.navbar{
		background-color: #23A528;
	}
	.navbar a{
		color: white;
	}
    .nav>li> a:hover{
		background-color: #76C379;
	}
	.form-group i{
		color: red;
	}
</style>
	<c:if test="${not empty success}">
		<script type="text/javascript">
			alert("User successfully added.");
		</script>
		<c:remove var="success" scope="request" />
	</c:if>
<nav class="navbar navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <i class="fa fa-bars fa-2x"></i>
          </button>
          <a class="navbar-brand" href="#">Pabebe Store Inventory System</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
        		<ul class="nav navbar-nav navbar-right">
                    <li><a href="LogOut"><i class="fa fa-sign-out"></i> Logout</a></li>
                </ul>
	        <div class="hidden-lg hidden-md hidden-sm">
	          <ul class="nav navbar-nav navbar-right">
	          	<li><a href="ItemList"><i class="fa fa-book fa-2x"></i><label>Overview</label><span class="sr-only">(current)</span></a></li>
		          </ul>
			      <c:if test="${not empty user}">
			          <ul class="nav nav-sidebar">
			            <li><a href="AddItem"><i class="fa fa-plus-square fa-2x"></i><label>Add New Item</label></a></li>
			            <li><a href="AddUser"><i class="fa fa-plus-square fa-2x"></i><label>Add New User</label></a></li>
                        <li><a href="UserList"><i class="fa fa-users fa-2x"></i><label>User List</label></a></li>
			          </ul>
			      </c:if>
			</div>
        </div>
      </div>
</nav>