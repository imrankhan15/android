<?php 

class logout extends ci_Controller{
	function index()
	{
		$this->session->unset_userdata('id');
		redirect("http://localhost/server/index.php/login");
	} 
}