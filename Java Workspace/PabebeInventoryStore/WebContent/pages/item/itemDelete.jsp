<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ include file="/pages/commons/scripts.jsp"%>
<title>Pabebe Inventory Store</title>]
<c:if test="${empty user}">
    <c:redirect url="Login"/>
</c:if>
</head>
<body>
	<form  action="DeleteItem" method="POST">
	<table align="center" width="400px">
		<tr>
			<td>Item ID</td>
			<td><input type="text" id="id" name="id" value="<c:out value="${id}"/>"/></td>
			<td><c:out value="${usernameerrmsg}"/></td>
		</tr>
		
				
		<tr>
			<td colspan="3" align="center"><input type="submit" value="Submit"/></td></tr>
	</table>
	
	</form>
	<form action = "ItemList" method = "POST">
	
	<input type = "submit" value = "View Items"/>
	</form>
	
	
			 
	
</body>
</html>