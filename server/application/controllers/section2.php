<?php 

class section2 extends ci_Controller{

    function index()
	{
	if($tmp = $this->session->userdata('id')){
	$subject=$_GET['subject'];
	$this->load->model('chapter_model');
	$data['rows1']=$this->chapter_model->getAllBook($subject);
	$this->load->view('section_view2',$data);
	}
			else {
				redirect("http://localhost/server/index.php/login");
			}
	} 
	

	
	
	
	
}
