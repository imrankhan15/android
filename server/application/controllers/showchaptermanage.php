<?php
class showchaptermanage extends ci_Controller{

	function index(){
	

   }
   function updateChapter(){
		$id=$_GET['id'];
		$bookid=$_POST['bookid'];
		$chaptername=$_POST['chaptername'];
		
		$data = array(
                'bookid' => $bookid,
                'chaptername' => $chaptername
             );

		 $this->db->where('id', $id);
		 $this->db->update('tbl_chapter', $data);
		 redirect("http://localhost/server/index.php/showchapters");
   
   }
   function deleteChapter(){
		$id=$_GET['id'];
		$this->db->delete('tbl_chapter', array('id' => $id));
		redirect("http://localhost/server/index.php/showchapters");
   }

}