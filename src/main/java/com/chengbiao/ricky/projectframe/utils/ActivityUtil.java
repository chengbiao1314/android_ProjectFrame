package com.chengbiao.ricky.projectframe.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ricky on 16/5/1.
 */
public class ActivityUtil {
    private List<Activity> mActivityList = new LinkedList<Activity>();
    private static ActivityUtil instance;

    public static synchronized ActivityUtil getInstance() {
        if (instance == null) {
            instance = new ActivityUtil();
        }
        return instance;
    }

    //No Parameter and no Result
    public void startActivity(Context context,Class mActivity,boolean isFinished){
        Intent intent = new Intent(context,mActivity);
        context.startActivity(intent);
        if(isFinished){
            ((Activity)context).finish();
        }
    }

    //has Parameter and no Result
    public void startActivity(Context context,Class mActivity,Bundle mBundle,boolean isFinished){
        Intent intent = new Intent(context,mActivity);
        intent.putExtras(mBundle);
        context.startActivity(intent);
        if(isFinished){
            ((Activity)context).finish();
        }
    }

    //No Parameter and has Result
    public void startActivity(Context context,Class mActivity,int requestCode,boolean isFinished){
        Intent intent = new Intent(context,mActivity);
        ((Activity)context).startActivityForResult(intent, requestCode);
        if(isFinished){
            ((Activity)context).finish();
        }
    }

    //has Parameter and has Result
    public void startActivity(Context context,Class mActivity,Bundle mBundle,int requestCode,boolean isFinished){
        Intent intent = new Intent(context,mActivity);
        intent.putExtras(mBundle);
        ((Activity)context).startActivityForResult(intent,requestCode);
        if(isFinished){
            ((Activity)context).finish();
        }
    }

    /*protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (resultCode) { //resultCode为回传的标记，我在B中回传的是RESULT_OK
            case RESULT_OK:
                Bundle b=data.getExtras(); //data为B中回传的Intent
                String str=b.getString("str1");//str即为回传的值
                break;
            default:
                break;
        }
    }*/

    public void addActivity(Activity activity){
        mActivityList.add(activity);
    }

    public void finishActivity(Activity activity){
        if(activity!=null){
            mActivityList.remove(activity);
            activity.finish();
            activity=null;
        }
    }

    public void finishAllActivity(){
        while(mActivityList.size() > 0) {
            Activity activity = mActivityList.get(mActivityList.size() - 1);
            mActivityList.remove(mActivityList.size() - 1);
            activity.finish();
        }
    }

    public void AppExit() {
//        Countly.sharedInstance().onStop();
        try {
            finishAllActivity();
        } catch (Exception e) {
            LogUtil.v("exit application failed...");
        }
    }

}
