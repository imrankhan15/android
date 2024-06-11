<?php

class chapter_model extends ci_model {

 function getAllBook($subject){
		$q1=$this->db->query("select * from tbl_book where  subject='$subject' ");
		
		if($q1->num_rows()>0)
		{
		 foreach($q1->result() as $row)
		 {
		 $data[]=$row;
		 }
		return $data;
		
		}
	}
				
		
function insert(){
		
		$bookId=$_POST['book_id'];
		$chap_name=$_POST['chapter_name'];
		$data = array(
		'bookid'=>$bookId,
		'chaptername' => $chap_name
		 );

	    $this->db->insert('tbl_chapter', $data);
		redirect("http://localhost/server/index.php/selection");
		
		}
		
	}