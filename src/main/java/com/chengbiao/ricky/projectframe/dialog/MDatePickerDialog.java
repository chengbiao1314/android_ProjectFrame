package com.chengbiao.ricky.projectframe.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.Toast;

import com.chengbiao.ricky.projectframe.R;

import java.util.Calendar;

public class MDatePickerDialog extends Dialog implements
		View.OnClickListener {
	// 记录当前的时间
	private int year;
	private int month;
	private int day;
	private Button dissmis_btn, ok_btn;
	private Context context;
	private Handler handler;
	private int type;
	private Calendar ca;

	public MDatePickerDialog(Context context, String title, Handler handler,
                             int type) {
		super(context);
		this.context = context;
		this.setTitle(title);
		this.handler = handler;
		this.type = type;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.dialog_datepicker);
		DatePicker date = (DatePicker) findViewById(R.id.datepicker);
		ok_btn = (Button) findViewById(R.id.ok_btn);
		dissmis_btn = (Button) findViewById(R.id.over_btn);
		ok_btn.setOnClickListener(this);
		dissmis_btn.setOnClickListener(this);
		// 或许当前的年月日，小时，分钟
		 ca = Calendar.getInstance();
		year = ca.get(Calendar.YEAR);
		month = ca.get(Calendar.MONTH);
		day = ca.get(Calendar.DAY_OF_MONTH);
		date.setCalendarViewShown(false);// 隐藏日历
		// 初始化DatePicker
		date.init(year, month, day, new OnDateChangedListener() {
			@Override
			public void onDateChanged(DatePicker arg0, int year, int month,
					int day) {
				MDatePickerDialog.this.year = year;
				MDatePickerDialog.this.month = month;
				MDatePickerDialog.this.day = day;
			}
		});
	}

	@Override
	public void onClick(View arg0) {
		switch (arg0.getId()) {
		case R.id.over_btn:
			this.dismiss();
			break;
		case R.id.ok_btn:
			if (year > ca.get(Calendar.YEAR)) {

			} else if (year == ca.get(Calendar.YEAR)) {
				if (month > ca.get(Calendar.MONTH)) {

				} else if (month == ca.get(Calendar.MONTH)) {
					if (day > ca.get(Calendar.DAY_OF_MONTH)) {

					} else if (day == ca.get(Calendar.DAY_OF_MONTH)) {

					} else {
						Toast.makeText(context, "时间不能早于当前时间",
								Toast.LENGTH_SHORT).show();
						break;
					}
				} else {
					Toast.makeText(context, "时间不能早于当前时间", Toast.LENGTH_SHORT)
							.show();
					break;
				}
			} else {
				Toast.makeText(context, "时间不能早于当前时间", Toast.LENGTH_SHORT)
						.show();
				break;
			}
			Message msg = new Message();
			Bundle bundle = new Bundle();
			bundle.putInt("year", year);
			bundle.putInt("month", month + 1);
			bundle.putInt("day", day);
			msg.setData(bundle);
			msg.what = type;
			handler.sendMessage(msg);
			this.dismiss();
			break;

		default:
			break;
		}
	}

}
