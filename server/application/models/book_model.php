<?php

class book_model extends ci_model {
function getAllClass(){
$q1=$this->db->query("select * from tbl_class ");
		
		if($q1->num_rows()>0)
		{
		 foreach($q1->result() as $row)
		 {
		 $data[]=$row;
		 }
		return $data;
		
		}
}
function getAllSubject($class_id){
		
		$q1=$this->db->query("select * from tbl_subject where class_id='$class_id'");
		
		if($q1->num_rows()>0)
		{
		 foreach($q1->result() as $row)
		 {
		 $data[]=$row;
		 }
		return $data;
		
		}
}
function insertBookName()
		{
			$subject=$_POST['subject'];
			$bookname=$_POST['bookname'];
			$data = array(
			'subject'=>$subject,
			'book_name' => $bookname
			);

			$this->db->insert('tbl_book', $data);
			redirect("http://localhost/server/index.php/selection");
		}
		
	}

