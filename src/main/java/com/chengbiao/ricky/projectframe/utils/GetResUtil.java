package com.chengbiao.ricky.projectframe.utils;

import android.content.Context;
import android.graphics.drawable.Drawable;

/**
 * Created by ChengBiao on 2016/4/26.
 */
public class GetResUtil {
    private static GetResUtil instance;

    public static synchronized GetResUtil getInstance() {
        if (instance == null) {
            instance = new GetResUtil();
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
