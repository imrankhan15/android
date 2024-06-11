package com.edu.myfacerecognizer;

import java.io.File;
import java.io.FilenameFilter;

import com.googlecode.javacv.cpp.opencv_core.IplImage;
import com.googlecode.javacv.cpp.opencv_core.MatVector;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;

import static com.googlecode.javacv.cpp.opencv_highgui.*;
import static com.googlecode.javacv.cpp.opencv_core.*;
import static com.googlecode.javacv.cpp.opencv_imgproc.*;
import static com.googlecode.javacv.cpp.opencv_contrib.*;
import java.io.File;
import java.io.FilenameFilter;
import java.awt.image.BufferedImage;

public class OpenCVFaceRecognizer extends Activity {

	protected static final String TAG = "opencv";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		File s = Environment.getExternalStorageDirectory();
		String s2 = s.getPath() + "/testPic.png";
		String s3 = s.getPath() + "/test";
		Log.i(TAG, s2 + s3);
		String trainingDir = s3;
		IplImage testImage = cvLoadImage(s2);

		File root = null;

		root = new File(s3);

		Log.i(TAG, "" + root.getName());
		FilenameFilter pgmFilter = new FilenameFilter() {
			public boolean accept(File dir, String name) {

				return name.toLowerCase().endsWith(".png");
			}
		};

		File[] imageFiles = root.listFiles(pgmFilter);
		Log.i(TAG, "" + imageFiles.length);
		MatVector images = new MatVector(imageFiles.length);

		int[] labels = new int[imageFiles.length];

		int counter = 0;
		int label;

		IplImage img;
		IplImage grayImg;

		for (File image : imageFiles) {
			img = cvLoadImage(image.getAbsolutePath());

			label = Integer.parseInt(image.getName().split("\\-")[0]);
			Log.i(TAG, image.getName());
			grayImg = IplImage.create(img.width(), img.height(), IPL_DEPTH_8U,
					1);

			cvCvtColor(img, grayImg, CV_BGR2GRAY);

			images.put(counter, grayImg);

			labels[counter] = label;

			counter++;
		}

		IplImage greyTestImage = IplImage.create(testImage.width(),
				testImage.height(), IPL_DEPTH_8U, 1);

		// FaceRecognizer faceRecognizer = createFisherFaceRecognizer();
		// FaceRecognizer faceRecognizer = createEigenFaceRecognizer();
		FaceRecognizer faceRecognizer = createLBPHFaceRecognizer();

		faceRecognizer.train(images, labels);

		cvCvtColor(testImage, greyTestImage, CV_BGR2GRAY);

		int predictedLabel = faceRecognizer.predict(greyTestImage);
		if (predictedLabel == 1) {
			startActivity(new Intent(getApplication(),
					login.class));
			
		} else if (predictedLabel == 4) {
			startActivity(new Intent(getApplication(),
					facedetectionexample.class));
			  
			  
			  // show it alertDialog.show();
			

		} else {

		}

		/*
		 * AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
		 * this);
		 * 
		 * // set title alertDialogBuilder.setTitle("Your Title");
		 * 
		 * // set dialog message alertDialogBuilder
		 * .setMessage("Your label"+predictedLabel)
		 * 
		 * ;
		 * 
		 * // create alert dialog AlertDialog alertDialog =
		 * alertDialogBuilder.create();
		 * 
		 * // show it alertDialog.show();
		 */
	}

}
