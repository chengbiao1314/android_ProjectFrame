package com.chengbiao.ricky.projectframe.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;

/**
 * Created by ChengBiao on 2016/4/26.
 */
public class ValueUtil {
    private static ValueUtil instance;

    public static synchronized ValueUtil getInstance() {
        if (instance == null) {
            instance = new ValueUtil();
        }
        return instance;
    }

    public String getStringFromRes(Context context,int id){
        return context.getResources().getString(id);
    }

    public int getColorFromRes(Context context,int id){
        return context.getResources().getColor(id);
    }

    public Drawable getDrawableFromRes(Context context,int id){
        return context.getResources().getDrawable(id);
    }
}
