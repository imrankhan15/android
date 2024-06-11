<?php 

class section extends ci_Controller{

    function index()
	{
			if($tmp = $this->session->userdata('id')){
			$this->load->model('book_model');
			$data['rows']=$this->book_model->getAllClass();
			$this->load->view('section_view',$data);
			}
			else {
				redirect("http://localhost/server/index.php/login");
			}
	} 
	

	
	
	
	
}


