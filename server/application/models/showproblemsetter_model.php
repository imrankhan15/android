<?php

class showproblemsetter_model extends ci_model {
function getAllProblemsetter()
	{
		
		$q1=$this->db->query("select * from tbl_probsetterinfo ");
		
		if($q1->num_rows()>0)
		{
		 foreach($q1->result() as $row)
		 {
		 $data[]=$row;
		 }
		return $data;
		
		}
		
	}
	function getProblemsetter($i)
	{
		
		$q1=$this->db->query("select * from tbl_probsetterinfo where id='$i' ");
		
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