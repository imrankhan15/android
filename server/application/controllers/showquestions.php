<?php 

class showquestions extends ci_Controller{
	function index()
	{
	if($tmp = $this->session->userdata('id')){
		$this->load->model('showquestion_model');
		$data['rows']=$this->showquestion_model->getAllQuestion();
		$this->load->view('showquestions_view',$data);
		 }
		else {
			redirect("http://localhost/server/index.php/login");
		}
	}
}
