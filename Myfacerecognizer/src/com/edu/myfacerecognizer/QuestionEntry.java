
package com.edu.myfacerecognizer;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;

public class QuestionEntry {

	private String _subject="";
    private String _passageText = "";
    private String _bookName="";
    private String _chapterName="";
    private int _startPage=0;
    private int _endPage=0;
    private int _pid=0;
    private int _sid=0;
    private String _roll="";
    private String _questionText1 = "";
    private String _questionText2 = "";
    private String _questionText3 = "";
    private String _questionText4 = "";
    private String _answerText11="";
    private String _answerText12="";
    private String _answerText13="";
    private String _answerText14="";
    private String _answerText21="";
    private String _answerText22="";
    private String _answerText23="";
    private String _answerText24="";
    private String _answerText31="";
    private String _answerText32="";
    private String _answerText33="";
    private String _answerText34="";
    private String _answerText41="";
    private String _answerText42="";
    private String _answerText43="";
    private String _answerText44="";
    private int _answerReal11=0;
    private int _answerReal12=0;
    private int _answerReal13=0;
    private int _answerReal14=0;
    private int _answerReal21=0;
    private int _answerReal22=0;
    private int _answerReal23=0;
    private int _answerReal24=0;
    private int _answerReal31=0;
    private int _answerReal32=0;
    private int _answerReal33=0;
    private int _answerReal34=0;
    private int _answerReal41=0;
    private int _answerReal42=0;
    private int _answerReal43=0;
    private int _answerReal44=0;
  
    
    StringBuilder sb = new StringBuilder();

	String details = null;
	
	 
    QuestionEntry() {
    	
        // constructor

    }

    public String get_passageText() {
        return this._passageText;
    }

    public void set_passageText(String passageText) {
        this._passageText = passageText;
    }
    public String get_subject() {
        return this._subject;
    }

    public void set_subject(String subject) {
        this._subject = subject;
    }
    public String get_bookName() {
        return this._bookName;
    }

    public void set_bookName(String bookName) {
        this._bookName = bookName;
    }
    public String get_chapterName() {
        return this._chapterName;
    }

    public void set_chapterName(String chapterName) {
        this._chapterName = chapterName;
    }
    public int get_startPage() {
        return this._startPage;
    }

    public void set_startPage(int startPage) {
        this._startPage = startPage;
    }
    
    public int get_endPage() {
        return this._endPage;
    }

    public void set_endPage(int endPage) {
        this._endPage = endPage;
    }
    public int get_pid(){
    	return this._pid;
    }
    public void set_pid(int pid){
    	this._pid=pid;
    }
    public int get_sid(){
    	return this._sid;
    }
    public void set_sid(int sid){
    	this._sid=sid;
    }
    public String get_roll(){
    	return this._roll;
    }
    public void set_roll(String roll){
    	this._roll=roll;
    }

    public String get_questionText1() {
        return this._questionText1;
    }

    public void set_questionText1(String _questionText1) {
        this._questionText1 = _questionText1;
    }
    public String get_questionText2() {
        return this._questionText2;
    }

    public void set_questionText2(String _questionText2) {
        this._questionText2 = _questionText2;
    }
    public String get_questionText3() {
        return this._questionText3;
    }

    public void set_questionText3(String _questionText3) {
        this._questionText3 = _questionText3;
    }
    public String get_questionText4() {
        return this._questionText4;
    }

    public void set_questionText4(String _questionText4) {
        this._questionText4 = _questionText4;
    }
    
   public String get_answerText11(){
	   return this._answerText11;
   }
   public void set_answerText11(String _answerText11){
	   this._answerText11=_answerText11;
   }
   public String get_answerText12(){
	   return this._answerText12;
   }
   public void set_answerText12(String _answerText12){
	   this._answerText12=_answerText12;
   }
   public String get_answerText13(){
	   return this._answerText13;
   }
   public void set_answerText13(String _answerText13){
	   this._answerText13=_answerText13;
   }
   public String get_answerText14(){
	   return this._answerText14;
   }
   public void set_answerText14(String _answerText14){
	   this._answerText14=_answerText14;
   }
   public String get_answerText21(){
	   return this._answerText21;
   }
   public void set_answerText21(String _answerText21){
	   this._answerText21=_answerText21;
   }
   public String get_answerText22(){
	   return this._answerText22;
   }
   public void set_answerText22(String _answerText22){
	   this._answerText22=_answerText22;
   }
   public String get_answerText23(){
	   return this._answerText23;
   }
   public void set_answerText23(String _answerText23){
	   this._answerText23=_answerText23;
   }
   public String get_answerText24(){
	   return this._answerText24;
   }
   public void set_answerText24(String _answerText24){
	   this._answerText24=_answerText24;
   }
   public String get_answerText31(){
	   return this._answerText31;
   }
   public void set_answerText31(String _answerText31){
	   this._answerText31=_answerText31;
   }
   public String get_answerText32(){
	   return this._answerText32;
   }
   public void set_answerText32(String _answerText32){
	   this._answerText32=_answerText32;
   }
   public String get_answerText33(){
	   return this._answerText33;
   }
   public void set_answerText33(String _answerText33){
	   this._answerText33=_answerText33;
   }
   public String get_answerText34(){
	   return this._answerText34;
   }
   public void set_answerText34(String _answerText34){
	   this._answerText34=_answerText34;
   }
   public String get_answerText41(){
	   return this._answerText41;
   }
   public void set_answerText41(String _answerText41){
	   this._answerText41=_answerText41;
   }
   public String get_answerText42(){
	   return this._answerText42;
   }
   public void set_answerText42(String _answerText42){
	   this._answerText42=_answerText42;
   }
   public String get_answerText43(){
	   return this._answerText43;
   }
   public void set_answerText43(String _answerText43){
	   this._answerText43=_answerText43;
   }
   public String get_answerText44(){
	   return this._answerText44;
   }
   public void set_answerText44(String _answerText44){
	   this._answerText44=_answerText44;
   }
   public int get_answerReal11(){
	   return this._answerReal11;
   }
   public void set_answerReal11(int _answerReal11){
	   this._answerReal11=_answerReal11;
   }
   public int get_answerReal12(){
	   return this._answerReal12;
   }
   public void set_answerReal12(int _answerReal12){
	   this._answerReal12=_answerReal12;
   }
   public int get_answerReal13(){
	   return this._answerReal13;
   }
   public void set_answerReal13(int _answerReal13){
	   this._answerReal13=_answerReal13;
   }
   public int get_answerReal14(){
	   return this._answerReal14;
   }
   public void set_answerReal14(int _answerReal14){
	   this._answerReal14=_answerReal14;
   }
   public int get_answerReal21(){
	   return this._answerReal21;
   }
   public void set_answerReal21(int _answerReal21){
	   this._answerReal21=_answerReal21;
   }
   public int get_answerReal22(){
	   return this._answerReal22;
   }
   public void set_answerReal22(int _answerReal22){
	   this._answerReal22=_answerReal22;
   }
   public int get_answerReal23(){
	   return this._answerReal23;
   }
   public void set_answerReal23(int _answerReal23){
	   this._answerReal23=_answerReal23;
   }
   public int get_answerReal24(){
	   return this._answerReal24;
   }
   public void set_answerReal24(int _answerReal24){
	   this._answerReal24=_answerReal24;
   }
   public int get_answerReal31(){
	   return this._answerReal31;
   }
   public void set_answerReal31(int _answerReal31){
	   this._answerReal31=_answerReal31;
   }
   public int get_answerReal32(){
	   return this._answerReal32;
   }
   public void set_answerReal32(int _answerReal32){
	   this._answerReal32=_answerReal32;
   }
   public int get_answerReal33(){
	   return this._answerReal33;
   }
   public void set_answerReal33(int _answerReal33){
	   this._answerReal33=_answerReal33;
   }
   public int get_answerReal34(){
	   return this._answerReal34;
   }
   public void set_answerReal34(int _answerReal34){
	   this._answerReal34=_answerReal34;
   }
   public int get_answerReal41(){
	   return this._answerReal41;
   }
   public void set_answerReal41(int _answerReal41){
	   this._answerReal41=_answerReal41;
   }
   public int get_answerReal42(){
	   return this._answerReal42;
   }
   public void set_answerReal42(int _answerReal42){
	   this._answerReal42=_answerReal42;
   }
   public int get_answerReal43(){
	   return this._answerReal43;
   }
   public void set_answerReal43(int _answerReal43){
	   this._answerReal43=_answerReal43;
   }
   public int get_answerReal44(){
	   return this._answerReal44;
   }
   public void set_answerReal44(int _answerReal44){
	   this._answerReal44=_answerReal44;
   }
   
  
    @Override
    public String toString() {
    	sb = new StringBuilder();
    	sb.append("Passage " + this._passageText + "\n\n");
		details = sb.toString();
		return details;
    }

    public String toXMLString() {
        StringBuilder sb = new StringBuilder("");
        sb.append("<test>");
        sb.append("<subject>" + this._subject + "</subject>");
        sb.append("<passage>" + this._passageText + "</passage>");
        sb.append("<bookname>" + this._bookName + "</bookname>");
        sb.append("<chaptername>" + this._chapterName + "</chaptername>");
        sb.append("<startpage>"+this._startPage+"</startpage>");
        sb.append("<endpage>"+this._endPage+"</endpage>");
        sb.append("<sid>"+this._sid+"</sid>");
        sb.append("<pid>"+this._pid+"</pid>");
        sb.append("<roll>"+this._roll+"</roll>");
        sb.append("<question1>" + this._questionText1 + "</question1>");
        sb.append("<question2>" + this._questionText2 + "</question2>");
        sb.append("<question3>" + this._questionText3 + "</question3>");
        sb.append("<question4>" + this._questionText4 + "</question4>");
        sb.append("<answertext11>" + this._answerText11 + "</answertext11>");
        sb.append("<answertext12>" + this._answerText12 + "</answertext12>");
        sb.append("<answertext13>" + this._answerText13 + "</answertext13>");
        sb.append("<answertext14>" + this._answerText14 + "</answertext14>");
        sb.append("<answertext21>" + this._answerText21 + "</answertext21>");
        sb.append("<answertext22>" + this._answerText22 + "</answertext22>");
        sb.append("<answertext23>" + this._answerText23 + "</answertext23>");
        sb.append("<answertext24>" + this._answerText24 + "</answertext24>");
        sb.append("<answertext31>" + this._answerText31 + "</answertext31>");
        sb.append("<answertext32>" + this._answerText32 + "</answertext32>");
        sb.append("<answertext33>" + this._answerText33 + "</answertext33>");
        sb.append("<answertext34>" + this._answerText34 + "</answertext34>");
        sb.append("<answertext41>" + this._answerText41 + "</answertext41>");
        sb.append("<answertext42>" + this._answerText42 + "</answertext42>");
        sb.append("<answertext43>" + this._answerText43 + "</answertext43>");
        sb.append("<answertext44>" + this._answerText44 + "</answertext44>");
        sb.append("<answerreal11>" + this._answerReal11 + "</answerreal11>");
        sb.append("<answerreal12>" + this._answerReal12 + "</answerreal12>");
        sb.append("<answerreal13>" + this._answerReal13 + "</answerreal13>");
        sb.append("<answerreal14>" + this._answerReal14 + "</answerreal14>");
        sb.append("<answerreal21>" + this._answerReal21 + "</answerreal21>");
        sb.append("<answerreal22>" + this._answerReal22 + "</answerreal22>");
        sb.append("<answerreal23>" + this._answerReal23 + "</answerreal23>");
        sb.append("<answerreal24>" + this._answerReal24 + "</answerreal24>");
        sb.append("<answerreal31>" + this._answerReal31 + "</answerreal31>");
        sb.append("<answerreal32>" + this._answerReal32 + "</answerreal32>");
        sb.append("<answerreal33>" + this._answerReal33 + "</answerreal33>");
        sb.append("<answerreal34>" + this._answerReal34 + "</answerreal34>");
        sb.append("<answerreal41>" + this._answerReal41 + "</answerreal41>");
        sb.append("<answerreal42>" + this._answerReal42 + "</answerreal42>");
        sb.append("<answerreal43>" + this._answerReal43 + "</answerreal43>");
        sb.append("<answerreal44>" + this._answerReal44 + "</answerreal44>");
        sb.append("</test>");
        return sb.toString() + "\n";
    }

    public Bundle toBundle() {
        Bundle b = new Bundle();
        b.putString("subject", this._subject);
        b.putString("passage", this._passageText);
        b.putString("bookname", this._bookName);
        b.putString("chaptername", this._chapterName);
        b.putInt("pid", this._pid);
        b.putInt("sid", this._sid);
        b.putString("roll", this._roll);
        b.putInt("startpage", this._startPage);
        b.putInt("endpage", this._endPage);
        b.putString("question1", this._questionText1);
        b.putString("question2", this._questionText2);
        b.putString("question3", this._questionText3);
        b.putString("question4", this._questionText4);
        b.putString("answertext11", this._answerText11);
        b.putString("answertext12", this._answerText12);
        b.putString("answertext13", this._answerText13);
        b.putString("answertext14", this._answerText14);
        b.putString("answertext21", this._answerText21);
        b.putString("answertext22", this._answerText22);
        b.putString("answertext23", this._answerText23);
        b.putString("answertext24", this._answerText24);
        b.putString("answertext31", this._answerText31);
        b.putString("answertext32", this._answerText32);
        b.putString("answertext33", this._answerText33);
        b.putString("answertext34", this._answerText34);
        b.putString("answertext41", this._answerText41);
        b.putString("answertext42", this._answerText42);
        b.putString("answertext43", this._answerText43);
        b.putString("answertext44", this._answerText44);
        b.putInt("answerreal11", this._answerReal11);
        b.putInt("answerreal12", this._answerReal12);
        b.putInt("answerreal13", this._answerReal13);
        b.putInt("answerreal14", this._answerReal14);
        b.putInt("answerreal21", this._answerReal21);
        b.putInt("answerreal22", this._answerReal22);
        b.putInt("answerreal23", this._answerReal23);
        b.putInt("answerreal24", this._answerReal24);
        b.putInt("answerreal31", this._answerReal31);
        b.putInt("answerreal32", this._answerReal32);
        b.putInt("answerreal33", this._answerReal33);
        b.putInt("answerreal34", this._answerReal34);
        b.putInt("answerreal41", this._answerReal41);
        b.putInt("answerreal42", this._answerReal42);
        b.putInt("answerreal43", this._answerReal43);
        b.putInt("answerreal44", this._answerReal44);
        return b;
    }

    public static QuestionEntry fromBundle(Bundle b) {
        QuestionEntry je = new QuestionEntry();
        je.set_subject(b.getString("subject"));
        je.set_passageText(b.getString("passage"));
        je.set_bookName(b.getString("bookname"));
        je.set_chapterName(b.getString("chaptername"));
        je.set_pid(b.getInt("pid"));
        je.set_sid(b.getInt("sid"));
        je.set_startPage(b.getInt("startpage"));
        je.set_endPage(b.getInt("endpage"));
        je.set_roll(b.getString("roll"));
        je.set_questionText1(b.getString("question1"));
        je.set_questionText2(b.getString("question2"));
        je.set_questionText3(b.getString("question3"));
        je.set_questionText4(b.getString("question4"));
        je.set_answerText11(b.getString("answertext11"));
        je.set_answerText12(b.getString("answertext12"));
        je.set_answerText13(b.getString("answertext13"));
        je.set_answerText14(b.getString("answertext14"));
        je.set_answerText21(b.getString("answertext21"));
        je.set_answerText22(b.getString("answertext22"));
        je.set_answerText23(b.getString("answertext23"));
        je.set_answerText24(b.getString("answertext24"));
        je.set_answerText31(b.getString("answertext31"));
        je.set_answerText32(b.getString("answertext32"));
        je.set_answerText33(b.getString("answertext33"));
        je.set_answerText34(b.getString("answertext34"));
        je.set_answerText41(b.getString("answertext41"));
        je.set_answerText42(b.getString("answertext42"));
        je.set_answerText43(b.getString("answertext43"));
        je.set_answerText44(b.getString("answertext44"));
        je.set_answerReal11(b.getInt("answerreal11"));
        je.set_answerReal12(b.getInt("answerreal12"));
        je.set_answerReal13(b.getInt("answerreal13"));
        je.set_answerReal14(b.getInt("answerreal14"));
        je.set_answerReal21(b.getInt("answerreal21"));
        je.set_answerReal22(b.getInt("answerreal22"));
        je.set_answerReal23(b.getInt("answerreal23"));
        je.set_answerReal24(b.getInt("answerreal24"));
        je.set_answerReal31(b.getInt("answerreal31"));
        je.set_answerReal32(b.getInt("answerreal32"));
        je.set_answerReal33(b.getInt("answerreal33"));
        je.set_answerReal34(b.getInt("answerreal34"));
        je.set_answerReal41(b.getInt("answerreal41"));
        je.set_answerReal42(b.getInt("answerreal42"));
        je.set_answerReal43(b.getInt("answerreal43"));
        je.set_answerReal44(b.getInt("answerreal44"));
        
        return je;
    }
    

}
