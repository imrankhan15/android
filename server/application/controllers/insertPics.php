<?php 

class insertPics extends ci_Controller{
	 
    function index()
	{
		if($tmp = $this->session->userdata('teacherid')){
			$this->load->model('teacher_model');
			$data['rows']=$this->teacher_model->getStudents();
			$this->load->view('insertstudentPicture_view',$data);
		}
		else {
			redirect("http://localhost/server/index.php/login");
		}
	}
	function insert()
	{
		if ($_FILES["file"]["error"] > 0)
		   {
		   echo "Error: " . $_FILES["file"]["error"] . "<br>";
		   }
		 else
		   {
		   echo "Upload: " . $_FILES["file"]["name"] . "<br>";
		   echo "Type: " . $_FILES["file"]["type"] . "<br>";
		   echo "Size: " . ($_FILES["file"]["size"] / 1024) . " kB<br>";
		   echo "Stored in: " . $_FILES["file"]["tmp_name"];
		   $path = $_POST['stdid'];

			if ( ! is_dir($path)) {
				mkdir($path);
			}
		    if (file_exists($path."/" . $_FILES["file"]["name"]))
			   {
			   echo $_FILES["file"]["name"] . " already exists. ";
			   }
			 else
			   {
			   move_uploaded_file($_FILES["file"]["tmp_name"],
			   $path."/" . $_FILES["file"]["name"]);
			   echo "Stored in: " . $path."/" . $_FILES["file"]["name"];
			   print "<form method=post action='http://localhost/server/index.php/teacherselection'>";
				print "<input type=submit name=page1submit value='Back' >";
				print "</form>";
			   }
		   }
		   
		
	}
}