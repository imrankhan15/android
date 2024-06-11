<?php
class showbookmanage extends ci_Controller{

	function index(){
	

   }
   function updateBook(){
		$id=$_GET['id'];
		$bookname=$_POST['bookname'];
		$data = array(
                'book_name' => $bookname
             );

		 $this->db->where('id', $id);
		 $this->db->update('tbl_book', $data);
		 redirect("http://localhost/server/index.php/showbooks");
   
   }
   function deleteBook(){
		$id=$_GET['id'];
		$this->db->delete('tbl_book', array('id' => $id));
		redirect("http://localhost/server/index.php/showbooks");
   }

}