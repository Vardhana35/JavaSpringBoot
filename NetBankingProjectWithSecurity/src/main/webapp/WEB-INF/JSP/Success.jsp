<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registration Success</title>
</head>
<body>
    <h2>${message}</h2>
    <p>Your account has been registered successfully.</p>
	
	<ul> 
		<li><a href="${pageContext.request.contextPath}/addTransaction">Add a Transaction</a></li>
		<li><a href="${pageContext.request.contextPath}/login">Login to Your Account</a></li>
 
	</ul>
</body>
</html>
