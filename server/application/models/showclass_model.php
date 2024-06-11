<?php

class showclass_model extends ci_model {
	
	function getAllClass()
	{
		
		$q1=$this->db->query("select * from tbl_class");
		
		if($q1->num_rows()>0)
		{
		 foreach($q1->result() as $row)
		 {
		 $data[]=$row;
		 }
		return $data;
		
		}
		
	}
	
	function getClass($id)
	{
		
		$q1=$this->db->query("select * from tbl_class where id='$id'");
		
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