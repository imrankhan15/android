<?php 
class seen_question5 extends ci_Controller{

    function index()
	{
		if($tmp = $this->session->userdata('id')){
		$this->load->model('seen_question_model');
		$this->seen_question_model->insert();
		}
			else {
				redirect("http://localhost/server/index.php/login");
			}
		
	} 
}
