package com.chengbiao.ricky.projectframe.dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.chengbiao.ricky.projectframe.R;

public class CallPhoneDialog extends Dialog implements OnClickListener {

	private Context context;
	private Display display;
	private LinearLayout dialog_callphone;
	private TextView tv_name;
	private TextView btn_call;
	private TextView btn_dismiss;
	private String name, phone;

	public CallPhoneDialog(Context context, String name, String phone) {
		super(context, R.style.Dialog_Fullscreen);
		getWindow().setGravity(Gravity.BOTTOM);
		WindowManager windowManager = (WindowManager) context
				.getSystemService(Context.WINDOW_SERVICE);
		display = windowManager.getDefaultDisplay();
		this.context = context;
		this.name = name;
		this.phone = phone;
	}

	@SuppressWarnings("deprecation")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_callphone);
		intiview();
		dialog_callphone.setLayoutParams(new FrameLayout.LayoutParams((int) (display.getWidth() * 0.95), LayoutParams.WRAP_CONTENT));
	}

	private void intiview() {
		dialog_callphone = (LinearLayout) findViewById(R.id.dialog_callphone);
        btn_call = (TextView) findViewById(R.id.btn_call);
		btn_dismiss = (TextView) findViewById(R.id.btn_dismiss);
		tv_name = (TextView) findViewById(R.id.tv_name);

        tv_name.setText(name);
        btn_call.setText(phone);

        btn_call.setOnClickListener(this);
        btn_dismiss.setOnClickListener(this);
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.btn_call:
			Intent intent = new Intent(Intent.ACTION_DIAL);
			Uri data = Uri.parse("tel:" + phone);
			intent.setData(data);
			context.startActivity(intent);
			break;
		case R.id.btn_dismiss:
			this.dismiss();
			break;
		default:
			break;
		}
	}
}
