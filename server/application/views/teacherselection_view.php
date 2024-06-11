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
<form method="post" action="http://localhost/server/index.php/teacherselection/insert">
<table>
<tr><td> <b>Data Inquiry:<b/></td></tr>
<tr>
<td>Select person type you want to Insert:</td>
<td> 
<select name=rsctype>
<option value="">Select...</option>
<option value="problemsetter" selected>ProblemSetter
<option value="student">Student

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
<form method="post" action="http://localhost/server/index.php/teacherselection/show">
<table>
<tr>
<td>Select Person type you want to Show:</td>
<td> 
<select name=rsctype>
<option value="">Select...</option>
<option value="problemsetter" selected>Problem Setter
<option value="student">Student

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
<form method="post" action="http://localhost/server/index.php/teacherselection/showResult">
<table>
<tr><td> <b>Get Result Details:<b/></td></tr>
<tr><td>Select Student Roll No </td></tr>
<tr><td>
<select name=roll>
 <?php
    
	foreach($rows as $line){
        echo '<option value="' . $line->id . '">' . $line->id. '</option>';
    }
    ?>
</select>
</td></tr>
<tr><td>
<input type="submit" name=page1submit value="Show" >
</td></tr>
</table>
</form>

<form method="post" action="http://localhost/server/index.php/logoutTeacher">
<input type="submit" name=page1submit value="logout" >
</form>
</body>
</html>