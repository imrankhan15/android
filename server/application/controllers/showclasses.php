<?php 

class showclasses extends ci_Controller{
	function index()
	{
		$this->load->model('showclass_model');
		$data['rows']=$this->showclass_model->getAllClass();
		$this->load->view('showclasses_view',$data);
	}
}
