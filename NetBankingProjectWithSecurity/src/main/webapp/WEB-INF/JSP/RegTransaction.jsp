<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Add Transaction</title>
</head>
<body>
    <h2>Add Transaction</h2>
    
    <form:form action="/addTransaction" method="post" modelAttribute="transaction_history">
        <table>
            <tr>
                <td>Transaction ID:</td>
                <td><form:input path="transactionId" required="true"/></td>
            </tr>
            <tr>
                <td>Amount:</td>
                <td><form:input path="amount" type="number" step="0.01" min="0" required="true"/></td>
            </tr>
            <tr>
                <td>Date:</td>
                <td><form:input path="date" required="true"/></td>
            </tr>
            <tr>
                <td>Account Number:</td>
                <td><form:input path="accNum" required="true"/></td>
            </tr>
            <tr>
                <td colspan="2"><input type="submit" value="Save Transaction"/></td>
            </tr>
        </table>
    </form:form>
</body>
</html>
