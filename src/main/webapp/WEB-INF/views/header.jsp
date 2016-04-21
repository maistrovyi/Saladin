<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Saladin</title>
    <link rel="stylesheet" type="text/css" href="/saladin/resources/css/general_style.css">
</head>
<body>
<div id="user_panel">
    <div id="user_info">
        <h3>User: ${person.loginName}</h3>
        <p><h3><a href="/saladin/signout">Log out</a></h3></p>
    </div>
</div>
<nav id="nav">
    <div id="logo">
        <img src="/saladin/resources/images/logo.png" width="365" height="200"/>
    </div>
    <div id="menu">
        <c:forEach items="${person.getMenuItems()}" var="role" varStatus="loop">
            <li><a href="/saladin${role.getMenuType()}">${role.getMenuName()}</a></li>
        </c:forEach>
    </div>
</nav>
<script type="text/javascript" src="/saladin/resources/js/active.js"></script>
</body>
</html>