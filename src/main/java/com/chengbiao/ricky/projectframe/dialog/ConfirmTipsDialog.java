package com.chengbiao.ricky.projectframe.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.chengbiao.ricky.projectframe.R;
import com.chengbiao.ricky.projectframe.utils.GetResUtil;


/**
 * 
 * @author Administrator
 * 
 */
public class ConfirmTipsDialog extends Dialog implements
		View.OnClickListener {

	private Context context;
	private Button btn_cancel;
	private Button btn_confirm;
	private TextView tv_title;
    private TextView tv_message;
    private Handler handler;

    private String title;
    private String message;
    private String confirm;
    private String cancel;
    private boolean isShowConfirm = true;
    private boolean isShowCancel = true;

	public ConfirmTipsDialog(Context context, Handler handler) {
		super(context, R.style.Dialog_Fullscreen);
		this.context = context;
		this.handler = handler;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.setContentView(R.layout.dialog_confirm_tips);
        this.setCancelable(false);//click back,dialog can dismiss

        tv_title = (TextView) findViewById(R.id.tv_title);
        tv_message = (TextView) findViewById(R.id.tv_message);
		btn_cancel = (Button) findViewById(R.id.btn_cancel);
		btn_confirm = (Button) findViewById(R.id.btn_confirm);

		btn_cancel.setOnClickListener(this);
		btn_confirm.setOnClickListener(this);

        initDialogStyle();
	}

    private void initDialogStyle(){
        if(title == null || title.isEmpty()){
            tv_title.setVisibility(View.GONE);
        }else{
            tv_title.setVisibility(View.VISIBLE);
            tv_title.setText(title);
        }
        if(message == null || message.isEmpty()){
            tv_message.setVisibility(View.GONE);
        }else{
            tv_message.setVisibility(View.VISIBLE);
            tv_message.setText(message);
        }
        if(message == null || message.isEmpty()){
            tv_message.setVisibility(View.GONE);
        }else{
            tv_message.setVisibility(View.VISIBLE);
            tv_message.setText(GetResUtil.getInstance().getStringFromRes(context,R.string.dialog_message));
        }
    }

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.btn_dismiss:
			this.dismiss();
			break;
		case R.id.btn_call:
			// 通知activity修改资料
			Message msg = new Message();
			msg.what = 2;
			handler.sendMessage(msg);
			this.dismiss();
			break;
		default:
			break;
		}
	}

    public void setTitle(String title) {
        this.title = title;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public void setCancel(String cancel) {
        this.cancel = cancel;
    }

    public void isShowConfirm(boolean isShowConfirm) {
        this.isShowConfirm = isShowConfirm;
    }

    public void isShowCancel(boolean isShowCancel) {
        this.isShowCancel = isShowCancel;
    }
}
