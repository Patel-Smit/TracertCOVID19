package com.smit.tracertcovid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class selfcheckActivity extends AppCompatActivity {
private WebView selfcheckWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selfcheck);
        selfcheckWebview = (WebView) findViewById(R.id.wv_selfcheck);
        selfcheckWebview.setWebViewClient(new WebViewClient());
        selfcheckWebview.loadUrl("https://ca.thrive.health/covid19/en");
        //selfcheckWebview.getSettings().setBuiltInZoomControls(false);
        //selfcheckWebview.getSettings().setSupportZoom(false);
        //selfcheckWebview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        //selfcheckWebview.getSettings().setAllowFileAccess(true);
        selfcheckWebview.getSettings().setDomStorageEnabled(true);

        WebSettings webSettings = selfcheckWebview.getSettings();
        webSettings.setJavaScriptEnabled(true);

    }
}
