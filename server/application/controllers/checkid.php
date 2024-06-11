<?php 

class checkid extends ci_Controller{
	 
    function index()
	{
		
		$rollno=$_POST['rollno'];
		$q1=$this->db->query("select * from tbl_stdinfo2 where id='$rollno'");
		if($q1->num_rows()>0)
			{
			 $a=$q1->result();
			 $class_name=$a[0]->class_name;
			 }
			 else {
			 $class_name=0;
			 }	
		
		
		$response = array("success" => $class_name);
		
		// echo($response["success"]);
		 echo json_encode($response);
	
	}
	
}