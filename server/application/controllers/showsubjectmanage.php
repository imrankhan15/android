<?php
class showsubjectmanage extends ci_Controller{

	function index(){
	

   }
   function updateSubject(){
		$id=$_GET['id'];
		$class_id=$_POST['class_id'];
		$subject_name=$_POST['subject_name'];
		$data = array(
                'class_id' => $class_id,
				'subject_name' => $subject_name,
             );

		 $this->db->where('id', $id);
		 $this->db->update('tbl_subject', $data);
		 redirect("http://localhost/server/index.php/showsubjects");
   
   }
   function deleteSubject(){
		$id=$_GET['id'];
		$this->db->delete('tbl_subject', array('id' => $id));
		redirect("http://localhost/server/index.php/showsubjects");
   }

}