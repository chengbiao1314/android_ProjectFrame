package com.chengbiao.ricky.projectframe;

import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.chengbiao.ricky.projectframe.config.ContextSelectEnum;
import com.chengbiao.ricky.projectframe.config.StaticTag;
import com.chengbiao.ricky.projectframe.fragment.AboutFragment;
import com.chengbiao.ricky.projectframe.fragment.MainFragment;
import com.chengbiao.ricky.projectframe.fragment.SettingFragment;
import com.chengbiao.ricky.projectframe.slidingmenu.SlidingFragmentActivity;
import com.chengbiao.ricky.projectframe.slidingmenu.SlidingMenu;


public class MainActivityCanSliding extends SlidingFragmentActivity {
    public static SlidingMenu sm;

    private AboutFragment mAboutFragment;
    private MainFragment mMainFragment;
    private SettingFragment mSettingFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setBehindContentView(R.layout.slidingmenu_layout_left);
        setContentView(R.layout.slidingmenu_layout_home);


        //透明状态栏
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            Window window = getWindow();
            //透明状态栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //透明导航栏
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }

        sm = getSlidingMenu();
        sm.setMode(SlidingMenu.LEFT);
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
        sm.setShadowDrawable(R.drawable.sliding_menu_shadow);
        sm.setShadowWidthRes(R.dimen.sliding_menu_shadow_width);
        sm.setBehindWidthRes(R.dimen.sliding_menu_width);

        init();
    }

    private void init(){
        getFragmentInstances(StaticTag.defaultFragment);
    }

    private void getFragmentInstances(ContextSelectEnum contextSelectEnum){
        switch (contextSelectEnum){
            case HOME:
                if (mMainFragment == null) {
                    mMainFragment = new MainFragment();
                }
                switchFragment(mMainFragment);
                break;
            case SETTING:
                if (mSettingFragment == null)
                    mSettingFragment = new SettingFragment();
//                mSettingFragment.setSetTitleInterface(mSetTitleInterface);
                switchFragment(mSettingFragment);
                break;
            case ABOUT:
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
}
