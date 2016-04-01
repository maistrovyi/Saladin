<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Check Stock | Saladin</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/general_style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/button_menu.css">
    <link rel="shortcut icon" href="/resources/images/favicon.ico" type="image/x-icon">
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="content">
    <p>Description:</p>
    <p>Please, input "Location" and "Material" fields to get check stock from SAP.</p>
    <form method="post" action="check_stock">
        <p>Location:<input id="button_check_stock_m" type="text" name="location"/></p>
        <p>Material:<input type="text" name="material"/></p>
        <p><input type="submit" value="GET CHECK STOCK" class="button"/></p>
    </form>
</div>
</body>
</html>