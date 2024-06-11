<?php 

class freeway_question extends ci_Controller{
	 
    function index()
	{
			if($tmp = $this->session->userdata('id')){
				$this->load->view('freeway_question_view');
				$this->load->model('freeway_question_model');
			}
			else {
				redirect("http://localhost/server/index.php/login");
			}
	}
	function insertQuestion()
	{
	$this->load->model('freeway_question_model');
	 $this->freeway_question_model->insertQuestion();
	}
}
