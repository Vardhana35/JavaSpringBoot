<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Account Registration</title>
</head>
<body>
    <h2>Register Account</h2>
    
    <!-- Bind this form to the "account" model attribute -->
    <form:form action="/register" method="post" modelAttribute="account">
        <table>
            <tr>
                <td>Account Number:</td>
                <td><form:input path="accNum" type="number" min="10000" max="1000000" required="true"/></td>
            </tr>
            <tr>
                <td>Account Name:</td>
                <td><form:input path="accName" minlength="5" maxlength="20" required="true"/></td>
            </tr>
            <tr>
                <td>Balance:</td>
                <td><form:input path="balance" type="number" step="0.01" min="0" required="true"/></td>
            </tr>
            <tr>
                <td>Branch ID:</td>
                <td><form:input path="branchId" minlength="10" required="true"/></td>
            </tr>
            <tr>
                <td>Area:</td>
                <td><form:input path="area"/></td>
            </tr>
            <tr>
                <td>Email:</td>
                <td><form:input path="email" type="email" required="true"/></td>
            </tr>
            
            <!-- Extra fields for authentication -->
            <tr>
                <td>Username:</td>
                <td><form:input path="username" minlength="5" maxlength="20" required="true"/></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><form:password path="password" minlength="8" required="true"/></td>
            </tr>
            <tr>
                <td>Confirm Password:</td>
                <!-- confirmPassword can be part of a DTO -->
                <td><form:password path="confirmPassword" minlength="8" required="true"/></td>
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
