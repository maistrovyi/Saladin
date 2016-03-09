<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Material Document | lifecell</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/general_style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/button_menu.css">
    <link rel="shortcut icon" href="/resources/images/favicon.ico" type="image/x-icon">
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="content">
    <h3>Description:</h3>
    <h5><p>Please, input Year and Document to insert into the SAP database.</p></h5>
    <form method="post" action="material_document">
        <p><h4>Year:</h4></p>
        <p><input type="text" name="year"/></p>
        <p><h4>Document:</h4></p>
        <P><input type="text" name="document"/></p>
        <p><input type="submit" value="Material Document" class="button"/></p>
    </form>
</div>
</body>
</html>