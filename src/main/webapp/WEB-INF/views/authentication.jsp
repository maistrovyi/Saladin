<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8"/>
    <title>Sign in | Recent news</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="resources/css/authentication_style.css" rel="stylesheet" type="text/css"/>
    <link rel="shortcut icon" href="/resources/images/favicon.ico" type="image/x-icon">
</head>
<body>
<div class="reg_block">
    <form action="#" th:action="@{/authentication}" method="post">
        <input type="text"  placeholder="Login Name" class="input" name ="loginName"/>
        <input type="password"  placeholder="Password" class="input" name ="password"/>
        <label class="error_label" th:if="${authorization_error != null}" th:text="${authorization_error}"></label>
        <input type="submit" value="Sign In" class="input_button" />
        <a class="forgot_link" href="registration">Not signed up yet?</a>
    </form>
</div>
</body>
</html>