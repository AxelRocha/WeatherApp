package com.example.weatherapp.model.requestResponses.forecastWeather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ForecastWeatherDescription{
    @SerializedName("description")
    @Expose
    private String description;

    public ForecastWeatherDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}