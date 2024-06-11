package com.edu.myfacerecognizer;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PointF;
import android.media.FaceDetector;
import android.media.FaceDetector.Face;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class facedetectionexample extends Activity {
	private static final int TAKE_PICTURE_CODE = 100;
	private static final int MAX_FACES = 5;

	private Bitmap cameraBitmap = null;
	

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		

		((Button) findViewById(R.id.take_picture)).setOnClickListener(btnClick);
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		if (TAKE_PICTURE_CODE == requestCode) {
			processCameraImage(data);
		}
	}

	private void openCamera() {
		Intent intent = new Intent(
				android.provider.MediaStore.ACTION_IMAGE_CAPTURE);

		startActivityForResult(intent, TAKE_PICTURE_CODE);
	}

	private void processCameraImage(Intent intent) {
		setContentView(R.layout.detect);

		((Button) findViewById(R.id.detect_face)).setOnClickListener(btnClick);

		ImageView imageView = (ImageView) findViewById(R.id.image_view);

		cameraBitmap = (Bitmap) intent.getExtras().get("data");
		cameraBitmap = cameraBitmap.createScaledBitmap(cameraBitmap, 320, 480,
				false);

		imageView.setImageBitmap(cameraBitmap);
	}

	private void detectFaces() {
		if (null != cameraBitmap) {
			int width = cameraBitmap.getWidth();
			int height = cameraBitmap.getHeight();

			FaceDetector detector = new FaceDetector(width, height, MAX_FACES);
			Face[] faces = new Face[MAX_FACES];

			Bitmap bitmap565 = Bitmap.createBitmap(width, height,
					Config.RGB_565);
			Paint ditherPaint = new Paint();
			Paint drawPaint = new Paint();

			ditherPaint.setDither(true);
			drawPaint.setColor(Color.RED);
			drawPaint.setStyle(Paint.Style.STROKE);
			drawPaint.setStrokeWidth(2);

			Canvas canvas = new Canvas();
			canvas.setBitmap(bitmap565);
			canvas.drawBitmap(cameraBitmap, 0, 0, ditherPaint);

			int facesFound = detector.findFaces(bitmap565, faces);
			PointF midPoint = new PointF();
			float eyeDistance = 0.0f;
			float confidence = 0.0f;

			Log.i("FaceDetector", "Number of faces found: " + facesFound);

			if (facesFound >0) {
				Bitmap myBitmap;
				for (int index = 0; index < facesFound; ++index) {
					faces[index].getMidPoint(midPoint);
					eyeDistance = faces[index].eyesDistance();
					confidence = faces[index].confidence();

					Log.i("FaceDetector", "Confidence: " + confidence
							+ ", Eye distance: " + eyeDistance
							+ ", Mid Point: (" + midPoint.x + ", " + midPoint.y
							+ ")");

					myBitmap = Bitmap.createBitmap(bitmap565,
							(int) (midPoint.x - eyeDistance-2.0),
							(int) (midPoint.y - eyeDistance-5.0),
							(int) (2.3 * eyeDistance),
							(int) (3 * eyeDistance));
					Bitmap bmOut = Bitmap.createBitmap(myBitmap.getWidth(),
							myBitmap.getHeight(), myBitmap.getConfig());
					// pixel information
					int A, R1, G, B;
					int pixel;
					final double GS_RED = 0.299;
					final double GS_GREEN = 0.587;
					final double GS_BLUE = 0.114;

					// get image size
					width = myBitmap.getWidth();
					height = myBitmap.getHeight();

					// scan through every single pixel
					for (int x = 0; x < width; ++x) {
						for (int y = 0; y < height; ++y) {
							// get one pixel color
							pixel = myBitmap.getPixel(x, y);
							// retrieve color of all channels
							A = Color.alpha(pixel);
							R1 = Color.red(pixel);
							G = Color.green(pixel);
							B = Color.blue(pixel);
							// take conversion up to one single value
							R1 = G = B = (int) (GS_RED * R1 + GS_GREEN * G + GS_BLUE
									* B);
							// set new pixel color to output bitmap
							bmOut.setPixel(x, y, Color.argb(A, R1, G, B));
						}
					}
					canvas.drawBitmap(bmOut, 0, 0, ditherPaint);
					
					
					
					String filepath = Environment.getExternalStorageDirectory() + "/testPic" + ".png";
					
					try {
						
						FileOutputStream outStream = new FileOutputStream(filepath) ;
						
						
						bmOut.compress(Bitmap.CompressFormat.PNG, 90,outStream);

						outStream.flush();
						outStream.close();
					} catch (FileNotFoundException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}

					ImageView imageView = (ImageView) findViewById(R.id.image_view);

					imageView.setImageBitmap(bmOut);
					 Intent intent = new Intent(facedetectionexample.this, DownLoadActivity.class);
						facedetectionexample.this.startActivity(intent);

				}
			}

		}
	}

	private View.OnClickListener btnClick = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.take_picture:
				openCamera();
				break;
			case R.id.detect_face:
				detectFaces();
				break;
			}
		}
	};
}
