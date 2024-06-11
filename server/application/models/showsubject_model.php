<?php

class showsubject_model extends ci_model {
	
	function getAllSubject()
	{
		
		$q1=$this->db->query("select * from tbl_subject");
		
		if($q1->num_rows()>0)
		{
		 foreach($q1->result() as $row)
		 {
		 $data[]=$row;
		 }
		return $data;
		
		}
		
	}
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
	function getSubject($id)
	{
		
		$q1=$this->db->query("select * from tbl_subject where id='$id'");
		
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