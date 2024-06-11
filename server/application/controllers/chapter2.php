<?php 

class chapter2 extends ci_Controller{
		function index()
		{
			if($tmp = $this->session->userdata('id')){
			$subject=$this->input->get('subject');
			$this->load->model('chapter_model');
			$data['rows']=$this->chapter_model->getAllBook($subject);
			$this->load->view('chapter_view2',$data);
			}
			else {
				redirect("http://localhost/server/index.php/login");
			}
		}
}
