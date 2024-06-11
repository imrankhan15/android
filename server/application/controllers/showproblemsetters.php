<?php 

class showproblemsetters extends ci_Controller{
	function index()
	{
		$this->load->model('showproblemsetter_model');
		$data['rows']=$this->showproblemsetter_model->getAllProblemsetter();
		$this->load->view('showproblemsetters_view',$data);
	}
}
