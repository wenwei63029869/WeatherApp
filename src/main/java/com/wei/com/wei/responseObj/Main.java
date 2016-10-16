package com.wei.com.wei.responseObj;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by weiwen on 10/15/16.
 */
public class Main {
    private String temp;
    private String humidity;
    private String pressure;
    @JsonProperty("temp_min")
    private String tempMin;
    @JsonProperty("temp_max")
    private String tempMax;

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }

    public String getPressure() {
        return pressure;
    }

    public void setPressure(String pressure) {
        this.pressure = pressure;
    }

    public String getTempMin() {
        return tempMin;
    }

    public void setTempMin(String tempMin) {
        this.tempMin = tempMin;
    }

    public String getTempMax() {
        return tempMax;
    }

    public void setTempMax(String tempMax) {
        this.tempMax = tempMax;
    }
}
