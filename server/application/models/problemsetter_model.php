<?php

class problemsetter_model extends ci_model {

function validateData()
	{
		$id=$this->input->post('id');
		$q1=$this->db->query("select * from tbl_probsetterinfo where id='$id'");
		
		if($q1->num_rows()>0)
		{
		 foreach($q1->result() as $row)
		 {
		 $data[]=$row;
		 }
		return $data;
		
		}
		
	}
	function validateTeacher()
	{
		$id=$this->input->post('id');
		$q1=$this->db->query("select * from tbl_teacherinfo where id='$id'");
		
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


