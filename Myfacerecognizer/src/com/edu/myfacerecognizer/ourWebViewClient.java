package com.edu.myfacerecognizer;

import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ourWebViewClient extends WebViewClient {
	@Override
	public boolean shouldOverrideUrlLoading(WebView v,String url){
		v.loadUrl(url);
		return true;
	}

}
