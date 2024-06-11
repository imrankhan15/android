<?php 

class passage extends ci_Controller{

    function index()
	{
			if($tmp = $this->session->userdata('id')){
			$this->load->view('passage_view');
			}
			else {
				redirect("http://localhost/server/index.php/login");
			}
	
	} 
	function insertPassage()
	{
	$this->load->model('passage_model');
	$this->passage_model->insertPassage();
	}
}


