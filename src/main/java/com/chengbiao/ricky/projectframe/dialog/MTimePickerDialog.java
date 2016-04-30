package com.chengbiao.ricky.projectframe.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;

import com.chengbiao.ricky.projectframe.R;

/**
 * 
 * 选择时间
 * 
 * @author Administrator
 * 
 */
public class MTimePickerDialog extends Dialog implements
		View.OnClickListener {
	private int starttime;
	private int endtime;
	private Button dissmis_btn, ok_btn;
	private Context context;
	private Handler handler;

	public MTimePickerDialog(Context context, String title, Handler handler) {
		super(context);
		// TODO Auto-generated constructor stub
		this.context = context;
		this.setTitle(title);
		this.handler = handler;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_timepicker);
		NumberPicker Picker_start = (NumberPicker) findViewById(R.id.timepicker_start);
		NumberPicker Picker_end = (NumberPicker) findViewById(R.id.timepicker_end);
		ok_btn = (Button) findViewById(R.id.picker_ok_btn);
		dissmis_btn = (Button) findViewById(R.id.picker_over_btn);
		ok_btn.setOnClickListener(this);
		dissmis_btn.setOnClickListener(this);
		// numberpicker相关设置
		Picker_start.setMinValue(0);
		Picker_start.setMaxValue(23);
		Picker_start
				.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
		Picker_end.setMinValue(0);
		Picker_end.setMaxValue(23);
		Picker_end
				.setDescendantFocusability(NumberPicker.FOCUS_BLOCK_DESCENDANTS);
		// 监听
		Picker_start.setOnValueChangedListener(new OnValueChangeListener() {

			@Override
			public void onValueChange(NumberPicker picker, int oldVal,
					int newVal) {
				// TODO Auto-generated method stub
				starttime = newVal;
			}
		});
		Picker_end.setOnValueChangedListener(new OnValueChangeListener() {

			@Override
			public void onValueChange(NumberPicker picker, int oldVal,
					int newVal) {
				// TODO Auto-generated method stub
				endtime = newVal;
			}
		});
	}

	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub
		switch (arg0.getId()) {
		case R.id.picker_over_btn:
			this.dismiss();
			break;
		case R.id.picker_ok_btn:
			Message msg = new Message();
			Bundle bundle = new Bundle();
			bundle.putInt("starttime", starttime);
			bundle.putInt("endtime", endtime);
			msg.setData(bundle);
			msg.what = 1;
			handler.sendMessage(msg);
			this.dismiss();
			break;

		default:
			break;
		}
	}

}
