<?php 

class answer extends ci_Controller{
	 
    function index()
	{
		if($tmp = $this->session->userdata('id')){
			$this->load->model('answer_model');
			if($this->input->get('qd')){
			$qd=$this->input->get('qd');
			$data['rows']=$this->answer_model->getQuestion($qd);
			}
			else{
			$data['rows']=$this->answer_model->getAllQuestions();
			}
			
			$this->load->view('answer_view',$data);
		}
		else {
			redirect("http://www.tstuff.site90.com/server/index.php/login");
		}
	}
	function storeAnswer()
	{
		$this->load->model('answer_model');
		$this->answer_model->insertAnswer();
	}
}
