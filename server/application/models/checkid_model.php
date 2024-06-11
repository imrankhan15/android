<?php
class checkid_model extends ci_model {
function checkroll($rollno)
	{
			
			
			if($q1->num_rows()>0)
			{
			 return 1;
			 }
			 else {
			 return 0;
			 }
	}

}