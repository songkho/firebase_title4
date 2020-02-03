package com.idsoft.firebase_title.hosting;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.idsoft.firebase_title.R;

public class hosting extends AppCompatActivity {

    private WebView mWebView = null;


    public class WebCustomClient extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            return false;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hosting);

        mWebView  = findViewById(R.id.mywebview);
        mWebView.setWebViewClient(new WebCustomClient());
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl("https://inlaid-particle-153117.firbaseapp.com/index.html");

    }
}
