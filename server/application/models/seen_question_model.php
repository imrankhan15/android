<?php

class seen_question_model extends ci_model {

		function getAllBook($subject){
			$q1=$this->db->query("select * from tbl_book where  subject='$subject' ");
			
				if($q1->num_rows()>0)
				{
					 foreach($q1->result() as $row)
					 {
					 $data[]=$row;
					 }
					return $data;
				
				}
		}
		function getSection($id){
		$q1=$this->db->query("select * from tbl_section where  id='$id' ");
		
		if($q1->num_rows()>0)
		{
		 foreach($q1->result() as $row)
		 {
		 $data[]=$row;
		 }
		return $data;
		
		}
		}
	function getAllChapter($book_id){
		$q1=$this->db->query("select * from tbl_chapter where  bookid='$book_id' ");
		
		if($q1->num_rows()>0)
		{
		 foreach($q1->result() as $row)
		 {
		 $data[]=$row;
		 }
		return $data;
		
		}
	}
		function getAllSection($chap_id){
				$q1=$this->db->query("select * from tbl_section where chap_id='$chap_id'");
				
				if($q1->num_rows()>0)
				{
				 foreach($q1->result() as $row)
				 {
				 $data[]=$row;
				 }
				return $data;
				
				}
				
		}
		function insert()
		{
			$question=$_POST['question'];
			$subject='NoNeed';
			$section_id=$_POST['section_id'];
			$data = array(
			'level'=>0,
			'passage_id'=>4,
			'question_text' => $question,
			'section_id'=>$section_id,
			'subject' => $subject
			 );
			$this->db->insert('tbl_question', $data);
			redirect("http://localhost/server/index.php/show_seenquestions?sid=$section_id");
		}

	}


