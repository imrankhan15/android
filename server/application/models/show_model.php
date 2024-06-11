<?php

class show_model extends ci_model {

function get_answers($qid){
	
	$q1=$this->db->query("select * from tbl_answer where qid='$qid'");
		
		if($q1->num_rows()>0)
		{
		 foreach($q1->result() as $row)
		 {
		 $data[]=$row;
		 }
		return $data;
		
		}
}
function get_passagequestions($pid){
	
		$q1=$this->db->query("select * from tbl_question where passage_id='$pid'");
		
		if($q1->num_rows()>0)
		{
		 foreach($q1->result() as $row)
		 {
		 $data[]=$row;
		 }
		return $data;
		
		}
}
function get_sectionquestions($sid){

		$q1=$this->db->query("select * from tbl_question where section_id='$sid'");
		
		if($q1->num_rows()>0)
		{
		 foreach($q1->result() as $row)
		 {
		 $data[]=$row;
		 }
		return $data;
		
		}
}

}