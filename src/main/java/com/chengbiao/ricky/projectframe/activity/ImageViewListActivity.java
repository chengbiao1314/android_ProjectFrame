package com.chengbiao.ricky.projectframe.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.chengbiao.ricky.projectframe.R;
import com.chengbiao.ricky.projectframe.base.BaseActivity;
import com.chengbiao.ricky.projectframe.dialog.CallPhoneDialog;
import com.chengbiao.ricky.projectframe.dialog.ConfirmTipsDialog;
import com.chengbiao.ricky.projectframe.dialog.MDatePickerDialog;
import com.chengbiao.ricky.projectframe.dialog.MLoadingDialog;
import com.chengbiao.ricky.projectframe.dialog.MTimePickerDialog;
import com.chengbiao.ricky.projectframe.myview.MyCircleImageView;
import com.chengbiao.ricky.projectframe.myview.MyToast;
import com.chengbiao.ricky.projectframe.utils.GetImageUtil;

public class ImageViewListActivity extends BaseActivity {
    private MyCircleImageView mcv_person_icon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imageviewlist);

        getElement();
        initData();
    }

    private void getElement(){
        mcv_person_icon = (MyCircleImageView) findViewById(R.id.mcv_person_icon);

        mcv_person_icon.setOnClickListener(this);
    }

    private void initData(){
        //TODO
    }

    @Override
    public void mOnClick(View v) {
        switch (v.getId()){
            case R.id.mcv_person_icon:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("选择获取图片方式");
                builder.setNegativeButton("取消", null);
                builder.setItems(new String[]{"拍照","相册"}, new DialogInterface.OnClickListener() {
                    int REQUEST_CODE;

                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                GetImageUtil.getInstance().takePictureByCamera(ImageViewListActivity.this);
                                break;
                            case 1:
                                GetImageUtil.getInstance().choosePictureFromSystem(ImageViewListActivity.this);
                                break;

                            default:
                                break;
                        }
                    }
                });
                builder.create().show();
                break;
            default:
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Bitmap pic= GetImageUtil.getInstance().beRuningInResult(this,requestCode,data);
            if(pic != null){
                mcv_person_icon.setImageBitmap(pic);
            }else{
                MyToast.showToast(this,"picture is null");
            }
        }else{
            MyToast.showToast(this,"error...");
        }
    }
}
