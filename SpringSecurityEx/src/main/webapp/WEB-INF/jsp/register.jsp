<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>User Registration</title>
</head>
<body>
    <h2>Register</h2>
    
    <!-- Bind this form to the "user" model attribute -->
    <form:form action="register" method="post" modelAttribute="user">
        <table>
            <tr>
                <td>Username:</td>
                <td><form:input path="username" required="true"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:password path="password" required="true"/></td>
            </tr>
            <tr>
                <td>Confirm Password:</td>
                <!-- confirmPassword is not part of your entity, but you can add it in DTO -->
                <td><form:password path="confirmPassword" required="true"/></td>
            </tr>
			
            <tr>
                <td>Details:</td>
                <td><form:textarea path="details" rows="4" cols="30"/></td>
            </tr>
			
			<tr>
			    <td>Group Permission:</td>
			    <td><form:input path="groupPermission" required="true"/></td>
			</tr>

            <tr>
                <td colspan="2">
                    <input type="submit" value="Register"/>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
