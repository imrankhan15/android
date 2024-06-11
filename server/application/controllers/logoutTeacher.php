<?php 

class logoutTeacher extends ci_Controller{
	function index()
	{
		$this->session->unset_userdata('teacherid');
		redirect("http://localhost/server/index.php/login");
	} 
}