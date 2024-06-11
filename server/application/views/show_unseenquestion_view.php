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
The  Questions for this passage are:
<?php
$id=$pd[0];
foreach($rows as $line){
        echo  '</br>'.'id'.$line->id.'-->question'.$line->question_text.'</br>' ;
    }
	print("<form method=POST action='http://localhost/server/index.php/unseen_question1?pd=$id'>");
	?>

<input type="submit" name=page1submit value="Back" >
</form>
</body>
</html>