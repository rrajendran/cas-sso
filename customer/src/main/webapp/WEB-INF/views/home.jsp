<%@page
	import="org.springframework.security.core.context.SecurityContextHolder"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<title>Customer Home</title>
	<link rel="stylesheet" type="text/css" href="<c:url value="/css/customer.css" />">
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script>
		$(document).ready(function(){
			$("#userDetails").click(function(){
				$("#userDetailsContent").show();
				$("#ticketContent").hide();
			});
			
			$("#ticket").click(function(){
				$("#userDetailsContent").hide();
				$("#ticketContent").show();
			});
			
		});
	</script>
</head>
<body>
	<div id="box">
		<div id="sidebar">
			<div id="navigation">
				<h3>Menus</h3>
				<ul>
					<li>
						<a href="<c:url value="/secure/index" />">
							Secure
						</a>
					</li>
				</ul>
				<ul>
					<li>
						<a
							href="<c:url value="/secure/extreme/index" />">
							Extreme Secure
						</a>
					</li>
				</ul>
			</div>
		</div>
		<div id="content">
			<div>
				<h1>${message}</h1>
				<div id="userDetailsContent" class="details"> 
					<table>
						<tr>
							<td>Username</td>
							<td>${userDetails.username}</td>
						</tr>
						<tr>
							<td>Password</td>
							<td>${userDetails.password}</td>
						</tr>
						<tr>
							<td>Enabled</td>
							<td>${userDetails.enabled}</td>
						</tr>
						 <tr>
							<td>Account Non Expired</td>
							<td>${userDetails.accountNonExpired}</td>
						</tr>
						<tr>
							<td>Account Non Locked</td>
							<td>${userDetails.accountNonLocked}</td>
						</tr>
						<tr>
							<td>Credential Non Expired</td>
							<td>${userDetails.credentialsNonExpired}</td>
						</tr>
						<tr>
							<td>Ticket</td>
							<td>${credentials}</td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		
		
	</div>
</body>
</html>