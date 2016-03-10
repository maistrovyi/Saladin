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
    <h2>Description:</h2>
    <h3><p>Please, input "Year" and "Document" to insert into the SAP database.</p></h3>
    <form method="post" action="material_document">
        <h3>Year:<input type="text" id="first_input_mat_doc" name="year"/></h3>
        <h3>Document:<input type="text" name="document"/></h3>
        <p><input type="submit" id="button_mat_doc" value="GET MATERIAL DOCUMENT" class="button"/></p>
    </form>
</div>
</body>
</html>