<?php 

class showanswers extends ci_Controller{
	function index()
	{
		$this->load->model('showanswer_model');
		$data['rows']=$this->showanswer_model->getAllAnswer();
		$this->load->view('showanswers_view',$data);
	}
}
