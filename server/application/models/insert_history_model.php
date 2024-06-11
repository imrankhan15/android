<?php

class insert_history_model extends ci_model {

	function insertAnswer($subject,$roll,$passed,$pid,$sid){
	
	$data = array(
	
    'std_id' => $roll ,
    'passed' => $passed,
    'passage_id' => $pid,
	'section_id'=>$sid,
	'subject'=>$subject
	 );

	 $this->db->insert('tbl_testhistory', $data);
    
	}
	function increment($roll){
	$q1=$this->db->query("UPDATE tbl_stdinfo2 SET student_level = student_level+1  WHERE id = '$roll'");
	}
	function insert_feed($roll,$sid,$feedback){
		$data = array(
	
		'section_id' => $sid,
		'details' => $feedback,
		'roll' => $roll
		
		 );
		 $this->db->insert('tbl_review',$data);
	}

}
