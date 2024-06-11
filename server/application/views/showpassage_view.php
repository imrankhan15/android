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
		print("<form method=POST action='http://localhost/server/index.php/showpassagemanage/updatePassage?id=$id'>");
		print("<table>");
		?>
		
		
		<?php
		foreach($rows as $row){
			print("<tr><td>Level</td><td>");
			print("<select name=level>");
			 
			echo '<option value="' . $row->level . ' selected">' . $row->level. '</option>';	
				foreach($mos as $line){
					echo '<option value="' . $line->id . '">' . $line->id. '</option>';
				}
				
			print("</select>");
			print("</td></tr>");
			print("<tr><td>PassageText</td><td><textarea   rows=10 cols=80 name=text>".$row->text."</textarea></td></tr>");
			print("</table>");
			print("<br>");
			print("<br>");
			print("<input type=submit value='Update Passage Record'></form>");
			print("<br><br><a href='http://localhost/server/index.php/showpassagemanage/deletePassage?id=$id'>Delete Passage</a>");
			
		}
		?>
		<form method="post" action="http://localhost/server/index.php/showpassages">
		<input type="submit" name=page1submit value="Back" >
		</form>
</body>
</html>