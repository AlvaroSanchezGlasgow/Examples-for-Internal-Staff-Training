<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html lang="en">
<head>


<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=yes">
<meta name="Description" content="Allocation Information." />
<meta name="Distribution" content="internal" />
<meta name="Author" content="everis" />

<link rel="stylesheet" href="css/bootstrap/bootstrap.css">
<link rel="stylesheet" href="css/bootstrap/bootstrap-responsive.css">
<link rel="stylesheet" href="css/bootstrap/bootstrap-responsive.min.css">
<link rel="stylesheet" href="css/bootstrap/bootstrap.min.css">
<link rel="stylesheet" href="css/datatable/jquery.dataTables.min.css">
<link rel="stylesheet" href="css/jquery-confirm/jquery-confirm.css">

<script src="js/jquery/jquery-3.3.1.slim.min.js"></script>
<script src="js/jquery/jquery-3.3.1.js"></script>
<script src="js/popper/popper.min.js"></script>
<script src="js/bootstrap/bootstrap.min.js"></script>
<script src="js/bootstrap/bootstrap.js"></script>
<script src="js/datatable/jquery.dataTables.min.js"></script>
<script src="js/jquery-confirm/jquery-confirm.js"></script>
<script src="js/generics/popUpsFunctions.js"></script>
<script src="js/generics/genericFunctions.js"></script>
<script src="js/generics/app-ajax.js"></script>


<title>Index - Everis Course</title>
</head>
<body>

	<div class="container">
		<div class="row">

			<div class="span4">

				<a href="http://www.everis.uk.com/" target="_blank"> <img
					src="images/everis_logo.png" title="everis" />
				</a>
			</div>
			<div class="span4">
				<h1>Everis</h1>
				<p>Java Spring Boot - Course</p>
			</div>
			<div class="span4">
				<p></p>
				<sec:authentication property="principal.username" />
				-
				<sec:authentication property="principal.authorities" />

				(<a href="<c:url value="/logout" />">Logout</a>)
			</div>
	

		<div class="span12">
			<ul class="breadcrumb">
				<li class="active"><a
					href="${pageContext.request.contextPath}/">Home</a> <span
					class="divider">/</span></li>
				<sec:authorize access="hasAuthority('ADMIN')">
					<li><a href="${pageContext.request.contextPath}/admin">Forced Error</a>
						<span class="divider">/</span></li>
				</sec:authorize>
			</ul>
		</div>
	</div>
		

		

		<div class="row">
			<div class="table-responsive" style="text-align: center;">

<c:choose>
	<c:when test="${not empty users}">
				<table id="tableResult" class="table-striped" border="0.2" style="margin: 0 auto;">
					<thead style="background-color:#0063be;color:#e8e9e9;">
						<th></th>
						<th>User ID</th>
						<th>User Name</th>
						<th>User Surname</th>
						<th>User Role</th>
					</thead>
					<tbody style="">
					<c:forEach items='${users}' var='item' varStatus='loopStatus'>
						<tr>
							<td><input type="checkbox" name="users" value="<c:out value='${item.userId}' />"></td>
							<td><c:out value='${item.userId}' /></td>
							<td><c:out value='${item.userName}' /></td>
							<td><c:out value='${item.userSurname}' /></td>
							<td><c:out value='${item.userRole}' /></td>
						</tr>
						</c:forEach>
					</tbody>
				</table>
					</c:when>
	<c:otherwise>
		<hr></hr>
		<center>
			<span class="label label-default NoResults">No results found</span>
		</center>
		<hr></hr>
	</c:otherwise>
</c:choose>

			</div>

		</div>
		
		<form action="/">

<!--
			<div class="row" style="text-align: center;">
				<div class="col">
					<input type="text" class="form-control" placeholder="User ID">
				
					<input type="text" class="form-control" placeholder="User name">
				</div>
				<div class="col">
					<input type="text" class="form-control" placeholder="User Surname">
				
					<input type="text" class="form-control" placeholder="User Role">
				</div>
			
-->
<hr></hr>

			<div class="col-sm-4" style="text-align: center;">
				<!--<button type="button" class="btn btn-primary btn-lg" onclick="">Search</button>-->
				<button type="button" class="btn btn-primary btn-lg" onclick="javascript:deleteConfirm();">Delete</button>
				<button type="button" class="btn btn-primary btn-lg" onclick="javascript:newUserPopUp();">New</button>
			</div>
			</div>
		</form>
		<hr></hr>
	</div>
	
<script type="text/javascript">
$(document).ready( function () {
    $('#tableResult').DataTable();
} );
</script>
</body>
</html>