<?php 

class showsubjects extends ci_Controller{
	function index()
	{
		$this->load->model('showsubject_model');
		$data['rows']=$this->showsubject_model->getAllSubject();
		$this->load->view('showsubjects_view',$data);
	}
}
