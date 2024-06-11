
package com.edu.myfacerecognizer;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

public class Prefs {

    private SharedPreferences _prefs = null;
    private Editor _editor = null;
    private String _type = "seen";
    private int _chapterID=12;
    private String _serverurl = "http://10.0.2.2:80/server/index.php/getQuestionList";
    private String _roll="0805110";
    private int _class1=8;

    public Prefs(Context context) {
        this._prefs = context.getSharedPreferences("PREFS_PRIVATE", Context.MODE_PRIVATE);
        this._editor = this._prefs.edit();
    }

    public String getValue(String key, String defaultvalue) {
        if (this._prefs == null) {
            return "seen";
        }

        return this._prefs.getString(key, defaultvalue);
    }

    public void setValue(String key, String value) {
        if (this._editor == null) {
            return;
        }

        this._editor.putString(key, value);

    }
    public int getClass1() {
        if (this._prefs == null) {
            return 8;
        }

        this._class1 = this._prefs.getInt("class1",8 );
        return this._class1;
    }

    public int getChapId() {
        if (this._prefs == null) {
            return 12;
        }

        this._chapterID = this._prefs.getInt("chapterID",2 );
        return this._chapterID;
    }
    public String getType() {
        if (this._prefs == null) {
            return "seen";
        }

        this._type = this._prefs.getString("type", "seen");
        return this._type;
    }
    public String getRoll() {
        if (this._prefs == null) {
            return "0805110";
        }

        this._roll = this._prefs.getString("roll", "0805110");
        return this._roll;
    }

    public String getServer() {
        if (this._prefs == null) {
            return "http://10.0.2.2:80/server/";
        }

        this._serverurl = this._prefs.getString("serverurl", "http://10.0.2.2:80/server/");
        return this._serverurl;
    }

    public void setRoll(String roll) {
		// TODO Auto-generated method stub
    	 if (this._editor == null) {
             return;
         }

         this._editor.putString("roll", roll);
		
	}
    public void setChapterID(int chapterID) {
        if (this._editor == null) {
            return;
        }

        this._editor.putInt("chapterID", chapterID);
    }
    public void setClass1(int class1) {
        if (this._editor == null) {
            return;
        }

        this._editor.putInt("class1", class1);
    }
    public void setType(String type) {
        if (this._editor == null) {
            return;
        }

        this._editor.putString("type", type);
    }

    public void setServer(String serverurl) {
        if (this._editor == null) {
            return;
        }
        this._editor.putString("serverurl", serverurl);
    }

    public void save() {
        if (this._editor == null) {
            return;
        }
        this._editor.commit();
    }

	
}
