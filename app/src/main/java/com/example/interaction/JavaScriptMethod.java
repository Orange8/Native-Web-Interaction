package com.example.interaction;

import android.content.Context;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;

/**
 * Description:
 * Author: zhangxb.
 * Date: 2018/3/1.
 */

public class JavaScriptMethod {
    public static final String JAVAINTERFACE = "javaInterface";
    private Context mContext;
    private WebView mWebView;
    public JavaScriptMethod(Context context, WebView webView) {
        mContext = context;
        mWebView = webView;
    }

    @JavascriptInterface
    public void showToast(String json){
        ToastUtils.showToast(mContext, json);
    }
}
