package com.edu.myfacerecognizer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SlidingDrawer;
import android.widget.TextView;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class ShowSettingsNine extends Activity {
	Prefs myprefs = null;
	RadioGroup r1, r2,r3,r4;
	RadioButton rb1, rb3,rb4,rb5,rb6,rb7;
	LinearLayout content1,content2,content3;
	Button b2,b3,b4;
	TextView tv1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.classninesettings);
		this.myprefs = new Prefs(getApplicationContext());
		r1 = (RadioGroup) findViewById(R.id.subject9);
		
		r2 = (RadioGroup) findViewById(R.id.chap9);
		r3 = (RadioGroup) findViewById(R.id.chap29);
		r4 = (RadioGroup) findViewById(R.id.chap39);

		b2 = (Button) findViewById(R.id.settingssave92);
		b3 = (Button) findViewById(R.id.settingssave292);
		b4 = (Button) findViewById(R.id.settingssave392);
		
		rb1 = (RadioButton) findViewById(R.id.socialscience9);

		rb3 = (RadioButton) findViewById(R.id.english9);
		rb4 = (RadioButton) findViewById(R.id.mathematics9);
		rb5 = (RadioButton) findViewById(R.id.chaps901);
		rb6 = (RadioButton) findViewById(R.id.chaps2901);
		rb7 = (RadioButton) findViewById(R.id.chaps3901);
		
		
		tv1 = (TextView) findViewById(R.id.tsubject9);
		content1=(LinearLayout)findViewById(R.id.contentss9);
		content2=(LinearLayout)findViewById(R.id.contente9);
		content3=(LinearLayout)findViewById(R.id.contentm9);
		ShowSettingsNine.this.myprefs.setChapterID(12);
		r1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				if (rb1.isChecked()) {
					
					r1.setVisibility(8);
					tv1.setVisibility(8);
					
					content1.setVisibility(0);
					

				}
				else if(rb3.isChecked()){
					r1.setVisibility(8);
					tv1.setVisibility(8);
					
					content2.setVisibility(0);
				}
				else if(rb4.isChecked()){
					r1.setVisibility(8);
					tv1.setVisibility(8);
					
					content3.setVisibility(0);
				}
			}

		});
		r2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				if (rb5.isChecked()) {
					ShowSettingsNine.this.myprefs.setChapterID(12);
				} 
			}

		});
		r3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Aut0-generated method stub
				if (rb6.isChecked()) {
					ShowSettingsNine.this.myprefs.setChapterID(17);
				} 
			}

		});
		r4.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				if (rb7.isChecked()) {
					ShowSettingsNine.this.myprefs.setChapterID(16);
				} 
			}

		});
		b2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ShowSettingsNine.this.myprefs.save();
				finish();
			}
			
		});
		b3.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ShowSettingsNine.this.myprefs.save();
				finish();
			}
			
		});
		b4.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ShowSettingsNine.this.myprefs.save();
				finish();
			}
			
		});
	}

}
