package com.dong.dongweather.json;

import android.text.TextUtils;
import android.util.Log;

import com.dong.dongweather.LogUtil;
import com.dong.dongweather.gson.HeWeather5;
import com.dong.dongweather.gson.HeWeather6;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */

public class WeatherJson {
    private static final String TAG = "WeatherJson";
    public static HeWeather5 getWeatherResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONObject jsonObject = new JSONObject(response);
                JSONArray jsonArray = jsonObject.getJSONArray("HeWeather5");
                String weateherContent = jsonArray.getJSONObject(0).toString();
                return new Gson().fromJson(weateherContent, HeWeather5.class);
            } catch (JSONException e) {
                e.printStackTrace();
                LogUtil.d(TAG, "getWeatherResponse: ");
            }
        }
        return null;
    }

    public static HeWeather6.Now getWeatherRespoonseNOW(String response)
    {
        if (!TextUtils.isEmpty(response)) {
            HeWeather6.Now now = new HeWeather6.Now();
                try {
                    JSONObject json = new JSONObject(response);
                    JSONObject nowArray=json.getJSONObject("now");
                    now.temp = nowArray.getString("temp");
                    now.text = nowArray.getString("text");
                    now.feelsLike = nowArray.getString("feelsLike");
                    now.humidity = nowArray.getString("feelsLike");
                    now.vis = nowArray.getString("vis");
                    now.windScale = nowArray.getString("windScale");
                    now.windDir = nowArray.getString("windDir");
                    now.precip = nowArray.getString("precip");
                    now.pressure = nowArray.getString("pressure");
                    System.out.println("今天溫度是:"+now.temp);
                    return now;

                } catch (JSONException e) {
                    e.printStackTrace();
                }

        }
        return null;
    }

    public static HeWeather6.Tqzs getWeatherRespoonseTQZS(String response)
    {
        if (!TextUtils.isEmpty(response)) {
            HeWeather6.Tqzs tqzs = new HeWeather6.Tqzs();
            List<HeWeather6.Tqzs.TqzsData> TqzsList=new ArrayList<HeWeather6.Tqzs.TqzsData>();

            try {
                JSONObject json = new JSONObject(response);
                tqzs.code = json.getString("code");
                tqzs.updateTime = json.getString("updateTime");
                tqzs.fxLink = json.getString("fxLink");
                JSONArray TqzsArray=json.getJSONArray("daily");
                for(int i=0;i<TqzsArray.length();i++)
                {
                    HeWeather6.Tqzs.TqzsData td=new HeWeather6.Tqzs.TqzsData();
                    JSONObject TqzsDataObj = TqzsArray.getJSONObject(i);
                    td.category= TqzsDataObj.getString("category");
                    try
                    {
                       td.text = TqzsDataObj.getString("text");
                    }
                    catch (JSONException e)
                    {
                        td.text ="该地区暂无改生活指数数据哦";
                    }
                    td.level = TqzsDataObj.getString("level");
                    td.type = TqzsDataObj.getString("type");
                    td.name = TqzsDataObj.getString("name");
                    td.date = TqzsDataObj.getString("date");
                    TqzsList.add(td);
                }
                tqzs.setDaily(TqzsList);
                return tqzs;

            } catch (JSONException e) {
                e.printStackTrace();
            }

        }
        return null;
    }

    public static HeWeather6 getWeatherResponse6(String response) {
        if (!TextUtils.isEmpty(response)) {
            HeWeather6 heWeather6=new HeWeather6();
            List<HeWeather6.DailyData> dataList=new ArrayList<HeWeather6.DailyData>();
            try {
                JSONObject json = new JSONObject(response);
                heWeather6.updateTime= json.getString("updateTime");
                heWeather6.code = json.getString("code");
                heWeather6.fxLink = json.getString("fxLink");
                JSONArray dailyArray = json.getJSONArray("daily");
                for (int i = 0; i < dailyArray.length(); i++) {
                    HeWeather6.DailyData dailyData=new HeWeather6.DailyData();
                    JSONObject dailyObj = dailyArray.getJSONObject(i);
                    dailyData.fxDate = dailyObj.getString("fxDate");
                    dailyData.textDay = dailyObj.getString("textDay");
                    dailyData.tempMax = dailyObj.getString("tempMax");
                    dailyData.tempMin = dailyObj.getString("tempMin");
                    dailyData.textNight = dailyObj.getString("textNight");
                    dailyData.moonPhase = dailyObj.getString("moonPhase");
                    dailyData.vis = dailyObj.getString("vis");
                    dailyData.precip = dailyObj.getString("precip");
                    dailyData.pressure = dailyObj.getString("pressure");

                    dataList.add(dailyData);
                    System.out.println("日期：" + dailyData.fxDate + "，白天天气：" + dailyData.textDay + "，最高温度：" + dailyData.tempMax + "，最低温度：" + dailyData.tempMin);
                }

                heWeather6.setDaily(dataList);
                return  heWeather6;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


    public static HeWeather6 getWeatherResponseBuffer(String response) {
        if (!TextUtils.isEmpty(response)) {
            HeWeather6 heWeather6=new HeWeather6();
            List<HeWeather6.DailyData> dataList=new ArrayList<HeWeather6.DailyData>();
            try {
                JSONObject json = new JSONObject(response);
                if(json.getJSONObject("now")!=null)
                {
                    heWeather6.now = new HeWeather6.Now();
                    JSONObject nowArray=json.getJSONObject("now");
                    heWeather6.now.temp = nowArray.getString("temp");
                    heWeather6.now.text = nowArray.getString("text");
                    heWeather6.now.feelsLike = nowArray.getString("feelsLike");
                    heWeather6.now.humidity = nowArray.getString("feelsLike");
                    heWeather6.now.vis = nowArray.getString("vis");
                    heWeather6.now.windScale = nowArray.getString("windScale");
                    heWeather6.now.windDir = nowArray.getString("windDir");
                    heWeather6.now.precip = nowArray.getString("precip");
                    heWeather6.now.pressure = nowArray.getString("pressure");
                }
                heWeather6.updateTime= json.getString("updateTime");
                heWeather6.code = json.getString("code");
                JSONArray dailyArray = json.getJSONArray("daily");
                for (int i = 0; i < dailyArray.length(); i++) {
                    HeWeather6.DailyData dailyData=new HeWeather6.DailyData();
                    JSONObject dailyObj = dailyArray.getJSONObject(i);
                    dailyData.fxDate = dailyObj.getString("fxDate");
                    dailyData.textDay = dailyObj.getString("textDay");
                    dailyData.tempMax = dailyObj.getString("tempMax");
                    dailyData.tempMin = dailyObj.getString("tempMin");
                    dailyData.textNight = dailyObj.getString("textNight");
                    dailyData.moonPhase = dailyObj.getString("moonPhase");
                    dailyData.vis = dailyObj.getString("vis");
                    dailyData.precip = dailyObj.getString("precip");
                    dailyData.pressure = dailyObj.getString("pressure");

                    dataList.add(dailyData);
                    System.out.println("日期：" + dailyData.fxDate + "，白天天气：" + dailyData.textDay + "，最高温度：" + dailyData.tempMax + "，最低温度：" + dailyData.tempMin);
                }

                heWeather6.setDaily(dataList);
                return  heWeather6;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static boolean isContinuousNow(String str) {
        int index = str.indexOf("now");
        while (index >= 0 && index + 3 < str.length()) {
            if (str.substring(index + 3, index + 6).equals("now")) {
                index = str.indexOf("now", index + 3);
            } else {
                break;
            }
        }
        return index >= 0;
    }

}
