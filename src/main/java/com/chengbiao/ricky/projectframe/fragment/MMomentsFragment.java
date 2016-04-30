package com.chengbiao.ricky.projectframe.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chengbiao.ricky.projectframe.R;

public class MMomentsFragment extends Fragment {
    private View view;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mmoments, null);

        return view;
    }

}
