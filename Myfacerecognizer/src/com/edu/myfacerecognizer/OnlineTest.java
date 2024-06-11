package com.edu.myfacerecognizer;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OnlineTest extends Activity {
	 final int ACTIVITY_REFRESHQUESTIONS = 1;
	    final int ACTIVITY_LISTQUESTIONS = 2;
	    final int ACTIVITY_SETTINGS = 3;

	    final String tag = "OnlineTest";

	    Prefs myprefs = null;

		@Override
		protected void onCreate(Bundle savedInstanceState) {
			// TODO Auto-generated method stub
			super.onCreate(savedInstanceState);
			 setContentView(R.layout.onlinetest);

		        // get our application prefs handle
		        this.myprefs = new Prefs(getApplicationContext());

		        // see if we have an email address set yet....
		        RefreshUserInfo();

		        // refresh jobs
		        
		        // show jobs
		        final Button listjobsbutton = (Button) findViewById(R.id.showQuestions);
		        listjobsbutton.setOnClickListener(new Button.OnClickListener() {

		            public void onClick(View v) {
		                try {
		                    // Perform action on click
		                	startActivityForResult(new Intent(v.getContext(), RefreshQuestions.class),
			                        OnlineTest.this.ACTIVITY_REFRESHQUESTIONS);
		                   
		                } catch (Exception e) {
		                    Log.i(OnlineTest.this.tag, "Failed to list jobs [" + e.getMessage() + "]");
		                }
		            }
		        });

		        // settings
		        final Button settingsbutton = (Button) findViewById(R.id.settings);
		        settingsbutton.setOnClickListener(new Button.OnClickListener() {

		            public void onClick(View v) {
		                try {
		                    // Perform action on click
		                	int i=OnlineTest.this.myprefs.getClass1();
		                	if(i==8){
		                		 startActivity(new Intent(v.getContext(), ShowSettingsEight.class));
		                	}
		                	else if(i==9||i==10){
		                		 startActivity(new Intent(v.getContext(), ShowSettingsNine.class));
		                	}
		                   
		                } catch (Exception e) {
		                    Log.i(OnlineTest.this.tag, "Failed to Launch Settings [" + e.getMessage() + "]");
		                }
		            }
		        });
		        final Button closebutton = (Button) findViewById(R.id.close);
		        closebutton.setOnClickListener(new Button.OnClickListener() {

		            public void onClick(View v) {
		                try {
		                    // Perform action on click
		                	Intent intent = new Intent(OnlineTest.this,
									login.class);
							OnlineTest.this.startActivity(intent);
		                   
		                } catch (Exception e) {
		                    Log.i(OnlineTest.this.tag, "Failed to Launch Settings [" + e.getMessage() + "]");
		                }
		            }
		        });
		}

		@Override
		protected void onActivityResult(int requestCode, int resultCode,
				Intent data) {
			// TODO Auto-generated method stub
			 switch (requestCode) {
	            case ACTIVITY_REFRESHQUESTIONS:
	            	 startActivity(new Intent(OnlineTest.this, ManageQuestions.class));
	            	 break;
	                
	            case ACTIVITY_LISTQUESTIONS:
	                break;
	            case ACTIVITY_SETTINGS:
	                RefreshUserInfo();
	                break;
	        };
		}
		private void RefreshUserInfo() {
	        try {
	            final TextView subjectlabel = (TextView) findViewById(R.id.subjectlabel);
	            subjectlabel.setText("Class: " + this.myprefs.getClass1()+"\nRoll: " + this.myprefs.getRoll() + "\n");
	        } catch (Exception e) {
	        		
	        }
	    }
		

		
	    
}
