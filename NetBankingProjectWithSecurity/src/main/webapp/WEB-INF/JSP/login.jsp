<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h2>Custom Login Page</h2>
    <form action="${pageContext.request.contextPath}/login" method="POST">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        
        <label for="username">username:</label>
        <input type="text" id="username" name="username" required/><br><br>
        
        <label for="password">password:</label>
        <input type="password" id="password" name="password" required/><br><br>
        
        <input type="submit" value="Login"/>
    </form>
</body>
</html>
