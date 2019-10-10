package com.example.webprogress;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    WebView webView;
    ProgressDialog pd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     webView = findViewById(R.id.webview);
     pd = new ProgressDialog(MainActivity.this);


     String link = "https://www.bbc.com/weather/6077243";


     webView.setWebViewClient(new Mywebview());

     webView.getSettings().setJavaScriptEnabled(true);

     webView.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);


     webView.getSettings().setLoadsImagesAutomatically(true);

     webView.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);

        webView.getSettings().setDomStorageEnabled(true);

   webView.loadUrl(link);

    }


    // custom client browser
    public class Mywebview extends WebViewClient {


        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);

            pd.setMessage("its loading");

            pd.setTitle("webpage is loading");

            pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);

            pd.show();


        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {

         view.loadUrl(url);



            return super.shouldOverrideUrlLoading(view, url);

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);

        pd.dismiss();

        }
    }


}
