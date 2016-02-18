<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN"
"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <title>Check Stock</title>
  <link rel="stylesheet" type="text/css" href="style.css">
 </head>
 <body>
    <jsp:include page="header.jsp"/>
  <div id="content" bgcolor="#b5dcb3">
 <form method="post" action="check_stock">
     <p>Location: <input type="text" name="location"/></p>
     <p>Material: <input type="text" name="material"/></p>
     <p><input type="submit" value="Submit"/></p>
 </form>
  </div>
 </body>
</html>