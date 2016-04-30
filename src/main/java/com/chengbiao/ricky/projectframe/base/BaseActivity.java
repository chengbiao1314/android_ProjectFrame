package com.chengbiao.ricky.projectframe.base;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.chengbiao.ricky.projectframe.R;

public abstract class BaseActivity extends Activity implements View.OnClickListener {

    public abstract void mOnClick(View v);

    @Override
    public void onClick(View v) {
        mOnClick(v);
    }
}
