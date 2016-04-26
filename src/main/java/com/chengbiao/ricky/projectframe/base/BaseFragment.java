package com.chengbiao.ricky.projectframe.base;

import android.support.v4.app.Fragment;
import android.view.View;

public abstract class BaseFragment extends Fragment {
    public MOnClickListener mOnClickListener;

    public BaseFragment() {
        this.mOnClickListener = new MOnClickListener();
    }

    public abstract void mOnClick(View v);
    public class MOnClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            mOnClick(v);
        }
    }
}
