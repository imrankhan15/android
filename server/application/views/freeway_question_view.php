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
<form method="post" action="http://localhost/server/index.php/freeway_question/insertQuestion">
<table>
<tr><td>Please Select Your Subject</td></tr>
<tr><td><select name=subject>
<option value="">Select...</option>
<option value=EnglishReading selected>EnglishReading
<option value=SocialScience >SocialScience

</select></td></tr>
<tr><td>Please Select Your QuestionLevel</td></tr>
<tr><td><select name=level>
<option value="">Select...</option>
<option value=1 selected>Easy
<option value=2>Medium
<option value=3>Hard
</select></td></tr>
<tr><td>Please Insert Your Question</td></tr>
<tr><td>
<textarea name=question id="feedback" rows="10" cols="80" > </textarea>
<tr>
<td>
<input type="submit" name=page1submit value="Jump In" >
</td>
</tr>
</table>
</form>
<form method="post" action="http://localhost/server/index.php/selection">
<input type="submit" name=page1submit value="Back" >
</form>
</body>
</html>