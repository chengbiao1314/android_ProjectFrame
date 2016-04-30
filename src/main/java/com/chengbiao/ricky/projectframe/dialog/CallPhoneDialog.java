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
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

import com.chengbiao.ricky.projectframe.R;

public class CallPhoneDialog extends Dialog implements OnClickListener {

	private Context context;
	private Display display;
	private LinearLayout dialog_callphone;
	private TextView call_btn, call_name;
	private Button call_diamiss;
	private String name, phone;

	public CallPhoneDialog(Context context, String name, String phone) {
		super(context, R.style.Dialog_Fullscreen);
		// TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_callphone);
		intiview();
		dialog_callphone.setLayoutParams(new FrameLayout.LayoutParams(
				(int) (display.getWidth() * 0.95), LayoutParams.WRAP_CONTENT));
	}

	private void intiview() {
		// TODO Auto-generated method stub
		dialog_callphone = (LinearLayout) findViewById(R.id.dialog_callphone);
		call_btn = (TextView) findViewById(R.id.call_btn);
		call_diamiss = (Button) findViewById(R.id.call_dismiss);
		call_name = (TextView) findViewById(R.id.call_name);
		call_btn.setOnClickListener(this);
		call_diamiss.setOnClickListener(this);
		call_btn.setText(phone);
		call_name.setText(name);
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.call_btn:
			Intent intent = new Intent(Intent.ACTION_DIAL);
			Uri data = Uri.parse("tel:" + phone);
			intent.setData(data);
			context.startActivity(intent);
			break;
		case R.id.call_dismiss:
			this.dismiss();
			break;
		default:
			break;
		}
	}
}
