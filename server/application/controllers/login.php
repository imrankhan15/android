<?php 

class login extends ci_Controller{

    function index()
	{
	
	$this->load->view('login_view');
	$this->load->model('problemsetter_model');
	} 

	
	function check_login()
	{ $this->load->model('problemsetter_model');
		$role=$this->input->post('role');
	    $id=$this->input->post('id');
		if($role==0){
			if($query=$this->problemsetter_model->validateTeacher()){
			$newdata['teacherid']=$id;
			$this->session->set_userdata($newdata);
			redirect("http://localhost/server/index.php/teacherselection");
			}
			else {
				redirect("http://localhost/server/index.php/login");
			}
		}
		else if($role==1){
			if($query=$this->problemsetter_model->validateData()){
			$newdata['id']=$id;
			$this->session->set_userdata($newdata);
			redirect("http://localhost/server/index.php/selection");
			}
			else {
				redirect("http://localhost/server/index.php/login");
			}
		}
		else{
			
		}
		

	}
	
	
	
}


