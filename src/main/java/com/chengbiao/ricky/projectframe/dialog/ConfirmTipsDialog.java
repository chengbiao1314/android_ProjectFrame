package com.chengbiao.ricky.projectframe.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

import com.chengbiao.ricky.projectframe.R;


/**
 * 
 * @author Administrator
 * 
 */
public class ConfirmTipsDialog extends Dialog implements
		View.OnClickListener {

	private Context context;
	private Button dismiss_btn;
	private Button hint_btn;
	private Handler handler;

	public ConfirmTipsDialog(Context context, Handler handler) {
		super(context, R.style.Dialog_Fullscreen);
		this.context = context;
		this.handler = handler;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		this.setContentView(R.layout.dialog_confirm_tips);
		dismiss_btn = (Button) findViewById(R.id.dismisssave_btn);
		hint_btn = (Button) findViewById(R.id.hintsave_btn);
		dismiss_btn.setOnClickListener(this);
		hint_btn.setOnClickListener(this);

	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.dismisssave_btn:
			this.dismiss();
			break;
		case R.id.hintsave_btn:
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

}
