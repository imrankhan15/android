package com.edu.myfacerecognizer;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Vector;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.content.Context;
import android.util.Log;
public class QuestionList {
	private Context _context = null;
    private List<QuestionEntry> _questionlist;

    QuestionList(Context c) {
        this._context = c;
        this._questionlist = new Vector<QuestionEntry>(0);
    }

    int addQuestion(QuestionEntry qentry) {
        this._questionlist.add(qentry);
        return this._questionlist.size();
    }

    QuestionEntry getQuestion(int location) {
        return this._questionlist.get(location);
    }

    List<QuestionEntry> getAllJobs() {
        return this._questionlist;
    }

    int getQuestionCount() {
        return this._questionlist.size();
    }

   
    void persist() {
        try {
            FileOutputStream fos = this._context.openFileOutput("chapter12.xml", Context.MODE_PRIVATE);
            fos.write("<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n".getBytes());
            fos.write("<testlist>\n".getBytes());
            for (int i = 0; i < getQuestionCount(); i++) {
                QuestionEntry je = getQuestion(i);
                fos.write(je.toXMLString().getBytes());
            }
            fos.write("</testlist>\n".getBytes());
            fos.flush();
            fos.close();
        } catch (Exception e) {
            Log.d("CH12", "Failed to write out file?" + e.getMessage());
        }
    }

    static QuestionList parse(Context context) {
        try {
            FileInputStream fis = context.openFileInput("chapter12.xml");

            if (fis == null) {
                return null;
            }
            // we need an input source for the sax parser
            InputSource is = new InputSource(fis);

            // create the factory
            SAXParserFactory factory = SAXParserFactory.newInstance();

            // create a parser
            SAXParser parser = factory.newSAXParser();

            // create the reader (scanner)
            XMLReader xmlreader = parser.getXMLReader();

            // instantiate our handler
            QuestionListHandler jlHandler = new QuestionListHandler(context, null );

            // assign our handler
            xmlreader.setContentHandler(jlHandler);

            // perform the synchronous parse
            xmlreader.parse(is);

            // clean up
            fis.close();

            // return our new questionlist
            return jlHandler.getList();
        } catch (Exception e) {
            Log.d("CH12", "Error parsing question list xml file : " + e.getMessage());
            return null;
        }
    }

}
