package com.chengbiao.ricky.projectframe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import com.chengbiao.ricky.projectframe.fragment.AboutFragment;
import com.chengbiao.ricky.projectframe.fragment.HomeFragment;
import com.chengbiao.ricky.projectframe.fragment.SettingFragment;
import com.chengbiao.ricky.projectframe.slidingmenu.SlidingFragmentActivity;
import com.chengbiao.ricky.projectframe.slidingmenu.SlidingMenu;


public class MainActivityCanSliding extends SlidingFragmentActivity {

    public static SlidingMenu sm;

    private AboutFragment mAboutFragment;
    private HomeFragment mHomeFragment;
    private SettingFragment mSettingFragment;

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

        if (mAboutFragment == null)
            mAboutFragment = new AboutFragment();
        switchFragment(mAboutFragment);
    }

    public static void mytoggle(){
        sm.toggle();
    }

    public void switchFragment(Fragment fragment) {
        mytoggle();
        getSupportFragmentManager().beginTransaction().replace(R.id.content, fragment).commit();
    }

    public void sliding_menu_click(View view){
        switch(view.getId()){
            case R.id.sliding_menu_one:
                if(mAboutFragment == null)
                    mAboutFragment = new AboutFragment();
                switchFragment(mAboutFragment);
                Toast.makeText(this, "have running...", 0).show();
                break;
            case R.id.sliding_menu_two:
                if(mHomeFragment == null)
                    mHomeFragment = new HomeFragment();
                switchFragment(mHomeFragment);
                Toast.makeText(this, "have running...", 0).show();
                break;
            case R.id.sliding_menu_three:
                if(mSettingFragment == null)
                    mSettingFragment = new SettingFragment();
                switchFragment(mSettingFragment);
                Toast.makeText(this, "have running...", 0).show();
                break;
        }
    }


}
