package com.chengbiao.ricky.projectframe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chengbiao.ricky.projectframe.config.ContextSelectEnum;
import com.chengbiao.ricky.projectframe.config.StaticTag;
import com.chengbiao.ricky.projectframe.fragment.MCenterFragment;
import com.chengbiao.ricky.projectframe.fragment.MHomeFragment;
import com.chengbiao.ricky.projectframe.fragment.MMomentsFragment;
import com.chengbiao.ricky.projectframe.fragment.MOrderFragment;
import com.chengbiao.ricky.projectframe.utils.StringUtil;


public class MainActivityNoSliding extends FragmentActivity implements View.OnClickListener {
    private TextView tv_title_inContext;
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

    private MHomeFragment mMHomeFragment;
    private MMomentsFragment mMMomentsFragment;
    private MOrderFragment mMOrderFragment;
    private MCenterFragment mMCenterFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_nosliding);

        getElement();
        init();
    }

    private void getElement(){
        tv_title_inContext = (TextView) findViewById(R.id.tv_title_main);
        iv_home = (ImageView) findViewById(R.id.iv_home_main);
        iv_moments = (ImageView) findViewById(R.id.iv_moments_main);
        iv_order = (ImageView) findViewById(R.id.iv_order_main);
        iv_center = (ImageView)findViewById(R.id.iv_center_main);
        tv_home = (TextView)findViewById(R.id.tv_home_main);
        tv_moments = (TextView)findViewById(R.id.tv_moments_main);
        tv_order = (TextView)findViewById(R.id.tv_order_main);
        tv_center = (TextView)findViewById(R.id.tv_center_main);
        ll_home = (LinearLayout)findViewById(R.id.ll_home_main);
        ll_moments = (LinearLayout)findViewById(R.id.ll_moments_main);
        ll_order = (LinearLayout)findViewById(R.id.ll_order_main);
        ll_center = (LinearLayout)findViewById(R.id.ll_center_main);

        ll_home.setOnClickListener(this);
        ll_moments.setOnClickListener(this);
        ll_order.setOnClickListener(this);
        ll_center.setOnClickListener(this);
    }

    private void init(){
        selectFragment(StaticTag.defaultHomeSelect);
    }

    private void selectFragment(ContextSelectEnum contextSelectEnum){
        selectIcon(contextSelectEnum);
        changeTitle(contextSelectEnum);
        switch (contextSelectEnum){
            case MYHOME:
                if (mMHomeFragment == null) {
                    mMHomeFragment = new MHomeFragment();
                }
                switchFragment(mMHomeFragment);
                break;
            case MYMOMENTS:
                if (mMMomentsFragment == null) {
                    mMMomentsFragment = new MMomentsFragment();
                }
                switchFragment(mMMomentsFragment);
                break;
            case MYORDER:
                if (mMOrderFragment == null) {
                    mMOrderFragment = new MOrderFragment();
                }
                switchFragment(mMOrderFragment);
                break;
            case MYCENTER:
                if (mMCenterFragment == null) {
                    mMCenterFragment = new MCenterFragment();
                }
                switchFragment(mMCenterFragment);
                break;
            default:
                break;
        }
    }

    private void switchFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
    }

    private void selectIcon(ContextSelectEnum selectIcon){
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

    private void changeTitle(ContextSelectEnum titleEnum){
        switch(titleEnum){
            case MYHOME:
                setTitle(R.string.main_index_home);
                break;
            case MYMOMENTS:
                setTitle(R.string.main_index_moments);
                break;
            case MYORDER:
                setTitle(R.string.main_index_order);
                break;
            case MYCENTER:
                setTitle(R.string.main_index_center);
                break;
            default:
                break;
        }
    }

    public void setTitle(int stringId){
        tv_title_inContext.setText(StringUtil.getInstance().getStringFromRes(this, stringId));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.ll_home_main:
                selectFragment(ContextSelectEnum.MYHOME);
                break;
            case R.id.ll_moments_main:
                selectFragment(ContextSelectEnum.MYMOMENTS);
                break;
            case R.id.ll_order_main:
                selectFragment(ContextSelectEnum.MYORDER);
                break;
            case R.id.ll_center_main:
                selectFragment(ContextSelectEnum.MYCENTER);
                break;
            default:
                break;
        }
    }
}
