<?php 

class show_answer extends ci_Controller{
	 
    function index()
	{
		$qid=$_GET['qid'];
		$this->load->model('show_model');
		$data['qd'][0]=$qid;
		$data['rows']=$this->show_model->get_answers($qid);
		$this->load->view('show_ans_view',$data);
	}
	
}
