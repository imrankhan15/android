<?php
class showanswermanage extends ci_Controller{

	function index(){
	

   }
   function updateAnswer(){
		$id=$_GET['id'];
		$qid=$_POST['qid'];
		$answer=$_POST['answer'];
		$realanswer=$_POST['real'];
		$data = array(
                'qid' => $qid,
                'text_ans' => $answer,
                'realanswer' => $realanswer
             );

		 $this->db->where('id', $id);
		 $this->db->update('tbl_answer', $data);
		 redirect("http://localhost/server/index.php/showanswers");
   
   }
   function deleteAnswer(){
		$id=$_GET['id'];
		$this->db->delete('tbl_answer', array('id' => $id));
		redirect("http://localhost/server/index.php/showanswers");
   }

}