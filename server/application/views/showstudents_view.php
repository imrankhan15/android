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
<form method="post" action="http://localhost/server/index.php/teacherselection">
<input type="submit" name=page1submit value="Back" >
</form>
<?php

		
		print("<table border=1><tr><td>Student Id#</td><td>Student Mobile No</td><td>Student Level</td></tr>");
		foreach($rows as $row){
			 print("<tr><td><a href='http://localhost/server/index.php/showstudent?id=$row->id'>$row->id</a></td><td>$row->phone_num</td><td>$row->student_level</td></tr>");
		}
		print("</table>");
		print("<br>");
		print("<br>");
    
?>

</body>
</html>