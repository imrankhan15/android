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
<form method="post" action="http://localhost/server/index.php/subject/insert">
<table>
<tr><td>Insert Subject<td></tr>
<tr><td>
<tr><td>Please Insert Your ID</td></tr>
<tr><td><textarea name=id id="feedback" rows="5" cols="20" > </textarea></td></tr>
<tr><td>Select Class</td></tr>
<tr><td>
<select name=class_id>
 <?php
    
	foreach($rows as $line){
        echo '<option value="' . $line->id . '">' . $line->name. '</option>';
    }
    ?>
</select>
</td>
</tr>
<tr><td>Please Insert Your SubjectName</td></tr>
<tr><td><textarea name=name id="feedback" rows="5" cols="40" > </textarea></td></tr>

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