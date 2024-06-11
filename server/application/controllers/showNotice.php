<?php 

class showNotice extends ci_Controller{
	 
    function index()
	{
		if($tmp = $this->session->userdata('id')){
		
		$this->load->view('notice_view');
		}
		else {
			redirect("http://localhost/server/index.php/login");
		}
		
	}
	
}