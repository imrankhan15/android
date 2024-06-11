<?php 

class insertstudent extends ci_Controller{
	 
    function index()
	{
		if($tmp = $this->session->userdata('teacherid')){
			
			$this->load->view('insertstudent_view');
		}
		else {
			redirect("http://localhost/server/index.php/login");
		}
	}
	function insert()
	{
		$this->load->model('teacher_model');
		$this->teacher_model->insertStudent();
	}
}
