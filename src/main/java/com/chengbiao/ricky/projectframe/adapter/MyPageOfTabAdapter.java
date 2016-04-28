package com.chengbiao.ricky.projectframe.adapter;

import android.support.v4.view.PagerAdapter;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.ViewGroup;

import com.chengbiao.ricky.projectframe.R;
import com.chengbiao.ricky.projectframe.base.BasePage;

import java.util.List;

/**
 * Created by admin on 2016/4/26.
 */
public class MyPageOfTabAdapter extends PagerAdapter {
    public List<BasePage> mPages;
    public List<String> mTitles;

    public MyPageOfTabAdapter(List<BasePage> mLists,List<String> mTitle) {
        this.mPages = mLists;
        this.mTitles = mTitle;
    }

    @Override
    public int getCount() {
        if(mPages != null){
            return mPages.size();
        }
        return 0;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        ((ViewPager) container).removeView(mPages.get(position).rootview);
        container.removeView(mPages.get(position).rootview);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
//        ((ViewPager) container).addView(mPages.get(position).rootview,0);
        container.addView(mPages.get(position).rootview);
        return mPages.get(position).rootview;
    }

    @Override
    public boolean isViewFromObject(View arg0, Object arg1) {
        return arg0 == arg1;
    }

    @Override
    public CharSequence getPageTitle(int position) {

        SpannableString str = new SpannableString(mTitles.get(position));
        str.setSpan(new ForegroundColorSpan(R.color.mainColor),0, str.length(),Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        return str;
    }
}
