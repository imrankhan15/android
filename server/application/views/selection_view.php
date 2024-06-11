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

<br>
<div style="position:relative;top:-70px;left:360px;margin:1em 0 4em em">
<form method="post" action="http://localhost/server/index.php/selection/insert">
<table>
<tr>
<td>
<b>Inquiry Data:</b>
</td>
</tr>
<tr>
<td>Select resource type you want to Insert:</td>
<td> 
<select name=rsctype>
<option value="">Select...</option>
<option value=class selected>Class
<option value=subject >Subject
<option value=book>BookName
<option value=chapter>Chapter
<option value=section >Section
<option value=question>Question
<option value=answer>Answer

</select>
</td>
</tr>
<tr>
<td>
<input type="submit" name=page1submit value="Insert" >
</td>
</tr>
</table>
</form>
<form method="post" action="http://localhost/server/index.php/selection/show">
<table>
<tr>
<td>Select resource type you want to Show:</td>
<td> 
<select name=rsctype>
<option value="">Select...</option>
<option value=class selected>Class
<option value=subject >Subject
<option value=book>BookName
<option value=chapter>Chapter
<option value=section >Section
<option value=question>Question
<option value=answer>Answer

</select>
</td>
</tr>
<tr>
<td>
<input type="submit" name=page1submit value="Show" >
</td>
</tr>
</table>
</form>
<b>Inquiry Application:</b>
<form method="post" action="http://localhost/server/index.php/showNotice">
<input type="submit" name=page1submit value="showNotice" >
</form>
<form method="post" action="http://localhost/server/index.php/showFeedBack">
<input type="submit" name=page1submit value="showFeedBack" >
</form>
<form method="post" action="http://localhost/server/index.php/logout">
<input type="submit" name=page1submit value="logout" >
</form>
</body>
</html>