<?php

class showsection_model extends ci_model {
function getAllSection()
	{
		
		$q1=$this->db->query("select * from tbl_section ");
		
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
	function getAllChapter(){
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
	function getSection($id)
	{
		
		$q1=$this->db->query("select * from tbl_section where id='$id'");
		
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