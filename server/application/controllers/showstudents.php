<?php 

class showstudents extends ci_Controller{
	function index()
	{
		$this->load->model('showstudent_model');
		$data['rows']=$this->showstudent_model->getAllStudent();
		$this->load->view('showstudents_view',$data);
	}
}
