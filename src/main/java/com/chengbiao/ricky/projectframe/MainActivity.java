package com.chengbiao.ricky.projectframe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.chengbiao.ricky.projectframe.network.HttpRequest;
import com.chengbiao.ricky.projectframe.utils.ActivityUtil;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HttpRequest http = new HttpRequest("stringResponse",null,null);
        http.run();
    }

    public void ActionClick(View v){
        switch (v.getId()){
            case R.id.btn_slidingFrame:
                ActivityUtil.getInstance().startActivity(this,MainActivityCanSliding.class,false);
                break;
            case R.id.btn_noslidingFrame:
                ActivityUtil.getInstance().startActivity(this,MainActivityNoSliding.class,false);
                break;
            default:
                break;
        }
    }
}
