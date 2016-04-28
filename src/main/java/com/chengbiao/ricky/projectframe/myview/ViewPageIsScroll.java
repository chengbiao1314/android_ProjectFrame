package com.chengbiao.ricky.projectframe.myview;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Ricky on 16/4/29.
 */
public class ViewPageIsScroll extends ViewPager{
    private boolean scrollble = true;

    public ViewPageIsScroll(Context context) {
        super(context);
    }

    public ViewPageIsScroll(Context context, AttributeSet attrs) {
        super(context, attrs);
    }


    @Override
    public boolean onTouchEvent(MotionEvent ev) {
        if (!scrollble) {
            return true;
        }
        return super.onTouchEvent(ev);
    }


    public boolean isScrollble() {
        return scrollble;
    }

    public void setScrollble(boolean scrollble) {
        this.scrollble = scrollble;
    }
}
