<html> 
<head>

</head>
<body BGCOLOR='#888888'>
<div style="border:1px solid black;padding:15px;margin:20px;min-height:100px;background-color:#9999CC">
<p>
<center style="color:#180000;font-size:30px">
Online Exam System For Specified Students
</center>
</p>
</div>
<br>
<br>
<br>
 <b><center>
</center></b>
<br>
<div style="position:relative;top:-70px;left:10px;margin:1em 0 4em em">
<?php

		
		
		print("<table border=1><tr><td>Passage Id#</td><td>Level</td><td>Text</td></tr>");
		foreach($rows as $row){
			 print("<tr><td><a href='http://localhost/server/index.php/showpassage?id=$row->id'>$row->id</a></td><td>$row->level</td><td>$row->text</td></tr>");
		}
		print("</table>");
		print("<br>");
		print("<br>");
		?>
		<form method="post" action="http://localhost/server/index.php/selection">
		<input type="submit" name=page1submit value="Back" >
		</form>
    

</body>
</html>