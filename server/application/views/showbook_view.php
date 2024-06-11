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
	print("<form method=POST action='http://localhost/server/index.php/showbookmanage/updateBook?id=$id'>");
	print("<table>");
		
		foreach($rows as $row){
			print("<tr><td>BookName</td><td><input maxlength=50 type=text name=bookname value='".$row->book_name."'></td></tr>");
		}
		print("</table>");
		print("<br>");
		print("<br>");
		print("<input type=submit value='Update Book Record'></form>");
		print("<br><br><a href='http://localhost/server/index.php/showbookmanage/deleteBook?id=$id'>Delete Book</a>");
		?>
		<form method="post" action="http://localhost/server/index.php/showbooks">
<input type="submit" name=page1submit value="Back" >
</form>
</body>
</html>