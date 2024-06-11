package com.edu.myfacerecognizer;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.http.util.ByteArrayBuffer;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.ImageView.ScaleType;

public class DownLoadActivity extends Activity implements OnClickListener {
	Prefs myprefs = null;
	private static final String TAG = "Imran";
	private boolean isImage = false;
	private String reviewImageLink;
	File sdImageMainDirectory;
	Button loginw, close;
	EditText stdid;
	TextView tview;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login);
		close = (Button) findViewById(R.id.closeapp);
		loginw = (Button) findViewById(R.id.login);
		stdid = (EditText) findViewById(R.id.password);
		stdid.setTextColor(Color.BLACK);
		tview = (TextView) findViewById(R.id.loginerrormsg);
		loginw.setOnClickListener(this);
		close.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				moveTaskToBack(true);
			}
		});
		this.myprefs = new Prefs(getApplicationContext());

		String filepath = Environment.getExternalStorageDirectory() + "/test";
		File myFile = new File(filepath);
		if (myFile.exists())
			myFile.delete();
		sdImageMainDirectory = new File(
				Environment.getExternalStorageDirectory(), "test");
		sdImageMainDirectory.mkdirs();

	}

	class DoReadQuestions implements Runnable {

		int i;
		int lev;
		URL url;

		DoReadQuestions(int id, int level) {
			i = id;
			lev = level;
		}

		@Override
		public void run() {
			try {
				
				URL reviewImageURL;
				String name = reviewImageLink.substring(reviewImageLink
						.lastIndexOf("/") + 1);

				reviewImageURL = new URL(reviewImageLink);

				if (!hasExternalStoragePublicPicture(name)) {
					isImage = false;
					new DownloadImageTask().execute(reviewImageLink);
					Log.v("log_tag", "if");
					isImage = true;

					File file = new File(sdImageMainDirectory, name);
					Log.v("log_tag", "Directory created");

				}
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	private class DownloadImageTask extends AsyncTask<String, Integer, Bitmap> {
		// This class definition states that DownloadImageTask will take String
		// parameters, publish Integer progress updates, and return a Bitmap
		protected Bitmap doInBackground(String... paths) {
			URL url;
			String line;
			String fileName;
			try {
				line = paths[0];
				fileName = line.substring(line.lastIndexOf("/") + 1);
				url = new URL(paths[0]);
				HttpURLConnection connection = (HttpURLConnection) url
						.openConnection();
				int length = connection.getContentLength();
				InputStream is = (InputStream) url.getContent();
				byte[] imageData = new byte[length];
				int buffersize = (int) Math.ceil(length / (double) 100);
				int downloaded = 0;
				int read;
				while (downloaded < length) {
					if (length < buffersize) {
						read = is.read(imageData, downloaded, length);
					} else if ((length - downloaded) <= buffersize) {
						read = is.read(imageData, downloaded, length
								- downloaded);
					} else {
						read = is.read(imageData, downloaded, buffersize);
					}
					downloaded += read;
					publishProgress((downloaded * 100) / length);
				}
				Bitmap bitmap = BitmapFactory.decodeByteArray(imageData, 0,
						length);
				saveFile(bitmap, fileName);
				if (bitmap != null) {
					Log.i(TAG, "Bitmap created");
				} else {
					Log.i(TAG, "Bitmap not created");
				}
				is.close();
				String precision = line.substring(line.lastIndexOf("_") + 1,
						line.lastIndexOf("_") + 2);
				int pre = Integer.parseInt(precision);
				if (pre == 4) {
					startActivity(new Intent(getApplication(),
							MainActivity.class));
				}
				return bitmap;
			} catch (MalformedURLException e) {
				Log.e(TAG, "Malformed exception: " + e.toString());
			} catch (IOException e) {
				Log.e(TAG, "IOException: " + e.toString());
			} catch (Exception e) {
				Log.e(TAG, "Exception: " + e.toString());
			}
			return null;

		}

		protected void onPostExecute() {
			/*
			 * String name = reviewImageLink.substring(reviewImageLink
			 * .lastIndexOf("/") + 1); if (result != null) {
			 * hasExternalStoragePublicPicture(name); // saveToSDCard(result,
			 * name); saveFile(result, name); isImage = true;
			 * 
			 * } else { isImage = false;
			 * 
			 * }
			 */
			// startActivity(new Intent(getApplication(), MainActivity.class));
		}
	}

	public void saveToSDCard(Bitmap bitmap, String name) {
		boolean mExternalStorageAvailable = false;
		boolean mExternalStorageWriteable = false;
		String state = Environment.getExternalStorageState();
		if (Environment.MEDIA_MOUNTED.equals(state)) {
			mExternalStorageAvailable = mExternalStorageWriteable = true;
			Log.v(TAG, "SD Card is available for read and write "
					+ mExternalStorageAvailable + mExternalStorageWriteable);
			saveFile(bitmap, name);
		} else if (Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
			mExternalStorageAvailable = true;
			mExternalStorageWriteable = false;
			Log.v(TAG, "SD Card is available for read "
					+ mExternalStorageAvailable);
		} else {
			mExternalStorageAvailable = mExternalStorageWriteable = false;
			Log.v(TAG, "Please insert a SD Card to save your Video "
					+ mExternalStorageAvailable + mExternalStorageWriteable);
		}
	}

	private void saveFile(Bitmap bitmap, String name) {
		String filename = name;
		ContentValues values = new ContentValues();

		File outputFile = new File(sdImageMainDirectory, filename);
		values.put(MediaStore.MediaColumns.DATA, outputFile.toString());
		values.put(MediaStore.MediaColumns.TITLE, filename);
		values.put(MediaStore.MediaColumns.DATE_ADDED,
				System.currentTimeMillis());
		values.put(MediaStore.MediaColumns.MIME_TYPE, "image/png");
		Uri uri = this.getContentResolver().insert(
				android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI,

				values);
		try {
			OutputStream outStream = this.getContentResolver()
					.openOutputStream(uri);
			bitmap.compress(Bitmap.CompressFormat.PNG, 95, outStream);

			outStream.flush();
			outStream.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private boolean hasExternalStoragePublicPicture(String name) {

		File file = new File(sdImageMainDirectory, name);
		if (file != null) {
			file.delete();
		}
		return file.exists();
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

		// TODO Auto-generated method stub
		String s1 = stdid.getText().toString();
		DownLoadActivity.this.myprefs.setRoll(s1);
		
		DownLoadActivity.this.myprefs.save();
		
		// + lev
		// + "-d_" + i + ".png";

		for (int i = 1; i < 4; i++) {
			reviewImageLink = " http://10.0.2.2:80/server/" + s1 + "/"+ 1 + "-d_" + i + ".png";
			Thread workthread = new Thread(new DoReadQuestions(i, 1));
			
			workthread.start();
		}
		reviewImageLink = " http://10.0.2.2:80/server/" + s1 + "/"+ 4 + "-d_" + 4 + ".png";
		Thread workthread = new Thread(new DoReadQuestions(4, 4));

		workthread.start();
	}

}
