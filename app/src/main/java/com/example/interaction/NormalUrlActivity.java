package com.example.interaction;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

/**
 * Description 普通url拦截的例子:
 * Author: zhangxb.
 * Date: 2018/3/1.
 */

public class NormalUrlActivity extends Activity {
    private WebView mWebView;
    private Button nativeButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        initView();
    }

    private void initView() {

        mWebView = findViewById(R.id.webview);
        String url = "https://subao-test.zhongan.com/subao-h5/iCloudInsurance/insureHome.html?partnerChannelCode=j7k4cfxb";
//        mWebView.loadUrl("file:///android_asset/demo.html");
        mWebView.loadUrl(url);
        mWebView.setWebViewClient(new MyWebViewClient());
        mWebView.getSettings().setJavaScriptEnabled(true);
        nativeButton = findViewById(R.id.btn_native);
        nativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }


    class MyWebViewClient extends WebViewClient {

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            String url = view.getUrl();
            Log.d("Tag", url);
            if(url.contains("showToast")){
                ToastUtils.showToast(NormalUrlActivity.this, "只是一个来自web的toast!");
            }

            return super.shouldOverrideUrlLoading(view, request);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }


        @Override
        public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
            super.onReceivedError(view, errorCode, description, failingUrl);
            Log.d("Tag", "onReceivedError:" + errorCode + "   " + description);
        }


        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
            Log.d("Tag", "onReceivedError2:" + request + "   " + error.getDescription());
        }

        @Override
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            super.onReceivedHttpError(view, request, errorResponse);
            Log.d("Tag", "onReceivedHttpError:" + errorResponse.toString());
        }

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            super.onReceivedSslError(view, handler, error);
            Log.d("Tag", "onReceivedSslError:" + error.toString());
        }
    }
}
