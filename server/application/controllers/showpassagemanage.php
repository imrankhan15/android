<?php
class showpassagemanage extends ci_Controller{

	function index(){
	

   }
   function updatePassage(){
   if($tmp = $this->session->userdata('id')){
		$id=$_GET['id'];
		$level=$_POST['level'];
		$text=$_POST['text'];
		$data = array(
                'level' => $level,
                'text' => $text
             );

		 $this->db->where('id', $id);
		 $this->db->update('tbl_passage', $data);
		 redirect("http://localhost/server/index.php/showpassages");
		 }
		else {
			redirect("http://localhost/server/index.php/login");
		}
   
   }
   function deletePassage(){
    if($tmp = $this->session->userdata('id')){
		$id=$_GET['id'];
		$this->db->delete('tbl_passage', array('id' => $id));
		redirect("http://localhost/server/index.php/showpassages");
		}
		else {
			redirect("http://localhost/server/index.php/login");
		}
   }

}