<?php 

class section3 extends ci_Controller{

    function index()
	{
		if($tmp = $this->session->userdata('id')){
		$book=$_GET['book'];
		$this->load->model('section_model');
		$data['rows']=$this->section_model->getAllChapter($book);
		$this->load->view('section_view3',$data);
		}
			else {
				redirect("http://localhost/server/index.php/login");
			}
	} 
	

	
	
	
	
}
