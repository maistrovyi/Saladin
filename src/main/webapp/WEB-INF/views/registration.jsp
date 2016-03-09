<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Spring MVC form submission</title>
</head>

<body>
<h2>Fill your form!</h2>

<form:form method="POST" commandName="registrationFormData">
    <table>
        <tr>
            <td>Enter your firstName:</td>
            <td><form:input path="person.firstName" /></td>
            <%--<td><form:errors path="name" cssStyle="color: #ff0000;"/></td>--%>
        </tr>
        <tr>
            <td>Enter your secondName:</td>
            <td><form:input path="person.secondName" /></td>
                <%--<td><form:errors path="name" cssStyle="color: #ff0000;"/></td>--%>
        </tr>
        <tr>
            <td>Enter your login:</td>
            <td><form:input path="person.loginName" /></td>
                <%--<td><form:errors path="name" cssStyle="color: #ff0000;"/></td>--%>
        </tr>
        <tr>
            <td>Enter a password:</td>
            <td><form:password path="person.password"  showPassword="true"/></td>
            <%--<td><form:errors path="password" cssStyle="color: #ff0000;"/></td>--%>
        <tr>
            <td>Confirm your password:</td>
            <td><form:password path="repeatPassword" showPassword="true"/></td>
            <%--<td><form:errors path="passwordConf" cssStyle="color: #ff0000;"/></td>--%>
        </tr>
        <tr>
            <td><input type="submit" name="submit" value="Submit"></td>
        </tr>
        <tr>
    </table>
</form:form>

</body>
</html>