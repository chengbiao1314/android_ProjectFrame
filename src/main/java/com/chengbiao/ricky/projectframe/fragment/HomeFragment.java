package com.chengbiao.ricky.projectframe.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;

import com.chengbiao.ricky.projectframe.R;
import com.chengbiao.ricky.projectframe.config.ContextTitleEnum;
import com.chengbiao.ricky.projectframe.interfaces.SetTitleInterface;

public class HomeFragment extends Fragment {
    private View view;
    private SetTitleInterface mSetTitleInterface;

    private Button btn_title1;
    private Button btn_title2;
    private Button btn_title3;
    public HomeFragment(){}

    public void setSetTitleInterface(SetTitleInterface mSetTitleInterface){
        this.mSetTitleInterface = mSetTitleInterface;
    }
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home, null);

        btn_title1 = (Button) view.findViewById(R.id.btn_title1);
        btn_title2 = (Button) view.findViewById(R.id.btn_title2);
        btn_title3 = (Button) view.findViewById(R.id.btn_title3);
        btn_title1.setOnClickListener(new mOnClickListener());
        btn_title2.setOnClickListener(new mOnClickListener());
        btn_title3.setOnClickListener(new mOnClickListener());

        return view;
    }
    private class mOnClickListener implements OnClickListener {
        @Override
        public void onClick(View v) {
            mSetTitleInterface.setTitle(ContextTitleEnum.MYMOMENTS);
            switch(v.getId()){
                case R.id.btn_title1:
                    mSetTitleInterface.setTitle(ContextTitleEnum.MYMOMENTS);
                    break;
                case R.id.btn_title2:
                    mSetTitleInterface.setTitle(ContextTitleEnum.MYCENTER);
                    break;
                case R.id.btn_title3:
                    mSetTitleInterface.setTitle(ContextTitleEnum.MYORDER);
                    break;
                default:
                    break;
            }
        }
    }
}
