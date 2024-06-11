<?php 

class selection extends ci_Controller{
	
		function index()
		{
		if($tmp = $this->session->userdata('id')){
			$this->load->view('selection_view');
			}
			else {
				redirect("http://localhost/server/index.php/login");
			}
			
		
		}
		function insert(){
		 $rsctype=$this->input->post('rsctype');
				
				if($rsctype=="section")
				{
				
				redirect("http://localhost/server/index.php/section");
				}				 
				
				elseif($rsctype=="subject")
				{
				redirect("http://localhost/server/index.php/subject");
				
				}
				elseif($rsctype=="class")
				{
				redirect("http://localhost/server/index.php/class1");
				
				}
					
				elseif($rsctype=="question")
				{
				redirect("http://localhost/server/index.php/question");
				}
				elseif($rsctype=="answer")
				{
				redirect("http://localhost/server/index.php/answer");
				}
				elseif($rsctype=="book")
				{
				redirect("http://localhost/server/index.php/book");
				}
				elseif($rsctype=="chapter")
				{
				redirect("http://localhost/server/index.php/chapter");
				}
		}
		function show(){
			 $rsctype=$this->input->post('rsctype');
				
				if($rsctype=="section")
				{
				
				redirect("http://localhost/server/index.php/showsections");
				}				 
				
				elseif($rsctype=="subject")
				{
				redirect("http://localhost/server/index.php/showsubjects");
				
				}
				elseif($rsctype=="class")
				{
				redirect("http://localhost/server/index.php/showclasses");
				
				}
					
				elseif($rsctype=="question")
				{
				redirect("http://localhost/server/index.php/showquestions");
				}
				elseif($rsctype=="answer")
				{
				redirect("http://localhost/server/index.php/showanswers");
				}
				elseif($rsctype=="book")
				{
				redirect("http://localhost/server/index.php/showbooks");
				}
				elseif($rsctype=="chapter")
				{
				redirect("http://localhost/server/index.php/showchapters");
				}
		}
		
	
	}

