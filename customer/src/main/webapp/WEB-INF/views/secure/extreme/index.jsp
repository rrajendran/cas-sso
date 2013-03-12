<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>

<html>
<body>
<h1>VERY Secure Page</h1>
This is a protected page. You can only see me if you are a supervisor.

<authz:authorize access="hasRole('ROLE_SUPERVISOR')">
  <h1> You have "ROLE_SUPERVISOR" (this text is surrounded by &lt;authz:authorize&gt; tags). </h1>
  <p>${principal}</p>
</authz:authorize>

<p>
	<a href="/login/index">Home</a>
</p>
<p>
	<a href="/login/secure/index">Secure</a>
</p>
</body>
</html>