<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%--<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="shortcut icon" href="/resources/images/favicon.ico" type="image/x-icon">

    <title>Authentication | lifecell</title>

    <!-- Bootstrap core CSS -->
    <link href="<c:url value="/webjars/bootstrap/3.2.0/css/bootstrap.css" />" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="<c:url value="/resources/css/authentication.css" />" rel="stylesheet">

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.3.0/respond.min.js"></script>
    <![endif]-->
</head>

<body>

<div class="container" style="width: 300px;">
    <c:url value="/j_spring_security_check" var="loginUrl" />
    <form action="${loginUrl}" method="post">
        <h2 class="form-signin-heading">Welcome to lifecell</h2>
        <input type="text" class="form-control" name="j_username" placeholder="Email address" required autofocus value="lifecell">
        <input type="password" class="form-control" name="j_password" placeholder="Password" required value="admin">
        <button class="btn btn-lg btn-primary btn-block" type="submit">Login</button>
        <a href="/registration" class="btn btn-lg btn-primary btn-block">Register</a>
    </form>
</div>

</body>
</html>