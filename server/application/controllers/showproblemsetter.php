<?php
class showproblemsetter extends ci_Controller{

	function index(){
		$id=$_GET['id'];
		$this->load->model('showproblemsetter_model');
		$data['rows']=$this->showproblemsetter_model->getProblemsetter($id);
		$data['i'][0]=$id;
		$this->load->view('showproblemsetter_view',$data);
	}

}