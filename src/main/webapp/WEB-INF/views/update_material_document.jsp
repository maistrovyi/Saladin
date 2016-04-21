<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>MD Update | Saladin</title>
    <link rel="stylesheet" type="text/css" href="/saladin/resources/css/general_style.css">
    <link rel="stylesheet" type="text/css" href="/saladin/resources/css/button_menu.css">
    <link rel="shortcut icon" href="/saladin/resources/images/favicon.ico" type="image/x-icon">
    <script type="text/javascript" src="/saladin/resources/js/disabledSubmitButton.js"></script>
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="content">
    <p>Description:</p>
    <p>Please, input "Document" field to update material document from SAP.</p>
    <form method="post" action="update_material_document">
        </span>
            Document:<input type="text" onchange="checkEmptyFieldMaterial(this.value)" name="document"/>
            <label class="error_label">${error}</label>
        <span>
        <p><input type="submit" id="button_mat_doc" value="UPDATE MD" class="button" disabled="disabled"/></p>
    </form>
</div>
</body>
</html>