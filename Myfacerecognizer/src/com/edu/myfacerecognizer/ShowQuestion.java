package com.edu.myfacerecognizer;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.TimeZone;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.xml.sax.InputSource;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.TabActivity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.ScrollView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TextView;
import android.widget.SlidingDrawer;
import android.widget.SlidingDrawer.OnDrawerCloseListener;
import android.widget.SlidingDrawer.OnDrawerOpenListener;

public class ShowQuestion extends TabActivity implements OnClickListener,
		OnTabChangeListener {
	private Context _context = null;
	int chapID;
	int result;
	int result1;
	int result2;
	int result3;
	int result4;
	Prefs myprefs = null;
	QuestionEntry je = null;
	int RealAnswer = 0;
	String m[] = new String[3];
	Button submit;
	TextView passage, bookname, chaptername, startpage, endpage;
	TextView question1;
	TextView question2;
	TextView question3;
	TextView question4;
	TextView rev1;

	Button feedback;
	ScrollView s1, s2, s3, s4;

	RadioGroup answers1, answers2, answers3, answers4, rev;

	RadioButton answer11, answer12, answer13, answer14, answer21, answer22,
			answer23, answer24, answer31, answer32, answer33, answer34,
			answer41, answer42, answer43, answer44, revw1, revw2, revw3, revw4;
	SlidingDrawer drawer1, drawer2, drawer3, drawer4;
	TabHost tabhost;
	TabSpec ts1, ts2, ts3;
	WebView wb;
	String review;

	Intent startingIntent;

	@Override
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		_context = this;
		result = 0;
		result1 = 0;
		result2 = 0;
		result3 = 0;
		result4 = 0;
		setContentView(R.layout.showquestion);

		this.myprefs = new Prefs(getApplicationContext());

		chapID = ShowQuestion.this.myprefs.getChapId();
		wb = (WebView) findViewById(R.id.webView1);
		wb.getSettings().setJavaScriptEnabled(true);
		wb.getSettings().setLoadWithOverviewMode(true);
		wb.getSettings().setUseWideViewPort(true);
		rev1 = (TextView) findViewById(R.id.review);
		rev = (RadioGroup) findViewById(R.id.rev);
		revw1 = (RadioButton) findViewById(R.id.rev1);
		revw2 = (RadioButton) findViewById(R.id.rev2);
		revw3 = (RadioButton) findViewById(R.id.rev3);
		revw4 = (RadioButton) findViewById(R.id.rev4);
		feedback = (Button) findViewById(R.id.submit);
		submit = (Button) findViewById(R.id.button1);
		drawer1 = (SlidingDrawer) findViewById(R.id.slidingDrawer1);
		drawer2 = (SlidingDrawer) findViewById(R.id.slidingDrawer2);
		drawer3 = (SlidingDrawer) findViewById(R.id.slidingDrawer3);
		drawer4 = (SlidingDrawer) findViewById(R.id.slidingDrawer4);
		s1 = (ScrollView) findViewById(R.id.S1);
		s2 = (ScrollView) findViewById(R.id.S2);
		s3 = (ScrollView) findViewById(R.id.S3);
		s4 = (ScrollView) findViewById(R.id.S4);

		passage = (TextView) findViewById(R.id.Passage);
		bookname = (TextView) findViewById(R.id.bookname);
		chaptername = (TextView) findViewById(R.id.chaptername);
		startpage = (TextView) findViewById(R.id.startpage);
		endpage = (TextView) findViewById(R.id.endpage);
		question1 = (TextView) findViewById(R.id.Question1);
		question2 = (TextView) findViewById(R.id.Question2);
		question3 = (TextView) findViewById(R.id.Question3);
		question4 = (TextView) findViewById(R.id.Question4);
		answers1 = (RadioGroup) findViewById(R.id.Answers1);
		answers2 = (RadioGroup) findViewById(R.id.Answers2);
		answers3 = (RadioGroup) findViewById(R.id.Answers3);
		answers4 = (RadioGroup) findViewById(R.id.Answers4);

		answer11 = (RadioButton) findViewById(R.id.answer11);
		answer12 = (RadioButton) findViewById(R.id.answer12);
		answer13 = (RadioButton) findViewById(R.id.answer13);
		answer14 = (RadioButton) findViewById(R.id.answer14);

		answer21 = (RadioButton) findViewById(R.id.answer21);
		answer22 = (RadioButton) findViewById(R.id.answer22);
		answer23 = (RadioButton) findViewById(R.id.answer23);
		answer24 = (RadioButton) findViewById(R.id.answer24);

		answer31 = (RadioButton) findViewById(R.id.answer31);
		answer32 = (RadioButton) findViewById(R.id.answer32);
		answer33 = (RadioButton) findViewById(R.id.answer33);
		answer34 = (RadioButton) findViewById(R.id.answer34);

		answer41 = (RadioButton) findViewById(R.id.answer41);
		answer42 = (RadioButton) findViewById(R.id.answer42);
		answer43 = (RadioButton) findViewById(R.id.answer43);
		answer44 = (RadioButton) findViewById(R.id.answer44);

		Typeface font = Typeface.createFromAsset(getAssets(),
				"SolaimanLipi_20-04-07.ttf");
		question1.setTypeface(font);
		question2.setTypeface(font);
		question3.setTypeface(font);
		question4.setTypeface(font);
		answer11.setTypeface(font);
		answer12.setTypeface(font);
		answer13.setTypeface(font);
		answer14.setTypeface(font);
		answer21.setTypeface(font);
		answer22.setTypeface(font);
		answer23.setTypeface(font);
		answer24.setTypeface(font);
		answer31.setTypeface(font);
		answer32.setTypeface(font);
		answer33.setTypeface(font);
		answer34.setTypeface(font);
		answer41.setTypeface(font);
		answer42.setTypeface(font);
		answer43.setTypeface(font);
		answer44.setTypeface(font);

		this.myprefs = new Prefs(getApplicationContext());

		String details = null;

		startingIntent = getIntent();

		if (startingIntent != null) {
			Log.i("ShowQuestion", "starting intent not null");
			Bundle b = startingIntent.getExtras();
			if (b == null) {
				Log.i("ShowQuestion", "bad bundle");
				details = "bad bundle?";
			} else {
				this.je = QuestionEntry.fromBundle(b);
				final int i = this.je.get_pid();
				int visibility = 0;
				passage.setText("");
				bookname.setText("");
				chaptername.setText("");
				startpage.setText("");
				endpage.setText("");
				if (i == 4) {

					bookname.setText(this.je.get_bookName());

					chaptername.setText(this.je.get_chapterName());

					startpage.setText("Section Details:\n\nStarting PageNo:"
							+ String.valueOf(this.je.get_startPage()));
					Log.d("thesis", "_questionlist is null");
					endpage.setText("Ending PageNo:"
							+ String.valueOf(this.je.get_endPage()));
					passage.setVisibility(8);

				} else {
					bookname.setVisibility(8);
					chaptername.setVisibility(8);
					startpage.setVisibility(8);
					endpage.setVisibility(8);
					passage.setText("Passage Details:\n\n"
							+ this.je.get_passageText());

				}
				Log.i("ShowQuestion", "bad bundle");

				question1.setText(this.je.get_questionText1());
				Log.i("ShowQuestion", "bad bundle");

				question2.setText(this.je.get_questionText2());
				question3.setText(this.je.get_questionText3());
				question4.setText(this.je.get_questionText4());
				answer11.setText(this.je.get_answerText11());
				answer12.setText(this.je.get_answerText12());
				answer13.setText(this.je.get_answerText13());
				answer14.setText(this.je.get_answerText14());
				answer21.setText(this.je.get_answerText21());
				answer22.setText(this.je.get_answerText22());
				answer23.setText(this.je.get_answerText23());
				answer24.setText(this.je.get_answerText24());
				answer31.setText(this.je.get_answerText31());
				answer32.setText(this.je.get_answerText32());
				answer33.setText(this.je.get_answerText33());
				answer34.setText(this.je.get_answerText34());
				answer41.setText(this.je.get_answerText41());
				answer42.setText(this.je.get_answerText42());
				answer43.setText(this.je.get_answerText43());
				answer44.setText(this.je.get_answerText44());
				submit.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						tabhost.setVisibility(8);
						rev1.setVisibility(0);
						rev.setVisibility(0);
						feedback.setVisibility(0);
					}

				});
				review = "";
				rev.setOnCheckedChangeListener(new OnCheckedChangeListener() {

					@Override
					public void onCheckedChanged(RadioGroup arg0, int arg1) {
						// TODO Auto-generated method stub
						if (revw1.isChecked()) {
							review = "Easy";

						} else if (revw2.isChecked()) {
							review = "Medium";
						} else if (revw3.isChecked()) {
							review = "Hard";
						} else if (revw4.isChecked()) {
							review = "Very Hard";
						} else {

						}

					}

				});
				feedback.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						// TODO Auto-generated method stub
						String s1 = review;
						result = result1 + result2 + result3 + result4;
						int passed = 0;
						if (result > 15)
							passed = 1;
						String pid = String.valueOf(je.get_pid());
						String sid = String.valueOf(je.get_sid());
						String roll = je.get_roll();

						Thread workthread = new Thread(new DoReadQuestions(
								passed, s1));

						workthread.start();
						AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
								ShowQuestion.this);

						// set title
						alertDialogBuilder.setTitle("Reviewers comment");
						String msg = "";
						if (passed == 1) {
							msg = "Congrates!!! You are promoted to next level";
						} else {
							msg = "Good Try,try next test please";
						}

						// set dialog message
						alertDialogBuilder
								.setMessage(msg)
								.setCancelable(false)
								.setPositiveButton("Close Test",
										new DialogInterface.OnClickListener() {
											public void onClick(
													DialogInterface dialog,
													int id) {
												// if this button is clicked,
												// close
												// current activity
												Intent intent = new Intent(
														ShowQuestion.this,
														OnlineTest.class);
												ShowQuestion.this
														.startActivity(intent);
											}
										})

						;

						// create alert dialog
						AlertDialog alertDialog = alertDialogBuilder.create();

						// show it
						alertDialog.show();
					}

				});
				drawer1.setOnDrawerOpenListener(new OnDrawerOpenListener() {
					@Override
					public void onDrawerOpened() {
						// TODO Auto-generated method stub

						s1.setVisibility(8);

					}
				});
				final QuestionEntry e1 = this.je;
				drawer1.setOnDrawerCloseListener(new OnDrawerCloseListener() {
					@Override
					public void onDrawerClosed() {
						// TODO Auto-generated method stub
						if (i == 4) {
							s1.setVisibility(0);
							bookname.setVisibility(0);
							chaptername.setVisibility(0);
							startpage.setVisibility(0);
							endpage.setVisibility(0);
							passage.setVisibility(8);

						} else {
							s1.setVisibility(0);
							passage.setVisibility(0);
							bookname.setVisibility(8);
							chaptername.setVisibility(8);
							startpage.setVisibility(8);
							endpage.setVisibility(8);
						}

					}
				});
				drawer2.setOnDrawerOpenListener(new OnDrawerOpenListener() {
					@Override
					public void onDrawerOpened() {
						// TODO Auto-generated method stub
						s2.setVisibility(8);

					}
				});

				drawer2.setOnDrawerCloseListener(new OnDrawerCloseListener() {
					@Override
					public void onDrawerClosed() {
						// TODO Auto-generated method stub
						s2.setVisibility(0);

					}
				});
				drawer3.setOnDrawerOpenListener(new OnDrawerOpenListener() {
					@Override
					public void onDrawerOpened() {
						// TODO Auto-generated method stub
						s3.setVisibility(8);

					}
				});

				drawer3.setOnDrawerCloseListener(new OnDrawerCloseListener() {
					@Override
					public void onDrawerClosed() {
						// TODO Auto-generated method stub
						s3.setVisibility(0);

					}
				});
				drawer4.setOnDrawerOpenListener(new OnDrawerOpenListener() {
					@Override
					public void onDrawerOpened() {
						// TODO Auto-generated method stub
						s4.setVisibility(8);

					}
				});

				drawer4.setOnDrawerCloseListener(new OnDrawerCloseListener() {
					@Override
					public void onDrawerClosed() {
						// TODO Auto-generated method stub
						s4.setVisibility(0);

					}
				});

			}
		} else {
			details = "Question Information Not Found.";
			TextView tv = (TextView) findViewById(R.id.Passage);

			tv.setText(details);
			return;
		}

		final QuestionEntry check = this.je;
		answers1.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (answer11.isChecked()) {
					if (check.get_answerReal11() == 1) {
						result1 += 5;
					} else {
						if (result1 > 0) {
							result1 -= 5;
						}
					}
				} else if (answer12.isChecked()) {
					if (check.get_answerReal12() == 1) {
						result1 += 5;
					} else {
						if (result1 > 0) {
							result1 -= 5;
						}
					}
				} else if (answer13.isChecked()) {
					if (check.get_answerReal13() == 1) {
						result1 += 5;
					} else {
						if (result1 > 0) {
							result1 -= 5;
						}
					}
				} else if (answer14.isChecked()) {
					if (check.get_answerReal14() == 1) {
						result1 += 5;
					} else {
						if (result1 > 0) {
							result1 -= 5;
						}
					}
				} else {

				}

			}

		});
		answers2.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (answer21.isChecked()) {
					if (check.get_answerReal21() == 1) {
						result2 += 5;
					} else {
						if (result2 > 0) {
							result2 -= 5;
						}
					}
				} else if (answer22.isChecked()) {
					if (check.get_answerReal22() == 1) {
						result2 += 5;
					} else {
						if (result2 > 0) {
							result2 -= 5;
						}
					}
				} else if (answer23.isChecked()) {
					if (check.get_answerReal23() == 1) {
						result2 += 5;
					} else {
						if (result2 > 0) {
							result2 -= 5;
						}
					}
				} else if (answer24.isChecked()) {
					if (check.get_answerReal24() == 1) {
						result2 += 5;
					} else {
						if (result2 > 0) {
							result2 -= 5;
						}
					}
				} else {

				}

			}

		});
		answers3.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (answer31.isChecked()) {
					if (check.get_answerReal31() == 1) {
						result3 += 5;
					} else {
						if (result3 > 0) {
							result3 -= 5;
						}
					}
				} else if (answer32.isChecked()) {
					if (check.get_answerReal32() == 1) {
						result3 += 5;
					} else {
						if (result3 > 0) {
							result3 -= 5;
						}
					}
				} else if (answer33.isChecked()) {
					if (check.get_answerReal33() == 1) {
						result3 += 5;
					} else {
						if (result3 > 0) {
							result3 -= 5;
						}
					}
				} else if (answer34.isChecked()) {
					if (check.get_answerReal34() == 1) {
						result3 += 5;
					} else {
						if (result3 > 0) {
							result3 -= 5;
						}
					}
				} else {

				}

			}

		});
		answers4.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			public void onCheckedChanged(RadioGroup group, int checkedId) {
				if (answer41.isChecked()) {
					if (check.get_answerReal41() == 1) {
						result4 += 5;
					} else {
						if (result4 > 0) {
							result4 -= 5;
						}
					}
				} else if (answer42.isChecked()) {
					if (check.get_answerReal42() == 1) {
						result4 += 5;
					} else {
						if (result4 > 0) {
							result4 -= 5;
						}
					}
				} else if (answer43.isChecked()) {
					if (check.get_answerReal43() == 1) {
						result4 += 5;
					} else {
						if (result4 > 0) {
							result4 -= 5;
						}
					}
				} else if (answer44.isChecked()) {
					if (check.get_answerReal44() == 1) {
						result4 += 5;
					} else {
						if (result4 > 0) {
							result4 -= 5;
						}
					}
				} else {

				}

			}

		});

		tabhost = (TabHost) findViewById(android.R.id.tabhost);
		tabhost.setup();
		ts1 = tabhost.newTabSpec("Exam");
		ts1.setIndicator("Exam");
		ts1.setContent(R.id.Exam);
		tabhost.addTab(ts1);

		ts2 = tabhost.newTabSpec("HelpFromOnline");
		ts2.setIndicator("HelpFromOnline");
		ts2.setContent(R.id.HelpFromOnline);

		tabhost.addTab(ts2);
		ts3 = tabhost.newTabSpec("PDFviewer");
		ts3.setIndicator("PDFviewer");
		ts3.setContent(R.id.PDFviewer);

		tabhost.addTab(ts3);
		tabhost.setCurrentTab(0);
		tabhost.setOnTabChangedListener(new OnTabChangeListener() {

			public void onTabChanged(String tabId) {

				switch (tabhost.getCurrentTab()) {
				case 0:
					// do what you want when tab 0 is selected
					break;
				case 1:
					// do what you want when tab 1 is selected
					wb.setWebViewClient(new ourWebViewClient());
					wb.loadUrl("http://www.google.com");
					break;
				case 2:
					// do what you want when tab 1 is selected
					Intent intent = new Intent(ShowQuestion.this, First.class);
					ShowQuestion.this.startActivity(intent);
					break;

				default:

					break;
				}
			}
		});

	}

	class DoReadQuestions implements Runnable {

		int passed = 0;
		String feedback = "";

		DoReadQuestions(int pass, String feed) {
			passed = pass;
			feedback = feed;
		}

		@Override
		public void run() {
			String pid = String.valueOf(je.get_pid());
			String sid = String.valueOf(je.get_sid());
			String roll = je.get_roll();
			String subject = je.get_subject();
			// TODO Auto-generated method stub
			String passed1 = String.valueOf(passed);
			/**/
			ArrayList<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(
					6);
			nameValuePairs.add(new BasicNameValuePair("subject", subject));
			nameValuePairs.add(new BasicNameValuePair("roll", roll));
			nameValuePairs.add(new BasicNameValuePair("passed", passed1));
			nameValuePairs.add(new BasicNameValuePair("pid", pid));
			nameValuePairs.add(new BasicNameValuePair("sid", sid));
			nameValuePairs.add(new BasicNameValuePair("feedback", feedback));

			sendData(nameValuePairs);

		}

	}

	@Override
	public void onClick(View arg0) {

	}

	private void sendData(ArrayList<NameValuePair> data) {
		// TODO Auto-generated method stub
		try {
			HttpClient httpclient = new DefaultHttpClient();
			HttpPost httppost = new HttpPost(
			 "http://10.0.2.2:80/server/index.php/insert_history");

					//"http://www.tstuff.site90.com/server/index.php/insert_history");
			httppost.setEntity(new UrlEncodedFormEntity(data));
			HttpResponse response = httpclient.execute(httppost);
		} catch (Exception e) {
			Log.e("log_tag", "Error:  " + e.toString());
		}

	}

	@Override
	public void onTabChanged(String arg0) {
		// TODO Auto-generated method stub

	}

}
