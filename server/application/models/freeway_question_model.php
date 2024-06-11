<?php

class freeway_question_model extends ci_model {

		function insertQuestion(){
			$level=$_POST['level'];
			$question=$_POST['question'];
			$subject=$_POST['subject'];
			$data = array(
			'level'=>$level,
			'passage_id'=>0,
			'question_text' => $question,
			'section_id'=>1,
			'subject' => $subject
			 );

			 $this->db->insert('tbl_question', $data);
			redirect("http://localhost/server/index.php/selection");
		}
	}


