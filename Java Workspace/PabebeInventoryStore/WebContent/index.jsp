<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/pages/commons/scripts.jsp"%>
<title>Pabebe Inventory Store</title>
</head>
<body>
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
</style>
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
            <c:if test="${not empty user}">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="LogOut"><i class="fa fa-sign-out"></i> Logout</a></li>
                </ul>
            </c:if>
            <c:if test="${empty user}">
                <ul class="nav navbar-nav navbar-right">
                    <li><a href="Login">Click here to Log-In</a></li>
                </ul>
            </c:if>
	        <div class="hidden-lg hidden-md hidden-sm">
	          
			      <c:if test="${not empty user}">
                                  <ul class="nav navbar-nav navbar-right">
                                    <li class="active"><a href="ItemList"><i class="fa fa-book fa-2x"></i><label>Overview</label><span class="sr-only">(current)</span></a></li>
                                  </ul>
			          <ul class="nav nav-sidebar">
			            <li><a href="AddItem"><i class="fa fa-plus-square fa-2x"></i><label>Add New Item</label></a></li>
     			        <li><a href="AddUser"><i class="fa fa-plus-square fa-2x"></i><label>Add New User</label></a></li>
						<li><a href="UserList"><i class="fa fa-users fa-2x"></i><label>User List</label></a></li>
			          </ul>
			      </c:if>
                                <c:if test="${empty user}">
                                    <ul class="nav nav-sidebar">
                                        <li><a href="Login"><i class="fa fa-plus-square fa-2x"></i> <label>Login</label></a></li>
                                    </ul>
                                </c:if>
			</div>
        </div>
      </div>
 </nav>
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
	            <li class="active"><a href="#"><i class="fa fa-book fa-2x"></i><label>Overview</label><span class="sr-only">(current)</span></a></li>
	          </ul>
		      <c:if test="${not empty user}">
		          <ul class="nav nav-sidebar">
		            <li><a href="AddItem"><i class="fa fa-plus-square fa-2x"></i><label>Add New Item</label></a></li>
		            <li><a href="AddUser"><i class="fa fa-plus-square fa-2x"></i><label>Add New User</label></a></li>
					<li><a href="UserList"><i class="fa fa-users fa-2x"></i><label>User List</label></a></li>
		          </ul>
		      </c:if>
	    </div>
	<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
    </c:if>
	<c:if test="${empty user}">
		<div class="container">
                    <br><br>
                    <style>
                        .jsearch{
                            padding-left: 0px;
                        }
                    </style>
	</c:if>
	<c:if test="${not empty success}">
		<script type="text/javascript">
			alert("Item successfully added.");
		</script>
		<c:remove var="success" scope="request"/>	
	</c:if>
        <c:if test="${not empty user}">
                <h1>Welcome back <c:out value="${user.firstName}"/>!</h1><br>
        </c:if>
		<div class="col-lg-4 col-sm-12 col-xs-12 pull-right">
			<div class="jumbotron jsearch">
				<div>
					<h4>Search Items:</h4>
                                        <style>
                                            .search{
                                                padding: 10px;
                                            }
                                        </style>
                                        
					<form id="searchItem" method="POST" action="ItemList">
						<input type="text" id="searchkeyword" class="form-control" name="searchkeyword" value="<c:out value="${searchkeyword}"/>"/>
						<div class="pull-right">
                                                    <div class="search">
							<button type="submit" value="Search" class="btn btn-success"><i class="fa fa-search"></i> Search</button>
                                                    </div>
						</div>
					</form>
					<form id="resetItem" method="GET" action="ItemList">
                                            <div class="search">
						<input type="submit" value="Reset" class="btn btn-primary pull-right"/>
                                            </div>
					</form>
				</div>
				<br><br>
			</div>
		</div>
			
		<div class="col-lg-8 col-md-12">
			<table class="table table-striped table-hover pull-left">
		        <thead>
		            <tr>
		                <th>Item Name</th>
		                <th>Item Description</th>
		                <th>Item Price</th>
		                <th>Item Quantity</th>
		                <c:if test="${not empty user}">
		                	<th>Action</th>
		                </c:if>
		            </tr>
		        </thead>
		        <tbody>
		            <c:forEach items="${items}" var="items">
		                <tr>
		                    <td>
		                    	<c:choose>
		                    		<c:when test="${not empty user}">
		                    			<form id="viewItem<c:out value="${items.id}"/>" action="ViewItem" method="POST">
		                    				<a href="#" onclick="document.forms['viewItem<c:out value="${items.id}"/>'].submit();return false;"><c:out value="${items.itemName}"/></a>
		                    				<input type="hidden" id="id" name="id" value="<c:out value="${items.id}"/>"/>
		                    			</form>
		                    		</c:when>
		                    		<c:otherwise>
		                    			<c:out value="${items.itemName}" />                    		
		                    		</c:otherwise>                  		
		                    	</c:choose>
		                    </td>
		                    <td><c:out value="${items.itemDescription}" /></td>
		                    <td><i class="fa fa-rub"></i> <c:out value="${items.itemPrice}" /></td>
		                    <td><c:out value="${items.itemQuantity}" /></td>
		                    
								<c:if test="${not empty user}">
									<td>
				                   		<form id="deleteItem<c:out value="${items.id}"/>" method="POST" action="DeleteItem">
				                   			<input type="hidden" id="id" name="id" value="<c:out value="${items.id}"/>"/>
				                   			<button class="btn btn-danger" onclick="return confirm('Are you sure to delete this item?')"><i class="fa fa-trash-o"></i> Delete</button>
				                   		</form>
			                   		</td>
								</c:if>
							
		                </tr>
		            </c:forEach>
		        </tbody>
		    </table>
	    </div>
    </div>
    </div>
</div>
</body>
</html>