<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
  
  <script language = "javascript">
	function action1()
    {open("check_stock_content.jsp", "testing", "asd", false)}
//    {document.getElementById("info").innerHTML = "Action 1 clicked!";}

    function action2()
    {document.getElementById("info").innerHTML = "Action 2 clicked!";}

    function action3()
    {document.getElementById("info").innerHTML = "Action 3 clicked!";}
  </script>

 </head>
 <br style="background: #f0f0f0">

<p><input type = "button" value = "Check Stock" name = "checkstockAction" OnClick = "action1()"></p>
<a href="http://www.google.com" target="main_page">Google</a>
 <br /><br />
<a href="http://www.google.com" target = "CHECK_STOCK_CONTENT">Check Stock Content</a>
<p><input type = "button" value = "Action 2" name = "action2" OnClick = "action2()"></p>
<p><input type = "button" value = "Action 3" name = "action3" OnClick = "action3()"></p>

<div id="info"></div>
 </body>
</html>