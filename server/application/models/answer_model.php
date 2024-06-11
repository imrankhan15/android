<?php

class answer_model extends ci_model {

function getAllQuestions()
	{
		
		$q1=$this->db->query("select * from tbl_question ");
		
		if($q1->num_rows()>0)
		{
		 foreach($q1->result() as $row)
		 {
		 $data[]=$row;
		 }
		return $data;
		
		}
		
	}
	function getQuestion($id)
	{
		
		$q1=$this->db->query("select * from tbl_question where id='$id'");
		
		if($q1->num_rows()>0)
		{
		 foreach($q1->result() as $row)
		 {
		 $data[]=$row;
		 }
		return $data;
		
		}
		
	}
	function insertAnswer(){
	$qid=$_POST['rsctype'];
	$answer=$_POST['answer'];
	$real=$_POST['real'];
	$data = array(
    'qid' => $qid ,
    'text_ans' => $answer,
    'realanswer' => $real
	 );

	 $this->db->insert('tbl_answer', $data);
     redirect("http://localhost/server/index.php/show_answer?qid=$qid");
	}

}
