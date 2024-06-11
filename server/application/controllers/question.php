<?php 

class question extends ci_Controller{

    function index()
	{ 
			if($tmp = $this->session->userdata('id')){
			$this->load->view('question_view');
			}
			else {
				redirect("http://localhost/server/index.php/login");
			}
	
		
	}
	function check_type(){
	$type=$this->input->post('type');
		
	    if($type=='seen')
        {
		redirect("http://localhost/server/index.php/seen_question");
		}
		else if($type=='unseen')
        {
		redirect("http://localhost/server/index.php/unseen_question");
		}
		else if($type=='freeway')
        {
		redirect("http://localhost/server/index.php/freeway_question");
		}
	}
}


