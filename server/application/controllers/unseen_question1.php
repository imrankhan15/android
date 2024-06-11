<?php 

class unseen_question1 extends ci_Controller{

    function index()
	{
	if($tmp = $this->session->userdata('id')){
	
	$this->load->model('unseen_question_model');
	
		if($this->input->get('pd')){
		$pd=$this->input->get('pd');
			$data['rows']=$this->unseen_question_model->getPassage($pd);
			
		}
		else{
		$subject=$this->input->get('subject');
		$data['rows']=$this->unseen_question_model->getAllPassage();
		}
	
	
	$this->load->view('unseen_question_view1',$data);
	}
			else {
				redirect("http://localhost/server/index.php/login");
			}
	
	} 
	
}
