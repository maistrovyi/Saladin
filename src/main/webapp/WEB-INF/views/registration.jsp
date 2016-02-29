<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
    <head>
        <title>Registration | lifecell</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <%--<link rel="stylesheet" type="text/css" href="resources/css/general.css"/>--%>
        <link href="resources/css/registration_style.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <div th:replace="header">&nbsp;</div>

        <form action="#" th:action="@{/registration}" method="post" th:object="${registrationFormData}">
            <div class="reg_block">
                <div class="box">
                    <div class="input_block">
                        <input type="text" placeholder="First Name" class="input" th:field="*{person.firstName}"/>
                    </div>
                    <div class="error_block">
                        <label th:if="${#fields.hasErrors('*{person.firstName}')}" class="error_label"
                               th:errors="*{person.firstName}"></label>
                    </div>
                </div>

                <div class="box">
                    <div class="input_block">
                        <input type="text" placeholder="Second Name" class="input" th:field="*{person.secondName}"/>
                    </div>
                    <div class="error_block">
                        <label th:if="${#fields.hasErrors('*{person.secondName}')}" class="error_label"
                               th:errors="*{person.secondName}"></label>
                    </div>
                </div>

                <div class="box">
                    <div class="input_block">
                        <input type="text" placeholder="Login Name" class="input" th:field="*{person.loginName}"/>
                    </div>
                    <div class="error_block">
                        <label th:if="${#fields.hasErrors('*{person.loginName}')}" class="error_label"
                               th:errors="*{person.loginName}"></label>
                    </div>
                </div>

                <div class="box">
                    <div class="input_block">
                        <input type="password" placeholder="Password" class="input" th:field="*{person.password}"/>
                    </div>
                    <div class="error_block">
                        <label th:if="${#fields.hasErrors('*{person.password}')}" class="error_label"
                               th:errors="*{person.password}"></label>
                    </div>
                </div>

                <div class="box">
                    <div class="input_block">
                        <input type="password" placeholder="Repeat Password" class="input" th:field="*{repeatPassword}"/>
                    </div>
                </div>

                <input type="submit" value="Sign Up" class="input_button"/>
            </div>
        </form>
    </body>
</html>