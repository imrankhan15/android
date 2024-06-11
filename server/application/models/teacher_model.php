<?php

class teacher_model extends ci_model {
	function getClass($roll){
		$q1=$this->db->query("select * from tbl_stdinfo2 where id='$roll'");
		
		if($q1->num_rows()>0)
		{
		 foreach($q1->result() as $row)
		 {
		 $data[]=$row;
		 }
		return $data;
		
		}
	}

    function getStudents(){
		$q1=$this->db->query("select * from tbl_stdinfo2");
		
		if($q1->num_rows()>0)
		{
		 foreach($q1->result() as $row)
		 {
		 $data[]=$row;
		 }
		return $data;
		
		}
	}
	
	function getSubjects($classid){
		if($classid==10)$classid=9;
		$q1=$this->db->query("select * from tbl_subject where class_id='$classid'");
		
		if($q1->num_rows()>0)
		{
		 foreach($q1->result() as $row)
		 {
		 $data[]=$row;
		 }
		return $data;
		
		}
	}
	function insertStudent(){
	$id=$_POST['stdid'];
	$mobileno=$_POST['stmb'];
	
	
		$data = array(
		'id' => $id ,
		'phone_num'=>$mobileno
		);

	 $this->db->insert('tbl_stdinfo2', $data);
     redirect("http://localhost/server/index.php/show_student");
	}
	function insertproblemsetter(){
	$id=$_POST['psid'];
	$mobileno=$_POST['psmb'];	
		$data = array(
		'id' => $id ,
		'phone_num'=>$mobileno
		);

	 $this->db->insert('tbl_probsetterinfo', $data);
     redirect("http://localhost/server/index.php/show_problemsetter");
	}
	
	function insertstudentpic(){
	}

}