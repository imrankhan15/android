<?php

class unseen_question_model extends ci_model {

		function getAllPassage(){
				$q1=$this->db->query("select * from tbl_passage ");
				
				if($q1->num_rows()>0)
				{
				 foreach($q1->result() as $row)
				 {
				 $data[]=$row;
				 }
				return $data;
				
				}
				
		}
		function getPassage($pid){
				$q1=$this->db->query("select * from tbl_passage where id='$pid'");
				
				if($q1->num_rows()>0)
				{
				 foreach($q1->result() as $row)
				 {
				 $data[]=$row;
				 }
				return $data;
				
				}
				
		}
		function insert(){
		$question=$_POST['question'];
			$subject='NoNeed';
			$passage_id=$_POST['passage_id'];
			$data = array(
			'level'=>0,
			'passage_id'=>$passage_id,
			'question_text' => $question,
			'section_id'=>1,
			'subject' => $subject
			 );
			$this->db->insert('tbl_question', $data);
			redirect("http://localhost/server/index.php/show_unseenquestion?pd=$passage_id");
		}
		


	}


