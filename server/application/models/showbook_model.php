<?php

class showbook_model extends ci_model {
	
	function getAllBook()
	{
		
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
	
	function getBook($id)
	{
		
		$q1=$this->db->query("select * from tbl_book where id='$id'");
		
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