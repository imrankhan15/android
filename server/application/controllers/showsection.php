<?php
class showsection extends ci_Controller{

	function index(){
	if($tmp = $this->session->userdata('id')){
			$id=$_GET['id'];
			$this->load->model('showsection_model');
			$data['rows']=$this->showsection_model->getSection($id);
			$data['mos']=$this->showsection_model->getAllLevel();
			$data['nos']=$this->showsection_model->getAllChapter();
			$data['i'][0]=$id;
			$this->load->view('showsection_view',$data);
	 }
		else {
			redirect("http://localhost/server/index.php/login");
		}
	}

}