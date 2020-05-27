package com.smit.tracertcovid_19;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class cityOverallStatsActivity extends AppCompatActivity {
    private WebView cityOverallStatsWebview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_city_overall_stats);
        cityOverallStatsWebview = (WebView) findViewById(R.id.wv_cityOverallStats);
        cityOverallStatsWebview.setWebViewClient(new WebViewClient());
        cityOverallStatsWebview.loadUrl("https://santemontreal.qc.ca/en/public/coronavirus-covid-19");
        cityOverallStatsWebview.getSettings().setDomStorageEnabled(true);

        WebSettings webSettings = cityOverallStatsWebview.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }
}
