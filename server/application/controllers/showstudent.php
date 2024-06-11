<?php
class showstudent extends ci_Controller{

	function index(){
		$id=$_GET['id'];
		$this->load->model('showstudent_model');
		$data['rows']=$this->showstudent_model->getStudent($id);
		$data['mows']=$this->showstudent_model->getLevel();
		$data['i'][0]=$id;
		$this->load->view('showstudent_view',$data);
	}

}