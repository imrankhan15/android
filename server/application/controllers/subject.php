<?php 

class subject extends ci_Controller{
	 
    function index()
	{
		if($tmp = $this->session->userdata('id')){
		$this->load->model('book_model');
		$data['rows']=$this->book_model->getAllClass();
		$this->load->view('subject_view',$data);
		}
		else {
			redirect("http://localhost/server/index.php/login");
		}
	
	}
	function insert()
	{
		$this->load->model('subject_model');
		$this->subject_model->insert();
	}
	
}
