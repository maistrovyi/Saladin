<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>
 <head>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
     <script language = "javascript">
         function submitAction()
         {document.getElementById("info").innerHTML = "Submit clicked!";}
     </script>
 </head>
 <body>
   <p><strong>Location :</strong><br>
   <input type="text" size="40">
   </p>

   <p><strong>Material:</strong><br>
   <input type="text" size="40">
   </p>

 <p><input type = "button" value = "Submit" name = "submitButton" OnClick = "submitAction()"></p>

 <div id = "info"></div>
 </body>
</html>