<?php

class list_model extends ci_model {

	function get_passage($roll){
		$q1=$this->db->query("SELECT * FROM tbl_stdinfo2 ,tbl_passage WHERE tbl_passage.level = student_level+1 
								AND tbl_stdinfo2.id = '$roll' 
								AND tbl_passage.id NOT IN ((SELECT tbl_testhistory.passage_id FROM tbl_testhistory 
								WHERE tbl_testhistory.std_id = '$roll'))LIMIT 0, 1 ");
		if($q1->num_rows()>0)
		{
			 foreach($q1->result() as $row)
			 {
				$data[]=$row;
			 }
		 }
		return $data;
	}
	function get_subject($chap_id){
	$q1=$this->db->query("SELECT subject FROM tbl_book WHERE id = ( SELECT bookid FROM tbl_chapter WHERE id ='$chap_id' )");
		if($q1->num_rows()>0)
		{
			 foreach($q1->result() as $row)
			 {
				$data[]=$row;
			 }
		 }
		return $data;
	}
	function get_section($roll,$chap_id){
		$q1=$this->db->query("SELECT * FROM tbl_stdinfo2 ,tbl_section WHERE tbl_section.chap_id= '$chap_id'
								AND tbl_stdinfo2.id = '$roll' 
								AND tbl_section.id NOT IN ((SELECT tbl_testhistory.section_id FROM tbl_testhistory 
								WHERE tbl_testhistory.std_id = '$roll'))LIMIT 0, 1 ");
		if($q1->num_rows()>0)
		{
			 foreach($q1->result() as $row)
			 {
				$data[]=$row;
			 }
		 }
		return $data;
	}
	function get_passagequestion($id){
		$q1=$this->db->query("SELECT * FROM tbl_question WHERE tbl_question.passage_id = '$id' ORDER BY RAND() LIMIT 0, 4 ");
		if($q1->num_rows()>0)
		{
			 foreach($q1->result() as $row)
			 {
				$data[]=$row;
			 }
		 }
		return $data;
	}
	function get_sectionquestion($id){
		$q1=$this->db->query("SELECT * FROM tbl_question WHERE tbl_question.section_id = '$id' ORDER BY RAND() LIMIT 0, 4 ");
		if($q1->num_rows()>0)
		{
			 foreach($q1->result() as $row)
			 {
				$data[]=$row;
			 }
		 }
		return $data;
	}
	function get_answer($id){
		$q1=$this->db->query("SELECT * FROM tbl_answer WHERE tbl_answer.realanswer <> 1 AND tbl_answer.qid = '$id' LIMIT 0,3 UNION ALL 
								SELECT * FROM tbl_answer WHERE tbl_answer.realanswer = 1 AND tbl_answer.qid = '$id' ORDER BY RAND()");
		if($q1->num_rows()>0)
		{
			 foreach($q1->result() as $row)
			 {
				$data[]=$row;
			 }
		 }
		return $data;
	}
	
	function getLevel($roll){
	$q1=$this->db->query("select * from tbl_stdinfo2 where id='$roll'");
	if($q1->num_rows()>0)
		{
			 foreach($q1->result() as $row)
			 {
				$data[]=$row;
			 }
		 }
		return $data;
	}
	function getChapter($id){
	$q1=$this->db->query("select * from tbl_chapter where id='$id'");
	if($q1->num_rows()>0)
		{
			 foreach($q1->result() as $row)
			 {
				$data[]=$row;
			 }
		 }
		return $data;
	}
	function getBook($id){
	$q1=$this->db->query("select * from tbl_book where id='$id'");
	if($q1->num_rows()>0)
		{
			 foreach($q1->result() as $row)
			 {
				$data[]=$row;
			 }
		 }
		return $data;
	}
	function insertPassageNotice($level){
		
			$data = array(
			'passage_level'=>$level,
			);

			$this->db->insert('tbl_notice', $data);
	}
	function insertSectionNotice($chap_id){
		
			$data = array(
			'chapter_id'=>$chap_id,
			);

			$this->db->insert('tbl_notice', $data);
	}

}