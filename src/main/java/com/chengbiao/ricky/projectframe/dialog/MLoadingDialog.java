package com.chengbiao.ricky.projectframe.dialog;

import android.app.Dialog;
import android.content.Context;
import android.view.View;
import android.widget.TextView;

import com.chengbiao.ricky.projectframe.R;

public class MLoadingDialog extends Dialog{

	public MLoadingDialog(Context context, int theme, String message) {
		super(context,theme);
		View view = View.inflate(context, R.layout.dialog_loading, null);
		setContentView(view);
		TextView msg = (TextView) view.findViewById(R.id.message);
		msg.setText(message);
		this.setCancelable(true);
		this.setCanceledOnTouchOutside(false);
	}
}
