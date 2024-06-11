<?php

class showanswer_model extends ci_model {
function getAllAnswer()
	{
		
		$q1=$this->db->query("select * from tbl_answer ");
		
		if($q1->num_rows()>0)
		{
		 foreach($q1->result() as $row)
		 {
		 $data[]=$row;
		 }
		return $data;
		
		}
		
	}
	function getAllQuestion(){
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
	function getAnswer($id)
	{
		
		$q1=$this->db->query("select * from tbl_answer where id='$id'");
		
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