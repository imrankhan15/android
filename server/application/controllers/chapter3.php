<?php 

class chapter3 extends ci_Controller{
		function index()
		{
			if($tmp = $this->session->userdata('id')){
			
			$this->load->model('chapter_model');
			$this->chapter_model->insert();
			
			}
			else {
				redirect("http://localhost/server/index.php/login");
			}
		}
}
