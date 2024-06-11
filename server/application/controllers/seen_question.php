<?php 
class seen_question extends ci_Controller{

    function index()
	{
		if($tmp = $this->session->userdata('id')){
		$this->load->model('book_model');
		$data['rows']=$this->book_model->getAllClass();
		$this->load->view('seen_question_view',$data);
		}
			else {
				redirect("http://localhost/server/index.php/login");
			}
		
	} 
}


