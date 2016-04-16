<!DOCTYPE html>
<head>
    <meta charset="UTF-8"/>
    <title>Sign in | Saladin</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="resources/css/authentication_style.css" rel="stylesheet" type="text/css"/>
    <link rel="shortcut icon" href="resources/images/favicon.ico" type="image/x-icon">
</head>
<body>
<div class="body">
    <div class="reg_block">
        <form action="#" action="@{/authentication}" method="post">
            <input type="text" placeholder="Login Name" class="input" name="loginName"/>
            <input type="password" placeholder="Password" class="input" name="password"/>
            <label class="error_label">${authentication_error}</label>
            <input type="submit" value="Log In" class="input_button"/>
            <a class="forgot_link" href="registration">Not signed up yet?</a>
        </form>
    </div>
</div>
</body>
</html>