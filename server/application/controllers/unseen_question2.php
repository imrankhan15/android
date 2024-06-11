<?php 

class unseen_question2 extends ci_Controller{

    function index()
	{
		if($tmp = $this->session->userdata('id')){
		$this->load->model('unseen_question_model');
		$this->unseen_question_model->insert();
		}
			else {
				redirect("http://localhost/server/index.php/login");
			}
	} 
	
}
