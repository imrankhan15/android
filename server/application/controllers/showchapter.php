<?php
class showchapter extends ci_Controller{

	function index(){
		$id=$_GET['id'];
		$this->load->model('showchapter_model');
		$data['rows']=$this->showchapter_model->getChapter($id);
		$data['mos']=$this->showchapter_model->getAllBook();
		$data['i'][0]=$id;
		$this->load->view('showchapter_view',$data);
	}

}