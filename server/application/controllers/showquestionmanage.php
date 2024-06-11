<?php
class showquestionmanage extends ci_Controller{

	function index(){
	

   }
   function updateQuestion(){
   if($tmp = $this->session->userdata('id')){
		$id=$_GET['id'];
		$pid=$_POST['pid'];
		$sid=$_POST['sid'];
		$question=$_POST['question'];
		$data = array(
                'passage_id' => $pid,
				'section_id' => $sid,
                'question_text' => $question
             );

		 $this->db->where('id', $id);
		 $this->db->update('tbl_question', $data);
		 redirect("http://localhost/server/index.php/showquestions");
		 }
		else {
			redirect("http://localhost/server/index.php/login");
		}
   
   }
   function deleteQuestion(){
   if($tmp = $this->session->userdata('id')){
		$id=$_GET['id'];
		$this->db->delete('tbl_question', array('id' => $id));
		redirect("http://localhost/server/index.php/showquestions");
		}
		else {
			redirect("http://localhost/server/index.php/login");
		}
   }

}