package com.example.weatherapp.model.requestResponses.currentWeather;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentWeatherDescription{
    @SerializedName("description")
    @Expose
    private String description;

    public CurrentWeatherDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
