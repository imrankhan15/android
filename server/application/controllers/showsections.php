<?php 

class showsections extends ci_Controller{
	function index()
	{
	if($tmp = $this->session->userdata('id')){
		$this->load->model('showsection_model');
		$data['rows']=$this->showsection_model->getAllSection();
		$this->load->view('showsections_view',$data);
		 }
		else {
			redirect("http://localhost/server/index.php/login");
		}
	}
}
