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

public class ShowSettingsEight extends Activity {
	Prefs myprefs = null;
	RadioGroup r1,r2,r3;
	RadioButton rb1,rb2,rb3,rb4;
	LinearLayout lss,lgs;
	Button b2,b3;
	TextView tv1;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.classeightsettings);
		this.myprefs = new Prefs(getApplicationContext());
		r1=(RadioGroup)findViewById(R.id.subject8);
		r2=(RadioGroup)findViewById(R.id.chap8);
		r3=(RadioGroup)findViewById(R.id.chap28);
	
		b2=(Button)findViewById(R.id.settingssave28);
		b3=(Button)findViewById(R.id.settingssave38);
		rb1=(RadioButton)findViewById(R.id.socialscience8);
		rb2=(RadioButton)findViewById(R.id.generalscience8);
		rb3=(RadioButton)findViewById(R.id.chaps801);
		rb4=(RadioButton)findViewById(R.id.chapg801);
		tv1=(TextView)findViewById(R.id.tsubject8);
		lss=(LinearLayout)findViewById(R.id.contentss8);
		lgs=(LinearLayout)findViewById(R.id.contentgs8);
		ShowSettingsEight.this.myprefs.setChapterID(13);
		r1.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				if (rb1.isChecked()) {
					
					r1.setVisibility(8);
					tv1.setVisibility(8);
					
					lss.setVisibility(0);
					

				} else if (rb2.isChecked()) {
					r1.setVisibility(8);
					tv1.setVisibility(8);
					
					lgs.setVisibility(0);

				}
			}

		});
		r2.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				if (rb3.isChecked()) {
					
					ShowSettingsEight.this.myprefs.setChapterID(13);
					

				} 
			}

		});
		r3.setOnCheckedChangeListener(new OnCheckedChangeListener() {

			@Override
			public void onCheckedChanged(RadioGroup arg0, int arg1) {
				// TODO Auto-generated method stub
				if (rb4.isChecked()) {
					
					ShowSettingsEight.this.myprefs.setChapterID(14);

				} 
			}

		});
		b2.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ShowSettingsEight.this.myprefs.save();
				finish();
			}
			
		});
		b3.setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				ShowSettingsEight.this.myprefs.save();
				finish();
			}
			
		});
		
		
		
	}
	

}
