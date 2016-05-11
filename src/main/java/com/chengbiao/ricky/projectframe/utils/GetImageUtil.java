package com.chengbiao.ricky.projectframe.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;

import com.chengbiao.ricky.projectframe.config.StaticTag;
import com.chengbiao.ricky.projectframe.myview.MyToast;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Ricky on 16/5/1.
 */
public class GetImageUtil {
    private static GetImageUtil instance;
    private int TAG_takepicture = 0;
    private int TAG_choosepicture = 1;

    public static synchronized GetImageUtil getInstance() {
        if (instance == null) {
            instance = new GetImageUtil();
        }
        return instance;
    }

    public void takePictureByCamera(Context context){
//        Uri imageUri = null;
//        String fileName = null;
//        Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        fileName = "image.jpg";
//        imageUri = Uri.fromFile(new File(Environment.getExternalStorageDirectory(),fileName));
//        openCameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
//        ((Activity)context).startActivityForResult(openCameraIntent, TAG_takepicture);

        String state = Environment.getExternalStorageState();
        if (state.equals(Environment.MEDIA_MOUNTED)) {
            Intent getImageByCamera = new Intent("android.media.action.IMAGE_CAPTURE");
            ((Activity)context).startActivityForResult(getImageByCamera, TAG_takepicture);
        }
        else {
            MyToast.showToast(context,"please install SDcard");
        }
    }

    public void choosePictureFromSystem(Context context) {
        Intent openAlbumIntent = new Intent(Intent.ACTION_GET_CONTENT);
        openAlbumIntent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        ((Activity)context).startActivityForResult(openAlbumIntent, TAG_choosepicture);
    }

    public Bitmap beRuningInResult(Context context,int requestCode, Intent data){
        Bitmap photo = null;
        if (requestCode == TAG_takepicture) {
            Uri uri = data.getData();
            if (uri == null) {
                //use bundle to get data
                Bundle bundle = data.getExtras();
                if (bundle != null) {
                    photo = (Bitmap) bundle.get("data"); //get bitmap
                    //spath :生成图片取个名字和路径包含类型
//                            saveImage(Bitmap photo, String spath);
                } else {
                    MyToast.showToast(context, "get picture error");
                }
            } else {
                try{
                    ContentResolver resolver = context.getContentResolver();
                    photo = MediaStore.Images.Media.getBitmap(resolver, uri);
                }catch(IOException e){
                    MyToast.showToast(context, "get picture error");
                }
                //to do find the path of pic by uri
            }


//                    Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + "/image.jpg");
//                    Bitmap newBitmap = ImageTools.zoomBitmap(bitmap, bitmap.getWidth() / SCALE, bitmap.getHeight() / SCALE);
//                    bitmap.recycle();
//
//                    iv_image.setImageBitmap(newBitmap);
//                    ImageTools.savePhotoToSDCard(newBitmap, Environment.getExternalStorageDirectory().getAbsolutePath(), String.valueOf(System.currentTimeMillis()));

        }else if (requestCode == TAG_choosepicture){
            ContentResolver resolver = context.getContentResolver();
            Uri originalUri = data.getData();
            try {
                photo = MediaStore.Images.Media.getBitmap(resolver, originalUri);
//                    if (photo != null) {
//                        Bitmap smallBitmap = ImageTools.zoomBitmap(photo, photo.getWidth() / SCALE, photo.getHeight() / SCALE);
//                        photo.recycle();
//
//                        iv_image.setImageBitmap(smallBitmap);
//                    }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return photo;
    }

    public boolean saveImage(Bitmap photo, String spath) {
        try {
            BufferedOutputStream bos = new BufferedOutputStream(
                    new FileOutputStream(spath, false));
            photo.compress(Bitmap.CompressFormat.JPEG, 100, bos);
            bos.flush();
            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
