<?php 

class insert_history extends ci_Controller{
	 
    function index()
	{
		echo json_encode($data);
		$subject=$_POST['subject'];
		$roll=$_POST['roll'];
		$passed=$_POST['passed'];
		$pid=$_POST['pid'];
		$sid=$_POST['sid'];
		$feedback=$_POST['feedback'];

		$this->load->model('insert_history_model');
		$this->insert_history_model->insertAnswer($subject,$roll,(int)$passed,(int)$pid,(int)$sid);
		if((int)$passed==1)$this->insert_history_model->increment($roll);
		$this->insert_history_model->insert_feed($roll,$sid,$feedback);
	
	}
	
}