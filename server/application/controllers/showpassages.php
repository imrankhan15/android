<?php 

class showpassages extends ci_Controller{
	function index()
	{
	if($tmp = $this->session->userdata('id')){
		$this->load->model('showpassage_model');
		$data['rows']=$this->showpassage_model->getAllPassage();
		$this->load->view('showpassages_view',$data);
		}
		else {
			redirect("http://localhost/server/index.php/login");
		}
	}
}