

package com.edu.myfacerecognizer;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

public class QuestionListHandler extends DefaultHandler {

    Handler phandler = null;
    QuestionList _list;
    QuestionEntry _question;
    String _lastElementName = "";
    StringBuilder sb = null;
    Context _context;

    QuestionListHandler(Context c, Handler progresshandler) {
        this._context = c;
        if (progresshandler != null) {
            this.phandler = progresshandler;
            Message msg = new Message();
            msg.what = 0;
            msg.obj = ("Processing List");
            this.phandler.sendMessage(msg);
        }
    }

    public QuestionList getList() {
        Message msg = new Message();
        msg.what = 0;
        msg.obj = ("Fetching List");
        if (this.phandler != null) {
            this.phandler.sendMessage(msg);
        }
        return this._list;//
    }

    @Override
    public void startDocument() throws SAXException {
        Message msg = new Message();
        msg.what = 0;
        msg.obj = ("Starting Document");
        if (this.phandler != null) {
            this.phandler.sendMessage(msg);
        }

        // initialize our JobLIst object - this will hold our parsed contents
       

        // initialize the JobEntry object
        this._list = new QuestionList(this._context);
        this._question = new QuestionEntry();

    }

    @Override
    public void endDocument() throws SAXException {
        Message msg = new Message();
        msg.what = 0;
        msg.obj = ("End of Document");
        if (this.phandler != null) {
            this.phandler.sendMessage(msg);
        }

    }

    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        try {
            this.sb = new StringBuilder("");

            if (localName.equals("test")) {
                // create a new item

                Message msg = new Message();
                msg.what = 0;
                msg.obj = (localName);
                if (this.phandler != null) {
                    this.phandler.sendMessage(msg);
                }

               this._question = new QuestionEntry();

            }
        } catch (Exception ee) {
            Log.d("startElement", ee.getStackTrace().toString());
        }
    }

    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {

        if (localName.equals("test")) {
            // add our job to the list!
        	this._list.addQuestion(this._question);
            Message msg = new Message();
            msg.what = 0;
            msg.obj = ("Storing Question # " + "test");
            if (this.phandler != null) {
                this.phandler.sendMessage(msg);
            }

            return;
        }
        if (localName.equals("subject")) {
            this._question.set_subject(this.sb.toString());
            
            return;
        }

        if (localName.equals("passage")) {
            this._question.set_passageText(this.sb.toString());
            
            return;
        }
        if (localName.equals("bookname")) {
            this._question.set_bookName(this.sb.toString());
            
            return;
        }
        if (localName.equals("chaptername")) {
            this._question.set_chapterName(this.sb.toString());
            
            return;
        }
        if (localName.equals("pid")) {
            this._question.set_pid(Integer.parseInt(this.sb.toString()));
            
            return;
        }
        if (localName.equals("sid")) {
            this._question.set_sid(Integer.parseInt(this.sb.toString()));
            
            return;
        }
        if (localName.equals("startpage")) {
            this._question.set_startPage(Integer.parseInt(this.sb.toString()));
            
            return;
        }
        if (localName.equals("endpage")) {
            this._question.set_endPage(Integer.parseInt(this.sb.toString()));
            
            return;
        }
        if (localName.equals("roll")) {
            this._question.set_roll(this.sb.toString());
            
            return;
        }
        
        if (localName.equals("question1")) {
            this._question.set_questionText1(this.sb.toString());
            return;
        }
        if (localName.equals("question2")) {
            this._question.set_questionText2(this.sb.toString());
            return;
        }
        if (localName.equals("question3")) {
            this._question.set_questionText3(this.sb.toString());
            return;
        }
        if (localName.equals("question4")) {
            this._question.set_questionText4(this.sb.toString());
            return;
        }
        if (localName.equals("question4")) {
            this._question.set_questionText4(this.sb.toString());
            return;
        }
        if (localName.equals("answertext11")) {
            this._question.set_answerText11(this.sb.toString());
            return;
        }
        if (localName.equals("answertext12")) {
            this._question.set_answerText12(this.sb.toString());
            return;
        }
        if (localName.equals("answertext13")) {
            this._question.set_answerText13(this.sb.toString());
            return;
        }
        if (localName.equals("answertext14")) {
            this._question.set_answerText14(this.sb.toString());
            return;
        }
        if (localName.equals("answertext21")) {
            this._question.set_answerText21(this.sb.toString());
            return;
        }
        if (localName.equals("answertext22")) {
            this._question.set_answerText22(this.sb.toString());
            return;
        }
        if (localName.equals("answertext23")) {
            this._question.set_answerText23(this.sb.toString());
            return;
        }
        if (localName.equals("answertext24")) {
            this._question.set_answerText24(this.sb.toString());
            return;
        }
        if (localName.equals("answertext31")) {
            this._question.set_answerText31(this.sb.toString());
            return;
        }
        if (localName.equals("answertext32")) {
            this._question.set_answerText32(this.sb.toString());
            return;
        }
        if (localName.equals("answertext33")) {
            this._question.set_answerText33(this.sb.toString());
            return;
        }
        if (localName.equals("answertext34")) {
            this._question.set_answerText34(this.sb.toString());
            return;
        }
        if (localName.equals("answertext41")) {
            this._question.set_answerText41(this.sb.toString());
            return;
        }
        if (localName.equals("answertext42")) {
            this._question.set_answerText42(this.sb.toString());
            return;
        }
        if (localName.equals("answertext43")) {
            this._question.set_answerText43(this.sb.toString());
            return;
        }
        if (localName.equals("answertext44")) {
            this._question.set_answerText44(this.sb.toString());
            return;
        }
        if (localName.equals("answerreal11")) {
            this._question.set_answerReal11(Integer.parseInt(this.sb.toString()));
            return;
        }
        if (localName.equals("answerreal12")) {
            this._question.set_answerReal12(Integer.parseInt(this.sb.toString()));
            return;
        }
        if (localName.equals("answerreal13")) {
            this._question.set_answerReal13(Integer.parseInt(this.sb.toString()));
            return;
        }
        if (localName.equals("answerreal14")) {
            this._question.set_answerReal14(Integer.parseInt(this.sb.toString()));
            return;
        }
        if (localName.equals("answerreal21")) {
            this._question.set_answerReal21(Integer.parseInt(this.sb.toString()));
            return;
        }
        if (localName.equals("answerreal22")) {
            this._question.set_answerReal22(Integer.parseInt(this.sb.toString()));
            return;
        }
        if (localName.equals("answerreal23")) {
            this._question.set_answerReal23(Integer.parseInt(this.sb.toString()));
            return;
        }
        if (localName.equals("answerreal24")) {
            this._question.set_answerReal24(Integer.parseInt(this.sb.toString()));
            return;
        }
        if (localName.equals("answerreal31")) {
            this._question.set_answerReal31(Integer.parseInt(this.sb.toString()));
            return;
        }
        if (localName.equals("answerreal32")) {
            this._question.set_answerReal32(Integer.parseInt(this.sb.toString()));
            return;
        }
        if (localName.equals("answerreal33")) {
            this._question.set_answerReal33(Integer.parseInt(this.sb.toString()));
            return;
        }
        if (localName.equals("answerreal34")) {
            this._question.set_answerReal34(Integer.parseInt(this.sb.toString()));
            return;
        }
        if (localName.equals("answerreal41")) {
            this._question.set_answerReal41(Integer.parseInt(this.sb.toString()));
            return;
        }
        if (localName.equals("answerreal42")) {
            this._question.set_answerReal42(Integer.parseInt(this.sb.toString()));
            return;
        }
        if (localName.equals("answerreal43")) {
            this._question.set_answerReal43(Integer.parseInt(this.sb.toString()));
            return;
        }
        if (localName.equals("answerreal44")) {
            this._question.set_answerReal44(Integer.parseInt(this.sb.toString()));
            return;
        }
    }

    @Override
    public void characters(char ch[], int start, int length) {
        String theString = new String(ch, start, length);
        Log.d("", "characters[" + theString + "]");
        this.sb.append(theString);
    }
    
    
}
