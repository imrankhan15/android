<?php

class showpassage_model extends ci_model {
function getAllPassage()
	{
		
		$q1=$this->db->query("select * from tbl_passage ");
		
		if($q1->num_rows()>0)
		{
		 foreach($q1->result() as $row)
		 {
		 $data[]=$row;
		 }
		return $data;
		
		}
		
	}
	function getAllLevel(){
		$q1=$this->db->query("select * from tbl_level ");
		
		if($q1->num_rows()>0)
		{
		 foreach($q1->result() as $row)
		 {
		 $data[]=$row;
		 }
		return $data;
		
		}
	}
	function getPassage($id)
	{
		
		$q1=$this->db->query("select * from tbl_passage where id='$id'");
		
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