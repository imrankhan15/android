<?php 

class class1 extends ci_Controller{
	 
    function index()
	{
		if($tmp = $this->session->userdata('id')){
		
		$this->load->view('class_view');
		}
		else {
			redirect("http://localhost/server/index.php/login");
		}
	
	}
	function insert()
	{
		$this->load->model('class_model');
		$this->class_model->insert();
	}
	
}
