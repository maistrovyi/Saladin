<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Saladin</title>
    <link rel="stylesheet" type="text/css" href="resources/css/general_style.css">
</head>
<body>
<div id="user_panel">
    <div id="user_info">
        <h3>User: ${person.loginName}</h3>
        <p><h3><a href="/signout">Log out</a></h3></p>
    </div>
</div>
<nav id="nav">
    <div id="logo">
        <img src="/resources/images/logo.png" width="365" height="200"/>
    </div>
    <div id="menu">
    <li><a href="/home">HOME</a></li>
    <li><a href="/check_stock">CHECK STOCK</a></li>
    <li><a href="/material_document">MATERIAL DOCUMENT</a></li>
    <li><a href="/update_material_document">MD UPDATE</a></li>
    <li><a href="/simple_material">MATERIAL</a></li>
    <li><a href="/active">ACTIVE QUEUE</a></li>
    <li><a href="/persons">PERSONS</a></li>
    <li><a href="/settings">SETTINGS</a></li>
    </div>
</nav>
<script type="text/javascript" src="/resources/js/active.js"></script>
</body>
</html>