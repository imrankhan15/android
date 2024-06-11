<?php
class showsubject extends ci_Controller{

	function index(){
		$id=$_GET['id'];
		$this->load->model('showsubject_model');
		$data['rows']=$this->showsubject_model->getSubject($id);
		$data['mows']=$this->showsubject_model->getAllClass();
		$data['i'][0]=$id;
		$this->load->view('showsubject_view',$data);
	}

}