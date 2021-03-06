package com.chengbiao.ricky.projectframe.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.chengbiao.ricky.projectframe.R;
import com.chengbiao.ricky.projectframe.activity.DialogListActivity;
import com.chengbiao.ricky.projectframe.activity.ImageViewListActivity;
import com.chengbiao.ricky.projectframe.base.BaseFragment;
import com.chengbiao.ricky.projectframe.utils.ActivityUtil;
import com.chengbiao.ricky.projectframe.utils.GetResUtil;

public class MCenterFragment extends BaseFragment {
    private View view;
    private Context context;
    private TextView tv_title;

    private Button btn_mydialog;
    private Button btn_myimageview;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mcenter, null);
        context = getActivity();

        getElement();
        initData();
        return view;
    }

    @Override
    public void mOnClick(View v) {
        switch (v.getId()){
            case R.id.btn_mydialog:
                ActivityUtil.getInstance().startActivity(context, DialogListActivity.class,false);
                break;
            case R.id.btn_myimageview:
                ActivityUtil.getInstance().startActivity(context, ImageViewListActivity.class,false);
                break;
            default:
                break;
        }
    }

    private void getElement() {
        tv_title = (TextView) view.findViewById(R.id.tv_title);
        btn_mydialog = (Button) view.findViewById(R.id.btn_mydialog);
        btn_myimageview = (Button) view.findViewById(R.id.btn_myimageview);

        btn_mydialog.setOnClickListener(mOnClickListener);
        btn_myimageview.setOnClickListener(mOnClickListener);
    }

    private void initData(){
        tv_title.setText(GetResUtil.getInstance().getStringFromRes(context, R.string.main_index_center));
    }
}
