<?php
class showsectionmanage extends ci_Controller{

	function index(){
	

   }
   function updateSection(){
   if($tmp = $this->session->userdata('id')){
		$id=$_GET['id'];
		$chap_id=$_POST['chap_id'];
		$startpage=$_POST['startpage'];
		$endpage=$_POST['endpage'];
		$level=$_POST['level'];
		$section_name=$_POST['section_name'];
		$data = array(
                'chap_id' => $chap_id,
                'startpage' => $startpage,
                'endpage' => $endpage,
				'section_level'=>$level,
				'section_name'=>$section_name
             );

		 $this->db->where('id', $id);
		 $this->db->update('tbl_section', $data);
		 redirect("http://localhost/server/index.php/showsections");
		 }
		else {
			redirect("http://localhost/server/index.php/login");
		}
   
   }
   function deleteSection(){
   if($tmp = $this->session->userdata('id')){
		$id=$_GET['id'];
		$this->db->delete('tbl_section', array('id' => $id));
		redirect("http://localhost/server/index.php/showsections");
		}
		else {
			redirect("http://localhost/server/index.php/login");
		}
   }

}