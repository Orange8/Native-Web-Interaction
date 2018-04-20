package com.example.interaction;

import android.content.Context;
import android.widget.Toast;

/**
 * Description:
 * Author: zhangxb.
 * Date: 2018/3/1.
 */

public class ToastUtils {
    public static void showToast(Context context, String msg){
        Toast.makeText(context, msg, Toast.LENGTH_SHORT).show();
    }
}
