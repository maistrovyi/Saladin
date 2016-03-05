<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<%--<html xmlns:th="http://www.thymeleaf.org">--%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Error | lifecell</title>
    <link rel="stylesheet" type="text/css" href="resources/css/error_style.css">
    <link rel="shortcut icon" href="/resources/images/favicon.ico" type="image/x-icon">
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="content">
    <p><h1>Ooops... We are sorry, but something went wrong.</h1></p>
    <p><a href="/home" style="color: #4CAF50"><h2>Take me back to the homepage</h2></a></p>
    <div class="general_block">
        <div class="header">Details : ${header}</div>
        <div class="message"><p>Message : ${message}</p></div>
    </div>
</div>
</body>
</html>