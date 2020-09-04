package com.example.weatherapp.model.requestResponses.currentWeather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CurrentWeatherRequestResponse {
    @SerializedName("data")
    @Expose
    private List<CurrentWeatherInformation> data;

    public CurrentWeatherRequestResponse(List<CurrentWeatherInformation> data) {
        this.data = data;
    }

    public List<CurrentWeatherInformation> getData() {
        return data;
    }

    public void setData(List<CurrentWeatherInformation> data) {
        this.data = data;
    }
}
