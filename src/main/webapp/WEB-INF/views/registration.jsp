<!DOCTYPE html>
<head>
    <title>Registration | lifecell</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link rel="shortcut icon" href="/resources/images/favicon.ico" type="image/x-icon">
    <link href="resources/css/registration_style.css" rel="stylesheet" type="text/css"/>
</head>
<body>
<div class="body">
    <form action="#" action="@{/registration}" method="post" object="${registrationFormData}">
        <div class="reg_block">
            <div class="box">
                <div class="input_block">
                    <input type="text" placeholder="First Name" class="input" field="*{person.firstName}"/>
                </div>
                <div class="error_block">
                    <label if="${fields.hasErrors('*{person.firstName}')}" class="error_label"
                           errors="*{person.firstName}"></label>
                </div>
            </div>

            <div class="box">
                <div class="input_block">
                    <input type="text" placeholder="Second Name" class="input" field="*{person.secondName}"/>
                </div>
                <div class="error_block">
                    <label if="${fields.hasErrors('*{person.secondName}')}" class="error_label"
                           errors="*{person.secondName}"></label>
                </div>
            </div>

            <div class="box">
                <div class="input_block">
                    <input type="text" placeholder="Login Name" class="input" field="*{person.loginName}"/>
                </div>
                <div class="error_block">
                    <label if="${fields.hasErrors('*{person.loginName}')}" class="error_label"
                           errors="*{person.loginName}"></label>
                </div>
            </div>

            <div class="box">
                <div class="input_block">
                    <input type="password" placeholder="Password" class="input" field="*{person.password}"/>
                </div>
                <div class="error_block">
                    <label if="${fields.hasErrors('*{person.password}')}" class="error_label"
                           errors="*{person.password}"></label>
                </div>
            </div>

            <div class="box">
                <div class="input_block">
                    <input type="password" placeholder="Repeat Password" class="input" field="*{repeatPassword}"/>
                </div>
            </div>

            <input type="submit" value="Sign Up" class="input_button"/>
        </div>
    </form>
</div>
</body>
</html>