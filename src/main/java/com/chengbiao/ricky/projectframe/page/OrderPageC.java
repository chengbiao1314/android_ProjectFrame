package com.chengbiao.ricky.projectframe.page;

import android.content.Context;
import android.view.View;

import com.chengbiao.ricky.projectframe.R;
import com.chengbiao.ricky.projectframe.base.BasePage;

public class OrderPageC extends BasePage {
    private MOnClickListener mOnClickListener;

	public OrderPageC(Context context) {
		super(context);
	}

    @Override
    public View initView() {
        return View.inflate(context,R.layout.page_order_c1, null);
    }

    @Override
    public void initData() {
        mOnClickListener = super.mOnClickListener;

//        Button btn = (Button) rootview.findViewById(R.id.btn_1);
//        btn.setOnClickListener(mOnClickListener);
    }

    @Override
    public void mOnClick(View v) {
        switch (v.getId()){
//            case R.id.btn_1:
//                ToastUtil.showToast(context, "running...");
//                break;
            default:
                break;
        }
    }

}