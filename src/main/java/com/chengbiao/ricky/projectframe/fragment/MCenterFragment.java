package com.chengbiao.ricky.projectframe.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.chengbiao.ricky.projectframe.R;
import com.chengbiao.ricky.projectframe.activity.DialogListActivity;
import com.chengbiao.ricky.projectframe.base.BaseFragment;
import com.chengbiao.ricky.projectframe.utils.ActivityUtil;

public class MCenterFragment extends BaseFragment {
    private View view;
    private Context context;

    private Button btn_mydialog;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mcenter, null);
        context = getActivity();

        getElement();

        return view;
    }

    @Override
    public void mOnClick(View v) {
        switch (v.getId()){
            case R.id.btn_mydialog:
                ActivityUtil.getInstance().startActivity(context, DialogListActivity.class,false);
                break;
            default:
                break;
        }
    }

    private void getElement() {
        btn_mydialog = (Button) view.findViewById(R.id.btn_mydialog);

        btn_mydialog.setOnClickListener(mOnClickListener);
    }
}
