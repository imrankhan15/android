<?php

class passage_model extends ci_model {

function insertPassage()
		{
		$subject=$_POST['subject'];
		$level=$_POST['level'];
		$text=$_POST['text'];
		$data = array(
		'level'=>$level,
		'text' => $text,
		'subject' => $subject
		 );

	    $this->db->insert('tbl_passage', $data);
		redirect("http://localhost/server/index.php/selection");
		}
		
	}

	


