<?php
class showproblemsettermanage extends ci_Controller{

	function index(){
	

   }
   function updateProblemsetter(){
		$id=$_GET['id'];
		$phonenum=$_POST['phone_num'];
		
		$data = array(
                'phone_num' => $phonenum
				
             );

		 $this->db->where('id', $id);
		 $this->db->update('tbl_probsetterinfo', $data);
		 redirect("http://localhost/server/index.php/showproblemsetters");
   
   }
   function deleteProblemsetter(){
		$id=$_GET['id'];
		$this->db->delete('tbl_probsetterinfo', array('id' => $id));
		redirect("http://localhost/server/index.php/showproblemsetters");
   }

}