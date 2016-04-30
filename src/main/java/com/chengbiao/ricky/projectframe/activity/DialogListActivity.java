package com.chengbiao.ricky.projectframe.activity;

import android.app.DatePickerDialog;
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

public class DialogListActivity extends BaseActivity {
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
    }

    private void getElement(){
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

    @Override
    public void mOnClick(View v) {
        switch (v.getId()){
            case R.id.btn_confirmTips_dialog:
                ConfirmTipsDialog dialog = new ConfirmTipsDialog(this,null);
                dialog.show();
                break;
            case R.id.btn_datePicker_dialog:
                new MDatePickerDialog(this,"AA",null,0);
                break;
            case R.id.btn_timePicker_dialog:
                new MTimePickerDialog(this,"BB",null);
                break;
            case R.id.btn_loading_dialog:
                new MLoadingDialog(this,0,"CC");
                break;
            case R.id.btn_callPhone_dialog:
                new CallPhoneDialog(this,"xiao","13661196508");
                break;
            default:
                break;
        }
    }
}
