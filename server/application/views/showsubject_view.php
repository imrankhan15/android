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
<div style="position:relative;top:-70px;left:360px;margin:1em 0 4em em">
<?php
	$id=$i[0];
	print("<form method=POST action='http://localhost/server/index.php/showsubjectmanage/updateSubject?id=$id'>");
	print("<table>");
		
		foreach($rows as $row){
			print("<tr><td>Class Id</td><td>");
			print("<select name=class_id>");
			
				echo '<option value="' . $row->class_id . ' selected">' . $row->class_id. '</option>';
				foreach($mos as $line){
					if($line->id!=$row->class_id)
					echo '<option value="' . $line->id . '">' . $line->id. '</option>';
				}
				
			print("</select>");
			print("</td></tr>");
			print("<tr><td>Subject Name</td><td><input maxlength=50 type=text name=subject_name value='".$row->subject_name."'></td></tr>");
		}
		print("</table>");
		print("<br>");
		print("<br>");
		print("<input type=submit value='Update Subject Record'></form>");
		print("<br><br><a href='http://localhost/server/index.php/showsubjectmanage/deleteSubject?id=$id'>Delete Subject</a>");
		?>
		<form method="post" action="http://localhost/server/index.php/showsubjects">
<input type="submit" name=page1submit value="Back" >
</form>
</body>
</html>