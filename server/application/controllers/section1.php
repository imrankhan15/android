<?php 

class section1 extends ci_Controller{

    function index()
	{
			if($tmp = $this->session->userdata('id')){
			$class_id=$_GET['class_id'];
			$this->load->model('book_model');
			$data['rows']=$this->book_model->getAllSubject($class_id);
			$this->load->view('section_view1',$data);
			}
			else {
				redirect("http://localhost/server/index.php/login");
			}
	} 
	

	
	
	
	
}
