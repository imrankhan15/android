package com.edu.myfacerecognizer;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.telephony.SmsManager;

public class ManageQuestions extends Activity implements OnClickListener {

	final int SHOWQUESTION = 1;
	Prefs myprefs = null;

	QuestionList _questionlist = null;
	ListView questionListView;
	Button sms,back;
	TextView tv;
	int result = 0;
	int m[];
	int j;
	int k = 1;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);

		setContentView(R.layout.managequestions);

		this.myprefs = new Prefs(getApplicationContext());

		tv = (TextView) findViewById(R.id.statuslabel);
		sms = (Button) findViewById(R.id.button1);
		back = (Button) findViewById(R.id.button2);
		sms.setOnClickListener(this);
		back.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(ManageQuestions.this,OnlineTest.class);
				startActivity(i);
			}
			
		});

		this._questionlist = QuestionList.parse(getApplicationContext());
		if (this._questionlist == null) {
			Log.d("thesis", "_questionlist is null");

			this._questionlist = new QuestionList(getApplicationContext());
		}

		if (this._questionlist.getQuestionCount() == 0) {
			tv.setText("There are No Questions Available");
			sms.setVisibility(View.VISIBLE);
		} else {

			Intent testIntent = new Intent(this, ShowQuestion.class);
			QuestionEntry je = this._questionlist.getQuestion(0);
			Bundle b = je.toBundle();
			testIntent.putExtras(b);
			startActivity(testIntent);

		}

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (requestCode) {
		case SHOWQUESTION:
			if (resultCode == 1) {
				finish();

			}
			break;
		}

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		String phoneNumber = "8801941417305";
		String message = "Please Check the notice box new entry required";

		SmsManager smsManager = SmsManager.getDefault();
		smsManager.sendTextMessage(phoneNumber, null, message, null, null);
		Log.d("thesis", "_questionlist is null");

	}

}
