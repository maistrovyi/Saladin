<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Registration | lifecell</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="stylesheet" type="text/css" href="resources/css/general.css"/>
    <link href="resources/css/registration_style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<form:form method="post" commandName="registrationFormData">
<div class="reg_block">
    <div class="box">
        <div class="input_block">
            <form:input type="text" placeholder="First Name" class="input" path="person.firstName"/>
        </div>
    </div>
    <div class="box">
        <div class="input_block">
            <form:input type="text" placeholder="Second Name" class="input" path="person.secondName"/>
        </div>
    </div>
    <div class="box">
        <div class="input_block">
            <form:input type="text" placeholder="Login Name" class="input" path="person.loginName"/>
        </div>
    </div>
    <div class="box">
        <div class="input_block">
            <form:input type="password" placeholder="Password" class="input" path="person.password"/>
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