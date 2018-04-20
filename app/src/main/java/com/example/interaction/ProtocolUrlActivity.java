package com.example.interaction;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


/**
 * Description 走约定协议的url拦截例子:
 * Author: zhangxb.
 * Date: 2018/3/1.
 */

public class ProtocolUrlActivity extends Activity {
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
        mWebView.loadUrl("file:///android_asset/demo.html");
        mWebView.setWebViewClient(new MyWebViewClient());
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
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
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            Log.d("Tag", "shouldOverrideUrlLoading: " + url);

            try {
                if(url.startsWith("demo")){
                    ToastUtils.showToast(ProtocolUrlActivity.this, "只是一个来自web的toast!");
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
            return super.shouldOverrideUrlLoading(view, url);
        }

        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
        }
    }
}
