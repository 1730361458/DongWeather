package com.dong.dongweather.gson;

import java.util.List;

public class HeWeather6 {
    public String code;
    public String updateTime;
    public String fxLink;
    public String cityName;

    public Now now;
    public Tqzs tqzs;
    public List<DailyData> daily;
    public Refer refer;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public String getFxLink() {
        return fxLink;
    }

    public void setFxLink(String fxLink) {
        this.fxLink = fxLink;
    }

    public List<DailyData> getDaily() {
        return daily;
    }

    public void setDaily(List<DailyData> daily) {
        this.daily = daily;
    }

    public void setNow(Now now)
    {
        this.now=now;
    }


    public static class Now {
        public String obsTime;
        public String temp;
        public String feelsLike;
        public String icon;
        public String text;
        public String wind360;
        public String windDir;
        public String windScale;
        public String windSpeed;
        public String humidity;
        public String precip;
        public String pressure;
        public String vis;
        public String cloud;
        public String dew;
    }

    public static class Tqzs {
        public String code;
        public String updateTime;
        public String fxLink;
        public List<TqzsData> daily;

        public List<TqzsData> getDaily() {
            return daily;
        }

        public void setDaily(List<TqzsData> daily) {
            this.daily = daily;
        }

        public static class TqzsData
        {
            public String date;
            public String type;
            public String name;
            public String level;
            public String category;
            public String text;
        }


    }

    public static class DailyData {
        public String fxDate;
        public String sunrise;
        public String sunset;
        public String moonrise;
        public String moonset;
        public String moonPhase;
        public String moonPhaseIcon;
        public String tempMax;
        public String tempMin;
        public String iconDay;
        public String textDay;
        public String iconNight;
        public String textNight;
        public String wind360Day;
        public String windDirDay;
        public String windScaleDay;
        public String windSpeedDay;
        public String wind360Night;
        public String windDirNight;
        public String windScaleNight;
        public String windSpeedNight;
        public String humidity;
        public String precip;
        public String pressure;
        public String vis;
        public String cloud;
        public String uvIndex;

        public String getFxDate() {
            return fxDate;
        }

        public void setFxDate(String fxDate) {
            this.fxDate = fxDate;
        }

        public String getSunrise() {
            return sunrise;
        }

        public void setSunrise(String sunrise) {
            this.sunrise = sunrise;
        }

        public String getSunset() {
            return sunset;
        }

        public void setSunset(String sunset) {
            this.sunset = sunset;
        }

        public String getMoonrise() {
            return moonrise;
        }

        public void setMoonrise(String moonrise) {
            this.moonrise = moonrise;
        }

        public String getMoonset() {
            return moonset;
        }

        public void setMoonset(String moonset) {
            this.moonset = moonset;
        }

        public String getMoonPhase() {
            return moonPhase;
        }

        public void setMoonPhase(String moonPhase) {
            this.moonPhase = moonPhase;
        }

        public String getMoonPhaseIcon() {
            return moonPhaseIcon;
        }

        public void setMoonPhaseIcon(String moonPhaseIcon) {
            this.moonPhaseIcon = moonPhaseIcon;
        }

        public String getTempMax() {
            return tempMax;
        }

        public void setTempMax(String tempMax) {
            this.tempMax = tempMax;
        }

        public String getTempMin() {
            return tempMin;
        }

        public void setTempMin(String tempMin) {
            this.tempMin = tempMin;
        }

        public String getIconDay() {
            return iconDay;
        }

        public void setIconDay(String iconDay) {
            this.iconDay = iconDay;
        }
    }

    public static class Refer
    {
        public List<String> sources;
        public List<String> license;
        public List<String> getSources() {
            return sources;
        }

        public void setSources(List<String> sources) {
            this.sources = sources;
        }

        public List<String> getLicense() {
            return license;
        }

        public void setLicense(List<String> license) {
            this.license = license;
        }
    }

}


