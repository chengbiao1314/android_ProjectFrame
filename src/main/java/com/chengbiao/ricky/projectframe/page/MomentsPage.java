package com.chengbiao.ricky.projectframe.page;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import com.chengbiao.ricky.projectframe.R;
import com.chengbiao.ricky.projectframe.base.BasePage;
import com.chengbiao.ricky.projectframe.myview.MyToast;

public class MomentsPage extends BasePage {
    private MOnClickListener mOnClickListener;

	public MomentsPage(Context context) {
		super(context);
	}

    @Override
    public View initView() {
        return View.inflate(context,R.layout.page_moments, null);
    }

    @Override
    public void initData() {
        mOnClickListener = super.mOnClickListener;

        Button btn = (Button) rootview.findViewById(R.id.btn_1);
        btn.setOnClickListener(mOnClickListener);
    }

    @Override
    public void mOnClick(View v) {
        switch (v.getId()){
            case R.id.btn_1:
                MyToast.showToast(context, "running...");
                break;
            default:
                break;
        }
    }

}