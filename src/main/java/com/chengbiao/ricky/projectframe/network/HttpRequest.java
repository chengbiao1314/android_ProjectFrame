package com.chengbiao.ricky.projectframe.network;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.chengbiao.ricky.projectframe.utils.LogUtil;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Ricky on 16/5/1.
 */
public class HttpRequest extends Thread {
    private String url = "";
    private JSONObject jsonObject = null;
    private Handler handler = null;

    public HttpRequest(String url,JSONObject jsonobject,Handler handler){
        this.url = url;
        this.jsonObject = RequestJSONObjectFormat.getInstance().getRequestJSONObject(jsonobject);
        this.handler = handler;
    }

    public String postRequestString(String stringURL,JSONObject stringJsonObject)
            throws Exception {
        String stringResponse = "";

        OutputStream outputStream = null;
        InputStream inputStream = null;
        HttpURLConnection httpUrlConnection = null;
        try{
            URL url = new URL(stringURL);
            httpUrlConnection = (HttpURLConnection) url.openConnection();
            httpUrlConnection.setRequestMethod("POST");
            httpUrlConnection.setDoInput(true);
            httpUrlConnection.setDoOutput(true);
            httpUrlConnection.setUseCaches(false);
            httpUrlConnection.setConnectTimeout(10 * 1000);
            httpUrlConnection.setReadTimeout(10 * 1000);
            httpUrlConnection.setRequestProperty("Charset", "UTF-8");
            httpUrlConnection.setRequestProperty("Connection", "Keep-Alive");
            httpUrlConnection.setRequestProperty("User-Agent","project+VersionName");

            //request...
            if (stringJsonObject != null) {
                outputStream = httpUrlConnection.getOutputStream();
                outputStream.write(stringJsonObject.toString().getBytes());
                outputStream.flush();
            }

            LogUtil.v("url:"+ stringURL);
            LogUtil.v("requestBody:"+ stringJsonObject.toString());

            //response...
            int responseCode = httpUrlConnection.getResponseCode();
            if(HttpURLConnection.HTTP_OK == responseCode){
                inputStream = httpUrlConnection.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                StringBuilder buffer = new StringBuilder();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }
                stringResponse = buffer.toString();
                reader.close();
                LogUtil.v("requestBody:"+ stringResponse);
                return stringResponse;
            }else{
                LogUtil.v("request error..1");
                throw new Exception("server error"+"("+responseCode+")");
            }
        }catch(Exception e){
            LogUtil.v("request error..2");
            return "request error...";

        }finally {
            if (outputStream != null) {
                outputStream.close();
                outputStream = null;
            }

            if (inputStream != null) {
                inputStream.close();
                inputStream = null;
            }

            if (httpUrlConnection != null) {
                httpUrlConnection.disconnect();
                httpUrlConnection = null;
            }
        }
    }

    public void run() {
        Message message = new Message();
        Bundle bundle = new Bundle();
        bundle.putBoolean("STATUS", false);
        String tmp = "service error!";
        try {
            tmp=postRequestString(url,jsonObject);
            bundle.putString("RES",tmp);
            bundle.putBoolean("STATUS",true);
        } catch (Exception e) {
            bundle.putString("ERRORMSG", e.getMessage());
        }
        message.setData(bundle);
        if(handler!=null){
            handler.sendMessage(message);
        }else{
            LogUtil.v(url + "  :  handler is null");
        }
    }
}
