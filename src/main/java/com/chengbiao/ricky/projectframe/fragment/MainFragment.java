package com.chengbiao.ricky.projectframe.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chengbiao.ricky.projectframe.MainActivityCanSliding;
import com.chengbiao.ricky.projectframe.R;
import com.chengbiao.ricky.projectframe.base.BaseFragment;
import com.chengbiao.ricky.projectframe.config.ContextSelectEnum;
import com.chengbiao.ricky.projectframe.config.StaticTag;
import com.chengbiao.ricky.projectframe.interfaces.SetTitleInterface;
import com.chengbiao.ricky.projectframe.utils.LogUtil;
import com.chengbiao.ricky.projectframe.utils.StringUtil;

public class MainFragment extends BaseFragment {
    private Context context;
    private View view;

    private FrameLayout fl_context;
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

    private MainHomeFragment mMHomeFragment;
    private MainMomentsFragment mMMomentsFragment;
    private MainOrderFragment mMOrderFragment;
    private MainCenterFragment mMCenterFragment;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_main, null);
        context = getActivity();

        LogUtil.v("A:"+getActivity().toString());

        getElement();
        initData();

        return view;
    }

    private void getElement(){
        fl_context = (FrameLayout) view.findViewById(R.id.content_main);
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
        selectFragment(StaticTag.defaultHomeSelect);
    }

    private void selectFragment(ContextSelectEnum contextSelectEnum){
        selectIcon(contextSelectEnum);
        switch (contextSelectEnum){
            case MYHOME:
                if (mMHomeFragment == null) {
                    mMHomeFragment = new MainHomeFragment();
                }
                switchFragment(mMHomeFragment);
                break;
            case MYMOMENTS:
                if (mMMomentsFragment == null) {
                    mMMomentsFragment = new MainMomentsFragment();
                }
                switchFragment(mMMomentsFragment);
                break;
            case MYORDER:
                if (mMOrderFragment == null) {
                    mMOrderFragment = new MainOrderFragment();
                }
                switchFragment(mMOrderFragment);
                break;
            case MYCENTER:
                if (mMCenterFragment == null) {
                    mMCenterFragment = new MainCenterFragment();
                }
                switchFragment(mMCenterFragment);
                break;
            default:
                break;
        }
    }

    private void switchFragment(Fragment fragment) {
        getChildFragmentManager().beginTransaction().replace(R.id.content_main, fragment).commit();
    }

    @Override
    public void mOnClick(View v) {
        switch(v.getId()){
            case R.id.ll_home_fragment_home:
                selectFragment(ContextSelectEnum.MYHOME);
                break;
            case R.id.ll_moments_fragment_home:
                selectFragment(ContextSelectEnum.MYMOMENTS);
                break;
            case R.id.ll_order_fragment_home:
                selectFragment(ContextSelectEnum.MYORDER);
                break;
            case R.id.ll_center_fragment_home:
                selectFragment(ContextSelectEnum.MYCENTER);
                break;
            default:
                break;
        }
    }

    private void selectIcon(ContextSelectEnum selectIcon){
        MainActivityCanSliding.sm.clearIgnoredViews();
        switch (selectIcon){
            case MYHOME:
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
                MainActivityCanSliding.sm.addIgnoredView(fl_context);
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
