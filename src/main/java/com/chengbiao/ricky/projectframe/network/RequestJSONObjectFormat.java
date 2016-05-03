package com.chengbiao.ricky.projectframe.network;

import org.json.JSONObject;

/**
 * Created by Ricky on 16/5/1.
 */
public class RequestJSONObjectFormat {
    private static RequestJSONObjectFormat instance;

    public static synchronized RequestJSONObjectFormat getInstance() {
        if (instance == null) {
            instance = new RequestJSONObjectFormat();
        }
        return instance;
    }

    public JSONObject getRequestJSONObject(JSONObject jsonobject){
        return jsonobject;
    }
}
