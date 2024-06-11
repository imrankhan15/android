<?php
class showanswer extends ci_Controller{

	function index(){
	$id=$_GET['id'];
	$this->load->model('showanswer_model');
	$data['rows']=$this->showanswer_model->getAnswer($id);
	$data['mos']=$this->showanswer_model->getAllQuestion();
	$data['i'][0]=$id;
	$this->load->view('showanswer_view',$data);
	}

}