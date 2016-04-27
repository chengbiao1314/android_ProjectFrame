package com.chengbiao.ricky.projectframe.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chengbiao.ricky.projectframe.MainActivityCanSliding;
import com.chengbiao.ricky.projectframe.R;
import com.chengbiao.ricky.projectframe.adapter.MyPageAdapter;
import com.chengbiao.ricky.projectframe.base.BaseFragment;
import com.chengbiao.ricky.projectframe.base.BasePage;
import com.chengbiao.ricky.projectframe.config.ContextSelectEnum;
import com.chengbiao.ricky.projectframe.config.StaticTag;
import com.chengbiao.ricky.projectframe.interfaces.SetTitleInterface;
import com.chengbiao.ricky.projectframe.page.CenterPage;
import com.chengbiao.ricky.projectframe.page.HomePage;
import com.chengbiao.ricky.projectframe.page.MomentsPage;
import com.chengbiao.ricky.projectframe.page.OrderPage;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends BaseFragment {
    private Context context;
    private View view;
    private SetTitleInterface mSetTitleInterface;

    private ViewPager vp_content;
    private LinearLayout ll_home;
    private LinearLayout ll_moments;
    private LinearLayout ll_order;
    private LinearLayout ll_center;
    private ImageView iv_home;
    private ImageView iv_moments;
    private ImageView iv_order;
    private ImageView iv_center;
    private TextView tv_home;
    private TextView tv_moments;
    private TextView tv_order;
    private TextView tv_center;

    private List<BasePage> pageList;
    private HomePage homePage;
    private MomentsPage momentsPage;
    private OrderPage orderPage;
    private CenterPage centerPage;

    public void setSetTitleInterface(SetTitleInterface mSetTitleInterface){
        this.mSetTitleInterface = mSetTitleInterface;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, null);
        context = getActivity();

        getElement();
        initData();

        return view;
    }

    private void getElement(){
        vp_content = (ViewPager) view.findViewById(R.id.vp_content_fragment_home);
        iv_home = (ImageView) view.findViewById(R.id.iv_home_fragment_home);
        iv_moments = (ImageView) view.findViewById(R.id.iv_moments_fragment_home);
        iv_order = (ImageView) view.findViewById(R.id.iv_order_fragment_home);
        iv_center = (ImageView) view.findViewById(R.id.iv_center_fragment_home);
        tv_home = (TextView) view.findViewById(R.id.tv_home_fragment_home);
        tv_moments = (TextView) view.findViewById(R.id.tv_moments_fragment_home);
        tv_order = (TextView) view.findViewById(R.id.tv_order_fragment_home);
        tv_center = (TextView) view.findViewById(R.id.tv_center_fragment_home);
        ll_home = (LinearLayout) view.findViewById(R.id.ll_home_fragment_home);
        ll_moments = (LinearLayout) view.findViewById(R.id.ll_moments_fragment_home);
        ll_order = (LinearLayout) view.findViewById(R.id.ll_order_fragment_home);
        ll_center = (LinearLayout) view.findViewById(R.id.ll_center_fragment_home);

        ll_home.setOnClickListener(mOnClickListener);
        ll_moments.setOnClickListener(mOnClickListener);
        ll_order.setOnClickListener(mOnClickListener);
        ll_center.setOnClickListener(mOnClickListener);
    }

    private void initData(){
        if(pageList == null){
            pageList = new ArrayList<BasePage>();
        }
        homePage = new HomePage(context);
        momentsPage = new MomentsPage(context);
        orderPage = new OrderPage(context);
        centerPage = new CenterPage(context);

        pageList.clear();
        pageList.add(homePage);
        pageList.add(momentsPage);
        pageList.add(orderPage);
        pageList.add(centerPage);

        vp_content.setAdapter(new MyPageAdapter(pageList));
        selectIcon(StaticTag.defaultHomeSelect);

//        MainActivityCanSliding.sm.addIgnoredView(vp_content);
    }

    @Override
    public void mOnClick(View v) {
        mSetTitleInterface.setTitle(ContextSelectEnum.MYMOMENTS);
                MainActivityCanSliding.sm.clearIgnoredViews();
        switch(v.getId()){
            case R.id.ll_home_fragment_home:
                selectIcon(ContextSelectEnum.MYHOME);
                break;
            case R.id.ll_moments_fragment_home:
                selectIcon(ContextSelectEnum.MYMOMENTS);
                break;
            case R.id.ll_order_fragment_home:
                selectIcon(ContextSelectEnum.MYORDER);
                        MainActivityCanSliding.sm.addIgnoredView(vp_content);
                break;
            case R.id.ll_center_fragment_home:
                selectIcon(ContextSelectEnum.MYCENTER);
                break;
            default:
                break;
        }
    }

    private void selectIcon(ContextSelectEnum selectIcon){
        switch (selectIcon){
            case MYHOME:
                mSetTitleInterface.setTitle(ContextSelectEnum.MYHOME);
                vp_content.setCurrentItem(0);
                iv_home.setBackground(getResources().getDrawable(R.drawable.tab_main_home_on));
                iv_moments.setBackground(getResources().getDrawable(R.drawable.tab_main_moments_off));
                iv_order.setBackground(getResources().getDrawable(R.drawable.tab_main_order_off));
                iv_center.setBackground(getResources().getDrawable(R.drawable.tab_main_center_off));
                tv_home.setTextColor(getResources().getColor(R.color.mainColor));
                tv_moments.setTextColor(getResources().getColor(R.color.my_gray));
                tv_order.setTextColor(getResources().getColor(R.color.my_gray));
                tv_center.setTextColor(getResources().getColor(R.color.my_gray));
                break;
            case MYMOMENTS:
                mSetTitleInterface.setTitle(ContextSelectEnum.MYMOMENTS);
                vp_content.setCurrentItem(1);
                iv_home.setBackground(getResources().getDrawable(R.drawable.tab_main_home_off));
                iv_moments.setBackground(getResources().getDrawable(R.drawable.tab_main_moments_on));
                iv_order.setBackground(getResources().getDrawable(R.drawable.tab_main_order_off));
                iv_center.setBackground(getResources().getDrawable(R.drawable.tab_main_center_off));
                tv_home.setTextColor(getResources().getColor(R.color.my_gray));
                tv_moments.setTextColor(getResources().getColor(R.color.mainColor));
                tv_order.setTextColor(getResources().getColor(R.color.my_gray));
                tv_center.setTextColor(getResources().getColor(R.color.my_gray));
                break;
            case MYORDER:
                mSetTitleInterface.setTitle(ContextSelectEnum.MYORDER);
                vp_content.setCurrentItem(2);
                iv_home.setBackground(getResources().getDrawable(R.drawable.tab_main_home_off));
                iv_moments.setBackground(getResources().getDrawable(R.drawable.tab_main_moments_off));
                iv_order.setBackground(getResources().getDrawable(R.drawable.tab_main_order_on));
                iv_center.setBackground(getResources().getDrawable(R.drawable.tab_main_center_off));
                tv_home.setTextColor(getResources().getColor(R.color.my_gray));
                tv_moments.setTextColor(getResources().getColor(R.color.my_gray));
                tv_order.setTextColor(getResources().getColor(R.color.mainColor));
                tv_center.setTextColor(getResources().getColor(R.color.my_gray));
                break;
            case MYCENTER:
                mSetTitleInterface.setTitle(ContextSelectEnum.MYCENTER);
                vp_content.setCurrentItem(3);
                iv_home.setBackground(getResources().getDrawable(R.drawable.tab_main_home_off));
                iv_moments.setBackground(getResources().getDrawable(R.drawable.tab_main_moments_off));
                iv_order.setBackground(getResources().getDrawable(R.drawable.tab_main_order_off));
                iv_center.setBackground(getResources().getDrawable(R.drawable.tab_main_center_on));
                tv_home.setTextColor(getResources().getColor(R.color.my_gray));
                tv_moments.setTextColor(getResources().getColor(R.color.my_gray));
                tv_order.setTextColor(getResources().getColor(R.color.my_gray));
                tv_center.setTextColor(getResources().getColor(R.color.mainColor));
                break;
            default:
                break;
        }
    }
}
