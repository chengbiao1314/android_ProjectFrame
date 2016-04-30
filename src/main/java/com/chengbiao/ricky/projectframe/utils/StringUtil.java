package com.chengbiao.ricky.projectframe.utils;

import android.content.Context;

/**
 * Created by ChengBiao on 2016/4/26.
 */
public class StringUtil {
    private static StringUtil instance;

    public static synchronized StringUtil getInstance() {
        if (instance == null) {
            instance = new StringUtil();
        }
        return instance;
    }

    public String getStringFromRes(Context context,int id){
        return context.getResources().getString(id);
    }
}
