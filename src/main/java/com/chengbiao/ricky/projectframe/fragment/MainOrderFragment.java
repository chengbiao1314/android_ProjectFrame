package com.chengbiao.ricky.projectframe.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chengbiao.ricky.projectframe.R;
import com.chengbiao.ricky.projectframe.adapter.MyPageOfTabAdapter;
import com.chengbiao.ricky.projectframe.base.BaseFragment;
import com.chengbiao.ricky.projectframe.base.BasePage;
import com.chengbiao.ricky.projectframe.page.OrderPageA;
import com.chengbiao.ricky.projectframe.page.OrderPageB;
import com.chengbiao.ricky.projectframe.page.OrderPageC;
import com.chengbiao.ricky.projectframe.page.OrderPageD;
import com.chengbiao.ricky.projectframe.page.OrderPage_a;
import com.chengbiao.ricky.projectframe.page.OrderPage_b;
import com.chengbiao.ricky.projectframe.page.OrderPage_c;
import com.chengbiao.ricky.projectframe.page.OrderPage_d;
import com.chengbiao.ricky.projectframe.utils.LogUtil;
import com.chengbiao.ricky.projectframe.utils.ValueUtil;

import java.util.ArrayList;
import java.util.List;

public class MainOrderFragment extends BaseFragment {
    private View view;
    private Context context;
    private LinearLayout ll_ordertype_1;
    private LinearLayout ll_ordertype_2;
    private TextView tv_type1;
    private TextView tv_type2;
    private TextView tv_ordertype_1_1;
    private TextView tv_ordertype_1_2;
    private TextView tv_ordertype_1_3;
    private TextView tv_ordertype_1_4;
    private TextView tv_ordertype_2_1;
    private TextView tv_ordertype_2_2;
    private TextView tv_ordertype_2_3;
    private TextView tv_ordertype_2_4;

    private ViewPager vp_content1;
    private ViewPager vp_content2;
    private List<String> titleList1;
    private List<String> titleList2;
    private List<BasePage> pageList1;
    private List<BasePage> pageList2;
    private OrderPageA mOrderPageA;
    private OrderPageB mOrderPageB;
    private OrderPageC mOrderPageC;
    private OrderPageD mOrderPageD;
    private OrderPage_a mOrderPagea;
    private OrderPage_b mOrderPageb;
    private OrderPage_c mOrderPagec;
    private OrderPage_d mOrderPaged;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main_order, null);
        context = getActivity();

        LogUtil.v("B:" + getActivity().toString());

        getElement();
        initData();

        return view;
    }

    private void getElement(){
        ll_ordertype_1 = (LinearLayout) view.findViewById(R.id.ll_ordertype_1);
        ll_ordertype_2 = (LinearLayout) view.findViewById(R.id.ll_ordertype_2);
        tv_type1 = (TextView) view.findViewById(R.id.tv_type1);
        tv_type2 = (TextView) view.findViewById(R.id.tv_type2);
        tv_ordertype_1_1 = (TextView) view.findViewById(R.id.tv_ordertype_1_1);
        tv_ordertype_1_2 = (TextView) view.findViewById(R.id.tv_ordertype_1_2);
        tv_ordertype_1_3 = (TextView) view.findViewById(R.id.tv_ordertype_1_3);
        tv_ordertype_1_4 = (TextView) view.findViewById(R.id.tv_ordertype_1_4);
        tv_ordertype_2_1 = (TextView) view.findViewById(R.id.tv_ordertype_2_1);
        tv_ordertype_2_2 = (TextView) view.findViewById(R.id.tv_ordertype_2_2);
        tv_ordertype_2_3 = (TextView) view.findViewById(R.id.tv_ordertype_2_3);
        tv_ordertype_2_4 = (TextView) view.findViewById(R.id.tv_ordertype_2_4);
        vp_content1 = (ViewPager) view.findViewById(R.id.vp_content1_order_pager);
        vp_content2 = (ViewPager) view.findViewById(R.id.vp_content2_order_pager);

        tv_type1.setOnClickListener(mOnClickListener);
        tv_type2.setOnClickListener(mOnClickListener);
        tv_ordertype_1_1.setOnClickListener(mOnClickListener);
        tv_ordertype_1_2.setOnClickListener(mOnClickListener);
        tv_ordertype_1_3.setOnClickListener(mOnClickListener);
        tv_ordertype_1_4.setOnClickListener(mOnClickListener);
        tv_ordertype_2_1.setOnClickListener(mOnClickListener);
        tv_ordertype_2_1.setOnClickListener(mOnClickListener);
        tv_ordertype_2_1.setOnClickListener(mOnClickListener);
        tv_ordertype_2_1.setOnClickListener(mOnClickListener);
    }

    public void initData() {

        if(titleList1 == null){
            titleList1 = new ArrayList<String>();
        }
        if(titleList2 == null){
            titleList2 = new ArrayList<String>();
        }
        if(pageList1 == null){
            pageList1 = new ArrayList<BasePage>();
        }
        if(pageList2 == null){
            pageList2 = new ArrayList<BasePage>();
        }

        titleList1.add("order A");
        titleList1.add("order B");
        titleList1.add("order C");
        titleList1.add("order D");
        titleList2.add("order a");
        titleList2.add("order b");
        titleList2.add("order c");
        titleList2.add("order d");
        tv_ordertype_1_1.setText(titleList1.get(0));
        tv_ordertype_1_2.setText(titleList1.get(1));
        tv_ordertype_1_3.setText(titleList1.get(2));
        tv_ordertype_1_4.setText(titleList1.get(3));
        tv_ordertype_2_1.setText(titleList2.get(0));
        tv_ordertype_2_2.setText(titleList2.get(1));
        tv_ordertype_2_3.setText(titleList2.get(2));
        tv_ordertype_2_4.setText(titleList2.get(3));

        mOrderPageA = new OrderPageA(getActivity());
        mOrderPageB = new OrderPageB(getActivity());
        mOrderPageC = new OrderPageC(getActivity());
        mOrderPageD = new OrderPageD(getActivity());
        mOrderPagea = new OrderPage_a(getActivity());
        mOrderPageb = new OrderPage_b(getActivity());
        mOrderPagec = new OrderPage_c(getActivity());
        mOrderPaged = new OrderPage_d(getActivity());

        pageList1.clear();
        pageList1.add(mOrderPageA);
        pageList1.add(mOrderPageB);
        pageList1.add(mOrderPageC);
        pageList1.add(mOrderPageD);
        pageList2.clear();
        pageList2.add(mOrderPagea);
        pageList2.add(mOrderPageb);
        pageList2.add(mOrderPagec);
        pageList2.add(mOrderPaged);

        vp_content1.setAdapter(new MyPageOfTabAdapter(pageList1));
        vp_content2.setAdapter(new MyPageOfTabAdapter(pageList2));

        vp_content1.setOnPageChangeListener(new MyPageChangeListener(0));
        vp_content2.setOnPageChangeListener(new MyPageChangeListener(1));

        vp_content1.setCurrentItem(0);
        vp_content2.setCurrentItem(0);
        changeIndex(0, vp_content1.getCurrentItem());
        changeIndex(1,vp_content1.getCurrentItem());
    }

    @Override
    public void mOnClick(View v) {
        switch (v.getId()){
            case R.id.tv_type1:
                ll_ordertype_1.setVisibility(View.VISIBLE);
                vp_content1.setVisibility(View.VISIBLE);
                ll_ordertype_2.setVisibility(View.GONE);
                vp_content2.setVisibility(View.GONE);
                break;
            case R.id.tv_type2:
                ll_ordertype_1.setVisibility(View.GONE);
                vp_content1.setVisibility(View.GONE);
                ll_ordertype_2.setVisibility(View.VISIBLE);
                vp_content2.setVisibility(View.VISIBLE);
                break;
            case R.id.tv_ordertype_1_1:
                vp_content1.setCurrentItem(0);
                break;
            case R.id.tv_ordertype_1_2:
                vp_content1.setCurrentItem(1);
                break;
            case R.id.tv_ordertype_1_3:
                vp_content1.setCurrentItem(2);
                break;
            case R.id.tv_ordertype_1_4:
                vp_content1.setCurrentItem(3);
                break;
            case R.id.tv_ordertype_2_1:
                vp_content2.setCurrentItem(0);
                break;
            case R.id.tv_ordertype_2_2:
                vp_content2.setCurrentItem(1);
                break;
            case R.id.tv_ordertype_2_3:
                vp_content2.setCurrentItem(2);
                break;
            case R.id.tv_ordertype_2_4:
                vp_content2.setCurrentItem(3);
                break;
            default:
                break;
        }
    }

    private void changeIndex(int type,int index){
        if (type == 0){
            switch (index) {
                case 0:
                    tv_ordertype_1_1.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.mainColor));
                    tv_ordertype_1_2.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.my_gray));
                    tv_ordertype_1_3.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.my_gray));
                    tv_ordertype_1_4.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.my_gray));
                    tv_ordertype_1_1.setBackground(ValueUtil.getInstance().getDrawableFromRes(context, R.drawable.line_bottom_red));
                    tv_ordertype_1_2.setBackground(null);
                    tv_ordertype_1_3.setBackground(null);
                    tv_ordertype_1_4.setBackground(null);
                    break;
                case 1:
                    tv_ordertype_1_1.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.my_gray));
                    tv_ordertype_1_2.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.mainColor));
                    tv_ordertype_1_3.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.my_gray));
                    tv_ordertype_1_4.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.my_gray));
                    tv_ordertype_1_2.setBackground(ValueUtil.getInstance().getDrawableFromRes(context, R.drawable.line_bottom_red));
                    tv_ordertype_1_1.setBackground(null);
                    tv_ordertype_1_3.setBackground(null);
                    tv_ordertype_1_4.setBackground(null);
                    break;
                case 2:
                    tv_ordertype_1_1.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.my_gray));
                    tv_ordertype_1_2.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.my_gray));
                    tv_ordertype_1_3.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.mainColor));
                    tv_ordertype_1_4.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.my_gray));
                    tv_ordertype_1_3.setBackground(ValueUtil.getInstance().getDrawableFromRes(context, R.drawable.line_bottom_red));
                    tv_ordertype_1_2.setBackground(null);
                    tv_ordertype_1_1.setBackground(null);
                    tv_ordertype_1_4.setBackground(null);
                    break;
                case 3:
                    tv_ordertype_1_1.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.my_gray));
                    tv_ordertype_1_2.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.my_gray));
                    tv_ordertype_1_3.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.my_gray));
                    tv_ordertype_1_4.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.mainColor));
                    tv_ordertype_1_4.setBackground(ValueUtil.getInstance().getDrawableFromRes(context, R.drawable.line_bottom_red));
                    tv_ordertype_1_2.setBackground(null);
                    tv_ordertype_1_3.setBackground(null);
                    tv_ordertype_1_1.setBackground(null);
                    break;
            }
        }else if (type == 1){
            switch (index) {
                case 0:
                    tv_ordertype_2_1.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.mainColor));
                    tv_ordertype_2_2.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.my_gray));
                    tv_ordertype_2_3.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.my_gray));
                    tv_ordertype_2_4.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.my_gray));
                    tv_ordertype_2_1.setBackground(ValueUtil.getInstance().getDrawableFromRes(context, R.drawable.line_bottom_red));
                    tv_ordertype_2_2.setBackground(null);
                    tv_ordertype_2_3.setBackground(null);
                    tv_ordertype_2_4.setBackground(null);
                    break;
                case 1:
                    tv_ordertype_2_1.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.my_gray));
                    tv_ordertype_2_2.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.mainColor));
                    tv_ordertype_2_3.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.my_gray));
                    tv_ordertype_2_4.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.my_gray));
                    tv_ordertype_2_2.setBackground(ValueUtil.getInstance().getDrawableFromRes(context, R.drawable.line_bottom_red));
                    tv_ordertype_2_1.setBackground(null);
                    tv_ordertype_2_3.setBackground(null);
                    tv_ordertype_2_4.setBackground(null);
                    break;
                case 2:
                    tv_ordertype_2_1.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.my_gray));
                    tv_ordertype_2_2.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.my_gray));
                    tv_ordertype_2_3.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.mainColor));
                    tv_ordertype_2_4.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.my_gray));
                    tv_ordertype_2_3.setBackground(ValueUtil.getInstance().getDrawableFromRes(context, R.drawable.line_bottom_red));
                    tv_ordertype_2_2.setBackground(null);
                    tv_ordertype_2_1.setBackground(null);
                    tv_ordertype_2_4.setBackground(null);
                    break;
                case 3:
                    tv_ordertype_2_1.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.my_gray));
                    tv_ordertype_2_2.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.my_gray));
                    tv_ordertype_2_3.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.my_gray));
                    tv_ordertype_2_4.setTextColor(ValueUtil.getInstance().getColorFromRes(context, R.color.mainColor));
                    tv_ordertype_2_4.setBackground(ValueUtil.getInstance().getDrawableFromRes(context, R.drawable.line_bottom_red));
                    tv_ordertype_2_2.setBackground(null);
                    tv_ordertype_2_3.setBackground(null);
                    tv_ordertype_2_1.setBackground(null);
                    break;
            }
        }
    }

    public class MyPageChangeListener implements ViewPager.OnPageChangeListener {
        private int type;
        MyPageChangeListener(int type){
            this.type = type;
        }
        @Override
        public void onPageSelected(int currIndex) {
            changeIndex(type,currIndex);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {
        }

        @Override
        public void onPageScrollStateChanged(int arg0) {
        }
    }
}
