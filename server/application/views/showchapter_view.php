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
		print("<form method=POST action='http://localhost/server/index.php/showchaptermanage/updateChapter?id=$id'>");
		print("<table>");
		
		foreach($rows as $row){
			print("<tr><td>Book Id</td><td>");
			print("<select name=bookid>");
			 
			echo '<option value="' . $row->bookid . ' selected">' . $row->bookid. '</option>';	
				foreach($mos as $line){
					echo '<option value="' . $line->id . '">' . $line->id. '</option>';
				}
			
			print("</select>");
			print("</td></tr>");
			print("<tr><td>ChapterName</td><td><input maxlength=50 type=text name=chaptername value='".$row->chaptername."'></td></tr>");
			print("</table>");
			print("<br>");
			print("<br>");
			print("<input type=submit value='Update Chapter Record'></form>");
			print("<br><br><a href='http://localhost/server/index.php/showchaptermanage/deleteChapter?id=$id'>Delete chapter</a>");
			
		}
		?>
		
		<form method="post" action="http://localhost/server/index.php/showchapters">
		<input type="submit" name=page1submit value="Back" >
		</form>
</body>
</html>