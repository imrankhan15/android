<?php
class showpassage extends ci_Controller{

	function index(){
	$id=$_GET['id'];
	$this->load->model('showpassage_model');
	$data['rows']=$this->showpassage_model->getPassage($id);
	$data['mos']=$this->showpassage_model->getAllLevel();
	$data['i'][0]=$id;
	$this->load->view('showpassage_view',$data);
	}

}