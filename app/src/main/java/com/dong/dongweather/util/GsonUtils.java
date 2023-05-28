package com.dong.dongweather.util;

import android.util.Log;

import com.google.gson.ExclusionStrategy;
import com.google.gson.FieldAttributes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.json.JSONArray;
import org.json.JSONObject;

public class GsonUtils {
    private static final String TAG = "GsonUtils";
    private static Gson mGson;

    static {
        LogUtils.d(TAG + "lpq", "static initializer: ");
        mGson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .setExclusionStrategies(new ExclusionStrategy() {
                    @Override
                    public boolean shouldSkipField(FieldAttributes f) {
                        return f.getName().equals("baseObjId");
                    }

                    @Override
                    public boolean shouldSkipClass(Class<?> clazz) {
                        return false;
                    }
                })
                .create();
    }

    public static String toJson(Object object) {
        if (object == null) {
            return "";
        }
        return mGson.toJson(object);
    }

    public static <T> T fromJson(String json, Class<T> cls){
        return mGson.fromJson(json, cls);
    }


    public static String parseJSONWithJSONObject(String jsonData) {
        try {
            // JSONArray jsonArray = new JSONArray(jsonData);

            JSONArray jsonArray = new JSONObject(jsonData).getJSONArray("images");

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String url = jsonObject.getString("url");

                String url1="http://cn.bing.com"+url;
                return url1;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
