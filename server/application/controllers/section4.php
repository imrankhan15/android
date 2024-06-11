<?php 

class section4 extends ci_Controller{

    function index()
	{
		if($tmp = $this->session->userdata('id')){
		
		$this->load->model('section_model');
		$this->section_model->insert();
		
		}
			else {
				redirect("http://localhost/server/index.php/login");
			}
	} 
	

	
	
	
	
}
