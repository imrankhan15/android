<?php 

class getQuestionList extends ci_Controller{
	 
    function index()
	{
		
		$roll=$_GET['roll'];
		$type=$_GET['type'];
		
		$this->load->model('list_model');
		if($type=='unseen'){
			if($data['rows']=$this->list_model->get_passage($roll)){
			
				$a=$data['rows'][0]->text;
				$b=$data['rows'][0]->id;
				print("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
				print("<testlist>\n");
				print("<test>\n");
				$subject='EnglishReading';
				print("<subject>$subject</subject>\n");
				print("<roll>$roll</roll>\n");
				print("<pid>$b</pid>\n");
				print("<sid>1</sid>\n");
				print("<bookname>'nobook'</bookname>\n");
				print("<chaptername>'nochapter'</chaptername>\n");
				print("<startpage>0</startpage>\n");
				print("<endpage>0</endpage>\n");
				print("<passage>$a</passage>\n");
				
				
				$id=$data['rows'][0]->id;
				$pid=$data['rows'][0]->id;
				$data1['rows2']=$this->list_model->get_passagequestion($id);
				
				$a=$data1['rows2'][0]->question_text;
				print("<question1>$a</question1>\n");
				$a=$data1['rows2'][1]->question_text;
				print("<question2>$a</question2>\n");
				$a=$data1['rows2'][2]->question_text;
				print("<question3>$a</question3>\n");
				$a=$data1['rows2'][3]->question_text;
				print("<question4>$a</question4>\n");
				
				$id=$data1['rows2'][0]->id;
				$data2['rows3']=$this->list_model->get_answer($id);
				$a=$data2['rows3'][0]->text_ans;
				$b=$data2['rows3'][0]->realanswer;
				print("<answertext11>$a</answertext11>\n");
				print("<answerreal11>$b</answerreal11>\n");
				$a=$data2['rows3'][1]->text_ans;
				$b=$data2['rows3'][1]->realanswer;
				print("<answertext12>$a</answertext12>\n");
				print("<answerreal12>$b</answerreal12>\n");
				$a=$data2['rows3'][2]->text_ans;
				$b=$data2['rows3'][2]->realanswer;
				print("<answertext13>$a</answertext13>\n");
				print("<answerreal13>$b</answerreal13>\n");
				$a=$data2['rows3'][3]->text_ans;
				$b=$data2['rows3'][3]->realanswer;
				print("<answertext14>$a</answertext14>\n");
				print("<answerreal14>$b</answerreal14>\n");
				
				$id=$data1['rows2'][1]->id;
				$data2['rows3']=$this->list_model->get_answer($id);
				$a=$data2['rows3'][0]->text_ans;
				$b=$data2['rows3'][0]->realanswer;
				print("<answertext21>$a</answertext21>\n");
				print("<answerreal21>$b</answerreal21>\n");
				$a=$data2['rows3'][1]->text_ans;
				$b=$data2['rows3'][1]->realanswer;
				print("<answertext22>$a</answertext22>\n");
				print("<answerreal22>$b</answerreal22>\n");
				$a=$data2['rows3'][2]->text_ans;
				$b=$data2['rows3'][2]->realanswer;
				print("<answertext23>$a</answertext23>\n");
				print("<answerreal23>$b</answerreal23>\n");
				$a=$data2['rows3'][3]->text_ans;
				$b=$data2['rows3'][3]->realanswer;
				print("<answertext24>$a</answertext24>\n");
				print("<answerreal24>$b</answerreal24>\n");
				
				$id=$data1['rows2'][2]->id;
				$data2['rows3']=$this->list_model->get_answer($id);
				$a=$data2['rows3'][0]->text_ans;
				$b=$data2['rows3'][0]->realanswer;
				print("<answertext31>$a</answertext31>\n");
				print("<answerreal31>$b</answerreal31>\n");
				$a=$data2['rows3'][1]->text_ans;
				$b=$data2['rows3'][1]->realanswer;
				print("<answertext32>$a</answertext32>\n");
				print("<answerreal32>$b</answerreal32>\n");
				$a=$data2['rows3'][2]->text_ans;
				$b=$data2['rows3'][2]->realanswer;
				print("<answertext33>$a</answertext33>\n");
				print("<answerreal33>$b</answerreal33>\n");
				$a=$data2['rows3'][3]->text_ans;
				$b=$data2['rows3'][3]->realanswer;
				print("<answertext34>$a</answertext34>\n");
				print("<answerreal34>$b</answerreal34>\n");
				
				$id=$data1['rows2'][3]->id;
				$data2['rows3']=$this->list_model->get_answer($id);
				$a=$data2['rows3'][0]->text_ans;
				$b=$data2['rows3'][0]->realanswer;
				print("<answertext41>$a</answertext41>\n");
				print("<answerreal41>$b</answerreal41>\n");
				$a=$data2['rows3'][1]->text_ans;
				$b=$data2['rows3'][1]->realanswer;
				print("<answertext42>$a</answertext42>\n");
				print("<answerreal42>$b</answerreal42>\n");
				$a=$data2['rows3'][2]->text_ans;
				$b=$data2['rows3'][2]->realanswer;
				print("<answertext43>$a</answertext43>\n");
				print("<answerreal43>$b</answerreal43>\n");
				$a=$data2['rows3'][3]->text_ans;
				$b=$data2['rows3'][3]->realanswer;
				print("<answertext44>$a</answertext44>\n");
				print("<answerreal44>$b</answerreal44>\n");
				
				print("</test>\n");
				print("</testlist>\n");
			}
			else{
			$data[rows]=$this->list_model->getLevel($roll);
			$level=$data[rows][0]->student_level;
			$this->list_model->insertPassageNotice($level);
			}
		}
		else if($type=='seen'){
			$chap_id=$_GET['chap_id'];
			$data['rows1']=$this->list_model->get_subject($chap_id);
			$subject=$data['rows1'][0]->subject;
			if($data['rows']=$this->list_model->get_section($roll,$chap_id)){
			
				$a1=$data['rows'][0]->startpage;
				$a2=$data['rows'][0]->endpage;
				$b=$data['rows'][0]->id;
				$c=$data['rows'][0]->chap_id;
				$data3['rows4']=$this->list_model->getChapter($c);
				$d=$data3['rows4'][0]->bookid;
				$e=$data3['rows4'][0]->chaptername;
				$data4['rows5']=$this->list_model->getBook($d);
				$f=$data4['rows5'][0]->book_name;
				print("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n");
				print("<testlist>\n");
				print("<test>\n");
				print("<subject>$subject</subject>\n");
				print("<roll>$roll</roll>\n");
				print("<sid>$b</sid>\n");
				print("<pid>4</pid>\n");
				print("<bookname>$f</bookname>\n");
				print("<chaptername>$e</chaptername>\n");
				print("<startpage>$a1</startpage>\n");
				print("<endpage>$a2</endpage>\n");
				print("<passage>'notext'</passage>\n");
				$id=$data['rows'][0]->id;
				
				$data1['rows2']=$this->list_model->get_sectionquestion($id);
				
				$a=$data1['rows2'][0]->question_text;
				print("<question1>$a</question1>\n");
				$a=$data1['rows2'][1]->question_text;
				print("<question2>$a</question2>\n");
				$a=$data1['rows2'][2]->question_text;
				print("<question3>$a</question3>\n");
				$a=$data1['rows2'][3]->question_text;
				print("<question4>$a</question4>\n");
				
				$id=$data1['rows2'][0]->id;
				$data2['rows3']=$this->list_model->get_answer($id);
				$a=$data2['rows3'][0]->text_ans;
				$b=$data2['rows3'][0]->realanswer;
				print("<answertext11>$a</answertext11>\n");
				print("<answerreal11>$b</answerreal11>\n");
				$a=$data2['rows3'][1]->text_ans;
				$b=$data2['rows3'][1]->realanswer;
				print("<answertext12>$a</answertext12>\n");
				print("<answerreal12>$b</answerreal12>\n");
				$a=$data2['rows3'][2]->text_ans;
				$b=$data2['rows3'][2]->realanswer;
				print("<answertext13>$a</answertext13>\n");
				print("<answerreal13>$b</answerreal13>\n");
				$a=$data2['rows3'][3]->text_ans;
				$b=$data2['rows3'][3]->realanswer;
				print("<answertext14>$a</answertext14>\n");
				print("<answerreal14>$b</answerreal14>\n");
				
				$id=$data1['rows2'][1]->id;
				$data2['rows3']=$this->list_model->get_answer($id);
				$a=$data2['rows3'][0]->text_ans;
				$b=$data2['rows3'][0]->realanswer;
				print("<answertext21>$a</answertext21>\n");
				print("<answerreal21>$b</answerreal21>\n");
				$a=$data2['rows3'][1]->text_ans;
				$b=$data2['rows3'][1]->realanswer;
				print("<answertext22>$a</answertext22>\n");
				print("<answerreal22>$b</answerreal22>\n");
				$a=$data2['rows3'][2]->text_ans;
				$b=$data2['rows3'][2]->realanswer;
				print("<answertext23>$a</answertext23>\n");
				print("<answerreal23>$b</answerreal23>\n");
				$a=$data2['rows3'][3]->text_ans;
				$b=$data2['rows3'][3]->realanswer;
				print("<answertext24>$a</answertext24>\n");
				print("<answerreal24>$b</answerreal24>\n");
				
				$id=$data1['rows2'][2]->id;
				$data2['rows3']=$this->list_model->get_answer($id);
				$a=$data2['rows3'][0]->text_ans;
				$b=$data2['rows3'][0]->realanswer;
				print("<answertext31>$a</answertext31>\n");
				print("<answerreal31>$b</answerreal31>\n");
				$a=$data2['rows3'][1]->text_ans;
				$b=$data2['rows3'][1]->realanswer;
				print("<answertext32>$a</answertext32>\n");
				print("<answerreal32>$b</answerreal32>\n");
				$a=$data2['rows3'][2]->text_ans;
				$b=$data2['rows3'][2]->realanswer;
				print("<answertext33>$a</answertext33>\n");
				print("<answerreal33>$b</answerreal33>\n");
				$a=$data2['rows3'][3]->text_ans;
				$b=$data2['rows3'][3]->realanswer;
				print("<answertext34>$a</answertext34>\n");
				print("<answerreal34>$b</answerreal34>\n");
				
				$id=$data1['rows2'][3]->id;
				$data2['rows3']=$this->list_model->get_answer($id);
				$a=$data2['rows3'][0]->text_ans;
				$b=$data2['rows3'][0]->realanswer;
				print("<answertext41>$a</answertext41>\n");
				print("<answerreal41>$b</answerreal41>\n");
				$a=$data2['rows3'][1]->text_ans;
				$b=$data2['rows3'][1]->realanswer;
				print("<answertext42>$a</answertext42>\n");
				print("<answerreal42>$b</answerreal42>\n");
				$a=$data2['rows3'][2]->text_ans;
				$b=$data2['rows3'][2]->realanswer;
				print("<answertext43>$a</answertext43>\n");
				print("<answerreal43>$b</answerreal43>\n");
				$a=$data2['rows3'][3]->text_ans;
				$b=$data2['rows3'][3]->realanswer;
				print("<answertext44>$a</answertext44>\n");
				print("<answerreal44>$b</answerreal44>\n");
				
				print("</test>\n");
				print("</testlist>\n");
			}
			else{
			
			$this->list_model->insertSectionNotice($chap_id);
			}
		}
		else{
		}
	}
	
}