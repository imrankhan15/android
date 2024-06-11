<?php 

class showbooks extends ci_Controller{
	function index()
	{
		$this->load->model('showbook_model');
		$data['rows']=$this->showbook_model->getAllBook();
		$this->load->view('showbooks_view',$data);
	}
}
