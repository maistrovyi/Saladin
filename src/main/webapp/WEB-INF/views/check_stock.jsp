<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Check Stock | Saladin</title>
    <link rel="stylesheet" type="text/css" href="/saladin/resources/css/general_style.css">
    <link rel="stylesheet" type="text/css" href="/saladin/resources/css/button_menu.css">
    <link rel="shortcut icon" href="/saladin/resources/images/favicon.ico" type="image/x-icon">
    <script type="text/javascript" src="/saladin/resources/js/disabledSubmitButton.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="content">
    <p>Description:</p>
    <p>Please, input "Location" and "Material" fields to get check stock from SAP.</p>
    <form method="post" name="Form" action="check_stock">
        <span>
            Location:<input id="button_check_stock_m" type="text" onchange="checkEmptyCheckStockFields()" name="location"/>
            <label class="error_label">${locationValueError}</label>
        </span>
        <p></p>
        <span>
            Material:<input type="text" onchange="checkEmptyCheckStockFields()" name="material"/>
            <label class="error_label">${materialValueError}</label>
        </span>
        <p><input type="submit" id="submitButton" value="GET CHECK STOCK" class="button" disabled="disabled"/></p>
    </form>
</div>
</body>
</html>