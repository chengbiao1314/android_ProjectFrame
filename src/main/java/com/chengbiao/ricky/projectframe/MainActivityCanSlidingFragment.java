package com.chengbiao.ricky.projectframe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.chengbiao.ricky.projectframe.config.ContextSelectEnum;
import com.chengbiao.ricky.projectframe.config.StaticTag;
import com.chengbiao.ricky.projectframe.fragment.AboutFragment;
import com.chengbiao.ricky.projectframe.fragment.MainFragment;
import com.chengbiao.ricky.projectframe.fragment.SettingFragment;
import com.chengbiao.ricky.projectframe.interfaces.SetTitleInterface;
import com.chengbiao.ricky.projectframe.slidingmenu.SlidingFragmentActivity;
import com.chengbiao.ricky.projectframe.slidingmenu.SlidingMenu;
import com.chengbiao.ricky.projectframe.utils.StringUtil;


public class MainActivityCanSlidingFragment extends SlidingFragmentActivity {
    public static SlidingMenu sm;

    private TextView tv_title_inContext;
    private AboutFragment mAboutFragment;
    private MainFragment mMainFragment;
    private SettingFragment mSettingFragment;

    private SetTitleInterface mSetTitleInterface;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setBehindContentView(R.layout.slidingmenu_layout_left);
        setContentView(R.layout.slidingmenu_layout_home);

        sm = getSlidingMenu();
        sm.setMode(SlidingMenu.LEFT);
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        sm.setShadowDrawable(R.drawable.sliding_menu_shadow);
        sm.setShadowWidthRes(R.dimen.sliding_menu_shadow_width);
        sm.setBehindWidthRes(R.dimen.sliding_menu_width);

        init();
    }

    private void init(){
        tv_title_inContext = (TextView) findViewById(R.id.tv_title_inContext);

        mSetTitleInterface = new SetTitleInterface() {
            @Override
            public void setTitle(ContextSelectEnum titleEnum) {
                changeTitle(titleEnum);
            }
        };

        getFragmentInstances(StaticTag.defaultFragment);
    }

    private void getFragmentInstances(ContextSelectEnum contextSelectEnum){
        switch (contextSelectEnum){
            case HOME:
                mSetTitleInterface.setTitle(ContextSelectEnum.HOME);
                if (mMainFragment == null) {
                    mMainFragment = new MainFragment();
                }
                mMainFragment.setSetTitleInterface(mSetTitleInterface);
                switchFragment(mMainFragment);
                break;
            case SETTING:
                mSetTitleInterface.setTitle(ContextSelectEnum.SETTING);
                if (mSettingFragment == null)
                    mSettingFragment = new SettingFragment();
//                mSettingFragment.setSetTitleInterface(mSetTitleInterface);
                switchFragment(mSettingFragment);
                break;
            case ABOUT:
                mSetTitleInterface.setTitle(ContextSelectEnum.ABOUT);
                if (mAboutFragment == null)
                    mAboutFragment = new AboutFragment();
//                mAboutFragment.setSetTitleInterface(mSetTitleInterface);
                switchFragment(mAboutFragment);
                break;
            default:
                break;
        }
    }

    private void switchFragment(Fragment fragment) {
        sm.toggle();
        getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
    }

    public void sliding_menu_click(View view){
        switch(view.getId()){
            case R.id.iv_slidingmenu:
                sm.toggle();
                break;
            case R.id.ll_menu_home:
                StaticTag.defaultFragment = ContextSelectEnum.HOME;
                getFragmentInstances(StaticTag.defaultFragment);
                break;
            case R.id.ll_menu_setting:
                StaticTag.defaultFragment = ContextSelectEnum.SETTING;
                getFragmentInstances(StaticTag.defaultFragment);
                break;
            case R.id.ll_menu_about:
                StaticTag.defaultFragment = ContextSelectEnum.ABOUT;
                getFragmentInstances(StaticTag.defaultFragment);
                break;
            default:
                break;
        }
    }

    private void changeTitle(ContextSelectEnum titleEnum){
        switch(titleEnum){
            case HOME:
                setTitle(R.string.left_menu_home);
                break;
            case SETTING:
                setTitle(R.string.left_menu_setting);
                break;
            case ABOUT:
                setTitle(R.string.left_menu_about);
                break;
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
}
