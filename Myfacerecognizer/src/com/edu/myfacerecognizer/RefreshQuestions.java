

package com.edu.myfacerecognizer;

import java.net.URL;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class RefreshQuestions extends Activity {

    Prefs myprefs = null;
    Boolean bCancel = false;
    QuestionList mList = null;
    ProgressDialog myprogress;
    Handler progresshandler;

    @Override
    public void onCreate(Bundle icicle) {
        super.onCreate(icicle);

        setContentView(R.layout.refreshquestions);

        this.myprefs = new Prefs(getApplicationContext());

        this.myprogress = ProgressDialog.show(this, "Refreshing Question List", "Please Wait", true, false);

        // install handler for processing gui update messages
        this.progresshandler = new Handler() {

            @Override
            public void handleMessage(Message msg) {
                // process incoming messages here
                switch (msg.what) {
                    case 0:
                        // update progress bar
                        RefreshQuestions.this.myprogress.setMessage("" + (String) msg.obj);
                        break;
                    case 1:
                        RefreshQuestions.this.myprogress.cancel();
                        finish();
                        break;
                    case 2: // error occurred
                        RefreshQuestions.this.myprogress.cancel();
                        finish();
                        break;
                }
                // super.handleMessage(msg);
            }
        };

        Thread workthread = new Thread(new DoReadQuestions());

        workthread.start();

    }

    class DoReadQuestions implements Runnable {

        public void run() {
            InputSource is = null;

            // set up our message - used to convey progress information
            Message msg = new Message();
            msg.what = 0;
            URL url;
            try {
                // Looper.prepare();

                msg.obj = ("Connecting ...");
                RefreshQuestions.this.progresshandler.sendMessage(msg);
                
               // www.tstuff.site90.com
                	// url = new URL("http://10.0.2.2:80/server/index.php/getQuestionList?roll="+RefreshQuestions.this.myprefs.getRoll()+"&type=seen"+"&chap_id="+RefreshQuestions.this.myprefs.getChapId());
                	 url = new URL("http://10.0.2.2:80/server/index.php/getQuestionList?roll="+RefreshQuestions.this.myprefs.getRoll()+"&type="+RefreshQuestions.this.myprefs.getType()+"&chap_id="+RefreshQuestions.this.myprefs.getChapId());
              
               
                // get our data via the url class
                is = new InputSource(url.openStream());

                // create the factory
                SAXParserFactory factory = SAXParserFactory.newInstance();

                // create a parser
                SAXParser parser = factory.newSAXParser();

                // create the reader (scanner)
                XMLReader xmlreader = parser.getXMLReader();

                // instantiate our handler
                QuestionListHandler jlHandler = new QuestionListHandler(getApplication().getApplicationContext(),
                    RefreshQuestions.this.progresshandler);

                // assign our handler
                xmlreader.setContentHandler(jlHandler);

                msg = new Message();
                msg.what = 0;
                msg.obj = ("Parsing ...");
                RefreshQuestions.this.progresshandler.sendMessage(msg);

                // perform the synchronous parse
                try{
                xmlreader.parse(is);
                }catch(Exception e){
                	Log.d("CH12", "Exception: abc" + e.getMessage());
                	 
                }
                finally{
                	msg = new Message();
                    msg.what = 0;
                    msg.obj = ("Parsing Complete");
                    RefreshQuestions.this.progresshandler.sendMessage(msg);

                    msg = new Message();
                    msg.what = 0;
                    msg.obj = ("Saving Question List");
                    RefreshQuestions.this.progresshandler.sendMessage(msg);

                    jlHandler.getList().persist();
                }

               

                msg = new Message();
                msg.what = 0;
                msg.obj = ("Question List Saved.");
                RefreshQuestions.this.progresshandler.sendMessage(msg);

                msg = new Message();
                msg.what = 1;
                RefreshQuestions.this.progresshandler.sendMessage(msg);

            } catch (Exception e) {
                Log.d("CH12", "Exception: abc" + e.getMessage());
                msg = new Message();
                msg.what = 2; // error occured
                msg.obj = ("Caught an error retrieving Question data: " + e.getMessage());
                RefreshQuestions.this.progresshandler.sendMessage(msg);

            }
        }
    }
    
    

}
