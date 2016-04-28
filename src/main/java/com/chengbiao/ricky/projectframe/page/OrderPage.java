package com.chengbiao.ricky.projectframe.page;

import android.content.Context;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.chengbiao.ricky.projectframe.MainActivityCanSliding;
import com.chengbiao.ricky.projectframe.R;
import com.chengbiao.ricky.projectframe.adapter.MyPageOfTabAdapter;
import com.chengbiao.ricky.projectframe.base.BasePage;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends BasePage {
    private MOnClickListener mOnClickListener;
    private PagerTabStrip pt_content1;
    private ViewPager vp_content1;
    private List<String> titleList;
    private List<BasePage> pageList;
    private OrderPageA mOrderPageA;
    private OrderPageB mOrderPageB;
    private OrderPageC mOrderPageC;
    private OrderPageD mOrderPageD;

    private View view1, view2, view3;
    private List<View> viewList;//view数组

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

        vp_content1 = (ViewPager) rootview.findViewById(R.id.vp_content1_order_pager);
        pt_content1 = (PagerTabStrip) rootview.findViewById(R.id.pt_content1_order_pager);

        if(titleList == null){
            titleList = new ArrayList<String>();
        }
        if(pageList == null){
            pageList = new ArrayList<BasePage>();
        }

        titleList.add("order A");
        titleList.add("order B");
        titleList.add("order C");
        titleList.add("order D");

        mOrderPageA = new OrderPageA(context);
        mOrderPageB = new OrderPageB(context);
        mOrderPageC = new OrderPageC(context);
        mOrderPageD = new OrderPageD(context);

        pageList.clear();
        pageList.add(mOrderPageA);
        pageList.add(mOrderPageB);
        pageList.add(mOrderPageC);
        pageList.add(mOrderPageD);

        pt_content1.setTabIndicatorColorResource(R.color.mainColor);
        pt_content1.setMinimumWidth(100);
        vp_content1.setAdapter(new MyPageOfTabAdapter(pageList, titleList));

        MainActivityCanSliding.sm.addIgnoredView(vp_content1);
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