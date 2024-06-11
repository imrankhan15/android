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
		
		print("<form method=POST action='http://localhost/server/index.php/showsectionmanage/updateSection?id=$id'>");
		print("<table>");
		
		foreach($rows as $row){
			print("<tr><td>Chapter Id</td><td>");
			print("<select name=chap_id>");
			
				echo '<option value="' . $row->chap_id . ' selected">' . $row->chap_id. '</option>';
				foreach($nos as $line){
					echo '<option value="' . $line->id . '">' . $line->id. '</option>';
				}
				
			print("</select>");
			print("</td></tr>");
			print("<tr><td>Start Page</td><td><input maxlength=50 type=text name=startpage value='".$row->startpage."'></td></tr>");
			print("<tr><td>End Page</td><td><input maxlength=50 type=text name=endpage value='".$row->endpage."'></td></tr>");
			print("<tr><td>Level</td><td>");
			print("<select name=level>");
			
				echo '<option value="' . $row->section_level . ' selected">' . $row->section_level. '</option>';
				foreach($mos as $line){
					echo '<option value="' . $line->id . '">' . $line->id. '</option>';
				}
				
			print("</select>");
			print("<tr><td>Section Name</td><td><input maxlength=50 type=text name=section_name value='".$row->section_name."'></td></tr>");
			print("</td></tr>");
			print("</table>");
			print("<br>");
			print("<br>");
			print("<input type=submit value='Update Section Record'></form>");
			print("<br><br><a href='http://localhost/server/index.php/showsectionmanage/deleteSection?id=$id'>Delete Section</a>");
			
			
		}
		?>
		
		<form method="post" action="http://localhost/server/index.php/showsections">
		<input type="submit" name=page1submit value="Back" >
		</form>
		
		
		
    

</body>
</html>