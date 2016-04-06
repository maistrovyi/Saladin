<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Saladin | Settings</title>
    <link rel="stylesheet" type="text/css" href="resources/css/general_style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/button_menu.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/settings_style.css">
    <link rel="shortcut icon" href="/resources/images/favicon.ico" type="image/x-icon">
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="content">
    <p>If you want to change your password - input all fields and click on the "SAVE" button.</p>
    <form:form method="post" commandName="passwordChangingFormData">
        <div class="box">
            <div class="input_block">
                <label for="currentPasswordField">Current Password:</label>
                <form:input type="password" id="currentPasswordField" class="input" path="person.password"/>
            </div>
            <div class="error_block">
                <form:errors path="person.password" cssClass="error_label"/>
            </div>
        </div>

        <div class="box">
            <div class="input_block">
                <label for="newPasswordField">New password:</label>
                <form:input type="password" id="newPasswordField" class="input_block_new_pass" path="newPassword"/>
            </div>
            <div class="error_block">
                <form:errors path="newPassword" cssClass="error_label"/>
            </div>
        </div>

        <div class="box">
            <div class="input_block">
                <label for="repeatPasswordField">Repeat Password:</label>
                <form:input type="password" id="repeatPasswordField" class="input" path="repeatPassword"/>
            </div>
            <div class="error_block">
                <form:errors path="repeatPassword" cssClass="error_label"/>
            </div>
        </div>
        <div>
            <input id="passwordChangeButton" type="submit" value="SAVE" class="button"/>
        </div>
    </form:form>
</div>
</body>
</html>