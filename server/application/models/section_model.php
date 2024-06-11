<?php

class section_model extends ci_model {

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
	function getAllChapter($book_id){
		$q1=$this->db->query("select * from tbl_chapter where  bookid='$book_id' ");
		
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
	$chap_id=$_POST['chap_id'];
	$sPage=$_POST['sPage'];
	$ePage=$_POST['ePage'];
	$level=$_POST['level'];
	$section_name=$_POST['sName'];
	$data = array(
    'chap_id' => $chap_id ,
    'startpage' => $sPage,
    'endpage' => $ePage,
	'section_level'=>$level,
	'section_name'=>$section_name
	);

	 $this->db->insert('tbl_section', $data);
	redirect("http://localhost/server/index.php/selection");
	}
}


