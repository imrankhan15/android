<?php 

class show_seenquestions extends ci_Controller{
	 
    function index()
	{
		$sid=$_GET['sid'];
		$this->load->model('show_model');
		$data['sd'][0]=$sid;
		$data['rows']=$this->show_model->get_sectionquestions($sid);
		$this->load->view('show_seenquestion_view',$data);
	}
	
}
