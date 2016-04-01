<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration | Saladin</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="resources/css/registration_style.css" rel="stylesheet" type="text/css"/>
    <link rel="shortcut icon" href="/resources/images/favicon.ico" type="image/x-icon">
</head>
<body>
<form:form method="post" commandName="registrationFormData">
<div class="reg_block">
    <div class="box">
        <div class="input_block">
            <form:input type="text" placeholder="First Name" class="input" path="person.firstName"/>
        </div>
        <div class="error_block">
            <form:errors path="person.firstName" cssClass="error_label"/>
        </div>
    </div>

    <div class="box">
        <div class="input_block">
            <form:input type="text" placeholder="Second Name" class="input" path="person.secondName"/>
        </div>
        <div class="error_block">
            <form:errors path="person.secondName" cssClass="error_label"/>
        </div>
    </div>

    <div class="box">
        <div class="input_block">
            <form:input type="text" placeholder="Login Name" class="input" path="person.loginName"/>
        </div>
        <div class="error_block">
            <form:errors path="person.loginName" cssClass="error_label"/>
        </div>
    </div>

    <div class="box">
        <div class="input_block">
            <form:input type="password" placeholder="Password" class="input" path="person.password"/>
        </div>
        <div class="error_block">
            <form:errors path="person.password" cssClass="error_label"/>
        </div>
    </div>

    <div class="box">
        <div class="input_block">
            <form:input type="password" placeholder="Repeat Password" class="input" path="repeatPassword"/>
        </div>
    </div>
    <input type="submit" value="Sign Up" class="input_button"/>
    </form:form>
</body>
</html>