<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Material | lifecell</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/general_style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/button_menu.css">
    <link rel="shortcut icon" href="/resources/images/favicon.ico" type="image/x-icon">
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="content">
    <h2>Description:</h2>
    <h3><p>Please, input "Material" to MATERIAL from SAP database.</p></h3>
    <form method="post" action="simple_material">
        <h3>Material:<input type="text" name="material"/></h3>
        <p><input type="submit" value="GET MATERIAL" class="button"/></p>
    </form>
</div>
</body>
</html>