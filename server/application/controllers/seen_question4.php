<?php 
class seen_question4 extends ci_Controller{

    function index()
	{
	if($tmp = $this->session->userdata('id')){
		
		$this->load->model('seen_question_model');
			if($this->input->get('sd')){
			$sid=$this->input->get('sd');
			$data['rows1']=$this->seen_question_model->getSection($sid);
			}
			else{
			$chap_id=$_GET['chap_id'];
			$data['rows1']=$this->seen_question_model->getAllSection($chap_id);
			}
		
		$this->load->view('seen_question_view4',$data);
	}
			else {
				redirect("http://localhost/server/index.php/login");
			}
		
	} 
}
