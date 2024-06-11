<?php

class subject_model extends ci_model {

function insert()
		{
			$id=$_POST['id'];
			$class_id=$_POST['class_id'];
			$name=$_POST['name'];
			$data = array(
			'id'=>$id,
			'class_id' => $class_id,
			'subject_name'=>$name
			);

			$this->db->insert('tbl_subject', $data);
			redirect("http://localhost/server/index.php/selection");
		}
		
	}

