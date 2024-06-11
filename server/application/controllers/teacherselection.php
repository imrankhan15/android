<?php 

class teacherselection extends ci_Controller{
	 
    function index()
	{
		$this->load->model('teacher_model');
		$data['rows']=$this->teacher_model->getStudents();
		
		$this->load->view('teacherselection_view',$data);
	}
	function insert()
	{
	 $rsctype=$this->input->post('rsctype');
				
				if($rsctype=="problemsetter")
				{
				
				redirect("http://localhost/server/index.php/insertproblemsetter");
				}				 
				
				elseif($rsctype=="student")
				{
				redirect("http://localhost/server/index.php/insertstudent");
				
				}
	}
	function show()
	{
				$rsctype=$this->input->post('rsctype');
				
				if($rsctype=="problemsetter")
				{
				
				redirect("http://localhost/server/index.php/showproblemsetters");
				}				 
				
				elseif($rsctype=="student")
				{
				redirect("http://localhost/server/index.php/showstudents");
				
				}
	}
	
	function showResult()
	{	
		$roll=$_POST['roll'];	
		$this->load->model('teacher_model');
		$data['rows']=$this->teacher_model->getClass($roll);
		$class_id=$data['rows'][0]->class_name;
		$data['rows']=$this->teacher_model->getSubjects($class_id);
		$data['roll'][0]=$roll;
		$this->load->view('getResult_view',$data);
			
	}
	function showResult2()
	{	
		$roll=$_POST['roll'];
		$subject=$_POST['subject'];
		$query1=$this->db->query("select count(*) as total_test from tbl_chapter where bookid in(select id from tbl_book where subject='$subject')");
		$data['total_test'][0]=$query1->result()[0]->total_test;
		$query2=$this->db->query("SELECT count( * ) AS passedtest FROM tbl_testhistory WHERE std_id = '$roll' AND subject = '$subject' AND passed =1");
		$data['passed'][0]=$query2->result()[0]->passedtest;
		$this->load->view('result',$data);
			
	}
	
	
}
