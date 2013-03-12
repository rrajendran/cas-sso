<html>
<body>
<h1>Secure Page</h1>
This is a protected page. You can get to me if you've been remembered,
or if you've authenticated this session.<br><br>

<%if (request.isUserInRole("ROLE_ADMIN")) { %>
	You are a supervisor! You can therefore see the <a href="extreme/index.jsp">extremely secure page</a>.<br><br>
	<p>${principal}</p>
	<h1>Ticket : ${ticket}</h1>
<% } %>


<p>
	<a href="/login/index">Home</a>
</p>
<p>
	<a href="/login/secure/extreme/index">Extreme Secure</a>
</p>
</body>
</html>