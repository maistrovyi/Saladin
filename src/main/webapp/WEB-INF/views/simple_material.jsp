<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Material | Saladin</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/general_style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/button_menu.css">
    <link rel="shortcut icon" href="/resources/images/favicon.ico" type="image/x-icon">
    <script type="text/javascript" src="/resources/js/disabledSubmitButton.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="content">
    <p>Description:</p>
    <p>Please, input "Material" field to get material data from SAP.</p>
    <form method="post" action="simple_material">
        <p>Material:<input type="text" onchange="checkEmptyField(this.value)" name="material"/></p>
        <p><input type="submit" id="submitButton" value="GET MATERIAL" class="button" disabled="disabled"/></p>
    </form>
</div>
</body>
</html>