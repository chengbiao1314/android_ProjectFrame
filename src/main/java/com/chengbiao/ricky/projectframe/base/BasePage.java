package com.chengbiao.ricky.projectframe.base;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;

/**
 * Created by admin on 2016/4/26.
 */
public abstract class BasePage{
    public Context context;
    public View rootview;
    public MOnClickListener mOnClickListener;
    public BasePage(Context context) {
        this.context = context;
        this.rootview = initView();
        this.mOnClickListener = new MOnClickListener();
        initData();
    }

    public abstract View initView();
    public abstract void initData();

    public abstract void mOnClick(View v);
    public class MOnClickListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            mOnClick(v);
        }
    }

}
