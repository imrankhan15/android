<?php 

class showchapters extends ci_Controller{
	function index()
	{
		$this->load->model('showchapter_model');
		$data['rows']=$this->showchapter_model->getAllChapter();
		$this->load->view('showchapters_view',$data);
	}
}
