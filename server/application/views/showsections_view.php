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

		$COL_ID = 0;
		$COL_chapid = 1;
		$COL_startpage = 2;
		$COL_endpage = 2;
		$COL_level = 3;
		print("<table border=1><tr><td>Section Id#</td><td>Chapter ID</td><td>Start Page</td><td>End Page</td><td>Level</td><td>SectionName</td></tr>");
		foreach($rows as $row){
			 print("<tr><td><a href='http://localhost/server/index.php/showsection?id=$row->id'>$row->id</a></td><td>$row->chap_id</td><td>$row->startpage</td><td>$row->endpage</td><td>$row->section_level</td><td>$row->section_name</td></tr>");
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