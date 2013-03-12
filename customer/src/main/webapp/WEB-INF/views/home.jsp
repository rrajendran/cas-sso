<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<html>
<body>
<h1>${message}</h1>
<p>${principal}</p>
<p>${credentials}</p>
<p>
	<a href="/login/secure/index">Secure</a>
</p>
<p>
	<a href="/login/secure/extreme/index">Extreme Secure</a>
</p>
</body>
</html>