<?php 

class insertproblemsetter extends ci_Controller{
	 
    function index()
	{
		if($tmp = $this->session->userdata('teacherid')){
			
			$this->load->view('insertproblemsetter_view');
		}
		else {
			redirect("http://localhost/server/index.php/login");
		}
	}
	function insert()
	{
		$this->load->model('teacher_model');
		$this->teacher_model->insertProblemsetter();
	}
}
