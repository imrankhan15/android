<?php

class class_model extends ci_model {

function insert()
		{
			$id=$_POST['id'];
			$name=$_POST['name'];
			$data = array(
			'id'=>$id,
			'name' => $name
			);

			$this->db->insert('tbl_class', $data);
			redirect("http://localhost/server/index.php/selection");
		}
		
	}

