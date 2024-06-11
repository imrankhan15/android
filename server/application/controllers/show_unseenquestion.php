<?php 

class show_unseenquestion extends ci_Controller{
	 
    function index()
	{
		$pid=$_GET['pd'];
		$this->load->model('show_model');
		$data['pd'][0]=$pid;
		$data['rows']=$this->show_model->get_passagequestions($pid);
		$this->load->view('show_unseenquestion_view',$data);
	}
	
}