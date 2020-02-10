package com.idsoft.firebase_title.analytics;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.idsoft.firebase_title.R;

public class onetActivity extends AppCompatActivity {

    private Fanalytics mFanlytics = null;
    private WebView mFanlyticsWebView = null;

    @SuppressLint("JavascriptInterface")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);

        mFanlyticsWebView = findViewById(R.id.webview);
        mFanlyticsWebView.getSettings().setJavaScriptEnabled(true);
        mFanlyticsWebView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1){
            mFanlyticsWebView.addJavascriptInterface(new AnalyticsWebInterface(this), AnalyticsWebInterface.TAG);
        }else {
            ;
        }

        //2.10

        mFanlyticsWebView.loadUrl("https://google.com");

        mFanlytics = new Fanalytics();
        mFanlytics.initFirebaseAnalytics(this);
        mFanlytics.sendLogEvent(Fanalytics.FIREBASE_ITEMID_ONEACTIVITY,  Fanalytics.FIREBASE_ITEMANME_ONEACTIVITY);

        mFanlytics.setUserProperty("favoerte_food", "apple");
    }
}
