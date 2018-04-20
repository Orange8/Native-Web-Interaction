package com.example.interaction;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.webkit.WebSettings;
import android.widget.Button;

import com.github.lzyzsd.jsbridge.BridgeHandler;
import com.github.lzyzsd.jsbridge.BridgeWebView;
import com.github.lzyzsd.jsbridge.CallBackFunction;
import com.google.gson.Gson;

/**
 * Description 走JSbridge的例子:
 * Author: zhangxb.
 * Date: 2018/3/1.
 */

public class JsBridgeActivity extends Activity {
    BridgeWebView bridgeWebView;
    private Button nativeButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jsbridge_webview);
        initView();
    }

    private void initView() {
        bridgeWebView = findViewById(R.id.webview);
        bridgeWebView.getSettings().setJavaScriptEnabled(true);
        bridgeWebView.getSettings().setCacheMode(WebSettings.LOAD_DEFAULT);
        bridgeWebView.loadUrl("file:///android_asset/demo.html");

        nativeButton = findViewById(R.id.btn_native);
        nativeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                bridgeWebView.callHandler("functionInJs", new Gson().toJson(new User()), new CallBackFunction() {
                    @Override
                    public void onCallBack(String data) {
                        ToastUtils.showToast(JsBridgeActivity.this, "response data from web:" + data);
                    }
                });
            }
        });

        bridgeWebView.registerHandler("submitFromWeb", new BridgeHandler() {
            @Override
            public void handler(String data, CallBackFunction function) {

                ToastUtils.showToast(JsBridgeActivity.this, "handler = submitFromWeb, data from web = " + data);

                function.onCallBack("response data from Java");
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
}
