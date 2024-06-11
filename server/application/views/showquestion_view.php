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
		
		print("<form method=POST action='http://localhost/server/index.php/showquestionmanage/updateQuestion?id=$id'>");
		print("<table>");
		foreach($rows as $row){
			print("<tr><td>Passage Id</td><td>");
			print("<select name=pid>");
			
				echo '<option value="' . $row->passage_id . ' selected">' . $row->passage_id. '</option>';
				foreach($mos as $line){
					echo '<option value="' . $line->id . '">' . $line->id. '</option>';
				}
			
			print("</select>");
			print("</td></tr>");
			print("<tr><td>Section Id</td><td>");
			print("<select name=sid>");
			 
				echo '<option value="' . $row->section_id . ' selected">' . $row->section_id. '</option>';
				foreach($nos as $line){
					echo '<option value="' . $line->id . '">' . $line->id. '</option>';
				}
				
			print("</select>");
			print("</td></tr>");
			print("<tr><td>QuestionText</td><td><textarea name=question rows=10 cols=80>".$row->question_text."</textarea></td></tr>");
			print("</table>");
			print("<br>");
			print("<br>");
			print("<input type=submit value='Update Question Record'></form>");
			print("<br><br><a href='http://localhost/server/index.php/showquestionmanage/deleteQuestion?id=$id'>Delete Quetion</a>");
			
		}
		?>
		<form method="post" action="http://localhost/server/index.php/showquestions">
<input type="submit" name=page1submit value="Back" >
</form>
    

</body>
</html>