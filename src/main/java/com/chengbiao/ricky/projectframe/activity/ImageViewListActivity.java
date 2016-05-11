package com.chengbiao.ricky.projectframe.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.chengbiao.ricky.projectframe.R;
import com.chengbiao.ricky.projectframe.base.BaseActivity;
import com.chengbiao.ricky.projectframe.dialog.CallPhoneDialog;
import com.chengbiao.ricky.projectframe.dialog.ConfirmTipsDialog;
import com.chengbiao.ricky.projectframe.dialog.MDatePickerDialog;
import com.chengbiao.ricky.projectframe.dialog.MLoadingDialog;
import com.chengbiao.ricky.projectframe.dialog.MTimePickerDialog;
import com.chengbiao.ricky.projectframe.myview.MyCircleImageView;

public class ImageViewListActivity extends BaseActivity {
    private MyCircleImageView mcv_person_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageviewlist);

        getElement();
    }

    private void getElement(){
        mcv_person_icon = (MyCircleImageView) findViewById(R.id.mcv_person_icon);

        mcv_person_icon.setOnClickListener(this);
    }

    @Override
    public void mOnClick(View v) {
        switch (v.getId()){
            case R.id.mcv_person_icon:
                break;
            default:
                break;
        }
    }
}
