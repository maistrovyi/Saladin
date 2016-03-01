<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>Check Stock | lifecell</title>
    <link rel="stylesheet" type="text/css" href="/resources/css/general_style.css">
    <link rel="stylesheet" type="text/css" href="/resources/css/button_menu.css">
    <link rel="shortcut icon" href="/resources/images/favicon.ico" type="image/x-icon">
</head>
<body>
<jsp:include page="header.jsp"/>
<div id="content">
    <h3>Description:</h3>
    <h5><p>JavaServer Pages (JSP) is a technology that helps software developers create dynamically generated</p>
        <p> web pages based on HTML, XML, or other document types. Released in 1999 by Sun Microsystems, JSP</p>
        <p> is similar to PHP and ASP, but it uses the Java programming language.</p></h5>
    <form method="post" action="check_stock">
        <p><h4>Location:</h4></p>
        <p><input type="text" name="location"/></p>
        <p><h4>Material:</h4></p>
        <P><input type="text" name="material"/></p>
        <p><input type="submit" value="Check Stock" class="button"/></p>
    </form>
</div>
</body>
</html>