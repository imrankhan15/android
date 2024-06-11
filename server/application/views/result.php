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
The  Result is:
<?php
	
	
        echo  '</br>'.'total_test No:   '.$total_test[0].'  -->Passed:   '.$passed[0].'</br>' ;
    
	
?>

<form method="post" action="http://localhost/server/index.php/teacherselection">
<input type="submit" name=page1submit value="Back" >
</form>
</body>
</html>