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
<form method="post" action="http://localhost/server/index.php/section4">

<table>
<tr><td>Select ChapterName</td></tr>
<tr><td>
<select name=chap_id>
 <?php
    
	foreach($rows as $line){
        echo '<option value="' . $line->id . '">' . $line->chaptername . '</option>';
    }
    ?>
</select>

</td>
</tr>
<tr><td>Please Select Your Section Level:</td></tr>
<tr><td>
<select name=level>
<option value="">Select...</option>
<option value=1 selected>Easy
<option value=2>Medium
<option value=3>Hard
</select>

</td></tr>

<tr><td>Please Insert Your Section Name:</td></tr>
<tr><td><input type="text" name=sName></td></tr>

<tr><td>Please Insert Your Starting Page Num:</td></tr>
<tr><td><input type="text" name=sPage></td></tr>

<tr><td>Please Insert Your Ending Page Num:</td></tr>
<tr><td><input type="text" name=ePage></td></tr>
<tr><td><input type="submit" name=page1submit value="Jump In" ></td></tr>

</table>

</form>
<form method="post" action="http://localhost/server/index.php/selection">
<input type="submit" name=page1submit value="Back" >
</form>
</body>
