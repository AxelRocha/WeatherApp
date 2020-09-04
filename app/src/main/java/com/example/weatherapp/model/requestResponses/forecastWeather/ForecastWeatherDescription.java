package com.example.weatherapp.model.requestResponses.forecastWeather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForecastWeatherDescription{
    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("code")
    @Expose
    private String weatherCode;

    public ForecastWeatherDescription(String description, String weatherCode) {
        this.description = description;
        this.weatherCode = weatherCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(String weatherCode) {
        this.weatherCode = weatherCode;
    }
}