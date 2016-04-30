package com.chengbiao.ricky.projectframe.myview;

import android.content.Context;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chengbiao.ricky.projectframe.R;

public class MyToast{

	private static Toast toast;

	public static void showToast(Context context, String toaststr) {
		View myToast = View.inflate(context, R.layout.toast_myself, null);
		
		if(toast == null){
			toast = Toast.makeText(context, "", Toast.LENGTH_SHORT);
		}

		toast.setView(myToast);
	    TextView tv=(TextView)myToast.findViewById(R.id.tv_toast_text);
	    tv.setText(toaststr);
//	    toast.setGravity(Gravity.CENTER_HORIZONTAL, 0, 0);
		toast.show();
	}

}
