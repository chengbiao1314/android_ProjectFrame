package com.chengbiao.ricky.projectframe.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chengbiao.ricky.projectframe.MainActivityCanSlidingFragment;
import com.chengbiao.ricky.projectframe.MainActivityCanSlidingPage;
import com.chengbiao.ricky.projectframe.R;
import com.chengbiao.ricky.projectframe.adapter.MyPageOfTabAdapter;
import com.chengbiao.ricky.projectframe.base.BasePage;
import com.chengbiao.ricky.projectframe.page.OrderPageA;
import com.chengbiao.ricky.projectframe.page.OrderPageB;
import com.chengbiao.ricky.projectframe.page.OrderPageC;
import com.chengbiao.ricky.projectframe.page.OrderPageD;
import com.chengbiao.ricky.projectframe.utils.LogUtil;

import java.util.ArrayList;
import java.util.List;

public class MainOrderFragment extends Fragment {
    private View view;

    private PagerTabStrip pt_content1;
    private ViewPager vp_content1;
    private List<String> titleList;
    private List<BasePage> pageList;
    private OrderPageA mOrderPageA;
    private OrderPageB mOrderPageB;
    private OrderPageC mOrderPageC;
    private OrderPageD mOrderPageD;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_order, null);

        LogUtil.v("B:" + getActivity().toString());

        initData();

        return view;
    }

    public void initData() {
        vp_content1 = (ViewPager) view.findViewById(R.id.vp_content1_order_pager);
        pt_content1 = (PagerTabStrip) view.findViewById(R.id.pt_content1_order_pager);

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

        mOrderPageA = new OrderPageA(getActivity());
        mOrderPageB = new OrderPageB(getActivity());
        mOrderPageC = new OrderPageC(getActivity());
        mOrderPageD = new OrderPageD(getActivity());

        pageList.clear();
        pageList.add(mOrderPageA);
        pageList.add(mOrderPageB);
        pageList.add(mOrderPageC);
        pageList.add(mOrderPageD);

        pt_content1.setTabIndicatorColorResource(R.color.mainColor);
        pt_content1.setMinimumWidth(50);
        pt_content1.setTextSpacing(50);
        pt_content1.setFadingEdgeLength(50);
        vp_content1.setAdapter(new MyPageOfTabAdapter(pageList, titleList));
    }

}
