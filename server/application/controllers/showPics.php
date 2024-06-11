<?php 

class showPics extends ci_Controller{
	 
    function index()
	{
		if($tmp = $this->session->userdata('teacherid')){
			
			$this->load->view('showstudentpicture_view');
		}
		else {
			redirect("http://localhost/server/index.php/login");
		}
	}
	
}