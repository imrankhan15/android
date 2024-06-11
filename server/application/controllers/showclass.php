<?php
class showclass extends ci_Controller{

	function index(){
		$id=$_GET['id'];
		$this->load->model('showclass_model');
		$data['rows']=$this->showclass_model->getClass($id);
		$data['i'][0]=$id;
		$this->load->view('showclass_view',$data);
	}

}