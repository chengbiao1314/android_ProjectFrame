package com.chengbiao.ricky.projectframe.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chengbiao.ricky.projectframe.R;
import com.chengbiao.ricky.projectframe.base.BaseFragment;
import com.chengbiao.ricky.projectframe.utils.GetResUtil;

public class MOrderFragment extends BaseFragment {
    private Context context;
    private View view;
    private TextView tv_title;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_morder, null);
        context = getActivity();

        getElement();
        initData();
        return view;
    }

    private void getElement(){
        tv_title = (TextView) view.findViewById(R.id.tv_title);
    }

    private void initData(){
        tv_title.setText(GetResUtil.getInstance().getStringFromRes(context, R.string.main_index_order));
    }

    @Override
    public void mOnClick(View v) {

    }
}
