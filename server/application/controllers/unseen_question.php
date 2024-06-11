<?php 

class unseen_question extends ci_Controller{

    function index()
	{
		if($tmp = $this->session->userdata('id')){
			$this->load->view('unseen_question_view');
		}
			else {
				redirect("http://localhost/server/index.php/login");
			}
		
	} 
	
}


