package com.chengbiao.ricky.projectframe.page;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.chengbiao.ricky.projectframe.R;
import com.chengbiao.ricky.projectframe.base.BasePage;

public class OrderPage extends BasePage {
    private MOnClickListener mOnClickListener;

	public OrderPage(Context context) {
		super(context);
	}

    @Override
    public View initView() {
        return View.inflate(context,R.layout.page_order, null);
    }

    @Override
    public void initData() {
        mOnClickListener = super.mOnClickListener;
    }

    @Override
    public void mOnClick(View v) {
        switch (v.getId()){
            case R.id.btn_1:
                Toast.makeText(context,"running...",Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }

}