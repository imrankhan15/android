<?php
class showstudentmanage extends ci_Controller{

	function index(){
	

   }
   function updateStudent(){
		$id=$_GET['id'];
		$phonenum=$_POST['phone_num'];
		$level=$_POST['student_level'];
		$data = array(
                'phone_num' => $phonenum,
				'student_level'=>$level
             );

		 $this->db->where('id', $id);
		 $this->db->update('tbl_stdinfo2', $data);
		 redirect("http://localhost/server/index.php/showstudents");
   
   }
   function deleteStudent(){
		$id=$_GET['id'];
		$this->db->delete('tbl_stdinfo2', array('id' => $id));
		redirect("http://localhost/server/index.php/showstudents");
   }

}