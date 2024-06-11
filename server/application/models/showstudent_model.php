<?php

class showstudent_model extends ci_model {
function getAllStudent()
	{
		
		$q1=$this->db->query("select * from tbl_stdinfo2 ");
		
		if($q1->num_rows()>0)
		{
		 foreach($q1->result() as $row)
		 {
		 $data[]=$row;
		 }
		return $data;
		
		}
		
	}
	
	function getStudent($id)
	{
		
		$q1=$this->db->query("select * from tbl_stdinfo2 where id='$id'");
		
		if($q1->num_rows()>0)
		{
		 foreach($q1->result() as $row)
		 {
		 $data[]=$row;
		 }
		return $data;
		
		}
		
	}
	function getLevel(){
		$q1=$this->db->query("select * from tbl_level");
		
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