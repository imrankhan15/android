<?php
class showbook extends ci_Controller{

	function index(){
		$id=$_GET['id'];
		$this->load->model('showbook_model');
		$data['rows']=$this->showbook_model->getBook($id);
		$data['i'][0]=$id;
		$this->load->view('showbook_view',$data);
	}

}