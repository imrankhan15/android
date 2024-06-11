<?php
class showquestion extends ci_Controller{

	function index(){
		if($tmp = $this->session->userdata('id')){
		$id=$_GET['id'];
		$this->load->model('showquestion_model');
		$data['rows']=$this->showquestion_model->getQuestion($id);
		$data['mos']=$this->showquestion_model->getAllPassage();
		$data['nos']=$this->showquestion_model->getAllSection();
		$data['i'][0]=$id;
		$this->load->view('showquestion_view',$data);
		}
		else {
			redirect("http://localhost/server/index.php/login");
		}
	}

}