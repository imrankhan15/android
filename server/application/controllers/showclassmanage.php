<?php
class showclassmanage extends ci_Controller{

	function index(){
	

   }
   function updateClass(){
		$id=$_GET['id'];
		$name=$_POST['name'];
		$data = array(
                'name' => $name
             );

		 $this->db->where('id', $id);
		 $this->db->update('tbl_class', $data);
		 redirect("http://localhost/server/index.php/showclasses");
   
   }
   function deleteClass(){
		$id=$_GET['id'];
		$this->db->delete('tbl_class', array('id' => $id));
		redirect("http://localhost/server/index.php/showclasses");
   }

}