<?php

class showchapter_model extends ci_model {
function getAllChapter()
	{
		
		$q1=$this->db->query("select * from tbl_chapter ");
		
		if($q1->num_rows()>0)
		{
		 foreach($q1->result() as $row)
		 {
		 $data[]=$row;
		 }
		return $data;
		
		}
		
	}
	
	function getAllBook(){
		$q1=$this->db->query("select * from tbl_book ");
		
		if($q1->num_rows()>0)
		{
		 foreach($q1->result() as $row)
		 {
		 $data[]=$row;
		 }
		return $data;
		
		}
	}
	function getChapter($id)
	{
		
		$q1=$this->db->query("select * from tbl_chapter where id='$id'");
		
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