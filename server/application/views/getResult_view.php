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

<form method="post" action="http://localhost/server/index.php/teacherselection/showResult2">
<table>
<tr><td> <b>Get Result Details:<b/></td></tr>
<tr><td>Your Roll  </td></tr>
<tr><td>
<?php
$a=$roll[0];
print("<input type=text name=roll value=$a readonly>");
?>
</td></tr>
<tr><td>Select Subject  </td></tr>
<tr><td><select name=subject>
 <?php
    
	foreach($rows as $line){
        echo '<option value="' . $line->id . '">' . $line->subject_name. '</option>';
    }
    ?>
</select>
<tr>
<td>
<input type="submit" name=page1submit value="Show" >
</td>
</tr>
</table>
</form>
<form method="post" action="http://localhost/server/index.php/logoutTeacher">
<input type="submit" name=page1submit value="logout" >
</form>
</body>
</html>