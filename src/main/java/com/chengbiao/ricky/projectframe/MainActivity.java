package com.chengbiao.ricky.projectframe;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

import com.chengbiao.ricky.projectframe.network.HttpRequest;
import com.chengbiao.ricky.projectframe.utils.ActivityUtil;
import com.chengbiao.ricky.projectframe.utils.LogUtil;

public class MainActivity extends Activity {

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            LogUtil.v("has run....");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogUtil.v("****************run...***************");
        HttpRequest http = new HttpRequest("http://www.hao123.com",null,handler);
        http.start();
    }

    public void ActionClick(View v){
        switch (v.getId()){
            case R.id.btn_slidingFrame_page:
                ActivityUtil.getInstance().startActivity(this,MainActivityCanSlidingPage.class,false);
                break;
            case R.id.btn_slidingFrame_frag:
                ActivityUtil.getInstance().startActivity(this,MainActivityCanSlidingFragment.class,false);
                break;
            case R.id.btn_noslidingFrame:
                ActivityUtil.getInstance().startActivity(this,MainActivityNoSliding.class,false);
                break;
            default:
                break;
        }
    }
}
