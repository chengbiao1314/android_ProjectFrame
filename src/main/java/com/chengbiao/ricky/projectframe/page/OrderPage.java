package com.chengbiao.ricky.projectframe.page;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.chengbiao.ricky.projectframe.MainActivityCanSliding;
import com.chengbiao.ricky.projectframe.R;
import com.chengbiao.ricky.projectframe.adapter.MyPageAdapter;
import com.chengbiao.ricky.projectframe.base.BasePage;
import com.chengbiao.ricky.projectframe.config.StaticTag;
import com.chengbiao.ricky.projectframe.utils.ToastUtil;

import java.util.ArrayList;
import java.util.List;

public class OrderPage extends BasePage {
    private MOnClickListener mOnClickListener;
    private ViewPager vp_content;
    private List<BasePage> pageList;
    private HomePage homePage;
    private MomentsPage momentsPage;
    private OrderPage orderPage;
    private CenterPage centerPage;

    private View view1, view2, view3;
    private List<View> viewList;//view数组

	public OrderPage(Context context) {
		super(context);
	}

    @Override
    public View initView() {
        return View.inflate(context,R.layout.page_order, null);
    }

    @Override
    public void initData() {
//        mOnClickListener = super.mOnClickListener;

//        Button btn = (Button) rootview.findViewById(R.id.btn_1);
//        btn.setOnClickListener(mOnClickListener);

        vp_content = (ViewPager) rootview.findViewById(R.id.vp_content1_order_pager);

//        if(pageList == null){
//            pageList = new ArrayList<BasePage>();
//        }
//        homePage = new HomePage(context);
//        momentsPage = new MomentsPage(context);
//        orderPage = new OrderPage(context);
//        centerPage = new CenterPage(context);
//
//        pageList.clear();
//        pageList.add(homePage);
//        pageList.add(momentsPage);
//        pageList.add(orderPage);
//        pageList.add(centerPage);

//        vp_content.setAdapter(new MyPageAdapter(pageList));


        //temp....
        view1 = View.inflate(context,R.layout.page_center, null);
        view2 = View.inflate(context,R.layout.page_home,null);
        view3 = View.inflate(context,R.layout.page_moments, null);

        viewList = new ArrayList<View>();// 将要分页显示的View装入数组中
        viewList.add(view1);
        viewList.add(view2);
        viewList.add(view3);
        PagerAdapter pagerAdapter = new PagerAdapter() {

            @Override
            public boolean isViewFromObject(View arg0, Object arg1) {
                // TODO Auto-generated method stub
                return arg0 == arg1;
            }

            @Override
            public int getCount() {
                // TODO Auto-generated method stub
                return viewList.size();
            }

            @Override
            public void destroyItem(ViewGroup container, int position,
                                    Object object) {
                // TODO Auto-generated method stub
                container.removeView(viewList.get(position));
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                // TODO Auto-generated method stub
                container.addView(viewList.get(position));


                return viewList.get(position);
            }
        };

        vp_content.setAdapter(pagerAdapter);
        MainActivityCanSliding.sm.addIgnoredView(vp_content);
    }

    @Override
    public void mOnClick(View v) {
        switch (v.getId()){
//            case R.id.btn_1:
//                ToastUtil.showToast(context, "running...");
//                break;
            default:
                break;
        }
    }

}