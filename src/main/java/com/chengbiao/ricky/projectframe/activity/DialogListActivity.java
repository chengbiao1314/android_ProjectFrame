package com.chengbiao.ricky.projectframe.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chengbiao.ricky.projectframe.R;
import com.chengbiao.ricky.projectframe.base.BaseActivity;
import com.chengbiao.ricky.projectframe.dialog.CallPhoneDialog;
import com.chengbiao.ricky.projectframe.dialog.ConfirmTipsDialog;
import com.chengbiao.ricky.projectframe.dialog.MDatePickerDialog;
import com.chengbiao.ricky.projectframe.dialog.MLoadingDialog;
import com.chengbiao.ricky.projectframe.dialog.MTimePickerDialog;
import com.chengbiao.ricky.projectframe.myview.MyToast;
import com.chengbiao.ricky.projectframe.utils.GetResUtil;

import static com.chengbiao.ricky.projectframe.config.StaticTag.*;

public class DialogListActivity extends BaseActivity {
    private TextView tv_title;
    private Button btn_confirmTips_dialog;
    private Button btn_datePicker_dialog;
    private Button btn_timePicker_dialog;
    private Button btn_loading_dialog;
    private Button btn_callPhone_dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialoglist);

        getElement();
        initData();
    }

    private void getElement(){
        tv_title = (TextView) findViewById(R.id.tv_title);
        btn_confirmTips_dialog = (Button) findViewById(R.id.btn_confirmTips_dialog);
        btn_datePicker_dialog = (Button) findViewById(R.id.btn_datePicker_dialog);
        btn_timePicker_dialog = (Button) findViewById(R.id.btn_timePicker_dialog);
        btn_loading_dialog = (Button) findViewById(R.id.btn_loading_dialog);
        btn_callPhone_dialog = (Button) findViewById(R.id.btn_callPhone_dialog);

        btn_confirmTips_dialog.setOnClickListener(this);
        btn_datePicker_dialog.setOnClickListener(this);
        btn_timePicker_dialog.setOnClickListener(this);
        btn_loading_dialog.setOnClickListener(this);
        btn_callPhone_dialog.setOnClickListener(this);
    }

    private void initData(){
        tv_title.setText(GetResUtil.getInstance().getStringFromRes(this,R.string.title_mydialog));
    }

    @Override
    public void mOnClick(View v) {
        switch (v.getId()){
            case R.id.btn_confirmTips_dialog:
                ConfirmTipsDialog dialog = new ConfirmTipsDialog(this,handler);
                dialog.setTitle(GetResUtil.getInstance().getStringFromRes(this, R.string.dialog_title));
                dialog.setMessage(GetResUtil.getInstance().getStringFromRes(this, R.string.dialog_message));
                dialog.show();
                break;
            case R.id.btn_datePicker_dialog:
                new MDatePickerDialog(this,"AA",null,0).show();
                break;
            case R.id.btn_timePicker_dialog:
                new MTimePickerDialog(this,"BB",null).show();
                break;
            case R.id.btn_loading_dialog:
                new MLoadingDialog(this,0,"CC").show();
                break;
            case R.id.btn_callPhone_dialog:
                new CallPhoneDialog(this,"xiao","13661196508").show();
                break;
            default:
                break;
        }
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what){
                case Dialog_Handler_Code:
                    MyToast.showToast(DialogListActivity.this,"running tips dialog...");
                    break;
            }
        }
    };
}
