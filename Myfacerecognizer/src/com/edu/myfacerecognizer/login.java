package com.edu.myfacerecognizer;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class login extends Activity  {

	Prefs myprefs = null;
	
	// private static String loginURL =
	// "http://10.0.2.2:80/server/index.php/checkid";
	//http://www.tstuff.site90.com/server/index.php/checkid
	private static String loginURL = "http://10.0.2.2:80/server/index.php/checkid";
	private JSONParser jsonParser;
	private static String KEY_SUCCESS = "success";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		this.myprefs = new Prefs(getApplicationContext());
		jsonParser = new JSONParser();
		
		String s1 = login.this.myprefs.getRoll();

		Thread workthread = new Thread(new DoReadQuestions(s1));

		workthread.start();

	}

	class DoReadQuestions implements Runnable {

		String s1;

		DoReadQuestions(String pass) {
			s1 = pass;
		}

		@Override
		public void run() {
			JSONObject json = loginUser(s1);
			try {
				if (json.getString(KEY_SUCCESS) != null) {
					// tview.setText("");
					String res = json.getString(KEY_SUCCESS);
					if (Integer.parseInt(res) != 0) {
						login.this.myprefs.setRoll(s1);
						login.this.myprefs.setClass1(Integer.parseInt(res));
						login.this.myprefs.save();
						startActivity(new Intent(getApplication(),
								OnlineTest.class));
						// close out this activity
						finish();
					} else {
						// Error in login
						// tview.setText("InValid ID");
					}
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}

		}

	}



	public JSONObject loginUser(String password) {
		// Building Parameters
		ArrayList<NameValuePair> params = new ArrayList<NameValuePair>(1);
		params.add(new BasicNameValuePair("rollno", password));
		JSONObject json = jsonParser.getJSONFromUrl(loginURL, params);
		// return json
		// Log.e("JSON", json.toString());
		return json;
	}

}
